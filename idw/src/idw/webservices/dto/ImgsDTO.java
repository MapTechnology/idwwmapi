/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author milton
 */
@SuppressWarnings("serial")
public class ImgsDTO implements Serializable {
    private List<ImgDTO> imgs;

	public List<ImgDTO> getImgs() {
		return imgs;
	}

	public void setImgs(List<ImgDTO> imgs) {
		this.imgs = imgs;
	}
    
}