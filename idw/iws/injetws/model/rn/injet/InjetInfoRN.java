package injetws.model.rn.injet;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijbroneinjapt;
import idw.model.pojos.injet.Ijfictec;
import idw.model.pojos.injet.Ijmolpro;
import idw.model.pojos.injet.Ijregistrobarcode;
import idw.model.pojos.injet.Ijregultocorinj;
import idw.model.pojos.injet.Ijtbaco;
import idw.model.pojos.injet.Ijtbcau;
import idw.model.pojos.injet.Ijtbdnc;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.Ijtbinjandonprcsft;
import idw.model.pojos.injet.Ijtbjup;
import idw.model.pojos.injet.Ijtbproembalagem;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.injet.TurnoInjetDTO;
import idw.util.IdwLogger;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpProduto;
import injetws.model.rn.InfoRN;
import injetws.model.rn.UtilRN;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsFitesaDTO;
import injetws.webservices.dto.IwsFitesaDadosDTO;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsPesoProdutoDTO;
import injetws.webservices.dto.IwsRegistroBarCodeDTO;
import injetws.webservices.dto.IwsUpAndonPrcsftDTO;
import injetws.webservices.dto.IwsUpDTO;
import injetws.webservices.dto.IwsUpDncDTO;
import ms.model.dao.AbstractPdbaInjetDAO;

@SuppressWarnings("unchecked")
public class InjetInfoRN extends AbstractPdbaInjetDAO{
	
