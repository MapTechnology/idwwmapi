package ms.coleta.andon;

import java.util.List;
import java.util.ListIterator;

import ms.coleta.dto.AndonDTO;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
public class AndonRN {

	private IIC adam = null;

	public AndonRN(IIC icAdam) {
		this.adam = icAdam;
	}

	public boolean processaEventosAndon(List<AndonDTO> listaEventosAndon, List<AndonDTO> ultimosParametrosAndon,
			List<ParametroDTO> listaSaidasAtivadas ) {
		//		List<ParametroDTO> listaSaidasAtivadas = new ArrayList<ParametroDTO>();
		ParametroDTO dadosParametro = null;
		AndonDTO novoEventoAndon;
		AndonDTO ultimoEventoAndon;
		boolean flagAtualizaLista = false;
		boolean flagListaPendenteAtualizacao = false;

		if (listaEventosAndon.size() > 0)
		{
			ListIterator<AndonDTO> ultimosParametrosReferencia = ultimosParametrosAndon.listIterator();

			for (int i = 0; i < listaEventosAndon.size(); i++)
			{
				novoEventoAndon = new AndonDTO(listaEventosAndon.get(i));
				//ultimoEventoAndon = new AndonDTO(ultimosParametrosReferencia.next());
				ultimoEventoAndon = ultimosParametrosReferencia.next();
				dadosParametro = new ParametroDTO();

				// Se o evento que est� na lista atualizada n�o est� na lista de eventos acionados, inicializ�-lo
				if (!novoEventoAndon.equals(ultimoEventoAndon)) {					
					dadosParametro = this.inicializarEventos(novoEventoAndon, ultimoEventoAndon);
					if(!flagAtualizaLista)
						flagListaPendenteAtualizacao = true;
					flagAtualizaLista = true;
				}
				// Se o evento ainda se mantem na lista, por�m houve mudan�a de par�metros de tempo, intermit�ncia ou ativa��o, este deve ser alterado
				else if(novoEventoAndon.verificaMudancaDeParametros(ultimoEventoAndon)) {
					dadosParametro = new ParametroDTO(novoEventoAndon);
					if(!flagAtualizaLista)
						flagListaPendenteAtualizacao = true;
					flagAtualizaLista = true;
				}
				// Se o evento ainda � o mesmo enviado para o ADAM, inserir este evento na lista de parametros.
				else if(flagAtualizaLista == true) {
					dadosParametro = new ParametroDTO(ultimoEventoAndon);
				}

				/* A c�pia do evento s� diz respeito aos parametros alterados.
				 * Agendador e verifica��o de inicializa��o de Timer n�o s�o copiados pois s�o mantidos em ultimosParametrosAndon por este 
				 * n�o ser vol�til.
				 * */
				if(flagAtualizaLista == true)
					ultimoEventoAndon.copyAndonDTO(novoEventoAndon);

				listaSaidasAtivadas.add(dadosParametro);
				if(flagListaPendenteAtualizacao == true) {
					flagListaPendenteAtualizacao = false;
					for(int j = 0; j < i; j++) {
						listaSaidasAtivadas.set(j, new ParametroDTO(listaEventosAndon.get(j)));
					}
				}
			}//for
		} else if (listaEventosAndon.size() <= 0) {
			// Desligar todos os andons
			AndonDTO eventoAndonLimpo = new AndonDTO();

			for (int i = 0; i < 16; i++)
			{
				if (ultimosParametrosAndon.get(i).getStativo() == 1)
				{
					eventoAndonLimpo.setIdrele(i + 1);
					eventoAndonLimpo.setStativo(0);
					eventoAndonLimpo.setStintermitente(0);
					eventoAndonLimpo.setTmpsinalalto(0);
					eventoAndonLimpo.setTmpsinalbaixo(0);
					ParametroDTO parametro = new ParametroDTO(eventoAndonLimpo);
					listaSaidasAtivadas.add(parametro);
					ultimosParametrosAndon.set(i, eventoAndonLimpo);
				}
			}
		}
		return flagAtualizaLista;
	}

	private ParametroDTO inicializarEventos(AndonDTO novoEventoAndon, AndonDTO ultimoEventoAndon){

		//Se o evento � do tipo ANDON_PARADA, chamar o scheduler e desligar o respectivo rel�.
		if (novoEventoAndon.isAndonParada() == true && ultimoEventoAndon.getTimerIniciado() == false){
			novoEventoAndon.iniciaVerificacaoEventoAgendado(this.adam);
			novoEventoAndon.setStativo(0);
			ultimoEventoAndon.setTimerIniciado(true);
		}
		//Se o evento � do tipo ANDON_INSPECAO_PENDENTE, chama o scheduler e liga o respectivo rel�
		else if(novoEventoAndon.isAndonInspecaoPendente() == true && ultimoEventoAndon.getTimerIniciado() == false) {
			novoEventoAndon.iniciaVerificacaoEventoAgendado(this.adam);
			ultimoEventoAndon.setTimerIniciado(true);
		}

		//Por fim, todos os eventos ser�o excutados.
		//Se o evento n�o for de um tipo que precise de tratamento especial, apenas execut�-lo.
		ParametroDTO retorno = new ParametroDTO(novoEventoAndon);

		return retorno;
	}

	
}
