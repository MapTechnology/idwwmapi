package idw.model.rn.classificacaoabc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgabc;
import idw.model.pojos.OmCfgabclim;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.OmCfgabclimTemplate.TpClasseABC;
import idw.model.pojos.template.OmPtTemplate.TpClasseABCCritica;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.UsuarioRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.ClassificacaoABCDTO;
import idw.webservices.dto.ClassificacoesABCDTO;
import idw.webservices.dto.ComboDTO;
import idw.webservices.dto.ListaComboDTO;
import idw.webservices.dto.ResultadoDTO;

public class ClassificacaoABCRN extends AbstractRN<DAOGenerico> {

	public ClassificacaoABCRN() {
		this(null);
	}

	public ClassificacaoABCRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public ClassificacaoABCDTO setClassificacaoABCDTO(ClassificacaoABCDTO itemDTO) {
		OmCfgabc itemOriginal = new OmCfgabc();
		itemOriginal = itemDTO.getOmCfgabc().clone();

		OmCfgabc omCfgabc = salvarDesativandoOriginal(itemOriginal, new Date(), itemDTO.getOmCfgabc().getOmUsrByIdUsrrevisao());

		itemDTO.setOmCfgabc(omCfgabc.clone());

		itemDTO.getOmCfgabc().getOmCfgabclims().clear();
		for (OmCfgabclim lim : itemOriginal.getOmCfgabclims()) {
			lim.setOmCfgabc(itemDTO.getOmCfgabc());
			lim = getDao().makePersistent(lim);
			itemDTO.getOmCfgabc().getOmCfgabclims().add(lim);
		}

		OmCfg omCfg = Util.getConfigGeral(getDaoSession());
		if (omCfg.getOmCfgabc() != null && omCfg.getOmCfgabc().getCdCfgabc().equals(omCfgabc.getCdCfgabc())) {
			omCfg.setOmCfgabc(omCfgabc);
			getDao().makePersistent(omCfg);
		}

		return itemDTO;
	}

	public ClassificacoesABCDTO getListaClassificacaoABCDTO(ClassificacaoABCDTO filtro) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT abc");
		q.append("FROM OmCfgabc abc");
		q.append("WHERE 1 = 1");

