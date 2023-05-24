package idw.model.rn.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.injet.Ijalertas;
import idw.model.pojos.injet.Ijcnsmaqop;
import idw.model.pojos.injet.Ijcnsmaqopdetref;
import idw.model.pojos.injet.Ijcnsturno;
import idw.model.pojos.injet.IjcnsturnoId;
import idw.model.pojos.injet.Ijcnsturnodetref;
import idw.model.pojos.injet.Ijconger;
import idw.model.pojos.injet.Ijfictec;
import idw.model.pojos.injet.Ijgrpdetinj;
import idw.model.pojos.injet.Ijgrpinj;
import idw.model.pojos.injet.Ijindiceselabels;
import idw.model.pojos.injet.Ijmatrizsetup;
import idw.model.pojos.injet.Ijmolpro;
import idw.model.pojos.injet.Ijop;
import idw.model.pojos.injet.Ijreacic;
import idw.model.pojos.injet.Ijreapar;
import idw.model.pojos.injet.Ijrearef;
import idw.model.pojos.injet.Ijtbboardmach;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.IjtbinjTemplate;
import idw.model.pojos.injet.Ijtbmol;
import idw.model.pojos.injet.Ijtbpar;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.dto.AlertaInjetDTO;
import idw.model.rn.injet.dto.CavidadePesoInjetDTO;
import idw.model.rn.injet.dto.CicloInjetDTO;
import idw.model.rn.injet.dto.DadosParaECPonderadaInjetDTO;
import idw.model.rn.injet.dto.EficienciaCicloInjetDTO;
import idw.model.rn.injet.dto.FiltroMaquinaInjetDTO;
import idw.model.rn.injet.dto.MaquinaInjetDTO;
import idw.model.rn.injet.dto.MaquinaPlanejamentoInjetDTO;
import idw.model.rn.injet.dto.MaquinaTotalInjetDTO;
import idw.model.rn.injet.dto.MaquinasInjetDTO;
import idw.model.rn.injet.dto.ParadaInjetDTO;
import idw.model.rn.injet.dto.RefugoInjetDTO;
import idw.model.rn.injet.dto.RefugoTempoInjetDTO;
import idw.model.rn.injet.dto.TrocaOPInjetDTO;
import idw.util.FormulasInjet;
import injetws.model.excessoes.RegistroDesconhecidoException;


public class MaquinaInjetRN extends AbstractRN<DAOGenericoInjet> {

