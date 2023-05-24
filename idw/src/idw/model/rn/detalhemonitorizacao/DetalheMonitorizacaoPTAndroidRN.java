package idw.model.rn.detalhemonitorizacao;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.CiclosDTO;
import idw.webservices.dto.DetalhamentoProducaoDTO;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.DwFolhasDTO;
import idw.webservices.dto.FiltroCiclosDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroDetalheProducaoDTO;
import idw.webservices.dto.FiltroGraficoDetalhePtDTO;
import idw.webservices.dto.GraficoDetalhePtDTO;

public class DetalheMonitorizacaoPTAndroidRN extends DetalheMonitorizacaoPTInsertRN{
	/*
	 * Metodo usado apenas para o Android
	 */
	public GraficoDetalhePtDTO getGraficoDetalhePTandroidDTO(Long idpt,
			Long idturno, Long idfolha, String dtReferencia,
			String dtReferenciainicial, String dtReferenciafinal, Long idCp,
			String tpId, int limiteMaxResult) {
		FiltroGraficoDetalhePtDTO filtro = new FiltroGraficoDetalhePtDTO();
		OmPt ompt = null;
		DwTurno turno = null;
		DwFolha folha = null;

		try {
			ompt = this.getDao().findById(OmPt.class, idpt, false);
		} catch (Exception e) {
		}

		try {
			turno = this.getDao().findById(DwTurno.class, idturno, false);
		} catch (Exception e) {
		}

		try {
			folha = this.getDao().findById(DwFolha.class, idfolha, false);
		} catch (Exception e) {
		}

		if (dtReferencia != null && !dtReferencia.equals("")) {
			filtro.setDtReferencia(DataHoraRN.stringToDate(dtReferencia,
					"dd/MM/yyyy"));
		}

		if (dtReferenciainicial != null && !dtReferenciainicial.equals("")) {
			filtro.setDtReferenciaInicial(DataHoraRN.stringToDate(
					dtReferenciainicial, "dd/MM/yyyy"));
		}

		if (dtReferenciafinal != null && !dtReferenciafinal.equals("")) {
			filtro.setDtReferenciaFinal(DataHoraRN.stringToDate(
					dtReferenciafinal, "dd/MM/yyyy"));
		}
		if (!tpId.equals("")) {
			Byte byte1 = new Byte(tpId);
			filtro.setTpId(byte1);
		}
		if (idCp != null && idCp > 0) {
			filtro.setIdCp(idCp);
		}
		filtro.setOmPt(ompt);
		filtro.setDwfolha(folha);
		filtro.setDwTurno(turno);
		
		DetalheMonitorizacaoGraficoAreaResponsavelRN rn = new DetalheMonitorizacaoGraficoAreaResponsavelRN(getDao());
		return rn.getGraficoDetalhePtDTO(filtro, limiteMaxResult);
	}

	public GraficoDetalhePtDTO getGraficoDetalhePtAndroidDTOPorHora(Long idpt,
			String dtReferenciainicial, String dtReferenciafinal) {
		FiltroGraficoDetalhePtDTO filtro = new FiltroGraficoDetalhePtDTO();
		OmPt ompt = null;

		try {
			ompt = this.getDao().findById(OmPt.class, idpt, false);
		} catch (Exception e) {
		}

		if (dtReferenciainicial != null && !dtReferenciainicial.equals("")) {
			filtro.setDtReferenciaInicial(DataHoraRN.stringToDate(
					dtReferenciainicial, "dd/MM/yyyy"));
		}

		if (dtReferenciafinal != null && !dtReferenciafinal.equals("")) {
			filtro.setDtReferenciaFinal(DataHoraRN.stringToDate(
					dtReferenciafinal, "dd/MM/yyyy"));
		}

		filtro.setOmPt(ompt);
		DetalheMonitorizacaoGraficoAreaResponsavelRN rn = new DetalheMonitorizacaoGraficoAreaResponsavelRN(getDao());
		return rn.getGraficoDetalhePtDTO(filtro);
	}

