package idw.model.rn.monitorizacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.ReferenciaCircularGtPaiComGtFilho;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmedparamlog;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwFolhamedtemhor;
import idw.model.pojos.DwFolhamedtemp;
import idw.model.pojos.DwFolhamedtemphorcfg;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.PpCp;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.GTsDTO;
import idw.webservices.dto.GtDTO;
import idw.webservices.dto.GtImgMonitorizacaoDTO;
import idw.webservices.dto.GtRtDTO;
import idw.webservices.dto.ImgDTO;
import idw.webservices.dto.ImgsDTO;
import idw.webservices.dto.ObjDTO;
import idw.webservices.dto.ObjRtDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.dto.ObjsDTO;
import idw.webservices.dto.ObjsRtDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.dto.PtImgMonitorizacaoDTO;

public class MonitorizacaoRN extends AbstractRN<DAOGenerico> {

	public MonitorizacaoRN() {
		this(null);
	}

	public MonitorizacaoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	

	
	// Web_Service para recuperar a lista de PTs e as imgs dos objetos.

	public PtImgMonitorizacaoDTO getImgsPTsDTO() {

		// hql para recupar as urls das imgs
		MapQuery query = new MapQuery(getDaoSession());
		query.append("select img from OmImg img");
		query.appendWhere(null, "img.stAtivo=1", true);

		List<OmImg> listaImagens = query.list();
		List<ImgDTO> listaImagensClones = new ArrayList<ImgDTO>();
		ImgsDTO imgsDTO = new ImgsDTO();

		// clonando as imagens
		if (listaImagens != null) {
			for (OmImg img : listaImagens) {
				ImgDTO imgDTO = new ImgDTO();
				imgDTO.setImg(img.clone());
				listaImagensClones.add(imgDTO);
			}
		}

		imgsDTO.setImgs(listaImagensClones);

		// construindo hql para recuperar PTs
		query.novaConsulta();

		query.append("select pt from OmPt pt");
		query.append("Where pt.stAtivo=1");

		List<OmPt> listaPts = query.list();

		List<PtDTO> listaPtDTO = new ArrayList<PtDTO>();

		if (listaPts != null) {
			for (OmPt pt : listaPts) {
				PtDTO ptDTO = new PtDTO();
				ptDTO.setPt(pt.clone());
				listaPtDTO.add(ptDTO);
			}
		}

		PTsDTO ptsDTO = new PTsDTO();
		ptsDTO.setPts(listaPtDTO);

		PtImgMonitorizacaoDTO resultado = new PtImgMonitorizacaoDTO();
		resultado.setImgsDTO(imgsDTO);
		resultado.setPtsDTO(ptsDTO);

		return resultado;
	}

	public GtImgMonitorizacaoDTO getImgsGTsDTO() {

		// hql para recupar as urls das imgs
		MapQuery query = new MapQuery(getDaoSession());
		query.append("select img from OmImg img");
		query.appendWhere(null, "img.stAtivo=1", true);

		List<OmImg> listaImagens = query.list();
		List<ImgDTO> listaImagensClones = new ArrayList<ImgDTO>();
		ImgsDTO imgsDTO = new ImgsDTO();

		// clonando as imagens
		if (listaImagens != null) {
			for (OmImg img : listaImagens) {
				ImgDTO imgDTO = new ImgDTO();
				imgDTO.setImg(img.clone());
				listaImagensClones.add(imgDTO);
			}
		}

		imgsDTO.setImgs(listaImagensClones);

		// construindo hql para recuperar PTs
		query.novaConsulta();

		query.append("select gt from OmGt gt");
		query.append("Where gt.stAtivo=1");

		List<OmGt> listaGts = query.list();

		List<GtDTO> listaGtDTO = new ArrayList<GtDTO>();

		if (listaGts != null) {
			for (OmGt gt : listaGts) {
				GtDTO gtDTO = new GtDTO();
				gtDTO.setGt(gt.clone());
				listaGtDTO.add(gtDTO);
			}
		}

		GTsDTO gtsDTO = new GTsDTO();
		gtsDTO.setGts(listaGtDTO);

		GtImgMonitorizacaoDTO resultado = new GtImgMonitorizacaoDTO();
		resultado.setImgsDTO(imgsDTO);
		resultado.setGtsDTO(gtsDTO);

		return resultado;
	}

