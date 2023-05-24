package injetws.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class IwsListModDTO implements Serializable {

	private List<IwsModDTO> lstModDTO = new ArrayList<IwsModDTO>();
	private boolean existeModDTO = false;
	/**
	 * @param modDTOs the lstModDTO to set
	 */
	public void setListModDTO(List<IwsModDTO> modDTO) {
		this.lstModDTO = modDTO;
	}
	/**
	 * @return the lstModDTO
	 */
	public List<IwsModDTO> getListModDTO() {
		return lstModDTO;
	}
	/**
	 * @param erro the erro to set
	 */
	public void setExisteModDTO(boolean ExisteModDTO) {
		this.existeModDTO = ExisteModDTO;
	}
	/**
	 * @return the existeModDTO
	 */
	public boolean isExisteModDTO() {
		return existeModDTO;
	}
	
	public void copyListModDTO(List<IwsModDTO> modDTOs) {
		if(modDTOs != null) {
			for(IwsModDTO modDto : modDTOs) {
				IwsModDTO mod = new IwsModDTO();
				mod.setIdUsuario(modDto.getIdUsuario());
				mod.setLogin(modDto.getLogin());
				mod.setNome(modDto.getNome());
				mod.setIdGrupoUsu(modDto.getIdGrupoUsu());
				mod.setDthrLogin(modDto.getDthrLogin());
				mod.setDthrLogout(modDto.getDthrLogout());
				
				this.lstModDTO.add(mod);
			}
			existeModDTO = true;
		}
		else this.lstModDTO = null;
	}
}