	public GraficoDetalhePtDTO getGraficoDetalhePTandroidBIDTO(Long idgt,
			Long idturno, Long idfolha, String dtReferencia,
			String dtReferenciainicial, String dtReferenciafinal) {
		FiltroGraficoDetalhePtDTO filtro = new FiltroGraficoDetalhePtDTO();
		OmGt omgt = null;
		DwTurno turno = null;
		DwFolha folha = null;

		try {
			omgt = this.getDao().findById(OmGt.class, idgt, false);
		} catch (Exception e) {
		}

		try {
			turno = this.getDao().findById(DwTurno.class, idturno, false);
		} catch (Exception e) {
		}

		try {
			folha = this.getDao().findById(DwFolha.class, idfolha, false);
		} catch (Exception e) {
		}

		if (dtReferencia != null && !dtReferencia.equals("")) {
			filtro.setDtReferencia(DataHoraRN.stringToDate(dtReferencia,
					"dd/MM/yyyy"));
		}

		if (dtReferenciainicial != null && !dtReferenciainicial.equals("")) {
			filtro.setDtReferenciaInicial(DataHoraRN.stringToDate(
					dtReferenciainicial, "dd/MM/yyyy"));
		}

		if (dtReferenciafinal != null && !dtReferenciafinal.equals("")) {
			filtro.setDtReferenciaFinal(DataHoraRN.stringToDate(
					dtReferenciafinal, "dd/MM/yyyy"));
		}

		filtro.setOmGt(omgt);
		filtro.setDwfolha(folha);
		filtro.setDwTurno(turno);
		return getGraficoDetalhePtBIDTO(filtro);
	}

	public DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPTAndroid(
			String dtreferencia, Long iddwconsolid, String dtreferenciainicial,
			String dtreferenciafinal, Long idturno, Long iddwrap, Long idpt,
			Long idgt, Long idproduto, String cdCp) {

		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();
		filtro.setDtReferencia(dtreferencia != null ? DataHoraRN.stringToDate(
				dtreferencia, "dd/MM/yyyy") : null);
		filtro.setDtReferenciaInicial(dtreferenciainicial != null
				&& !dtreferenciainicial.equals("") ? DataHoraRN.stringToDate(
				dtreferenciainicial, "dd/MM/yyyy") : null);
		filtro.setDtReferenciaFinal(dtreferenciafinal != null
				&& !dtreferenciafinal.equals("") ? DataHoraRN.stringToDate(
				dtreferenciafinal, "dd/MM/yyyy") : null);
		filtro.setIdDwConsolId(iddwconsolid != null ? iddwconsolid : 0);

		filtro.setCdCp(cdCp != null && !cdCp.equals("") ? cdCp : null);

		DwRap dwrap = null;
		OmPt ompt = null;
		OmGt omgt = null;
		OmProduto produto = null;
		DwTurno turno = null;

		try {
			turno = this.getDao().findById(DwTurno.class, idturno, false);
		} catch (Exception e) {
		}

		try {
			ompt = this.getDao().findById(OmPt.class, idpt, false);
		} catch (Exception e) {
		}

		try {
			omgt = this.getDao().findById(OmGt.class, idgt, false);
		} catch (Exception e) {
		}

		try {
			produto = this.getDao().findById(OmProduto.class, idproduto, false);
		} catch (Exception e) {
		}

		try {
			dwrap = this.getDao().findById(DwRap.class, iddwrap, false);
		} catch (Exception e) {
		}

		filtro.setDwRap(dwrap);
		filtro.setOmGt(omgt);
		filtro.setOmPt(ompt);
		filtro.setOmProduto(produto);
		filtro.setDwTurno(turno);
		filtro.setCdCp(cdCp);
		return getDetalheMonitorizacaoPtInjetDTO(filtro);
	}
	public DetalhamentoProducaoDTO getDetalhamentoProducaoDTOAndroid(
			Long iddwconsolid, String dtreferenciainicial,
			String dtreferenciafinal, Long idpt) {

		FiltroDetalheProducaoDTO filtro = new FiltroDetalheProducaoDTO();
		filtro.setDthrinicio(dtreferenciainicial != null
				&& !dtreferenciainicial.equals("") ? DataHoraRN.stringToDate(
				dtreferenciainicial, "yyyy-MM-dd HH:mm:ss") : null);
		filtro.setDthrfim(dtreferenciafinal != null
				&& !dtreferenciafinal.equals("") ? DataHoraRN.stringToDate(
				dtreferenciafinal, "yyyy-MM-dd HH:mm:ss") : null);
		filtro.setIddwConsolid(iddwconsolid != null ? iddwconsolid : 0);
		OmPt ompt = null;

		try {
			ompt = this.getDao().findById(OmPt.class, idpt, false);
		} catch (Exception e) {
		}
		filtro.setOmpt(ompt);

		return getDetalhamentoProducao(filtro);
	}