	/**
	 * Pega uma lista de imagens
	 * 
	 * @param filtro
	 *            <p>
	 *            filtro.getImg().getIdImg() -> filtra pelo id de OmImg
	 *            <p>
	 *            filtro.getImg().getCdImg() -> filtra pelo c�digo de OmImg
	 *            <p>
	 *            se alguns dos parametros acima estiver null ou "" -> pega
	 *            todos as imagens
	 * @return
	 */
	public ImgsDTO getImgsDTO(ImgDTO filtro, boolean clonaResultado) {
		String hql = "";
		hql += "select omimg ";
		hql += "from OmImg omimg ";
		hql += "where omimg.stAtivo=1 ";
		if ((filtro != null) && (filtro.getImg() != null)) {
			if (filtro.getImg().getIdImg() != 0) {
				hql += "and omimg.idImg = ::idImg:"
						+ filtro.getImg().getIdImg();
				hql = hql.replaceAll("::idImg:",
						String.valueOf(filtro.getImg().getIdImg()));
			} else if ((filtro.getImg().getCdImg() != null)
					&& !filtro.getImg().getCdImg().equals("")) {
				hql += "and omimg.cdImg = " + filtro.getImg().getCdImg();
				hql = hql.replaceAll("::cdImg:",
						String.valueOf(filtro.getImg().getCdImg()));
			}
		}

		MapQuery q = new MapQuery(getDaoSession());

		q.append(hql);

		List<OmImg> listaOmImg = null;

		listaOmImg = q.list();

		List<ImgDTO> lista = new ArrayList<ImgDTO>();

		for (OmImg omImg : listaOmImg) {
			ImgDTO img = new ImgDTO();
			img.setImg((clonaResultado ? (OmImg) omImg.clone() : omImg));

			lista.add(img);
		}

		ImgsDTO imgs = new ImgsDTO();
		imgs.setImgs(lista);
		return imgs;

	}

	/**
	 * Recupera os objetos espec�ficos do Grupo de trabalho
	 * 
	 * @param idGt
	 *            Id do grupo de trabalho
	 * @return
	 */
	public ObjsDTO getObjsDTO(IdwLogger log, long idGt, Long idPt, boolean clonaResultado) {
		ObjDTO objDTO = new ObjDTO();
		objDTO.setObj(new OmObj());
		objDTO.getObj().setOmGtByIdGt(new OmGt());
		objDTO.getObj().getOmGtByIdGt().setIdGt(idGt);
		objDTO.getObj().setOmPt(new OmPt());
		objDTO.getObj().getOmPt().setIdPt(idPt);

		return this.getObjsDTO(log, objDTO, clonaResultado);
	}

	/**
	 * Recupera os objetos conforme o filtro
	 * 
	 * @param filtro
	 *            <p>
	 *            <code>filtro.getObj().getOmGtByIdGt().getIdGt()</code> pega
	 *            objetos relacionados IdGt indicado
	 *            <p>
	 *            <code>filtro.getObj().getOmGtByIdGtfilho().getIdGt()</code>
	 *            pega objetos relacionados IdGt filho indicado
	 *            <p>
	 *            <code>filtro.getObj().getOmPt().getIdGt()</code> pega objetos
	 *            relacionados IdPt indicado
	 *            <p>
	 *            pega todos os objetos, caso nenhum filtro foi passado
	 * @param clonaResultado
	 *            <p>
	 *            itens da lista devem ser clonados
	 * @return lista de OmObj
	 */
	public ObjsDTO getObjsDTO(IdwLogger log, ObjDTO filtro, boolean clonaResultado) {

		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select distinct omObj");
		q.append("from OmObj omObj");
		q.append("left join fetch omObj.omGtByIdGt");
		q.append("left join fetch omObj.omGtByIdGtfilho");
		q.append("left join fetch omObj.omPt ompt");
		q.append("left join fetch ompt.omTppt omtppt");
		q.append("left join fetch omtppt.omAlgocor omalgocor");
		q.append("left join fetch omObj.omImg omimg");
		
		q.appendWhere(MapQuery._NULL, "omObj.omGtByIdGt.idGt=:idGt",
						filtro.getObj() != null && 
						filtro.getObj().getOmGtByIdGt() != null &&
						filtro.getObj().getOmGtByIdGt().getIdGt() != null &&
						filtro.getObj().getOmGtByIdGt().getIdGt().equals(0l) == false
						);
		q.appendWhere(MapQuery._AND, "omObj.dwRotaByIdRota is null", true);
		
		q.appendWhere(
				MapQuery._AND,
				"omObj.omGtByIdGtfilho.idGt = :idGtfilho",
				filtro.getObj() != null
						&& (filtro.getObj().getOmGtByIdGtfilho() != null)
						&& (filtro.getObj().getOmGtByIdGtfilho().getIdGt() != 0));
		q.appendWhere(MapQuery._AND, "omObj.omPt.idPt=:idPt",
				filtro.getObj() != null && filtro.getObj().getOmPt() != null && filtro.getObj().getOmPt().getIdPt() != null && filtro.getObj().getOmPt().getIdPt() != 0);

		if (filtro.getObj() != null) {
			// IdGtFilho
			if ((filtro.getObj().getOmGtByIdGt() != null) && filtro.getObj().getOmGtByIdGt().getIdGt() != null && (filtro.getObj().getOmGtByIdGt().getIdGt() != 0)) {
				q.defineParametro("idGt", filtro.getObj().getOmGtByIdGt().getIdGt());
			}

			// IdGtfilho
			if ((filtro.getObj().getOmGtByIdGtfilho() != null) && filtro.getObj().getOmGtByIdGtfilho() != null && (filtro.getObj().getOmGtByIdGtfilho().getIdGt() != 0)) {
				q.defineParametro("idGtfilho", filtro.getObj().getOmGtByIdGtfilho().getIdGt());
			}
			// Pt
			if (filtro.getObj().getOmPt() != null && filtro.getObj().getOmPt().getIdPt() != null && filtro.getObj().getOmPt().getIdPt() != 0) {
				q.defineParametro("idPt", filtro.getObj().getOmPt().getIdPt());
			}
		}

		List<OmObj> listaOmObj = null;

		q.query().setTimeout(LockOptions.NO_WAIT);
		q.query().setLockOptions(LockOptions.NONE);
		
		if (log != null) log.iniciaAvaliacao("list() em omobj " + q.hqlToString());
		listaOmObj = q.list();
		if (log != null) log.mostrarAvaliacaoCompleta();

		// Passa o resultado para uma lista de ObjDTO
		if (log != null) log.iniciaAvaliacao("clonagem do retorno list");
		List<ObjDTO> lista = new ArrayList<ObjDTO>();
		for (OmObj omObj : listaOmObj) {
			ObjDTO obj = new ObjDTO();
			obj.setObj((clonaResultado ? omObj.clone(true) : omObj));

			// Clonar o PT e o Tipo do PT
			if (clonaResultado == true && omObj.getOmPt() != null) {
				obj.getObj().setOmPt(omObj.getOmPt().clone(false));
				if (omObj.getOmPt().getOmGt() != null)
					obj.getObj().getOmPt().setOmGt(omObj.getOmPt().getOmGt().clone(false));
				obj.getObj().getOmPt().setOmTppt(omObj.getOmPt().getOmTppt().clone(false));
				obj.getObj().getOmPt().getOmTppt().setOmAlgocor(omObj.getOmPt().getOmTppt().getOmAlgocor().clone(false));
			}

			lista.add(obj);
		}
		if (log != null) log.mostrarAvaliacaoCompleta();
		ObjsDTO Objs = new ObjsDTO();
		Objs.setObjs(lista);

		return Objs;
	}

