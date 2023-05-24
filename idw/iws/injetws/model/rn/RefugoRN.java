package injetws.model.rn;

import injetws.model.excessoes.MestreOfflineException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrColetorEventos;
import injetws.model.pojos.PrEventosBridgeCollecDb;
import injetws.model.pojos.PrUp;
import injetws.model.rn.injet.InjetRefugoRN;
import injetws.webservices.dto.IwsDefeitoDTO;
import injetws.webservices.dto.IwsRefugoComDefeitosDTO;
import injetws.webservices.dto.IwsRefugoDTO;

import java.math.BigDecimal;
import java.util.Date;

import ms.excessao.ServicoFalhouException;
import ms.model.dao.AbstractPdbaInjetDAO;
import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.DataHoraRN;
import idw.model.rn.pdba.ProducaoPdbaMsEvtRN;
import idw.util.IdwLogger;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;


public class RefugoRN extends AbstractPdbaInjetDAO{
	
	IdwLogger log;
	
	public RefugoRN(IdwLogger log,DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(log);
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.log = log;
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
	public PrUp pesquisaPrup(String idUp){
		String hql = "";
		hql += "select prup ";
		hql += "from PrUp prup ";
		hql += "where prup.idup = '::idup'";

		hql = hql.replaceAll("::idup", idUp);

		Query q = getDaoPdba().getSession().createQuery(hql);

		PrUp retorno = (PrUp) q.uniqueResult();

		return retorno;
	}
	
	public IwsRefugoDTO getInfoUltimoRefugo(String IdUp)throws SemSGBDException{
		IwsRefugoDTO resposta = new IwsRefugoDTO();
		
		Date DataHrAtual;
		DataHrAtual=DataHoraRN.getDataHoraAtual(getDaoPdba());
		PrUp prup = null;
		prup = pesquisaPrup(IdUp);
		
		resposta.setIsRefugoValido(true);
		
		if(prup.getMsdthrultimorefugo() == null) {
			resposta.setMilissegundos(0);	
		} else {
			resposta.setMilissegundos(prup.getMsdthrultimorefugo().longValue());
		}
		
		if(prup.getDthrultimorefugo()==null) {
			resposta.setDthrUltRefugo(DataHrAtual);
		} else {
			resposta.setDthrUltRefugo(prup.getDthrultimorefugo());
		}
		
		resposta.setCdRefugo(prup.getCdultimorefugo());

		if(prup.getIdreduzidaproduto()==null) {
			resposta.setIdReduzidaProd("");
		} else {
			resposta.setIdReduzidaProd(""+prup.getIdreduzidaproduto());
		}
		
		return resposta;	
		
	}
	
	public IwsRefugoDTO setTr_LancaEventoRefugoComDefeitos(IwsRefugoComDefeitosDTO refugoComDefeitosDTO, Date dthrRefugo)throws SemSGBDException, ServicoFalhouException{
		//espa�o reservado para lan�ar evento de refugo
		//throw new RegistroDesconhecidoException();
		String idUp = refugoComDefeitosDTO.getIdUP();
		Date dataHrAtual = dthrRefugo;
		String cdRefugo = "";
		String idRdzProduto = refugoComDefeitosDTO.getIdRdzProduto();
		Float quantidade = 0f;
		
		for (IwsDefeitoDTO defeitoDTO : refugoComDefeitosDTO.getDefeitos()){
			if (Float.valueOf(defeitoDTO.getQuantidade()) > quantidade){
				cdRefugo = defeitoDTO.getCdDefeito();
				quantidade = Float.valueOf(defeitoDTO.getQuantidade());
			}
		}
		InjetRefugoRN iRN = new InjetRefugoRN(getDaoInjet());
			
		
		cdRefugo=iRN.getTr_ValidaCodDescRefugo(cdRefugo);		
		
		IwsRefugoDTO resposta = new IwsRefugoDTO();

		PrUp prup = null;
		prup = pesquisaPrup(idUp);	

		long milisegundos = dataHrAtual.getTime()%1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(12));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dataHrAtual);
		prcoletoreventos.setMsdthr1evento((double)milisegundos);		
		prcoletoreventos.setDthr2evento(dataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dataHrAtual));
		prcoletoreventos.setInf01(cdRefugo);
		prcoletoreventos.setInf02(idRdzProduto);
		prcoletoreventos.setInf03(refugoComDefeitosDTO.getQuantidade());
		prcoletoreventos.setInf04(null);
		prcoletoreventos.setInf05(null);		

		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrEventosBridgeCollecDb eventoResposta = null;
		try{
			eventoResposta = infoRN.lancarEventoEsperaPrEventosBridgeCollecDb(log, 0, prcoletoreventos, true);
		} catch (MestreOfflineException e){	

			resposta.setIsRefugoValido(false);
			return resposta;
		}		

		String retorno = eventoResposta.getInf01();		
		if(retorno.compareTo("0") == 0){
			resposta.setIsRefugoValido(false);		
			resposta.setMilissegundos(0);
			resposta.setDthrUltRefugo(dataHrAtual);
			resposta.setCdRefugo("");
			resposta.setIdReduzidaProd("");
		}else if(retorno.compareTo("1") == 0){	
			prup.setIdreduzidaproduto(idRdzProduto.charAt(0));
			prup.setCdultimorefugo(cdRefugo);
			prup.setDthrultimorefugo(dataHrAtual);
			prup.setMsdthrultimorefugo((double)milisegundos);	
			resposta.setIsRefugoValido(true);
			resposta.setMilissegundos(milisegundos);
			resposta.setDthrUltRefugo(dataHrAtual);
			resposta.setCdRefugo(cdRefugo);
			resposta.setIdReduzidaProd(idRdzProduto);
			getDaoPdba().flushReiniciandoTransacao();
			// Alessandre em 3-11-2014
			// Caso o idw esteja ativo � necess�rio lan�ar um inicio de ciclo com o mesmso horario de prup.dthriniciocci
			// Pois os dois sistemas precisam ter a mesma referencia de ciclo
			if (IdwFacade.getInstancia().isIDWAtivo() == true) {
				// Caso ocorra qualquer problema, o processo nao deve parar e seguir em frente pra finalizar execucao do metodo
					ProducaoPdbaMsEvtRN idwRN = new ProducaoPdbaMsEvtRN();
						idwRN.executarServico(getDaoPdba().getSession(), cdRefugo/*cdRefugo*/, null/*cdCausa*/, null/*cdAcao*/, refugoComDefeitosDTO.getQuantidade()/*Quantidade*/, prup.getIdup().toString()/*IdUp*/, idRdzProduto/*idRdzProduto*/, dataHrAtual /*DataHrAtual*/);
			}

		}
		return resposta;
	}

}