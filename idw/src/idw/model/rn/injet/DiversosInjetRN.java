package idw.model.rn.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmInd;
import idw.model.pojos.injet.Ijconger;
import idw.model.pojos.injet.Ijestmol;
import idw.model.pojos.injet.Ijgalobj;
import idw.model.pojos.injet.Ijgalobjgal;
import idw.model.pojos.injet.Ijgalobjgalmtrz;
import idw.model.pojos.injet.Ijgrpinj;
import idw.model.pojos.injet.Ijgrpmol;
import idw.model.pojos.injet.Ijindiceselabels;
import idw.model.pojos.injet.Ijlogope;
import idw.model.pojos.injet.Ijop;
import idw.model.pojos.injet.Ijrt;
import idw.model.pojos.injet.Ijtbfresh;
import idw.model.pojos.injet.Ijtbgal;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.Ijtbmol;
import idw.model.pojos.injet.Ijtbpro;
import idw.model.pojos.injet.Ijtbtur;
import idw.model.pojos.injet.Ijtreal;
import idw.model.pojos.injet.Ijusufilbi;
import idw.model.pojos.injet.Ijusufilgal;
import idw.model.pojos.injet.VMaqDataBi;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.dto.FiltroInjetDTO;
import idw.model.rn.injet.dto.MaquinaTotalInjetDTO;
import idw.util.Util;
import idw.webservices.dto.AlertaGalpaoDTO;
import idw.webservices.dto.AlertasGalpaoDTO;
import idw.webservices.dto.ConfiguracaoConcentrador;
import idw.webservices.dto.IwsAgendaDeParadaDTO;
import idw.webservices.dto.ListaIwsAgendaDeParadaDTO;
import idw.webservices.dto.ParadaGalpaoDTO;
import idw.webservices.dto.ParadasDTO;
import idw.webservices.dto.ParadasGalpaoDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.CfgParamConcOP;
import injetws.model.excessoes.RegistroDesconhecidoException;
import ms.util.ConversaoTipos;

@SuppressWarnings("unchecked")
public class DiversosInjetRN extends AbstractRN<DAOGenericoInjet>{

	public DiversosInjetRN() {
		super(new DAOGenericoInjet());
	}
	
