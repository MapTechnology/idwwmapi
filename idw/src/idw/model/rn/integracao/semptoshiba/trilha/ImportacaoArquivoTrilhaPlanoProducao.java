package idw.model.rn.integracao.semptoshiba.trilha;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmGtDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpPlano;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PlanoProducaoRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.geraplano.passos.tipoA.TipoAGeraLayout;
import idw.util.Util;
import idw.webservices.dto.FiltroImportacaoTrilhaDTO;
import idw.webservices.dto.PlanoDTO;
import idw.webservices.dto.ResultadoDTO;

public class ImportacaoArquivoTrilhaPlanoProducao extends AbstractRN<DAOGenerico> {

	public ImportacaoArquivoTrilhaPlanoProducao() {
		super(new DAOGenerico());
	}
	public ImportacaoArquivoTrilhaPlanoProducao(DAOGenerico dao) {
		super(dao);
	}
	
	public PlanoDTO importarPlano(FiltroImportacaoTrilhaDTO filtro){
		FolhaRN frn = new FolhaRN(getDao());
		UsuarioRN rnu = new UsuarioRN(getDao());
		ProdutoRN rnp = new ProdutoRN(getDao());
		PlanoProducaoRN rn = new PlanoProducaoRN(getDao());
		OmGtDAO gtDAO = new OmGtDAO(getDaoSession());
		rn.setPlanoDTO(filtro.getPlano(), getDao());

		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		// Cancelar todas as ppcps
		rn.excluirTodosAsCps(filtro.getPlano());
		
		// Cancelar todos os planos firmados
		rn.cancelarPlanosFirmados();
		
		// Procurar o plano passado
		PpPlano ppPlano = rn.pesquisarPlanoByCdESt();
		
		/*
		 * Exemplo do conteudo do arquivo

		 	"IMC";"111.25-0";"551908";"23/04/2014 16:03:03";"24/04/2014 16:22:41";"2030"
			"IMC";"111.25-0";"551908";"24/04/2014 16:22:41";"24/04/2014 18:25:32";"250"

		 */
		OmUsr omusr = rnu.getOmUsrByLoginStAtivo(filtro.getUsuarioLogado().getUsuario().getLogin());
		

		// Ler linha por linha do conteudo do arquivo
		ArquivoImportacaoTrilhaRN arqrn = new ArquivoImportacaoTrilhaRN(filtro.getArquivo().getConteudo());
		
		for (String linha : arqrn.getLinhas()) {
		
			LinhaImportacaoTrilhaDTO registro = new LinhaImportacaoTrilhaDTO(linha);
			
			// Para cada linha separar os campos: "AREA";"MAQUINA";"PLACA";"DATAINICIO";"DATAFIM";"QUANTIDADE"
			String maquina = registro.getMaquina();
			String semiacabado = registro.getSemiacabado();
			Date dthrInicio = registro.getDthrInicio();
			Date dthrFim = registro.getDthrFim();
			Double quantidade = registro.getQuantidade();
			String nrdoc = registro.getNroDoc();
			if (nrdoc == null || nrdoc.equals(""))
				nrdoc = "SemDOC";
			
			// Para o plano passado inserir um novo ppCp
			// Inserir o ppCp apenas para a ultima maquina da linha, na qual o status de planeja para a linha esta marcado
			// Somente as maquinas SMDs serão importadas
			// Outras linhas tipo IMC e maquinas PTH serao desconsideradas
			OmGt omgt = gtDAO.getOmGtPorCdAtivo(maquina);
			
			if (omgt == null)
				continue;
			
			// Navega em todos os pts desse gt
			for (OmPt ompt : omgt.getOmPts()) {
				
				if (ompt.getStAtivo().equals((byte) 0) )
					continue;
				
				// Soh importa ops para as smds
				if (ompt.getOmTppt().equals(omcfg.getOmTpptByIdTpptinsersora()) == false)
					continue;
				
				// Soh importa ops para a ultima maquina da linha
				if (ompt.getIsApongt() == false) {
					continue;
				}
				
				PpCp ppcp = new PpCp();
				
				ppcp.setCdCp(maquina + "-" + semiacabado);
				ppcp.setDtCobertura(null);
				ppcp.setDthrFinal(dthrFim);
				ppcp.setDthrFinalreal(null);
				ppcp.setDthrInicio(dthrInicio);
				ppcp.setDthrInicioreal(null);
				ppcp.setDtRevisao(DataHoraRN.getDataHoraAtual());
				ppcp.setDtStativo(DataHoraRN.getDataHoraAtual());
				ppcp.setDwCal(null);
				ppcp.setDwConsolids(null);
				ppcp.setDwEst(null);
				
				DwFolha dwfolha = frn.pesquisaFolhaByCdEStComRota(semiacabado + "-SMD");
				
				ppcp.setDwFolha(dwfolha);
				ppcp.setDwRota(null);
				ppcp.setDwRts(null);
				ppcp.setIdCp(null);
				ppcp.setIsAntecipacao(false);
				ppcp.setIsApAberta(true);
				ppcp.setIsBarrasete(false);
				ppcp.setIsCm(false);
				ppcp.setIsFaltamp(false);
				ppcp.setIsFinalserie(false);
				ppcp.setIsMassa(true);
				ppcp.setIsTryout(false);
				ppcp.setOmGt(omgt);
				ppcp.setOmPt(ompt);
				
				ppcp.setOmUsrByIdUsrrevisao(omusr);
				ppcp.setOmUsrByIdUsrstativo(omusr);
				ppcp.setPasso(BigDecimal.ZERO);
				ppcp.setPpCliente(null);
				ppcp.setPpCpfaltamps(null);
				ppcp.setPpCpneccrons(null);
				ppcp.setPpCpPresForIdCp(null);
				ppcp.setPpCpPresForIdCppredecessora(null);
				ppcp.setStAtivo((byte) 1); 
				PpCpproduto ppcpproduto = new PpCpproduto();
				ppcpproduto.setIdCpproduto(null);
				ppcpproduto.setNrDoc(nrdoc);
				OmProduto omproduto = null;
				try {
					omproduto = rnp.getOmProduto(semiacabado);
				} catch (RegistroDesconhecidoException e) {
					PlanoDTO retorno = new PlanoDTO();
					ResultadoDTO resultado = new ResultadoDTO();
					resultado.setIdmensagem(resultado.getCOMPONENTE_DESCONHECIDO());
					retorno.setResultadoDTO(resultado);
					retorno.setCdPlano(semiacabado);
					return retorno;
				}
				// Verificar se o produto possui um cliente. Se nao possuir retornar um erro
				if (omproduto.getPpCliente() == null) {
					PlanoDTO retorno = new PlanoDTO();
					ResultadoDTO resultado = new ResultadoDTO();
					resultado.setIdmensagem(resultado.getIMP_CLIENTE_DESCONHECIDO());
					retorno.setResultadoDTO(resultado);
					retorno.setCdPlano(semiacabado);
					return retorno;
				}
				ppcpproduto.setOmProduto(omproduto);
				ppcpproduto.setPcsProducaobruta(BigDecimal.ZERO);
				ppcpproduto.setPcsProducaoplanejada(new BigDecimal(quantidade));
				ppcpproduto.setPpCp(ppcp);
				ppcpproduto.setPpCpDatas(null);
				Set<PpCpproduto> ppCpprodutos = new HashSet<PpCpproduto>();
				ppCpprodutos.add(ppcpproduto);
				ppcp.setPpCpprodutos(ppCpprodutos);
				
				ppcp.setPpPlano(ppPlano);
				
				
				getDao().makePersistent(ppcp);
			}
		}
		
		// Firmar o plano passado
		PlanoDTO retorno;
		try {
			retorno = rn.firmarPlano(true);
		} catch (SemPlanejamentoException e) {
			retorno = null;
		}
		
		// Montar o layout da ppcps para visualizar a importacao na opcao Ajustes do plano
		TipoAGeraLayout lrn = new TipoAGeraLayout(getDao());
		lrn.geraLayout(ppPlano);
		
		
		// Se nao firmou vai entrar no if abaixo
		if (retorno.getResultadoDTO().getIdmensagem() != retorno.getResultadoDTO().getCOM_SUCESSO()) {
			
		}
		
		return retorno;
	}
	
}
