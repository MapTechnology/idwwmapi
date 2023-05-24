package idw.model.rn;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmUsr;
import idw.model.pojos.TtSapCon;
import idw.model.pojos.TtSapEstmppa;
import idw.model.pojos.TtTmgCon;
import idw.model.rn.sap.SapConhecimentos;
import idw.model.rn.sap.SapEstoques;
import idw.model.rn.sap.TmgConhecimentos;
import idw.util.IdwLogger;
import idw.webservices.dto.ResultadoImportacaoSapDTO;
import idw.webservices.dto.SapConhecimentoDTO;
import idw.webservices.dto.SapConhecimentosDTO;
import idw.webservices.dto.SapEstoqueDTO;
import idw.webservices.dto.SapEstoquesDTO;
import idw.webservices.dto.TmgConhecimentoDTO;
import idw.webservices.dto.TmgConhecimentosDTO;
import idw.webservices.dto.UsuarioDTO;

public class ImportacaoMatPrimaSapRN  implements IDao {

	private DAOGenerico dao; //para MapQuery


	public ImportacaoMatPrimaSapRN() {
		this.dao = new DAOGenerico();
	}
	public ImportacaoMatPrimaSapRN(DAOGenerico dao) {
		this.dao = dao;
	}

	public ResultadoImportacaoSapDTO importarSap(UsuarioDTO usrlogadodto)
	{
		ResultadoImportacaoSapDTO retorno = new ResultadoImportacaoSapDTO();

		SapEstoquesDTO sapestoquesdto = new SapEstoquesDTO();
		SapConhecimentosDTO sapconhecimentosdto = new SapConhecimentosDTO();
		TmgConhecimentosDTO tmgconhecimentosdto = new TmgConhecimentosDTO();

		ConfiguracaoRN configuracaorn = new ConfiguracaoRN();
		configuracaorn.setSession(this.dao.getSession());

		//Ale... isso ainda falta colocar validacao e retorno de erro caso o usuario nao exista. Ass: Hugo
		//mas eu coloquei assim mesmo s� pra quebrar o galho aqui
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());
		OmUsr omusr = null;
		omusr = usuarioRN.getDao().findById(OmUsr.class, usrlogadodto.getUsuario().getIdUsr(), false);
		//fim alteracao

		OmCfg omcfg = null;
		omcfg = configuracaorn.getConfiguracao();

		IdwLogger log = new IdwLogger("ImportacaoSap");
    	int idLog = log.getIdAleatorio();

		SapEstoques sapEstoques = new SapEstoques(this.dao);
		sapEstoques.importarSapEstoques(log, idLog, omcfg, omusr, sapestoquesdto);

		this.dao.flushReiniciandoTransacao();

		//de novo...
		TmgConhecimentos tmgConhecimentos = new TmgConhecimentos(this.dao);
		tmgConhecimentos.importarTmgConhecimentos(log, idLog, omcfg, omusr, tmgconhecimentosdto);

    	this.dao.flushReiniciandoTransacao();

        /*
		// TESTES preenchendo com o que vem dos parametros e MODIFICANDO...
		// SapEstoquesDTO ...
        List<SapEstoqueDTO> listasapestoquesdto;
        listasapestoquesdto = psapestoquesdto.getSapestoques();
        if (listasapestoquesdto!=null)
        {
        	TtSapEstmppa newpojo = null;
        	SapEstoqueDTO newdto = null;
        	List<SapEstoqueDTO> newlistadto =  new ArrayList<SapEstoqueDTO>();
            for (SapEstoqueDTO i : listasapestoquesdto)
            {
            	newdto = new SapEstoqueDTO();
            	newpojo = (TtSapEstmppa) i.getSapestoque().clone();
            	newpojo.setCentro("c11");
            	newpojo.setDeposito("d11");
            	newdto.setSapestoque(newpojo);
            	newlistadto.add(newdto);
            }
            sapestoquesdto.setSapestoques(newlistadto);//"fatiriza"
        }
		*/

		SapConhecimentos sapConhecimentos = new SapConhecimentos(this.dao);
		sapConhecimentos.importarSapConhecimentos(log, idLog, omcfg, omusr, sapconhecimentosdto);

