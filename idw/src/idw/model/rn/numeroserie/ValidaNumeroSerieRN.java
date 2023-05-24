package idw.model.rn.numeroserie;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.agramkow.DAOGenericoAgramkow;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.agramkow.ResultsHeader;
import idw.model.rn.AbstractRN;
import idw.model.rn.CpRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.GrupoProdutoRN;
import idw.model.rn.PTRN;
import idw.model.rn.VerificaPassagemRN;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.agramkowsql.AgramkowSqlRN;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.model.rn.EventoRN;

public class ValidaNumeroSerieRN extends AbstractRN<DAOGenerico>{

	public enum TpRetornoValidaNS{
		RETORNO_NS_FORARANGE(-1),
		RETORNO_NS_INVALIDO(0),
		RETORNO_NS_VALIDO(1),
		RETORNO_NS_VALIDO_SEM_CICLO(2),
		RETORNO_NS_INVALIDO_NC(3),
		RETORNO_NS_VALIDO_PEDIR_QT(4),
		RETORNO_NS_NC(5),
		RETORNO_NS_INVALIDO_FMRT(6), //FALHOU O MAIS RECENTE TESTE (em processo manufatura) RELATIVO AO NS SOB VALIDAÇÃO
		RETORNO_NS_FORALIMITE(7);

		private final int value;
		private TpRetornoValidaNS(int value){
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}



	public ValidaNumeroSerieRN() {
		super(new DAOGenerico());
	}
	
	public ValidaNumeroSerieRN(DAOGenerico dao) {
		super(dao);
	}

	@Deprecated
	public int validaNumeroSerie(String cdpt, String nrop, String ns, String cdproduto, MensagemRecebida mensagem) {
		return validaNumeroSerie(cdpt, nrop, ns, mensagem, false);
	}

	/*
	 * Esse metodo eh chamado pela servico de validacao do refugo e pelo servico de validacao do NS
	 */
	public int validaNumeroSerie(String cdpt,String nrOp,String ns, Long idpt, boolean isValidarMontagem){

		MensagemRecebida msg = new MensagemRecebida();
		EventoColetado evento = new EventoColetado();
		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt);

		evento.setCb(ns);
		evento.setIcUpDTO(icupdto);
		evento.setCdop(nrOp);
		msg.setEventoColetado(evento);

		return validaNumeroSerie(cdpt, nrOp, ns, msg, isValidarMontagem);
	}
	

	/*
	 * Esse metodo eh chamado pela servico de validacao do refugo e pelo servico de validacao do NS. Agramkow específico.
	 */
	public int validaNumeroSerieAgramkow(String cdpt,String nrOp,String ns, Long idpt, boolean isValidarMontagem){

		MensagemRecebida msg = new MensagemRecebida();
		EventoColetado evento = new EventoColetado();
		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt);

		evento.setCb(ns);
		evento.setIcUpDTO(icupdto);
		evento.setCdop(nrOp);
		msg.setEventoColetado(evento);