	public InjetInfoRN(DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	/**
	 * Pega o registro correspondente ao c?digo da injetora. Representa a
	 * unidade produtiva (UP)
	 * 
	 * @param cdInjetora
	 *            c?digo da injetora
	 * @return Ijtbinj
	 * @throws RegistroDesconhecidoException
	 */

	public Ijtbinj getIjtbinj(String cdInjetora) {
		StringBuilder hql = new StringBuilder();

		hql.append("select ijtbinj ");
		hql.append("from Ijtbinj ijtbinj ");
		hql.append("where (ijtbinj.cdinjetora = :cdInjetora)");

		Query q = getDaoInjet().getSession().createQuery(hql.toString());

		q.setParameter("cdInjetora", cdInjetora);

		Ijtbinj ijtbinj = null;
		ijtbinj = (Ijtbinj) q.uniqueResult();

		return ijtbinj;

	}

	/**
	 * Adquire o os produtos relacionados a rela??o molde x estrutura da ?ltima
	 * validade
	 * 
	 * @param cdMolde
	 *            c?digo do molde
	 * @param cdEstrutura
	 *            c?digo da estrutura
	 * @return lista do produtos da moldexestrutura
	 */

	public List<Ijmolpro> getListaIjmolpro(String cdMolde, String cdEstrutura) {
		return getListaIjmolpro(cdMolde, cdEstrutura, null, null);
	}

	/**
	 * Adquire o os produtos relacionados a rela??o molde x estrutura
	 * 
	 * @param cdMolde
	 *            c?digo do molde
	 * @param cdEstrutura
	 *            c?digo da estrutura
	 * @param dtHrIVal
	 *            filtra pela data/hora de in?cio de validade da estrutura
	 * @return lista do produtos da moldexestrutura
	 */

	public List<Ijmolpro> getListaIjmolpro(String cdMolde, String cdEstrutura,
			Date dtHrIVal) {
		return getListaIjmolpro(cdMolde, cdEstrutura, dtHrIVal, null);
	}

	/**
	 * Adquire o os produtos relacionados a rela??o molde x estrutura da
	 * validade que est? dentro do per?odo de referencia
	 * 
	 * @param cdMolde
	 *            c?digo do molde
	 * @param cdEstrutura
	 *            c?digo da estrutura
	 * @param dtHrReferencia
	 *            filtra por uma data/hora que esteja entre o in?cio e fim da
	 *            validade de estrutura
	 * @return lista do produtos da moldexestrutura
	 */

	public List<Ijmolpro> getListaIjmolpro(Date dtHrReferencia, String cdMolde,
			String cdEstrutura) {
	
		return getListaIjmolpro(cdMolde, cdEstrutura, null, dtHrReferencia);
	}

	/**
	 * Adquire o os produtos relacionados a rela??o molde x estrutura
	 * 
	 * @param cdMolde
	 *            c?digo do molde
	 * @param cdEstrutura
	 *            c?digo da estrutura
	 * @param dtHrIVal
	 *            filtra pela data/hora de in?cio de validade da estrutura
	 * @param dtHrReferencia
	 *            filtra por uma data/hora que esteja entre o in?cio e fim da
	 *            validade de estrutura caso
	 * @return lista do produtos da moldexestrutura
	 */

	public List<Ijmolpro> getListaIjmolpro(String cdMolde, String cdEstrutura,
			Date dtHrIVal, Date dtHrReferencia) {

		StringBuilder hql = new StringBuilder();

		hql.append(" SELECT ijmolpro ");
		hql.append(" FROM Ijmolpro ijmolpro ");
		hql.append(" WHERE (ijmolpro.id.cdmolde = :cdMolde)");
		hql.append(" AND (ijmolpro.id.cdestrutura = :cdEstrutura)");

		if (dtHrIVal != null) {
			hql.append(" AND (ijmolpro.id.dthrival= :dtHrIVal)");
		} else if (dtHrReferencia == null) {
			hql.append(" AND (ijmolpro.dthrfval IS NULL)");
		} else {
			hql.append(" AND (");
			hql.append("      (( :dtHrReferencia BETWEEN ijmolpro.id.dthrival AND ijmolpro.dthrfval) ");
			hql.append("        AND NOT ijmolpro.dthrfval IS NULL) ");
			hql.append(" 	  OR ");
			hql.append(" 	  ( ijmolpro.id.dthrival < :dtHrRef AND ijmolpro.dthrfval IS NULL");
		}

		hql.append(" ORDER BY ijmolpro.id.dthrival");

		Query q = getDaoInjet().getSession().createQuery(hql.toString());

		// Atualiza parametros
		q.setParameter("cdMolde", cdMolde);
		q.setParameter("cdEstrutura", cdEstrutura);

		if (dtHrIVal != null) {
			q.setTimestamp("dtHrIVal", dtHrIVal);
		} else {
			if (dtHrReferencia != null) {
				q.setTimestamp("dtHrReferencia", dtHrReferencia);
			}
		}

		// Recupera a lista
		List<Ijmolpro> listaIjmolpro = null;

		listaIjmolpro = q.list();

		return listaIjmolpro;

	}
	
	/**
	 * Adquire os dados do ciclo padr?o da ?ltima validade
	 * @param cdInjetora
	 *            c?digo da injetora 
	 * @param cdMolde
	 *            c?digo do molde
	 * @param cdEstrutura
	 *            c?digo da estrutura
	 * @return dados do ciclo padr?o
	 */

	public Ijfictec getIjfictec(String cdInjetora, String cdMolde, String cdEstrutura) {
		return getIjfictec(cdInjetora, cdMolde, cdEstrutura, null);
	}

	/**
	 * Adquire os dados do ciclo padr?o atrav?s da data/hora do in?cio de validade
	 * @param cdInjetora
	 *            c?digo da injetora 
	 * @param cdMolde
	 *            c?digo do molde
	 * @param cdEstrutura
	 *            c?digo da estrutura
	 * @param dtHrIVal
	 *            filtra pela data/hora de in?cio de validade do ciclo
	 * @return dados do ciclo padr?o
	 */

	public Ijfictec getIjfictec(String cdInjetora, String cdMolde, String cdEstrutura,
			Date dtHrIValCic) {

		List<Ijfictec> listaIjfictec = getListIjfictec(cdInjetora, cdMolde, cdEstrutura, dtHrIValCic, null);
		
		Ijfictec ijfictec = null;
		if (listaIjfictec.size() > 0 ){
			ijfictec = listaIjfictec.get(0);	
		}
		return ijfictec;
	}	
	
	/**
	 * Adquire os dados do ciclo padr?o
	 * @param cdInjetora c?digo da injetora
	 * @param cdMolde c?digo do molde
	 * @param cdEstrutura c?digo da estrutura
	 * @param dtHrIValCic filtra pela data/hora de in?cio de validade do ciclo
	 * @param dtHrReferencia filtra por uma data/hora que esteja entre o in?cio e fim da
	 *            validade do ciclo
	 * @return dados do ciclo padr?o
	 */
	public List<Ijfictec> getListIjfictec(String cdInjetora, String cdMolde, String cdEstrutura,
			Date dtHrIValCic, Date dtHrReferencia) {

		StringBuilder hql = new StringBuilder();

		hql.append(" SELECT ijfictec ");
		hql.append(" FROM Ijfictec ijfictec ");
		hql.append(" WHERE  (ijfictec.id.cdmolde = :cdMolde)");
		if(cdInjetora !=null){
			hql.append( " AND (ijfictec.id.cdinjetora = :cdInjetora)");
		}
		hql.append(" AND (ijfictec.id.cdestrutura = :cdEstrutura)");

		if (dtHrIValCic != null) {
			hql.append(" AND (ijfictec.id.dthrivalcic= :dtHrIVal)");
		} else if (dtHrReferencia == null) {
			hql.append(" AND (ijfictec.dthrfvalcic IS NULL)");
		} else {
			hql.append(" AND (");
			hql.append("      (( :dtHrReferencia BETWEEN ijfictec.id.dthrivalcic AND ijfictec.dthrfvalcic) ");
			hql.append("        AND NOT ijfictec.dthrfvalcic IS NULL) ");
			hql.append(" 	  OR ");
			hql.append(" 	  ( ijfictec.id.dthrivalcic < :dtHrRef AND ijfictec.dthrfvalcic IS NULL");
		}

		hql.append(" ORDER BY ijfictec.id.dthrivalcic");

		Query q = getDaoInjet().getSession().createQuery(hql.toString());

		// Atualiza parametros
		if(cdInjetora !=null){
			q.setParameter("cdInjetora", cdInjetora);
		}
		q.setParameter("cdMolde", cdMolde);
		q.setParameter("cdEstrutura", cdEstrutura);

		if (dtHrIValCic != null) {
			q.setTimestamp("dtHrIVal", dtHrIValCic);
		} else {
			if (dtHrReferencia != null) {
				q.setTimestamp("dtHrReferencia", dtHrReferencia);
			}
		}

		// Recupera a lista
		List<Ijfictec> listaIjfictec = null;
		
		listaIjfictec = q.list();		
		
		return listaIjfictec;

	}	
	
	/**
	 * Recupera o DNC da m?quina
	 * @param cdInjetora
	 * @return Dnc da m?quina
	 */	
	public Ijtbdnc getIjtbdnc(String cdInjetora){
		StringBuilder hql = new StringBuilder();
		
		hql.append(" SELECT ijtbdnc ");
		hql.append(" FROM Ijtbdnc ijtbdnc ");
		hql.append(" WHERE (ijtbdnc.cdinjetora = :cdInjetora)");

		Query q = getDaoInjet().getSession().createQuery(hql.toString());
		
		q.setParameter("cdInjetora", cdInjetora);
		
		Ijtbdnc ijtbdnc = null;

		ijtbdnc  = (Ijtbdnc) q.uniqueResult();
		
		return ijtbdnc;
	}
	
	/**
	 * Pega o DTO do DNC
	 * @param cdMaquina
	 * @return objeto DTO do DNC
	 */
	public IwsUpDncDTO getTr_DncTransferencia(String cdMaquina) {
		
		IwsUpDncDTO upDncDTO = new IwsUpDncDTO();
		
		Ijtbdnc ijtbdnc = getIjtbdnc(cdMaquina);

		if (ijtbdnc == null) {
			upDncDTO.setcodErro(IwsUpDncDTO.DADOS_AUSENTES);
		} else {
			upDncDTO.copyIjtbdnc(ijtbdnc);
			upDncDTO.setcodErro(IwsUpDncDTO.SEM_ERRO);
		}

		return upDncDTO;
	}

	
	/**
	 * Recupera o Andon da m?quina
	 * @param cdInjetora
	 * @return Andon da m?quina
	 */
	public Ijtbinjandonprcsft getIjtbinjandonprcsft(String cdInjetora){
		StringBuilder hql = new StringBuilder();
		
		hql.append(" SELECT ijtbinjandonprcsft ");
		hql.append(" FROM Iijtbinjandonprcsft ");
		hql.append(" WHERE (ijtbinjandonprcsft.cdinjetora = :cdInjetora)");

		Query q = getDaoInjet().getSession().createQuery(hql.toString());
		
		q.setParameter("cdInjetora", cdInjetora);
		
		Ijtbinjandonprcsft ijtbinjandonprcsft = null;

		ijtbinjandonprcsft = (Ijtbinjandonprcsft) q.uniqueResult();
		
		return ijtbinjandonprcsft;
	}
	
	/**
	 * Pega o DTO do Andon
	 * @param cdMaquina
	 * @return objeto DTO do Andon
	 */
	public IwsUpAndonPrcsftDTO setTr_getPrUpAndonPrcsft(String cdMaquina) {
		IwsUpAndonPrcsftDTO upAndonPrcsftDTO = new IwsUpAndonPrcsftDTO();
		
		Ijtbinjandonprcsft ijtbinjandonprcsft = getIjtbinjandonprcsft(cdMaquina);

		if (ijtbinjandonprcsft == null) {
			upAndonPrcsftDTO.seterro(true);
		} else {
			upAndonPrcsftDTO.copyIjandonprcsft(ijtbinjandonprcsft);
			upAndonPrcsftDTO.seterro(false);			
		}

		return upAndonPrcsftDTO;
	}
	
	
	public IwsListaUpDTO inicializacaoSemEvento(String mac) throws SemSGBDException {
		IwsListaUpDTO listaUpDTO = new IwsListaUpDTO();
		
		// TODO: verificar se vai ter isso
		// Verifica evento 18 de ativacao de UP para esse coletor
	//	verificaEvento18(mac);
	//	flushReiniciandoTransacao();
		
		// Obtem a lista de UPs
		List<Ijtbinj> ijtbups = null;
		
		try {
			ijtbups = getUps(mac);
		} catch (SemSGBDException e) {
			listaUpDTO.setIsSGBDOnline(false);

			return(listaUpDTO);
		}
		
		// TODO: verificar se retorna vazio ou seta alguma coisa
		// se nao existir up
		if(ijtbups.size() == 0) {
			return(listaUpDTO);
		}

		// Obtem o intervalo do ultimo heart-beat
		try{
			listaUpDTO.setDthrUltimoBeatColetor(getUpBeat(ijtbups));
		} catch (RegistroDesconhecidoException e) {
			// Nao conseguiu obter o valor do ultimo heartbeat, assumir data e hora atual
			listaUpDTO.setDthrUltimoBeatColetor(new Date());
		} catch (SemSGBDException e) {
			listaUpDTO.setIsSGBDOnline(false);

			return(listaUpDTO);
		}
		
		// pegando DwCfg
		/*
		DwCfg oDwCfg = null;
		try {
			oDwCfg = this.getDwCfg();
		} catch(Exception e) {
			// TODO: verificar o que fazer em caso de exce??o
		}
		
		long idPeproNormal, idPeproCip;
		if(oDwCfg != null) {
			idPeproNormal = oDwCfg.getDwPeproByIdPeproNormal().getIdPepro(); // obter id_prepro para periodo produtivo normal
			idPeproCip = oDwCfg.getDwPeproByIdPeproCip().getIdPepro(); // obter id_prepro para periodo produtivo cip
		}
		else {
			// TODO: verificar o que fazer nesse else
		}*/
		
		for (Ijtbinj oIjtbinj : ijtbups) {
			
			// convencionado aqui: seria copiado dados da itera??o, para usar adiante
			IwsUpDTO oUpDTO = new IwsUpDTO();
			oUpDTO.copyIjtbinj(oIjtbinj);
			
//			String hql = "";
			
			// atualizar em Ijregultocorinj, para Up da itera??o, o ultimo heart beat do coletor obtido anteriormente (de listaUpDTO.getDthrUltimoBeatColetor());
			this.atualizaHeartBeat(oIjtbinj.getCdinjetora(), listaUpDTO.getDthrUltimoBeatColetor());
			
//			TurnoDTO oTurnoAtualDTO = null;
//			oTurnoAtualDTO = obtemTurno(oIjtbinj.getCdinjetora(), new Date(), oIjtbinj.getIjop().getNrop()); // obtem o turno atual
			
			
			/**
			 * nao ligar para essa parte do codigo, soh mantinha ela aqui para
			 * auxilio, se quiser pode tirar DAQUI...
			 */
			// Atualiza em prup o ultimo heart beat do coletor
			/*prup.mudaDtHrUltimoHeartBeat(listaUpDTO.getDthrUltimoBeatColetor());
			prup.mudaMsDthrUltimoHeartBeat((double)DataHoraRN.getApenasMilisegundos(listaUpDTO.getDthrUltimoBeatColetor()));

			String hql = "";
			// PR_UP.StAguardRespMasterBridgeDB = ?0?
			hql = "";
			hql += "update PrUp prup ";
			hql += "set prup.staguardrespmasterbridgecldb = '0' ";
			hql += "where prup.idup = '::idup' ";

			hql = hql.replaceAll("::idup", prup.getIdup());

			Query q = getSession().createQuery(hql);

			q.executeUpdate();

			flushReiniciandoTransacao();

			// Obtem CPDTO para a UP
			CpDTO cpdto = new CpDTO();

			cpdto.setNrop(prup.getNrop());
			cpdto.setCdmolde(prup.getCdmolde());
			cpdto.setCdestrutura(prup.getCdestrutura());
			cpdto.setDthrIPlanejamento(prup.getDthriniplanejada());		
			if (prup.getTmpciclopadrao() != null)
				cpdto.setCicloPadrao(prup.getTmpciclopadrao().toString());
			else
				cpdto.setCicloPadrao("0");

			if (prup.getCfgperctmpcicloparauto() != null)
				cpdto.setCfgPercTmpCicloParAuto(prup.getCfgperctmpcicloparauto().floatValue());
			else
				cpdto.setCfgPercTmpCicloParAuto(0f);

			if (prup.getCfgperctoleranciasinalciclo() != null)
				cpdto.setCfgPercToleranciaSinalCiclo(prup.getCfgperctoleranciasinalciclo().floatValue());
			else
				cpdto.setCfgPercToleranciaSinalCiclo(0f);

			if (prup.getCfgtamanhoumpacoteciclos() != null)
				cpdto.setCfgTamanhoUmPacoteCiclos(prup.getCfgtamanhoumpacoteciclos().floatValue());
			else
				cpdto.setCfgTamanhoUmPacoteCiclos(0f);

			cpdto.setIsProducaoValida(true);
			cpdto.setIsSGBDOnline(true);	
			verificaIsComCIP(prup);
			listaUpDTO.addPrUp(prup, cpdto, getSession());			
		*/
		/**
		 * ...ATE AQUI
		 */
		}
		
		return(listaUpDTO);
	}
		
	public void atualizaHeartBeat(String cdInjetora, Date heartBeat) {
		String hql = "";
		
		hql += "UPDATE Ijregultocorinj ijregultocorinj ";
		hql += "SET ijregultocorinj.dthrultimaocor = :dthrultimaocor ";
		hql += "WHERE (ijregultocorinj.cdinjetora = '::cdinjetora')";
		
		hql = hql.replaceAll("::cdinjetora", cdInjetora);
		
		Query q = getDaoInjet().getSession().createQuery(hql);
		
		q.setTimestamp("dthrultimaocor", heartBeat);
		
		q.executeUpdate();
	}
	
	public Date getUpBeat(List<Ijtbinj> ijtbups) throws RegistroDesconhecidoException, SemSGBDException {
		// pegando codigos das injetoras
		StringBuilder oStringBuilder = new StringBuilder();
		oStringBuilder.append("(");
		int iCont = 0;
		for(Ijtbinj oIjtbinj : ijtbups) {
			if(iCont > 0) oStringBuilder.append(",");
			
			oStringBuilder.append(oIjtbinj.getCdinjetora());
			
			iCont = 1;
		}
		
		if(iCont == 0) { // nao tem query para fazer, pois nao tem cdinjetora
			return(new Date()); // retorna a data atual
		}
		
		oStringBuilder.append(")");
		String sListaCdInjetora = oStringBuilder.toString();
		
		String hql = "";
		
		hql += "SELECT ijregultocorinj ";
		hql += "FROM Ijregultocorinj ijregultocorinj ";
		hql += "WHERE (ijregultocorinj.cdinjetora IN ::listainjetora) ";
		hql += "ORDER BY dthrultimaocor DESC";
		
		hql = hql.replaceAll("::listainjetora", sListaCdInjetora);

		Query q = getDaoInjet().getSession().createQuery(hql);

		List<Ijregultocorinj> listaIjregultocorinj = null;
		try{
			listaIjregultocorinj = q.list();
		} catch (Exception e){
			throw new SemSGBDException();
		}

		Ijregultocorinj oIjregultocorinj = null;

		if (listaIjregultocorinj.size() > 0)
			oIjregultocorinj = listaIjregultocorinj.get(0);
		else
			throw new RegistroDesconhecidoException();
		
		Date resposta = oIjregultocorinj.getDthrultimaocor();

		return(resposta);
	}
	
	public List<Ijtbinj> getUps(String mac) throws SemSGBDException{
		String sql = "";
		
		// TODO: verificar se pode ser feito com SQL
		sql += "SELECT ijtbinj.* ";
		sql += "JOIN ijtbcoletores "; 
		sql += "JOIN ijtbsubcoletores ON (ijtbcoletores.cdmestre = ijtbsubcoletores.cdmestre AND ijtbcoletores.cdcoletor=ijtbsubcoletores.cdcoletor) ";
		sql += "JOIN ijtbinj ON (ijtbinj.cdsubcoletor = ijtbsubcoletores.cdsubcoletor AND ijtbinj.cdcoletor=ijtbcoletores.cdcoletor AND ijtbinj.cdmestre = ijtbcoletores.cdmestre) ";
		sql += "WHERE ijtbcoletores.idalterncoletor = '::mac'";
		
		sql = sql.replaceAll("::mac", mac);

		List<Ijtbinj> listaIjtbinj = null;

		Query q = getDaoInjet().getSession().createSQLQuery(sql);

		try{
			listaIjtbinj = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		return(listaIjtbinj);
	}
	
	public boolean setRegistroBarCode(IwsRegistroBarCodeDTO barcodeDTO){
		try{
			barcodeDTO.setDthrregistro(DataHoraRN.getDataHoraAtual(getDaoPdba()) );
			
			TurnoInjetDTO turnoInjetDTO = FuncoesApoioInjet.encontraTurno(getDaoInjet(), barcodeDTO.getDthrregistro());
			
			turnoInjetDTO.setDtReferencia(DataHoraRN.getDataSemHora(turnoInjetDTO.getDtReferencia()));
			
			barcodeDTO.setCdturno(turnoInjetDTO.getIjtbtur().getCdturno());
			barcodeDTO.setDtturno(turnoInjetDTO.getDtReferencia());
			
			Ijregistrobarcode regbarCode= new Ijregistrobarcode(
					barcodeDTO.getIdlinha(), 
					barcodeDTO.getDthrleitura(),
					barcodeDTO.getCdturno(), 
					barcodeDTO.getDtturno(), 
					barcodeDTO.getNrserie(), 
					barcodeDTO.getCdproduto(),
					barcodeDTO.getBarcode(), 
					barcodeDTO.getDthrregistro());
			
			getDaoInjet().makePersistent(regbarCode);
			
			
			/* Alessandre em 12-12-17 #4935
			 * A questão é que ao ler o 1o codigo de barras o ciclo nao eh contabilizado pq eh usado como referencia de inicio de ciclo
			 * então estou verficando se prup.iniciocilo estiver vazio, para na sequencia colocar um valor de referencia para inicio de ciclo
			 * pensei em colocar essa referencia de inicio de ciclo na entrada da op, mas nao eh valido pois podemos ter uma parada e se tivesse
			 * inicio de ciclo la teriamos uma producao que nao existe
			 */
			PrUp prup = getPrUp(barcodeDTO.getIdlinha());
			if (prup != null && prup.getDthrinicic() == null) {
				prup.setDthrinicic(barcodeDTO.getDthrleitura());
				prup.setInfoAdicional("inicioBarcode");
				getDaoPdba().makePersistent(prup);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private int fillDadosDTO(IwsRegistroBarCodeDTO dadosDTO){		
		//Trata c?digo de barras da ARTHI		
		String barcodeclean=dadosDTO.getBarcode().replace(".", "").replace("-","");
		
		int sizeBarCode=barcodeclean.length();
		if(sizeBarCode>=25){// Tamanho m?nimo para que a etiqueta seja aceita Formato antigo
			dadosDTO.setDtemisemb(barcodeclean.substring(0, 4));
			dadosDTO.setCdprodutoemb(barcodeclean.substring(4,8));
			dadosDTO.setCdproduto(dadosDTO.getCdprodutoemb());
			dadosDTO.setQtdprodemb(barcodeclean.substring(8,12));
			dadosDTO.setNrpedidoemb(barcodeclean.substring(12,20));
			dadosDTO.setSequencialemb(barcodeclean.substring(20,25));
		}else if(sizeBarCode>=19){// Tamanho mínimo para que a etiqueta seja aceita Formato novo
			dadosDTO.setDtemisemb(barcodeclean.substring(0, 4));
			dadosDTO.setCdprodutoemb(barcodeclean.substring(4,8));
			if(barcodeclean.substring(8,10).toUpperCase().equals("XX")){				
				dadosDTO.setCdproduto(dadosDTO.getCdprodutoemb());
			}
			else{
				dadosDTO.setCdproduto(dadosDTO.getCdprodutoemb()+"/"+barcodeclean.substring(8,10));
			}			
			dadosDTO.setQtdprodemb(barcodeclean.substring(10,13));
			dadosDTO.setNrpedidoemb(barcodeclean.substring(14,19));
			dadosDTO.setSequencialemb(barcodeclean.substring(14,19));
		}else{
			//log.info("Erro ao obter dados de código de barra, Dados Insuficientes: "+dadosDTO.getBarcode());
			return 2;
		}
		return 1;
	}
	
	private BigDecimal getPeso(String peso){
		BigDecimal retorno = BigDecimal.ZERO;
		peso=peso.replace("+", "");
		retorno= new BigDecimal(peso.replace(',', '.'));
		
		return retorno;
	}
	
	private boolean validaSeCdProdEstaEmUP(String idup,String cdProd){
		boolean retorno = false;
		MapQuery q = new MapQuery(this.getDaoPdba().getSession());
		q.append("select otbl ");
		q.append("from PrUpProduto otbl");
		q.append("where otbl.cdproduto = :cdprod");
		q.append("and otbl.prUp.idup = :idup");
		q.defineParametro("cdprod", cdProd);
		q.defineParametro("idup", new BigDecimal(idup));
		q.setMaxResults(1);		
		PrUpProduto otbl = (PrUpProduto) q.uniqueResult();
		
		if (otbl != null) {
			retorno= true;
		}
		otbl = null;
		q = null;
		return retorno;
		
	}

	
	private String getCdMaquina(String idup){
		String retorno = "XXXXXX";
		MapQuery q = new MapQuery(this.getDaoPdba().getSession());
		q.append("select otbl ");
		q.append("from PrUp otbl");
		q.append("where otbl.idup = :idup");
		q.defineParametro("idup", new BigDecimal(idup));
		q.setMaxResults(1);		
		PrUp otbl = (PrUp) q.uniqueResult();
		
		if (otbl != null) {
			retorno= otbl.getCdmaquina();
		}
		otbl = null;
		q = null;
		return retorno;
		
	}

	private PrUp getPrUp(String cdup){
		MapQuery q = new MapQuery(this.getDaoPdba().getSession());
		q.append("select a ");
		q.append("from PrUp a");
		q.append("where a.cdmaqestendido = :cd");
		q.append("and a.stativa = 1");
		q.defineParametro("cd", cdup);
		q.setMaxResults(1);		
		PrUp otbl = (PrUp) q.uniqueResult();
		q = null;
		return otbl;
		
	}
	
	private boolean validaSeBarCodeJaFoiTratado(String barcode){
		boolean retorno = false;
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());
		q.append("select otbl ");
		q.append("from Ijregistrobarcode otbl");
		q.append("where otbl.barcode = :barcode");
		q.append("and otbl.stevento = '1'");
		q.defineParametro("barcode", barcode);
		q.setMaxResults(1);		
		Ijregistrobarcode otbl = (Ijregistrobarcode) q.uniqueResult();
		
		if (otbl != null) {
			//log.info("Barcode: "+barcode+" J? inserido em Ijregistrobarcode com stevento 1");
			retorno= true;
		}
		otbl = null;
		q = null;
		return retorno;
		
	}
	

	public IwsPesoProdutoDTO getPesoProduto(IdwLogger log, int idLog,String idUP,String Cdprod){
		IwsPesoProdutoDTO retorno = new IwsPesoProdutoDTO();
				
		InfoRN infoRN = new InfoRN(this.getDaoInjet(),this.getDaoPdba());
		
		PrUp prup = infoRN.pesquisaPrup(log, idLog, idUP);
		
		if(prup !=null){
			MapQuery q = new MapQuery(this.getDaoInjet().getSession());
			q.append("select otbl ");
			q.append("from Ijmolpro otbl");
			q.append("where otbl.id.cdproduto = :cdprod");
			q.append("and otbl.id.cdmolde = :cdmolde");
			q.append("and otbl.id.cdestrutura = :cdestrutura");
			q.append("and otbl.dthrfval is NULL");
			q.defineParametro("cdprod", Cdprod);
			q.defineParametro("cdmolde", prup.getCdmolde());
			q.defineParametro("cdestrutura", prup.getCdestrutura());
			q.setMaxResults(1);		
			Ijmolpro otbl = (Ijmolpro) q.uniqueResult();
		
			if (otbl != null) {
				retorno.setPliquidomedio(new BigDecimal(otbl.getPliquidomedio()));
				retorno.setPbrutomedio(new BigDecimal(otbl.getPbrutomedio()));
			
				retorno.getStatus().setSucesso(true);						
			}else{
				retorno.getStatus().setMensagem("PESO INDISPONIVEL: "+Cdprod);
				retorno.getStatus().setSucesso(false);	
			}
			otbl = null;
			q = null;
		}
		return retorno;
	} 


	
	public IwsFitesaDTO getDadosFitesa(String ip){
		IwsFitesaDTO retorno = new IwsFitesaDTO();		
		
				
		MapQuery q = new MapQuery(this.getDaoPdba().getSession());
		q.append("select prup");
		q.append("from PrUp prup");
		q.append("join fetch prup.prSubColetor prsubcoletor");
		q.append("join fetch prsubcoletor.prColetor prcoletor");
		q.append("where prcoletor.idcoletor = :idcoletor");
		q.append("and prup.stativa = '1' ");
		q.defineParametro("idcoletor", ip);
		
		List<PrUp> prups = q.list();
		
		if(prups != null && prups.size() > 0){
			for(PrUp prup: prups){
				if(prup.getNropestendido()!=null){
					for(PrUpProduto produto: prup.getPrUpProdutos()){
						q = null;
						q = new MapQuery(this.getDaoInjet().getSession());
						q.append("select otbl.larguranombobina ");
						q.append("from IjtbproFitAux otbl");
						q.append("where otbl.cdproduto = :cdproduto");
						q.defineParametro("cdproduto", produto.getCdproduto());
						q.setMaxResults(1);
						BigDecimal largura = (BigDecimal)q.uniqueResult();
						if(largura != null){
							IwsFitesaDadosDTO dados = new IwsFitesaDadosDTO();
							dados.setOp(prup.getNropestendido());
							dados.setSubcoletor(prup.getPrSubColetor().getIdsubcoletor().intValue());
							dados.setLarguranomminal(largura.intValue());
							retorno.addUpProdLargura(dados);
							retorno.setTemDado(true);
						}						
					}
				}
			}
		}else{
			System.out.println("ERRO SEM UP VINCULADO AO IP:"+ip);
		}
		
		q = null;
			
		return retorno;
	}
	
	private IwsErroDTO validaPesoDaEmbalagem(String Cdprod,BigDecimal dPeso,int quantidade){
		IwsErroDTO retorno = new IwsErroDTO();
		retorno.setSucesso(false);
		
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());
		q.append("select otbl ");
		q.append("from Ijtbproembalagem otbl");
		q.append("where otbl.ijtbpro.cdproduto = :cdprod");
		q.defineParametro("cdprod", Cdprod);
		q.setMaxResults(1);		
		Ijtbproembalagem otbl = (Ijtbproembalagem) q.uniqueResult();
		// TARA + peso
		// se estiver dentro da faixa efetua o lan?amento
		// sen?o devolve mensagem:
		// PESO ACIMO DO LIMITE ou PESO ABAIXO DO LIMITE stevento=2
		// 
		if (otbl != null) {
			double peso = dPeso.doubleValue();
			//Comapara Limites de Peso
			double limiteSuperior=otbl.getTaraembalagem()+(quantidade*otbl.getLimsuppesoproduto());
			double limiteInferior=otbl.getTaraembalagem()+(quantidade*otbl.getLiminfpesoproduto());
		
			if(peso>limiteSuperior){
				retorno.setMensagem("PESO ACIMA DO LIMITE:" + limiteSuperior);
			}else if(peso<limiteInferior){
				retorno.setMensagem("PESO ABAIXO DO LIMITE:" + limiteInferior);
			}else{
				retorno.setSucesso(true);
			}			
		}else{
			retorno.setMensagem("PRODUTO INVALIDO: "+Cdprod);
		}
		otbl = null;
		q = null;
		return retorno;
	}
	
	public IwsErroDTO setValidaPesagem(String idUp,IwsRegistroBarCodeDTO dadosDTO,String Peso){
		IwsErroDTO retorno = new IwsErroDTO();
		int stevento=1;
		retorno.setSucesso(false);
		try{			
			if(fillDadosDTO(dadosDTO)!=1){
				retorno.setMensagem("ERRO AO TRATAR COD. DE BARRAS: "+dadosDTO.getBarcode());
				stevento=2;
			}
			BigDecimal dPeso =getPeso(Peso);
			if((stevento==1) &&(dPeso== BigDecimal.ZERO)){
				retorno.setMensagem("ERRO AO TRATAR PESO: "+Peso);
				stevento=2;
			}
			if((stevento==1) &&
				(validaSeCdProdEstaEmUP(idUp,dadosDTO.getCdproduto())==false)){
				retorno.setMensagem("PRODUTO "+dadosDTO.getCdproduto()+" NAO PERTENCE A OP");
				stevento=2;
				
			}
			
			if(stevento==1){
				int quantidade = Integer.parseInt(dadosDTO.getQtdprodemb());
				if(quantidade<=0){
					retorno.setMensagem("Quantidade Invalida: "+dadosDTO.getQtdprodemb());
					stevento=2;
				}else{
					retorno= validaPesoDaEmbalagem(dadosDTO.getCdproduto(),dPeso,quantidade);
					if(retorno.getSucesso()==false){
						stevento=2;
					}
				}
			}					
			// verifica se etiqueta j? passou com STEVENTO=1
			// se j? passou devolve mensagem
			// ETIQUETA JA EXISTE NO SISTEMA stevento=2
			if((stevento==1) && (validaSeBarCodeJaFoiTratado(dadosDTO.getBarcode())==true)){
				retorno.setMensagem("ETIQUETA "+dadosDTO.getBarcode()+ " JA EXISTE NO SISTEMA");
				stevento=2;			
			}
			
			dadosDTO.setDthrregistro(DataHoraRN.getDataHoraAtual(getDaoPdba()) );
			TurnoInjetDTO turnoInjetDTO = FuncoesApoioInjet.encontraTurno(getDaoInjet(), dadosDTO.getDthrregistro());
			
			dadosDTO.setCdturno(turnoInjetDTO.getIjtbtur().getCdturno());
			dadosDTO.setDtturno(turnoInjetDTO.getDtReferencia());
			dadosDTO.setNrserie(dadosDTO.getSequencialemb());
			dadosDTO.setIdlinha(getCdMaquina(idUp));
			// Insere dado estando OK ou n?o para servir como LOG					
			Ijregistrobarcode regbarCode= new Ijregistrobarcode(dadosDTO.getIdlinha(), dadosDTO.getDthrregistro(),
					dadosDTO.getCdturno(), dadosDTO.getDtturno(), dadosDTO.getNrserie(), dadosDTO.getCdproduto(),
					dadosDTO.getBarcode(), dadosDTO.getDthrregistro(),dadosDTO.getCdprodutoemb(),dadosDTO.getQtdprodemb(),
					dadosDTO.getNrpedidoemb(),dadosDTO.getSequencialemb(),retorno.getMensagem(),String.valueOf(stevento));	
			getDaoInjet().makePersistent(regbarCode);
			if(stevento==1){
				retorno.setSucesso(true);
			}else{
				retorno.setSucesso(false);			
			}			
		}catch(Exception e){
			e.printStackTrace();
			retorno.setMensagem("NAO FOI POSSIVEL VALIDAR, TENTE NOVAMENTE");
			retorno.setSucesso(false);
		}
		return retorno;
	}
	
	public boolean setDadosColetados(injetws.webservices.dto.IwsDadosColetadosDTO dadosDTO){	
		try{
			String sql = "";
			sql += "INSERT INTO Ijdrvcolcelcar (idmaquina,idcaracteristica,vllido,dthrleitura,dthrstleitura,stleitura,cdgrpparam)";
			sql += "VALUES((SELECT idauxdrivercelcar from IjTbInjAuxDrvCelC where cdinjetora=:cdMaquina),:tpTeste,:ValorLido,:dthrEvt,:dthrAtual,'0',:cdgrpparam)";			

			Query q = this.getDaoInjet().getSession().createSQLQuery(sql);			
		
			q.setParameter("cdMaquina",dadosDTO.getCdMaquina());
			q.setParameter("tpTeste",dadosDTO.getIdCaracteristica());
			q.setParameter("ValorLido",dadosDTO.getValorLido());
			q.setParameter("dthrEvt",dadosDTO.getDtHrLeitura());
			q.setParameter("dthrAtual",DataHoraRN.getDataHoraAtual(getDaoPdba()));
			q.setParameter("cdgrpparam", dadosDTO.getCdgrpparam());
			q.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
			
	
	public Boolean validaCausa(String cdCausa) {
		boolean retorno = false;
		cdCausa = UtilRN.getCodigoPadraoInjet(cdCausa);
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());		
		q.append("from Ijtbcau ijtbcau ");
		q.append("where (ijtbcau.cdcausas = :cdcausa) and (ijtbcau.stativo = 1)  and (ijtbcau.tipocausa = 1 )");
		q.defineParametro("cdcausa", cdCausa);
		q.setMaxResults(1);
		
		Ijtbcau oijtbcau = (Ijtbcau)q.uniqueResult();
		if(oijtbcau!=null)			
			retorno = true;
		
		return retorno;		
	}
	
	public Boolean validaAcao(String cdAcao) {
		
		boolean retorno = false;
		cdAcao = UtilRN.getCodigoPadraoInjet(cdAcao);
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());		
		q.append("from Ijtbaco ijtbaco ");
		q.append("where (ijtbaco.cdacoes = :cdAcao) and (ijtbaco.stativo = 1) and (ijtbaco.tipoacao = 1 )");
		q.defineParametro("cdAcao", cdAcao);
		q.setMaxResults(1);
		
		Ijtbaco oijtbaco = (Ijtbaco)q.uniqueResult();
		if(oijtbaco!=null)			
			retorno = true;
		
		return retorno;
	}	
	
	public Boolean validaJustificativa(String cdJustificativa) {
		boolean retorno = false;
		cdJustificativa = UtilRN.getCodigoPadraoInjet(cdJustificativa);
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());		
		q.append("from Ijtbjup ijtbjup ");
		q.append("where (ijtbjup.cdjustparada = :cdJustificativa) and (ijtbjup.stativo = 1)");
		q.defineParametro("cdJustificativa", cdJustificativa);
		q.setMaxResults(1);
		
		Ijtbjup oijtbjup = (Ijtbjup)q.uniqueResult();
		if(oijtbjup!=null)			
			retorno = true;
		
		return retorno;		
	}	
	
	public void verificaIntegDoal(PrUp prup) {
		
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());		
		q.append("from Ijbroneinjapt obj ");
		q.append("where obj.cdinjetora=:cdMaquina and");
		q.append("obj.aponta='1'");
		q.defineParametro("cdMaquina", prup.getCdmaquina());
		q.setMaxResults(1);		
		
		Ijbroneinjapt obj = (Ijbroneinjapt)q.uniqueResult();
		if(obj!=null){			
			prup.setStintegdoal('1');
		}else{
			prup.setStintegdoal('0');
		}	
		this.getDaoPdba().getSession().merge(prup);
		this.getDaoPdba().flushReiniciandoTransacao();
		return;		
	}
	
	public IwsErroDTO mudaCavidadesAtivasNomolde(PrUp prup, int valor,Date dthr,Ijtbusu usuario) {
		IwsErroDTO retorno = new IwsErroDTO();
		 List<Ijmolpro>  listmolde =getListaIjmolpro(prup.getCdmolde(), prup.getCdestrutura());
		 if(listmolde!=null && listmolde.size()>0){
			 if(listmolde.size()>1){
				 retorno.setMensagem("Mais de Um Molde Ativo Encontrado!");
				 retorno.setSucesso(false);
			 }else{
				 Ijmolpro molde = listmolde.get(0);	
				 List<Ijfictec> listFictec = getListIjfictec(null,prup.getCdmolde(),prup.getCdestrutura(),null,null); 
				 if((double)valor > molde.getQtcavidades()){
					 retorno.setMensagem("Max Cavidades=" + molde.getQtcavidades().doubleValue());
					 retorno.setSucesso(false);
				 }else if(valor <= 0){
					 retorno.setMensagem("Min Cavidades Ativas=1");
					 retorno.setSucesso(false);
				 }else if((double)valor == molde.getQtcavativas().doubleValue()){
					 retorno.setMensagem("Molde Ja pussui "+valor+" Cavidades Ativas");
					 retorno.setSucesso(false);
				 }else{
					 Ijmolpro novoMolde = (Ijmolpro)molde.clone();
					 Date dthrSemMs= DataHoraRN.getDataSemMilisegundos(dthr);
					 novoMolde.getId().setDthrival(dthrSemMs);
					 novoMolde.setDthrfval(null);
					 novoMolde.setQtcavativas((double)valor);	
					 novoMolde.setIjtbusu(usuario);
					 molde.setDthrfval(dthrSemMs);
					 getDaoInjet().makePersistent(molde);	
					 getDaoInjet().makePersistent(novoMolde);						 
					 for(Ijfictec fictec:listFictec){
						 Ijfictec fictecNovo= (Ijfictec) fictec.clone();
						 fictec.setDthrfvalcic(dthrSemMs);
						 fictecNovo.getId().setDthrivalcic(dthrSemMs);
						 fictecNovo.setDthrfvalcic(null);
						 fictecNovo.setDthrivalestru(dthrSemMs);
						 fictecNovo.setIjtbusu(usuario);
						 getDaoInjet().makePersistent(fictec);	
						 getDaoInjet().makePersistent(fictecNovo);	
					 }
					 retorno.setSucesso(true);
					 getDaoInjet().flushReiniciandoTransacao();
				 }
			 }
		 }else{
			 retorno.setMensagem("Molde N?o encontrado");
			 retorno.setSucesso(false);
		 }
		return retorno;
	}

}