        /*
    	// TmgConhecimentosDTO ...
        List<TmgConhecimentoDTO> listatmgconhecimentosdto;
        listatmgconhecimentosdto = ptmgconhecimentosdto.getTmgconhecimentos();
        if (listatmgconhecimentosdto!=null)
        {
        	TtTmgCon newpojo = null;
        	TmgConhecimentoDTO newdto = null;
        	List<TmgConhecimentoDTO> newlistadto =  new ArrayList<TmgConhecimentoDTO>();
            for (TmgConhecimentoDTO i : listatmgconhecimentosdto)
            {
            	newdto = new TmgConhecimentoDTO();
            	newpojo = (TtTmgCon) i.getTmgconhecimento().clone();
            	newpojo.setConhecimento("con33");
            	newdto.setTmgconhecimento(newpojo);
            	newlistadto.add(newdto);
            }
            tmgconhecimentosdto.setTmgconhecimentos(newlistadto);//"fatiriza"
        }
        */


        retorno.setSapconhecimentosdto(sapconhecimentosdto);
        retorno.setSapestoquesdto(sapestoquesdto);
        retorno.setTmgconhecimentosdto(tmgconhecimentosdto);

		return retorno;
	}

	public SapEstoquesDTO getSapEstoquesDTO(SapEstoqueDTO filtro) {
		SapEstoques sapEstoques = new SapEstoques(this.dao);
		List<TtSapEstmppa> listaTtSapEstmppa = sapEstoques.getListaPojosSapEstoques(filtro);

		List<SapEstoqueDTO> lista = new ArrayList<SapEstoqueDTO>();

		if (listaTtSapEstmppa != null) {
			for (TtSapEstmppa ttSapEstmppa : listaTtSapEstmppa) {
				SapEstoqueDTO sapestoque = new SapEstoqueDTO();
				sapestoque.setSapestoque((TtSapEstmppa) ttSapEstmppa.clone());

				sapestoque.setResultadoEvento(0);
				lista.add(sapestoque);
			}
		}
		SapEstoquesDTO sapestoques = new SapEstoquesDTO();
		sapestoques.setSapestoques(lista);
		return sapestoques;
	}

	public SapConhecimentosDTO getSapConhecimentosDTO(SapConhecimentoDTO filtro) {
		SapConhecimentos sapConhecimentos = new SapConhecimentos(this.dao);
		List<TtSapCon> listaTtSapCon = sapConhecimentos.getListaPojosSapConhecimentos(filtro);

		List<SapConhecimentoDTO> lista = new ArrayList<SapConhecimentoDTO>();

		if (listaTtSapCon != null) {
			for (TtSapCon ttSapCon : listaTtSapCon) {
				SapConhecimentoDTO sapconhecimento = new SapConhecimentoDTO();
				sapconhecimento.setSapconhecimento((TtSapCon) ttSapCon.clone());

				sapconhecimento.setResultadoEvento(0);
				lista.add(sapconhecimento);
			}
		}
		SapConhecimentosDTO sapconhecimentos = new SapConhecimentosDTO();
		sapconhecimentos.setSapconhecimentos(lista);
		return sapconhecimentos;
	}

	public TmgConhecimentosDTO getTmgConhecimentosDTO(TmgConhecimentoDTO filtro) {
		TmgConhecimentos tmgConhecimentos = new TmgConhecimentos(this.dao);
		List<TtTmgCon> listaTtTmgCon = tmgConhecimentos.getListaPojosTmgConhecimentos(filtro);

		List<TmgConhecimentoDTO> lista = new ArrayList<TmgConhecimentoDTO>();

		if (listaTtTmgCon != null) {
			for (TtTmgCon ttTmgCon : listaTtTmgCon) {
				TmgConhecimentoDTO tmgconhecimento = new TmgConhecimentoDTO();
				tmgconhecimento.setTmgconhecimento((TtTmgCon) ttTmgCon.clone());

				tmgconhecimento.setResultadoEvento(0);
				lista.add(tmgconhecimento);
			}
		}
		TmgConhecimentosDTO tmgconhecimentos = new TmgConhecimentosDTO();
		tmgconhecimentos.setTmgconhecimentos(lista);

		return tmgconhecimentos;
	}
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}

}