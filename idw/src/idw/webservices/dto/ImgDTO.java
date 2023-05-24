/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmImg;


/**
 *
 * @author milton
 */
@SuppressWarnings("serial")
public class ImgDTO implements Serializable {

	private OmImg img;

    private int resultadoEvento;

    /**
     * @return the img
     */
    public OmImg getImg() {
        return this.img;
    }

    /**
     * @param Img the Img to set
     */
    public void setImg(OmImg img) {
        this.img = img;
    }

    /**
     * @return the resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }

    /**
     * @param resultadoEvento the resultadoEvento to set
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }
	
}