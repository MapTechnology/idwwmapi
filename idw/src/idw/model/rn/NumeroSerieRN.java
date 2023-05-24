package idw.model.rn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.DwNSerieDAO;
import idw.model.dao.MapQuery;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwNsMp;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPassmon;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmRegrasNscb;
import idw.model.pojos.OmRegrasTags;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpnserie;
import idw.model.pojos.template.OmTagsTemplate.TAG;
import idw.model.pojos.template.PpCpTemplate;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.util.UtilsString;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.MontagensDTO;
import idw.webservices.dto.ResultadoDTO;
import ms.util.ConversaoTipos;

public class NumeroSerieRN extends AbstractRN<DAOGenerico> {

	private static final int TAMANHO_SEQ_SEMANA = 5;

	public NumeroSerieRN() {
		super(new DAOGenerico());
	}

	public NumeroSerieRN(DAOGenerico dao) {
		super(dao);
	}

	public DwNserie getDwNserieCb(String cb) throws NumeroSerieIrregularException{
		MapQuery q = new MapQuery(this.getDaoSession());

		// Obtem a configuracao geral
		OmCfg omcfg = null;
		omcfg = Util.getConfigGeral(this.getDaoSession());

		// select * from dw_nserie where cb = passagem.cb
		q.append("SELECT distinct dwnserie ");
		q.append("FROM DwNserie dwnserie ");
		q.append("WHERE dwnserie.cb = :cb");
		q.append("order by dwnserie.idNserie desc ");

		// Alessandre em 04-11-21 comentei devido um nullpointer na extracao da mascara que nao tinha motivo.
//		if (omcfg != null && omcfg.getMascaracb() != null)
//			q.defineParametro("cb",  Util.extraiPorMascara(cb, omcfg.getMascaracb()));
//		else
			q.defineParametro("cb", cb);
		q.setMaxResults(1);

		DwNserie oDwNserie = null;

		oDwNserie = (DwNserie) q.uniqueResult();

		// Se nao encontrou nada avaliar pelo codigo completo. Tendo certeza que nao existe o CB
		if (oDwNserie == null) {
			q.defineParametro("cb", cb);
			oDwNserie = (DwNserie) q.uniqueResult();
		}


		if (oDwNserie == null) {
			cb = cb.trim();
			q.defineParametro("cb", cb);
			oDwNserie = (DwNserie) q.uniqueResult();
		}

		q = null;

		return(oDwNserie);
	}


	public DwNserie getDwNserieCb(long id) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("SELECT dwnserie ");
		q.append("FROM DwNserie dwnserie ");
		q.append("WHERE dwnserie.idNserie = :id ");

		q.defineParametro("id", id);

		DwNserie oDwNserie = null;
		oDwNserie = (DwNserie) q.uniqueResult();