	/**
	 * Remove objetos
	 * 
	 * @param objsDTO
	 */

	public void removeObj(ObjsDTO objsDTO) {
		List<OmObj> objs = new ArrayList<OmObj>();

		for (ObjDTO obj : objsDTO.getObjs()) {
			objs.add(obj.getObj());
		}

		this.removeObj(objs);
	}

	/**
	 * Remove objetos
	 * 
	 * @param objs
	 */
	public void removeObj(List<OmObj> objs) {
		for (OmObj obj : objs) {
			this.getDaoSession().delete(obj);
		}
	}

	/**
	 * Pega toda a arvore de objetos do gt
	 * 
	 * @param gt
	 * @return obj e seus descentes do gt
	 * @see #getArvoreObjsGt(OmGt, OmGt)
	 */
	public ObjsDTO getArvoreObjsGt(GtDTO gt) {
		ObjsDTO objsDTO = new ObjsDTO();

		gt.getGt().setOmObjsForIdGt(new HashSet<OmObj>());
		try {
			gt.getGt().setOmObjsForIdGt(this.getArvoreObjsGt(gt.getGt(), null));
		} catch (ReferenciaCircularGtPaiComGtFilho e) {

			e.printStackTrace();
		}

		return objsDTO;
	}

	/**
	 * Prepara o GT com os seus objetos descendentes
	 * 
	 * @param gtRoot
	 *            <p>
	 *            Grupo de trabalho por onde come�ou a arvore
	 * @param gtFilho
	 *            <p>
	 *            se <code>!= null</code> indica que est� procurando um subitem
	 * @return
	 * @throws ReferenciaCircularGtPaiComGtFilho
	 */
	public Set<OmObj> getArvoreObjsGt(OmGt gtRoot, OmGt gtFilho)
			throws ReferenciaCircularGtPaiComGtFilho {
		Set<OmObj> retorno = null;

		if (gtFilho != null) {
			// Verifica se objetos do gt j� est� na arvore
			// Procura desde o root se o filho deste gt j� existe na �rvore
			retorno = gtRoot.getObjs(gtFilho);
		} else {
			gtFilho = gtRoot;
		}

		if (retorno != null) {
			return retorno;
		}
		gtFilho.setOmObjsForIdGt(new HashSet<OmObj>());

		ObjDTO filtroObj = new ObjDTO();

		filtroObj.setObj(new OmObj());

		filtroObj.getObj().setOmGtByIdGt(gtFilho);

		ObjsDTO objsDTO = this.getObjsDTO(null, filtroObj, false);
		OmObj obj = null;

		if (objsDTO != null) {
			for (ObjDTO objDTOItem : objsDTO.getObjs()) {

				obj = objDTOItem.getObj().clone(false);

				// Adicio objetos no filho
				gtFilho.getOmObjsForIdGt().add(objDTOItem.getObj());

				if (obj.getOmGtByIdGtfilho() != null) {

					// Verifica se item possui como gtFilho o gtRoot
					if (obj.getOmGtByIdGtfilho().getIdGt() == gtRoot.getIdGt()) {
						throw new ReferenciaCircularGtPaiComGtFilho(
								gtRoot.descendenciaFilho(obj.getOmGtByIdGt()));
					}

					// Progra os objetos dos GtFilho do obj atual
					obj.getOmGtByIdGtfilho().setOmObjsForIdGt(
							this.getArvoreObjsGt(gtRoot, gtFilho));
				}

			}
			retorno = gtFilho.getOmObjsForIdGt();
		}

		return retorno;
	}

