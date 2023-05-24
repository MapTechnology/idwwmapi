package idw.model.rn.monitorizacao;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.GTRN;
import idw.model.rn.TurnoRN;
import idw.webservices.dto.GtDTO;
import idw.webservices.dto.GtRtDTO;
import idw.webservices.dto.GtRtMonitorizacaoDTO;

public class MonitorizacaoVisaoMaquinaAndroidRN extends MonitorizacaoVisaoMaquinaRN{

	public GtRtMonitorizacaoDTO getGtRtMonitorizacaoTmAndroidDTO(long idturno, long idgt, String dtreferencia) {
		GtRtDTO gtRtDTOFiltro = new GtRtDTO();
		TurnoRN turnoRN = new TurnoRN(getDao());

		GTRN gtRN = new GTRN();
		gtRN.setSession(getDaoSession());
		DwTurno dwturno = null;
		OmGt omgt = null;

		try {
			if (idturno == 0) {
				dwturno = null;
			} else {
				dwturno = turnoRN.getDao().findById(DwTurno.class, idturno,
						false);
			}

			omgt = gtRN.findById(OmGt.class, idgt, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		gtRtDTOFiltro.setDwTurno(dwturno == null ? null : dwturno.clone(false));
		GtDTO gtDTO = new GtDTO();
		gtDTO.setGt(omgt == null ? null : omgt.clone(false));
		gtRtDTOFiltro.setGtDTO(gtDTO);
		gtRtDTOFiltro.setDtReferencia(DataHoraRN.stringToDate(dtreferencia,
				"dd/MM/yyyy"));
		return getTelaMonitorizacaoMaquina(gtRtDTOFiltro,
				DwConsolidTemplate.TpId.TURNO);
	}
	
}