	public MaquinaInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}
	
	/**
	 * Lista as m�quinas ativas
	 * <pre>
	 * 	Filtro usado:
	 * 	cdinjetora <> '999999' and stinjetora = '0'
	 * </pre>
	 * @return
	 */
	public List<Ijtbinj> listaMaquinasAtivas(){

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbinj ijtbinj ");
		q.appendWhere(MapQuery._NULL, "ijtbinj.cdinjetora <> :cdinjetora",true);
		q.appendWhere(MapQuery._AND, "ijtbinj.stinjetora=:ativo", true);
		q.defineParametro("cdinjetora", FuncoesApoioInjet.CODIGO_DEFAULT_6_DIGITOS);
		q.defineParametro("ativo",0);
		return q.list();
	}

	/**
	 * Monta lista de c�digos de mestre
	 * @param listaMaquinas
	 * @return
	 */
	public Set<String> listaCdMestres(List<Ijtbinj> listaMaquinas){
		Set<String> listaCdsMestre = new HashSet<String>();
		for(Ijtbinj ijtbinj: listaMaquinas){
			listaCdsMestre.add(ijtbinj.getCdmestre());
		}
		return listaCdsMestre;
	}
	
	public List<Ijtbinj> listaMaquinasAtivasLicenciadas(){
		List<Ijtbinj> listaRetorno = new ArrayList<Ijtbinj>();

		List<Ijtbinj> listaMaquinasAtivas = this.listaMaquinasAtivas();

		// Pega apenas as m�quinas com licen�a
		for(Ijtbinj ijtbinj: listaMaquinasAtivas){
			if(this.isIjtbinjLicenciada(ijtbinj)){
				listaRetorno.add(ijtbinj);
			}
		}

		return listaRetorno;
	}

	private boolean isIjtbinjLicenciada(Ijtbinj ijtbinj){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbboardmach ijtb where ijtb.id.campo01 in (300, 301) and ijtb.id.campo07 = :cd "); // 300 - coleta automatica 301-coleta discreta
		q.defineParametro("cd", ijtbinj.getCdinjetora());
		q.setMaxResults(1);
		Ijtbboardmach ijtbboardmach = (Ijtbboardmach) q.uniqueResult();
		if (ijtbboardmach != null) {
			if (ijtbboardmach.getId().getCampo01() == 300d) {
				// coleta automatica
				ijtbinj.mudaTpLicenca(IjtbinjTemplate.TiposColeta.COLETA_AUTOMATICA.getTpColeta());
			}
			if (ijtbboardmach.getId().getCampo01() == 301d) {
				// coleta discreta
				ijtbinj.mudaTpLicenca(IjtbinjTemplate.TiposColeta.COLETA_DISCRETA.getTpColeta());
			}
		}
		return (ijtbboardmach == null ? false : true);
	}

	public List<Ijtbinj> pesquisarListaMaquinas(String ordem){
		// Obtem lista ijcnsturno do filtro
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select distinct ijtbinj ");
		q.append("from Ijtbinj ijtbinj ");
		q.append("left join fetch ijtbinj.ijtbpar ijtbpar ");
		q.append("left join fetch ijtbpar.ijareres ijareres ");
		q.append("order by " + ordem);

		List<Ijtbinj> lista = null;
		lista = q.list();
		return lista;
	}
	
	public Ijtbinj pesquisarIjtbinj(String cdMaquina){
		Ijtbinj retorno = null;
		String HQL = "";

		HQL += "from Ijtbinj ijtbinj ";
		HQL += "left join fetch ijtbinj.ijtbpar ijtbpar ";
		HQL += "where ijtbinj.cdinjetora = '::cdmaquina' ";

		HQL = HQL.replaceAll("::cdmaquina", cdMaquina);

		List<Ijtbinj> listIjtbinj = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			listIjtbinj = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		if (listIjtbinj.size() > 0){
			retorno = listIjtbinj.get(0);
		}
		return retorno;
	}
	public Ijtbinj pesquisarIjtbinjByCdInjEstendido(String cdMaquina){
		Ijtbinj retorno = null;
		String HQL = "";

		HQL += "from Ijtbinj ijtbinj ";
		HQL += "left join fetch ijtbinj.ijtbpar ijtbpar ";
		HQL += "where ijtbinj.cdinjestendido = '::cdmaquina' ";

		HQL = HQL.replaceAll("::cdmaquina", cdMaquina);

		List<Ijtbinj> listIjtbinj = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			listIjtbinj = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		if (listIjtbinj.size() > 0){
			retorno = listIjtbinj.get(0);
		}
		return retorno;
	}

	public List<Ijgrpinj> pesquisarListaIjgrpinj(Ijtbinj ijtbinj){
		String hql = "";

		hql += "select ijgrpinj ";
		hql += "from Ijgrpinj ijgrpinj ";
		hql += "join ijgrpinj.ijgrpdetinjs ijgrpdetinj ";
		hql += "where ijgrpdetinj.id.cdinjetora = '::cdinjetora' ";

		hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());

		List<Ijgrpinj> listIjgrpinj = null;

		Query q = null;

		try{
			q = getDaoSession().createQuery(hql);
		} catch (Exception e){
			e.printStackTrace();
		}

		try{
			listIjgrpinj = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		return listIjgrpinj;
	}

	public List<Ijmolpro> pesquisarIjmolpro(FiltroMaquinaInjetDTO filtro) throws RegistroDesconhecidoException{
		String hql = "";

		if (
				(filtro.getCdProduto() == null || filtro.getCdProduto().equals("")) ||
				(filtro.getNrop() == null || filtro.getNrop().equals(""))
		){

			throw new RegistroDesconhecidoException();
		}

		hql += "from Ijmolpro ijmolpro ";
		hql += "where exists (from Ijopprodutos B where B.id.nrop = '::nrop' and ";
		hql += "B.id.cdmolde = ijmolpro.id.cdmolde and B.id.cdestrutura = ijmolpro.id.cdestrutura) ";
		hql += "and ijmolpro.id.cdproduto = '::cdproduto' ";

		hql = hql.replaceAll("::cdproduto", filtro.getCdProduto());
		hql = hql.replaceAll("::nrop", filtro.getNrop());

		Query q = getDaoSession().createQuery(hql);

		List<Ijmolpro> lista = null;

		lista = q.list();

		return lista;
	}

	public Ijfictec pesquisarIjfictecAPartirDeIjcnsturno(Ijcnsturno ijcnsturno){
		Criterion[] listaCriterion = {
				Expression.eq("id.cdinjetora", ijcnsturno.getId().getCdinjetora()),
				Expression.eq("id.cdmolde", ijcnsturno.getId().getCdmolde()),
				Expression.eq("id.cdestrutura", ijcnsturno.getId().getCdestrutura()),
				Expression.eq("id.dthrivalcic", ijcnsturno.getId().getDthrivalcic())
		};

		List<Ijfictec> listaIjfictec = getDao().findByCriteria(Ijfictec.class, listaCriterion);

		return listaIjfictec.get(0);
	}

	public Ijfictec pesquisarIjfictec(String cdinjetora, String cdmolde, String cdestrutura) throws RegistroDesconhecidoException{
		Criterion[] listaCriterion = {
				Expression.eq("id.cdinjetora", cdinjetora),
				Expression.eq("id.cdmolde", cdmolde),
				Expression.eq("id.cdestrutura", cdestrutura),
				Expression.isNull("dthrfvalcic")
		};
		List<Ijfictec> listaIjfictec = getDao().findByCriteria(Ijfictec.class, listaCriterion);

		if (listaIjfictec.size() == 0)
			throw new RegistroDesconhecidoException();

		return listaIjfictec.get(0);
	}

	private String pesquisarIjentsaiopmaq(Ijreapar ijreapar){
		String retorno = "";

		String hql = "";

		hql += "select ijentsaiopmaq.id.nrop from IjentsaiOpmaq ijentsaiopmaq ";
		hql += "where ijentsaiopmaq.id.cdinjetora = '::cdinjetora' ";
		hql += "and ijentsaiopmaq.id.dtHrEntrada >= :data ";
		hql += "order by ijentsaiopmaq.id.dtHrEntrada ";

		hql = hql.replaceAll("::cdinjetora", ijreapar.getId().getCdinjetora());

		Query q = getDaoSession().createQuery(hql);
		q.setTimestamp("data", ijreapar.getId().getDthriparada());

		List<String> listaIjentsaiOpmaq = null;

		listaIjentsaiOpmaq = q.list();

		if (listaIjentsaiOpmaq.size() > 0){
			retorno = (String) listaIjentsaiOpmaq.get(0);
		}
		return retorno;
	}
	
	public static void main(String args[]) {
		/*
		MaquinaInjetRN rn = new MaquinaInjetRN();
		FiltroMaquinaInjetDTO filtro = new FiltroMaquinaInjetDTO();
		filtro.setData(data);
		filtro.setCdMaquina(cdMaquina);
		filtro.setCdTurno(cdTurno);
		
		MaquinaInjetDTO dto = rn.analisarMaquina(filtro);
		
		dto.getMaquinaTotalDTO().getTempoProdutivasSegundos();
		dto.getMaquinaTotalDTO().getTempoAtivoSegundos();
		dto.getMaquinaTotalDTO().getTempoTotalSegundos();
		dto.getMaquinaTotalDTO().getTempoCicloProdutivoSegundos();
		dto.getMaquinaTotalDTO().getCicloPadrao();
		dto.getMaquinaTotalDTO().getQtInjNormal();
		dto.getMaquinaTotalDTO().getProducaoRefugadaUnidade();
		dto.getMaquinaTotalDTO().getProducaoBrutaUnidade();
		*/
	}
	public MaquinasInjetDTO analisarMaquinas(FiltroMaquinaInjetDTO filtro) throws RegistroDesconhecidoException {
		
		// Obter todas as ops no periodo para filtrar por op
		List<Ijcnsturno> lista = pesquisarIjcnsturno(filtro);
		List<String> listaOps = new ArrayList<String>();
		for (Ijcnsturno ij : lista) {
			if (listaOps.contains(ij.getIjop().getNrop()) == false) {
				listaOps.add(ij.getIjop().getNrop());
			}
		}
		
		MaquinasInjetDTO retorno = new MaquinasInjetDTO();
		
		for (String op : listaOps) {
			filtro.setNrop(op);
			MaquinaInjetDTO dto = analisarMaquina(filtro);
			retorno.getMaquinas().add(dto);
		}
		
		return retorno;
	}

	private List<Ijcnsturno> pesquisarIjcnsturno(FiltroMaquinaInjetDTO filtro) {
		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "select distinct ijcnsturno ";
		HQL += "from Ijcnsturno ijcnsturno ";
		HQL += "join fetch ijcnsturno.ijfictec ijfictec ";
		HQL += "join fetch ijcnsturno.ijmolpros ijmolpro ";
		HQL += "join fetch ijmolpro.ijtbpro ijtbpro ";
		HQL += "left join fetch ijcnsturno.ijcnsturnodetrefs ijcnsturnodetref ";
		HQL += "where  ";
		HQL += "ijcnsturno.id.cdinjetora = '::cdmaquina' ";

		if (filtro.getData() != null){
			HQL += "and ijcnsturno.id.dtturno between :data and :dtfinal ";
		}

		if (filtro.getCdTurno() != null && !filtro.getCdTurno().equals("")){
			HQL += "and ijcnsturno.id.cdturno = '::cdturno' ";
			HQL = HQL.replaceAll("::cdturno", filtro.getCdTurno());
		}

		if (filtro.getNrop() != null && !filtro.getNrop().equals("")){
			HQL += "and ijcnsturno.id.nrop = '::nrop' ";
			HQL = HQL.replaceAll("::nrop", filtro.getNrop());
		}

		if (filtro.isConsiderarMolde()){
			HQL += "and ijcnsturno.id.cdmolde = '::cdmode' ";
			HQL = HQL.replaceAll("::cdmolde", filtro.getCdMolde());
		} else if (filtro.isConsiderarMoldeGrupo() ){
			HQL += "and exists (from Ijgrpdetmol ijgrpdetmol where ijgrpdetmol.cdgrpmol = '::cdmoldegrupo' and ijgrpdetmol.cdmolde = ijcnsturno.id.cdmolde) ";
			HQL = HQL.replaceAll("::cdmoldegrupo", filtro.getCdMoldeGrupo());
		}

		if (filtro.isConsiderarProduto()){
			HQL += "and exists (from Ijmolpro ijmolpro where ijmolpro.id.cdproduto = '::cdproduto' and ijmolpro.id.cdmolde = ijcnsturno.id.cdmolde and ijmolpro.id.cdestrutura = ijcnsturno.id.cdestrutura and ijmolpro.id.dthrival = ijcnsturno.id.dthrivalestru ) ";
			HQL = HQL.replaceAll("::cdproduto", filtro.getCdProduto());
		}

		HQL += "order by ijcnsturno.id.cdmolde, ijcnsturno.id.cdestrutura";

		HQL = HQL.replaceAll("::cdmaquina", filtro.getCdMaquina());

		List<Ijcnsturno> listIjcnsturno = new ArrayList<Ijcnsturno>();
		Query q = null;

		try{
			q = getDaoSession().createQuery(HQL);
		} catch (Exception e){
			e.printStackTrace();
		}

		if (filtro.getData() != null){
			q.setDate("data", filtro.getData());
			q.setDate("dtfinal", filtro.getDtFinal());
			System.out.println("data=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(filtro.getData()) + " dtfinal=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(filtro.getDtFinal()));
		}

		System.out.println(HQL);
		try{
			
			listIjcnsturno = q.list();
			
		} catch (Exception e){
			e.printStackTrace();
		}

		return listIjcnsturno;
	}
	
	
	public MaquinaInjetDTO analisarMaquina(FiltroMaquinaInjetDTO filtro) throws RegistroDesconhecidoException {
		// Marcos Sardinha: 2015-06-24
		Boolean isTempoReal = false;
		
		MaquinaInjetDTO retorno = new MaquinaInjetDTO();

		DiversosInjetRN rnDiv = new DiversosInjetRN(getDao());
		rnDiv.setDaoSession(getDaoSession());

		retorno.setCdMaquina(filtro.getCdMaquina());
		retorno.setNrop(filtro.getNrop());

		MaquinaInjetRN maquinaRN = this;

		Ijtbinj ijtbinj = filtro.getIjtbinj();

		if (filtro.getIsProcessarCompleto() == true || ijtbinj == null)
			ijtbinj = maquinaRN.pesquisarIjtbinj(filtro.getCdMaquina());

		if (ijtbinj == null) {
			ijtbinj = maquinaRN.pesquisarIjtbinjByCdInjEstendido(filtro.getCdMaquina());
		}
		if (ijtbinj == null)
			throw new RegistroDesconhecidoException();

		Ijtbinj ijtbinjClone = new Ijtbinj();
		ijtbinjClone.setCdinjestendido(ijtbinj.getCdinjestendido());
		ijtbinjClone.setCdinjetora(ijtbinj.getCdinjetora());
		ijtbinjClone.setStfuncionamento(ijtbinj.getStfuncionamento());
		ijtbinjClone.setAguardandomolde(ijtbinj.getAguardandomolde());
		Ijtbpar ijtbparClone = new Ijtbpar();
		if (ijtbinj != null && ijtbinj.getIjtbpar() != null && ijtbinj.getIjtbpar().getSaidademolde() != null)
			ijtbparClone.setSaidademolde(ijtbinj.getIjtbpar().getSaidademolde());
		
		ijtbinjClone.setIjtbpar(ijtbparClone);
		ijtbinjClone.setStinjetora(ijtbinj.getStinjetora());
		
		retorno.setIjtbinj(ijtbinjClone);
		retorno.setDsMaquina(ijtbinj.getCdidentific());

		if (filtro.getIsProcessarCompleto() == true){
			try {
				String cdMoldeAtual = "";
				if (ijtbinj.getCdmoldeatual() != null)
					cdMoldeAtual = ijtbinj.getCdmoldeatual();

				Ijtbmol ijtbmol = rnDiv.pesquisarIjtbmol(cdMoldeAtual);
				Ijtbmol ijtbmolClone = new Ijtbmol();
				ijtbmolClone.setCdmolde(ijtbmol.getCdmolde());
				retorno.setIjtbmolAtualNaMaquina(ijtbmolClone);
			} catch (RegistroDesconhecidoException e2) {
				retorno.setIjtbmolAtualNaMaquina(new Ijtbmol());
			}
		}
		// Obter a parada atual ou ultima parada
		ParadaInjetDTO paradaAtualUltimaParada = new ParadaInjetDTO();
		if (ijtbinj.getIjtbpar() != null){
			paradaAtualUltimaParada.setCdParada(ijtbinj.getIjtbpar().getCdparada());
			paradaAtualUltimaParada.setDsParada(ijtbinj.getIjtbpar().getDsparada());
			paradaAtualUltimaParada.setDthriParada(ijtbinj.getDthriparada());
			paradaAtualUltimaParada.setDthrfParada(ijtbinj.getDthrfparada());
			paradaAtualUltimaParada.setDsAreaResponsavel(ijtbinj.getIjtbpar().getIjareres().getDsarea());

			Date fimAConsiderar = ijtbinj.getDthrfparada();

			if (ijtbinj.getDthrfparada() == null)
				fimAConsiderar = DataHoraRN.getDataHoraAtual();

			int tempoParadaSegundos = 
				DataHoraRN.amountOfSecondsInPeriod(ijtbinj.getDthriparada(), fimAConsiderar);

			paradaAtualUltimaParada.setTempoParadaSegundos((float)tempoParadaSegundos);
		}
		retorno.setParadaAtualUltimaParada(paradaAtualUltimaParada);

		// Verificar se � para obter os grupos aos quais a maquina pertence
		//
		if (filtro.getIsObterGruposDaMaquina() == true){
			retorno.setGruposQueMaquinaPertence(maquinaRN.pesquisarListaIjgrpinj(ijtbinj));
		}

		MaquinaTotalInjetDTO maquinaTotalDTO = new MaquinaTotalInjetDTO();
		DadosParaECPonderadaInjetDTO dadosECPonderada  = new DadosParaECPonderadaInjetDTO();

		// Se a data de inicio estiver indefinida e a OP definida, ent�o definir a data de inicio como sendo o incio da OP
		// e a de fim a data corrente. Com isso poder� ser obtido os dados para o tempo real Acumulado
		if (filtro.getData() == null && filtro.getNrop()!= null && !filtro.getNrop().equals("")){
			// Obtem a data de inicio da op
			PlanejamentoInjetRN plaRN = new PlanejamentoInjetRN(getDao());
			plaRN.setDaoSession(getDaoSession());

			Ijop ijop = null;
			try {
				ijop = plaRN.pesquisarIjop(ijtbinj.getOpatual());
			} catch (RegistroDesconhecidoException e) {
				ijop = new Ijop();
				ijop.setDthrireal(DataHoraRN.getDataHoraAtual());
			}
			filtro.setData(ijop.getDthrireal());

			// Obtem a data atual
			filtro.setDtFinal(DataHoraRN.getDataHoraAtual());
		}

		List<Ijcnsturno> listIjcnsturno = pesquisarIjcnsturno(filtro);
		
		
		BigDecimal tempoAtivo = new BigDecimal(0);
		BigDecimal tempoParada = new BigDecimal(0);
		BigDecimal tempoParadaSemPeso = new BigDecimal(0);
		BigDecimal tempoCicloProdutivo = new BigDecimal(0);
		BigDecimal tempoCicloImprodutivo = new BigDecimal(0);
		BigDecimal tempoRefugo = new BigDecimal(0);
		BigDecimal tempoRitmo = new BigDecimal(0);
		BigDecimal tempoCtt = new BigDecimal(0);
		BigDecimal tempoPerdaCavidade = new BigDecimal(0);
		BigDecimal tempoPerdaCiclo = new BigDecimal(0);

		BigDecimal perdaParada = new BigDecimal(0);
		BigDecimal perdaParadaSemPeso = new BigDecimal(0);
		BigDecimal perdaCiclo = new BigDecimal(0);
		BigDecimal perdaCavidade = new BigDecimal(0);

		BigDecimal perdaParadaKg = new BigDecimal(0);
		BigDecimal perdaParadaSemPesoKg = new BigDecimal(0);
		BigDecimal perdaCicloKg = new BigDecimal(0);

		BigDecimal perdaParadaCusto = new BigDecimal(0);
		BigDecimal perdaParadaSemPesoCusto= new BigDecimal(0);
		BigDecimal perdaCicloCusto = new BigDecimal(0);

		BigDecimal producaoBruta = new BigDecimal(0);
		BigDecimal producaoLiquida = new BigDecimal(0);
		BigDecimal producaoRefugada = new BigDecimal(0);
		BigDecimal producaoPrevista = new BigDecimal(0);

		BigDecimal producaoBrutaKg = new BigDecimal(0);
		BigDecimal producaoLiquidaKg = new BigDecimal(0);
		BigDecimal producaoRefugadaKg = new BigDecimal(0);
		BigDecimal producaoPrevistaKg = new BigDecimal(0);

		BigDecimal producaoBrutaCusto = new BigDecimal(0);
		//		BigDecimal producaoLiquidaCusto = new BigDecimal(0);
		BigDecimal producaoRefugadaCusto = new BigDecimal(0);
		BigDecimal producaoPrevistaCusto = new BigDecimal(0);

		BigDecimal cicloMedio = new BigDecimal(0);
		BigDecimal cicloPadrao = new BigDecimal(0);
		BigDecimal cicloPadraoIndependenteCicloMedio = new BigDecimal(0);
		BigDecimal qtInjNormal = new BigDecimal(0);
		BigDecimal qtCiclosPrevistos = new BigDecimal(0);

		Integer qtCicloPadraoDiferentes = 0;

		Ijcnsturno ijcnsturnoAnterior = null;

		boolean isConsiderarCorrecao = false;

		// Se nao tiver registro em ijcnsturno, deve-se ao menos iniciar algumas propriedades de retorno
		// que serivr� por exemplo para as viewsSulbras
		if (listIjcnsturno == null || listIjcnsturno.size() == 0){
			// Verificar quais os produtos envolvidos no filtro passado
			if (filtro.getIsObterRelacaoProdutos() == true){
				List<Ijmolpro> listaIjmolpro = null;

				try {
					listaIjmolpro = pesquisarIjmolpro(filtro);
					retorno.addProdutos(new HashSet<Ijmolpro>(listaIjmolpro));
					String cdmolde = listaIjmolpro.get(0).getId().getCdmolde();
					String cdestrutura = listaIjmolpro.get(0).getId().getCdestrutura(); 
					Ijfictec reg = null;
					reg = pesquisarIjfictec(filtro.getCdMaquina(), cdmolde, cdestrutura);
					cicloPadrao = new BigDecimal(reg.getCiclopadrao());
				} catch (RegistroDesconhecidoException e1) {
					cicloPadrao = new BigDecimal(0);
				}
				
				//Marcos Sardinha: 2015-06-24 - se n�o ijcnsturno, considerar sem conex�o
				retorno.getIjtbinj().setStfuncionamento("2");
			}
		} else {
			// Se tiver registros, verificar se a correcao do tempo deve ser feita ou nao
			isConsiderarCorrecao = rnDiv.getIjtbfresh().get(0).obtemIsConsiderarCorrecaoDeTempo();
		}
		
		for (Ijcnsturno ijcnsturno : listIjcnsturno){

			// Abaixo seta o registro de ijcnsturno para considerar ou nao a correcao de horarios
			ijcnsturno.setIsConsideraCorrecaoTempo(isConsiderarCorrecao);

			if (filtro.getIsObterRelacaoProdutos() == true){
				retorno.addProdutos(ijcnsturno.getIjmolpros());
			}

			if (ijcnsturnoAnterior == null){
				ijcnsturnoAnterior = ijcnsturno;
			}
			tempoAtivo = tempoAtivo.add(ijcnsturno.pegarTempoDisponivel());
			tempoParada = tempoParada.add(ijcnsturno.getTmpparadas());
			// TmpParadasSemPEso nao eh mais utilizado
			if (ijcnsturno.getTmpparadassempeso() != null)
				tempoParadaSemPeso = tempoParadaSemPeso.add(new BigDecimal(ijcnsturno.getTmpparadassempeso()));
			tempoCicloProdutivo = tempoCicloProdutivo.add(ijcnsturno.pegarTmpCicNormalConsiderandoCorrecao());
			tempoCicloImprodutivo = tempoCicloImprodutivo.add(ijcnsturno.pegarTmpcicfinparadaConsiderandoCorrecao());
			tempoCtt = tempoCtt.add(ijcnsturno.pegarCttConsiderandoCorrecao());
			qtInjNormal = qtInjNormal.add(new BigDecimal(ijcnsturno.getQtinjnormal()));
			
			// Encontra o ciclo padrao para o registro em avaliacao de ijcnsturno
			Ijfictec ijfictec = ijcnsturno.getIjfictec();
			/// Pesquisar foi retirado pois o select de ijcnsturno ja deve retornoar tb ijfictec pesquisarIjfictecAPartirDeIjcnsturno(ijcnsturno);

			// Encontra a quantidade de cavidades ativas e peso para o registro avaliado
			CavidadePesoInjetDTO cavidadePeso = totalizaListaIjmolproAPartirDeIjcnsturno(ijcnsturno, filtro);

			Integer qtcavidadesAtivas = cavidadePeso.getQtcavidadesAtivas();
			Integer qtcavidades = cavidadePeso.getQtcavidades();
			BigDecimal pesoBruto = cavidadePeso.getPesoBruto();
			//			BigDecimal pesoLiquido = cavidadePeso.getPesoLiquido();
			BigDecimal custo = cavidadePeso.getCusto();


			// Calcula os indicadores dependentes do ciclo e da cavidade
			BigDecimal perdaParadaIjcnsturno = ijcnsturno.getTmpparadas();
			perdaParadaIjcnsturno = perdaParadaIjcnsturno.divide(new BigDecimal(ijfictec.getCiclopadrao()), 100, BigDecimal.ROUND_HALF_EVEN);
			perdaParadaIjcnsturno = perdaParadaIjcnsturno.multiply(new BigDecimal(qtcavidadesAtivas));
			perdaParada = perdaParada.add(perdaParadaIjcnsturno);

			BigDecimal perdaParadaKgIjcnsturno = perdaParadaIjcnsturno.multiply(pesoBruto);
			perdaParadaKgIjcnsturno = perdaParadaKgIjcnsturno.divide(new BigDecimal(1000));
			perdaParadaKg = perdaParadaKg.add(perdaParadaKgIjcnsturno);

			BigDecimal perdaParadaCustoIjcnsturno = perdaParadaIjcnsturno.multiply(custo);
			perdaParadaCusto = perdaParadaCusto.add(perdaParadaCustoIjcnsturno);

			BigDecimal perdaParadaSemPesoIjcnsturno = new BigDecimal(0);
			
			if (ijcnsturno.getTmpparadassempeso() != null)
				perdaParadaSemPesoIjcnsturno = new BigDecimal(ijcnsturno.getTmpparadassempeso());
			
			perdaParadaSemPesoIjcnsturno = perdaParadaSemPesoIjcnsturno.divide(new BigDecimal(ijfictec.getCiclopadrao()), 100, BigDecimal.ROUND_HALF_EVEN);
			perdaParadaSemPesoIjcnsturno = perdaParadaSemPesoIjcnsturno.multiply(new BigDecimal(qtcavidadesAtivas));
			perdaParadaSemPeso = perdaParadaSemPeso.add(perdaParadaSemPesoIjcnsturno);

			BigDecimal perdaParadaSemPesoKgIjcnsturno = perdaParadaSemPesoIjcnsturno.multiply(pesoBruto);
			perdaParadaSemPesoKgIjcnsturno = perdaParadaSemPesoKgIjcnsturno.divide(new BigDecimal(1000));
			perdaParadaSemPesoKg = perdaParadaSemPesoKg.add(perdaParadaSemPesoKgIjcnsturno);

			BigDecimal perdaParadaSemPesoCustoIjcnsturno = perdaParadaSemPesoIjcnsturno.multiply(custo);
			perdaParadaSemPesoCusto = perdaParadaSemPesoCusto.add(perdaParadaSemPesoCustoIjcnsturno);


			BigDecimal perdaCicloIjcnsturno = ijcnsturno.pegarTmpCicNormalConsiderandoCorrecao();
			perdaCicloIjcnsturno = perdaCicloIjcnsturno.divide(new BigDecimal(ijfictec.getCiclopadrao()), 100, BigDecimal.ROUND_HALF_EVEN);
			perdaCicloIjcnsturno = perdaCicloIjcnsturno.subtract(new BigDecimal(ijcnsturno.getQtinjnormal()));
			perdaCicloIjcnsturno = perdaCicloIjcnsturno.multiply(new BigDecimal(qtcavidadesAtivas));
			if (perdaCicloIjcnsturno.subtract(
					new BigDecimal(perdaCicloIjcnsturno.intValue())
			).doubleValue() * -1 >= 0.99999999999999)
				perdaCicloIjcnsturno = perdaCicloIjcnsturno.divide(new BigDecimal(1), 0, BigDecimal.ROUND_UP);

			perdaCiclo = perdaCiclo.add(perdaCicloIjcnsturno);

			if (ijcnsturno.getQtinjnormal().floatValue() > 0f && ijcnsturno.pegarTmpCicNormalConsiderandoCorrecao().floatValue() > 0f && ijfictec.getCiclopadrao() > 0d){
				BigDecimal tempoPerdaCicloIjcnsturno = ijcnsturno.pegarTmpCicNormalConsiderandoCorrecao();
				tempoPerdaCicloIjcnsturno = tempoPerdaCicloIjcnsturno.divide(new BigDecimal(ijcnsturno.getQtinjnormal()), 100, BigDecimal.ROUND_HALF_EVEN);
				tempoPerdaCicloIjcnsturno = tempoPerdaCicloIjcnsturno.subtract(new BigDecimal(ijfictec.getCiclopadrao()));
				if (tempoPerdaCicloIjcnsturno.floatValue() > 0f){ // Entao o ciclo medio eh maior que o padrao, ou seja ineficiente
					tempoPerdaCicloIjcnsturno = tempoPerdaCicloIjcnsturno.multiply(new BigDecimal(ijcnsturno.getQtinjnormal()));
					tempoPerdaCiclo = tempoPerdaCiclo.add(tempoPerdaCicloIjcnsturno);
				}

				// Ajuda ao garbage collector
				tempoPerdaCicloIjcnsturno = null;
			}

			BigDecimal perdaCicloKgIjcnsturno = perdaCicloIjcnsturno.multiply(pesoBruto);
			perdaCicloKgIjcnsturno = perdaCicloKgIjcnsturno.multiply(new BigDecimal(1000));
			perdaCicloKg = perdaCicloKg.add(perdaCicloKgIjcnsturno);

			BigDecimal perdaCicloCustoIjcnsturno = perdaCicloIjcnsturno.multiply(custo);
			perdaCicloCusto = perdaCicloCusto.add(perdaCicloCustoIjcnsturno);

			BigDecimal producaoBrutaIjcnsturno = new BigDecimal(ijcnsturno.getQtinjnormal());
			producaoBrutaIjcnsturno = producaoBrutaIjcnsturno.multiply(new BigDecimal(qtcavidadesAtivas));
			producaoBruta = producaoBruta.add(producaoBrutaIjcnsturno);
			BigDecimal producaoBrutaKgIjcnsturno = producaoBrutaIjcnsturno.multiply(pesoBruto);
			producaoBrutaKgIjcnsturno = producaoBrutaKgIjcnsturno.divide(new BigDecimal(1000));
			producaoBrutaKg = producaoBrutaKg.add(producaoBrutaKgIjcnsturno);
			BigDecimal producaoBrutaCustoIjcnsturno = producaoBrutaIjcnsturno.multiply(custo);
			producaoBrutaCusto = producaoBrutaCusto.add(producaoBrutaCustoIjcnsturno);

			BigDecimal producaoPrevistaIjcnsturno = ijcnsturno.pegarTempoDisponivel().divide(new BigDecimal(ijfictec.getCiclopadrao()), 100, BigDecimal.ROUND_HALF_EVEN);
			producaoPrevistaIjcnsturno = producaoPrevistaIjcnsturno.multiply(new BigDecimal(qtcavidadesAtivas));
			producaoPrevista = producaoPrevista.add(producaoPrevistaIjcnsturno);
			BigDecimal producaoPrevistaKgIjcnsturno = producaoPrevistaIjcnsturno.multiply(pesoBruto);
			producaoPrevistaKgIjcnsturno = producaoPrevistaKgIjcnsturno.divide(new BigDecimal(1000));
			producaoPrevistaKg = producaoPrevistaKg.add(producaoPrevistaKgIjcnsturno);
			BigDecimal producaoPrevistaCustoIjcnsturno = producaoPrevistaIjcnsturno.multiply(custo);
			producaoPrevistaCusto = producaoPrevistaCusto.add(producaoPrevistaCustoIjcnsturno);

			BigDecimal perdaCavidadeIjcnsturno = new BigDecimal(ijcnsturno.getQtinjnormal());
			perdaCavidadeIjcnsturno = perdaCavidadeIjcnsturno.multiply(new BigDecimal(qtcavidades - qtcavidadesAtivas));
			perdaCavidade = perdaCavidade.add(perdaCavidadeIjcnsturno);

			BigDecimal tempoPerdaCavidadeIjcnsturno = ijcnsturno.pegarTmpCicNormalConsiderandoCorrecao();
			if (qtcavidades != 0)
				tempoPerdaCavidadeIjcnsturno = tempoPerdaCavidadeIjcnsturno.divide(new BigDecimal(qtcavidades), 100, BigDecimal.ROUND_HALF_EVEN);
			tempoPerdaCavidadeIjcnsturno = tempoPerdaCavidadeIjcnsturno.multiply(new BigDecimal(qtcavidades - qtcavidadesAtivas));
			tempoPerdaCavidade = tempoPerdaCavidade.add(tempoPerdaCavidadeIjcnsturno);

			BigDecimal cicloMedioIjcnsturno = FormulasInjet.calcularCicloMedio(ijcnsturno.pegarTmpCicNormalConsiderandoCorrecao(), new BigDecimal(ijcnsturno.getQtinjnormal()));

			cicloPadraoIndependenteCicloMedio = cicloPadraoIndependenteCicloMedio.add(new BigDecimal(ijfictec.getCiclopadrao()));

			// Marcos Sardinha: 2015-06-10 - para monitoriza��oo hierárquica Termotécnica
			BigDecimal tempoProdutivoCalcPrevista =  new BigDecimal(0);
			BigDecimal qtCiclosPrevistoIjCnsTurno =  new BigDecimal(0);
			tempoProdutivoCalcPrevista = tempoProdutivoCalcPrevista.add(tempoCicloProdutivo).add(tempoCicloImprodutivo);
			qtCiclosPrevistoIjCnsTurno = new BigDecimal(tempoProdutivoCalcPrevista.divide(new BigDecimal(ijfictec.getCiclopadrao()), 100, BigDecimal.ROUND_HALF_EVEN).intValue());
			qtCiclosPrevistos = qtCiclosPrevistos.add(qtCiclosPrevistoIjCnsTurno);

					
			if (ijcnsturno.getQtinjnormal().floatValue() > 0f){
				cicloMedio = cicloMedio.add(cicloMedioIjcnsturno);


				cicloPadrao = cicloPadrao.add(new BigDecimal(ijfictec.getCiclopadrao()));
				qtCicloPadraoDiferentes += 1;

				// Adiciona os dados para calcula da Eficiencia de ciclo
				EficienciaCicloInjetDTO eficienciaCicloDTO = new EficienciaCicloInjetDTO(
						ijcnsturno.getId().getCdinjetora(),
						ijcnsturno.getId().getCdmolde(),
						ijcnsturno.getId().getCdestrutura(),
						ijcnsturno.getId().getDthrivalcic());

				eficienciaCicloDTO.setTmpcicnormal(ijcnsturno.pegarTmpCicNormalConsiderandoCorrecao());
				eficienciaCicloDTO.setQtinjnormal(new BigDecimal(ijcnsturno.getQtinjnormal()));
				eficienciaCicloDTO.setCicloPadrao(new BigDecimal(ijfictec.getCiclopadrao()));

				maquinaTotalDTO.addEficienciaCicloDTO(eficienciaCicloDTO);
			}

			BigDecimal tempoRitmoIjcnsturno = ijcnsturno.pegarTmpCicNormalConsiderandoCorrecao();
			tempoRitmoIjcnsturno = tempoRitmoIjcnsturno.divide(new BigDecimal(ijfictec.getCiclopadrao()), 100, BigDecimal.ROUND_HALF_EVEN);
			tempoRitmoIjcnsturno = tempoRitmoIjcnsturno.subtract(new BigDecimal(ijcnsturno.getQtinjnormal()));
			tempoRitmoIjcnsturno = tempoRitmoIjcnsturno.multiply(new BigDecimal(ijfictec.getCiclopadrao()));
			tempoRitmo = tempoRitmo.add(tempoRitmoIjcnsturno);

			// Encontra ijcnsturnodetref para calcula da quantidade refugada e tempo de refugo
			RefugoTempoInjetDTO refugoTempo = this.totalizaListaIjcnsturnodetrefAPartirDeIjcnsturno(
					listIjcnsturno,
					ijcnsturno, filtro);

			producaoRefugada = producaoRefugada.add(refugoTempo.getProducaoRefugada());
			producaoRefugadaCusto = producaoRefugadaCusto.add(refugoTempo.getProducaoRefugadaCusto());
			producaoRefugadaKg = producaoRefugadaKg.add(refugoTempo.getProducaoRefugadaKg());
			tempoRefugo = tempoRefugo.add(refugoTempo.getTempoRefugo());
						
			// Calculos dos dados para a ecPonderada
			// procupara se o molde e a estrutura existem
			// soma dados de TmpCicNomal, qtInjNormal e cicloPadrao para o molde encontrado
			// ou entao inclui entrada para molde novo
			// mas somente para os registros que tiverem tempo ativo
			if (ijcnsturno.pegarTempoDisponivel().doubleValue() > 0){
				boolean isDadosECExistem = false;
				for (DadosParaECPonderadaInjetDTO dadosEC : retorno.getDadosECPonderada()){
					if (dadosEC.getCdMolde().equals(ijcnsturno.getId().getCdmolde()) && 
							dadosEC.getCdEstrutra().equals(ijcnsturno.getId().getCdestrutura()) &&
							dadosEC.getCdMaquina().equals(ijcnsturno.getId().getCdinjetora())){
						isDadosECExistem = true;
						dadosEC.addCicloPadrao(new BigDecimal(ijfictec.getCiclopadrao()));
						dadosEC.addQtInjNormal(new BigDecimal(ijcnsturno.getQtinjnormal()));
						dadosEC.addTempoAtivo(ijcnsturno.pegarTempoDisponivel());
						dadosEC.addTmpCicNormal(ijcnsturno.pegarTmpCicNormalConsiderandoCorrecao());
						dadosEC.addQtCicloPadrao();
					}
				}
				if (isDadosECExistem == false){
					dadosECPonderada = new DadosParaECPonderadaInjetDTO();
					dadosECPonderada.setCdMaquina(ijcnsturno.getId().getCdinjetora());
					dadosECPonderada.setCdMolde(ijcnsturno.getId().getCdmolde());
					dadosECPonderada.setCdEstrutra(ijcnsturno.getId().getCdestrutura());
					dadosECPonderada.setCicloPadrao(new BigDecimal(ijfictec.getCiclopadrao()));
					dadosECPonderada.setQtInjNormal(new BigDecimal(ijcnsturno.getQtinjnormal()));
					dadosECPonderada.setTempoAtivo(ijcnsturno.pegarTempoDisponivel());
					dadosECPonderada.setTmpCicNormal(ijcnsturno.pegarTmpCicNormalConsiderandoCorrecao());
					dadosECPonderada.setQtCicloPadrao(1);
					retorno.addDadosECPonderada(dadosECPonderada);
				}
			}
		}


		// Obtem a producao liquida
		producaoLiquida = producaoBruta.subtract(producaoRefugada);
		producaoLiquidaKg = producaoBrutaKg.subtract(producaoRefugadaKg);
		//		producaoLiquidaCusto = producaoBrutaCusto.subtract(producaoRefugadaCusto);

		// Obtem o inicio e final do periodo que se deseja avaliar as paradas
		// Se apenas um turno estiver sendo avaliado, entao o inicio e fim do periodo ser� o inicio e fim do turno avaliado
		// Se todos os turnos estiverem sendo avaliados, entao o periodo sera o inicio do primeiro turno e final
		// do ultimo turno
		// A data de referencia ser� sempre a data em avaliacao
		String cdTurnoInicial = "";
		String cdTurnoFinal = "";

		boolean isTurnoProgramado = true;

		if (filtro.getDtFinal() == null)
			filtro.setDtFinal(DataHoraRN.getDataHoraAtual());
		if (filtro.getData() == null)
			filtro.setData(DataHoraRN.getDataHoraAtual());
		
		if (filtro.getCdTurno() == null || filtro.getCdTurno().equals("") || filtro.getCdTurno().equals("999999")){
			// Nao posso fixar valores assim
			//			cdTurnoInicial = FuncoesApoioInjet.encontrarTurnoInicialNoDia(filtro.getData());
			try {
				cdTurnoFinal = FuncoesApoioInjet.encontrarTurnoFinalNoDia((DAOGenericoInjet) getDao(), filtro.getDtFinal());
			} catch (SemCalendarioException e) {
				isTurnoProgramado = false;
			}
			cdTurnoInicial = "000001";
			//			cdTurnoFinal = "000003";

		} else {
			cdTurnoInicial = filtro.getCdTurno();
			cdTurnoFinal = filtro.getCdTurno();
		}
		Date inicioPeriodo = null;
		Date fimPeriodo = null;

		Date inicioTurno = null;
		Date fimTurno = null;

		try {
			if (filtro.getData() != null){
				inicioTurno = FuncoesApoioInjet.calcularInicioTurno(getDao(), filtro.getData(), cdTurnoInicial);
				inicioPeriodo = filtro.getData();
			}
		} catch (SemCalendarioException e1) {
			/*
			 * Se nao houver turno nesse periodo, entao nao deve-se verificar as consultas de paradas, etc.
			 */
			isTurnoProgramado = false;
		}

		try {
			if (filtro.getDtFinal() != null){
				fimTurno = FuncoesApoioInjet.calcularFimTurno(getDao(), filtro.getDtFinal(), cdTurnoFinal);
				fimPeriodo = filtro.getDtFinal();
			}
		} catch (SemCalendarioException e1) {
			/*
			 * Se nao houver turno nesse periodo, entao nao deve-se verificar as consultas de paradas, etc.
			 */
			isTurnoProgramado = false;
		}
		if (inicioPeriodo == null)
			inicioPeriodo = filtro.getData();

		if (fimPeriodo == null)
			fimPeriodo = filtro.getDtFinal();


		if (isTurnoProgramado){
			// Obtem o tempo de paradas em aberto e fechadas sem peso
			// somar em tempoParadaSemPeso
			String HQL = "";

			HQL += "from Ijreapar ijreapar ";
			HQL += "join fetch ijreapar.ijtbpar ijtbpar ";
			HQL += "where ";


			// Outras regras
			HQL += "ijreapar.id.cdinjetora = '::cdmaquina' ";
			//			HQL += "ijreapar.ijestmol.id.cdmolde <> '999999' and ";
			//			HQL += "ijreapar.ijestmol.id.cdestrutura <> '9999' and ";
			//			HQL += "ijreapar.ijop.nrop <> '9999999999' ";



			HQL = HQL.replaceAll("::cdmaquina", filtro.getCdMaquina());

			if (filtro.getNrop() != null && !filtro.getNrop().equals("")){
				HQL += "and ijreapar.ijop.nrop = '::nrop' ";
				HQL = HQL.replaceAll("::nrop", filtro.getNrop());
			}

			if (filtro.isConsiderarMolde()){
				HQL += "and ijreapar.ijestmol.id.cdmolde = '::cdmode' ";
				HQL = HQL.replaceAll("::cdmolde", filtro.getCdMolde());
			} else if (filtro.isConsiderarMoldeGrupo() ){
				HQL += "and exists (from Ijgrpdetmol ijgrpdetmol where ijgrpdetmol.cdgrpmol = '::cdmoldegrupo' and ijgrpdetmol.cdmolde = ijreapar.ijestmol.id.cdmolde) ";
				HQL = HQL.replaceAll("::cdmoldegrupo", filtro.getCdMoldeGrupo());
			}

			if (filtro.isConsiderarProduto()){
				HQL += "and exists (from Ijmolpro ijmolpro where ijmolpro.id.cdproduto = '::cdproduto' and ijmolpro.id.cdmolde = ijreapar.ijestmol.id.cdmolde and ijmolpro.id.cdestrutura = ijreapar.ijestmol.id.cdestrutura and ijmolpro.id.dthrival = ijreapar.dthrivalestru) ";
				HQL = HQL.replaceAll("::cdproduto", filtro.getCdProduto());
			}

			String hqlParaDtHrFParadaNull = HQL;

			if (inicioPeriodo != null && fimPeriodo != null){
				HQL += "and ijreapar.dthrfparada is not null and ( ";
				HQL += "   (ijreapar.id.dthriparada between :dtinicio and :dtfim ) or ";
				HQL += "   (ijreapar.dthrfparada between :dtinicio and :dtfim) or ";
				HQL += "   (ijreapar.id.dthriparada < :dtinicio and ijreapar.dthrfparada > :dtfim) ";
				HQL += "   ) ";

				hqlParaDtHrFParadaNull += "and (ijreapar.dthrfparada is null) ";
			}


			HQL += "order by ijreapar.id.dthriparada ";
			hqlParaDtHrFParadaNull += "order by ijreapar.id.dthriparada ";

			List<Ijreapar> listIjreapar = null;
			Query q = null;
			if (inicioTurno != null && fimTurno != null){
					try{
						q = getDaoSession().createQuery(HQL);
					} catch (Exception e){
						e.printStackTrace();
					}
					q.setTimestamp("dtinicio", inicioTurno);
					q.setTimestamp("dtfim", fimTurno);
			}

			try{
				listIjreapar = q.list();
			} catch (Exception e){
				e.printStackTrace();
			}

			q = getDaoSession().createQuery(hqlParaDtHrFParadaNull);

			listIjreapar.addAll(q.list());

			BigDecimal tempoParadaEmAbertoSemPeso = new BigDecimal(0);
			BigDecimal perdaParadaEmAbertoSemPeso = new BigDecimal(0);
			BigDecimal perdaParadaEmAbertoSemPesoKg = new BigDecimal(0);
			BigDecimal perdaParadaEmAbertoSemPesoCusto = new BigDecimal(0);



			BigDecimal tempoParadaEmAbertoComPeso = new BigDecimal(0);
			BigDecimal perdaParadaEmAbertoComPeso = new BigDecimal(0);
			BigDecimal perdaParadaEmAbertoComPesoKg = new BigDecimal(0); 
			BigDecimal perdaParadaEmAbertoComPesoCusto = new BigDecimal(0);


			boolean isUltimaParadaFoiSaidaDeMolde = false;
			Date dthrInicioSetup = null;
			for (Ijreapar ijreapar : listIjreapar){

				// Atualiza ijtbpar de ijreapar
				Ijtbpar ijtbpar = pesquisarIjtbpar(ijreapar.getIjtbpar().getCdparada());
				ijreapar.setIjtbpar(ijtbpar);

				//				ijreapar.getIjtbpar().getDsparada();
				// antes de mais nada, verificar se a parada em analise eh do tipo saida de molde
				// se sim, entao setar flag para que a proxima parada seja analisada se eh de entrada de molde
				if (filtro.getIsObterTemposDeSetupDasOPs() == true){
					if (ijreapar.getIjtbpar().getTrocademolde().equals(BigDecimal.ONE) && 
							ijreapar.getIjtbpar().getEntradademolde().equals(BigDecimal.ZERO)){
						if (ijreapar.getCdmoldeentrada() == null || 
								isUltimaParadaFoiSaidaDeMolde == false || 
								ijreapar.getDthrfparada() == null){

							isUltimaParadaFoiSaidaDeMolde = false;
							dthrInicioSetup = null;
						} else {
							// Calcula o tempo de troca de molde
							BigDecimal tempoParadaEmSetupReal = null;
							tempoParadaEmSetupReal = FuncoesApoioInjet.getTempoParadaNoIntervaloDoTurno(
									getDao(),
									inicioPeriodo,
									fimPeriodo,
									dthrInicioSetup, 
									ijreapar.getDthrfparada(),
									filtro.getCdTurno());

							// Encontra a OP que esta entrando
							String nropEntrada = "";
							try{
								nropEntrada = pesquisarIjentsaiopmaq(ijreapar);
							} catch (NullPointerException e){
								e.printStackTrace();
							}
							// Encontra o tempo padrao para a troca de molde
							BigDecimal tempoPlanejadoSetup = null;
							tempoPlanejadoSetup = obterTempoPlanejadoSetup(ijreapar);

							// Atualiza as informacoes de troca de op
							boolean isExisteTroca = false;
							for (TrocaOPInjetDTO troca : retorno.getTrocasDeOP()){
								if (troca.getNropEntrando().equals(nropEntrada)){
									isExisteTroca = true;
									troca.setTempoRealSetup(troca.getTempoRealSetup().add(tempoParadaEmSetupReal));
								}
							}
							if (isExisteTroca == false){
								TrocaOPInjetDTO trocaop = new TrocaOPInjetDTO();
								trocaop.setCdMaquina(ijtbinj.getCdinjestendido());
								trocaop.setNropEntrando(nropEntrada);
								trocaop.setNropSaindo(ijreapar.getIjop().getNrop());
								trocaop.setTempoPlanejadoSetup(tempoPlanejadoSetup);
								trocaop.setTempoRealSetup(tempoParadaEmSetupReal);

								retorno.addTrocaOP(trocaop);
							}

							// limpa variaveis de controle
							isUltimaParadaFoiSaidaDeMolde = false;
							dthrInicioSetup = null;
						}
					}
					if (ijreapar.getIjtbpar().getTrocademolde().equals(BigDecimal.ZERO) && 
							ijreapar.getIjtbpar().getEntradademolde().equals(BigDecimal.ONE)){
						isUltimaParadaFoiSaidaDeMolde = true;
						dthrInicioSetup = ijreapar.getId().getDthriparada();
					} else {
						isUltimaParadaFoiSaidaDeMolde = false;
						dthrInicioSetup = null;
					}
				}

				
				BigDecimal tempoParadaEmIjreapar = new BigDecimal(0);
				/* Se foi definido um turno especificamente, deve-se obter o tempo da parada apenas no turno em quest�o
				 * 
				 */
				if (filtro.isConsiderarTurno()){
					// Encontrar o inicio e fim do turno para a parada que esta sendo avaliada
					tempoParadaEmIjreapar = FuncoesApoioInjet.getTempoParadaNoIntervaloDoTurno(
							getDao(),
							inicioPeriodo,
							fimPeriodo,
							ijreapar.getId().getDthriparada(), 
							ijreapar.getDthrfparada(),
							filtro.getCdTurno());
					

				} else {
					tempoParadaEmIjreapar = FuncoesApoioInjet.getTempoParadaNoIntervalo(
							getDao(),
							inicioTurno, 
							fimTurno, 
							ijreapar.getId().getDthriparada(),
							ijreapar.getDthrfparada());

				}
				// Contabiliza dados para o MTBF e MTTR
				if (ijreapar.getIjtbpar().getCalcmtbfmttr() == '1'){
					maquinaTotalDTO.setQtOcorrenciaParadasMTBFMTTR(maquinaTotalDTO.getQtOcorrenciaParadasMTBFMTTR() + 1);
					maquinaTotalDTO.setTempoParadasMTTR(maquinaTotalDTO.getTempoParadasMTTR().add(tempoParadaEmIjreapar));
				}
				// fim do MTBF e MTTR
				
				
				//Marcos Sardinha: 2015-06-24 - considera tempo real somente se realmente for 
				Date dthrAtual = new Date();
				try {
					TurnoInjetDTO dtRefTurAtual = FuncoesApoioInjet.encontraTurno(getDao(), dthrAtual);
					System.out.println("filtro.Data = " + DataHoraRN.dateToStringDDMMYYYYHHMMSS(filtro.getData()) + " refTurnoHrAtual=" + 
					DataHoraRN.dateToStringDDMMYYYYHHMMSS(dtRefTurAtual.getDtReferencia()) + 
					" cdTurnoFiltro=" + filtro.getCdTurno() + 
					" turnAtual=" + dtRefTurAtual.getIjtbtur().getCdturno() );
					if ( (DataHoraRN.equals(filtro.getData(), dtRefTurAtual.getDtReferencia())) && (filtro.getCdTurno().equals(dtRefTurAtual.getIjtbtur().getCdturno())) )
					{
						System.out.println("Vou processar o turno atual");
						isTempoReal = true;
					}
				} catch (SemCalendarioException e) {
					e.printStackTrace();
				}
				
				if (!isTempoReal)
				{
					/* trabalhando
					retorno.setCorFundo(0);
					retorno.getIjtbinj().setStfuncionamento("1");
					
					Date dtHrFimParada = ijreapar.getDthrfparada();
					
					if (dtHrFimParada == null)
					{
						dtHrFimParada = dthrAtual;
					}
					
					if (dtHrFimParada.compareTo(fimTurno) >= 0)
					{
						System.out.println("MAQUINA PARADA ANTIGA");
						// máquina virou o turno parada
						retorno.setCorFrente(MaquinaInjetDTO.FRENTE_PARADA);
						retorno.getIjtbinj().setStfuncionamento("0");
						if (!FuncoesApoioInjet.isParadaComPeso(ijreapar))
						{
							retorno.setCorFundo(MaquinaInjetDTO.FUNDO_PARADASEMPESO);
						}
					}
					*/
				}
				
				
				boolean paradaSemPeso = !FuncoesApoioInjet.isParadaComPeso(ijreapar);

				// Se for para retornar a lista de paradas por motivos
				if (filtro.isObterParadasPorMotivo() == true) {// as paradas sem peso devem ser consideradas && paradaSemPeso == false){
					retorno.addParadasPorMotivo(ijreapar, tempoParadaEmIjreapar, !paradaSemPeso);
				}

				// Se for para retornar a lista de paradas por motivos
				if (filtro.isObterParadasPorArea() == true ) {// as paradas sem peso devem ser consideradas && paradaSemPeso == false){
					retorno.addParadasPorArea(ijreapar, tempoParadaEmIjreapar);
				}


				// Se for parada em aberto
				if (ijreapar.getDthrfparada() == null){

					if (paradaSemPeso == true){
						tempoParadaEmAbertoSemPeso = tempoParadaEmAbertoSemPeso.add(tempoParadaEmIjreapar);
					} else
						tempoParadaEmAbertoComPeso = tempoParadaEmAbertoComPeso.add(tempoParadaEmIjreapar);


					// Calcula a perda em pecas e quilos

					// Obtem qtcavidades ativas e peso
					CavidadePesoInjetDTO cavidadePeso = totalizaListaIjmolproAPartirDeIjreapar(ijreapar, filtro);

					Integer qtcavidadesAtivas = cavidadePeso.getQtcavidadesAtivas();
					//				Integer qtcavidades = cavidadePeso.getQtcavidades();
					BigDecimal pesoBruto = cavidadePeso.getPesoBruto();
					//				BigDecimal pesoLiquido = cavidadePeso.getPesoLiquido();
					BigDecimal custo = cavidadePeso.getCusto();

					// Obtem ciclo padrao
					Ijfictec ijfictec = null;

					try{
						ijfictec = pesquisarIjfictecAPartirDeIjreapar(ijreapar);
					} catch (RegistroDesconhecidoException e){
						// Se nao houver ijfictec para a parada, a mesma eh descartada
						continue;
					}


					if (paradaSemPeso == true){
						// Calculos
						BigDecimal perdaParadaEmAbertoSemPesoIjreapar = tempoParadaEmIjreapar;
						perdaParadaEmAbertoSemPesoIjreapar = perdaParadaEmAbertoSemPesoIjreapar.divide(new BigDecimal(ijfictec.getCiclopadrao()), 100, BigDecimal.ROUND_HALF_EVEN);
						perdaParadaEmAbertoSemPesoIjreapar = perdaParadaEmAbertoSemPesoIjreapar.multiply(new BigDecimal(qtcavidadesAtivas));
						perdaParadaEmAbertoSemPeso = perdaParadaEmAbertoSemPeso.add(perdaParadaEmAbertoSemPesoIjreapar);

						BigDecimal perdaParadaEmAbertoSemPesoKgIjreapar = perdaParadaEmAbertoSemPesoIjreapar.multiply(pesoBruto);
						perdaParadaEmAbertoSemPesoKgIjreapar = perdaParadaEmAbertoSemPesoKgIjreapar.divide(new BigDecimal(1000));
						perdaParadaEmAbertoSemPesoKg = perdaParadaEmAbertoSemPesoKg.add(perdaParadaEmAbertoSemPesoKgIjreapar);

						BigDecimal perdaParadaEmAbertoSemPesoCustoIjreapar = perdaParadaEmAbertoSemPesoIjreapar.multiply(custo);
						perdaParadaEmAbertoSemPesoCusto = perdaParadaEmAbertoSemPesoCusto.add(perdaParadaEmAbertoSemPesoCustoIjreapar);


					} else {

						// Calculos
						BigDecimal perdaParadaEmAbertoIjreapar = tempoParadaEmIjreapar;
						perdaParadaEmAbertoIjreapar = perdaParadaEmAbertoIjreapar.divide(new BigDecimal(ijfictec.getCiclopadrao()), 100, BigDecimal.ROUND_HALF_EVEN);
						perdaParadaEmAbertoIjreapar = perdaParadaEmAbertoIjreapar.multiply(new BigDecimal(qtcavidadesAtivas));
						perdaParadaEmAbertoComPeso = perdaParadaEmAbertoComPeso.add(perdaParadaEmAbertoIjreapar);

						BigDecimal perdaParadaEmAbertoKgIjreapar = perdaParadaEmAbertoIjreapar.multiply(pesoBruto);
						perdaParadaEmAbertoKgIjreapar = perdaParadaEmAbertoKgIjreapar.divide(new BigDecimal(1000));
						perdaParadaEmAbertoComPesoKg = perdaParadaEmAbertoComPesoKg.add(perdaParadaEmAbertoKgIjreapar);

						BigDecimal perdaParadaEmAbertoCustoIjreapar = perdaParadaEmAbertoIjreapar.multiply(custo);
						perdaParadaEmAbertoComPesoCusto = perdaParadaEmAbertoComPesoCusto.add(perdaParadaEmAbertoCustoIjreapar);
					}
				}

			}

			/*
			 *  Marcos Sardinha: 2015-06-01 >>> os tempos de parada em aberto já est�o sendo consolidados nas tabelas ijcns... do Injet.
			 *  As linha abaixo foram comentadas por esse motivo.
			 *  
				tempoParadaSemPeso = tempoParadaSemPeso.add(tempoParadaEmAbertoSemPeso);
				perdaParadaSemPeso = perdaParadaSemPeso.add(perdaParadaEmAbertoSemPeso);
				perdaParadaSemPesoKg = perdaParadaSemPesoKg.add(perdaParadaEmAbertoSemPesoKg);
				perdaParadaSemPesoCusto = perdaParadaSemPesoCusto.add(perdaParadaEmAbertoSemPesoCusto);
							
				tempoParada = tempoParada.add(tempoParadaEmAbertoComPeso);
				tempoAtivo = tempoAtivo.add(tempoParadaEmAbertoComPeso);
				perdaParada = perdaParada.add(perdaParadaEmAbertoComPeso);
				perdaParadaKg = perdaParadaKg.add(perdaParadaEmAbertoComPesoKg);
				perdaParadaCusto = perdaParadaCusto.add(perdaParadaEmAbertoComPesoCusto);
	
				producaoPrevista = producaoPrevista.add(perdaParadaEmAbertoComPeso);
				producaoPrevistaKg = producaoPrevistaKg.add(perdaParadaEmAbertoComPesoKg);
				producaoPrevistaCusto = producaoPrevistaCusto.add(perdaParadaEmAbertoComPesoCusto);
			*/
			
			
			//Marcos Sardinha: 2015-09-08 - verifica se é tempo real de fato... verificacao para sem OP 
			Date dthrAtual = new Date();
			try {
				TurnoInjetDTO dtRefTurAtual = FuncoesApoioInjet.encontraTurno(getDao(), dthrAtual);
				System.out.println("filtro.Data = " + DataHoraRN.dateToStringDDMMYYYYHHMMSS(filtro.getData()) + " refTurnoHrAtual=" + 
				DataHoraRN.dateToStringDDMMYYYYHHMMSS(dtRefTurAtual.getDtReferencia()) + 
				" cdTurnoFiltro=" + filtro.getCdTurno() + 
				" turnAtual=" + dtRefTurAtual.getIjtbtur().getCdturno() );
				if ( (filtro.getData().equals(dtRefTurAtual.getDtReferencia())) && (filtro.getCdTurno().equals(dtRefTurAtual.getIjtbtur().getCdturno())) )
				{
					System.out.println("Vou processar o turno atual");
					isTempoReal = true;
				}
			} catch (SemCalendarioException e) {
				e.printStackTrace();
			}
			
			if (!isTempoReal)
			{
				
				List<Object> listIjentsaiopmaq = null;
				
				HQL = "SELECT a.id.dthrentrada, a.id.dthrsaida ";
				HQL = HQL.concat("  FROM Ijentsaiopmaq a ");
				HQL = HQL.concat(" WHERE (   (a.id.dthrentrada BETWEEN :dtinicio AND :dtfim)  ");
				HQL = HQL.concat("        OR (a.id.dthrsaida BETWEEN :dtinicio AND :dtfim)  ");
				HQL = HQL.concat("        OR (:dtinicio BETWEEN a.id.dthrentrada AND a.id.dthrsaida) ");
				HQL = HQL.concat("        OR (a.id.dthrsaida IS NULL)  )");
				HQL = HQL.concat("  AND a.id.cdinjetora =:cdinjetora");
				HQL = HQL.concat(" ORDER BY a.id.dthrentrada DESC ");
						
				try
				{
					q = getDaoSession().createQuery(HQL);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}

				q.setTimestamp("dtinicio", inicioTurno);
				q.setTimestamp("dtfim", fimTurno);
				q.setString("cdinjetora", filtro.getCdMaquina());
				
				try
				{
					listIjentsaiopmaq = q.list();
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}

				if (q.list().size() == 0)
				{
					retorno.getIjtbinj().setAguardandomolde(BigDecimal.ONE);
				}
				else
				{
					retorno.getIjtbinj().setAguardandomolde(BigDecimal.ZERO);
					
					Object[] registro = (Object[]) listIjentsaiopmaq.iterator().next();
					Date dthrEnt = (Date) registro[0];
					Date dthrSai = (Date) registro[1]; 
										
					if (dthrSai == null)
					{
						if (DataHoraRN.compareTo(dthrEnt, fimTurno) > 0)
						{
							retorno.getIjtbinj().setAguardandomolde(BigDecimal.ONE);
						}
					}
				}
			}
		}


		// Calcular indicadores
		Float ip = FormulasInjet.calcularIndiceParada(tempoParada, tempoAtivo).floatValue();
		Float ir = FormulasInjet.calcularIndiceRefugo(producaoRefugada, producaoBruta);
		Float er = FormulasInjet.calcularEficienciaRealizacao(producaoLiquida, producaoPrevista).floatValue();
		Float ec = FormulasInjet.calcularEficienciaCiclo(cicloPadrao, cicloMedio);
		Float euc = 0f;
		Float ipd = FormulasInjet.calcularIndicePerda(perdaCiclo, perdaParada, producaoRefugada, perdaCavidade, producaoPrevista);

		if (retorno.getCorFrente() == MaquinaInjetDTO.FRENTE_FORAMETA || retorno.getCorFrente() == MaquinaInjetDTO.FRENTE_NAMETA)
			FormulasInjet.calcularEficienciaCiclo(cicloPadrao, retorno.getMaquinaTotalDTO().getUltimoCiclo());

		// finaliza DTO
		maquinaTotalDTO.setTempoAtivoSegundos(tempoAtivo);
		maquinaTotalDTO.setTempoParadaSegundos(tempoParada);
		maquinaTotalDTO.setTempoParadaSemPesoSegundos(tempoParadaSemPeso);
		maquinaTotalDTO.setIndiceParada(ip);
		maquinaTotalDTO.setTempoPerdaCicloSegundos(tempoRitmo);
		maquinaTotalDTO.setPerdaParadasUnidade(perdaParada);
		maquinaTotalDTO.setPerdaParadasKq(perdaParadaKg);
		maquinaTotalDTO.setPerdaCicloUnidade(perdaCiclo);
		maquinaTotalDTO.setPerdaCicloKq(perdaCicloKg);
		maquinaTotalDTO.setPerdaParadasSemPesoKg(perdaParadaSemPesoKg);
		maquinaTotalDTO.setPerdaParadasSemPesoUnidade(perdaParadaSemPeso);
		maquinaTotalDTO.setProducaoBrutaUnidade(producaoBruta);
		maquinaTotalDTO.setProducaoLiquidaUnidade(producaoLiquida);
		maquinaTotalDTO.setProducaoRefugadaUnidade(producaoRefugada);
		maquinaTotalDTO.setProducaoPrevistaUnidade(producaoPrevista);
		maquinaTotalDTO.setProducaoBrutaKg(producaoBrutaKg);
		maquinaTotalDTO.setProducaoLiquidaKg(producaoLiquidaKg);
		maquinaTotalDTO.setProducaoPrevistaKg(producaoPrevistaKg);
		maquinaTotalDTO.setProducaoRefugadaKg(producaoRefugadaKg);
		maquinaTotalDTO.setIndiceRefugo(ir);
		maquinaTotalDTO.setEficienciaRealizacao(er);
		maquinaTotalDTO.setEficienciaCiclo(ec);
		maquinaTotalDTO.setEficienciaUltimoCiclo(euc);
		maquinaTotalDTO.setPerdaCicloCusto(perdaCicloCusto);
		maquinaTotalDTO.setPerdaParadaCusto(perdaParadaCusto);
		maquinaTotalDTO.setProducaoRefugadaCusto(producaoRefugadaCusto);
		maquinaTotalDTO.setTempoCicloImprodutivoSegundos(tempoCicloImprodutivo);
		maquinaTotalDTO.setTempoCicloProdutivoSegundos(tempoCicloProdutivo);
		maquinaTotalDTO.setTempoCorrecaoCTT(tempoCtt);
		maquinaTotalDTO.setTempoRefugoSegundos(tempoRefugo);
		maquinaTotalDTO.setTempoRitmoSegundos(tempoRitmo);
		maquinaTotalDTO.setTempoTrabalhadoSegundos(tempoCicloProdutivo.add(tempoCicloImprodutivo).add(tempoCtt));
		maquinaTotalDTO.setTempoDisponiveisSegundos(maquinaTotalDTO.getTempoTrabalhadoSegundos().add(tempoParada));
		maquinaTotalDTO.setTempoProdutivasSegundos(tempoCicloProdutivo.subtract(tempoRefugo).subtract(tempoRitmo).subtract(tempoPerdaCavidade));
		maquinaTotalDTO.setPerdaCavidadeUnidade(perdaCavidade);
		maquinaTotalDTO.setTempoPerdaCavidadeSegundos(tempoPerdaCavidade);
		maquinaTotalDTO.setIndicePerda(ipd);
		maquinaTotalDTO.setCicloMedio(cicloMedio);
		maquinaTotalDTO.setCicloPadrao(cicloPadraoIndependenteCicloMedio);
		maquinaTotalDTO.setQtInjNormal(qtInjNormal);
		maquinaTotalDTO.setQtCicloPadraoDiferentes(qtCicloPadraoDiferentes);
		//		maquinaTotalDTO.setPci(pci);
		//		maquinaTotalDTO.setIndiceCavidadeAtiva(indiceCavidadeAtiva);
		//		maquinaTotalDTO.setTempoCavidadeIsoladasSegundos(tempoCavidadeIsoladasSegundos);
		maquinaTotalDTO.setQtCiclosPrevistos(qtCiclosPrevistos);
		
		retorno.setMaquinaTotalDTO(maquinaTotalDTO);
		retorno.setDthrITurno(inicioTurno);
		retorno.setDthrFTurno(fimTurno);

		if (filtro.getIsProcessarDetalheMaquina())
			processarDetalheMaquina(retorno);

		// Marcos Sardinha: 2015-06-24
		if (filtro.getIsProcessarTempoReal() && isTempoReal)
			processarTempoReal(retorno);

		// Ajuda ao Garbage collector
		ip = null;
		ir = null;
		er = null;
		ec = null;
		ipd = null;
		inicioPeriodo = null;
		fimPeriodo = null;
		cdTurnoInicial = null;
		cdTurnoFinal = null;
		ijcnsturnoAnterior = null;
		producaoRefugadaCusto = null;
		producaoPrevistaCusto = null;

		cicloMedio = null;
		cicloPadrao = null;
		qtInjNormal = null;
		tempoAtivo = null;
		tempoParada = null;
		tempoParadaSemPeso = null;
		tempoCicloProdutivo = null;
		tempoCicloImprodutivo = null;
		tempoRefugo = null;
		tempoRitmo = null;
		tempoCtt = null;
		tempoPerdaCavidade = null;
		tempoPerdaCiclo = null;

		perdaParada = null;
		perdaParadaSemPeso = null;
		perdaCiclo = null;
		perdaCavidade = null;

		perdaParadaKg = null;
		perdaParadaSemPesoKg = null;
		perdaCicloKg = null;

		perdaParadaCusto = null;
		perdaParadaSemPesoCusto= null;
		perdaCicloCusto = null;

		producaoBruta = null;
		producaoLiquida = null;
		producaoRefugada = null;
		producaoPrevista = null;

		producaoBrutaKg = null;
		producaoLiquidaKg = null;
		producaoRefugadaKg = null;
		producaoPrevistaKg = null;
		producaoBrutaCusto = null;
		listIjcnsturno = null;

		qtCiclosPrevistos = null;
		
		return retorno;
	}
	
	public Ijfictec pesquisarIjfictecAPartirDeIjreapar(Ijreapar ijreapar) throws RegistroDesconhecidoException{
		Criterion[] listaCriterion = {
				Expression.eq("id.cdinjetora", ijreapar.getId().getCdinjetora()),
				Expression.eq("id.cdmolde", ijreapar.getIjestmol().getId().getCdmolde()),
				Expression.eq("id.cdestrutura", ijreapar.getIjestmol().getId().getCdestrutura()),
				Expression.eq("id.dthrivalcic", ijreapar.getDthrivalcic())
		};
		List<Ijfictec> listaIjfictec = getDao().findByCriteria(Ijfictec.class, listaCriterion);
		if(listaIjfictec.size()==0){
			throw new RegistroDesconhecidoException();
		}
		return listaIjfictec.get(0);
	}

	public List<Ijmolpro> pesquisarListaIjmolproAPartirDeIjcnsturno(Ijcnsturno ijcnsturno){
		Criterion[] listaCriterion = {
				Expression.eq("id.cdmolde", ijcnsturno.getId().getCdmolde()),
				Expression.eq("id.cdestrutura", ijcnsturno.getId().getCdestrutura()),
				Expression.eq("id.dthrival", ijcnsturno.getId().getDthrivalestru())
		};

		List<Ijmolpro> listIjmolpro = getDao().findByCriteria(Ijmolpro.class, listaCriterion);

		return listIjmolpro;
	}

	public CavidadePesoInjetDTO totalizaListaIjmolproAPartirDeIjreapar(Ijreapar ijreapar, FiltroMaquinaInjetDTO filtro){
		IjcnsturnoId id = new IjcnsturnoId();
		id.setCdmolde(ijreapar.getIjestmol().getId().getCdmolde());
		id.setCdestrutura(ijreapar.getIjestmol().getId().getCdestrutura());
		id.setDthrivalestru(ijreapar.getDthrivalestru());
		Ijcnsturno ijcnsturno = new Ijcnsturno();
		ijcnsturno.setId(id);

		List<Ijmolpro> listIjmolpro = pesquisarListaIjmolproAPartirDeIjcnsturno(ijcnsturno);

		Integer qtcavidadesAtivas = 0;
		Integer qtcavidades = 0;
		BigDecimal pesoBruto = new BigDecimal(0);
		BigDecimal pesoLiquido = new BigDecimal(0);
		BigDecimal custo = new BigDecimal(0);

		for (Ijmolpro ijmolpro : listIjmolpro){
			if (filtro.getCdProduto() == null || filtro.getCdProduto().equals("") || filtro.getCdProduto().equals(ijmolpro.getId().getCdproduto())){
				qtcavidadesAtivas += ijmolpro.getQtcavativas().intValue();
				qtcavidades += ijmolpro.getQtcavidades().intValue();
				pesoBruto = pesoBruto.add(new BigDecimal(ijmolpro.getPbrutomedio()));
				pesoLiquido = pesoLiquido.add(new BigDecimal(ijmolpro.getPliquidomedio()));
				custo = custo.add(new BigDecimal(ijmolpro.getIjtbpro().getVlproduto().doubleValue() * ijmolpro.getQtcavativas()));
			}
		}

		CavidadePesoInjetDTO retorno = new CavidadePesoInjetDTO();
		retorno.setCusto(custo);
		retorno.setPesoBruto(pesoBruto);
		retorno.setPesoLiquido(pesoLiquido);
		retorno.setQtcavidades(qtcavidades);
		retorno.setQtcavidadesAtivas(qtcavidadesAtivas);

		return retorno;
	}

	public Integer totalizaListaIjmolproAPartirDeIjreapar(Ijreapar ijreapar){
		IjcnsturnoId id = new IjcnsturnoId();
		id.setCdmolde(ijreapar.getIjestmol().getId().getCdmolde());
		id.setCdestrutura(ijreapar.getIjestmol().getId().getCdestrutura());
		id.setDthrivalestru(ijreapar.getDthrivalestru());
		Ijcnsturno ijcnsturno = new Ijcnsturno();
		ijcnsturno.setId(id);

		return totalizaListaIjmolproAPartirDeIjcnsturno(ijcnsturno);
	}

	public Integer totalizaListaIjmolproAPartirDeIjcnsturno(Ijcnsturno ijcnsturno){
		List<Ijmolpro> listIjmolpro = pesquisarListaIjmolproAPartirDeIjcnsturno(ijcnsturno);

		Integer qtcavidadesAtivas = 0;
		Integer qtcavidades = 0;

		for (Ijmolpro ijmolpro : listIjmolpro){
			qtcavidadesAtivas += ijmolpro.getQtcavativas().intValue();
			qtcavidades += ijmolpro.getQtcavidades().intValue();
		}

		return qtcavidadesAtivas;
	}

	public BigDecimal obterTempoPlanejadoSetup(Ijreapar ijreapar){
		BigDecimal retorno = null;

		String hql = "";

		hql += "from IjmatrizSetup ijmatrizsetup ";
		hql += "where ijmatrizsetup.id.cdinjetora = '::cdinjetora' ";
		hql += "and ijmatrizsetup.id.cdMoldeSai = '::cdmoldesai' ";
		hql += "and ijmatrizsetup.id.cdMoldeEntra = '::cdmoldeentra' ";

		hql = hql.replaceAll("::cdinjetora", ijreapar.getId().getCdinjetora());
		hql = hql.replaceAll("::cdmoldesai", ijreapar.getIjestmol().getId().getCdmolde());
		hql = hql.replaceAll("::cdmoldeentra", ijreapar.getCdmoldeentrada());

		Query q = getDaoSession().createQuery(hql);

		List<Ijmatrizsetup> listaIjmatrizsetup = null;

		listaIjmatrizsetup = q.list();

		if (listaIjmatrizsetup.size() > 0)
			retorno = new BigDecimal(listaIjmatrizsetup.get(0).getTemposetup());


		return retorno;
	}

	public Ijtbpar pesquisarIjtbpar(String cdparada){
		Ijtbpar retorno = null;
		MapQuery q = new MapQuery(getDaoSession());
		q.append("from Ijtbpar ijtbpar ");
		q.append("where ijtbpar.cdparada = :cdparada");
		q.defineParametro("cdparada", cdparada);
		q.setMaxResults(1);
		retorno = (Ijtbpar) q.uniqueResult();
		return retorno;
	}

	private CavidadePesoInjetDTO totalizaListaIjmolproAPartirDeIjcnsturno(Ijcnsturno ijcnsturno, FiltroMaquinaInjetDTO filtro){
		Set<Ijmolpro> listIjmolpro = ijcnsturno.getIjmolpros(); //pesquisarListaIjmolproAPartirDeIjcnsturno(ijcnsturno);

		Integer qtcavidadesAtivas = 0;
		Integer qtcavidades = 0;
		BigDecimal pesoBruto = new BigDecimal(0);
		BigDecimal pesoLiquido = new BigDecimal(0);
		BigDecimal custo = new BigDecimal(0);

		for (Ijmolpro ijmolpro : listIjmolpro){
			if (filtro.getCdProduto() == null || filtro.getCdProduto().equals("") || filtro.getCdProduto().equals(ijmolpro.getId().getCdproduto())){
				qtcavidadesAtivas += ijmolpro.getQtcavativas().intValue();
				qtcavidades += ijmolpro.getQtcavidades().intValue();
				pesoBruto = pesoBruto.add(new BigDecimal(ijmolpro.getPbrutomedio()));
				pesoLiquido = pesoLiquido.add(new BigDecimal(ijmolpro.getPliquidomedio()));
				custo = custo.add(new BigDecimal(ijmolpro.getIjtbpro().getVlproduto().doubleValue() * ijmolpro.getQtcavativas()));
			}
		}

		CavidadePesoInjetDTO retorno = new CavidadePesoInjetDTO();
		retorno.setCusto(custo);
		retorno.setPesoBruto(pesoBruto);
		retorno.setPesoLiquido(pesoLiquido);
		retorno.setQtcavidades(qtcavidades);
		retorno.setQtcavidadesAtivas(qtcavidadesAtivas);

		return retorno;
	}

	private CavidadePesoInjetDTO ijmolproAPartirDeIjcnsturnodetref(Ijcnsturno ijcnsturno, Ijcnsturnodetref ijcnsturnodetref){
		// Linha abaixo desativada pois ijcnsturno ja possui a relacao dos produtos.
		//		List<Ijmolpro> listIjmolpro = pesquisarListaIjmolproAPartirDeIjcnsturnodetref(ijcnsturnodetref);

		Integer qtcavidadesAtivas = 0;
		Integer qtcavidades = 0;
		BigDecimal pesoBruto = new BigDecimal(0);
		BigDecimal pesoLiquido = new BigDecimal(0);
		BigDecimal custo = new BigDecimal(0);

		for (Ijmolpro ijmolpro : ijcnsturno.getIjmolpros()){
			// A quantidade de cavidades ativas deve retornar o total ao inves apenas das ativas do produto
			// isso eh necessario pois sera calculado o tempo do refugo
			qtcavidadesAtivas += ijmolpro.getQtcavativas().intValue();
			qtcavidades += ijmolpro.getQtcavidades().intValue();
			if (ijmolpro.getCdidentificacao().equals(ijcnsturnodetref.getId().getCdidentificacao())){
				pesoBruto = pesoBruto.add(new BigDecimal(ijmolpro.getPbrutomedio()));
				pesoLiquido = pesoLiquido.add(new BigDecimal(ijmolpro.getPliquidomedio()));
				custo = custo.add(new BigDecimal(ijmolpro.getIjtbpro().getVlproduto().doubleValue() *ijmolpro.getQtcavativas()));
			}
		}

		CavidadePesoInjetDTO retorno = new CavidadePesoInjetDTO();
		retorno.setCusto(custo);
		retorno.setPesoBruto(pesoBruto);
		retorno.setPesoLiquido(pesoLiquido);
		retorno.setQtcavidades(qtcavidades);
		retorno.setQtcavidadesAtivas(qtcavidadesAtivas);

		return retorno;



	}

	private RefugoTempoInjetDTO totalizaListaIjcnsturnodetrefAPartirDeIjcnsturno(List<Ijcnsturno> listaIjcnsturno, Ijcnsturno ijcnsturno,
			FiltroMaquinaInjetDTO filtro){

		RefugoTempoInjetDTO refugoTempo = new RefugoTempoInjetDTO();

		Character cdIdentificacao = null;

		// Encontra cdProduto se existir
		for (Ijmolpro ijmolpro : ijcnsturno.getIjmolpros()){
			if (filtro.getCdProduto() != null && 
					!filtro.getCdProduto().equals("") &&
					filtro.getCdProduto().equals(ijmolpro.getId().getCdproduto())){
				cdIdentificacao = ijmolpro.getCdidentificacao().charAt(0);
			}
		}

		for (Ijcnsturnodetref ijcnsturnodetref : ijcnsturno.getIjcnsturnodetrefs()){
			if (filtro.getCdProduto() == null || filtro.getCdProduto().equals("") || cdIdentificacao.equals(ijcnsturnodetref.getId().getCdidentificacao())){
				refugoTempo.addProducaoRefugada(new BigDecimal(ijcnsturnodetref.getQtpcsref()));

				CavidadePesoInjetDTO cavidadePeso = ijmolproAPartirDeIjcnsturnodetref(ijcnsturno, ijcnsturnodetref);

				Integer qtcavidadesAtivas = cavidadePeso.getQtcavidadesAtivas();
				//				Integer qtcavidades = cavidadePeso.getQtcavidades();
				BigDecimal pesoBruto = cavidadePeso.getPesoBruto();
				//				BigDecimal pesoLiquido = cavidadePeso.getPesoLiquido();
				BigDecimal custo = cavidadePeso.getCusto();

				BigDecimal producaoRefugadaKgIjcnsturnodetref = new BigDecimal(ijcnsturnodetref.getQtpcsref());
				producaoRefugadaKgIjcnsturnodetref = producaoRefugadaKgIjcnsturnodetref.multiply(pesoBruto);
				producaoRefugadaKgIjcnsturnodetref = producaoRefugadaKgIjcnsturnodetref.multiply(new BigDecimal(1000));
				refugoTempo.addProducaoRefugadaKg(producaoRefugadaKgIjcnsturnodetref);
				BigDecimal producaoRefugadaCustoIjcnsturnodetref = new BigDecimal(ijcnsturnodetref.getQtpcsref());
				producaoRefugadaCustoIjcnsturnodetref = producaoRefugadaCustoIjcnsturnodetref.multiply(custo);
				refugoTempo.addtProducaoRefugadaCusto(producaoRefugadaCustoIjcnsturnodetref);

				BigDecimal tempoRefugoIjcnsturnodetref = new BigDecimal(ijcnsturnodetref.getQtpcsref());
				tempoRefugoIjcnsturnodetref = tempoRefugoIjcnsturnodetref.multiply(encontrarCicloMedioAPartirDaListaIjcnsturno(
						listaIjcnsturno, 
						ijcnsturno));
				if (qtcavidadesAtivas > 0)
					tempoRefugoIjcnsturnodetref = tempoRefugoIjcnsturnodetref.divide(new BigDecimal(qtcavidadesAtivas), 100, BigDecimal.ROUND_HALF_EVEN);
				//				else
				//				tempoRefugoIjcnsturnodetref = new BigDecimal(0);

				refugoTempo.addTempoRefugo(tempoRefugoIjcnsturnodetref);
			}
		}

		return refugoTempo;
	}
	
	private BigDecimal encontrarCicloMedioAPartirDaListaIjcnsturno(List<Ijcnsturno> listIjcnsturno, Ijcnsturno ijcnsturno){
		BigDecimal tmpcicnormal = new BigDecimal(0);
		BigDecimal qtinjnormal = new BigDecimal(0);
		for (Ijcnsturno reg : listIjcnsturno){
			if (reg.getId().getCdinjetora().equals(ijcnsturno.getId().getCdinjetora()) &&
					reg.getId().getCdmolde().equals(ijcnsturno.getId().getCdmolde()) &&
					reg.getId().getCdestrutura().equals(ijcnsturno.getId().getCdestrutura()) &&
					DataHoraRN.equals(reg.getId().getDthrivalestru(), ijcnsturno.getId().getDthrivalestru()) &&
					reg.getId().getDthrivalcic().equals(ijcnsturno.getId().getDthrivalcic())){
				reg.setIsConsideraCorrecaoTempo(ijcnsturno.getIsConsideraCorrecaoTempo());
				tmpcicnormal = tmpcicnormal.add(reg.pegarTmpCicNormalConsiderandoCorrecao());
				qtinjnormal = qtinjnormal.add(new BigDecimal(reg.getQtinjnormal()));
			}
		}
		return FormulasInjet.calcularCicloMedio(tmpcicnormal, qtinjnormal);
	}

	private List<CicloInjetDTO> pesquisarCiclos(Ijtbinj ijtbinj) throws RegistroDesconhecidoException{
		String hql = "";

		hql += "from Ijreacic ijreacic ";
		hql += "where ijreacic.id.cdinjetora = '::cdinjetora' ";
		hql += "order by ijreacic.id.dthriciclo desc ";

		hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());

		Query q = getDaoSession().createQuery(hql);

		List<Ijreacic>	listaIjreacic = q.list();

		if (listaIjreacic.size() <= 0)
			throw new RegistroDesconhecidoException();

		List<CicloInjetDTO> retorno = new ArrayList<CicloInjetDTO>();
		for (Ijreacic ijreacic : listaIjreacic){
			CicloInjetDTO ciclo = new CicloInjetDTO();
			ciclo.setDthriciclo(ijreacic.getDthrivalcic());
			ciclo.setDthriciclo(ijreacic.getDthrfciclo());
			ciclo.setDuracao(ijreacic.getTeciclo().floatValue());
			ciclo.setCiclopadrao(ijreacic.getCiclopadrao().floatValue());
			ciclo.setEficienciaCiclo(FormulasInjet.calcularEficienciaCiclo(new BigDecimal(ijreacic.getCiclopadrao()), new BigDecimal(ijreacic.getTeciclo())));
			retorno.add(ciclo);
		}

		return retorno;
	}

	private void processarTempoReal(MaquinaInjetDTO maquinaDTO){
		// Obtem lingua default
		DiversosInjetRN divrn = new DiversosInjetRN(getDao());
		divrn.setDaoSession(getDaoSession());
		String cdLingua = "";
		try {
			cdLingua = divrn.getCdLingua();
		} catch (StringIndexOutOfBoundsException e) {
			cdLingua = "000000";
		}
		maquinaDTO.setCdLingua(cdLingua);

		// Obtem o ultimo ciclo e os ultimos ciclos
		BigDecimal ultimoCiclo = null;
		List<CicloInjetDTO> ciclos = null;
		try {
			ciclos = pesquisarCiclos(maquinaDTO.getIjtbinj());
		} catch (RegistroDesconhecidoException e1) {
			ciclos = new ArrayList<CicloInjetDTO>();
			ultimoCiclo = new BigDecimal(0);
		}
		if (ciclos.size() >= 1)
			ultimoCiclo = new BigDecimal(ciclos.get(0).getDuracao()); 

		maquinaDTO.setCiclos(ciclos);
		maquinaDTO.getMaquinaTotalDTO().setUltimoCiclo(ultimoCiclo);

		// Obtem dados do planejamento carregado em maquina
		PlanejamentoInjetRN plarn = new PlanejamentoInjetRN(getDao());
		plarn.setDaoSession(getDaoSession());
		try {
			maquinaDTO.setMaquinaPlanejamentoDTO(plarn.analisarPlanejamento(maquinaDTO));
		} catch (RegistroDesconhecidoException e1) {
			maquinaDTO.setMaquinaPlanejamentoDTO(new MaquinaPlanejamentoInjetDTO());
		}

		// Obtem dados de parametros default
		Ijindiceselabels ijindiceselabels = null;;
		try {
			ijindiceselabels = divrn.pesquisarIjindiceselabels(cdLingua);
		} catch (RegistroDesconhecidoException e) {
			ijindiceselabels = new Ijindiceselabels();
			ijindiceselabels.setEficciclo(new BigDecimal(100));
			ijindiceselabels.setEficrealizacao(new BigDecimal(85));
		}

		BigDecimal eo_padrao = ijindiceselabels.getEficrealizacao();
		BigDecimal ec_padrao = ijindiceselabels.getEficciclo();


		Ijconger ijconger = divrn.pesquisarListaIjconger().get(0);
		BigDecimal ir_padrao = null;
		
		if (ijconger != null)
			ir_padrao = new BigDecimal(ijconger.getId().getIndrefmaiorque());
		else
			ir_padrao = new BigDecimal(5);

		maquinaDTO.setEc_padrao(ec_padrao);
		maquinaDTO.setEo_padrao(eo_padrao);
		maquinaDTO.setIr_padrao(ir_padrao);

		// Processar as cores de frente
		int corFrente = MaquinaInjetDTO.FRENTE_NAMETA;
		int corFundo = 0;

		System.out.println("st Funcionamento = " + maquinaDTO.getIjtbinj().getStfuncionamento());
		if (maquinaDTO.getIjtbinj().getStfuncionamento() != null && maquinaDTO.getIjtbinj().getStfuncionamento().equals("2") ){
			System.out.println(" st func = 2");
			corFrente = MaquinaInjetDTO.FRENTE_SEMCONEXAO;
			corFundo = MaquinaInjetDTO.FUNDO_VAZIO;
		} else if (maquinaDTO.getIjtbinj().getStfuncionamento() != null && maquinaDTO.getIjtbinj().getStfuncionamento().equals("0") ){
			System.out.println(" st func = 0");
			corFrente = MaquinaInjetDTO.FRENTE_PARADA; 
		} else if (
				maquinaDTO.getMaquinaTotalDTO().getEficienciaRealizacao() <= eo_padrao.floatValue() ||
				maquinaDTO.getMaquinaTotalDTO().getEficienciaCiclo() <= ec_padrao.floatValue() ||
				maquinaDTO.getMaquinaTotalDTO().getEficienciaUltimoCiclo() <= ec_padrao.floatValue()){
			corFrente = MaquinaInjetDTO.FRENTE_FORAMETA;
		}

		if (
				maquinaDTO.getIjtbinj().getIjtbpar() != null &&
				maquinaDTO.getIjtbinj().getIjtbpar().getSaidademolde() != null &&
				maquinaDTO.getIjtbinj().getStfuncionamento() != null &&
				maquinaDTO.getIjtbinj().getStfuncionamento().equals("0") && 
				maquinaDTO.getIjtbinj().getIjtbpar().getSaidademolde().equals(BigDecimal.ZERO)){
			
			corFundo= MaquinaInjetDTO.FUNDO_PARADASEMPESO; 
		} else if (maquinaDTO.getIjtbinj().getAguardandomolde() != null && maquinaDTO.getIjtbinj().getAguardandomolde().equals(BigDecimal.ONE)){
			corFundo = MaquinaInjetDTO.FUNDO_AGUARDANDOMOLDE;
		} else if (
				maquinaDTO.getIjtbinj().getIjtbpar() != null &&
				maquinaDTO.getIjtbinj().getStfuncionamento() != null &&
				maquinaDTO.getIjtbinj().getStfuncionamento().equals("0") && 
				maquinaDTO.getIjtbinj().getIjtbpar().getCdparada() != null &&
				maquinaDTO.getIjtbinj().getIjtbpar().getCdparada().equals("999999")){
			corFundo = MaquinaInjetDTO.FUNDO_PARADANAOINFORMADA;
		} else if (maquinaDTO.getMaquinaPlanejamentoDTO().getIndiceProducao() >= 100 ){
			corFundo = MaquinaInjetDTO.FUNDO_OPCONCLUIDA;
		} else if (maquinaDTO.getMaquinaTotalDTO().getIndiceRefugo() >= ir_padrao.floatValue() ){
			corFundo = MaquinaInjetDTO.FUNDO_IRMAIOR;
		}else if (maquinaDTO.getIjtbinj().getMaquinaemalerta() != null && maquinaDTO.getIjtbinj().getMaquinaemalerta().equals(BigDecimal.ONE) ){
			corFundo = MaquinaInjetDTO.FUNDO_ALERTA;
		}
		// TODO Aqui o teste de iijalertainspecao

		// testa se a OP esta 90% concluida
		else if (maquinaDTO.getMaquinaPlanejamentoDTO().getIndiceProducao() >= eo_padrao.floatValue() ){
			corFundo = MaquinaInjetDTO.FUNDO_OPA90;
		} else
			corFundo = MaquinaInjetDTO.FUNDO_VAZIO;

		maquinaDTO.setCorFrente(corFrente);
		maquinaDTO.setCorFundo(corFundo);

		// Processa os alertas em aberto
		maquinaDTO.setAlertas(pesquisarAlertas(maquinaDTO.getIjtbinj()));
	}
	private List<AlertaInjetDTO> pesquisarAlertas(Ijtbinj ijtbinj){
		List<AlertaInjetDTO> retorno = new ArrayList<AlertaInjetDTO>();
		String hql = "";

		hql += "from Ijalertas ijalertas ";
		hql += "where ijalertas.id.cdinjetora = '::cdinjetora' ";
		hql += "and ijalertas.dthrfalerta = null ";

		hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());

		Query q = getDaoSession().createQuery(hql);

		List<Ijalertas>	listaIjalertas = q.list();

		for (Ijalertas ijalerta : listaIjalertas){
			AlertaInjetDTO alerta = new AlertaInjetDTO();
			alerta.copyIjalertas(ijalerta);
			retorno.add(alerta);
		}

		return retorno;
	}

	private void processarDetalheMaquina(MaquinaInjetDTO maquinaDTO){
		processarOperadoresLogados(maquinaDTO);
		processarParettoRefugos(maquinaDTO);
	}
	private void processarOperadoresLogados(MaquinaInjetDTO maquinaDTO){
		UsuarioInjetRN usuariosRN = new UsuarioInjetRN(getDao());
		usuariosRN.setDaoSession(getDaoSession());

		maquinaDTO.setOperadoresTurno(usuariosRN.getOperadoresLogadosNoTurno(maquinaDTO));
		maquinaDTO.setOperadoresAcumulado(usuariosRN.getOperadoresLogadosAcumulado(maquinaDTO));
	}
	private void processarParettoRefugos(MaquinaInjetDTO maquinaDTO){
		List<RefugoInjetDTO> refugos = new ArrayList<RefugoInjetDTO>();

		String hql = "";

		hql += "from Ijrearef ijrearef ";
		hql += "where ijrearef.id.cdinjetora = '::cdinjetora' ";
		hql += "and ijrearef.id.dthrirefugo between :dti and :dtf ";

		hql = hql.replaceAll("::cdinjetora", maquinaDTO.getIjtbinj().getCdinjetora());

		Query q = getDaoSession().createQuery(hql);

		q.setTimestamp("dti", maquinaDTO.getDthrITurno());
		q.setTimestamp("dtf", maquinaDTO.getDthrFTurno());

		List<Ijrearef>	listaIjrearef = q.list();

		for (Ijrearef ijrearef : listaIjrearef){
			RefugoInjetDTO refugo = new RefugoInjetDTO();
			refugo.setCdRefugo(ijrearef.getIjtbref().getCdrefugo());
			refugo.setDsRefugo(ijrearef.getIjtbref().getDsrefugo());
			refugo.setProducaoRefugada(new BigDecimal(ijrearef.getQtrefugada()));

			// Procura se o refugo ja existe em refugos
			boolean isExiste = false;
			for (RefugoInjetDTO refugoSearch : refugos){
				if (refugoSearch.equals(refugo)){
					isExiste = true;
					refugoSearch.addProducaoRefugada(refugo.getProducaoRefugada());
				}
			}
			if (isExiste == false)
				refugos.add(refugo);
		}

		maquinaDTO.setRefugos(refugos);
	}
	public List<Ijcnsmaqop> pesquisarListaIjcnsmaqopAPartirDeIjop(Ijop ijop){
		Criterion[] listaCriterion = {
				Expression.eq("id.nrop", ijop.getNrop()),
		};

		List<Ijcnsmaqop> listaIjcnsmaqop = getDao().findByCriteria(Ijcnsmaqop.class, listaCriterion);

		return listaIjcnsmaqop;
	}
	public CavidadePesoInjetDTO totalizaListaIjmolproAPartirDeIjcnsmaqop(Ijcnsmaqop ijcnsmaqop){
		List<Ijmolpro> listIjmolpro = pesquisarListaIjmolproAPartirDeIjcnsmaqop(ijcnsmaqop);

		Integer qtcavidadesAtivas = 0;
		Integer qtcavidades = 0;
		BigDecimal pesoBruto = new BigDecimal(0);
		BigDecimal pesoLiquido = new BigDecimal(0);
		BigDecimal custo = new BigDecimal(0);

		for (Ijmolpro ijmolpro : listIjmolpro){
			qtcavidadesAtivas += ijmolpro.getQtcavativas().intValue();
			qtcavidades += ijmolpro.getQtcavidades().intValue();
			pesoBruto = pesoBruto.add(new BigDecimal(ijmolpro.getPbrutomedio()));
			pesoLiquido = pesoLiquido.add(new BigDecimal(ijmolpro.getPliquidomedio()));
			custo = custo.add(new BigDecimal(ijmolpro.getIjtbpro().getVlproduto().doubleValue() *ijmolpro.getQtcavativas()));
		}

		CavidadePesoInjetDTO retorno = new CavidadePesoInjetDTO();
		retorno.setCusto(custo);
		retorno.setPesoBruto(pesoBruto);
		retorno.setPesoLiquido(pesoLiquido);
		retorno.setQtcavidades(qtcavidades);
		retorno.setQtcavidadesAtivas(qtcavidadesAtivas);

		return retorno;
	}
	public List<Ijmolpro> pesquisarListaIjmolproAPartirDeIjcnsmaqop(Ijcnsmaqop ijcnsmaqop){
		Criterion[] listaCriterion = {
				Expression.eq("id.cdmolde", ijcnsmaqop.getId().getCdmolde()),
				Expression.eq("id.cdestrutura", ijcnsmaqop.getId().getCdestrutura()),
				Expression.eq("id.dthrival", ijcnsmaqop.getId().getDthrivalestru())
		};

		List<Ijmolpro> listIjmolpro = getDao().findByCriteria(Ijmolpro.class, listaCriterion);

		return listIjmolpro;
	}
	public RefugoTempoInjetDTO totalizaListaIjcnsmaqopdetrefAPartirDeIjcnsmaqop(Ijcnsmaqop ijcnsmaqop){

		// Obtem a producao Refugada
		String HQL = "";

		HQL += "select ijcnsmaqopdetref ";
		HQL += "from Ijcnsmaqopdetref ijcnsmaqopdetref ";
		HQL += "where ";
		HQL += "    ijcnsmaqopdetref.id.cdinjetora = '::cdmaquina' ";
		HQL += "and ijcnsmaqopdetref.id.nrop = '::nrop' ";
		HQL += "and ijcnsmaqopdetref.id.cdmolde = '::cdmolde' ";
		HQL += "and ijcnsmaqopdetref.id.cdestrutura = '::cdestrutura' ";
		HQL += "and ijcnsmaqopdetref.id.dthrivalestru = ? ";


		HQL = HQL.replaceAll("::cdmaquina", ijcnsmaqop.getId().getCdinjetora());
		HQL = HQL.replaceAll("::nrop", ijcnsmaqop.getId().getNrop());
		HQL = HQL.replaceAll("::cdmolde", ijcnsmaqop.getId().getCdmolde());
		HQL = HQL.replaceAll("::cdestrutura", ijcnsmaqop.getId().getCdestrutura());

		List<Ijcnsmaqopdetref> listIjcnsmaqopdetref;

		Query q = getDaoSession().createQuery(HQL);

		q.setTimestamp(0, ijcnsmaqop.getId().getDthrivalestru());

		listIjcnsmaqopdetref = q.list();

		RefugoTempoInjetDTO refugoTempo = new RefugoTempoInjetDTO();

		for (Ijcnsmaqopdetref ijcnsmaqopdetref : listIjcnsmaqopdetref){
			refugoTempo.addProducaoRefugada(new BigDecimal(ijcnsmaqopdetref.getQtpcsref()));

			BigDecimal qtCiclosRefugadosIjcnsmaqop = new BigDecimal(0);
			CavidadePesoInjetDTO cavidadePeso = totalizaListaIjmolproAPartirDeIjcnsmaqopdetref(ijcnsmaqopdetref);

			qtCiclosRefugadosIjcnsmaqop = qtCiclosRefugadosIjcnsmaqop.divide(new BigDecimal(cavidadePeso.getQtcavidadesAtivas()));

			refugoTempo.addQtCiclosRefugados(qtCiclosRefugadosIjcnsmaqop);
		}

		return refugoTempo;
	}
	public CavidadePesoInjetDTO totalizaListaIjmolproAPartirDeIjcnsmaqopdetref(Ijcnsmaqopdetref ijcnsmaqopdetref){
		List<Ijmolpro> listIjmolpro = pesquisarListaIjmolproAPartirDeIjcnsmaqopdetref(ijcnsmaqopdetref);

		Integer qtcavidadesAtivas = 0;
		Integer qtcavidades = 0;
		BigDecimal pesoBruto = new BigDecimal(0);
		BigDecimal pesoLiquido = new BigDecimal(0);
		BigDecimal custo = new BigDecimal(0);

		for (Ijmolpro ijmolpro : listIjmolpro){
			qtcavidadesAtivas += ijmolpro.getQtcavativas().intValue();
			qtcavidades += ijmolpro.getQtcavidades().intValue();
			pesoBruto = pesoBruto.add(new BigDecimal(ijmolpro.getPbrutomedio()));
			pesoLiquido = pesoLiquido.add(new BigDecimal(ijmolpro.getPliquidomedio()));
			custo = custo.add(new BigDecimal(ijmolpro.getIjtbpro().getVlproduto().doubleValue() *ijmolpro.getQtcavativas()));
		}

		CavidadePesoInjetDTO retorno = new CavidadePesoInjetDTO();
		retorno.setCusto(custo);
		retorno.setPesoBruto(pesoBruto);
		retorno.setPesoLiquido(pesoLiquido);
		retorno.setQtcavidades(qtcavidades);
		retorno.setQtcavidadesAtivas(qtcavidadesAtivas);

		return retorno;
	}
	public List<Ijmolpro> pesquisarListaIjmolproAPartirDeIjcnsmaqopdetref(Ijcnsmaqopdetref ijcnsmaqopdetref){
		Criterion[] listaCriterion = {
				Expression.eq("id.cdmolde", ijcnsmaqopdetref.getId().getCdmolde()),
				Expression.eq("id.cdestrutura", ijcnsmaqopdetref.getId().getCdestrutura()),
				Expression.eq("id.dthrival", ijcnsmaqopdetref.getId().getDthrivalestru()),
				Expression.eq("cdidentificacao", ijcnsmaqopdetref.getId().getCdidentificacao()),
		};

		List<Ijmolpro> listIjmolpro = getDao().findByCriteria(Ijmolpro.class, listaCriterion);

		return listIjmolpro;
	}
	public List<Ijtbinj> pesquisarListaMaquinasDeUmGrupo(String cdGrupoMaquina){
		Criterion[] listaCriterion = {
				Expression.eq("id.cdgrpinj", cdGrupoMaquina)
		};

		List<Ijgrpdetinj> listaIjgrpdetinj = getDao().findByCriteria(Ijgrpdetinj.class, listaCriterion);
		List<Ijtbinj> listaIjtbinj = new ArrayList<Ijtbinj>();
		for (Ijgrpdetinj ijgrpdetinj : listaIjgrpdetinj){
			listaIjtbinj.add(ijgrpdetinj.getIjtbinj());
		}

		return listaIjtbinj;
	}
}