		return(oDwNserie);
	}

	public PpCpnserie getPpCpnserieByCpNserie(PpCp ppcp, DwNserie dwnserie) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("SELECT a ");
		q.append("FROM PpCpnserie a");
		q.append("WHERE a.ppCp = :ppcp");
		q.append("and a.dwNserie = :dwnserie");

		q.defineParametro("ppcp", ppcp);
		q.defineParametro("dwnserie", dwnserie);

		PpCpnserie oDwNserie = null;
		oDwNserie = (PpCpnserie) q.uniqueResult();

		return(oDwNserie);
	}

	public Boolean isNumeroSerieRefugado(String cb) {
		boolean isRetorno = false;

		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		DwNserie dwnserie;
		try {
			dwnserie = getDwNserieCb(cb);
		} catch (NumeroSerieIrregularException e) {
			dwnserie = null;
		}

		if (dwnserie != null && dwnserie.getDwEst() != null && dwnserie.getDwEst().equals(omcfg.getDwEstByIdEstrefugo()))
			isRetorno = true;

		return isRetorno;
	}

	public int getProximoSequencial(OmProduto omproduto) {
		int sequencial = 0;
        MapQuery q = new MapQuery(getDaoSession());
        q.append("select max(a.sequencial)");
        q.append("from DwNserie a");
        q.append("join a.omProduto b");
        q.append("where b.cdProduto = :cd");
        q.defineParametro("cd", omproduto.getCdProduto());
        Object max = q.uniqueResult();

        if (max == null)
        	sequencial=1;
        else {
        	sequencial = (Integer) max;
        	sequencial++;
        }

        return sequencial;

	}
	/**
	 *  Gerar um novo  numero de serie para determinado produto
	 *
	 */
	public String gerarNS(OmRegrasNscb regra, OmProduto omproduto, OmPt ompt, String cdcp) {
        StringBuilder numeroDeSerie = new StringBuilder();
        CpRN rn = new CpRN(getDao());

        PpCp ppcp = rn.pesquisarPpCpByNrDocCdPt(cdcp, ompt.getCdPt());

        // Encontrar o proximo sequencial para o produto
        int sequencial = 0;


        /* Ordenar as regras
         *
         */
        List<OmRegrasTags> regras = new ArrayList<>(regra.getOmRegrasTagses());
        Collections.sort(regras, new Comparator<OmRegrasTags>() {
			@Override
			public int compare(OmRegrasTags o1, OmRegrasTags o2) {
				return o1.getOrdem().compareTo(o2.getOrdem());
			}
		});

        for (OmRegrasTags regraTagNS : regras) {
            String cdTag = regraTagNS.getOmTags().getCdTags();
            String complemento = regraTagNS.getComplemento();

            if (cdTag.equals("@sequencial")) {
            	sequencial = getProximoSequencial(omproduto);
                if (complemento != null && complemento.contains("Z")) {
                    int tam = ConversaoTipos.converterParaInt(complemento);
                    String valor = String.valueOf(sequencial);

                    numeroDeSerie.append(UtilsString.getZerosAEsquerda(valor, tam));

                    if (complemento.contains("-"))
                        numeroDeSerie.append("-");
                } else {
                    numeroDeSerie.append(String.valueOf(sequencial));
                }
            }
            if (cdTag.equals("@yyyymmdd")) {
                String yyyymmdd = DataHoraRN.dateToStringYYYYMMDDHHMMSS(new Date()).substring(0, 10).replace("-", "");
                numeroDeSerie.append(yyyymmdd);
            }
            if (cdTag.equals("@yy")) {
                String yy  = DataHoraRN.dateToStringYY(new Date()).substring(0, 2);
                numeroDeSerie.append(yy);
                numeroDeSerie.append(complemento);
            }

            if (cdTag.equals("@semanaanual")) {
                String semana  = String.valueOf(DataHoraRN.getWeekYear(new Date()));
                numeroDeSerie.append(UtilsString.getZerosAEsquerda(semana, 2));
            }
            
            if (TAG.CBGT.equals(cdTag) && ompt.getOmGt() != null && ompt.getOmGt().getCb() != null) {
            	numeroDeSerie.append(ompt.getOmGt().getCb());
            }
            

            if (cdTag.equals("@semiacabado")) {
                numeroDeSerie.append(omproduto.getCdProduto());
                if (complemento != null && complemento.contains("Z") == false) {
                    numeroDeSerie.append(complemento);
                }
            }
            if (cdTag.equals("@produtofinal")) {
                if (ppcp.getDwRota() != null && ppcp.getDwRota().getOmProduto() != null) {
                    numeroDeSerie.append(ppcp.getDwRota().getOmProduto().getCdProduto());
                }
            }
            if (cdTag.equals("@cdpt")) {
                if (ppcp.getOmPt() != null) {
                    numeroDeSerie.append(ppcp.getOmPt().getCdPt());
                }
            }
            if (cdTag.equals("@plataforma")) {
            	try {
            		numeroDeSerie.append(getPlataformaSemiAcabado(ppcp));
            	} catch (NullPointerException e) {

            	}
                if (complemento != null && complemento.contains("Z") == false) {
                    numeroDeSerie.append(complemento);
                }
            }
            if (cdTag.equals("@op")) {
                if (ppcp.getPpCpprodutos() != null) {
                    numeroDeSerie.append(ppcp.getPpCpprodutos().iterator().next().getNrDoc());
                }
            }

            if (TAG.CAIXA.equals(cdTag)) {
            	numeroDeSerie.append(complemento);
            	if (omproduto.getCdCaixa() != null) {
            		numeroDeSerie.append(omproduto.getCdCaixa());
            	}
            }

            if (TAG.SEQUENCIAL_SEMANA_ANO.equals(cdTag)) {
            	String prefixo = numeroDeSerie.toString();
            	String strSequencial = montarSequencialSemanalAnual(prefixo, TAMANHO_SEQ_SEMANA);
            	numeroDeSerie.append(strSequencial);
            }
        }

        /* Incluir o novo numero de serie
         *
         */
        DwNserie ns = new DwNserie();
        ns.setIdNserie(0l);
        ns.setCb(numeroDeSerie.toString());
        ns.setNs(ns.getCb());
        ns.setOmProduto(omproduto);
        ns.setSequencial(sequencial);
        getDao().makePersistent(ns);

		return numeroDeSerie.toString();
	}

	
	

    
    
    /* Metodo usado para obter o numero sequencial 
     * para o Cartoon number
     */
	public String montarSequencialSemanalAnual(String prefixo, int tamanhoSeqSemana) {
		
		System.out.println("prefixo " + prefixo + " tamanho " + tamanhoSeqSemana);
		// Obtem o ultimo numero consolidado
		DwNSerieDAO dwNSerieDAO = new DwNSerieDAO(getDaoSession());
		DwNserie dwNSerie = dwNSerieDAO.getUltimoDwNSerieComLike(prefixo);
		int sequencialConsolidado = 1;

		if (dwNSerie != null) {
			// remove o prefixo, deixando só o sequencial
			int tamanhoPrefixo = prefixo.length();
			String strSequencial = dwNSerie.getCb().substring(tamanhoPrefixo);
			sequencialConsolidado = Integer.valueOf(strSequencial);
			sequencialConsolidado++;
		}
		
		
		// obtem o ultimo numero nos eventos
		int sequencialEventos = 1;
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a.cb");
		q.append("from MsEvt a");
		q.append("where a.cb like :cb");
		q.append("and a.stEvt = 0");
		q.append("order a.idEvt desc");
		
		q.setMaxResults(1);
		
//		aqui nova consulta em ms_evt para confirmar ultimo numero gerado
		
		
		
		// Decide qual o maior numero
		int sequencial = (sequencialConsolidado > sequencialEventos ? sequencialConsolidado : sequencialEventos);
		

		String strSequencial = UtilsString.getZerosAEsquerda(String.valueOf(sequencial), tamanhoSeqSemana);
		return strSequencial;
	}

    private String getPlataformaSemiAcabado(PpCp ppcp) {
        return getOmProdutoSemiAcabado(ppcp).getOmProgrp().getCdProgrp();
    }

    private OmProduto getOmProdutoSemiAcabado(PpCp ppCp) {
        OmProduto omproduto = new OmProduto();
        if (ppCp.getPpCpprodutos() != null && ppCp.getPpCpprodutos().size() > 0) {
            try {
                omproduto = ppCp.getPpCpprodutos().iterator().next().getOmProduto();
            } catch (NoSuchElementException e) {
                omproduto = null;
            }
        }
        return omproduto;
    }

    
	/* Retorna ultima montagem feita para o CB
	 *
	 */
	public MontagensDTO getUltimaMontagem(String cb) {
		IdwLogger log = new IdwLogger("getUltimaMontagem");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0, "MAC cb=" + cb);
		MontagensDTO retorno = new MontagensDTO();
		ResultadoDTO result = new ResultadoDTO();
		DwNserie dwnserie;
		try {
			dwnserie = getDwNserieCb(cb);
		} catch (NumeroSerieIrregularException e) {
			dwnserie = null;
		}

		if (	dwnserie == null || 
				(dwnserie != null && dwnserie.getDwPassagem() == null) || 
				(dwnserie != null && dwnserie.getDwPassagem().getDwPassmons() == null)) {
			if (dwnserie == null)
				log.info(idLog, 0, "dwnserie null");
			else if (dwnserie.getDwPassagem() == null)
				log.info(idLog, 0, "dwpassagem null");
			else if (dwnserie.getDwPassagem().getDwPassmons() == null)
				log.info(idLog, 0, "passmon null");
			else
				log.info(idLog, 0, "Nao encontrou montagem para dwnserie.id=" + dwnserie.getIdNserie() + " dwnserie.passagem=" + dwnserie.getDwPassagem().getIdPassagem() + " qtdemon=" + dwnserie.getDwPassagem().getDwPassmons().size());

			result.setIdmensagem(result.COM_SUCESSO);
			
			retorno.setCbPai(cb);
			if (dwnserie != null && dwnserie.getCbserial() != null)
				retorno.setCbSerial(dwnserie.getCbserial());
			retorno.setResultado(result);
			return retorno;
		}

		List<MontagemDTO> montagens = new ArrayList<>();

		for (DwPassmon mon : dwnserie.getDwPassagem().getDwPassmons()) {
			log.info(idLog, 0, "Achou a montagem idPassmon= " + mon.getIdPassmon() + " cb = " + mon.getCb() + " ordem=" + mon.getOrdem());
			
			MontagemDTO dto = new MontagemDTO();
			dto.setCb(mon.getCb());
			dto.setCdProdutoEsperado(mon.getOmProduto().getCdProduto());
			dto.setDsProdutoEsperado(mon.getOmProduto().getDsProduto());
			dto.setDthrMontagem(dwnserie.getDwPassagem().getDthr());
			dto.setCdPt(dwnserie.getDwPassagem().getOmPt().getCdPt());
			if (mon.getOrdem() != null)
				dto.setOrdem(mon.getOrdem());
			else
				dto.setOrdem(0);
			dto.setSerial(dwnserie.getCbserial());
			montagens.add(dto);
		}
		
		retorno.setCbPai(cb);
		retorno.setCbSerial(dwnserie.getCbserial());
		
		retorno.setListaMontagem(montagens);
		result.setIdmensagem(result.getERRO_DESCONHECIDO());
		retorno.setResultado(result);

		return retorno;
	}



    public static void main(String[] args) {
    	
    	/*
    	NumeroSerieRN rn = new NumeroSerieRN();
    	rn.iniciaConexaoBanco();
    	    	
    	MontagensDTO jamontado = rn.getUltimaMontagem("562049008406"); //, "MO_01_LIN02", ""); //642458259");
    	
    	System.out.println("resultado=" + jamontado.getResultado().getIdmensagem());
    	if (jamontado.getListaMontagem() != null) {
    		for (MontagemDTO dto : jamontado.getListaMontagem()) {
    			System.out.println(jamontado.getCbPai() + " --- " + dto.getCb() + " - "  + jamontado.getCdAvo() + " esperado:" + dto.getCdProdutoEsperado());
    		}
    	}
    	System.out.println("-------");
    	
    	// Avaliar a OP original
//    	String op = rn.getOpOndeMPUsadapeloCF("562002013163", "11-300-013740B");
    	String op = rn.getOpOndeMPUsadapeloCF("562001002673", "10-000-522501B");
    	System.out.println("op=" + op);
    	rn.finalizaConexaoBanco();
    	*/

    	NumeroSerieRN rn = new NumeroSerieRN();
    	rn.iniciaConexaoBanco();

    	MontagensDTO dto = rn.isCBJaMontado("MAC40", 1);
    	
    	System.out.println(dto.getCbPai());
    }

    
	public MontagensDTO isCBJaMontado(String cb, int nTentativa) {
		MontagensDTO retorno = new MontagensDTO();
		ResultadoDTO result = new ResultadoDTO();

		MapQuery q = new MapQuery(getDaoSession());

		/* Alessandre em 05-04-17 o select abaixo foi comentado e substituido pelo seguinte
		 * pois na gbr exitiram 2 montagens para o mesmo CB e ele nao deixou reutilizar o CB da 1a montagem e nao presente
		 * na 2a montagem em uma caixa qualquer.
		q.append("select distinct a");
		q.append("from DwPassagem a");
		q.append("join a.dwPassmons b");
		q.append("join a.dwNserie c");
		q.append("where b.cb = :cb");
		 */
		q.append("select distinct a");
		q.append("from DwPassagem a");
		q.append("join a.dwPassmons b"); // usado para encontrar se esta presente em alguma montagem
		q.append("join a.dwNserie c");
		q.append("left join c.dwPassagem d");
		q.append("where b.cb = :cb");
		q.append("and (a.stAtivo is null or a.stAtivo = 1)"); // garante que a passagem filtrada seja a ultima montagem do produto
		q.append("and (c.dwEst.idEst <> :idest or c.dwEst is null)");
		
		q.defineParametro("idest", 4l);
		q.defineParametro("cb", cb);
		q.setMaxResults(1);

		DwPassagem dwpassagem = (DwPassagem) q.uniqueResult();
		if (dwpassagem == null || dwpassagem.getDwPassmons() == null) {
			result.setIdmensagem(result.COM_SUCESSO);
			retorno.setResultado(result);
			return retorno;
		}

		List<MontagemDTO> montagens = new ArrayList<>();

		for (DwPassmon mon : dwpassagem.getDwPassmons()) {
			MontagemDTO dto = new MontagemDTO();
			dto.setCb(mon.getCb());
			dto.setCdProdutoEsperado(dwpassagem.getDwNserie().getOmProduto().getCdProduto());
			dto.setDsProdutoEsperado(dwpassagem.getDwNserie().getOmProduto().getDsProduto());
			dto.setDthrMontagem(dwpassagem.getDthr());
			dto.setCdPt(dwpassagem.getOmPt().getCdPt());
			dto.setCdCp(dwpassagem.getDwConsolid().getPpCp().getNrop());
			
			if (dwpassagem.getDwNserie() != null)
				dto.setSerial(dwpassagem.getDwNserie().getCbserial());
			
			montagens.add(dto);
		}
		retorno.setListaMontagem(montagens);
		result.setIdmensagem(result.getERRO_DESCONHECIDO());
		retorno.setResultado(result);

		if (dwpassagem.getDwNserie() != null && nTentativa <= 3) {
			retorno.setCbPai(dwpassagem.getDwNserie().getCb());
			
			// Verifica se o item foi montado em alguma embalagem. Se sim, então retornar também o PAI anterior
			MontagensDTO montagemAvo = isCBJaMontado(retorno.getCbPai(), ++nTentativa);
			if (montagemAvo.getResultado().getIdmensagem() != result.COM_SUCESSO) {
				retorno.setCdAvo(montagemAvo.getCbPai());
			} else {
				retorno.setCdAvo("--");
			}
		} else {
			retorno.setCbPai("--");
		}
		
		retorno.setCdProdutoEsperado(dwpassagem.getDwConsolid().getPpCp().obtemPrimeiroProduto().getCdProduto());
		
		return retorno;
	}

	


	/* Verifica se o CB ja foi montado pelo posto. Pode ser que existam montagens registradas
	 * mas se dwpassaagem.stNserie estiver = 0 é pq foram canceladas.
	 */
	public MontagensDTO isCBJaMontadoNoTppt(String cb, String cdpt, String cdcp) {
		MontagensDTO retorno = new MontagensDTO();
		ResultadoDTO result = new ResultadoDTO();
		
		PTRN prn = new PTRN(getDao());
		OmPt ompt;
		try {
			ompt = prn.getOmPt(cdpt);
		} catch (RegistroDesconhecidoException e) {
			result.setIdmensagem(result.getERRO_DESCONHECIDO());
			retorno.setResultado(result);
			return retorno;
		}
		
		CpRN crn = new CpRN(getDao());
		PpCp ppcp = crn.pesquisarPpCpByNrDocCdPt(cdcp, cdpt);
		if (ppcp == null) {
			result.setIdmensagem(result.getERRO_DESCONHECIDO());
			retorno.setResultado(result);
			return retorno;
		}
		

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select distinct a");
		q.append("from DwPassagem a");
		q.append("join a.dwPassmons b"); // usado para encontrar se esta presente em alguma montagem
		q.append("join a.dwNserie c");
		q.append("join a.omPt d");
		q.append("join d.omTppt e");
		
		if (ppcp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue())) {
			q.append("join a.dwConsolid f");
		}
		q.append("where b.cb = :cb");
		q.append("and e.cdTppt = :cdtppt");
		q.append("and (a.stAtivo is null or a.stAtivo = 1)");
		
		if (ppcp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue())) {
			q.append("and f.ppCp = :ppcp");
		}
		
		q.append("order by a.idPassagem desc");

		q.defineParametro("ppcp", ppcp);
		q.defineParametro("cb", cb);
		q.defineParametro("cdtppt", ompt.getOmTppt().getCdTppt());
		q.setMaxResults(1);

		DwPassagem dwpassagem = (DwPassagem) q.uniqueResult();
		if (dwpassagem == null || dwpassagem.getDwPassmons() == null) {
			result.setIdmensagem(result.COM_SUCESSO);
			retorno.setResultado(result);
			
			
		} else {
			result.setIdmensagem(result.getERRO_DESCONHECIDO());
			retorno.setResultado(result);

			// Enviar a montagem encontrada
			List<MontagemDTO> montagens = new ArrayList<>();

			for (DwPassmon mon : dwpassagem.getDwPassmons()) {
				MontagemDTO dto = new MontagemDTO();
				dto.setCb(mon.getCb());
				dto.setCdProdutoEsperado(dwpassagem.getDwNserie().getOmProduto().getCdProduto());
				dto.setDsProdutoEsperado(dwpassagem.getDwNserie().getOmProduto().getDsProduto());
				dto.setDthrMontagem(dwpassagem.getDthr());
				dto.setCdPt(dwpassagem.getOmPt().getCdPt());
				
				dto.setCdCp(dwpassagem.getDwConsolid().getPpCp().getNrop());
				
				if (dwpassagem.getDwNserie() != null)
					dto.setSerial(dwpassagem.getDwNserie().getCbserial());
				
				montagens.add(dto);
			}
			retorno.setCbPai(dwpassagem.getDwNserie().getCb());
			retorno.setListaMontagem(montagens);
		}

		return retorno;
	}

	
	/* Obtem a ultima montagem preenchendo o serial com o conteudo do postos de montagem SSID
	 * da flex. No caso sera a montagem de um palete, entao dentro do palete terao as caixas
	 * TODO rever a estrutura do sistema para poder customizar essa operacao
	 */
	public MontagensDTO getUltimaMontagemComSerial(String cb) {
		IdwLogger log = new IdwLogger("getUltimaMontagemComSerial");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0, "MAC cb=" + cb);
		MontagensDTO retorno = new MontagensDTO();
		ResultadoDTO result = new ResultadoDTO();
		DwNserie dwnserie;
		try {
			dwnserie = getDwNserieCb(cb);
		} catch (NumeroSerieIrregularException e) {
			dwnserie = null;
		}

		if (	dwnserie == null || 
				(dwnserie != null && dwnserie.getDwPassagem() == null) || 
				(dwnserie != null && dwnserie.getDwPassagem().getDwPassmons() == null)) {
			if (dwnserie == null)
				log.info(idLog, 0, "dwnserie null");
			else if (dwnserie.getDwPassagem() == null)
				log.info(idLog, 0, "dwpassagem null");
			else if (dwnserie.getDwPassagem().getDwPassmons() == null)
				log.info(idLog, 0, "passmon null");
			else
				log.info(idLog, 0, "Nao encontrou montagem para dwnserie.id=" + dwnserie.getIdNserie() + " dwnserie.passagem=" + dwnserie.getDwPassagem().getIdPassagem() + " qtdemon=" + dwnserie.getDwPassagem().getDwPassmons().size());

			result.setIdmensagem(result.COM_SUCESSO);
			retorno.setResultado(result);
			return retorno;
		}

		List<MontagemDTO> montagens = new ArrayList<>();
		List<DwPassmon> listaDwPassmon = obtemTodasAsMontagens(cb);

		for (DwPassmon mon : listaDwPassmon) {
			DwNserie nsMon;
			try {
				nsMon = getDwNserieCb(mon.getCb());
			} catch (NumeroSerieIrregularException e) {
				continue;
			}
			log.info(idLog, 0, "Achou a montagem idPassmon= " + mon.getIdPassmon() + " cb = " + mon.getCb() + " ordem=" + mon.getOrdem());
			
			MontagemDTO dto = new MontagemDTO();
			dto.setCb(mon.getCb());
			dto.setCdProdutoEsperado(mon.getOmProduto().getCdProduto());
			dto.setDsProdutoEsperado(mon.getOmProduto().getDsProduto());
			dto.setDthrMontagem(dwnserie.getDwPassagem().getDthr());
			dto.setCdPt(dwnserie.getDwPassagem().getOmPt().getCdPt());
			dto.setOrdem(mon.getOrdem());
			if (nsMon != null && nsMon.getCbserial() != null)
				dto.setSerial(nsMon.getCbserial());
			
			
			// Obter as submontagens, onde terão os dados das seriais
			MontagensDTO submon = getUltimaMontagemComSerial(mon.getCb());
			dto.setMontagens(submon.getListaMontagem());

			/* Alessandre em 19-07-18 comentei o trecho abaixo, pois acrescenti o campo cbSerial em dwNserie
			// Definir o serial. no momento eh o 1o com ordem 2 TODO devemos encontrar uma forma correta de se fazer isso
			for (MontagemDTO monsubdto : submon.getListaMontagem())  {
				if (monsubdto.getOrdem() == 2) {
					dto.setSerial(monsubdto.getCb());
					break;
				}
			}*/
			
			montagens.add(dto);
		}
		retorno.setListaMontagem(montagens);
		result.setIdmensagem(result.getERRO_DESCONHECIDO());
		retorno.setResultado(result);

		return retorno;
	}

	
	// Utilizado para saber se a ultima montagem no posto é igual a montagem que se quer refazer
	public MontagensDTO getUltimaMontagemNoPosto(String cb, String cdpt, String cdcp) {
		IdwLogger log = new IdwLogger("getUltimaMontagemNoPosto");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0, "MAC cb=" + cb + " no posto  " + cdpt);
		MontagensDTO retorno = new MontagensDTO();
		ResultadoDTO result = new ResultadoDTO();
		DwNserie dwnserie;
		try {
			dwnserie = getDwNserieCb(cb);
		} catch (NumeroSerieIrregularException e) {
			dwnserie = null;
		}

		if (	dwnserie == null || 
				(dwnserie != null && dwnserie.getDwPassagem() == null) || 
				(dwnserie != null && dwnserie.getDwPassagem().getDwPassmons() == null)) {
			if (dwnserie == null)
				log.info(idLog, 0, "dwnserie null");
			else if (dwnserie.getDwPassagem() == null)
				log.info(idLog, 0, "dwpassagem null");
			else if (dwnserie.getDwPassagem().getDwPassmons() == null)
				log.info(idLog, 0, "passmon null");
			else
				log.info(idLog, 0, "Nao encontrou montagem para dwnserie.id=" + dwnserie.getIdNserie() + " dwnserie.passagem=" + dwnserie.getDwPassagem().getIdPassagem() + " qtdemon=" + dwnserie.getDwPassagem().getDwPassmons().size());

			result.setIdmensagem(result.COM_SUCESSO);
			retorno.setResultado(result);
			return retorno;
		}

		List<MontagemDTO> montagens = new ArrayList<>();
		DwPassagem dwpassagem = obtemUltimaMontagemNoPosto(cb, cdpt, cdcp);                                
		if (dwpassagem != null) {
			for (DwPassmon mon : dwpassagem.getDwPassmons()) {
				log.info(idLog, 0, "Achou a montagem idPassmon= " + mon.getIdPassmon() + " cb = " + mon.getCb() + " ordem=" + mon.getOrdem());
				
				MontagemDTO dto = new MontagemDTO();
				dto.setCb(mon.getCb());
				dto.setCdProdutoEsperado(mon.getOmProduto().getCdProduto());
				dto.setDsProdutoEsperado(mon.getOmProduto().getDsProduto());
				dto.setDthrMontagem(dwnserie.getDwPassagem().getDthr());
				dto.setCdPt(dwnserie.getDwPassagem().getOmPt().getCdPt());
				dto.setOrdem(mon.getOrdem());
				
				montagens.add(dto);
			}
		}
		retorno.setListaMontagem(montagens);
		result.setIdmensagem(result.getCOM_SUCESSO());
		retorno.setResultado(result);

		return retorno;
	}

	/* Obtem todas as montagens nao so a ultima */
	private List<DwPassmon> obtemTodasAsMontagens(String cb) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwPassmon a");
		q.append("join a.dwPassagem b");
		q.append("join b.dwNserie c");
		q.append("where c.cb = :cb");
		q.append("and a.cb <> :cb");
		q.append("order by a.idPassmon");
		
		q.defineParametro("cb", cb);
		
		return q.list();
	}

	
	private DwPassagem obtemUltimaMontagemNoPosto(String cb, String cdpt, String cdcp) {
		PTRN prn = new PTRN(getDao());
		OmPt ompt;
		try {
			ompt = prn.getOmPt(cdpt);
		} catch (RegistroDesconhecidoException e) {
			return new DwPassagem();
		}
		
		
		CpRN crn = new CpRN(getDao());
		PpCp ppcp;
		ppcp = crn.pesquisarPpCpByNrDocCdPt(cdcp, cdpt);
		
		
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwPassagem a");
		q.append("join fetch a.dwPassmons b");
		q.append("join a.dwNserie c");
		q.append("join a.omPt d");
		// Se for uma ordem de RETRABALHO, entao a ultima montagem deve considerar apenas a Ordem de retrabalho
		if (ppcp != null & ppcp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue())) {
			q.append("join a.dwConsolid e");
		}
		q.append("where c.cb = :cb");
		q.append("and d.omTppt = :omtppt");
		if (ppcp != null & ppcp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue())) {
			q.append("and e.ppCp = :ppcp");
			q.defineParametro("ppcp", ppcp);
		}
		q.append("order by a.idPassagem desc");
		
		q.setMaxResults(1);
		q.defineParametro("cb", cb);
		q.defineParametro("omtppt", ompt.getOmTppt());
		
		return (DwPassagem) q.uniqueResult();
	}

	/* Obtem todas as montagens do produto e todas as montagens na qual o produto participou */
	public List<DwPassmon> obtemTodasAsMontagensEAsqueParticipou(String cb, boolean isObterProdutosMontadosAbaixo) {
		MapQuery q = new MapQuery(getDaoSession());
		
		List<DwPassmon> retorno;
		
		if (isObterProdutosMontadosAbaixo) {
			// Select para obter os produtos montados no NS
			q.append("select a");
			q.append("from DwPassmon a");
			q.append("join a.dwPassagem b");
			q.append("join b.dwNserie c");
			q.append("where (c.cb = :cb and a.cb <> :cb)");
			q.append("order by a.idPassmon");
			
			q.defineParametro("cb", cb);
			retorno = q.list();
		} else
			retorno = new ArrayList<>();
		
		
		// Select para obter em quais produtos o NS foi montado
		q.novaConsulta();
		q.append("select a");
		q.append("from DwPassmon a");
		q.append("where a.cb = :cb");
		q.append("order by a.idPassmon");

		q.defineParametro("cb", cb);

		List<DwPassmon> lista2 = q.list();
		retorno.addAll(lista2);
		
		return retorno;
	}
	
	
	public void registrarBatismoBC(IdwLogger log, String cb, String idRegistro) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("update DwNserie set dthrBatismobc = :dthr, idBatismobc = :id where cb = :cb");
		
		q.defineParametro("dthr", DataHoraRN.getDataHoraAtual());
		q.defineParametro("id", idRegistro);
		q.defineParametro("cb", cb);
		
		int qt = q.query().executeUpdate();
		
		log.info("batizou " + cb + " com id=" + idRegistro + " nregistro=" + qt);
	}

	
	/* metodo responsavel em verificar se uma lista de codigo de barras ja passou pelo posto
	 * 
	 */
	public  List<DwPassagem> pesquisarPassagensDoCbNoPosto(String cdPt, List<Object> cbs) {
		
		List<DwPassagem> retorno = new ArrayList<>();
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwPassagem a");
		q.append("join fetch a.omPt b");
		q.append("join fetch a.dwNserie c");
		q.append("where b.cdPt = :cdpt");
		q.append("and c.cb in (:cbs)");
		
		q.defineParametro("cdpt", cdPt);
		q.defineListaParametro("cbs", cbs);
		retorno = q.list();
		
		List<DwPassagem> ret = new ArrayList<>();
		
		for(DwPassagem dw:retorno){
			DwPassagem clone = dw.clone(false);
			clone.setDwNserie(dw.getDwNserie().clone(false));
			ret.add(clone);
		}
		
		return ret;
	}


	/* Metodo para retornar a OP em que o componente foi usado em determinado NS
	 * 
	 * select b.cb, c.cd_pt, e.nr_doc, g.cd_produto, *
			from dw_passagem a (nolock)
			join dw_nserie b on b.id_nserie = a.id_nserie
			join om_pt c on c.id_pt = a.id_pt
			join dw_consolid d on d.id_consolid = a.id_consolid
			join pp_cpproduto e on e.id_cp = d.id_cp
			join dw_ns_mp f on f.id_nserie = b.id_nserie
			join om_produto g on g.id_produto = f.id_produto
			where
			b.cb = '562003034538'
			and g.cd_produto = '21-203-740002B'
			order by a.id_passagem desc

	 */
    public String getOpOndeMPUsadapeloCF(String ns, String cdproduto) {
    	String retorno;
    	
    	MapQuery q = new MapQuery(getDaoSession());
    	q.append("select a");
    	q.append("from DwNsMp a");
    	q.append("join a.dwNserie b");
    	q.append("join a.omProduto c");
    	q.append("where b.cb = :cb");
    	q.append("and c.cdProduto = :cdproduto");
    	
    	q.defineParametro("cb", ns);
    	q.defineParametro("cdproduto", cdproduto);
    	
    	q.setMaxResults(1);
    	
    	DwNsMp dwnsmp = (DwNsMp) q.uniqueResult();
    	if (dwnsmp != null && dwnsmp.getNrop() != null) {
    		retorno = dwnsmp.getNrop();
    	} else
    		retorno = "";
    	
    	return retorno;
    }
}
