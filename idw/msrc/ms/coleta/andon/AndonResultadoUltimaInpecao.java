package ms.coleta.andon;

import ms.coleta.dto.AndonDTO;
import ms.model.dto.UpDTO;
import ms.excessao.AndonFalhouException;

public class AndonResultadoUltimaInpecao implements IAndon {

	public static int _RESULTADO_APROVADO = 1;
	public static int _RESULTADO_REPROVADO = 2;
	public static int _RESULTADO_APROVADO_COM_RESTRICAO = 3;
	public static int _SEM_RESULTADO = 0;
	@Override
	public boolean executaAndon(UpDTO UpDTO, AndonDTO andondto) throws AndonFalhouException {
		
		if(UpDTO.getResultadoUltimaInspecao() == _SEM_RESULTADO)
			return false;
		if(andondto.getTpeventoandon() == 4 && UpDTO.getResultadoUltimaInspecao() == _RESULTADO_REPROVADO)
            return true;
		if(andondto.getTpeventoandon() == 5 && UpDTO.getResultadoUltimaInspecao() == _RESULTADO_APROVADO_COM_RESTRICAO)
			return true;
		if(andondto.getTpeventoandon() == 6 && UpDTO.getResultadoUltimaInspecao() == _RESULTADO_APROVADO)
			return true;
		
		return false;
	}
}