		if (filtro.getOmCfgabc() != null && filtro.getOmCfgabc().getIdCfgabc() != null
				&& filtro.getOmCfgabc().getIdCfgabc() != 0) {
			q.append("AND abc.idCfgabc = :idCfgabc");
		} else {
			if (filtro.getOmCfgabc().getCdCfgabc() != null && !filtro.getOmCfgabc().getCdCfgabc().equals("")) {
				q.append("AND abc.cdCfgabc = :cdCfgabc");
			}
			if (filtro.getOmCfgabc().getDsCfgabc() != null && !filtro.getOmCfgabc().getDsCfgabc().equals("")) {
				q.append("AND abc.dsCfgabc = :dsCfgabc");
			}

			if ((filtro.getOmCfgabc().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getOmCfgabc().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getOmCfgabc().getOmUsrByIdUsrstativo().getCdUsr().equals(""))) {
				q.append("AND abc.omUsrByIdUsrstativo.cdUsr = :cdUsrSt");
			}
			if ((filtro.getOmCfgabc().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getOmCfgabc().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getOmCfgabc().getOmUsrByIdUsrstativo().getDsNome().equals(""))) {
				q.append("AND abc.omUsrByIdUsrstativo.dsNome = :dsNomeSt");
			}
			if ((filtro.getOmCfgabc().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getOmCfgabc().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getOmCfgabc().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))) {
				q.append("AND abc.omUsrByIdUsrrevisao.cdUsr = :cdUsrRev");
			}
			if ((filtro.getOmCfgabc().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getOmCfgabc().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getOmCfgabc().getOmUsrByIdUsrrevisao().getDsNome().equals(""))) {
				q.append("AND abc.omUsrByIdUsrrevisao.dsNome = :dsNomeRev ");
			}
			if (filtro.getOmCfgabc().getDtRevisao() != null) {
				q.append("AND abc.dtRevisao >= :dtRevisao AND abc.dtRevisao <= :dtRevisaoF");
			}
			if (filtro.getOmCfgabc().getDtStativo() != null) {
				q.append("AND abc.dtStativo >= :dtStativo AND abc.dtStativo <= :dtStativoF");
			}
			if (filtro.getOmCfgabc().getRevisao() != null) {
				q.append("AND abc.revisao = :revisao");
			}
			if (filtro.getOmCfgabc().getStAtivo() != null && filtro.getOmCfgabc().getStAtivo() < (byte) 2) {
				q.append("AND abc.stAtivo = :stAtivo");
			}
		}

		q.defineParametro("idCfgabc", filtro.getOmCfgabc().getIdCfgabc());
		q.defineParametro("cdCfgabc", filtro.getOmCfgabc().getCdCfgabc());
		q.defineParametro("dsCfgabc", filtro.getOmCfgabc().getDsCfgabc());

		if (filtro.getOmCfgabc().getDtRevisao() != null) {
			q.defineParametro("dtRevisao", filtro.getOmCfgabc().getDtRevisao());
			q.defineParametro("dtRevisaoF", DataHoraRN.getDataHora235959(filtro.getOmCfgabc().getDtRevisao()));
		}

		if (filtro.getOmCfgabc().getDtStativo() != null) {
			q.defineParametro("dtStativo", filtro.getOmCfgabc().getDtStativo());
			q.defineParametro("dtStativoF", DataHoraRN.getDataHora235959(filtro.getOmCfgabc().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getOmCfgabc().getRevisao());
		q.defineParametro("stAtivo", filtro.getOmCfgabc().getStAtivo());

		if (filtro.getOmCfgabc().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getOmCfgabc().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getOmCfgabc().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getOmCfgabc().getOmUsrByIdUsrstativo() != null) {
			q.defineParametro("cdUsrSt", filtro.getOmCfgabc().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getOmCfgabc().getOmUsrByIdUsrstativo().getDsNome());
		}

		List<OmCfgabc> listaPesquisa = null;
		try {
			listaPesquisa = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ClassificacaoABCDTO> lista = new ArrayList<ClassificacaoABCDTO>();

		if (listaPesquisa != null) {
			for (OmCfgabc item : listaPesquisa) {
				ClassificacaoABCDTO abcDTO = new ClassificacaoABCDTO();
				abcDTO.setOmCfgabc(item.clone());
				lista.add(abcDTO);
			}
		}
		ClassificacoesABCDTO listaDtoRetorno = new ClassificacoesABCDTO();
		listaDtoRetorno.setListaDTO(lista);
		return listaDtoRetorno;
	}

	public ClassificacoesABCDTO removeClassificacaoABC(ClassificacoesABCDTO itens) {
		List<ClassificacaoABCDTO> listaRetorno = new ArrayList<ClassificacaoABCDTO>();
		ClassificacoesABCDTO itensRetorno = new ClassificacoesABCDTO();
		
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(itens);
		itensRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return itensRetorno;
		}
				

		for (ClassificacaoABCDTO item : itens.getListaDTO()) {
			OmUsr omUser = new OmUsr();
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
			try {
				omUser = usuarioRN.getOmUsr(item.getOmCfgabc().getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				setResultadoRegistroDesconhecido(itens);
				return itens;
			}
			try {
				desativarClassificacaoABC(item.getOmCfgabc().getIdCfgabc(), new Date(), omUser);
			} catch (RegistroJaDesativadoException e) {
				setResultadoRegistroJaDesativado(itens);
				return itens;
			}
			listaRetorno.add(item);
		}
		
		itensRetorno.setListaDTO(listaRetorno);
		return itensRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(ClassificacoesABCDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		//campos
		OmCfgabc classificacaoEmUso = omcfg.getOmCfgabc();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(ClassificacaoABCDTO item: itens.getListaDTO()) {
			camposEmUsoOmCfg.setCodigo(item.getOmCfgabc().getCdCfgabc());
			
			if(classificacaoEmUso != null) {
				if(item.getOmCfgabc().getCdCfgabc().equals(classificacaoEmUso.getCdCfgabc())) {
					camposEmUsoOmCfg.setClassificacaoABC(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getListaDTO() != null && itens.getListaDTO().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}

	public OmCfgabc getOmCfgabcPorCdAtivoOrderByCd(String cdCfgabc) {
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT abc FROM OmCfgabc abc");
		q.append("WHERE abc.stAtivo = :stAtivo");
		q.append("AND abc.cdCfgabc = :cdCfgabc");
		q.append("ORDER BY abc.idCfgabc");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdCfgabc", cdCfgabc);
		q.setMaxResults(1);
		return (OmCfgabc) q.uniqueResult();
	}

	public OmCfgabc salvarDesativandoOriginal(OmCfgabc omCfgabc, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(omCfgabc, dateOperacao, omUsrOperacao);
	}

	/**
	 * Desativa {@code OmCfgabc} relacionado ao id da classificacaoABC
	 *
	 * @param idClassificacao
	 * @param date
	 * @param omUsr
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarClassificacaoABC(long idClassificacao, Date date, OmUsr omUsr)
			throws RegistroJaDesativadoException {
		this.getDao().desativar(OmCfgabc.class, idClassificacao, date, omUsr);
	}

	private void setResultadoRegistroDesconhecido(ClassificacoesABCDTO dto) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		resultadoDTO.setIdmensagem(resultadoDTO.getERRO_REGISTRO_DESCONHECIDO());
		dto.setResultado(resultadoDTO);
	}

	private void setResultadoRegistroJaDesativado(ClassificacoesABCDTO dto) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		resultadoDTO.setIdmensagem(resultadoDTO.getERRO_EXCLUI_STATIVO_ZERO());
		dto.setResultado(resultadoDTO);
	}

	public static ListaComboDTO getTiposClasseABCCritica() {
		ListaComboDTO dtos = new ListaComboDTO();
		dtos.setDtos(new ArrayList<ComboDTO>());
		for (TpClasseABCCritica classes : TpClasseABCCritica.values()) {
			ComboDTO dto = new ComboDTO();
			dto.setValor(classes.getValue());
			dto.setDescricao(classes.toString());
			dtos.getDtos().add(dto);
		}
		return dtos;
	}

	/**
	 * Pega os limites definidos da classificação ABC.<br>
	 * Caso não encontre, os limites irão assumir o que é carregado em {@link OmCfgabclim#inicializarLimites()}
	 * 
	 * @param omcfgabc
	 * @return
	 */
	public Map<TpClasseABC, OmCfgabclim> getLimitesClassesABC(OmCfgabc omcfgabc) {
		Map<TpClasseABC, OmCfgabclim> limitesClasseAbc = new HashMap<TpClasseABC, OmCfgabclim>();

		if (omcfgabc != null) {
			for (OmCfgabclim lim : omcfgabc.getOmCfgabclims()) {
				if (TpClasseABC.CLASSE_A.equals(lim.getClasse())) {
					limitesClasseAbc.put(TpClasseABC.CLASSE_A, lim);
				} else if (TpClasseABC.CLASSE_B.equals(lim.getClasse())) {
					limitesClasseAbc.put(TpClasseABC.CLASSE_B, lim);
				} else if (TpClasseABC.CLASSE_C.equals(lim.getClasse())) {
					limitesClasseAbc.put(TpClasseABC.CLASSE_C, lim);
				}
			}
		}

		// Insere limite indefinido
		// se estiver faltando algum limite de classe ABC
		for (TpClasseABC tpClasseABC : TpClasseABC.values()) {
			final OmCfgabclim classeABCSemLimiteDefinido = new OmCfgabclim();
			classeABCSemLimiteDefinido.inicializarLimites();
			if (!limitesClasseAbc.containsKey(tpClasseABC)) {
				classeABCSemLimiteDefinido.setClasse((short) tpClasseABC.getValue());
				limitesClasseAbc.put(tpClasseABC, classeABCSemLimiteDefinido);
			}
		}

		return limitesClasseAbc;
	}

	public TpClasseABC getClasseAbc(BigDecimal custoSaldoProduto, BigDecimal custoSaldoTodosProdutos,
			Map<TpClasseABC, OmCfgabclim> limitesAbc) {

		BigDecimal indice = AritmeticaUtil.dividir(custoSaldoProduto, custoSaldoTodosProdutos)
				.multiply(new BigDecimal(100));

		if (indice.compareTo(limitesAbc.get(TpClasseABC.CLASSE_A).getLimiteInfClasse()) < 0) {
			return TpClasseABC.CLASSE_A;
		} else if (indice.compareTo(limitesAbc.get(TpClasseABC.CLASSE_C).getLimiteInfClasse()) > 0) {
			return TpClasseABC.CLASSE_C;
		} else {
			return TpClasseABC.CLASSE_B;
		}

	}

	public BigDecimal calcularOEE(Collection<DwConsolid> listaAux) {
		BigDecimal tempoProdutivo = BigDecimal.ZERO;
		BigDecimal tempoAtivo = BigDecimal.ZERO;

		// Obtem dados necessarios para calculo do OEE
		for (DwConsolid id : listaAux) {
			for (DwConsol consol : id.getDwConsols()) {
				BigDecimal tempoCicloProdutivoDwConsol = consol.getSegAutoCicloprodutivo();

				Double tempoBoasAutoItem = FormulasInjet.calcularTempoBoas(tempoCicloProdutivoDwConsol, consol.getSegAutoTemporefugadas(), consol.getSegAutoTempoparadaCpVr(), consol.getSegAutoTempoparadaSpVr()).doubleValue();
				Double tempoBoasManuItem = FormulasInjet.calcularTempoBoas(consol.getSegManuCicloprodutivo(), consol.getSegManuTemporefugadas(), consol.getSegManuTempoparadaCpVr(), consol.getSegManuTempoparadaSpVr()).doubleValue();

				Double tempoboas = tempoBoasAutoItem + tempoBoasManuItem;
				if (tempoboas < 0)
					tempoboas = 0d;

				Double temporitmo = 0d;

				Double tempoRitmoAutoItem = FormulasInjet.calcularRitmo(tempoCicloProdutivoDwConsol,
						consol.getQtAutoCicloprodutivo(), consol.getSegAutoCiclopadrao(),
						consol.getSegAutoTempoparadaCpVr(), consol.getSegAutoTempoparadaSpVr()).doubleValue();

				Double tempoRitmoManuItem = FormulasInjet.calcularRitmo(consol.getSegManuCicloprodutivo(),
						consol.getQtManuCicloprodutivo(), consol.getSegAutoCiclopadrao(),
						consol.getSegManuTempoparadaCpVr(), consol.getSegManuTempoparadaSpVr()).doubleValue();

				if (consol.getPcsProducaoBruta().compareTo(BigDecimal.ZERO) > 0) {
					temporitmo = tempoRitmoAutoItem + tempoRitmoManuItem;
				}

				Double tempoProdutivoAutoItem = FormulasInjet
						.calcularTempoprodutivas(new BigDecimal(tempoboas), BigDecimal.ZERO, new BigDecimal(temporitmo))
						.doubleValue();

				if (tempoProdutivoAutoItem != null)
					tempoProdutivo = tempoProdutivo.add(new BigDecimal(tempoProdutivoAutoItem));

				if (consol.getSegAutoTempoativo() != null)
					tempoAtivo = tempoAtivo.add(consol.getSegAutoTempoativo());
			}
		}
		BigDecimal oee = new BigDecimal(FormulasInjet.calcularOEE(tempoProdutivo, tempoAtivo));
		return oee;
	}

	public BigDecimal getCustoSaldo(PpCpproduto ppCpproduto) {
		BigDecimal prodLiquida = AritmeticaUtil.diminuir(ppCpproduto.getPcsProducaobruta(), ppCpproduto.getPcsProducaorefugada());
		BigDecimal prodPlan = ppCpproduto.getPcsProducaoplanejada();
		BigDecimal saldo = AritmeticaUtil.diminuir(prodPlan, prodLiquida);
		OmProduto omProduto = ppCpproduto.getOmProduto();
		BigDecimal custoSaldo = AritmeticaUtil.multiplicar(saldo, omProduto.getVlCustounit());
		
		if (custoSaldo.compareTo(BigDecimal.ZERO) < 0) {
			custoSaldo = BigDecimal.ZERO;
		}
		return custoSaldo;
	}

}
