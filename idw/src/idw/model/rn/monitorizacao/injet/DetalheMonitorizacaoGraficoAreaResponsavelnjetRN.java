package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.SQLQuery;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRtcic;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.GraficoDetalhePtDTO;
import ms.util.ConversaoTipos;

public class DetalheMonitorizacaoGraficoAreaResponsavelnjetRN extends DetalheMonitorizacaoPTInjetRN{
	public DetalheMonitorizacaoGraficoAreaResponsavelnjetRN() {
		super(new DAOGenericoInjet());
	}
	
	public DetalheMonitorizacaoGraficoAreaResponsavelnjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	/*
	 * Gerado para poder usar um limite de linhas retornadas na consulta, e
	 * casos com muitas linhas havia estouro de memÃ³ria no Android
	 */
	public GraficoDetalhePtDTO getGraficoDetalhePtDTO(FiltroGraficoDetalhePtDTO filtro) {
		return getGraficoDetalhePtDTO(filtro, 0);
	}


	/*
	 * Esse grafico foi chamado no momento de se montar o grafico de parada por area responsavel.
	 * Acredito que sera chamado por outros graficos tambem
	 */
	public GraficoDetalhePtDTO getGraficoDetalhePtDTO(FiltroGraficoDetalhePtDTO filtro, int limiteMaxresult) {

		IdwLogger log = new IdwLogger("getGraficoDetalhePt");
		GraficoDetalhePtDTO retorno = new GraficoDetalhePtDTO();
		DwConsolidDTOs dwconsolidDTOs = new DwConsolidDTOs();
		List<DwConsolidDTO> listaDwConsolidDTO = new ArrayList<DwConsolidDTO>();
		
		if (filtro == null) {
			//nao tem dados pra montar graf (periodo somente com regulagem por exemnplo)
			return retorno;
		} 
		
		Byte tpId = filtro.getTpId();

		
		/*
		if (filtro.getIdCp() != null) {
			filtro.setPpCp(new PpCp());
			filtro.getPpCp().setIdCp(filtro.getIdCp());
			
			if (filtro.getPpCp() != null) {
				filtro.getPpCp().setCdCp(filtro.getPpCp().getCdCp());
			}			
		}
		*/
		
		
		List<DwConsolid> listadwconsolid = null;
		if (filtro.getIdConsolid() != 0) {
			listadwconsolid  = this.getDwConsolid(log, filtro.getIdConsolid(),
						filtro.isComParadas(), false, false, 
						false, false, false);			
		} else {		
			listadwconsolid  = this.getDwConsolid(log, tpId,
					filtro.getOmPt(), filtro.getPpCp(), filtro.getDwTurno(),
					filtro.getDwTParada(), null, filtro.getDtReferencia(),
					filtro.getDtReferenciaInicial(), filtro.getDtReferenciaFinal(),
					filtro.getDthrIturno(), filtro.getDthrFturno(),
					filtro.getDthrIhora(), filtro.getDthrFhora(),
					filtro.isComParadas(), false, false, limiteMaxresult,
					filtro.getOmGt(), false, false);
		}
		
		if (listadwconsolid != null && listadwconsolid.isEmpty() == false) {

			for (DwConsolid dwconsolid : listadwconsolid) {
								
				DwConsolidDTO dto = new DwConsolidDTO();
				dto.setDwConsolid(dwconsolid.clone(false));
				dto.getDwConsolid().setDwFolha(dwconsolid.getDwFolha().clone()); 
				
				DwConsol dwConsol = dwconsolid.getDwConsols().iterator().next();
								
				dto.getDwConsolid().setDwConsols(new HashSet<DwConsol>());
				
				for(DwConsol consol : dwconsolid.getDwConsols()){
					DwConsol consolClone = consol.clone(false);
					consolClone.setDwConsoldefs(consol.cloneDwConsoldefs());
					consolClone.setDwConsolres(consol.cloneDwConsolres());
					dto.getDwConsolid().getDwConsols().add(consolClone);
				}
				
				dto.getDwConsolid().setDwTurno(dwconsolid.getDwTurno());

				if (dwConsol.isTemParada()) {
					retorno.setComParadas(true);
				}

				// Calcula a eficiencia do ciclo
				Float eficienciaCiclo = FormulasInjet.calcularEficienciaCiclo( dwConsol.getSegAutoCiclopadrao(), dwConsol.getSegAutoCiclomedio()).floatValue();
				dto.setEficienciaCiclo(new Double(eficienciaCiclo == null ? 0 : eficienciaCiclo));
				listaDwConsolidDTO.add(dto);

				// Carrega dados de parada
				if (filtro.isComParadas()) {
					DwConsol dwConsolClonado = dto.getDwConsolid().getDwConsols().iterator().next();
					dwConsolClonado.setDwConsolpas(dwConsol.cloneDwConsolpas());

					List<DwConsolid> consolids = new ArrayList<DwConsolid>();
					consolids.add(dwconsolid);
					
				}				
			}

			// deve considerar o ultimo ciclo - a lista ta invertida, logo deve pegar o primeiro e nao o ultimo
			//DwFolha dwFolha = listadwconsolid.get(listadwconsolid.size() - 1).getDwFolha();
			DwConsolid dwci = listadwconsolid.get(listadwconsolid.size()-1);
			DwFolha dwFolha = dwci.getDwFolha();
			//
			// Pega ciclo padrao
			BigDecimal cicloPadrao = dwFolha.getSegCiclopadrao();
			retorno.setCicloPadrao(cicloPadrao.doubleValue());			
			BigDecimal cicloMinimo = dwFolha.getSegCiclominimo();
			BigDecimal cicloMaximo = dwFolha.getSegCiclotimeout();

			BigDecimal cavAtivas = dwci.getDwConsol().getQtAutoCavativas();  //dwFolha.getDwFolharaps().iterator().next().getDwFolharapcoms().iterator().next().getQtAtiva();
			BigDecimal cavTotais = dwci.getDwConsol().getQtAutoCavtotal(); //dwFolha.getDwFolharaps().iterator().next().getDwFolharapcoms().iterator().next().getQtTotal();
			
			retorno.setCavAtivas(cavAtivas.doubleValue());

			// Limite superior e inferior do ciclo (lse, lie)
			BigDecimal lse = cicloMaximo;
			BigDecimal lie = cicloMinimo;
			
			retorno.setLimitesuperior(lse.doubleValue());
			retorno.setLimiteinferior(lie.doubleValue());

			// Metahora
			try {
				if (ConfiguracoesInjetRN.getIsPcsPrevistaPelasCavTotais()) {
					retorno.setMetaHora(FormulasInjet.calcularMetaHora(cicloPadrao, cavTotais).doubleValue());
				} else {
					retorno.setMetaHora(FormulasInjet.calcularMetaHora(cicloPadrao, cavAtivas).doubleValue());
				}
			} catch (NumberFormatException e) {
				retorno.setMetaHora(-1d);
			}

		}
		
		//
		DwRtcic cic = null;
		
		if (filtro != null) {
			if (filtro.getPpCp() != null) {
				cic = getHoraInicioAndFimUltOcorrencia(filtro.getPpCp().getCdCp());
			} else {
				if (filtro.getTpId().equals(DetalheMonitorizacaoPTInjetRN.PERIODO_CONSOLIDACAO_HORA)) {
					cic = getHoraInicioAndFimUltOcorrencia(filtro.getOmPt().getCdPt(), filtro.getDthrIhora(), filtro.getDthrFhora());

				} else {
					cic = getHoraInicioAndFimUltOcorrencia(filtro.getOmPt().getCdPt(), filtro.getDtReferencia(), FuncoesApoioInjet.getStrZero(filtro.getDwTurno().getIdTurno(), 6));					
				}
			}

			if (cic != null) {
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(cic.getDthrIciclo());
				retorno.setDataIocorrencia(cal1);
				
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(cic.getDthrFciclo());
				retorno.setDataFocorrencia(cal2);
			}
			
			dwconsolidDTOs.setListaDwConsolidDTO(listaDwConsolidDTO);
			retorno.setDwConsolidDTOs(dwconsolidDTOs);			
		}

		return retorno;
	}
	
