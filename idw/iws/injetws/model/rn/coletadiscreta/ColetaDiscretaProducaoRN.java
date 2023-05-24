package injetws.model.rn.coletadiscreta;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.util.IdwLogger;
import injetws.model.excessoes.MestreOfflineException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrColetorEventos;
import injetws.model.pojos.PrEventosBridgeCollecDb;
import injetws.model.pojos.PrUp;
import idw.model.rn.DataHoraRN;
import injetws.model.rn.InfoRN;
import injetws.webservices.dto.IwsColetaDiscretaOPProdutoDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import ms.model.dao.AbstractPdbaInjetDAO;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.CharacterType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;

@SuppressWarnings("unchecked")
public class ColetaDiscretaProducaoRN extends AbstractPdbaInjetDAO {

	IdwLogger log;
	
	public ColetaDiscretaProducaoRN(IdwLogger log,DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(log);
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.log = log;
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
	public double getTr_OPQtdUltApont (String idOPEmAberto) throws SemSGBDException {
		double retorno = 0;
		
		String hql="";
		
		hql += "SELECT * ";
		hql += "  FROM PR_UP_OPS_EM_ABERTO_PROD ";
		hql += " WHERE idopemaberto = '" + idOPEmAberto + "'";

		Query q = getDaoPdba().getSession().createSQLQuery(hql)
			.addScalar("idopemaberto", StringType.INSTANCE)
			.addScalar("cdproduto", StringType.INSTANCE)
			.addScalar("idreduzidaproduto", CharacterType.INSTANCE)
			.addScalar("qtplan", DoubleType.INSTANCE)
			.addScalar("qtprodliqanterior", DoubleType.INSTANCE)
			.addScalar("siglaumprodliqanterior", StringType.INSTANCE)
			.setResultTransformer(Transformers.aliasToBean(IwsColetaDiscretaOPProdutoDTO.class));
		
		try{
			List<IwsColetaDiscretaOPProdutoDTO> listaRegistros = q.list();
			if (listaRegistros.size() > 0) {
				retorno = listaRegistros.get(0).getQtprodliqanterior();
				}
			}
	    catch (Exception e) 
	    	{
			e.printStackTrace();
			}
				
		return retorno;
		
	}

	public void setTr_ApontaProducaoColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao, String qtdApontada) throws MestreOfflineException, SemSGBDException {	
		
		Date dataHrAtual = dthrEvento;
		
		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = null;
		prup = infoRN.pesquisaPrup(log, 0, idUp);	
		
		long milisegundos = dataHrAtual.getTime()%1000;
		
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(33));

		/*
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		*/
		
		prcoletoreventos.setDthr1evento(dataHrAtual);
		prcoletoreventos.setMsdthr1evento((double)milisegundos);		
		prcoletoreventos.setDthr2evento(dataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dataHrAtual));
		
		prcoletoreventos.setNrop(nrOP);
		prcoletoreventos.setInf01(cdOperacao);
		prcoletoreventos.setInf02(qtdApontada);
		
		//PrEventosBridgeCollecDb eventoResposta = null;		
		infoRN.lancarEventoEsperaPrEventosBridgeCollecDb(log, 0, prcoletoreventos, false);

	}	

	public String getTr_ApontaRefugoColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao, String qtdRefugada) throws MestreOfflineException, SemSGBDException {
		String retorno = "";
		
		Date dataHrAtual = dthrEvento;
		
		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = null;
		prup = infoRN.pesquisaPrup(log, 0, idUp);	
		
		long milisegundos = dataHrAtual.getTime()%1000;
		
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(34));

		prcoletoreventos.setDthr1evento(dataHrAtual);
		prcoletoreventos.setMsdthr1evento((double)milisegundos);		
		prcoletoreventos.setDthr2evento(dataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dataHrAtual));
		
		prcoletoreventos.setNrop(nrOP);
		prcoletoreventos.setInf01(cdOperacao);
		prcoletoreventos.setInf02(qtdRefugada);
		
		PrEventosBridgeCollecDb eventoResposta = null;
		
		eventoResposta = infoRN.lancarEventoEsperaPrEventosBridgeCollecDb(log, 0, prcoletoreventos, true);
		retorno = eventoResposta.getInf01();
		
		return  retorno;
	}
}
