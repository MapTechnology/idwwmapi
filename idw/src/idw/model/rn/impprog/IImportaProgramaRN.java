package idw.model.rn.impprog;

import idw.model.pojos.OmPt;
import idw.webservices.dto.ProgramaInsersoraDTO;
import idw.webservices.dto.ProgramasInsersorasDTO;

public interface IImportaProgramaRN {

	public ProgramaInsersoraDTO getProgramaInsersoraDTO(ProgramaInsersoraDTO programaInsersoraDTO);
	public ProgramasInsersorasDTO getProgramasInsersorasDTO(OmPt ompt);
	public void inicializacao();
	public void finalizacao();
}
