/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.util;

import java.util.Comparator;

import idw.webservices.dto.PlanoAcompanhamentoDTO;

/**
 *
 * @author Hugo
 */
public class OrdenadorAcompanhamentos implements Comparator<PlanoAcompanhamentoDTO> {

    @Override
    public int compare(PlanoAcompanhamentoDTO o1, PlanoAcompanhamentoDTO o2) {
        int diferenca = o1.getCnt().compareTo(o2.getCnt());

        if(diferenca != 0) {
            return diferenca;
        }
        else {
        	      	
            diferenca = o1.getPasso().compareTo(o2.getPasso());
            return diferenca;
        }
    }
    
}