	public GraficoDetalhePtDTO getGraficoDetalhePtandroidUltimosCiclosDTO(
			Long idpt, Long idturno, String dtreferencia) {
		FiltroGraficoDetalhePtDTO filtro = new FiltroGraficoDetalhePtDTO();

		OmPt ompt = null;
		DwTurno turno = null;

		try {
			ompt = this.getDao().findById(OmPt.class, idpt, false);
		} catch (Exception e) {
		}

		try {
			turno = this.getDao().findById(DwTurno.class, idturno, false);
		} catch (Exception e) {
		}

		filtro.setOmPt(ompt);
		filtro.setDwTurno(turno);
		filtro.setDtReferencia(dtreferencia != null ? DataHoraRN.stringToDate(dtreferencia, "dd/MM/yyyy") : null);

		DetalheMonitorizacaoGraficoAreaResponsavelRN rn = new DetalheMonitorizacaoGraficoAreaResponsavelRN(getDao());
		return rn.getGraficoDetalhePtUltimosCiclosDTO(filtro);
	}

	public GraficoDetalhePtDTO getGraficoDetalhePtandroidUltimosCiclosBIDTO(
			Long idgt, Long idturno, String dtreferencia) {
		FiltroGraficoDetalhePtDTO filtro = new FiltroGraficoDetalhePtDTO();

		OmGt omgt = null;
		DwTurno turno = null;

		try {
			omgt = this.getDao().findById(OmGt.class, idgt, false);
		} catch (Exception e) {
		}

		try {
			turno = this.getDao().findById(DwTurno.class, idturno, false);
		} catch (Exception e) {
		}

		filtro.setOmGt(omgt);
		filtro.setDwTurno(turno);
		filtro.setDtReferencia(dtreferencia != null ? DataHoraRN.stringToDate(
				dtreferencia, "dd/MM/yyyy") : null);

		return getGraficoDetalhePtUltimosCiclosBIDTO(filtro);
	}
	public CiclosDTO getUltimosCiclosAndroid(Long idPt, Long idCp) {
		FiltroCiclosDTO filtro = new FiltroCiclosDTO();

		OmPt ompt = null;
		PpCp ppCp = null;

		try {
			ompt = this.getDao().findById(OmPt.class, idPt, false);
		} catch (Exception e) {
		}

		try {
			ppCp = this.getDao().findById(PpCp.class, idCp, false);
		} catch (Exception e) {
		}

		filtro.setOmPt(ompt);
		filtro.setPpCp(ppCp);

		return getUltimosCiclos(filtro);
	}

	public DwFolhasDTO getGraficoDetalhePadraoandroidDTO(Long idpt,
			Long idfolha, String dtreferencia) {
		FiltroGraficoDetalhePtDTO filtro = new FiltroGraficoDetalhePtDTO();

		OmPt ompt = null;
		DwFolha folha = null;

		try {
			ompt = this.getDao().findById(OmPt.class, idpt, false);
		} catch (Exception e) {
		}

		try {
			folha = this.getDao().findById(DwFolha.class, idfolha, false);
		} catch (Exception e) {
		}

		filtro.setOmPt(ompt);
		filtro.setDwfolha(folha);
		filtro.setDtReferencia(dtreferencia != null ? DataHoraRN.stringToDate(
				dtreferencia, "dd/MM/yyyy") : null);

		return getGraficoDetalhePadraoDTO(filtro);
	}
	public DwFolhasDTO getGraficoDetalhePadraoandroidBIDTO(Long idgt,
			Long idfolha, String dtreferencia) {
		FiltroGraficoDetalhePtDTO filtro = new FiltroGraficoDetalhePtDTO();

		OmGt omgt = null;
		DwFolha folha = null;

		try {
			omgt = this.getDao().findById(OmGt.class, idgt, false);
		} catch (Exception e) {
		}

		try {
			folha = this.getDao().findById(DwFolha.class, idfolha, false);
		} catch (Exception e) {
		}

		filtro.setOmGt(omgt);
		filtro.setDwfolha(folha);
		filtro.setDtReferencia(dtreferencia != null ? DataHoraRN.stringToDate(
				dtreferencia, "dd/MM/yyyy") : null);

		return getGraficoDetalhePadraoBIDTO(filtro);
	}

}
