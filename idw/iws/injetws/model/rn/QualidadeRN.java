package injetws.model.rn;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.Validate;

import ms.model.dao.AbstractPdbaInjetDAO;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.model.excessoes.MestreOfflineException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrColetorEventos;
import injetws.model.pojos.PrEventosBridgeCollecDb;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpProduto;
import injetws.webservices.dto.IwsInspecaoManualDTO;

public class QualidadeRN extends AbstractPdbaInjetDAO{
	
	IdwLogger log;
	
	public QualidadeRN(IdwLogger log,DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(log);
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.log = log;
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
	public IwsInspecaoManualDTO getTr_InspecaoManual(String CdMaquina, Date dthrEvento) throws SemSGBDException {
		Date dataHrAtual = dthrEvento;
		
		IwsInspecaoManualDTO resposta = new IwsInspecaoManualDTO();

		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = null;
		prup = infoRN.pesquisaPrupCdmaquina(log, 0, CdMaquina);	

		long milisegundos = dataHrAtual.getTime()%1000;
		
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(28));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dataHrAtual);
		prcoletoreventos.setMsdthr1evento((double)milisegundos);		
		prcoletoreventos.setDthr2evento(dataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dataHrAtual));

		
		PrEventosBridgeCollecDb eventoResposta = null;
		try{
			eventoResposta = infoRN.lancarEventoEsperaPrEventosBridgeCollecDb(log, 0, prcoletoreventos, true);
			
			if(eventoResposta.getTpevento().intValue() == new BigDecimal(31).intValue()) {
				resposta.setInf01(eventoResposta.getInf01());
				resposta.setInf02(eventoResposta.getInf02());
				resposta.setInf03(eventoResposta.getInf03());
				
				resposta.setErro(false);
			}
			else {
				resposta.setErro(true);
			}
				
		} catch (MestreOfflineException e){	
			resposta.setErro(true);
		}

		return(resposta);
	}
	
	public Boolean getTr_ValidaProdutoAA(String idUp, String cdProd ) throws SemSGBDException {	
		// valida id rdz produto
		PrUp prup = null;
		
		InfoRN oInfoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		prup = oInfoRN.pesquisaPrup(log, 0, idUp);
		
		Boolean valida = false;
		
		for (PrUpProduto prupproduto : prup.getPrUpProdutos()){
			if(cdProd.equals(new Character(prupproduto.getIdreduzidaproduto()).toString())){
				valida = true;
				break;
			}			
		}
		
		return(valida);
	}
	
	
}