	public DiversosInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}
	
	public Date getDtHrSistemaDeIjtreal(){
		Date retorno;
		Ijtreal ijtreal = pesquisarIjtreal();
		if (ijtreal.getId().getDthrsistema() == null)
			retorno = new Date();
		else
			retorno = ijtreal.getId().getDthrsistema();
		return retorno;
	}
	public Ijtreal pesquisarIjtreal(){
		Ijtreal retorno = new Ijtreal();

		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "from Ijtreal ijtreal ";

		List<Ijtreal> listaIjtreal = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			listaIjtreal = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		if (listaIjtreal != null && listaIjtreal.size() > 0)
			retorno = listaIjtreal.get(0);

		return retorno;
	}
	public List<Ijtbmol> pesquisarIjtbmol(){
		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "from Ijtbmol ijtbmol order by ijtbmol.id.cdmolde ";

		List<Ijtbmol> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		return lista;
	}
	
	public Ijtbmol pesquisarIjtbmol(String cdmolde) throws RegistroDesconhecidoException{
		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "from Ijtbmol ijtbmol where ijtbmol.id.cdmolde = '::cdmolde' ";
		HQL = HQL.replaceAll("::cdmolde", cdmolde);

		List<Ijtbmol> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		if (lista.size() <= 0)
			throw new RegistroDesconhecidoException();
		
		return lista.get(0);
	}
	
	public List<Ijtbfresh> getIjtbfresh(){
		List<Ijtbfresh> retorno = new ArrayList<Ijtbfresh>();
		
		String HQL ="";
		
		HQL+= "from Ijtbfresh a";
		
		Query q = getDaoSession().createQuery(HQL);

		try{
			retorno = (List<Ijtbfresh>) q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		return retorno;
	}

	public BigDecimal getQtdCiclosMonitorar(){
		BigDecimal retorno = new BigDecimal(50);
		
		String HQL ="";		
		HQL+= "SELECT a.id.qtcicarm from Ijconger a";		
		Query q = getDaoSession().createQuery(HQL);
		try{
			retorno = ConversaoTipos.converterParaBigDecimal(q.uniqueResult());
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public String getCdLingua(){
		Ijtbfresh ijtbfresh = getIjtbfresh().get(0);
		
		String cdLingua = "";
		
		cdLingua = ijtbfresh.getPk().getCampo16();
		
		//Marcos Sardinha: VFWEB - Injet
		//LicencaInjetRN rn = new LicencaInjetRN(); 
		//return rn.descriptar(cdLingua); // metodo bugado
		return SenhaRN.descriptografarSenha(cdLingua);
	}
	
	public Ijindiceselabels pesquisarIjindiceselabels(String cdLingua) throws RegistroDesconhecidoException{
		String hql = "";
		hql += "from Ijindiceselabels A ";
		hql += "where A.cdlingua = '::cdlingua' ";
		
		hql = hql.replaceAll("::cdlingua", cdLingua);
		
		Query q = getDaoSession().createQuery(hql);
		
		List<Ijindiceselabels> listaIjindiceselabels = q.list();
		
		if (listaIjindiceselabels.size() <= 0){
			throw new RegistroDesconhecidoException();
		}
		return listaIjindiceselabels.get(0);
	}
	public List<Ijconger> pesquisarListaIjconger(){
		List<Ijconger> listaIjconger = (List<Ijconger>) getDao().findAll(Ijconger.class);
		
		return listaIjconger;
	}
	
	public List<Ijtbinj> pesquisarIjtbinj(Ijtbinj filtro){
		String HQL = "";

		HQL += "from Ijtbinj t ";
		HQL += "join fetch t.ijgalobjs ijgalobjs where 1=1 ";
		
		if (filtro.getStinjetora() != null){
			HQL +="and t.stinjetora = ::stinjetora ";
		}		
		if (filtro.getIjgalobjs() != null){
			if (filtro.getIjgalobjs().size() > 0){	
				HQL +="and ijgalobjs.ijtbgal.cdgalpao = '::cdgalpao' ";
			}
		}
		
		HQL = HQL.replaceAll("::stinjetora", String.valueOf(filtro.getStinjetora())); 
		if (filtro.getIjgalobjs() != null){
			if (filtro.getIjgalobjs().size() > 0){	
				HQL = HQL.replaceAll("::cdgalpao", ((Ijgalobj)(filtro.getIjgalobjs().toArray()[0])).getIjtbgal().getCdgalpao());
			}
		}
		
		
		HQL += " order by t.cdinjestendido ";

		List<Ijtbinj> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}		
		
		return lista;
	}
	public List<Ijrt> pesquisarIjRT(Ijrt filtro){
		String HQL = "";

		HQL += "from Ijrt t where 1=1 ";
		if (filtro.getIjtbinj() != null){
			HQL +="and t.ijtbinj.cdinjetora = '::cdinjetora' ";
			HQL = HQL.replaceAll("::cdinjetora", String.valueOf(filtro.getIjtbinj().getCdinjetora()));
		}
		if (filtro.getDtReferencia() != null){
			HQL +="and t.dtReferencia = :dtReferencia ";
		}
		if (filtro.getIjtbtur() != null){
			HQL +="and t.ijtbtur.cdturno = '::cdturno' ";
			HQL = HQL.replaceAll("::cdturno", String.valueOf(filtro.getIjtbtur().getCdturno()));
		}
	
		List<Ijrt> lista = null;

		Query q = getDaoSession().createQuery(HQL);
		
		try {
			q.setDate("dtReferencia", filtro.getDtReferencia());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	public List<Ijtbtur> pesquisarIjtbtur(Ijtbtur filtro){
		String HQL = "";

		HQL += "from Ijtbtur t where 1=1 ";
		
		if (filtro.getCdturno() != null){
			HQL +="and t.cdturno = '::cdturno' ";
		}		
		
		HQL = HQL.replaceAll("::cdturno", String.valueOf(filtro.getCdturno())); 
		
		List<Ijtbtur> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}		
		
		return lista;
	}
	public List<Ijlogope> pesquisarIjlogope(Ijlogope filtro){
		String HQL = "";

		HQL += "from Ijlogope t where 1=1 ";
		if (filtro.getId().getCdinjetora() != null){
			HQL +="and t.id.cdinjetora = '::cdinjetora' ";
		}
		if (filtro.getDthrlogout() == null){
			HQL +="and t.dthrlogout is null ";
		}
		
		HQL = HQL.replaceAll("::cdinjetora", String.valueOf(filtro.getId().getCdinjetora()));
		
		List<Ijlogope> lista = null;

		Query q = getDaoSession().createQuery(HQL);		
		
		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	public List<Ijestmol> pesquisarIjestmol(Ijestmol filtro){
		String HQL = "";

		HQL += "from Ijestmol t where 1=1 ";
		
		if (filtro.getId().getCdmolde() != null){
			HQL +="and t.id.cdmolde = '::cdmolde' ";
		}		
		
		if (filtro.getId().getCdestrutura() != null){
			HQL +="and t.id.cdestrutura = '::cdestrutura' ";
		}
		
		if(filtro.getId() != null){
			HQL = HQL.replaceAll("::cdmolde", String.valueOf(filtro.getId().getCdmolde()));
			HQL = HQL.replaceAll("::cdestrutura", String.valueOf(filtro.getId().getCdestrutura()));
		} 
		
		List<Ijestmol> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}		
		
		return lista;
	}
	public List<VMaqDataBi> pesquisarVMaqDataBi(VMaqDataBi filtro){
		String HQL = "";

		HQL += "from VMaqDataBi t where 1=1 ";
		if (filtro.getIjtbinj().getCdinjetora() != null){
			HQL +="and t.ijtbinj.cdinjetora = '::cdinjetora' ";
		}
		if (filtro.getDtReferencia() != null){
			HQL +="and t.dtReferencia = :dtReferencia ";
		}
		if (filtro.getIjtbtur().getCdturno() != null){
			HQL +="and t.ijtbtur.cdturno = '::cdturno' ";
		}
	
		HQL = HQL.replaceAll("::cdinjetora", String.valueOf(filtro.getIjtbinj().getCdinjetora()));
		HQL = HQL.replaceAll("::cdturno", String.valueOf(filtro.getIjtbtur().getCdturno()));
		

		List<VMaqDataBi> lista = null;

		Query q = getDaoSession().createQuery(HQL);
		
		try {
			q.setDate("dtReferencia", filtro.getDtReferencia());
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	public MaquinaTotalInjetDTO getMediaTaxaUtilizacao(String cdInjetora, Integer ano, Integer mes){
		Date inicioP = DataHoraRN.getDataHoraAtual();
		String HQL = "";

		Date inicio = DataHoraRN.getInicioMes(ano, mes);
		Date fim = DataHoraRN.getFimMes(ano, mes);

//		HQL += "select  A.dtReferencia, sum(segTempoprodutivas) as soma_tempoprodutivas, sum(segTempodisponivel) as soma_tempodisponivel ";
		HQL += "select  sum(segTempotrabalhado) as soma_tempoprodutivas, sum(segTempodisponivel) as soma_tempodisponivel ";
		HQL += "from VMaqDataBi A ";
		HQL += "where A.ijtbinj.cdinjetora = '::cdinjetora' ";
		HQL += "and A.dtReferencia between :dtinicio and :dtfim ";
//		HQL += "and year(A.dtReferencia)= ::anoAvaliadoMesAtual ";
//		HQL += "and month(A.dtReferencia)= ::mesAvaliadoMesAtual ";
//		HQL += "group by A.dtReferencia";
		
		HQL = HQL.replaceAll("::cdinjetora", cdInjetora);
//		HQL = HQL.replaceAll("::anoAvaliadoMesAtual", String.valueOf(ano));
//		HQL = HQL.replaceAll("::mesAvaliadoMesAtual", String.valueOf(mes));
		
		List<Object[]> registro = null;

		Query q = getDaoSession().createQuery(HQL);				
		
			q.setParameter("dtinicio", inicio);
			q.setParameter("dtfim", fim);
		
		boolean isExecutou = false;
		while (isExecutou == false){
			try{
				registro = (List<Object[]>) q.list();
				isExecutou = true;
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		Double taxas = 0d;
		Double tTrab = 0d;
		Double tDisp = 0d;
		
		if (registro !=null && registro.size() > 0){
			for (Object[] objects : registro) {
				if (objects[1] !=null && ((BigDecimal)objects[1]).doubleValue() != 0){
					taxas+= ((BigDecimal)objects[0]).doubleValue() / ((BigDecimal)objects[1]).doubleValue();
					tTrab += ((BigDecimal)objects[0]).doubleValue();
					tDisp += ((BigDecimal)objects[1]).doubleValue();
				}
			}
			
			taxas = taxas / registro.size();
			taxas = tTrab / tDisp;
		}

		MaquinaTotalInjetDTO retorno = new MaquinaTotalInjetDTO();
		retorno.setTempoTrabalhadoSegundos(new BigDecimal(tTrab));
		retorno.setTempoDisponiveisSegundos(new BigDecimal(tDisp));
		retorno.setUtilizacao(taxas.floatValue());
		return retorno;
	}
	public List<Ijgalobjgal> pesquisarIjgalobjgal(Ijgalobjgal filtro){
		String HQL = "";

		HQL += "from Ijgalobjgal t where 1=1 ";
		if (filtro.getId() != null){
			HQL +="and t.id.cdgalpao = '::cdgalpao' ";
		}
		
		if (filtro.getId() != null){		
			HQL = HQL.replaceAll("::cdgalpao", filtro.getId().getCdgalpao());
		}

		List<Ijgalobjgal> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}		
		
		return lista;
	}
	public Double getOEEGalpao(String cdGalpao){
		String HQL = "";

		HQL += "select sum(segTempotrabalhado) as soma_tempotrabalhado, sum(segTempodisponivel) as soma_tempodisponivel ";
		HQL += "from VMaqDataBi A ";
		HQL += "where exists (from Ijgalobj b where b.id.cdinjetora = A.ijtbinj.cdinjetora and b.id.cdgalpao = '::cdGalpao' ) ";
		HQL += "and exists (from Ijtreal c where c.id.dtRefTurno = A.dtReferencia and c.id.cdTurno = A.ijtbtur.cdturno) ";		
		
		HQL = HQL.replaceAll("::cdGalpao", cdGalpao);
		
		Object[] registro = null;

		Query q = getDaoSession().createQuery(HQL);				
		
		try{
			registro = (Object[]) q.uniqueResult();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		Double oee = 0d;
		
		if (registro[0] != null && registro[1] != null){
			if (((BigDecimal)registro[1]).doubleValue() != 0){
				oee = (((BigDecimal)registro[0]).doubleValue() / ((BigDecimal)registro[1]).doubleValue())*100;
			}
		}	
				
		return oee;
	}	
	public List<Ijgalobjgalmtrz> pesquisarIjgalobjgalmtrz(Ijgalobjgalmtrz filtro){
		String HQL = "";

		HQL += "from Ijgalobjgalmtrz t where 1=1 ";
		if (filtro.getId() != null){
			HQL +="and t.id.cdgalpao = '::cdgalpao' ";
		}
		
		if (filtro.getId() != null){		
			HQL = HQL.replaceAll("::cdgalpao", filtro.getId().getCdgalpao());
		}

		List<Ijgalobjgalmtrz> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}		
		
		return lista;
	}
	public void salvarFiltro(FiltroInjetDTO filtro, int tpConsulta){

		// Pesquisa se pojos ja existem
		String hql = "";
		hql = "from Ijusufilbi ijusufilbi where ijusufilbi.tpConsulta = ::tpConsulta ";
		hql = hql.replaceAll("::tpConsulta", String.valueOf(tpConsulta));

		Query q = getDaoSession().createQuery(hql);

		Ijusufilbi ijusufilbi = (Ijusufilbi) q.uniqueResult();

		if (ijusufilbi == null)
			ijusufilbi = new Ijusufilbi();

		// Altera valores
		ijusufilbi.setAnoFinal(filtro.getAnoFinal());
		ijusufilbi.setAnoInicial(filtro.getAnoInicio());
		ijusufilbi.setDtFinal(filtro.getDtFim());
		ijusufilbi.setDtInicial(filtro.getDtInicio());
		ijusufilbi.setHrFinal(filtro.getHrFim());
		ijusufilbi.setHrInicial(filtro.getHrInicio());

		Ijgrpmol ijgrpmol = null;
		if (filtro.getCdMoldeGrupo() != null && !filtro.getCdMoldeGrupo().equals(""))
			ijgrpmol = null; //(Ijgrpmol) getDao().findById(Ijgrpmol.class, (Serializable) filtro.getCdMoldeGrupo(), false);
		ijusufilbi.setIjgrpmol(ijgrpmol);

		Ijgrpinj ijgrpinj = null;
		if (filtro.getCdMaquinaGrupo() != null && !filtro.getCdMaquinaGrupo().equals(""))
			ijgrpinj = null; //(Ijgrpinj) getDao().findById(Ijgrpinj.class, (Serializable) filtro.getCdMaquinaGrupo(), false);
		ijusufilbi.setIjgrpinj(ijgrpinj);

		Ijop ijop = null;
		if (filtro.getNrop() != null && !filtro.getNrop().equals(""))
			ijop = null; //(Ijop) getDao().findById(Ijop.class, (Serializable) filtro.getNrop(), false);
		ijusufilbi.setIjop(ijop);

		Ijtbinj ijtbinj = null;
		if (filtro.getCdMaquina() != null && !filtro.getCdMaquina().equals(""))
			ijtbinj = null; //(Ijtbinj) getDao().findById(Ijtbinj.class, (Serializable) filtro.getCdMaquina(), false);
		ijusufilbi.setIjtbinj(ijtbinj);

		Ijtbmol ijtbmol = null;
		if (filtro.getCdMolde() != null && !filtro.getCdMolde().equals(""))
			ijtbmol = null; //(Ijtbmol) getDao().findById(Ijtbmol.class, (Serializable) filtro.getCdMolde(), false);
		ijusufilbi.setIjtbmol(ijtbmol);

		Ijtbpro ijtbpro = null;
		if (filtro.getCdProduto() != null && !filtro.getCdProduto().equals(""))
			ijtbpro = null; //(Ijtbpro) getDao().findById(Ijtbpro.class, (Serializable) filtro.getCdProduto(), false);
		ijusufilbi.setIjtbpro(ijtbpro);

		Ijtbtur ijtbtur = null;
		if (filtro.getCdTurno() != null && !filtro.getCdTurno().equals(""))
			ijtbtur = null; //(Ijtbtur) getDao().findById(Ijtbtur.class, (Serializable) filtro.getCdTurno(), false);
		ijusufilbi.setIjtbtur(ijtbtur);

		ijusufilbi.setMesFinal((short) filtro.getMesFinal());
		ijusufilbi.setMesInicial((short) filtro.getMesInicio());
		ijusufilbi.setSemestre((short) filtro.getSemestre());
		ijusufilbi.setTpConsulta(tpConsulta);
		ijusufilbi.setTpDetalhe(filtro.getTipoDetalhe());
		ijusufilbi.setTpIndicador(filtro.getIndicador());
		ijusufilbi.setTpOrdenacao(filtro.getOrder());


		// Incluir novos registros
		try{
			ijusufilbi = (Ijusufilbi) getDao().makePersistent(ijusufilbi);
		} catch (Exception e){
			e.printStackTrace();
		}

		// Apagar registros atuais de ijusufilgal
		for (Ijusufilgal ijusufilgal : ijusufilbi.getIjusufilgals()){
			getDaoSession().delete(ijusufilgal);
		}
		ijusufilbi.setIjusufilgals(null);

		Set<Ijusufilgal> ijusufilgals = new HashSet<Ijusufilgal>();
		int ordem = 1;
		for (String cdGalpao : filtro.getGalpoes()){
			Ijusufilgal ijusufilgal = new Ijusufilgal();

			Ijtbgal ijtbgal = null;
			String cdGalpaoPesquisa = cdGalpao;

			if (cdGalpao.indexOf(" -") > 0)
				cdGalpaoPesquisa = cdGalpao.substring(0, cdGalpao.indexOf(" -"));

			GalpaoInjetRN galpaoRN = new GalpaoInjetRN(getDao());

			if (cdGalpao != null && !cdGalpao.equals(""))
				ijtbgal = galpaoRN.pesquisarIjtbgal(cdGalpaoPesquisa).get(0);

			ijusufilgal.setIjtbgal(ijtbgal);

			if (ijtbgal != null && ijtbgal.getCdgalpao() != null){
				ijusufilgal.setIjusufilbi(ijusufilbi);
				ijusufilgal.setOrdem(ordem);
				ordem++;
				ijusufilgal = (Ijusufilgal) getDao().makePersistent(ijusufilgal);
				ijusufilgals.add(ijusufilgal);

			}
		}

		//ijusufilbi.setIjusufilgals(ijusufilgals);
	}
	
	public OmCfgind getMetaEfiReaInjetToVF(BigDecimal valorDefault, String cdPt) {
		OmCfgind retorno = new OmCfgind();
		OmInd omind = new OmInd();		
		omind.setIdInd(1l);
		retorno.setOmInd(omind);
		retorno.setIdCfgind(1l);
		retorno.setIndMeta(valorDefault);

		//verifica se tem config especifica pra maquina
		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.eficrealizacao ");
		strSQL = strSQL.concat("  FROM ijinjcfgmetamonit a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE b.cdinjestendido = '" + cdPt + "'");
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		List<Object> listaReg = q.list();			

		Object reg = null;
		if (listaReg.size() > 0) {
			reg = listaReg.get(0);
			Object registroAux = (Object) reg;
			retorno.setIndMeta(ConversaoTipos.converterParaBigDecimal(registroAux));
		}			
		
		return retorno;
	}
	
	public OmCfgind getMetaEfiCicInjetToVF(BigDecimal valorDefault, String cdPt) {
		OmCfgind retorno = new OmCfgind();
		OmInd omind = new OmInd();		
		omind.setIdInd(2l);
		retorno.setOmInd(omind);		
		retorno.setIdCfgind(2l);
		retorno.setIndMeta(valorDefault);

		//verifica se tem config especifica pra maquina
		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.eficciclo ");
		strSQL = strSQL.concat("  FROM ijinjcfgmetamonit a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE b.cdinjestendido = '" + cdPt + "'");
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		List<Object> listaReg = q.list();			

		Object reg = null;
		if (listaReg.size() > 0) {
			reg = listaReg.get(0);
			Object registroAux = (Object) reg;
			retorno.setIndMeta(ConversaoTipos.converterParaBigDecimal(registroAux));
		}			
		
		return retorno;
	}

	public OmCfgind getMetaIndRefInjetToVF() {
		OmCfgind retorno = new OmCfgind();
		OmInd omind = new OmInd();
		omind.setIdInd(3l);
		retorno.setOmInd(omind);		
		retorno.setIdCfgind(3l);
		retorno.setIndMeta(new BigDecimal(3));

		//verifica se tem config especifica pra maquina
		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.indrefmaiorque ");
		strSQL = strSQL.concat("  FROM ijconger a ");
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		List<Object> listaReg = q.list();			

		Object reg = null;
		if (listaReg.size() > 0) {
			reg = listaReg.get(0);
			Object registroAux = (Object) reg;
			retorno.setIndMeta(ConversaoTipos.converterParaBigDecimal(registroAux));
		}			
		
		return retorno;
	}

	public PesquisasDTO pesquisaDwTRefugoInjetToVF(PesquisaDTO pesquisa) {
		String strSQL = "";
		// strSQL = strSQL.concat("SELECT t.cdrefugo, t.dsrefugo ");
		// 2019-09-20 Ailton, acrescentando as colunas lrequercausa e lrequeracao
		// para que essas informações sejam repassadas ao cliente solicitante
		strSQL = strSQL.concat("SELECT t.cdrefugo, t.dsrefugo, t.lrequercausa, t.lrequeracao ");
		strSQL = strSQL.concat("  FROM ijtbref t ");
		
		//strSQL = strSQL.concat(" WHERE 1 = 1 ");
		// 2019-09-20 Ailton, acrescentando a condicao de stativo =1
		strSQL = strSQL.concat(" WHERE stativo = 1 ");
		
		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			strSQL = strSQL.concat(" AND (t.cdrefugo = :cdTrefugo OR t.dsrefugo = :dsTrefugo ) ");
			
		} else if (!pesquisa.getCodigo().equals("")) {
			strSQL = strSQL.concat(" AND t.cdrefugo = :cdTrefugo ");
			
		} else if (!pesquisa.getDescricao().equals("")) {
			strSQL = strSQL.concat(" AND t.dsrefugo = :dsTrefugo ");
		}

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		
		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.setString("cdTrefugo", pesquisa.getCodigo())
			 .setString("dsTrefugo", pesquisa.getDescricao());
			
		} else if (!pesquisa.getCodigo().equals("")) {
			q.setString("cdTrefugo", pesquisa.getCodigo());
			
		} else if (!pesquisa.getDescricao().equals("")) {
			q.setString("dsTrefugo", pesquisa.getDescricao());
		}
		
		List<Object> lista = new ArrayList<Object>();
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (Object reg : lista) {
				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;

				PesquisaDTO itemDTO = new PesquisaDTO();
				try {
					itemDTO.setCodigo((String) registroLido[0]);
					itemDTO.setDescricao((String) registroLido[1]);
					if (registroLido[2].getClass().toString().contains("Integer") 
							&& registroLido[3].getClass().toString().contains("Integer")) {
						itemDTO.setRequercausa((Integer) registroLido[2]);
						itemDTO.setRequeracao((Integer) registroLido[3]);
					} else {
						itemDTO.setRequercausa(((BigDecimal) registroLido[2]).intValue());
						itemDTO.setRequeracao(((BigDecimal) registroLido[3]).intValue());
					}
					itemDTO.setRegistro(1);
				} catch (Exception e) {
					itemDTO.setDescricao(itemDTO.getDescricao() + " houve excecao ao obter registro");
					e.printStackTrace();
				}
				listaDTO.add(itemDTO);				
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}
	
	public ParadasGalpaoDTO getParadasByGalpao(String cdGalpao){
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdgalpao,a.cdinjetora,b.cdparada,c.dsparada,b.dthriparada,b.cdinjestendido ");
		strSQL = strSQL.concat(" FROM ijgalobj as a");
		strSQL = strSQL.concat(" JOIN ijtbinj as b on a.cdinjetora = b.cdinjetora");
		strSQL = strSQL.concat(" JOIN ijtbpar as c on b.cdparada = c.cdparada");		
		strSQL = strSQL.concat(" WHERE a.cdgalpao = '::cdGalpao' ");
		strSQL = strSQL.concat(" AND b.dthriparada is not null");
		strSQL = strSQL.concat(" AND b.dthrfparada is null");
		
		strSQL = strSQL.replaceAll("::cdGalpao", cdGalpao);
		
		List<Object> lista = new ArrayList<Object>();
		
		List<ParadaGalpaoDTO> retorno = new ArrayList<ParadaGalpaoDTO>();
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(lista != null){	
		
			for (Object o:lista){
				
				Object[] registroLido = null;
				Object registroLidoAux = (Object) o;
				registroLido = (Object[]) registroLidoAux;
				
				ParadaGalpaoDTO paradaGalpaoDTO = new ParadaGalpaoDTO();
				if(registroLido[5] != null){
					paradaGalpaoDTO.setCdInjetora((String) registroLido[5]);
				}else{
					paradaGalpaoDTO.setCdInjetora((String) registroLido[1]);
				}
				paradaGalpaoDTO.setCdGalpao((String) registroLido[0]);				
				paradaGalpaoDTO.setCdparada((String) registroLido[2]);
				paradaGalpaoDTO.setDsParada((String) registroLido[3]);
				paradaGalpaoDTO.setDthriparada((Date) registroLido[4]);
				paradaGalpaoDTO.setTempoParado(Util.diferencaEntreDatas((Date) registroLido[4]));
				
				retorno.add(paradaGalpaoDTO);		
				
				
			}
		
		}
		
		ParadasGalpaoDTO paradasGalpaoDTO = new ParadasGalpaoDTO();
		paradasGalpaoDTO.setParadasGalpao(retorno);
		
		
		return paradasGalpaoDTO;
	}
	
public AlertasGalpaoDTO getAlertasByGalpao(String cdGalpao){
		
		String strSQL = "";
		strSQL = strSQL.concat("select a.cdgalpao,a.cdinjetora,d.cdalerta,e.dsalerta,d.dthrialerta,b.cdinjestendido");
		strSQL = strSQL.concat(" FROM ijgalobj as a");
		strSQL = strSQL.concat(" join ijtbinj as b on a.cdinjetora = b.cdinjetora");
		strSQL = strSQL.concat(" join ijalertas as d on a.cdinjetora = d.cdinjetora");
		strSQL = strSQL.concat(" join ijtbale as e on d.cdalerta = e.cdalerta");		
		strSQL = strSQL.concat(" WHERE a.cdgalpao = '::cdGalpao' ");		
		strSQL = strSQL.concat(" and (d.dthrialerta IS NOT NULL");
		strSQL = strSQL.concat(" and d.dthrfalerta IS NULL)");
		
		strSQL = strSQL.replaceAll("::cdGalpao", cdGalpao);
		
		List<Object> lista = new ArrayList<Object>();
		
		List<AlertaGalpaoDTO> retorno = new ArrayList<AlertaGalpaoDTO>();
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(lista != null){	
		
			for (Object o:lista){
				
				Object[] registroLido = null;
				Object registroLidoAux = (Object) o;
				registroLido = (Object[]) registroLidoAux;
				
				AlertaGalpaoDTO alertaGalpaoDTO = new AlertaGalpaoDTO();
				alertaGalpaoDTO.setCdGalpao((String) registroLido[0]);
				if(registroLido[5] != null){
					alertaGalpaoDTO.setCdInjetora((String) registroLido[5]);
				}else{
					alertaGalpaoDTO.setCdInjetora((String) registroLido[1]);
				}
				alertaGalpaoDTO.setCdAlerta((String) registroLido[2]);
				alertaGalpaoDTO.setDsAlerta((String) registroLido[3]);
				alertaGalpaoDTO.setDthriAlerta((Date) registroLido[4]);
				alertaGalpaoDTO.setTempoParado(Util.diferencaEntreDatas((Date) registroLido[4]));
				retorno.add(alertaGalpaoDTO);		
				
				
			}
		
		}
		
		AlertasGalpaoDTO paradasGalpaoDTO = new AlertasGalpaoDTO();
		paradasGalpaoDTO.setAlertasGalpao(retorno);
		
		
		return paradasGalpaoDTO;
	}

	public PesquisasDTO pesquisaDwTParadaInjetToVF(PesquisaDTO pesquisa){
		String strSQL = "";
		strSQL = strSQL.concat("SELECT t.cdparada, t.dsparada ");
		strSQL = strSQL.concat("  FROM ijtbpar t ");
		strSQL = strSQL.concat(" WHERE 1 = 1 ");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			strSQL = strSQL.concat(" AND (t.cdparada = :cdTparada OR t.dsparada = :dsTparada ) ");
			
		} else if (!pesquisa.getCodigo().equals("")) {
			strSQL = strSQL.concat(" AND t.cdparada = :cdTparada ");
			
		} else if (!pesquisa.getDescricao().equals("")) {
			strSQL = strSQL.concat(" AND t.dsparada = :dsTparada ");
		}

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		
		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.setString("cdTparada", pesquisa.getCodigo())
			 .setString("dsTparada", pesquisa.getDescricao());
			
		} else if (!pesquisa.getCodigo().equals("")) {
			q.setString("cdTparada", pesquisa.getCodigo());
			
		} else if (!pesquisa.getDescricao().equals("")) {
			q.setString("dsTparada", pesquisa.getDescricao());
		}
		
		List<Object> lista = new ArrayList<Object>();
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (Object reg : lista) {
				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;

				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo((String) registroLido[0]);
				itemDTO.setDescricao((String) registroLido[1]);
				itemDTO.setRegistro(1);
				listaDTO.add(itemDTO);				
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}
	
	
	
	public PesquisasDTO pesquisaDwTParadaInjetToVFCompleto(PesquisaDTO pesquisa){
		String strSQL = "";
		strSQL = strSQL.concat("SELECT t.cdparada, t.dsparada, "
				+ "t.requercancelamento, t.requerjustificativ, t.requercausa, "
				+ "t.requeracao, t.pededrtresponsa, t.pededrttecnico1, t.pededrttecnico2"
				+ ", t.teprogramado"); // campo equivalente ao isAtivo; Se teprogramado == 1, registro ativo
		strSQL = strSQL.concat("  FROM ijtbpar t ");
		strSQL = strSQL.concat(" WHERE 1 = 1 ");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			strSQL = strSQL.concat(" AND (t.cdparada = :cdTparada OR t.dsparada = :dsTparada ) ");
			
		} else if (!pesquisa.getCodigo().equals("")) {
			strSQL = strSQL.concat(" AND t.cdparada = :cdTparada ");
			
		} else if (!pesquisa.getDescricao().equals("")) {
			strSQL = strSQL.concat(" AND t.dsparada = :dsTparada ");
		}

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		
		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.setString("cdTparada", pesquisa.getCodigo())
			 .setString("dsTparada", pesquisa.getDescricao());
			
		} else if (!pesquisa.getCodigo().equals("")) {
			q.setString("cdTparada", pesquisa.getCodigo());
			
		} else if (!pesquisa.getDescricao().equals("")) {
			q.setString("dsTparada", pesquisa.getDescricao());
		}
		
		List<Object> lista = new ArrayList<Object>();
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (Object reg : lista) {
				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;

				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo((String) registroLido[0]);
				itemDTO.setDescricao((String) registroLido[1]);
				itemDTO.setRegistro(1);
				
				itemDTO.setRequercancelamento(ConversaoTipos.converterParaBigDecimal(registroLido[2]).intValue());
				itemDTO.setRequerjustificativ(ConversaoTipos.converterParaBigDecimal(registroLido[3]).intValue());
				itemDTO.setRequercausa(ConversaoTipos.converterParaBigDecimal(registroLido[4]).intValue());
				itemDTO.setRequeracao(ConversaoTipos.converterParaBigDecimal(registroLido[5]).intValue());
				itemDTO.setPededrtresponsa(ConversaoTipos.converterParaBigDecimal(registroLido[6]).intValue());
				itemDTO.setPededrttecnico1(ConversaoTipos.converterParaBigDecimal(registroLido[7]).intValue());
				itemDTO.setPededrttecnico2(ConversaoTipos.converterParaBigDecimal(registroLido[8]).intValue());
				
				if (registroLido.length > 9 &&  registroLido[9] != null)
					itemDTO.setTeprogramado(ConversaoTipos.converterParaBigDecimal(registroLido[9]).intValue());
				
				listaDTO.add(itemDTO);				
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}

	public Integer getIdEmpresaInjet(){
		String idEmpresa = "";
		Ijtbfresh ijtbfresh = getIjtbfresh().get(0);
		
		idEmpresa = ijtbfresh.getPk().getCampo01();		
		return ConversaoTipos.converteParaInt(SenhaRN.descriptografarSenha(idEmpresa));
	}
	
	public Ijgrpmol pesquisarIjGrpMol(String cdGrpMol){
		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "from Ijgrpmol gm where gm.cdgrpmol = '::cdGrpMol' ";
		HQL = HQL.replaceAll("::cdGrpMol", cdGrpMol);

		List<Ijgrpmol> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return lista.get(0);
	}
	
	public OmGt pesquisarIjGrpMap(String cdGrpMaq){
		OmGt retorno = new OmGt();
		
		String HQL = "";

		HQL += "from Ijgrpinj gm where gm.cdgrpinj = '::cdGrpMaq' ";
		HQL = HQL.replaceAll("::cdGrpMaq", cdGrpMaq);

		List<Ijgrpinj> lista = null;

		Query q = getDaoSession().createQuery(HQL);

		try{
			lista = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		retorno.setIdGt(ConversaoTipos.converteParaBigDecimal(lista.get(0).getCdgrpinj()).longValue());
		retorno.setCdGt(lista.get(0).getCdgrpinj());
		retorno.setDsGt(lista.get(0).getDsgrpinj());
		retorno.setDsGt(lista.get(0).getDsgrpinj());
		retorno.setStAtivo((byte)1) ; 
		
		return retorno;
	}	

	public CfgParamConcOP getParamConcOP(){
		CfgParamConcOP retorno = new CfgParamConcOP();
		retorno.setTpVerifConcOP("1");
		retorno.setVlVerifConcOP(new BigDecimal(90));
		
		String HQL ="";		
		HQL+= "SELECT a.id.tpverifconcop, a.id.vlverifconcop from Ijconger a";		
		Query q = getDaoSession().createQuery(HQL);
		
		try{			
			List<Object> lista = null;
			lista = q.list();
			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) lista.get(0);
			registroLido = (Object[]) registroLidoAux;
			
			retorno.setTpVerifConcOP(ConversaoTipos.converterParaBigDecimal(registroLido[0]).toString());
			retorno.setVlVerifConcOP(ConversaoTipos.converterParaBigDecimal(registroLido[1]));
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public ListaIwsAgendaDeParadaDTO getAgendaParada(String cdPt){
		String strSQL = "";
		Date dtHrAtual = DataHoraRN.getDataHoraAtual();
		
		strSQL = strSQL.concat("SELECT a.dthrini, a.dthrfim, a.cdparada ");
		strSQL = strSQL.concat("  FROM ijagendapar a ");
		strSQL = strSQL.concat(" WHERE a.cdinjetora = :cdpt ");
		strSQL = strSQL.concat("  AND ( (:dthratual BETWEEN a.dthrini AND a.dthrfim) OR (a.dthrini >= :dthratual)  ) ");
		strSQL = strSQL.concat("  AND a.stagenda = 1");
		strSQL = strSQL.concat(" ORDER BY a.dthrini");
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);	
		q.setString("cdpt", cdPt)
		 .setDate("dthratual", dtHrAtual);
						
		List<Object> lista = new ArrayList<Object>();
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		ListaIwsAgendaDeParadaDTO listaDTO = new ListaIwsAgendaDeParadaDTO();
		listaDTO.setAgendaParadas(new ArrayList<IwsAgendaDeParadaDTO>());

		if (lista != null) {
			for (Object reg : lista) {
				Object[] registroLido = null;
				Object registroLidoAux = (Object) reg;
				registroLido = (Object[]) registroLidoAux;

				IwsAgendaDeParadaDTO itemDTO = new IwsAgendaDeParadaDTO();
				itemDTO.setDthrInicioAgenda((Date) registroLido[0]);
				itemDTO.setDthrFimAgenda((Date) registroLido[1]);
				itemDTO.setMotivoParadaAgenda((String) registroLido[2]);

				listaDTO.getAgendaParadas().add(itemDTO);				
			}
		}

		return listaDTO;
	}
	
	public String getLoteProdutivo(String cdPt){
		String strSQL = "";
		String retorno = "";
		
		strSQL = strSQL.concat("SELECT a.nrlote  ");
		strSQL = strSQL.concat("  FROM ijtbinjloteatual a ");
		strSQL = strSQL.concat(" WHERE a.cdinjetora = :cdpt ");
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);	
		q.setString("cdpt", cdPt);
						
		List<Object> lista = new ArrayList<Object>();
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (lista != null && lista.size() > 0) {
			Object reg = lista.get(0);			
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			//registroLido = (Object[]) registroLidoAux;

			//if (registroLido[0] != null) {
			if( registroLidoAux != null) {
				retorno =  (String) registroLidoAux;
			}
		}

		return retorno;
	}

	public String getCdProdSistCorp(String cdProduto) {
		String retorno = "";
		String strSQL = "";
		
		strSQL = strSQL.concat("SELECT cdprodutoauxiliar ");
		strSQL = strSQL.concat("  FROM IJdeparaPRO	");
		strSQL = strSQL.concat(" WHERE cdproduto = '" + cdProduto.trim() + "'");

		List<Object> listaReg = this.getDaoSession().createSQLQuery(strSQL).list();			

		Object reg = null;
		if (listaReg.size() > 0) {
			reg = listaReg.get(0);
		
			Object registroAux = (Object) reg;
			retorno  = ((String) (registroAux)).trim();
		}	
		
		return retorno;
	}	



	public void salvarConfigConcentrador(ConfiguracaoConcentrador configuracao) {
		String strSQL = "SELECT a.* FROM ijCfgConcentrador a";
		try {
			// o comando abaixo serve apenas pra verificar se a tabela existe ou nao
			SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);			
			List<Object> listaReg = q.list();			

			// abre transacao
			// Alessandre em 10-11-2020 linha abaixo comentada pois ja existe uma transacao. E com o comando abaixo da um erro de nested transactio not supported
//			this.getDaoSession().getTransaction().begin();
			
			// apaga antes de inserir
			strSQL = "DELETE FROM ijCfgConcxColetor WHERE nomeServico = :nomeServico";
			q = this.getDaoSession().createSQLQuery(strSQL);
			q.setString("nomeServico", configuracao.getNomeServico());
			q.executeUpdate();

			
			strSQL = "DELETE FROM ijCfgConcentrador WHERE nomeServico = :nomeServico";
			q = this.getDaoSession().createSQLQuery(strSQL);
			q.setString("nomeServico", configuracao.getNomeServico());
			q.executeUpdate();
			
			// insere
			strSQL = "";
			strSQL = strSQL.concat("INSERT INTO ijCfgConcentrador (nomeServico, bloqFimOPProbQld, refugoPorPeso, somente1Login, loginPorMatricula) ");
			strSQL = strSQL.concat("  VALUES (:nomeServico, :bloqFimOPProbQld, :refugoPorPeso, :somente1Login, :loginPorMatricula) ");
			
			q = this.getDaoSession().createSQLQuery(strSQL);
			q.setString("nomeServico", configuracao.getNomeServico())
			 .setInteger("bloqFimOPProbQld", configuracao.getBloqFimOPProbQld())
			 .setInteger("refugoPorPeso", configuracao.getRefugoPorPeso())
			 .setInteger("somente1Login", configuracao.getSomente1Login())
			 .setInteger("loginPorMatricula", configuracao.getLoginPorMatricula());			
			q.executeUpdate();
			
			// atualiza lista de coletores
			for (String id : configuracao.getListaColetores()) {
				strSQL = "INSERT INTO ijCfgConcxColetor (nomeServico, idcoletor) VALUES (:nomeServico, :idcoletor) ";
				
				q = this.getDaoSession().createSQLQuery(strSQL);
				q.setString("nomeServico", configuracao.getNomeServico())
				 .setString("idcoletor", id.trim());			
				q.executeUpdate();				
			}
			
			// fecha transacao
//			this.getDaoSession().getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			// nesta situacao a tabela nao deve ter sido criada
			System.out.println(e);
		}
	}
}
