package idw.model.rn;

import idw.model.pojos.DwCal;
import idw.model.pojos.DwRota;
import idw.model.pojos.PpNec;
import idw.model.pojos.PpPlanec;
import idw.model.pojos.PpPlano;
import idw.model.rn.geraplano.GeraAbstractPlanoFactory;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;


public class SimulacaoRN extends PlanoProducaoRN{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IdwLogger log;
	
	public SimulacaoRN(PlanoDTO plano){
		super(plano);
	}
	
	public PlanoDTO simularPlano(){
		log = new IdwLogger("SimulacaoRN-simularPlano");
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		log.info(idLog, identacao, "Iniciando processamento do idPlano = "  + this.getIdPlano());
		
		PlanoDTO retorno = new PlanoDTO();
		
		// Verifica se o plano está apto a rodar
		//1o: somente planos com status de Cadastrados podem ser gerados
		if (this.isStatusCadastrado() == false){
			log.info(idLog, identacao + 10, "Tipo do plano diferente de CADASTRADO. Abortando execução da simulação");
			retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().TIPO_PLANO_DESCONHECIDO);
			return retorno;
		}
		//2o: verifica se o plano existe no banco
		PpPlano ppplano = null;
		ppplano = this.pesquisarPlanoById();
		if (ppplano == null){
			log.info(idLog, identacao + 10, "Plano desconhecido com idPlano = " + this.getIdPlano() + ". Abortando execução da simulação");
			retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().PLANO_DESCONHECIDO);
			return retorno;
		}
		
		// 3o: verifica se o plano é para considerar determinado calendario e se um calendario especifico foi informado
		DwCal dwcalEspecifico = null;
		if (this.getIsDeterminadocal() != null && this.getIsDeterminadocal() == true){
			CalendarioRN calRN = new CalendarioRN();
			calRN.setSession(dao.getSession());
			dwcalEspecifico = calRN.pesquisarDwCalByCdESt(getDwCal());
			if (dwcalEspecifico == null){
				log.info(idLog, identacao + 10, "Calendário desconhecido com cdCal = " + getDwCal().getCdCal() + ". Abortando execução da simulação");
				retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().CALENDARIO_DESCONHECIDO);
				return retorno;
			}else{
				ppplano.setDwCal(dwcalEspecifico);
			}
		}
		
		// 4o: verifica se existem as necessidades e se os produtos dessas necessidades possuem roteiro
		RoteiroRN rotRN = new RoteiroRN();
//		rotRN.setSession(dao.getSession());
		rotRN.setDaoSession(dao.getSession());
		
		PedidoClienteRN necRN = new PedidoClienteRN(dao);
		for (PpPlanec pnec : ppplano.getPpPlanecs()){
			// verificar se existem os planos e se os produtos tem roteiro
			necRN.setIdNec(pnec.getPpNec().getIdNec());
			PpNec n = null;
			n = necRN.pesquisarPpnecById();
			
			if (n == null){
				log.info(idLog, identacao + 10, "Necessidade desconhecida com idNec = " + pnec.getPpNec().getIdNec() + ". Abortando execução da simulação");
				retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().NECESSIDADE_DESCONHECIDA);
				return retorno;
			}
			DwRota dwrota = rotRN.pesquisarDwRotaByIdProduto(pnec.getPpNec().getOmProduto(), false);
			if (dwrota == null){
				log.info(idLog, identacao + 10, "Roteiro inconsistente para cdProduto = " + pnec.getPpNec().getOmProduto().getCdProduto() + ". Abortando execução da simulação");
				// nao existe roteiro para o produto
				retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().ROTEIRO_INCONSISTENTE);
				return retorno;
			}
		}
		retorno = new PlanoDTO(ppplano, dao);
		retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().COM_SUCESSO);
		
		log.iniciaAvaliacao(idLog, "processaPlano");
		log.info(idLog, identacao + 10, "Chamando processaPlano para o idPlano = " + ppplano.getIdPlano());
		// Chama um factory para determinar qual será o algoritmo a ser usado para processamento
		GeraAbstractPlanoFactory geradorPlano = GeraAbstractPlanoFactory.getInstancia(dao, ppplano.getPpTpplano().getTpAlgoritmo());
		retorno = geradorPlano.processaPlano(log, idLog, identacao + 10, ppplano, this.getOmUsrByIdUsrrevisao());
		if (retorno.getResultadoDTO().isComSucesso() == true)
			log.info(idLog, identacao + 10, "Finalizou processaPlano para o idPlano = " + ppplano.getIdPlano());
		else
			log.info(idLog, identacao + 10, "Finalizou processaPlano para o idPlano = " + ppplano.getIdPlano() + " com o erro " + retorno.getResultadoDTO().getIdmensagem() + ". Simulação abortada.");
		
		log.paraAvaliacao(dao);

		log.info(idLog, identacao, "Finalizando processamento do idPlano = "  + this.getIdPlano() + " em " + log.getAvaliacaoCompleta());

		log = null;
		
		return retorno;
	}
}