	/**
	 * Salva objetos do Grupo de trabalho
	 * 
	 * @param gt
	 */
	public void setObj(OmGt gt) {

		// Crit�rios para n�o continuar o processamento
		if (gt.getOmObjsForIdGt() == null) {
			return;
		}

		// Apaga objs que pertenciam ao GT
		this.removeObjs(gt);

		// Adiciona os novos objetos do GT
		Set<OmObj> objs = new HashSet<OmObj>();
		for (OmObj objItem : gt.getOmObjsForIdGt()) {
			objs.add((OmObj) getDao().makePersistent(objItem));
		}

		// Atualiza objetos de GT
		gt.setOmObjsForIdGt(objs);

	}

	public void removeObjs(OmGt gt) {
		
		if (
				gt == null ||
				(gt != null && gt.getIdGt() == null) ||
				(gt != null && gt.getIdGt() != null && gt.getIdGt().equals(0l))) {
			return;
		}

		OmObj obj = new OmObj();
		obj.setOmGtByIdGt(gt);
		ObjDTO objDTO = new ObjDTO();
		objDTO.setObj(obj);
		ObjsDTO objsDTO = this.getObjsDTO(null, objDTO, false);

		// Apaga objs que pertenciam ao GT
		this.removeObj(objsDTO);

	}



	/**
	 * Dados monitorizacao em tempo real do Grupo de Trabalho
	 * 
	 * @param objDTO
	 * @return <code>OmObj</code> com detalhes da monitoriza��o
	 */
	public GtRtDTO getGtRtDTO(GtRtDTO gtRtDTOFiltro) {

		// Instancia objeto de retorno
		GtRtDTO gtRtDTO = new GtRtDTO();
		gtRtDTO.setObjsRtDTO(new ObjsRtDTO());
		gtRtDTO.getObjsRtDTO().setObjsRt(new ArrayList<ObjRtDTO>());
		gtRtDTO.setGtDTO(new GtDTO());
		gtRtDTO.getGtDTO().setGt(gtRtDTOFiltro.getGtDTO().getGt());

		// pega os objetos que fazem parte do GT
		ObjsDTO objsDTO = this.getObjsDTO(null, gtRtDTOFiltro.getGtDTO().getGt().getIdGt(), gtRtDTOFiltro.getIdPt(), true);

		// guardar a data/hora atual para o grupo de trabalho
		gtRtDTO.setDtReferencia(DataHoraRN.getDataHoraAtual());

		ObjRtDTO objRtDTOItem = null;

		for (ObjDTO objDTOItem : objsDTO.getObjs()) {

			objRtDTOItem = this.getObjRtDTO(objDTOItem);

			gtRtDTO.getObjsRtDTO().getObjsRt().add(objRtDTOItem);

		}

		return gtRtDTO;

	}

	/**
	 * Pega um OmObj inicializado
	 * 
	 * @return
	 */
	public ObjDTO getOmObjInicializado() {
		ObjDTO objDTO = new ObjDTO();
		objDTO.setObj(new OmObj());
		return objDTO;
	}