		return validaNumeroSerieAgramkow(cdpt, nrOp, ns, msg, isValidarMontagem);
	}
	/*
	 * Esse metodo eh chamado INDIRETAMENTE pela servico de validacao do refugo e pelo servico de validacao do NS
	 * Especificamente para Tratar Validações adicionais junto a banco Agramkow (Whirlpool MAO)
	 */
	public int validaNumeroSerieTestesAgramkow(String ns, String serverPtAnterior, String codPtAnterior){

		// no momento essa regra retorna o resultado de validação relativo ao mais recente teste detectado para o bc dado e pt anterior.
		//
		// ok : TpRetornoValidaNS.RETORNO_NS_VALIDO
		// nok: TpRetornoValidaNS.RETORNO_NS_INVALIDO_FMRT
		
		// A mensagem sugerida para NOK: "Invalidado: o mais recente teste falhou ou não foi realizado teste para o Barcode informado no posto de teste anterior"

		int retorno = 0;
		
        Calendar calPesquisar = new GregorianCalendar();
        calPesquisar.add(Calendar.DAY_OF_MONTH, AgramkowSqlRN.NUM_DIAS_A_PARTIR_DATA_ATUAL);
    	
        
		List<ResultsHeader> lista;		
        DAOGenericoAgramkow daoagramkow = new DAOGenericoAgramkow();
        AgramkowSqlRN agramkowsqlrn = new AgramkowSqlRN( daoagramkow);
        retorno = TpRetornoValidaNS.RETORNO_NS_INVALIDO_FMRT.getValue();
		try{
			agramkowsqlrn.iniciaConexaoBanco();


			lista = agramkowsqlrn.getResultsHeaderMRTList(calPesquisar.getTime(), ns,  codPtAnterior, serverPtAnterior);
			if (lista!=null && lista.size()>0){
				for (ResultsHeader o : lista){
					if(o!=null && o.getStatus()!=null && o.getStatus().intValue()==1 ){//==1: PASS (0=fail)
						retorno = TpRetornoValidaNS.RETORNO_NS_VALIDO.getValue();
					}
					break;
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				agramkowsqlrn.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				agramkowsqlrn.finalizaConexaoBanco();
			}
		}
		agramkowsqlrn.finalizaConexaoBanco();
		agramkowsqlrn = null;
		daoagramkow = null;
		
		
		return retorno;
	}
	
	public static void main(String[] args) {
		ValidaNumeroSerieRN rn = new ValidaNumeroSerieRN();
		rn.iniciaConexaoBanco();
		//rn.validaNumeroSerie("EMB_LIN02", "00456001001", "A433D7BA785E", 1518l, false);
		int r = rn.validaNumeroSerie("EMB_LIN04", "01098401001", "C03DD94A4CB8", new MensagemRecebida(), false);
		System.out.println("result=" + r);
		//00456001001 - A433D7BA785E A433D7C4D734
		// 00517701001
		rn.finalizaConexaoBanco();
	}

	/* Metodo principal de validacao do numero de serie. Esse metodo deve garantir os seguintes testes:
	 * 	1) Não pode ser qualquer codigo de barras. Tem que ser um aceitável as configuracoes da folha. Ou no CB tem o codigo do produto, ou o codigo da plataforma
		2) Seguir as regras de montagem definidas na folha detalhe da montagem.
		3) Avaliar se o banco de macs deve ser averiguado
		4) Avaliar se existe alguma não conformidade no roteiro ou postos anteriores
		5) Incluir o NS valido no banco
	 */
	private int validaNumeroSerie(String cdpt, String nrOp, String ns, MensagemRecebida mensagem, boolean isValidarMontagem){

		int retorno = TpRetornoValidaNS.RETORNO_NS_INVALIDO.getValue();  // invalido

		CpRN crn = new CpRN(getDao());
		PTRN ptrn = new PTRN(getDao());
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoSession());
		VerificaPassagemRN rn = new VerificaPassagemRN(getDao());
		GrupoProdutoRN grn = new GrupoProdutoRN();
		grn.setDao(getDao());
		grn.setSession(getDaoSession());
		FolhaRN frn = new FolhaRN(getDao());

		OmPt ompt = null;
		PpCp ppcp = null;
		DwFolha dwfolha = null;
		
		try {
			 ompt = ptrn.getOmPt(cdpt);
		} catch (RegistroDesconhecidoException e) {
			ompt = null;
		}

		if (nrOp == null && ompt != null && ompt.getPpCp() != null) {
			nrOp = ompt.getPpCp().getNrop();
			ppcp = ompt.getPpCp();
		} else {
			ppcp = crn.pesquisarPpCpByNrDocCdPt(nrOp, cdpt);
		}
		
		dwfolha = frn.getDwFolhaAtiva(ppcp);
		
		// Executar a regra definida em dwfolhamoncomp
		// Se for posto de embalagem ou montagem avaliar dwfolhamoncomp. Se nao avaliar usando dwfolha
		PostoValidacaoFactory regra = PostoValidacaoFactory.getInstancia(ompt.getOmTppt());
		retorno = regra.avaliarRegra(dwfolha, ppcp, ns, isValidarMontagem, getDao());
		
		// Alem disso verificar o roteiro e nao conformidades
		if (	retorno != TpRetornoValidaNS.RETORNO_NS_INVALIDO_NC.getValue() && 
				retorno != TpRetornoValidaNS.RETORNO_NS_INVALIDO.getValue() &&
				retorno != TpRetornoValidaNS.RETORNO_NS_FORARANGE.getValue() &&
				retorno != TpRetornoValidaNS.RETORNO_NS_FORALIMITE.getValue())
			retorno = regra.verificarRoteiro(ns, ompt, rn);
		
		
		return retorno;
	}
	

	
	
	

	/* Metodo principal de validacao do numero de serie. Esse metodo deve garantir os seguintes testes:
	 * 	1) Não pode ser qualquer codigo de barras. Tem que ser um aceitável as configuracoes da folha. Ou no CB tem o codigo do produto, ou o codigo da plataforma
		2) Seguir as regras de montagem definidas na folha detalhe da montagem.
		3) Avaliar se o banco de macs deve ser averiguado
		4) Avaliar se existe alguma não conformidade no roteiro ou postos anteriores
		5) Incluir o NS valido no banco
		Específico para tratar de validações adicionais junto a banco Agramkow (Whirlpool)
	 */
	private int validaNumeroSerieAgramkow(String cdpt, String nrOp, String ns, MensagemRecebida mensagem, boolean isValidarMontagem){

		int retorno = TpRetornoValidaNS.RETORNO_NS_INVALIDO.getValue();  // invalido

		CpRN crn = new CpRN(getDao());
		PTRN ptrn = new PTRN(getDao());
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaoSession());
		VerificaPassagemRN rn = new VerificaPassagemRN(getDao());
		GrupoProdutoRN grn = new GrupoProdutoRN();
		grn.setDao(getDao());
		grn.setSession(getDaoSession());
		FolhaRN frn = new FolhaRN(getDao());

		OmPt ompt = null;
		PpCp ppcp = null;
		DwFolha dwfolha = null;
		
		try {
			 ompt = ptrn.getOmPt(cdpt);
		} catch (RegistroDesconhecidoException e) {
			ompt = null;
		}

		if (nrOp == null && ompt != null && ompt.getPpCp() != null && ompt.getPpCp().getNrop()!=null) {
			nrOp = ompt.getPpCp().getNrop();
			ppcp = ompt.getPpCp();
		} else {
			ppcp = crn.pesquisarPpCpByNrDocCdPt(nrOp, cdpt);
		}

		if (nrOp != null && ompt != null && ompt.getPpCp() != null && ompt.getPpCp().getNrop()!=null) {
			if(! nrOp.equals(ompt.getPpCp().getNrop())){
				ppcp = crn.pesquisarPpCpByNrDoc(nrOp);
				
				if (ppcp!=null && ppcp.getNrop()!=null){
					Calendar cale = new GregorianCalendar();
					crn.trocarOP(cdpt, ppcp.getNrop(), cale.getTime());
				}
				
				
				//nono ompt.setPpCp(ppcp);
				///NAOAQUI ompt = this.getDao().makePersistent(ompt);
			}
		}
		
		if (ppcp==null && nrOp!=null){
			ppcp = crn.pesquisarPpCpByNrDoc(nrOp);
		}
		
		
		dwfolha = frn.getDwFolhaAtiva(ppcp);
		
		// Executar a regra definida em dwfolhamoncomp
		// Se for posto de embalagem ou montagem avaliar dwfolhamoncomp. Se nao avaliar usando dwfolha
		PostoValidacaoFactory regra = PostoValidacaoFactory.getInstancia(ompt.getOmTppt());
		retorno = regra.avaliarRegra(dwfolha, ppcp, ns, isValidarMontagem, getDao());
		
		// Alem disso verificar o roteiro e nao conformidades
		if (retorno != TpRetornoValidaNS.RETORNO_NS_INVALIDO_NC.getValue() && retorno != TpRetornoValidaNS.RETORNO_NS_INVALIDO.getValue() )
			retorno = regra.verificarRoteiro(ns, ompt, rn);
		
		
		return retorno;
	}
	
	
}