	@SuppressWarnings({"unused", "unchecked"})
	public DwRtcic getHoraInicioAndFimUltOcorrencia(String cdcp){
		DwRtcic ultimoCiclo = null;

		byte _nrop = 0;
		byte _dthrIniCic = 1;
		byte _dthrFimCic = 2;
		byte _segTmpCicLido = 3;
		byte _segTmpCicPadrao = 4;
		byte _cdInjetora = 5;
		byte _cdMolde = 6;
		byte _cdEstrutura = 7;
		byte _dthrIValCic = 8;
		byte _dthrIValEstru = 9;


		class RegistroLido {
			String nrop;
			Date dthrIniCic;
			Date dthrFimCic;
			BigDecimal segTmpCicLido = BigDecimal.ZERO;
			BigDecimal segTmpCicPadrao = BigDecimal.ZERO;
			String cdInjetora;
			String cdMolde;
			String cdEstrutura;
			Date dthrIValCic;
			Date dthrIValEstru;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.nrop, a.DtHrICiclo, a.DtHrFCiclo, a.TmpCicloLido, a.TmpCicPadrao, a.cdinjetora, a.cdmolde, a.cdestrutura, a.DtHrIValEstru, a.DtHrIValCic ");
		strSQL = strSQL.concat("  FROM viewUltimoCicloOP a ");
		strSQL = strSQL.concat(" WHERE a.nrop = '" + cdcp + "'");

		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		List<Object> lista = new ArrayList<Object>();		
		lista = q.list();

		if (lista.size() > 0) {
			Object reg = lista.get(0);
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.nrop = (String) registroLido[_nrop];
			registro.dthrIniCic = (Date) registroLido[_dthrIniCic];
			registro.dthrFimCic = (Date) registroLido[_dthrFimCic];
			registro.segTmpCicLido = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicLido]);
			registro.segTmpCicPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicPadrao]);
			registro.cdInjetora = (String) registroLido[_cdInjetora];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];
			registro.dthrIValCic = (Date) registroLido[_dthrIValCic];
			registro.dthrIValEstru = (Date) registroLido[_dthrIValEstru];

			DwRtcic regCic = new DwRtcic();
			regCic.setDwRt(null);
			regCic.setDthrIciclo(registro.dthrIniCic);
			regCic.setMsDthriciclo((byte) 0);
			regCic.setDthrFciclo(registro.dthrFimCic);
			regCic.setMsDthrfciclo((byte) 0);
			regCic.setSegDuracao(registro.segTmpCicLido);
			regCic.setIsRegulagem(false);
			regCic.setDwFolha(null);
			regCic.setPpCp(null);
			
			ultimoCiclo = regCic;
		}
		
		
		return ultimoCiclo;
		
	}

	@SuppressWarnings({"unused", "unchecked"})
	public DwRtcic getHoraInicioAndFimUltOcorrencia(String cdpt, Date dthrIni, Date dthrFim){
		DwRtcic ultimoCiclo = null;

		byte _nrop = 0;
		byte _dthrIniCic = 1;
		byte _dthrFimCic = 2;
		byte _segTmpCicLido = 3;
		byte _segTmpCicPadrao = 4;
		byte _cdInjetora = 5;
		byte _cdMolde = 6;
		byte _cdEstrutura = 7;
		byte _dthrIValCic = 8;
		byte _dthrIValEstru = 9;


		class RegistroLido {
			String nrop;
			Date dthrIniCic;
			Date dthrFimCic;
			BigDecimal segTmpCicLido = BigDecimal.ZERO;
			BigDecimal segTmpCicPadrao = BigDecimal.ZERO;
			String cdInjetora;
			String cdMolde;
			String cdEstrutura;
			Date dthrIValCic;
			Date dthrIValEstru;
		}

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.nrop, a.DtHrICiclo, a.DtHrFCiclo, a.TmpCicloLido, a.TmpCicPadrao, a.cdinjetora, a.cdmolde, a.cdestrutura, a.DtHrIValEstru, a.DtHrIValCic ");
		strSQL = strSQL.concat("  FROM IJreaCICOP a ");
		strSQL = strSQL.concat("  JOIN ( ");
		strSQL = strSQL.concat("         SELECT a.nrop, MAX(a.dthriciclo) as dthriciclo ");
		strSQL = strSQL.concat("           FROM IJreaCICOP a ");
		strSQL = strSQL.concat("           JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("          WHERE b.cdinjestendido = :cdinjetora ");
		strSQL = strSQL.concat("            AND ( (a.dthriciclo BETWEEN :dthrinitur AND :dthrfimtur) OR ");
		strSQL = strSQL.concat("                  (a.dthrfciclo BETWEEN :dthrinitur AND :dthrfimtur) OR ");
		strSQL = strSQL.concat("                  (:dthrinitur BETWEEN a.dthriciclo AND a.dthrfciclo)  ) ");
		strSQL = strSQL.concat("          GROUP BY a.nrop ");
		strSQL = strSQL.concat("       ) b ON (a.nrop = b.nrop AND a.dthriciclo = b.dthriciclo) ");
		
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q.setString("cdinjetora", cdpt)
		 .setTimestamp("dthrinitur", dthrIni)
		 .setTimestamp("dthrfimtur", dthrFim);
		 
		List<Object> lista = new ArrayList<Object>();		
		lista = q.list();

		if (lista.size() > 0) {
			Object reg = lista.get(0);
			RegistroLido registro = new RegistroLido();

			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.nrop = (String) registroLido[_nrop];
			registro.dthrIniCic = (Date) registroLido[_dthrIniCic];
			registro.dthrFimCic = (Date) registroLido[_dthrFimCic];
			registro.segTmpCicLido = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicLido]);
			registro.segTmpCicPadrao = ConversaoTipos.converterParaBigDecimal(registroLido[_segTmpCicPadrao]);
			registro.cdInjetora = (String) registroLido[_cdInjetora];
			registro.cdMolde = (String) registroLido[_cdMolde];
			registro.cdEstrutura = (String) registroLido[_cdEstrutura];
			registro.dthrIValCic = (Date) registroLido[_dthrIValCic];
			registro.dthrIValEstru = (Date) registroLido[_dthrIValEstru];

			DwRtcic regCic = new DwRtcic();
			regCic.setDwRt(null);
			regCic.setDthrIciclo(registro.dthrIniCic);
			regCic.setMsDthriciclo((byte) 0);
			regCic.setDthrFciclo(registro.dthrFimCic);
			regCic.setMsDthrfciclo((byte) 0);
			regCic.setSegDuracao(registro.segTmpCicLido);
			regCic.setIsRegulagem(false);
			regCic.setDwFolha(null);
			regCic.setPpCp(null);
			
			ultimoCiclo = regCic;
		}
		
		
		return ultimoCiclo;
		
	}

	public DwRtcic getHoraInicioAndFimUltOcorrencia(String cdpt, Date dtTurno, String cdTurno){
		DwRtcic ultimoCiclo = null;

		Date dthrIniTur = null;
		Date dthrFimTur = null;
		
		try {
			dthrIniTur = FuncoesApoioInjet.calcularInicioTurno(getDao(), dtTurno, cdTurno);
			dthrFimTur = FuncoesApoioInjet.calcularFimTurno(getDao(), dtTurno, cdTurno);
		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ultimoCiclo = getHoraInicioAndFimUltOcorrencia(cdpt, dthrIniTur, dthrFimTur);
		
		return ultimoCiclo;	
	}

}