	public ObjRtMonitorizacaoDTO getInfoTemperatura(DwConsolid dwci) {

		final int TEMPERATURA_CRITICA_INFERIOR = 0;
		final int TEMPERATURA_ACEITAVEL_INFERIOR = 1;
		final int TEMPERATURA_IDEAL = 2;
		final int TEMPERATURA_ACEITAVEL_SUPERIOR = 3;
		final int TEMPERATURA_CRITICA_SUPERIOR = 4;

		ObjRtMonitorizacaoDTO retorno = new ObjRtMonitorizacaoDTO();
		final Long FATOR_MULTIPLICACAO_DIA = 100000l;

		try {
			MapQuery query = new MapQuery(this.getDaoSession());

			// Recupera dados da �ltima temperatura lida -- dwConsolmedparamocos
			query.append("SELECT DISTINCT a");
			query.append("FROM DwConsolmedparamlog a");
			query.append("LEFT JOIN a.dwConsolParammeds b");
			query.append("LEFT JOIN b.dwConsolParam c");
			query.append("LEFT JOIN c.dwConsol dwc");
			query.append("LEFT JOIN dwc.dwConsolid dwci");
			query.append("LEFT JOIN dwci.dwFolha dwfolha");
			query.append("LEFT JOIN dwfolha.dwFolhamedtemps fmt");
			query.append("LEFT JOIN fmt.dwFolhamedtemhors fmth");
			query.append("LEFT JOIN fmth.dwFolhamedtemphorcfgs fmthc");

			query.append("WHERE dwci.idConsolid = :idConsolid");
			query.append("ORDER BY a.idConsolmedparamlog DESC");
			query.defineParametro("idConsolid", dwci.getIdConsolid());
			query.setMaxResults(1);

			DwConsolmedparamlog dwConsolmedparamlog;

			try {
				dwConsolmedparamlog = (DwConsolmedparamlog) query.uniqueResult();
				retorno = new ObjRtMonitorizacaoDTO();
				if (dwConsolmedparamlog != null && dwConsolmedparamlog.getVlrLido() != null)
					retorno.setUltimaTemperaturaLida(dwConsolmedparamlog.getVlrLido().doubleValue());
				else
					retorno.setUltimaTemperaturaLida(0d);

				Date dthrUltimaLeitura;
				if (dwConsolmedparamlog != null)
					dthrUltimaLeitura = dwConsolmedparamlog.getDthrMedicao();
				else
					dthrUltimaLeitura = DataHoraRN.getDataHoraAtual();
				
				int diaSemana = DataHoraRN.getWeekDay(dthrUltimaLeitura);

				// recupera configura��es
				Iterator<DwFolhamedtemp> iDwFolhamedtemp = dwci.getDwFolha().getDwFolhamedtemps().iterator();
				while (iDwFolhamedtemp.hasNext()) {
					DwFolhamedtemp dwfolhamedtemp = iDwFolhamedtemp.next();

					for (DwFolhamedtemhor fmth : dwfolhamedtemp.getDwFolhamedtemhors()) {
						Long intervaloInicial = ((fmth.getDiasemini().longValue()) * FATOR_MULTIPLICACAO_DIA) + fmth.getHrini().longValue();
						Long intervaloFinal = ((fmth.getDiasemfim().longValue()) * FATOR_MULTIPLICACAO_DIA) + fmth.getHrfim().longValue();
						Long horarioLeitura = (diaSemana * FATOR_MULTIPLICACAO_DIA) + DataHoraRN.getSegundosDoDia(dthrUltimaLeitura);

						if (horarioLeitura >= intervaloInicial && horarioLeitura <= intervaloFinal) {
							List<DwFolhamedtemphorcfg> lista = new ArrayList<DwFolhamedtemphorcfg>();
							lista.addAll(fmth.getDwFolhamedtemphorcfgs());
							Collections.sort(lista,
									new Comparator<DwFolhamedtemphorcfg>() {
										@Override
										public int compare(
												final DwFolhamedtemphorcfg o1,
												final DwFolhamedtemphorcfg o2) {
											Double v1 = o1.getLimInfTemp() != null ? o1.getLimInfTemp().doubleValue() : 0d;
											Double v2 = o2.getLimInfTemp() != null ? o2.getLimInfTemp().doubleValue() : 0d;

											if (v1.equals(v2)) {
												Double y1 = o1.getLimSupTemp() != null ? o1.getLimSupTemp().doubleValue() : 0d;
												Double y2 = o2.getLimSupTemp() != null ? o2.getLimSupTemp().doubleValue() : 0d;
												return y1.compareTo(y2);
											}
											return v1.compareTo(v2);
										}
									});

							retorno.setTemperaturaZonaCritInf(false);
							retorno.setTemperaturaZonaActInf(false);
							retorno.setTemperaturaZonaIdeal(false);
							retorno.setTemperaturaZonaActSup(false);
							retorno.setTemperaturaZonaCritSup(false);

							// testa limite cr�tico inferior
							Double valorSuperior = 0d;
							if (lista.get(TEMPERATURA_CRITICA_INFERIOR).getLimSupTemp() != null)
								valorSuperior = lista.get(TEMPERATURA_CRITICA_INFERIOR).getLimSupTemp().doubleValue();
							
							if (retorno.getUltimaTemperaturaLida() <= valorSuperior) {
								retorno.setTemperaturaZonaCritInf(true);
								if (dwci.getOmPt().getCdPt().equals("SOLDA_2")) {
									System.out.println("setTemperaturaZonaCritInf dwconsolid = " + dwci.getIdConsolid() + " vl= " + retorno.getUltimaTemperaturaLida());
									for (DwFolhamedtemphorcfg l : lista) {
										System.out.println("inf=" + l.getLimInfTemp() + " sup=" + l.getLimSupTemp());
									}
									System.out.println("--------------------");
								}

							}

							// testa limite aceit�vel inferior
							Double valorInferior = 0d;
							valorSuperior = 0d;
							if (lista.get(TEMPERATURA_ACEITAVEL_INFERIOR).getLimInfTemp() != null) {
								valorInferior = lista.get(TEMPERATURA_ACEITAVEL_INFERIOR).getLimInfTemp().doubleValue();
							}
							if (lista.get(TEMPERATURA_ACEITAVEL_INFERIOR).getLimSupTemp() != null) {
								valorSuperior = lista.get(TEMPERATURA_ACEITAVEL_INFERIOR).getLimSupTemp().doubleValue();
							}
							if ((retorno.getUltimaTemperaturaLida() > valorInferior) && (retorno.getUltimaTemperaturaLida() <= valorSuperior)) {
								retorno.setTemperaturaZonaActInf(true);
								if (dwci.getOmPt().getCdPt().equals("SOLDA_2")) {
									System.out.println("setTemperaturaZonaActInf dwconsolid = " + dwci.getIdConsolid() + " vl= " + retorno.getUltimaTemperaturaLida());
									for (DwFolhamedtemphorcfg l : lista) {
										System.out.println("inf=" + l.getLimInfTemp() + " sup=" + l.getLimSupTemp());
									}
									System.out.println("--------------------");
								}
							}

							// testa limite ideal
							valorInferior = 0d;
							valorSuperior = 0d;
							if (lista.get(TEMPERATURA_IDEAL).getLimInfTemp() != null)
								valorInferior = lista.get(TEMPERATURA_IDEAL).getLimInfTemp().doubleValue();
							if (lista.get(TEMPERATURA_IDEAL).getLimSupTemp() != null)
								valorSuperior = lista.get(TEMPERATURA_IDEAL).getLimSupTemp().doubleValue();
							
							if ((retorno.getUltimaTemperaturaLida() > valorInferior) && (retorno.getUltimaTemperaturaLida() <= valorSuperior)) {
								retorno.setTemperaturaZonaIdeal(true);
							}

							// testa limite aceit�vel superior
							valorInferior = 0d;
							valorSuperior = 0d;
							if (lista.get(TEMPERATURA_ACEITAVEL_SUPERIOR).getLimInfTemp() != null)
								valorInferior = lista.get(TEMPERATURA_ACEITAVEL_SUPERIOR).getLimInfTemp().doubleValue();
							if (lista.get(TEMPERATURA_ACEITAVEL_SUPERIOR).getLimSupTemp() != null)
								valorSuperior = lista.get(TEMPERATURA_ACEITAVEL_SUPERIOR).getLimSupTemp().doubleValue();
							if ((retorno.getUltimaTemperaturaLida() > valorInferior) && (retorno.getUltimaTemperaturaLida() <= valorSuperior)) {
								retorno.setTemperaturaZonaActSup(true);
							}

							// testa limite cr�tico superior
							valorInferior = 0d;
							if (lista.get(TEMPERATURA_CRITICA_SUPERIOR).getLimInfTemp() != null)
								valorInferior = lista.get(TEMPERATURA_CRITICA_SUPERIOR).getLimInfTemp().doubleValue();
							if (retorno.getUltimaTemperaturaLida() > valorInferior) {
								retorno.setTemperaturaZonaCritSup(true);
							}

						}
					}
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				dwConsolmedparamlog = null;
				retorno = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	public List<DwConsolid> getDwConsolidPorDt(OmPt ompt, PpCp ppcp, Date dtReferencia, DwTurno dwTurno) {
		List<DwConsolid> retorno = new ArrayList<DwConsolid>();
		try {
			MapQuery query = new MapQuery(this.getDaoSession());
			query.append("SELECT dwConsolid FROM DwConsolid dwConsolid");
			query.append("left join fetch dwConsolid.dwFolha dwfolha");
			query.append("left join fetch dwfolha.dwFolhaiacs dwfolhaiac");

			if (dtReferencia != null || dwTurno != null) {
				query.append("WHERE dwConsolid.dwTurno = :dwturno");
				query.append("AND dwConsolid.dtReferencia = :dtref");
				query.append("AND");
			} else {
				query.append("WHERE");
			}

			query.append("dwConsolid.omPt.cdPt = :ompt");
			
			if (ppcp != null)
				query.append("AND dwConsolid.ppCp = :ppcp");
			
			query.append("AND dwConsolid.tpId = 1 and dwConsolid.stAtivo is null ");
			query.append("order by dwConsolid.idConsolid desc");

			if (dtReferencia != null || dwTurno != null) {
				query.defineParametro("dwturno", dwTurno);
				query.defineParametroData("dtref", dtReferencia);
			}

			query.defineParametro("ompt", ompt.getCdPt());
			query.defineParametro("ppcp", ppcp);

			retorno = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	/**
	 * Coleta dos dados de tempo real do objeto
	 * 
	 * @param objDTO
	 * @return Dados do tempo real do objeto
	 */
	private ObjRtDTO getObjRtDTO(ObjDTO objDTO) {

		OmObj omObj = objDTO.getObj();

		ObjRtDTO objRtDTOItem = new ObjRtDTO();
		objRtDTOItem.setObjDTO(objDTO);

		objRtDTOItem.setDtReferencia(DataHoraRN.getDataHoraAtual());

		// Trata Posto de trabalho
		if (omObj.getTpObj().byteValue() == omObj.getTIPO_OBJ_PT()) {

			OmPt omPt = omObj.getOmPt();

			// Pega configura��o
			OmCfg omCfg = Util.getConfigGeral(this.getDaoSession());
			objRtDTOItem.setTemOmCfg(omCfg != null);

			// Pega Algoritmo
			OmAlgocor omAlgocor = this.getOmAlgocorForOmPt(omPt);
			objRtDTOItem.setTemOmAlgocor(omAlgocor != null);

			// Operadores logados
			objRtDTOItem.setDwConsolmologs(this.getOperadoresLogados(null,
					omObj.getOmPt()));

			// Pega dados do tempo Real
			DwRt dwRt = this.getDwRtForOmPt(omPt);
			objRtDTOItem.setTemDwRt(dwRt != null);
			objRtDTOItem.setOffline(true);

			if (objRtDTOItem.isTemDwRt() && objRtDTOItem.isTemOmAlgocor()) {

				// AlgoritmoMonitorizacaoFactory.getInstancia().executarAlgoritmo(omAlgocor.getIdAlgocor(),
				// objRtDTOItem, dwRt, omCfg,this);

				/*
				 * codigo substituido pelo codigo acima, que utiliza Factory //
				 * Se o algoritmo for WHP if(omAlgocor.getIdAlgocor() == 2) {
				 * this.algoritmoMonitorizacaoWHP(objRtDTOItem,dwRt,omCfg); }
				 */

			}

			// Trata grupo de trabalho
		} else if (omObj.getTpObj().byteValue() == omObj.getTIPO_OBJ_GT()) {
			objRtDTOItem.setDwConsolmologs(this.getOperadoresLogados(
					omObj.getOmGtByIdGtfilho(), null));

		}

		return objRtDTOItem;

	}

	public OmTppt getOmTpptForOmPt(OmPt omPt) {
		OmTppt omTppt = null;

		MapQuery q = new MapQuery(this.getDaoSession());

		q.append(" SELECT omTppt  ");
		q.append(" FROM OmTppt omTppt ");
		q.append(" INNER JOIN omTppt.omPts omPts ");
		q.append(" WHERE omPts.idPt = :idPt ");

		if (omPt != null) {
			q.defineParametro("idPt", omPt.getIdPt());
		}

		q.query().setMaxResults(1);

		try {
			omTppt = (OmTppt) q.query().uniqueResult();
		} catch (NullPointerException e) {
			omTppt = null;
		}

		q = null;

		return omTppt;
	}

	/**
	 * Pega algoritmo do PT
	 * 
	 * @param omPt
	 * @return configura��o para o PT Alessandre: Coloquei em deprecated em
	 *         19-6-13 pois ompt ja tem o atributo omtppt que possui o omalgocor
	 *         nao precisa dessa consulta. Se precisa, eh melhor modifica-la
	 *         tirando os joins e usando o idTppt do proprio ompt passado
	 */
	@Deprecated
	private OmAlgocor getOmAlgocorForOmPt(OmPt omPt) {
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append(" SELECT omAlgocor  ");
		q.append(" FROM OmAlgocor omAlgocor ");
		q.append(" INNER JOIN omAlgocor.omTppts omTppts ");
		q.append(" INNER JOIN omTppts.omPts omPts ");
		q.append(" WHERE omPts.idPt = :idPt ");

		q.defineParametro("idPt", omPt.getIdPt());

		q.query().setMaxResults(1);

		OmAlgocor omAlgocor = null;

		try {
			omAlgocor = (OmAlgocor) q.query().uniqueResult();
		} catch (NullPointerException e) {
			omAlgocor = null;
		}

		q = null;

		return omAlgocor;
	}

	/**
	 * Pega um dtrt em determinada data e turno
	 * 
	 * @param omPt
	 * @return
	 */

	public DwRt getDwRtForOmPt(OmPt omPt) {
		PTRN ptrn = new PTRN(getDao());
		
		OmPt ompt = null;
		try {
			ompt = ptrn.getOmPt(omPt.getCdPt());
		} catch (RegistroDesconhecidoException e1) {
			ompt = null;
		}

		MapQuery q = new MapQuery(this.getDaoSession());

		q.append(" SELECT dwRt ");
		q.append(" FROM DwRt dwRt ");
		q.append(" INNER JOIN dwRt.omPt omPt ");
		q.append(" INNER JOIN dwRt.dwTurno dwTurno  ");
		q.append(" WHERE omPt.idPt = :idPt ");
		if (ompt != null && ompt.getPpCp() != null) {
			q.append("and dwRt.ppCp = :ppcp");
		}
		/* Alessandre em 29-12-15 acrecentei a ordenacao por dthrHeartBeat.
		 * pois esse metodo eh usado pela monitorizacao em tempo real no turno corrente e retornou 
		 * o dwrt do turno anterior mesmo tendo dados no turno corrente pois o idRt do turno anterior estava maior que 
		 * do turno corrente
		 */
		q.append(" ORDER BY dwRt.dthrHeartbeat desc, dwRt.dthrEvento DESC, dwRt.idRt DESC ");

		if (omPt != null) {
			q.defineParametro("idPt", omPt.getIdPt());
		}
		if (ompt != null && ompt.getPpCp() != null) {
			q.defineParametro("ppcp", ompt.getPpCp());
		}

		q.query().setMaxResults(1);

		DwRt dwRt = null;

		try {
			dwRt = (DwRt) q.query().uniqueResult();
		} catch (NullPointerException e) {
			dwRt = null;
		}
		q = null;

		return dwRt;
	}

	/**
	 * Pega o <code>DwPassagem</code> do <code>OmPt</code>
	 * 
	 * @param omPt
	 * @return
	 */
	public DwPassagem getDwPassagemFromOmPt(OmPt omPt) {

		DwPassagem dwPassagem = null;

		MapQuery q = new MapQuery(this.getDaoSession());

		q.append(" SELECT dwPassagem ");
		q.append(" FROM DwPassagem dwPassagem ");
		q.append(" INNER JOIN dwPassagem.omPt omPt ");
		q.append(" LEFT OUTER JOIN dwPassagem.dwEst dwEst ");
		q.append(" LEFT OUTER JOIN dwPassagem.dwNserie dwNserie ");
		q.append(" LEFT OUTER JOIN dwNserie.dwPassagem dwPassagemFromDwSerie ");
		q.append(" WHERE omPt.idPt = :idPt ");
		q.append(" ORDER BY dwPassagem.idPassagem DESC ");

		q.defineParametro("idPt", omPt.getIdPt());
		q.query().setMaxResults(1);

		try {
			dwPassagem = (DwPassagem) q.query().uniqueResult();
		} catch (NullPointerException e) {
			dwPassagem = null;
		}

		q = null;

		return dwPassagem;
	}

	// Obtem a lista de Consolmolog do gt ou pt que estao em aberto
	public List<DwConsolmolog> getOperadoresLogados(OmGt omGt, OmPt omPt) {

		MapQuery q = new MapQuery(this.getDaoSession());

		q.append(" SELECT dwConsolmolog");
		q.append(" FROM DwConsolmolog dwConsolmolog ");
		q.append(" INNER JOIN dwConsolmolog.omUsr omUsr ");
		q.append(" LEFT OUTER JOIN dwConsolmolog.omPt omPt ");
		q.append(" LEFT OUTER JOIN dwConsolmolog.omGt omGt ");
		q.append(" WHERE dwConsolmolog.dthrFlogin IS NULL ");

		if (omPt != null) {
			q.append(" AND omPt.idPt = :idPt ");
		} else if (omGt != null) {
			q.append(" AND omGt.idGt = :idGt ");
		}

		q.append(" ORDER BY dwConsolmolog.idConsolmolog ");

		if (omPt != null) {
			q.defineParametro("idPt", omPt.getIdPt());
		}
		if (omGt != null) {
			q.defineParametro("idGt", omGt.getIdGt());
		}

		List<DwConsolmolog> dwConsolmologs = new ArrayList<DwConsolmolog>();

		List<DwConsolmolog> listaDwConsolmolog = q.list();

		for (DwConsolmolog dwConsolmolog : listaDwConsolmolog) {
			dwConsolmologs.add(dwConsolmolog.clone());
		}

		listaDwConsolmolog = null;
		q = null;

		return dwConsolmologs;

	}

}
