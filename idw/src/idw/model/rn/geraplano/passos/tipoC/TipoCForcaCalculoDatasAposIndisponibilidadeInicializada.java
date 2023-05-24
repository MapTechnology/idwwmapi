	package idw.model.rn.geraplano.passos.tipoC;

import java.util.SortedMap;

import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.IdwLogger;

public class TipoCForcaCalculoDatasAposIndisponibilidadeInicializada {
	
	public void geraCpsForcandoRecalculoDatas(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, 
			SortedMap<IdCtDTO, CtDTO> lista){
		
		for (IdCtDTO id : lista.keySet()){
			CtDTO ct = lista.get(id);
			if (ct.getId().getOmptEscolhido().getCdPt().equals("|00001"))
				System.out.println("deb");
			for (PassosDTO passo : ct.getPassosAlocadosJaOrdenadosPeloFimComEspelhoAjustado(log, idLog, identacao)){
				System.out.println(passo);
				passo.calculaDatasFim(); //DatasInicioFim(log, idLog, identacao, passo.getFim()); // o false nao foi passado pois as datas das predecessoras devem ser recalculadas, apenas no proximo passo que removerosconflitos nao devemos considerar o recalculo das predecessoras
				System.out.println(passo);
			}
		}
				
	}
}
