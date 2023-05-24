package idw.webservices;

import java.math.BigDecimal;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import idw.model.IdwFacade;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwDesalimpendcontag;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwTurno;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsMs;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmRegrasNscb;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.TeTarifasemanal;
import idw.model.pojos.template.IpBalanceamentoTemplate;
import idw.model.rn.classificacaoabc.ClassificacaoABCRN;
import idw.model.rn.diariobordo.DiarioBordoDTO;
import idw.model.rn.diariobordo.DiariosBordoDTO;
import idw.model.rn.indicador.IndicadorValorDTO;
import idw.model.rn.injet.dto.FiltroMaquinaInjetDTO;
import idw.model.rn.injet.dto.MaquinasInjetDTO;
import idw.model.rn.integracao.erp.OpsIntegracaoDTO;
import idw.model.rn.integracao.semptoshiba.trilha.ArquivosTrilhaDTO;
import idw.model.rn.joblog.FiltroPesquisaOmJobDTO;
import idw.model.rn.joblog.ListaOmJobLogDTO;
import idw.model.rn.joblog.ListaOmJobdetLogDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoDefeitosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoLogVRotSDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParetoRefugosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoParadaDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoRitmoDTO;
import idw.model.rn.monitorizacao.roteiro.ListaOmObjDTO;
import idw.model.rn.relatorios.R100.FiltroR100DTO;
import idw.model.rn.relatorios.R100.RelatorioR100DTO;
import idw.model.rn.relatorios.R101.FiltroR101DTO;
import idw.model.rn.relatorios.R101.RelatorioR101DTO;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO;
import idw.model.rn.relatorios.consolidados.RelatorioConsolidadoDTO;
import idw.model.rn.relatorios.opprocessada.ListaRelatorioOPProcessadaDTO;
import idw.model.rn.relatorios.refugo.consolidado.FiltroRelatorioRefugoConsolidadoPorMoldeDTO;
import idw.model.rn.relatorios.refugo.consolidado.RelatorioRefugoConsolidadoPorMoldeDTO;
import idw.relatorio.analiseproducaoeficiencia.ListaDTOAnaliseProducaoEficienciaHoraAHora;
import idw.relatorio.causasrefugo.FiltroRelatorioCausasDeRefugoDTO;
import idw.relatorio.causasrefugo.ListaRelatorioCausasDeRefugoDTO;
import idw.util.EmailDTO;
import idw.webservices.dto.*;
import injetws.model.excessoes.FalhaSnapshot;
import ms.model.MsFacade;
import ms.model.dto.BcDTO;
import ms.model.dto.ConfiguraHibernateDTO;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IhmDTO;
import ms.model.dto.ListaBcDTO;
import ms.model.dto.ListaEvtDTO;
import ms.model.dto.ListaIcDTO;
import ms.model.dto.ListaIhmDTO;
import ms.model.dto.ListaMSDTO;
import ms.model.dto.ListaUPDTO;
import ms.model.dto.Log4jDTO;
import ms.model.dto.MsDTO;
import ms.model.dto.MsicupsDTO;
import ms.model.dto.UpDTO;
import ms.model.dto.WebXMLDTO;
import ms.model.ic.FirmwaresDTO;
import ms.model.rn.aoi.EventoAOIDTO;

@WebService(name = "idwws", targetNamespace = "http://idw/idwws", serviceName = "idwws")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class IDWWS {
	
	@WebMethod
	public void icHeartBeat(int idLog,String urlIC, EventoDTO evento) {
		// Como o EventoDTO é inerente aos WS, ele esta sendo convertido para
		// EventoColetado aqui mesmo
		// TODO: Mover a transformacao EventoDTO-EventoColetado para o local adequado
		try {
			EventoColetado eventoColetado = new EventoColetado();
			eventoColetado.setDthrEvento(evento.getDataComoData());
			eventoColetado.setIdentacao(0);
			MsFacade.getInstancia().icHeartBeat(idLog, urlIC, eventoColetado);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    /* RETORNA A HORA ATUAL DO SERVIDOR QUE HOSPEDA OS WEBSERVICES */
    @WebMethod
    public idw.webservices.dto.UsuariosDTO getUsuariosDTO(idw.webservices.dto.UsuarioDTO usuario) {
        return IdwFacade.getInstancia().getUsuariosDTO(usuario);
    }

    @WebMethod
    public ChangeLogsBDDTO getChangeLogsBDNaoExecutados() {
        return IdwFacade.getInstancia().getChangeLogsBDNaoExecutados();
    }

    @WebMethod
    public ChangeLogsBDDTO getChangeLogsBDExecutados() {
        return IdwFacade.getInstancia().getChangeLogsBDExecutados();
    }

    @WebMethod
    public boolean executarChangeLogBD(ChangeLogBDDTO changeLogBDDTO) {
        return IdwFacade.getInstancia().executarChangeLogBD(changeLogBDDTO);
    }

    @WebMethod
    public idw.webservices.dto.UsuarioDTO setUsuarioDTO(idw.webservices.dto.UsuarioDTO usuario) {
        return IdwFacade.getInstancia().setUsuarioDTO(usuario);
    }

    @WebMethod
    public UsuariosDTO removeUsuariosDTO(UsuariosDTO usuarios) {
        return IdwFacade.getInstancia().removeUsuariosDTO(usuarios);
    }

    @WebMethod
    public idw.webservices.dto.UsuarioDTO ativaUsuarioDTO(idw.webservices.dto.UsuarioDTO usuario) {
        return IdwFacade.getInstancia().ativaUsuarioDTO(usuario);
    }

    @WebMethod
    public idw.webservices.dto.UsuarioDTO isUsuarioAutenticado(idw.webservices.dto.UsuarioDTO usuario) {
        return IdwFacade.getInstancia().isUsuarioAutenticado(usuario);
    }

    @WebMethod
    public idw.webservices.dto.UsuarioDTO getUsuarioDTO(idw.webservices.dto.UsuarioDTO usuario) {
        return IdwFacade.getInstancia().getUsuarioDTO(usuario);
    }

    @WebMethod
    public PesquisasDTO pesquisaTurno(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaTurno(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwFolha(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwFolha(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwFolhaTesteFuncional(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwFolhaTesteFuncional(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwEst(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwEst(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwEstlocal(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwEstlocal(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwEstlocalDesalimentacao(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwEstlocalDesalimentacao(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwCal(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwCal(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwMacrangePAI(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwMacrangePAI(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwPepro(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwPepro(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwFtParam(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwFtParam(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwRefugo(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwTRefugo(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaPpCpProduto(PesquisaDTO pesquisa, String cdOp) {
        return IdwFacade.getInstancia().pesquisaPpCpProduto(pesquisa, cdOp);
    }

    @WebMethod
    public ListaDwPassagemDTO getListaLeadTime(String op, String pt, String produto, Date data1, Date data2) {
        return IdwFacade.getInstancia().getListaLeadTime(op, pt, produto, data1, data2);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwTAlerta(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwTAlerta(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaGrupoProduto(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaGrupoProduto(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmgrpusr(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmgrpusr(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmcc(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmcc(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmusr(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmusr(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmresgui(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmresgui(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmimg(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmimg(pesquisa);
    }

    @WebMethod
    public OmImg pesquisaOmimgLikeUrl(String url) {
        return IdwFacade.getInstancia().pesquisaOmimgLikeUrl(url);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmCargo(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmCargo(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaTeConcessionaria(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaTeConcessionaria(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaTeTipoConsumidor(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaTeTipoConsumidor(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaTeLei(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaTeLei(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwGrpativ(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwGrpativ(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmgt(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmgt(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmGtPorTp(PesquisaDTO pesquisa, Long idTpGt) {
        return IdwFacade.getInstancia().pesquisaOmGtPorTp(pesquisa, idTpGt);
    }

    @WebMethod
    public Boolean verificaOmGtVazio(@WebParam(name = "idGt") Long idGt) {
        return IdwFacade.getInstancia().verificaOmGtVazio(idGt);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwTCausa(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwTCausa(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwTAcao(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwTAcao(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwTDefeito(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwTDefeito(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwTJust(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwTJust(pesquisa);
    }
    
    @WebMethod
    public PesquisasDTO pesquisaDwTOrigem(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwTOrigem(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmEstoque(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmEstoque(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmgtFabrica(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmgtFabrica(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmtpgt(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmtpgt(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmGtFase(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmGtFase(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaArea(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaArea(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwTParada(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwTParada(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmtppt(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmtppt(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmAlgocor(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmAlgocor(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwRap(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwRap(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwGrupoFerramenta(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwGrupoFerramenta(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoTodosTp(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoTodosTp(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOp(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOp(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoFinal(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoFinal(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoEmbalagem(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoEmbalagem(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoFinalSemiAcabado(PesquisaDTO filtro) {
        return IdwFacade.getInstancia().pesquisaOmprodutoFinalSemiAcabado(filtro);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoFinalDaRota(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoFinalDaRota(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaPedido(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaPedido(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaPpCp(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaPpCp(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmproduto(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoFinal(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoComponente(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoComponente(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoSemiacabado(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoSemiacabado(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoExcessaoProdutoFinal(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoExcessaoProdutoFinal(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoComponenteComAgrupador(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoComponenteComAgrupador(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoAgrupador(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoAgrupador(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprodutoNaFolha(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprodutoNaFolha(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmfornecedor(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmfornecedor(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmprg(OmPt pt, PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmprg(pt, pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmpa(OmPt pt, PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmpa(pt, pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmpt(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmpt(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwprocedimento(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwprocedimento(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmmapa(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmmapa(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaOmcfgscrpimp(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaOmcfgscrpimp(pesquisa);
    }

    @WebMethod
    public GrupoUsuariosDTO getGrupoUsuariosDTO(GrupoUsuarioDTO usuario) {
        return IdwFacade.getInstancia().getGrupoUsuariosDTO(usuario);
    }

    @WebMethod
    public GrupoUsuarioDTO setGrupoUsuarioDTO(GrupoUsuarioDTO usuario) {
        return IdwFacade.getInstancia().setGrupoUsuarioDTO(usuario);
    }

    @WebMethod
    public GrupoUsuariosDTO removeGrupoUsuariosDTO(GrupoUsuariosDTO usuarios) {
        return IdwFacade.getInstancia().removeGrupoUsuariosDTO(usuarios);
    }

    @WebMethod
    public GrupoUsuarioDTO ativaGrupoUsuarioDTO(GrupoUsuarioDTO usuario) {
        return IdwFacade.getInstancia().ativaGrupoUsuarioDTO(usuario);
    }

    @WebMethod
    public DireitoAcessoDTO validarRecursoGUI(DireitoAcessoDTO direitoAcesso) {
        return IdwFacade.getInstancia().validarRecursoGUI(direitoAcesso);
    }

    @WebMethod
    public GTsDTO getGTsDTO(GtDTO gt) {
        return IdwFacade.getInstancia().getGTsDTO(gt);
    }

    @WebMethod
    public MonitorizacaoHierarquicaDTO getGtsHierarquico(OmGt gt) {
        return IdwFacade.getInstancia().getGtsHieraquico(gt);
    }

    @WebMethod
    public GTsDTO getGTsComLayoutDTO(GtDTO gt) {
        return IdwFacade.getInstancia().getGTsComLayoutDTO(gt);
    }

    @WebMethod
    public GTsDTO getAndroidGTsComLayoutDTO() {
        GTsDTO dtos = new GTsDTO();
        dtos.setGts(IdwFacade.getInstancia().getGTsComLayoutDTOAndroid());
        return dtos;
    }

    @WebMethod
    public GtDTO setGTDTO(GtDTO gt) {
        return IdwFacade.getInstancia().setGTDTO(gt);
    }

    @WebMethod
    public GTsDTO removeGTsDTO(GTsDTO gts) {
        return IdwFacade.getInstancia().removeGTsDTO(gts);
    }

    @WebMethod
    public GtDTO ativaGTDTO(GtDTO gt) {
        return IdwFacade.getInstancia().ativaGTDTO(gt);
    }

    @WebMethod
    public ProdutosDTO getProdutosDTO(ProdutoDTO produto) {
        return IdwFacade.getInstancia().getProdutosDTO(produto);
    }

    @WebMethod
    public ProdutosDTO pesquisarProdutosFinaisNoTurno(Date dtReferencia, String cdTurno) {
        return IdwFacade.getInstancia().pesquisarProdutosFinaisNoTurno(dtReferencia, cdTurno);
    }

    @WebMethod
    public ProdutoDTO setProdutoDTO(ProdutoDTO produto) {
        return IdwFacade.getInstancia().setProdutoDTO(produto);
    }

    @WebMethod
	public ProdutoDTO salvarProdutosComBanco(ProdutoDTO produtodto) {
        return IdwFacade.getInstancia().salvarProdutosComBanco(produtodto);
    }

    @WebMethod
    public ProdutosDTO removeProdutosDTO(ProdutosDTO produtos) {
        return IdwFacade.getInstancia().removeProdutosDTO(produtos);
    }

    @WebMethod
    public ProdutoDTO ativaProdutoDTO(ProdutoDTO produto) {
        return IdwFacade.getInstancia().ativaProdutoDTO(produto);
    }

    @WebMethod
    public void setAtualizacaoDwconsolallog(long idConsolallog, String obs, long idUsr) {
        IdwFacade.getInstancia().setAtualizacaoDwconsolallog(idConsolallog, obs, idUsr);
    }

    @WebMethod
    public FornecedoresDTO getFornecedoresDTO(FornecedorDTO fornecedor) {
        return IdwFacade.getInstancia().getFornecedoresDTO(fornecedor);
    }

    @WebMethod
    public FornecedorDTO setFornecedorDTO(FornecedorDTO fornecedor) {
        return IdwFacade.getInstancia().setFornecedorDTO(fornecedor);
    }

    @WebMethod
    public FornecedoresDTO removeFornecedoresDTO(FornecedoresDTO fornecedors) {
        return IdwFacade.getInstancia().removeFornecedoresDTO(fornecedors);
    }

    @WebMethod
    public FornecedorDTO ativaFornecedorDTO(FornecedorDTO fornecedor) {
        return IdwFacade.getInstancia().ativaFornecedorDTO(fornecedor);
    }

    @WebMethod
    public PTsDTO getPTsDTO(PtDTO pt) {
        return IdwFacade.getInstancia().getPTsDTO(pt);
    }

    @WebMethod
    public PTsDTO getPtsDTOSemClonarFilhos(PtDTO pt) {
        return IdwFacade.getInstancia().getPtsDTOSemClonarFilhos(pt);
    }

    @WebMethod
    public PTsDTO getAndroidPTsDTO() {
        return IdwFacade.getInstancia().getAndroidPTsDTO();
    }

    @WebMethod
    public PTsDTO getPTsDeGtDTO(PtDTO pt) {
        return IdwFacade.getInstancia().getPTsDeGtDTO(pt);
    }

    @WebMethod
    public PtDTO setPtDTO(PtDTO pt) {
        return IdwFacade.getInstancia().setPtDTO(pt);
    }

    @WebMethod
    public PTsDTO removePTsDTO(PTsDTO pts) {
        return IdwFacade.getInstancia().removePTsDTO(pts);
    }

    @WebMethod
    public boolean validarPtcnc(OmPtcncDTO ptcnc) {
        return IdwFacade.getInstancia().validarPtcnc(ptcnc);
    }

    @WebMethod
    public PtDTO ativaPtDTO(PtDTO pt) {
        return IdwFacade.getInstancia().ativaPtDTO(pt);
    }

    @WebMethod
    public PaDTO validarPaDTO(PaDTO pa) {
        return IdwFacade.getInstancia().validarPaDTO(pa);
    }

    @WebMethod
    public PAsDTO geracaoAutomaticaPA(PtDTO pt, WizPaDTO wizPa, Integer tipoAlgoritmo) {
        return IdwFacade.getInstancia().geracaoAutomaticaPA(pt, wizPa, tipoAlgoritmo);
    }

    @WebMethod
    public MapasAlimentacaoDTO getMapasAlimentacaoDTO(MapaAlimentacaoDTO mapa) {
        return IdwFacade.getInstancia().getMapasAlimentacaoDTO(mapa);
    }

    @WebMethod
    public MapaAlimentacaoDTO setMapaAlimentacaoDTO(MapaAlimentacaoDTO mapa) {
        return IdwFacade.getInstancia().setMapaAlimentacaoDTO(mapa);
    }

    @WebMethod
    public MapasAlimentacaoDTO removeMapasAlimentacaoDTO(MapasAlimentacaoDTO mapas) {
        return IdwFacade.getInstancia().removeMapasAlimentacaoDTO(mapas);
    }

    @WebMethod
    public MapaAlimentacaoDTO ativaMapaAlimentacaoDTO(MapaAlimentacaoDTO mapa) {
        return IdwFacade.getInstancia().ativaMapaAlimentacaoDTO(mapa);
    }

    @WebMethod
    public MapaPaDTO validarMapaPaDTO(MapaPaDTO mapaPa) {
        return IdwFacade.getInstancia().validarMapaPaDTO(mapaPa);
    }

    @WebMethod
    public AlimentacoesDTO getAlimentacoesDTO(AlimentacaoDTO alimentacao) {
        return IdwFacade.getInstancia().getAlimentacoesDTO(alimentacao);
    }

    @WebMethod
    public EtiquetasDTO getEtiquetasProduto(ProdutosDTO produtos, String script) {
        return IdwFacade.getInstancia().getEtiquetas(produtos, script);
    }

    @WebMethod
    public EtiquetasDTO getEtiquetasMapas(MapasAlimentacaoDTO mapas, String script) {
        return IdwFacade.getInstancia().getEtiquetas(mapas, script);
    }

    @WebMethod
    public EtiquetasDTO getEtiquetasPTs(PTsDTO pts, String script) {
        return IdwFacade.getInstancia().getEtiquetas(pts, script);
    }

    @WebMethod
    public EtiquetasDTO getEtiquetasPAs(PAsDTO pas, String script) {
        return IdwFacade.getInstancia().getEtiquetas(pas, script);
    }

    @WebMethod
    public ComponentesDeParaDTO importarComponentesDePara(ComponentesDeParaDTO componentes) {
        return IdwFacade.getInstancia().importarComponentesDePara(componentes);
    }

    @WebMethod
    public void importarPrograma(String arquivo, String conteudoArquivo, boolean isForcarImportacao) {
        IdwFacade.getInstancia().importarPrograma(arquivo, conteudoArquivo, isForcarImportacao);
    }

    @WebMethod
    public void importarProgramaConteudoBase64(String arquivo, String conteudoArquivo, boolean isForcarImportacao)  throws FalhaSnapshot{
        IdwFacade.getInstancia().importarProgramaConteudoBase64(arquivo, conteudoArquivo, isForcarImportacao);
    }

    @WebMethod
    public UsuarioCODTO getUsuarioCODTO(String matricula) {
        return new UsuarioCODTO(); // IdwFacade.getInstancia().getUsuarioCODTO(matricula);
    }

    @WebMethod
    public MapasCODTO getMapasCODTO(String maquina) {
        return IdwFacade.getInstancia().getMapasCODTO(maquina);
    }

    @WebMethod
    public boolean isMapaValido(String maquina, String mapa) {
        return IdwFacade.getInstancia().isMapaValido(maquina, mapa);
    }

    @WebMethod
    public PosicoesCODTO getPosicoesCODTO(String maquina, String mapa, Boolean isUsarEspelhamento) {
        return IdwFacade.getInstancia().getPosicoesCODTO(maquina, mapa, isUsarEspelhamento);
    }

    @WebMethod
    public boolean setConferenciaOuPre(LeiturasCODTO leituras) {
        return IdwFacade.getInstancia().setConferenciaOuPre(leituras);
    }

    @WebMethod
    public LeiturasCODTO setCorrente(LeiturasCODTO leituras) {
        return IdwFacade.getInstancia().setCorrente(leituras);
    }

    @WebMethod
    public boolean setRealimentacao(LeiturasCODTO leituras) {
        return IdwFacade.getInstancia().setRealimentacao(leituras);
    }

    @WebMethod
    public boolean isProdutoEAlternativo(String cdProduto, String cdProdutoLido) {
        return IdwFacade.getInstancia().isProdutoEAlternativo(cdProduto, cdProdutoLido);
    }

    @WebMethod
    public void assumePreConferencia(String maquina) {
        IdwFacade.getInstancia().assumePreConferencia(maquina);
    }

    @WebMethod
    public LeiturasCODTO getCorrente(Long idAlimCorrente) {
        return IdwFacade.getInstancia().getCorrente(idAlimCorrente);
    }

    @WebMethod
    public boolean isRecursoAcessivel(int idAcesso, long idUsr) {
        return IdwFacade.getInstancia().isRecursoAcessivel(idAcesso, idUsr);
    }

    @WebMethod
    public HomologacoesDTO validarHomologacoesUsrPt(HomologacoesDTO homologacoesDTO) {
        return IdwFacade.getInstancia().validarHomologacoesUsrPt(homologacoesDTO);
    }

    @WebMethod
    public HomologacoesDTO validarHomologacoesUsrGt(HomologacoesDTO homologacoesDTO) {
        return IdwFacade.getInstancia().validarHomologacoesUsrGt(homologacoesDTO);
    }

    @WebMethod
    public HomologacoesDTO validarHomologacoesGt(HomologacoesDTO homologacoesDTO) {
        return IdwFacade.getInstancia().validarHomologacoesGt(homologacoesDTO);
    }

    @WebMethod
    public HomologacoesDTO validarHomologacoesPt(HomologacoesDTO homologacoesDTO) {
        return IdwFacade.getInstancia().validarHomologacoesPt(homologacoesDTO);
    }

    @WebMethod
    public ParametrosDTO getParametrosDTO(ParametroDTO parametro) {
        return IdwFacade.getInstancia().getParametrosDTO(parametro);
    }

    @WebMethod
    public ParametrosDTO getParametrosDTOComoListaGeral() {
        return IdwFacade.getInstancia().getParametrosDTOComoListaGeral();
    }

    @WebMethod
    public ConfiguracoesDTO getConfiguracoesDTO(ConfiguracaoDTO configuracao) {
        return IdwFacade.getInstancia().getConfiguracoesDTO(configuracao);
    }

    @WebMethod
    public ResultadoDTO removerProdutosSemConsumoDoEstoque() {
        return IdwFacade.getInstancia().removerProdutosSemConsumoDoEstoque();
    }

    @WebMethod
    public ParametroDTO setParametroDTO(ParametroDTO parametro) {
        return IdwFacade.getInstancia().setParametroDTO(parametro);
    }

    @WebMethod
    public ConfiguracaoDTO setConfiguracaoDTO(ConfiguracaoDTO configuracao) {
        return IdwFacade.getInstancia().setConfiguracaoDTO(configuracao);
    }

    @WebMethod
    public ParametrosDTO removeParametrosDTO(ParametrosDTO parametros) {
        return IdwFacade.getInstancia().removeParametrosDTO(parametros);
    }

    @WebMethod
    public ConfiguracoesDTO removeConfiguracoesDTO(ConfiguracoesDTO configuracoes) {
        return IdwFacade.getInstancia().removeConfiguracoesDTO(configuracoes);
    }

    @WebMethod
    public TurnosDTO getTurnosDTO(TurnoDTO itemDTO) {
        return IdwFacade.getInstancia().getTurnosDTO(itemDTO);
    }

    @WebMethod
    public TurnoDTO setTurnoDTO(TurnoDTO itemDTO) {
        return IdwFacade.getInstancia().setTurnoDTO(itemDTO);
    }

    @WebMethod
    public TurnosDTO removeTurnosDTO(TurnosDTO itemDTO) {
        return IdwFacade.getInstancia().removeTurnosDTO(itemDTO);
    }

    @WebMethod
    public TurnoDTO ativaTurnoDTO(TurnoDTO itemDTO) {
        return IdwFacade.getInstancia().ativaTurnoDTO(itemDTO);
    }

    @WebMethod
    public TDefeitosDTO getTDefeitosDTO(TDefeitoDTO itemDTO) {
        return IdwFacade.getInstancia().getTDefeitosDTO(itemDTO);
    }

    @WebMethod
    public TDefeitoDTO setTDefeitoDTO(TDefeitoDTO itemDTO) {
        return IdwFacade.getInstancia().setTDefeitoDTO(itemDTO);
    }

    @WebMethod
    public TDefeitosDTO removeTDefeitosDTO(TDefeitosDTO itemDTO) {
        return IdwFacade.getInstancia().removeTDefeitosDTO(itemDTO);
    }

    @WebMethod
    public TDefeitoDTO ativaTDefeitoDTO(TDefeitoDTO itemDTO) {
        return IdwFacade.getInstancia().ativaTDefeitoDTO(itemDTO);
    }

    @WebMethod
    public TAcoesDTO getTAcoesDTO(TAcaoDTO itemDTO) {
        return IdwFacade.getInstancia().getTAcoesDTO(itemDTO);
    }

    @WebMethod
    public DwFolhasDTO getFolhasDoPt(OmPt pt) {
        return IdwFacade.getInstancia().getFolhasDoPt(pt);
    }

    @WebMethod
    public TAcaoDTO setTAcaoDTO(TAcaoDTO itemDTO) {
        return IdwFacade.getInstancia().setTAcaoDTO(itemDTO);
    }

    @WebMethod
    public TAcoesDTO removeTAcoesDTO(TAcoesDTO itemDTO) {
        return IdwFacade.getInstancia().removeTAcoesDTO(itemDTO);
    }

    @WebMethod
    public TAcaoDTO ativaTAcaoDTO(TAcaoDTO itemDTO) {
        return IdwFacade.getInstancia().ativaTAcaoDTO(itemDTO);
    }

    @WebMethod
    public GruposProdutoDTO getGruposProdutoDTO(GrupoProdutoDTO itemDTO) {
        return IdwFacade.getInstancia().getGruposProdutoDTO(itemDTO);
    }

    @WebMethod
    public GrupoProdutoDTO setGrupoProdutoDTO(GrupoProdutoDTO itemDTO) {
        return IdwFacade.getInstancia().setGrupoProdutoDTO(itemDTO);
    }

    @WebMethod
    public GruposProdutoDTO removeGruposProdutoDTO(GruposProdutoDTO itemDTO) {
        return IdwFacade.getInstancia().removeGruposProdutoDTO(itemDTO);
    }

    @WebMethod
    public GrupoProdutoDTO ativaGrupoProdutoDTO(GrupoProdutoDTO itemDTO) {
        return IdwFacade.getInstancia().ativaGrupoProdutoDTO(itemDTO);
    }

    @WebMethod
    public CalendariosDTO getCalendariosDTO(CalendarioDTO itemDTO) {
        return IdwFacade.getInstancia().getCalendariosDTO(itemDTO);
    }

    @WebMethod
    public CalendarioDTO setCalendarioDTO(CalendarioDTO itemDTO) {
        return IdwFacade.getInstancia().setCalendarioDTO(itemDTO);
    }

    @WebMethod
    public CalendariosDTO removeCalendariosDTO(CalendariosDTO itemDTO) {
        return IdwFacade.getInstancia().removeCalendariosDTO(itemDTO);
    }

    @WebMethod
    public CalendarioPtsDTO validarCalendarioPtsDTO(CalendarioPtsDTO itemDTO) {
        return IdwFacade.getInstancia().validarCalendarioPtsDTO(itemDTO);
    }

    @WebMethod
    public CalendariosSemanaisDTO getCalendariosSemanaisDTO(CalendarioSemanalFiltroDTO itemDTO) {
        return IdwFacade.getInstancia().getCalendariosSemanaisDTO(itemDTO);
    }
    @WebMethod
    public CalendariosSemanaisDTO getCalendarioPt(Long idCal) {
        return IdwFacade.getInstancia().getCalendarioPt(idCal);
    }

    @WebMethod
    public CalendariosSemanaisDTO wizardCalendario(CalendarioWizardDTO itemDTO) {
        return IdwFacade.getInstancia().wizardCalendario(itemDTO);
    }

    @WebMethod
    public SessoesDTO inicializacao(String mac, Date dthrevento) {
        return IdwFacade.getInstancia().inicializacao(mac, dthrevento);
    }

    @WebMethod
    public SessoesDTO heartBeat(String mac, Date dthrevento) {
        return IdwFacade.getInstancia().heartBeat(mac, dthrevento);
    }

    @WebMethod
    public LoginDTO setLoginDTO(LoginDTO login) {
        return IdwFacade.getInstancia().setLoginDTO(login);
    }

    @WebMethod
    public LogoutDTO setLogoutDTO(LogoutDTO logout) {
        return IdwFacade.getInstancia().setLogoutDTO(logout);
    }

    @WebMethod
    public PassagemDTO postoPassagem(PassagemDTO passagem) {
        return IdwFacade.getInstancia().postoPassagem(passagem);
    }

    @WebMethod
    public PassagemDTO postoTesteVisual(PassagemDTO passagem) {
        return IdwFacade.getInstancia().postoTesteVisual(passagem);
    }

    @WebMethod
    public PassagemDTO postoReprocesso(PassagemDTO passagem) {
        return IdwFacade.getInstancia().postoReprocesso(passagem);
    }

    @WebMethod
    public PassagemDTO postoMontagem(PassagemDTO passagem) {
        return IdwFacade.getInstancia().postoMontagem(passagem);
    }

    @WebMethod
    public PassagemDTO verificaPassagem(PassagemDTO passagem) {
        return IdwFacade.getInstancia().verificaPassagem(passagem);
    }

    @WebMethod
    public PassagemDTO obtemNaoConformidadesAtuais(PassagemDTO passagem) {
        return IdwFacade.getInstancia().obtemNaoConformidadesAtuais(passagem);
    }

    @WebMethod
    public EtapasDTO getEtapasDTO(EtapaDTO itemDTO) {
        return IdwFacade.getInstancia().getEtapasDTO(itemDTO);
    }

    @WebMethod
    public EtapaDTO setEtapaDTO(EtapaDTO itemDTO) {
        return IdwFacade.getInstancia().setEtapaDTO(itemDTO);
    }

    @WebMethod
    public EtapasDTO removeEtapasDTO(EtapasDTO itemDTO) {
        return IdwFacade.getInstancia().removeEtapasDTO(itemDTO);
    }

    @WebMethod
    public FolhasDTO getFolhasDTO(FolhaDTO itemDTO) {
        return IdwFacade.getInstancia().getFolhasDTO(itemDTO);
    }

    @WebMethod
    public FolhaDTO setFolhaDTO(FolhaDTO itemDTO) {
        return IdwFacade.getInstancia().setFolhaDTO(itemDTO);
    }

    @WebMethod
    public FolhasDTO getFolhasDTOSemClonarFilhos(FolhaDTO itemDTO) {
        return IdwFacade.getInstancia().getFolhasDTOSemClonarFilhos(itemDTO);
    }

    @WebMethod
    public void updateFolhaDTO(FolhaDTO itemDTO) {
        IdwFacade.getInstancia().updateFolhaDTO(itemDTO);
    }

    @WebMethod
    public FolhasDTO removeFolhasDTO(FolhasDTO itemDTO) {
        return IdwFacade.getInstancia().removeFolhasDTO(itemDTO);
    }

    @WebMethod
    public AcoplamentoDTO verificaAcoplamento(AcoplamentoDTO acoplamento, MontagensDTO montagens) {
        return IdwFacade.getInstancia().verificaAcoplamento(acoplamento, montagens);
    }

    @WebMethod
    public AcoplamentoDTO verificaComponenteAcoplamento(AcoplamentoDTO acoplamento, MontagensDTO montagens) {
        return IdwFacade.getInstancia().verificaComponenteAcoplamento(acoplamento, montagens);
    }

    @WebMethod
    public DefeitoDTO verificaDefeito(DefeitoDTO defeito) {
        return IdwFacade.getInstancia().verificaDefeito(defeito);
    }

    @WebMethod
    public ComponenteDTO verificaComponente(ComponenteDTO componente) {
        return IdwFacade.getInstancia().verificaComponente(componente);
    }

    @WebMethod
    public RoteirosDTO getRoteirosDTO(RoteiroDTO itemDTO) {
        return IdwFacade.getInstancia().getRoteirosDTO(itemDTO);
    }

    @WebMethod
    public RoteirosDTO preenchePesquisaRoteiro(RoteiroDTO itemDTO) {
        return IdwFacade.getInstancia().preenchePesquisaRoteiro(itemDTO);
    }

    @WebMethod
    public RoteiroDTO setRoteiroDTO(RoteiroDTO itemDTO) {
        return IdwFacade.getInstancia().setRoteiroDTO(itemDTO);
    }

    @WebMethod
    public RoteirosDTO removeRoteirosDTO(RoteirosDTO itemDTO) {
        return IdwFacade.getInstancia().removeRoteirosDTO(itemDTO);
    }

    @WebMethod
    public ImgsDTO getImgsDTO(ImgDTO itemDTO) {
        return IdwFacade.getInstancia().getImgsDTO(itemDTO);
    }

    @WebMethod
    public ImgsDTO getImgsRoteiroDTO(ImgDTO itemDTO) {
        return IdwFacade.getInstancia().getImgsRoteiroDTO(itemDTO);
    }

    @WebMethod
    public ObjsDTO getArvoreObjsGt(GtDTO gt) {
        return IdwFacade.getInstancia().getArvoreObjsGt(gt);
    }

    @WebMethod
    public ObjsDTO getObjsDTO(ObjDTO itemDTO) {
        return IdwFacade.getInstancia().getObjsDTO(itemDTO);
    }

    @WebMethod
    public GtRtDTO getGtRtDTO(GtRtDTO gtDTOFiltro) {
        return IdwFacade.getInstancia().getGtRtDTO(gtDTOFiltro);
    }

    @WebMethod
    public GtRtMonitorizacaoDTO getGtRtMonitorizacaoDTO(GtRtDTO GtRtDTOFiltro) {
        return IdwFacade.getInstancia().getGtRtMonitorizacaoDTO(GtRtDTOFiltro);
    }

    @WebMethod
    public GtRtMonitorizacaoDTO getGtRtMonitorizacaoAcum(GtRtDTO GtRtDTOFiltro) {
        return IdwFacade.getInstancia().getGtRtMonitorizacaoAcum(GtRtDTOFiltro);
    }

    @WebMethod
    public ObjDTO getOmObjInicializado() {
        return IdwFacade.getInstancia().getOmObjInicializado();
    }

    @WebMethod
    public ObjsDTO getObjsRoteiroDTO(ObjDTO itemDTO) {
        return IdwFacade.getInstancia().getObjsRoteiroDTO(itemDTO);
    }

    @WebMethod
    public void setObjsRoteiro(DwRota dwRota) {
        IdwFacade.getInstancia().setObjsRoteiro(dwRota);
    }

    @WebMethod
    public PassagemDTO postoTesteFuncional(PassagemDTO passagem) {
        return IdwFacade.getInstancia().postoTesteFuncional(passagem);
    }

    @WebMethod
    public DetalhePTDTO detalhePT(FiltroDetalhePTDTO filtro) {
        return IdwFacade.getInstancia().detalhePT(filtro);
    }

    @WebMethod
    public DetalhesColetasDTO detalheColeta(long idSubetapa) {
        return IdwFacade.getInstancia().detalhesColetas(idSubetapa);
    }

    @WebMethod
    public RelIndTesteFinalDTO getRelIndTesteFinal(FiltroRelDTO filtro) {
        return IdwFacade.getInstancia().getRelIndTesteFinal(filtro);
    }

    @WebMethod
    public DetalhePTGraficoTesteFuncionalDTO getGraficoTesteFuncional(FiltroDetalhePTDTO filtro) {
        return IdwFacade.getInstancia().getGraficoTesteFuncional(filtro);
    }

    @WebMethod
    public FolhasDTO getFolhasporProduto(ProdutoDTO itemDTO) {
        return IdwFacade.getInstancia().getFolhasporProduto(itemDTO);
    }

    @WebMethod
    public EstoquesDTO getEstoquesDTO(EstoqueDTO itemDTO) {
        return IdwFacade.getInstancia().getEstoquesDTO(itemDTO);
    }

    @WebMethod
    public EstoqueDTO setEstoqueDTO(EstoqueDTO itemDTO) {
        return IdwFacade.getInstancia().setEstoqueDTO(itemDTO);
    }

    @WebMethod
    public EstoquesDTO removeEstoqueDTO(EstoquesDTO itemDTO) {
        return IdwFacade.getInstancia().removeEstoquesDTO(itemDTO);
    }

    public EstoqueDTO ativaEstoqueDTO(EstoqueDTO itemDTO) {
        return IdwFacade.getInstancia().ativaEstoqueDTO(itemDTO);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwRota(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaDwRota(pesquisa);
    }

    @WebMethod
    public DetalhePTSerieDTO detalheEtapasTeste(long idNSerie) {
        return IdwFacade.getInstancia().detalheEtapasTeste(idNSerie);
    }

    @WebMethod
    public PesquisasDTO pesquisaCliente(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaCliente(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaUnidadeMedida(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaUnidadeMedida(pesquisa);
    }

    @WebMethod
    public ConfiguracoesNecessidadesDTO pesquisaListaConfiguracaoNecessidadeDTO(ConfiguracaoNecessidadeDTO configuracaoNecessidadeDTO) {
        return IdwFacade.getInstancia().pesquisarListaConfiguracaoNecessidadeDTO(configuracaoNecessidadeDTO);
    }

    @WebMethod
    public ConfiguracaoNecessidadeDTO setConfiguracoesNecessidadesDTO(ConfiguracaoNecessidadeDTO itemDTO) {
        return IdwFacade.getInstancia().setConfiguracaoNecessidadeDTO(itemDTO);
    }

    @WebMethod
    public ConfiguracaoNecessidadeDTO setExclusaoConfiguracoesNecessidadesDTO(ConfiguracaoNecessidadeDTO itemDTO) {
        return IdwFacade.getInstancia().setExclusaoConfiguracoesNecessidadesDTO(itemDTO);
    }

    @WebMethod
    public PpNecListDTO pesquisaListaNecessidadesClientesDTO(PpNecDTO ppNecDTO) {
        return IdwFacade.getInstancia().pesquisarListaNecessidadesClientesDTO(ppNecDTO);
    }

    @WebMethod
    public PpNecListDTO importarPlanilhas(PpNecListDTO listaPpNec) {
        return IdwFacade.getInstancia().importarPlanilhas(listaPpNec);
    }

    @WebMethod
    public PpNecimplogListDTO buscarLogs(Long idNecimp, Integer limiteMaximo) {
        return IdwFacade.getInstancia().buscarLogs(idNecimp, limiteMaximo);
    }

    @WebMethod
    public PpNecimpurllogListDTO pesquisarAbasByUrlLog(PpNecimpurllogListDTO logDTO) {
        return IdwFacade.getInstancia().pesquisarAbasByUrlLog(logDTO);
    }

    @WebMethod
    public PpNecDTO setNecessidadesClientesDTO(PpNecDTO itemDTO) {
        return IdwFacade.getInstancia().setNecessidadesClientesDTO(itemDTO);
    }

    @WebMethod
    public PpNecDTO setExclusaoNecessidadesClientesDTO(PpNecDTO itemDTO) {
        return IdwFacade.getInstancia().setExclusaoNecessidadesClientesDTO(itemDTO);
    }

    @WebMethod
    public DwRapListDTO pesquisaListaRAPDTO(DwRapDTO itemDTO) {
        return IdwFacade.getInstancia().pesquisarListaRAPDTO(itemDTO);
    }

    @WebMethod
    public DwRapDTO setRAPDTO(DwRapDTO itemDTO) {
        return IdwFacade.getInstancia().setRAPDTO(itemDTO);
    }

    @WebMethod
    public DwRapDTO setExclusaoRAPDTO(DwRapDTO itemDTO) {
        return IdwFacade.getInstancia().setExclusaoRAPDTO(itemDTO);
    }

    @WebMethod
    public PlanoListDTO pesquisarPlanos(PlanoDTO plano) {
        return IdwFacade.getInstancia().pesquisarPlanosPlanoProducao(plano);
    }

    @WebMethod
    public PesquisasDTO pesquisarPlanosBusca(PlanoDTO plano) {
        return IdwFacade.getInstancia().pesquisarPlanosPlanoProducaoBusca(plano);
    }

    @WebMethod
    public PpTpplanoListDTO pesquisarTpPlanos(PpTpplanoDTO pptpplanoDTO) {
        return IdwFacade.getInstancia().pesquisarTpPlanos(pptpplanoDTO);
    }

    @WebMethod
    public PlanoDTO salvarPlano(PlanoDTO plano) {
        return IdwFacade.getInstancia().salvarPlano(plano);
    }

    @WebMethod
    public PlanoDTO firmarPlano(PlanoDTO plano, Boolean isForcarFirmar) {
        return IdwFacade.getInstancia().firmarPlano(plano, isForcarFirmar);
    }

    @WebMethod
    public PpNecListDTO pesquisarPpNecs(Date dtReferencia) {
        return IdwFacade.getInstancia().pesquisarPpNecs(dtReferencia);
    }

    @WebMethod
    public PlanoDTO excluirRegistro(PlanoDTO planoDTO) {
        return IdwFacade.getInstancia().excluirRegistro(planoDTO);
    }

    @WebMethod
    public PesquisasDTO pesquisaRAPs(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaRAPs(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaDwFolhaRap() {
        return IdwFacade.getInstancia().pesquisaDwFolhaRap();
    }

    @WebMethod
    public PesquisasDTO pesquisaProgramaIAC(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaProgramaIAC(pesquisa);
    }

    @WebMethod
    public PesquisasDTO pesquisaProdutoIAC(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaProdutoIAC(pesquisa);
    }

    @WebMethod
    public PTsDTO getPtsAtivos() {
        return IdwFacade.getInstancia().getPtsAtivos();
    }

    @WebMethod
    public PTsDTO getPtsSemCnc() {
        return IdwFacade.getInstancia().getPtsSemCnc();
    }

    @WebMethod
    public IndicadoresMinMetaMaxDTO buscarIndicadoresMinMetaMax(FiltroIndCfg filtro) {
        return IdwFacade.getInstancia().buscaIndicadoresMinMetaMax(filtro);
    }

    @WebMethod
    public DwRotapasso getOmPtDwRotapasso(DwRotapasso rotapasso) {
        return IdwFacade.getInstancia().getOmPtDwRotapasso(rotapasso);
    }

    @WebMethod
    public PlanoListDTO pesquisarPlanoECPs(PlanoDTO planoDTO) {
        return IdwFacade.getInstancia().pesquisarPlanoECPs(planoDTO);
    }

    @WebMethod
    public PtGtDTO pesquisarCentrosTrabalho() {
        return IdwFacade.getInstancia().pesquisarCentrosTrabalho();
    }

    @WebMethod
    public PtGtDTO pesquisarCentrosComCPsDeProdutosIguais(OmProduto produto) {
        return IdwFacade.getInstancia().pesquisarCentrosComCPsDeProdutosIguais(produto);
    }

    @WebMethod
    public PlanoDTO salvarPlanoManipulacao(PlanoDTO plano) {
        return IdwFacade.getInstancia().salvarPlanoManipulacao(plano);
    }

    @WebMethod
    public EstoquesDTO pesquisarEstoqueMateriaPrima(String cdEst, String cdProduto, String cdCliente) {
        return IdwFacade.getInstancia().pesquisarEstoqueMateriaPrima(cdEst, cdProduto, cdCliente);
    }

    @WebMethod
    public EstoqueDTO salvarPrevChegadaMateriaPrima(EstoquesDTO estoquesDTO) {
        return IdwFacade.getInstancia().salvarPrevChegadaMateriaPrima(estoquesDTO);
    }

    @WebMethod
    public ProdutoDTO importarPlanilhaEstruturaProduto(ProdutoDTO produto) {
        return IdwFacade.getInstancia().importarPlanilhaEstruturaProduto(produto);
    }
    /*
    @WebMethod
    public ProdutoDTO importarPlanilhaComponente(ProdutoDTO produto) {
        return IdwFacade.getInstancia().importarPlanilhaComponente(produto);
    }
	*/
    @WebMethod
    public SapEstoquesDTO getSapEstoquesDTO(SapEstoqueDTO sapestoque) {
        return IdwFacade.getInstancia().getSapEstoquesDTO(sapestoque);
    }

    @WebMethod
    public SapConhecimentosDTO getSapConhecimentosDTO(SapConhecimentoDTO sapconhecimento) {
        return IdwFacade.getInstancia().getSapConhecimentosDTO(sapconhecimento);
    }

    @WebMethod
    public PTsDTO pesquisarOmPtsAtivosComGt() {
        return IdwFacade.getInstancia().pesquisarOmPtsAtivos();
    }

    @WebMethod
    public DwConsolidDTOs pesquisarApontamentoProducao(DwConsolidDTO dto) {
        return IdwFacade.getInstancia().pesquisarApontamentoProducao(dto);
    }

    @WebMethod
    public DwTurnosDTO pesquisarTurnos() {
        return IdwFacade.getInstancia().pesquisarTurnos();
    }

    @WebMethod
    public DwFolhasDTO pesquisaProdutoNaFolha(String cdProduto, long idpt) {
        return IdwFacade.getInstancia().pesquisaProdutoNaFolha(cdProduto, idpt);
    }

    @WebMethod
    public void salvarApontamentoManual(DwConsolidDTOs dwConsolidDTOs) {
        IdwFacade.getInstancia().salvarApontamentoManual(dwConsolidDTOs);
    }

    @WebMethod
    public DsEspecializaAponDTO getEspecializaApon() {
        return IdwFacade.getInstancia().getEspecializaApon();
    }

    @WebMethod
    public TmgConhecimentosDTO getTmgConhecimentosDTO(TmgConhecimentoDTO tmgconhecimento) {
        return IdwFacade.getInstancia().getTmgConhecimentosDTO(tmgconhecimento);
    }

    @WebMethod
    public MsDetectorDTO salvarAlertaPlanejamento(MsDetectorDTO dto) {
        return IdwFacade.getInstancia().salvarAlertaPlanejamento(dto);
    }

    @WebMethod
    public PerfisAndonDTO getMsPerfilandon(PerfilAndonDTO dto) {
        return IdwFacade.getInstancia().getMsPerfilandon(dto);
    }

    @WebMethod
    public PerfisAndonDTO getPerfilAndonsAtivos() {
        return IdwFacade.getInstancia().getPerfilAndonsAtivos();
    }

    @WebMethod
    public PerfilAndonDTO setMsPerfilandon(PerfilAndonDTO dto) {
        return IdwFacade.getInstancia().setMsPerfilandon(dto);
    }

    @WebMethod
    public PerfilAndonDTO excluirPerfilAndon(PerfilAndonDTO dto) {
        return IdwFacade.getInstancia().excluirPerfilAndon(dto);
    }

    @WebMethod
    public ListaIcDTO getMsIcsStandalone() {
        return MsFacade.getInstancia().metMsIcsStandalone();
    }

    @WebMethod
    public PlanosIndisponibilidadesDTO pesquisarPlanoIndisponibilidade(PlanoIndisponibilidadeDTO plano) {
        return IdwFacade.getInstancia().pesquisarPlanoIndisponibilidade(plano);
    }

    @WebMethod
    public PlanoIndisponibilidadeDTO salvarPlanoIndisponibilidade(PlanoIndisponibilidadeDTO plano) {
        return IdwFacade.getInstancia().salvarPlanoIndisponibilidade(plano);
    }

    @WebMethod
    public PlanoIndisponibilidadeDTO excluirPlanoIndisponibilidade(PlanoIndisponibilidadeDTO plano) {
        return IdwFacade.getInstancia().excluirPlanoIndisponibilidade(plano);
    }

    @WebMethod
    public PlanoListDTO pesquisarPlanosPlanejamentoProducao(PlanoDTO planoDTO) {
        return IdwFacade.getInstancia().pesquisarPlanosPlanejamentoProducao(planoDTO);
    }

    @WebMethod
    public PlanoAcompanhamentoDTOList pesquisarAcompanhamentosDoPlano(PlanoAcompanhamentoDTO planoAcomp) {
        return IdwFacade.getInstancia().pesquisarAcompanhamentosDoPlano(planoAcomp);
    }

    @WebMethod
    public MsTpEvtsDTO pesquisarMsTpEvts() {
        return IdwFacade.getInstancia().pesquisarMsTpEvts();
    }

    @WebMethod
    public OmTpptDTO pesquisarOmTppts() {
        return IdwFacade.getInstancia().pesquisaOmTppts();
    }

    @WebMethod
    public MsIndsDTO pesquisaInds() {
        return IdwFacade.getInstancia().pesquisaInds();
    }

    @WebMethod
    public MsDetectorsDTO pesquisarMsDetector(MsDetectorDTO dto) {
        return IdwFacade.getInstancia().pesquisarMsDetector(dto);
    }

    @WebMethod
    public MsDetectorDTO excluirMsDetectors(MsDetectorsDTO msDetectorsDTO) {
        return IdwFacade.getInstancia().excluirMsDetectors(msDetectorsDTO);
    }

    @WebMethod
    public PpCmDTO salvarCmEstrutura(PpCmDTO itemDto) {
        return IdwFacade.getInstancia().salvarCmEstrutura(itemDto);
    }

    @WebMethod
    public ResultadoImportacaoSapDTO importarSap(idw.webservices.dto.UsuarioDTO usrlogadodto) {
        return IdwFacade.getInstancia().importarSap(usrlogadodto);
    }

    @WebMethod
    public FolhasDTO importarCiclos(FolhasDTO folhas, idw.webservices.dto.UsuarioDTO usrlogadodto) {
        return IdwFacade.getInstancia().importarPlanilhaCiclos(folhas, usrlogadodto);
    }

    @WebMethod
    public DwConsolidDTOs importarProducao(DwConsolidDTOs apontamentos, idw.webservices.dto.UsuarioDTO usrlogadodto) {
        return IdwFacade.getInstancia().importarPlanilhaProducao(apontamentos, usrlogadodto);
    }

    @WebMethod
    public PlanoDTO simularPlano(PlanoDTO plano) {
        return IdwFacade.getInstancia().simularPlano(plano);
    }

    @WebMethod
    public PpCmsDTO pesquisarPpCm(PpCmDTO itemDTO) {
        return IdwFacade.getInstancia().pesquisarPpCm(itemDTO);
    }

    @WebMethod
    public PpCmDTO removePpCm(PpCmDTO itemDTO) {
        return IdwFacade.getInstancia().removePpCm(itemDTO);
    }

    @WebMethod
    public ResultadoImportacaoSapDTO importarPlanilhaSAP(SapEstoquesDTO estoques, idw.webservices.dto.UsuarioDTO usuario) {
        return IdwFacade.getInstancia().importarPlanilhaSAP(estoques, usuario);
    }

    @WebMethod
    public ListaCPDTO pesquisarCpComPedido(PpCp cp) {
        return IdwFacade.getInstancia().pesquisarCpComPedido(cp);
    }

    @WebMethod
    public ListaCPDTO pesquisaListaPredecessoraCP(Long idCp) {
        return IdwFacade.getInstancia().pesquisaListaPredecessoraCP(idCp);
    }

    @WebMethod
    public PpNecListDTO pesquisarTodosCpComPedidoAtivo() {
        return IdwFacade.getInstancia().pesquisarTodosCpComPedidoAtivo();
    }

    @WebMethod
    public CpsDTO pesquisarCpByProdutoFinal(String cdproduto) {
        return IdwFacade.getInstancia().pesquisarCpByProdutoFinal(cdproduto);
    }

    @WebMethod
    public PtImgMonitorizacaoDTO getImgsPTsDTO() {
        return IdwFacade.getInstancia().getImgsPTsDTO();
    }

    @WebMethod
    public ObjsLayoutRoteiroDTO getObjsLayoutRoteiroDTO() {
        return IdwFacade.getInstancia().getObjsLayoutRoteiroDTO();
    }

    @WebMethod
    public GtImgMonitorizacaoDTO getImgsGTsDTO() {
        return IdwFacade.getInstancia().getImgsGTsDTO();
    }

    @WebMethod
    public DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPtInjetDTO(FiltroDetalhePTInjetDTO filtro) {
        return IdwFacade.getInstancia().getDetalheMonitorizacaoPtInjetDTO(filtro);
    }

    @WebMethod
    public DwFolhasDTO getDwFolhasPorCod(FolhaDTO filtro) {
        return IdwFacade.getInstancia().getDwFolhasPorCod(filtro);
    }

    @WebMethod
    public ProdutosDTO pesquisarProdutosPaiDisponiveis(Long idProduto) {
        return IdwFacade.getInstancia().pesquisarProdutosPaiDisponiveis(idProduto);
    }

    @WebMethod
    public GTsDTO getOmGtsAtivosPorTp(int idTpGt) {
        return IdwFacade.getInstancia().getOmGtsAtivosPorTp(idTpGt);
    }

    @WebMethod
    public PTsDTO getOmPtsAtivosPorTp(int idTpPt) {
        return IdwFacade.getInstancia().getOmPtsAtivosPorTp(idTpPt);
    }

    /* Aqui comecao os webservices para o MsWs */
    // Comentei pq passei todos eles para uma nova classe de webservice e qdo
    // estao aqui da erro na subida do webservice
    // possivelmente por conflito de nome de classes
    /*
     * WebServices vindos de MsWs
     */

    // Alessandre: O webservice abaixo foi comentado pois deve-se usar o do IDW
    // @WebMethod
    // public UsuarioMSDTO isUsuarioAutenticado(UsuarioMSDTO usuarioDTO){
    // return MsFacade.getInstancia().isUsuarioAutenticado(usuarioDTO);
    // }

    @WebMethod
    public ListaIcDTO getListaIcDTO(IcDTO icDTO) {
        return MsFacade.getInstancia().getListaIcDTO(icDTO);
    }

    @WebMethod
    public ListaIcDTO removeIcDTO(IcDTO icDTO) {
        return MsFacade.getInstancia().removeIcDTO(icDTO);
    }

    @WebMethod
    public ListaIhmDTO getListaIhmDTO(IhmDTO ihmDTO) {
        return MsFacade.getInstancia().getListaIhmDTO(ihmDTO);
    }

    @WebMethod
    public ListaIhmDTO setihmDTO(IhmDTO ihmDTO) {
        return MsFacade.getInstancia().setihmDTO(ihmDTO);
    }

    @WebMethod
    public ListaIhmDTO removeIhmDTO(IhmDTO ihmDTO) {
        return MsFacade.getInstancia().removeIhmDTO(ihmDTO);
    }

    @WebMethod
    public ListaMSDTO getListaMSDTO(MsDTO msDTO) {
        return MsFacade.getInstancia().getListaMSDTO(msDTO);
    }

    @WebMethod
    public ListaMSDTO setMSDTO(MsDTO msDTO) {
        return MsFacade.getInstancia().setMSDTO(msDTO);
    }

    @WebMethod
    public ListaMSDTO removeMSDTO(MsDTO msDTO) {
        return MsFacade.getInstancia().removeMSDTO(msDTO);
    }

    @WebMethod
    public ListaUPDTO getTodosUPDTO() {
        return MsFacade.getInstancia().getTodosUPDTO();
    }

    @WebMethod
    public ListaIcDTO getTodosIcDTO() {
        return MsFacade.getInstancia().getTodosIcDTO();
    }

    @WebMethod
    public IcDTO pesquisarMsIcPorUrlConexao(String urlconexao) {
        return MsFacade.getInstancia().pesquisarMsIcPorUrlConexao(urlconexao);
    }

    @WebMethod
    public ListaIhmDTO getTodosIhmDTO() {
        return MsFacade.getInstancia().getTodosIhmDTO();
    }

    @WebMethod
    public ListaUPDTO getListaupDTO(UpDTO upDTO) {
        return MsFacade.getInstancia().getListaupDTO(upDTO);
    }

    @WebMethod
    public ListaUPDTO setupDTO(UpDTO upDTO) {
        return MsFacade.getInstancia().salvarUpDTO(upDTO);
    }

    @WebMethod
    public ListaUPDTO removeUpDTO(UpDTO upDTO) {
        return MsFacade.getInstancia().removeUpDTO(upDTO);
    }

    @WebMethod
    public ListaUPDTO removeUpsDTO(ListaUPDTO listaUPDTO) {
        return MsFacade.getInstancia().removeUpsDTO(listaUPDTO);
    }

    @WebMethod
    public ListaUPDTO getTodosPrUp() {
        return MsFacade.getInstancia().getTodosPrUp();
    }

    @WebMethod
    public ListaEvtDTO pesquisaListaEvtDTO(String cdUp, Integer qtLinhas) {
        return MsFacade.getInstancia().pesquisarListaEvtDTO(cdUp, qtLinhas);
    }

    @WebMethod
    public boolean salvarConfiguracoesHibernate(ConfiguraHibernateDTO configuraHibernateDTO, int tipoHibernate) {
        return MsFacade.getInstancia().salvarConfiguracoesHibernate(configuraHibernateDTO, tipoHibernate);
    }

    @WebMethod
    public ConfiguraHibernateDTO pesquisaConfiguracaoHibernate(int tipoHibernate) {
        return MsFacade.getInstancia().pesquisaConfiguracaoHibernate(tipoHibernate);
    }

    @WebMethod
    public boolean salvarConfiguracaoLog4j(Log4jDTO logDTO) {
        return MsFacade.getInstancia().salvarConfiguracaoLog4j(logDTO);
    }

    @WebMethod
    public Log4jDTO carregarPropriedadesLog4jDTO() {
        return MsFacade.getInstancia().getPropriedadesLog4j();
    }

    @WebMethod
    public boolean configuraWebXml(WebXMLDTO webDTO) {
        return MsFacade.getInstancia().configuraWebXml(webDTO);
    }

    @WebMethod
    public WebXMLDTO pesquisarWebXml() {
        return MsFacade.getInstancia().getPropriedadesWebXml();
    }

    @WebMethod
    public String pesquisarLog(BigDecimal idEvento, BigDecimal tpEvento) {
        return MsFacade.getInstancia().pesquisarLog(idEvento, tpEvento);
    }

    public boolean isUsuarioOperadorAutenticado(String idup, String login, String senha) {
        return MsFacade.getInstancia().isUsuarioOperadorAutenticado(idup, login, senha);
    }

    @WebMethod
    public ListaBcDTO pesquisarListaBcs(BcDTO pesquisa) {
        return MsFacade.getInstancia().pesquisarListaBcs(pesquisa);
    }

    @WebMethod
    public ListaMSDTO importacaoManual(Long idMs, String login) {
        return MsFacade.getInstancia().importacaoManual(idMs, login);
    }

    @WebMethod
    public UsuariosDTO getOperadoresAtivos() {
        return IdwFacade.getInstancia().getOperadoresAtivos();
    }

    @WebMethod
    public void carregaTabelasBasicas() {
        IdwFacade.getInstancia().carregaTabelasBasicas();
    }

    @WebMethod
    public ListaIcDTO getListaMsIC() {
        return MsFacade.getInstancia().getListaMsIC();
    }

    @WebMethod
    public IcDTO salvarIcSimplificado(IcDTO icDTO, IcDTO icDTOParaRemocao) {
        return MsFacade.getInstancia().salvarIcSimplificado(icDTO, icDTOParaRemocao);
    }

    @WebMethod
    public boolean validaSeUpEstaSendoUsada(String cdUp, BigDecimal idic) {
        return MsFacade.getInstancia().validaSeUpEstaSendoUsada(cdUp, idic);
    }

    @WebMethod
    public ListaIcDTO salvarIcDTO(IcDTO icDTO) {
        return MsFacade.getInstancia().salvarIcDTO(icDTO);
    }

    @WebMethod
    public ListaBcDTO getListBcDTO() {
        return MsFacade.getInstancia().getListBcDTO();
    }

    @WebMethod
    public ListaUPDTO getListaMsUP() {
        return MsFacade.getInstancia().getListaMsUP();
    }

    @WebMethod
    public TempoRealDTO getUltimoTempoRealPt(FiltroProducaoDTO filtro) {
        return IdwFacade.getInstancia().getUltimoTempoRealPt(filtro);
    }

    @WebMethod
    public DwEstlocalsDTO getDwEstlocal(DwEstlocalDTO filtro) {
        return IdwFacade.getInstancia().getDwEstlocal(filtro);
    }

    @WebMethod
    public DwEstlocalDTO setDwEstlocal(DwEstlocalDTO filtro) {
        return IdwFacade.getInstancia().setDwEstlocal(filtro);
    }

    @WebMethod
    public DwEstlocalDTO removeDwEstlocal(DwEstlocalDTO filtro) {
        return IdwFacade.getInstancia().removeDwEstlocal(filtro);
    }

    @WebMethod
    public DwconsolestlocalprosDTO getConsultaLocalEstoque(FiltroConsolLocalEstoqueDTO filtro) {
        return IdwFacade.getInstancia().getConsultaLocalEstoque(filtro);
    }

    @WebMethod
    public DwEstlocalprosDTO getDwEstlocalpros(FiltroConsolLocalEstoqueDTO filtro) {
        return IdwFacade.getInstancia().getDwEstlocalpros(filtro);
    }

    @WebMethod
    public TurnosDTO getTodosOsTurnos() {
        return IdwFacade.getInstancia().getTodosOsTurnos();
    }

    @WebMethod
    public ProdutosDTO getTodosProdutosDTO() {
        return IdwFacade.getInstancia().getTodosProdutosDTO();
    }

    @WebMethod
    public PTsDTO getTodosPtsEmOmPapro() {
        return IdwFacade.getInstancia().getTodosPtsEmOmPapro();
    }

    @WebMethod
	public PTsDTO getTodosPtsComAlimentacao(){
        return IdwFacade.getInstancia().getTodosPtsComAlimentacao();
    }

    @WebMethod
    public MonitorizacoesAlimsDTO getMonitorizacaoAlimComFiltro(String filtro, boolean flag, boolean isFiltrarGt) {
        return IdwFacade.getInstancia().getMonitorizacaoAlimComFiltro(filtro, flag, isFiltrarGt);
    }

    @WebMethod
    public DwRapListDTO getDwRapAtivos() {
        return IdwFacade.getInstancia().getDwRapAtivos();
    }

    @WebMethod
    public DwRapListDTO getRapsDoGrupoRap(DwGrupoFerramenta grupo) {
        return IdwFacade.getInstancia().getRapsDoGrupoRap(grupo);
    }

    @WebMethod
    public CiclosDTO getUltimosCiclos(FiltroCiclosDTO filtroCiclosDTO) {
        return IdwFacade.getInstancia().getUltimosCiclos(filtroCiclosDTO);
    }

    @WebMethod
    public CiclosDTO getUltimosCiclosAndroid(@WebParam(name = "idpt") Long idPt, @WebParam(name = "idCp") Long idCp) {
        return IdwFacade.getInstancia().getUltimosCiclosAndroid(idPt, idCp);
    }

    @WebMethod
    public GraficoDetalhePtDTO getGraficoDetalhePtDTO(FiltroGraficoDetalhePtDTO filtro) {
        return IdwFacade.getInstancia().getGraficoDetalhePtDTO(filtro);
    }

    @WebMethod
    public GraficoDetalhePtFornoDTO getGraficoDetalhePtFornoDTO(FiltroGraficoDetalhePtDTO filtro) {
        return IdwFacade.getInstancia().getGraficoDetalhePtFornoDTO(filtro);
    }

    // @WebMethod
    // public FiltroRelCartaControle
    // getFiltroRelCartaControle(FiltroRelCartaControle filtro) {
    // return IdwFacade.getInstancia().getFiltroRelCartaControle(filtro);
    // }
    //
    // @WebMethod
    // public GraficoCartaControleDTO
    // getRelatorioCartaControle(FiltroRelCartaControle
    // filtroPrincipal,FiltroRelCartaControle filtroSecundario) {
    // return
    // IdwFacade.getInstancia().getRelatorioCartaControle(filtroPrincipal,
    // filtroSecundario);
    // }

    @WebMethod
    public RelatorioProdutoClasseDTO getRelatorioProdutoClasse(FiltroRelatorioAlertaDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioProdutoClasse(filtro);
    }

    @WebMethod
    public RelatorioProcedimentoDTO getRelatorioProcedimento(FiltroRelProcedimentoDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioProcedimento(filtro);
    }

    @WebMethod
    public RelatorioCargaMaquinaDTO getRelatorioCargaMaquina(FiltroRelatorioCargaMaquinaDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioCargaMaquina(filtro);
    }

    @WebMethod
    public GraficoDetalhePtFornoDTO getGraficoDetalhePtFornoDTOAndroid(@WebParam(name = "idpt") Long idpt,
            @WebParam(name = "idturno") Long idturno, @WebParam(name = "dtreferencia") String dtreferencia,
            @WebParam(name = "idCp") Long idCp) {
        return IdwFacade.getInstancia().getGraficoDetalhePtFornoDTOAndroid(idpt, idturno, dtreferencia, idCp);
    }

    @WebMethod
    public ListaPerdasmpDTO getGraficoPerdasMateriaPrimaDTO(FiltroGraficoDetalhePtDTO filtro) {
        return IdwFacade.getInstancia().getGraficoPerdasMateriaPrima(filtro);
    }

    @WebMethod
    public ListaPerdasmpDTO getGraficoPerdaFerrmantaPorProduto(FiltroGraficoDetalhePtDTO filtro) {
        return IdwFacade.getInstancia().getGraficoPerdaFerrmantaPorProduto(filtro);
    }

    public ListaPerdasmpDTO getGraficoPerdaMpPorRap(FiltroGraficoDetalhePtDTO filtro) {
        return IdwFacade.getInstancia().getGraficoPerdaMpPorRap(filtro);
    }

    public DwTPerdasmpDTO getDwTPerdasmp() {
        return IdwFacade.getInstancia().getDwTPerdasmp();
    }

    @WebMethod
    public TurnoAtualDTO getTurnoAtual(OmPt omPt, Date dtHrRef) {
        return IdwFacade.getInstancia().getTurnoAtualDTO(omPt, dtHrRef);
    }

    @WebMethod
    public TurnoAtualDTO getPeriodoTurno(FiltroTurnoDTO filtro) {
        return IdwFacade.getInstancia().getPeriodoTurno(filtro);
    }

    @WebMethod
    public TurnoAtualDTO getTurnoAtualGt(OmGt omGt, Date dataAtual) {
        return IdwFacade.getInstancia().getTurnoAtualGtDTO(omGt, dataAtual);
    }

    @WebMethod
    public TurnoAtualDTO getTurnoAtual1PTDTO(Date dataAtual) {
        return IdwFacade.getInstancia().getTurnoAtual1PTDTO(dataAtual);
    }

    @WebMethod
    public TurnoAtualDTO getTurnoAtualDTO(OmPt omPt, Date dtHrRef) {
        return IdwFacade.getInstancia().getTurnoAtualDTO(omPt, dtHrRef);
    }

    @WebMethod
    public GraficoDetalhePtDTO getGraficoDetalhePtandroidUltimosCiclosDTO(@WebParam(name = "idpt") Long idpt,
            @WebParam(name = "idturno") Long idturno, @WebParam(name = "dtreferencia") String dtreferencia) {
        return IdwFacade.getInstancia().getGraficoDetalhePtandroidUltimosCiclosDTO(idpt, idturno, dtreferencia);
    }

    @WebMethod
    public GraficoDetalhePtDTO getGraficoDetalhePtandroidUltimosCiclosBIDTO(@WebParam(name = "idgt") Long idgt,
            @WebParam(name = "idturno") Long idturno, @WebParam(name = "dtreferencia") String dtreferencia) {
        return IdwFacade.getInstancia().getGraficoDetalhePtandroidUltimosCiclosBIDTO(idgt, idturno, dtreferencia);
    }

    @WebMethod
    public DwFolhasDTO getGraficoDetalhePadraoDTO(FiltroGraficoDetalhePtDTO filtro) {
        return IdwFacade.getInstancia().getGraficoDetalhePadraoDTO(filtro);
    }

    @WebMethod
    public CpsDTO setAdiantamentoDTO(AdiantamentoDTO produtos, PlanoDTO plano) {
        CpsDTO retorno = new CpsDTO();
        retorno = IdwFacade.getInstancia().setAdiantamentoDTO(produtos, plano);
        return retorno;
    }

    @WebMethod
    public DetalhamentoProducaoDTO getDetalhamentoProducao(FiltroDetalheProducaoDTO filtro) {
        return IdwFacade.getInstancia().getDetalhamentoProducao(filtro);
    }

    @WebMethod
    public ListaDetalheAnaliseTurnoDTO getDetalheAnaliseTurno(FiltroProducaoDTO filtro) {
        return IdwFacade.getInstancia().getDetalheAnaliseTurnoDTO(filtro);
    }

    @WebMethod
    public DetalheAnaliseGargaloDTO getDetalheCelulas(FiltroProducaoDTO filtro) {
        return IdwFacade.getInstancia().getDetalheCelulas(filtro);
    }

    @WebMethod
    public ParadasDTO getParadasDTO(FiltroRelatorioParadaDTO filtro) {
        return IdwFacade.getInstancia().getParadasDTO(filtro);
    }

    @WebMethod
    public RelatorioDivergenciaDTO getRelatorioDivergencia(FiltroRelDivergenciaDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioDivergencia(filtro);
    }

    @WebMethod
    public OmTpptDTO getOmTpptDTO() {
        return IdwFacade.getInstancia().getOmTpptDTO();
    }

    @WebMethod
    public DwTRefugosDTO getRefugosDTO(FiltroRelatorioRefugoDTO filtro) {
        return IdwFacade.getInstancia().getRefugosDTO(filtro);
    }

    @WebMethod
    public UsuariosDTO getOMUsuariosDTO(FiltroRelatorioUsuarioDTO filtro) {
        return IdwFacade.getInstancia().getOMUsuariosDTO(filtro);
    }

    @WebMethod
    public AlertasDTO getAlertasDTO(FiltroRelatorioAlertaDTO filtro) {
        return IdwFacade.getInstancia().getAlertasDTO(filtro);
    }

    @WebMethod
    public AlertasDTO getTAlertasDTO(AlertaDTO filtro) {
        return IdwFacade.getInstancia().getTAlertasDTO(filtro);
    }

    @WebMethod
    public AlertaDTO setTAlertaDTO(AlertaDTO filtro) {
        return IdwFacade.getInstancia().setTAlertaDTO(filtro);
    }

    @WebMethod
    public AlertasDTO removeTAlertasDTO(AlertasDTO filtro) {
        return IdwFacade.getInstancia().removeTAlertasDTO(filtro);
    }

    @WebMethod
    public DwTJustsDTO getTJustificativa(DwTJustDTO filtro) {
        return IdwFacade.getInstancia().getTJustificativa(filtro);
    }

    @WebMethod
    public DwTJustDTO setTJustificativa(DwTJustDTO filtro) {
        return IdwFacade.getInstancia().setTJustificativa(filtro);
    }

    @WebMethod
    public DwTJustsDTO removeTJustificativa(DwTJustsDTO filtro) {
        return IdwFacade.getInstancia().removeTJustificativa(filtro);
    }

    @WebMethod
    public DwTCausasDTO getTCausa(DwTCausaDTO filtro) {
        return IdwFacade.getInstancia().getTCausa(filtro);
    }

    @WebMethod
    public DwTCausaDTO setTCausa(DwTCausaDTO filtro) {
        return IdwFacade.getInstancia().setTCausa(filtro);
    }

    @WebMethod
    public DwTCausasDTO removeTCausa(DwTCausasDTO filtro) {
        return IdwFacade.getInstancia().removeTCausa(filtro);
    }
    
    @WebMethod
    public DwTOrigensDTO getTOrigem(DwTOrigemDTO filtro) {
        return IdwFacade.getInstancia().getTOrigem(filtro);
    }

    @WebMethod
    public DwTOrigemDTO setTOrigem(DwTOrigemDTO filtro) {
        return IdwFacade.getInstancia().setTOrigem(filtro);
    }

    @WebMethod
    public DwTOrigensDTO removeTOrigem(DwTOrigensDTO filtro) {
        return IdwFacade.getInstancia().removeTOrigem(filtro);
    }

    @WebMethod
    public DwTRefugosDTO getTRefugo(DwTRefugoDTO filtro) {
        return IdwFacade.getInstancia().getTRefugo(filtro);
    }

    @WebMethod
    public DwTRefugoDTO setTRefugo(DwTRefugoDTO filtro) {
        return IdwFacade.getInstancia().setTRefugo(filtro);
    }

    @WebMethod
    public DwTRefugosDTO removeTRefugo(DwTRefugosDTO filtro) {
        return IdwFacade.getInstancia().removeTRefugo(filtro);
    }

    @WebMethod
    public DwTAreasDTO getTArea(DwTAreaDTO filtro) {
        return IdwFacade.getInstancia().getTArea(filtro);
    }

    @WebMethod
    public DwTAreaDTO setTArea(DwTAreaDTO filtro) {
        return IdwFacade.getInstancia().setTArea(filtro);
    }

    @WebMethod
    public DwTAreasDTO removeTArea(DwTAreasDTO filtro) {
        return IdwFacade.getInstancia().removeTArea(filtro);
    }

    @WebMethod
    public DwProcedimentosDTO getDwProcedimento(DwProcedimentoDTO filtro) {
        return IdwFacade.getInstancia().getDwProcedimento(filtro);
    }

    @WebMethod
    public DwNseriesDTO getDwNserie(FiltroRastreamentoNSDTO filtro) {
        return IdwFacade.getInstancia().getDwNserie(filtro);
    }

    @WebMethod
    public RastreamentoNSDTO getRastreamentoNS(FiltroRastreamentoNSDTO filtro) {
        return IdwFacade.getInstancia().getRastreamentoNS(filtro);
    }

    @WebMethod
    public RastreamentoNaoLidosDTO getRastreamentoNSNaoLido(String nsInicial, String nsFinal) {
        return IdwFacade.getInstancia().getRastreamentoNSNaoLido(nsInicial, nsFinal);
    }

    @WebMethod
    public DashboardsDTO getDashboardTV(FiltroDashboardDTO filtro) {
        return IdwFacade.getInstancia().getDashboardTV(filtro);
    }

    @WebMethod
    public DwProcedimentoDTO setDwProcedimento(DwProcedimentoDTO filtro) {
        return IdwFacade.getInstancia().setDwProcedimento(filtro);
    }

    @WebMethod
    public DwProcedimentosDTO removeDwProcedimento(DwProcedimentosDTO filtro) {
        return IdwFacade.getInstancia().removeDwProcedimento(filtro);
    }

    @WebMethod
    public DwGrpativDTOs getTodosDwGrpativAtivos() {
        return IdwFacade.getInstancia().getTodosDwGrpativAtivos();
    }

    @WebMethod
    public DwGrpativDTOs getDwGrpativ(DwGrpativDTO filtro) {
        return IdwFacade.getInstancia().getDwGrpativ(filtro);
    }

    @WebMethod
    public DwGrpativDTO setDwGrpativ(DwGrpativDTO filtro) {
        return IdwFacade.getInstancia().setDwGrpativ(filtro);
    }

    @WebMethod
    public DwGrpativDTOs removeDwGrpativ(DwGrpativDTOs filtro) {
        return IdwFacade.getInstancia().removeDwGrpativ(filtro);
    }

    @WebMethod
    public OmCargosDTO getTodosOmCargosAtivos() {
        return IdwFacade.getInstancia().getTodosOmCargosAtivos();
    }

    @WebMethod
    public DwFolhasDTO getTodasDwFolhasAtivas() {
        return IdwFacade.getInstancia().getTodasDwFolhasAtivas();
    }

    @WebMethod
    public DwFolhasDTO getDwFolhaDoProcedimento(DwProcedimento dwProcedimento) {
        return IdwFacade.getInstancia().getDwFolhaDoProcedimento(dwProcedimento);
    }

    @WebMethod
    public OmCargosDTO getOmCargo(OmCargoDTO filtro) {
        return IdwFacade.getInstancia().getOmCargo(filtro);
    }

    @WebMethod
    public OmCargoDTO setOmCargo(OmCargoDTO filtro) {
        return IdwFacade.getInstancia().setOmCargo(filtro);
    }

    @WebMethod
    public OmCargosDTO removeOmCargo(OmCargosDTO filtro) {
        return IdwFacade.getInstancia().removeOmCargo(filtro);
    }

    @WebMethod
    public TeConcessionariasDTO getTeConcessionaria(TeConcessionariaDTO filtro) {
        return IdwFacade.getInstancia().getTeConcessionaria(filtro);
    }

    @WebMethod
    public TeConcessionariaDTO setTeConcessionaria(TeConcessionariaDTO filtro) {
        return IdwFacade.getInstancia().setTeConcessionaria(filtro);
    }

    @WebMethod
    public TeConcessionariasDTO removeTeConcessionaria(TeConcessionariasDTO filtro) {
        return IdwFacade.getInstancia().removeTeConcessionaria(filtro);
    }

    @WebMethod
    public TeTarifasemanaisDTO setTearifasemanaisDTO(TeTarifasemanaisDTO listDTO) {
        return IdwFacade.getInstancia().setTearifasemanaisDTO(listDTO);
    }

    @WebMethod
    public TeTarifasemanaisDTO getTeTarifasemanais(TeTarifasemanal filtro) {
        return IdwFacade.getInstancia().getTeTarifasemanais(filtro);
    }

    @WebMethod
    public TeTarifaDTO setTeTarifaDTO(TeTarifaDTO tarifa) {
        return IdwFacade.getInstancia().setTeTarifaDTO(tarifa);
    }

    @WebMethod
    public TeTarifaDTO excluirTeTarifa(TeTarifaDTO tarifa) {
        return IdwFacade.getInstancia().excluirTeTarifa(tarifa);
    }

    @WebMethod
    public TeTarifasDTO getTeTarifaDTO(TeTarifaDTO filtro) {
        return IdwFacade.getInstancia().getTeTarifaDTO(filtro);
    }

    @WebMethod
    public TeLeisVigentesDTO getTeLeisVigentesDTO(TeLeiVigenteDTO itemDTO) {
        return IdwFacade.getInstancia().getTeLeisVigentesDTO(itemDTO);
    }

    @WebMethod
    public TeLeiVigenteDTO setTeLeiVigenteDTO(TeLeiVigenteDTO itemDTO) {
        return IdwFacade.getInstancia().setTeLeiVigenteDTO(itemDTO);
    }

    @WebMethod
    public TeTipoConsumidoresDTO getTeTipoConsumidor(TeTipoConsumidorDTO filtro) {
        return IdwFacade.getInstancia().getTeTipoConsumidor(filtro);
    }

    @WebMethod
    public TeTipoConsumidorDTO setTeTipoConsumidor(TeTipoConsumidorDTO filtro) {
        return IdwFacade.getInstancia().setTeTipoConsumidor(filtro);
    }

    @WebMethod
    public TeTipoConsumidoresDTO removeTeTipoConsumidor(TeTipoConsumidoresDTO filtro) {
        return IdwFacade.getInstancia().removeTeTipoConsumidor(filtro);
    }

    @WebMethod
    public DwTAreasDTO getListaAreasAtivas() {
        return IdwFacade.getInstancia().getListaAreasAtivas();
    }

    @WebMethod
    public ParadasDTO getTParada(DWParadaDTO filtro) {
        return IdwFacade.getInstancia().getTParada(filtro);
    }

    @WebMethod
    public DWParadaDTO setTParada(DWParadaDTO filtro) {
        return IdwFacade.getInstancia().setTParada(filtro);
    }

    @WebMethod
    public ParadasDTO removeTParada(ParadasDTO filtro) {
        return IdwFacade.getInstancia().removeTParada(filtro);
    }

    @WebMethod
    public GTsDTO getGTsDtoAtivos() {
        return IdwFacade.getInstancia().getGTsDtoAtivos();
    }

    @WebMethod
    public GtRtMonitorizacaoDTO getGtRtMonitorizacaoTmAndroidDTO(@WebParam(name = "idturno") long idturno,
            @WebParam(name = "idgt") long idgt, @WebParam(name = "dtreferencia") String dtreferencia) {
        return IdwFacade.getInstancia().getGtRtMonitorizacaoTmAndroidDTO(idturno, idgt, dtreferencia);
    }

    @WebMethod
    public DadosRelEficienciaSetupDTO getRelatorioEficienciaSetup(FiltroRelatorioIndiceParadasDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioEficienciaSetup(filtro);
    }

    @WebMethod
    public ListaRelatorioParadasInicioProcessoDTO getRelatorioParadasInicioProcessoDTO(FiltroRelatorioIndiceParadasDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioParadasInicioProcessoDTO(filtro);
    }

    @WebMethod
    public ListaRelatorioIndiceParadaDTO getRelatorioIndiceParadas(FiltroRelatorioIndiceParadasDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioIndiceParadas(filtro);
    }

    @WebMethod
    public RelatorioIndiceParadaPtDTO getDadosRelatorioParadasPorMaquina(FiltroRelatorioIndiceParadasDTO filtro) {
        return IdwFacade.getInstancia().getDadosRelatorioParadasPorMaquina(filtro);
    }

    @WebMethod
    public ItemRelatorioFichaTecnica getRelatorioFichaTecnica(ProdutoDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioFichaTecnica(filtro);
    }

    @WebMethod
    public RelatorioPlanejamentoRealizadoDTO getDadosRelatorioPlanejamentoRealizado(FiltroRelatorioPlanejamentoRealizadoDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioPlanejamentoRealizado(filtro);
    }

    @WebMethod
    public RelatorioPeriodoSemOpDTO getRelatorioPeriodoSemOp(FiltroRelatorioPeriodoSemOpDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioPeriodoSemOp(filtro);
    }

    @WebMethod
    public RelatorioCavInativasDTO getRelatorioCavidadeInativas(FiltroRelCavInativaDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioCavidadeInativas(filtro);
    }

    @WebMethod
    public RelatorioAnaliseCicloDTO getRelatorioAnaliseCiclo(FiltroRelDivergenciaDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioAnaliseCiclo(filtro);
    }

    @WebMethod
    public RelatorioMaquinasCriticasDTO getRelatorioMaquinasCriticas(FiltroRelMaqCriticaDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioMaquinasCriticas(filtro);
    }

    // @WebMethod
    // public PTsDTO buscaPtsPorPeriodoCnc(DwConsolid filtro){
    // return IdwFacade.getInstancia().buscaPtsPorPeriodoCnc(filtro);
    // }
    //
    // @WebMethod
    // public ProdutosDTO buscaProdutoPorPeriodoCnc(DwConsolid filtro){
    // return IdwFacade.getInstancia().buscaProdutoPorPeriodoCnc(filtro);
    // }
    //
    // @WebMethod
    // public CpsDTO buscaOpsPorPeriodoCnc(DwConsolid filtro){
    // return IdwFacade.getInstancia().buscaOpsPorPeriodoCnc(filtro);
    // }
    //
    // @WebMethod
    // public void buscaItensCNC(DwConsolid filtro){
    // IdwFacade.getInstancia().buscaItensCNC(filtro);
    // }
    //
    @WebMethod
    public ParadasDTO getListaParadasAtivas(OmTppt tppt) {
        return IdwFacade.getInstancia().getListaParadasAtivas(tppt);
    }

    @WebMethod
    public ProdutoDTO integracaoEstProduto(ProdutoDTO produto) {
        return IdwFacade.getInstancia().integracaoEstProduto(produto);
    }

    @WebMethod
    public void integrarEstoqueFuturo(PeriodoDTO periodoDTO, UsuarioDTO usuarioDTO) {
        IdwFacade.getInstancia().integrarEstoqueFuturo(periodoDTO, usuarioDTO);
    }

    @WebMethod
    public ProdutosDTO integracaoEstoque(Date dtReferencia, UsuarioDTO usrlogado) {
        return IdwFacade.getInstancia().integracaoEstoque(dtReferencia, usrlogado);
    }

    @WebMethod
    public void integracaoApontamentoDiario(UsuarioDTO usrlogado) {
        IdwFacade.getInstancia().integracaoApontamentoDiario(usrlogado);
    }

    @WebMethod
    public PpNecListDTO integracaoPlanoProducaoPeriodo(Date dtInicio, Date dtFim, UsuarioDTO usrlogado, boolean integrarProdutos) {
        return IdwFacade.getInstancia().integracaoPlanoProducaoPeriodo(dtInicio, dtFim, usrlogado, integrarProdutos);
    }

    @WebMethod
    public RoteiroDTO sugestaoRoteiro(String cdProduto) {
        return IdwFacade.getInstancia().sugestaoRoteiro(cdProduto);
    }

    @WebMethod
    public DadosRelatorioDTO relatorioPlanejadoRealizado(Date dtInicio, Date dtFim) {
        return IdwFacade.getInstancia().relatorioPlanejadoRealizado(dtInicio, dtFim);
    }

    @WebMethod
    public DadosRelatorioDTO relatorioTurnoHora(Date dtRf) {
        return IdwFacade.getInstancia().relatorioTurnoHora(dtRf);
    }

    @WebMethod
    public DwDesalimpendcontagsDTO getDesalimentacoes(FiltroDesalimentacaoContagem filtro) {
        return IdwFacade.getInstancia().getDesalimentacoes(filtro);
    }

    @WebMethod
    public ResultadoMovimentacaoLocalEstoqueDTO ajustarDesalimentacao(DwDesalimpendcontag desalimentacao, int novaQuantidade,
            int diferenca, String justificativa, String cdPa, OmUsr usuario, Date dthrDesalimentacao) {
        return IdwFacade.getInstancia().ajustarDesalimentacao(desalimentacao, novaQuantidade, diferenca, justificativa, cdPa, usuario,
                dthrDesalimentacao);
    }

    @WebMethod
    public DadosRelatorioDTO relatorioMapaEscadinha(DadosRelatorioDTO dados) {
        return IdwFacade.getInstancia().relatorioMapaEscadinha(dados);
    }

    @WebMethod
    public Object soma(@WebParam(name = "n1") int n1, @WebParam(name = "n2") int n2) {
        return n1 + n2;
    }

    @WebMethod
    public DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPTAndroid(@WebParam(name = "dtreferencia") String dtreferencia,
            @WebParam(name = "iddwconsolid") Long iddwconsolid, @WebParam(name = "dtreferenciainicial") String dtreferenciainicial,
            @WebParam(name = "dtreferenciafinal") String dtreferenciafinal, @WebParam(name = "idturno") Long idturno,
            @WebParam(name = "iddwrap") Long iddwrap, @WebParam(name = "idpt") Long idpt, @WebParam(name = "idgt") Long idgt,
            @WebParam(name = "idproduto") Long idproduto, @WebParam(name = "cdCp") String cdCp) {
        return IdwFacade.getInstancia().getDetalheMonitorizacaoPTAndroid(dtreferencia, iddwconsolid, dtreferenciainicial,
                dtreferenciafinal, idturno, iddwrap, idpt, idgt, idproduto, cdCp);
    }

    @WebMethod
    public GraficoDetalhePtDTO getGraficoDetalhePTandroidDTO(@WebParam(name = "idpt") Long idpt, @WebParam(name = "idturno") Long idturno,
            @WebParam(name = "idfolha") Long idfolha, @WebParam(name = "dtReferencia") String dtReferencia,
            @WebParam(name = "dtReferenciainicial") String dtReferenciainicial,
            @WebParam(name = "dtReferenciafinal") String dtReferenciafinal, @WebParam(name = "idCp") Long idCp,
            @WebParam(name = "tpId") String tpId, @WebParam(name = "limiteMaxresult") int limiteMaxResult) {
        return IdwFacade.getInstancia().getGraficoDetalhePTandroidDTO(idpt, idturno, idfolha, dtReferencia, dtReferenciainicial,
                dtReferenciafinal, idCp, tpId, limiteMaxResult);
    }

    @WebMethod
    public GraficoDetalhePtDTO getGraficoDetalhePTandroidDTOPorHora(@WebParam(name = "idpt") Long idpt,
            @WebParam(name = "dtReferenciainicial") String dtReferenciainicial,
            @WebParam(name = "dtReferenciafinal") String dtReferenciafinal) {
        return IdwFacade.getInstancia().getGraficoDetalhePtAndroidDTOPorHora(idpt, dtReferenciainicial, dtReferenciafinal);
    }

    @WebMethod
    public GraficoDetalhePtDTO getGraficoDetalhePTandroidBIDTO(@WebParam(name = "idgt") Long idgt,
            @WebParam(name = "idturno") Long idturno, @WebParam(name = "idfolha") Long idfolha,
            @WebParam(name = "dtReferencia") String dtReferencia, @WebParam(name = "dtReferenciainicial") String dtReferenciainicial,
            @WebParam(name = "dtReferenciafinal") String dtReferenciafinal) {
        return IdwFacade.getInstancia().getGraficoDetalhePTandroidBIDTO(idgt, idturno, idfolha, dtReferencia, dtReferenciainicial,
                dtReferenciafinal);
    }

    @WebMethod
    public DetalhamentoProducaoDTO getDetalhamentoProducaoDTOAndroid(@WebParam(name = "iddwconsolid") Long iddwconsolid,
            @WebParam(name = "dtreferenciainicial") String dtreferenciainicial,
            @WebParam(name = "dtreferenciafinal") String dtreferenciafinal, @WebParam(name = "idpt") Long idpt) {
        return IdwFacade.getInstancia().getDetalhamentoProducaoDTOAndroid(iddwconsolid, dtreferenciainicial, dtreferenciafinal, idpt);
    }

    @WebMethod
    public DwFolhasDTO getGraficoDetalhePadraoandroidDTO(@WebParam(name = "idpt") Long idpt, @WebParam(name = "idfolha") Long idfolha,
            @WebParam(name = "dtreferencia") String dtreferencia) {
        return IdwFacade.getInstancia().getGraficoDetalhePadraoandroidDTO(idpt, idfolha, dtreferencia);
    }

    @WebMethod
    public ArquivosTrilhaDTO getArquivoTrilha(FiltroExportacaoTrilhaDTO filtro) {
        return IdwFacade.getInstancia().getArquivoTrilha(filtro);
    }

    @WebMethod
    public FirmwaresDTO getFirmwares() {
        return MsFacade.getInstancia().getFirmwares();
    }

    @WebMethod
    public DwFolhasDTO getGraficoDetalhePadraoandroidBIDTO(@WebParam(name = "idgt") Long idgt, @WebParam(name = "idfolha") Long idfolha,
            @WebParam(name = "dtreferencia") String dtreferencia) {
        return IdwFacade.getInstancia().getGraficoDetalhePadraoandroidBIDTO(idgt, idfolha, dtreferencia);
    }

    @WebMethod
    public void setEventoInsert(EventoDTO eventoDTO) {
        try {
            IdwFacade.getInstancia().setEventosInsert(eventoDTO);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @WebMethod
    public CpDTO pesquisarMpFaltante(Long idCp) {
        return IdwFacade.getInstancia().pesquisarMpFaltante(idCp);
    }

    @WebMethod
    public void integracaoCM() {
        IdwFacade.getInstancia().integracaoCM();
    }

    @WebMethod
    public MsicupsDTO getListaMsicup() {
        return MsFacade.getInstancia().getListaMsicup();
    }

    @WebMethod
    public MsMs pesquisarMsMsPorURLConexaoComParametro(String UrlConexao) {
        return MsFacade.getInstancia().pesquisarMsMsPorURLConexaoComParametro(UrlConexao);
    }

    @WebMethod
    public void salvarNovaPpCp(PpCp ppcp) {
        IdwFacade.getInstancia().salvarNovaPpCp(ppcp);
    }

    @WebMethod
    public ListaCPDTO getOrdemDeProducao(PpCp filtro) {
        return IdwFacade.getInstancia().getOrdemDeProducao(filtro);
    }

    @WebMethod
    public ListaCPDTO getOPProdutos(String nrOP) {
        return IdwFacade.getInstancia().getOPProdutos(nrOP);
    }

    @WebMethod
    public ListaCPDTO salvarOrdemProducao(ListaCPDTO dto) {
        return IdwFacade.getInstancia().salvarOrdemProducao(dto);
    }

    @WebMethod
    public CpDTO excluirOrdemProducao(ListaCPDTO dto) {
        return IdwFacade.getInstancia().excluirOrdemProducao(dto);
    }

    @WebMethod
    public ListaRelatorioProdutividade getRelatorioProdutividade(DwConsolid filtro) {
        return IdwFacade.getInstancia().getRelatorioProdutividade(filtro);
    }

    public ProdutosSemiAcabadosDTO getProdutosSemiAcabados(OmProduto produto) {
        return IdwFacade.getInstancia().getProdutosSemiAcabados(produto);
    }

    @WebMethod
    public ListaCPDTO getPpCpsDaFolha(DwFolha folha) {
        return IdwFacade.getInstancia().getPpCpsDaFolha(folha);
    }

    @WebMethod
    public ProdutosDTO getListaProdutosFiltrosBIDTO(FiltroDetalhePTInjetDTO filtro) {
        return IdwFacade.getInstancia().getListaProdutosFiltrosBIDTO(filtro);
    }

    @WebMethod
    public GraficoBIParetoDTO getGrafBIParetoPerdas(Byte unidadeQtItem, FiltroDetalhePTInjetDTO filtro,
            DetalheMonitorizacaoPTInjetDTO indicadores) {
        return IdwFacade.getInstancia().getGrafBIParetoPerdas(unidadeQtItem, filtro, indicadores);
    }

    @WebMethod
    public GraficoBIRecorrenciaDTO getGraficoBIRecorrencia(FiltroDetalhePTInjetDTO filtroBI, Byte tipoRecorrencia, String cdItem) {
        return IdwFacade.getInstancia().getGraficoBIRecorrencia(filtroBI, tipoRecorrencia, cdItem);
    }

    @WebMethod
    public Double getCicloPadrao(DwFolha dwfolha, OmPt omPt) {
        return IdwFacade.getInstancia().getCicloPadrao(dwfolha, omPt);
    }

    @WebMethod
    public Double getPcsPorCicloAtivas(DwFolha dwfolha) {
        return IdwFacade.getInstancia().getPcsPorCicloAtivas(dwfolha);
    }

    @WebMethod
    public boolean ping() {
        return true;
    }

    @WebMethod
    public PpClientesDTO getPpClientesDTO(PpClienteDTO item) {
        return IdwFacade.getInstancia().getPpClientesDTO(item);
    }

    @WebMethod
    public PpClienteDTO setPpClienteDTO(PpClienteDTO item) {
        return IdwFacade.getInstancia().setPpClienteDTO(item);
    }

    @WebMethod
    public PpClientesDTO removePpClientesDTO(PpClientesDTO itens) {
        return IdwFacade.getInstancia().removePpClientesDTO(itens);
    }

    @WebMethod
    public ListaIndicadoresDTO getProducaoBrutaPt(FiltroProducaoDTO filtro) {
        return IdwFacade.getInstancia().getProducaoBrutaPt(filtro);
    }

    @WebMethod
    public GtDTO pesquisarOmGtPorIdOuCd(OmGt gt) {
        return IdwFacade.getInstancia().getOmGtPorIdOuCd(gt);
    }

    @WebMethod
    public PtDTO getOmPtOuIdOuCd(OmPt pt) {
        return IdwFacade.getInstancia().getOmPtPorIdOuCd(pt);
    }

    public MonitorizacaoHierarquicaDTO getMonitorizacaoHierarquicaDTO(FiltroProducaoDTO filtro) {
        return IdwFacade.getInstancia().getMonitorizacaoHierarquicaDTO(filtro);
    }

    @WebMethod
    public GraficosParettoParadaDTO getGraficoParettoParadaDTO(Date dtReferencia, BigDecimal idTurno, BigDecimal idPt, Boolean isComPeso,
            Boolean isSemPeso, BigDecimal totalParadas, String cdAreaResp, Boolean isConsiderarOP, String cdCp) {
        return IdwFacade.getInstancia().getGraficoParettoParadaDTO(dtReferencia, idTurno, idPt, isComPeso, isSemPeso, totalParadas,
                cdAreaResp, isConsiderarOP, cdCp);
    }

    @WebMethod
    public GraficosParettoParadaDTO getGraficoParettoParadaFichaMaqDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno,
            String cdPt, String cdCp, Boolean isComPeso, Boolean isSemPeso, BigDecimal totalParadas, String cdAreaResp) {
        return IdwFacade.getInstancia().getGraficoParettoParadaDTO(tpId, dtInicial, dtFinal, idTurno, cdPt, cdCp, isComPeso, isSemPeso,
                totalParadas, cdAreaResp);
    }

    @WebMethod
    public DetalhamentoParadaDTO getOcorrenciaParettoParadaDTO(Date dtReferencia, BigDecimal idTurno, BigDecimal idPt, Boolean isComPeso,
            Boolean isSemPeso, BigDecimal totalParadas, String cdParada) {
        return IdwFacade.getInstancia().getOcorrenciaParettoParadaDTO(dtReferencia, idTurno, idPt, isComPeso, isSemPeso, totalParadas,
                cdParada);
    }

    @WebMethod
    public DetalhamentoParadaDTO getOcorrenciasParadas(FiltroParadasDTO filtro) {
        return IdwFacade.getInstancia().getOcorrenciasParadas(filtro);
    }

    @WebMethod
    public boolean corrigeLogParadas(DetalhamentoParadaDTO paradas) {
        return IdwFacade.getInstancia().corrigeLogParadas(paradas);
    }

    @WebMethod
    public ParadasDTO getDwTParadasDistinctCdDs() {
        return IdwFacade.getInstancia().getDwTParadasDistinctCdDs();
    }

    @WebMethod
    public ParadasDTO getDwTParadasAtivas() {
        return IdwFacade.getInstancia().getDwTParadasAtivas();
    }

    @WebMethod
    public DetalhamentoParadaDTO getOcorrenciaBIParettoParadaDTO(Date dtInicial, Date dtFinal, BigDecimal idTurno, BigDecimal idPt,
            BigDecimal idGt, Boolean isComPeso, Boolean isSemPeso, BigDecimal totalParadas, String cdParada) {
        return IdwFacade.getInstancia().getOcorrenciaParettoBIParadaDTO(dtInicial, dtFinal, idTurno, idPt, idGt, isComPeso, isSemPeso,
                totalParadas, cdParada);
    }

    @WebMethod
    public GraficosParettoParadaDTO getGraficoParettoParadaBIDTO(FiltroDetalhePTInjetDTO filtro, Boolean isComPeso, Boolean isSemPeso,
            BigDecimal totalParadas) {
        return IdwFacade.getInstancia().getGraficoParettoParadaBIDTO(filtro, isComPeso, isSemPeso, totalParadas);
    }

    @WebMethod
    public DwRota getDwRota(String cdRota) {
        return IdwFacade.getInstancia().getDwRota(cdRota);
    }

    @WebMethod
    public OmProduto getOmProduto(String cdProduto) {
        return IdwFacade.getInstancia().pesquisaOmproduto(cdProduto);
    }

    @WebMethod
    public PlanoDTO importarArquivoTrilha(FiltroImportacaoTrilhaDTO filtro) {
        return IdwFacade.getInstancia().importarArquivoTrilha(filtro);
    }

    @WebMethod
    public ListaOmObjDTO obterMonitorizacaoVisaoRoteiro(Date dtReferencia, String cdTurno, String cdProduto) {
        return IdwFacade.getInstancia().obterMonitorizacaoVisaoRoteiro(dtReferencia, cdTurno, cdProduto);
    }

    @WebMethod
    public PTsDTO getPtsDoTtptDaFolha(DwFolha dwFolha) {
        return IdwFacade.getInstancia().getPtsDoTtptDaFolha(dwFolha);
    }

    @WebMethod
    public PTsDTO getGtsDoTtptDaFolha(DwFolha dwFolha) {
        return IdwFacade.getInstancia().getGtsDoTtptDaFolha(dwFolha);
    }

    @WebMethod
    public MaquinasInjetDTO getIndicadoresInjet(FiltroMaquinaInjetDTO filtro) {
        return IdwFacade.getInstancia().getIndicadoresInjet(filtro);
    }

    @WebMethod
    public DwEstlocalprosDTO getDwEstlocalprosMulti(FiltroMonitorizacaoLocalEstoque filtro) {
        return IdwFacade.getInstancia().getDwEstlocalprosMulti(filtro);
    }

    @WebMethod
    public ProdutosResumoFichaMaqDTO getListaProdutosResumoFichaProducaoDTO(ProdutosDTO lista, byte tipoExibicaoQtd, byte periodoConsolidacao) {
        return IdwFacade.getInstancia().getListaProdutosResumoFichaProducaoDTO(lista, tipoExibicaoQtd, periodoConsolidacao);
    }

    @WebMethod
    public ProdutosPerdasFichaMaqDTO getListaProdutosPerdasFichaMaqDTO(DetalheMonitorizacaoPTInjetDTO detMonitoramento, byte tipoExibicaoQtd) {
        return IdwFacade.getInstancia().getListaProdutosPerdasFichaMaqDTO(detMonitoramento, tipoExibicaoQtd);
    }

	@WebMethod
    public GraficosParetoRefugosDTO getGraficoParetoRefugosDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt,
            String cdCp, BigDecimal totalRefugado, String cdProduto) {
        return IdwFacade.getInstancia().getGraficoParetoRefugosDTO(tpId, dtInicial, dtFinal, idTurno, cdPt, cdCp, totalRefugado, cdProduto);
    }

    @WebMethod
    public DetalhamentoRefugoDTO getOcorrenciaParetoRefugosDTO(Date dtReferencia, BigDecimal idTurno, BigDecimal idPt, String cdRefugo) {
        return IdwFacade.getInstancia().getOcorrenciaParetoRefugosDTO(dtReferencia, idTurno, idPt, cdRefugo);
    }

    @WebMethod
    public GraficosParetoRefugosDTO getGraficoParetoRefugosBIDTO(Date dtInicial, Date dtFinal, BigDecimal idTurno, BigDecimal idPt,
            BigDecimal idGt, BigDecimal totalRefugado) {
        return IdwFacade.getInstancia().getGraficoParetoRefugosBIDTO(dtInicial, dtFinal, idTurno, idPt, idGt, totalRefugado);
    }

    @WebMethod
    public DetalhamentoRefugoDTO getOcorrenciaParetoRefugoDTO(Date dtReferencia, BigDecimal idTurno, BigDecimal idPt, String cdRefugo) {
        return IdwFacade.getInstancia().getOcorrenciaParetoRefugosDTO(dtReferencia, idTurno, idPt, cdRefugo);
    }

    @WebMethod
    public DetalhamentoRefugoDTO getOcorrenciaBIParetoRefugoDTO(Date dtInicial, Date dtFinal, BigDecimal idTurno, BigDecimal idPt,
            BigDecimal idGt, BigDecimal totalRefugado, String cdRefugo) {
        return IdwFacade.getInstancia().getOcorrenciaBIParetoRefugoDTO(dtInicial, dtFinal, idTurno, idPt, idGt, totalRefugado, cdRefugo);
    }

    @WebMethod
    public ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO getDetalhamentoGraficoPerdasBICiclosOrdemMaquina(
            DetalheMonitorizacaoPTInjetDTO indicadores, String cdMaquina, String cdProduto, Boolean isConsiderarPerda, Boolean isConsiderarGanho) {
        return IdwFacade.getInstancia().getDetalhamentoGraficoPerdasBICiclosOrdemMaquina(indicadores, cdMaquina, cdProduto, isConsiderarPerda, isConsiderarGanho);
    }

    @WebMethod
    public ListaGraficoBIParetoDetCiclosOrdemProdutoDTO getDetalhamentoGraficoPerdasBICiclosOrdemProduto(
            DetalheMonitorizacaoPTInjetDTO indicadores, Byte ordemQtd, String cdMaquina, String cdProduto, Boolean isConsiderarPerda, Boolean isConsiderarGanho) {
        return IdwFacade.getInstancia().getDetalhamentoGraficoPerdasBICiclosOrdemProduto(indicadores, ordemQtd, cdMaquina, cdProduto, isConsiderarPerda, isConsiderarGanho);
    }

    @WebMethod
    public ListaGraficoBIParetoDetTodasDTO getDetalhamentoGraficoPerdasBITodasOrdemProduto(DetalheMonitorizacaoPTInjetDTO indicadores,
            Byte ordemQtd, String cdMaquina, String cdProduto, Boolean isConsiderarPerda, Boolean isConsiderarGanho) {
        return IdwFacade.getInstancia().getDetalhamentoGraficoPerdasBITodasOrdemProduto(indicadores, ordemQtd, cdMaquina, cdProduto, isConsiderarPerda, isConsiderarGanho);
    }

    @WebMethod
    public ListaGraficoBIParetoDetRefOrdemMaquinaDTO getDetalhamentoGraficoPerdasBIRefOrdemMaquina(
            DetalheMonitorizacaoPTInjetDTO indicadores, String cdRefugo, String cdMaquina, String cdProduto) {
        return IdwFacade.getInstancia().getDetalhamentoGraficoPerdasBIRefOrdemMaquina(indicadores, cdRefugo, cdMaquina, cdProduto);
    }

    @WebMethod
    public ListaGraficoBIParetoDetRefOrdemProdutoDTO getDetalhamentoGraficoPerdasBIRefOrdemProduto(
            DetalheMonitorizacaoPTInjetDTO indicadores, Byte ordemQtd, String cdRefugo, String cdMaquina, String cdProduto) {
        return IdwFacade.getInstancia()
                .getDetalhamentoGraficoPerdasBIRefOrdemProduto(indicadores, ordemQtd, cdRefugo, cdMaquina, cdProduto);
    }

    @WebMethod
    public ListaGraficoBIParetoDetParOrdemMaquinaDTO getDetalhamentoGraficoPerdasBIParOrdemMaquina(
            DetalheMonitorizacaoPTInjetDTO indicadores, String cdParada, String cdMaquina, String cdProduto, Boolean isComPeso,
            Boolean isSemPeso) {
        return IdwFacade.getInstancia().getDetalhamentoGraficoPerdasBIParOrdemMaquina(indicadores, cdParada, cdMaquina, cdProduto,
                isComPeso, isSemPeso);
    }

    @WebMethod
    public ListaGraficoBIParetoDetParOrdemProdutoDTO getDetalhamentoGraficoPerdasBIParOrdemProduto(
            DetalheMonitorizacaoPTInjetDTO indicadores, Byte ordemQtd, String cdParada, String cdMaquina, String cdProduto,
            Boolean isComPeso, Boolean isSemPeso) {
        return IdwFacade.getInstancia().getDetalhamentoGraficoPerdasBIParOrdemProduto(indicadores, ordemQtd, cdParada, cdMaquina,
                cdProduto, isComPeso, isSemPeso);
    }

    @WebMethod
    public ProdutosDTO getListaProdutosRefugados(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt, String cdCp) {
        return IdwFacade.getInstancia().getListaProdutosRefugados(tpId, dtInicial, dtFinal, idTurno, cdPt, cdCp);
    }

    @WebMethod
    public DetalhamentoParadaDTO getOcorrenciaParetoParadaFichaMaqDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno,
            String cdPt, String cdGt, String cdCp, Boolean isComPeso, Boolean isSemPeso, String cdParada, String cdArea, Integer filtroOp) {
        return IdwFacade.getInstancia().getOcorrenciaParetoParadaFichaMaqDTO(tpId, dtInicial, dtFinal, idTurno, cdPt, cdGt, cdCp,
                isComPeso, isSemPeso, cdParada, cdArea, filtroOp);
    }

    @WebMethod
    public DetalhamentoRefugoDTO getOcorrenciaParetoRefugoFichaMaqDTO(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno,
            String cdPt, String cdCp, String cdRefugo, String cdProduto) {
        return IdwFacade.getInstancia().getOcorrenciaParetoRefugoFichaMaqDTO(tpId, dtInicial, dtFinal, idTurno, cdPt, cdCp, cdRefugo,
                cdProduto);
    }

    @WebMethod
    public GraficoAreaRespParadaDTO getGraficoAreaRespParada(Byte tpId, Date dtInicial, Date dtFinal, BigDecimal idTurno, String cdPt,
            String cdCp, Boolean isComPeso, Boolean isSemPeso) {
        return IdwFacade.getInstancia().getGraficoAreaRespParada(tpId, dtInicial, dtFinal, idTurno, cdPt, cdCp, isComPeso, isSemPeso);
    }

    @WebMethod
    public ConjuntoDTO getItensConjuntoProduto(String cdProduto) {
        return IdwFacade.getInstancia().getItensConjuntoProduto(cdProduto);
    }

    @WebMethod
    public ProdutosDTO getListaProdutosPeriodoBI(FiltroDetalhePTInjetDTO filtro) {
        return IdwFacade.getInstancia().getListaProdutosPeriodoBI(filtro);
    }

    @WebMethod
    public GruposFerramentaDTO getGruposFerramenta() {
        return IdwFacade.getInstancia().getGruposFerramenta();
    }

    @WebMethod
    public GruposFerramentaDTO getDwGrupoFerramenta(GrupoFerramentaDTO dto) {
        return IdwFacade.getInstancia().getDwGrupoFerramenta(dto);
    }

    @WebMethod
    public GrupoFerramentaDTO setDwGrupoFerramenta(GrupoFerramentaDTO dto) {
        return IdwFacade.getInstancia().setDwGrupoFerramenta(dto);
    }

    @WebMethod
    public GrupoFerramentaDTO excluirDwGrupoFerramenta(GrupoFerramentaDTO dto) {
        return IdwFacade.getInstancia().excluirDwGrupoFerramenta(dto);
    }

    @WebMethod
    public DwRapListDTO getListaCdDsRap() {
        return IdwFacade.getInstancia().getListaCdDsRap();
    }

    @WebMethod
    public ProdutosDTO getListaConjuntosPeriodoBI(FiltroDetalhePTInjetDTO filtro) {
        return IdwFacade.getInstancia().getListaConjuntosPeriodoBI(filtro);
    }

    @WebMethod
    public PesquisasDTO pesquisaCBNumSerie(PesquisaDTO pesquisa) {
        return IdwFacade.getInstancia().pesquisaCBNumSerie(pesquisa);
    }

    @WebMethod
    public ListaMonitorDTO pesquisarMonitorPorEvento(Long idEvento) {
        return IdwFacade.getInstancia().pesquisarMonitorPorEvento(idEvento);
    }

    @WebMethod
    public ListaCPDTO getPpCpByCdPt(OmPt ompt) {
        return IdwFacade.getInstancia().getPpCpByCdPt(ompt);
    }

    @WebMethod
    public ListaParametrosCEPDTO getListaParametrosCEP(Boolean incluirItemTODOS) {
        return IdwFacade.getInstancia().getListaParametrosCEP(incluirItemTODOS);
    }

    @WebMethod
    public DetalheCEPDTO getDetalheCEPGraf(Byte quebraPeriodo, DwConsolidDTOs listaDwconsolid, ListaParametrosCEPDTO listaParametros) {
        return IdwFacade.getInstancia().getDetalheCEPGraf(quebraPeriodo, listaDwconsolid, listaParametros);
    }

    @WebMethod
    public DetalheCEPDTO getDetalheCEP(DwConsolidDTOs listaDwconsolid, ListaParametrosCEPDTO listaParametros) {
        return IdwFacade.getInstancia().getDetalheCEP(listaDwconsolid, listaParametros);
    }

    @WebMethod
    public DetalheCEPDTO getDetalheParadasCEP(DetalhamentoParadaDTO detParadaDTO, ListaParametrosCEPDTO listaParametros) {
        return IdwFacade.getInstancia().getDetalheParadasCEP(detParadaDTO, listaParametros);
    }

    @WebMethod
    public DetalheCEPDTO getDetalheCiclosCEP(CiclosDTO detCiclosDTO, ListaParametrosCEPDTO listaParametros) {
        return IdwFacade.getInstancia().getDetalheCiclosCEP(detCiclosDTO, listaParametros);
    }

    @WebMethod
    public ListaAcompanhamentoProducaoDTO acompanhamentoProducao(FiltroRelatorioAnaliseEficienciaDTO filtro) {
        return IdwFacade.getInstancia().getAcompanhamentoProducaoRN(filtro);
    }

    @WebMethod
    public ListaRelatorioAnaliticoRefugoDTO relatorioAnaliticoRefugo(FiltroRelatorioIndiceDiarioDTO filtro) {
        return IdwFacade.getInstancia().relatorioAnaliticoRefugo(filtro);
    }

    @WebMethod
    public ListaRelatorioIndicesDiariosDTO getRelatorioIndicesDiarios(FiltroRelatorioIndiceDiarioDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioIndicesDiarios(filtro);
    }

    @WebMethod
    public ListaRelatorioIndiceRefugoDTO getRelatorioIndiceRefugo(FiltroRelatorioIndiceDiarioDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioIndiceRefugo(filtro);
    }

    @WebMethod
    public RelatorioProgramacaoDTO getRelatorioProgramacao(FiltroRelatorioProgramacaoDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioProgramacao(filtro);
    }

    @WebMethod
    public ListaRelatorioRefugoSemConsolidacaoDTO relatorioRefugoSemConsolidacao(FiltroRelatorioIndiceDiarioDTO filtro) {
        return IdwFacade.getInstancia().getListaRelatorioRefugoSemConsolidacaoDTO(filtro);
    }

    @WebMethod
    public GraficoCEPDTO getGraficoCEP(Byte quebraPeriodo, DetalheCEPDTO folhasCEP) {
        return IdwFacade.getInstancia().getGraficoCEP(quebraPeriodo, folhasCEP);
    }

    @WebMethod
    public GraficoCEPDTO getGraficoCEP2(Byte quebraPeriodo, Byte tpReferencia, ListaParametrosCEPDTO parametros,
            FiltroDetalhePTInjetDTO filtro) {
        return IdwFacade.getInstancia().getGraficoCEP2(quebraPeriodo, tpReferencia, parametros, filtro);
    }

    @WebMethod
    public DetalheCEPDTO getDetalheCEPGraf2(Byte quebraPeriodo, Byte tpReferencia, Long idFtParam, FiltroDetalhePTInjetDTO filtro) {
        return IdwFacade.getInstancia().getDetalheCEPGraf2(quebraPeriodo, tpReferencia, idFtParam, filtro);
    }

    @WebMethod
    public IndicadoresEstatisticosCEPDTO getIndicadoresEstatisticosCEP(FolhaCEPDTO folhaCEP, Integer tamanhoAmostra) {
        return IdwFacade.getInstancia().getIndicadoresEstatisticosCEP(folhaCEP, tamanhoAmostra);
    }

    @WebMethod
    public MapaCPDTOs getMapaCPs(FiltroDetalhePTInjetDTO filtro) {
        return IdwFacade.getInstancia().getMapaCPs(filtro);
    }

    @WebMethod
    public ListaRelatorioIndiceParadaAreaRespDTO getConsolpasAreaRespDTO(FiltroRelatorioIndiceParadasDTO filtro) {
        return IdwFacade.getInstancia().getConsolpasAreaRespDTO(filtro);
    }

    @WebMethod
    public ListaRelatorioIndiceParadaMoldeDTO getConsolpasMoldeDTO(FiltroRelatorioIndiceParadasDTO filtro) {
        return IdwFacade.getInstancia().getConsolpasMoldeDTO(filtro);
    }

    @WebMethod
    public ListaRelatorioOcorrenciaParadasDTO getConsolpaocoDTO(FiltroRelatorioIndiceParadasDTO filtro) {
        return IdwFacade.getInstancia().getConsolpaocoDTO(filtro);
    }

    @WebMethod
    public ListaRelatorioParadasAbertasDTO getConsolpaLogDTO(FiltroRelatorioParadasAbertasDTO filtro) {
        return IdwFacade.getInstancia().getConsolpaLogDTO(filtro);
    }

    @WebMethod
    public ListaRelatorioQuantidadeParadasDTO getConsolpaDTO(FiltroRelatorioIndiceParadasDTO filtro) {
        return IdwFacade.getInstancia().getConsolpaDTO(filtro);
    }

    @WebMethod
    public ListaRelatorioCausasParadasDTO getCausasParadas(FiltroRelatorioIndiceParadasDTO filtro) {
        return IdwFacade.getInstancia().getCausasParadas(filtro);
    }

    @WebMethod
    public CicloDTO getCicloTimeoutEPadrao(String cdProduto, String maquina) {
        return IdwFacade.getInstancia().getCicloTimeoutEPadrao(cdProduto, maquina);
    }

    @WebMethod
    public PTsDTO getPtByGt(OmGt omgt) {
        return IdwFacade.getInstancia().getPtByGt(omgt);

    }

    @WebMethod
    public CEPFolhasDTO getCEPFolhas(Byte quebraPeriodo, FiltroDetalhePTInjetDTO filtro, ListaParametrosCEPDTO listaParametros) {
        return IdwFacade.getInstancia().getCEPFolhas(quebraPeriodo, filtro, listaParametros);
    }

    @WebMethod
    public GraficosParetoRefugosDTO getGraficoParetoRefugo2DTO(FiltroDetalhePTInjetDTO filtro, BigDecimal totalRefugado) {
        return IdwFacade.getInstancia().getGraficoParetoRefugo2DTO(filtro, totalRefugado);
    }

    @WebMethod
    public OmCfg pesquisarOmCfgAtual() {
        return IdwFacade.getInstancia().getConfiguracaoAtual();
    }

    @WebMethod
    public Integer excluirOPSimples(String nrDoc) {
        return IdwFacade.getInstancia().excluirOPSimples(nrDoc);
    }

    @WebMethod
    public ClassificacaoABCDTO setClassificacaoABCDTO(ClassificacaoABCDTO itemDTO) {
        return IdwFacade.getInstancia().setClassificacaoABCDTO(itemDTO);
    }

    @WebMethod
    public ClassificacoesABCDTO getListaClassificacaoABCDTO(ClassificacaoABCDTO filtro) {
        return IdwFacade.getInstancia().getListaClassificacaoABCDTO(filtro);
    }

    @WebMethod
    public IndicadorValorDTO getIndicadorPorId(Long id) {
        return IdwFacade.getInstancia().getIndicadorPorId(id);
    }

    @WebMethod
    public PesquisasDTO pesquisaClassificacaoABC(PesquisaDTO filtro) {
        return IdwFacade.getInstancia().pesquisaClassificacaoABC(filtro);
    }

    @WebMethod
    public RelatorioConsolidadoDTO getConsolidadoDTO(FiltroRelatorioConsolidadosDTO filtro) {
        return IdwFacade.getInstancia().getConsolidadoDTO(filtro);
    }
    
    @WebMethod
    public RelatorioRefugoConsolidadoPorMoldeDTO getRefugoConsolidadoPorMoldeDTO(
            FiltroRelatorioRefugoConsolidadoPorMoldeDTO filtro) {
        return IdwFacade.getInstancia().getRefugoConsolidadoPorMoldeDTO(filtro);
    }

    @WebMethod
    public ListaRelatorioCausasDeRefugoDTO getRelatorioCausasDeRefugo(FiltroRelatorioCausasDeRefugoDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioCausasDeRefugo(filtro);
    }

    @WebMethod
    public DwTRitmoDTO setTRitmo(DwTRitmoDTO filtro) {
        return IdwFacade.getInstancia().setTRitmo(filtro);
    }

    @WebMethod
    public DwTRitmosDTO getTRitmo(DwTRitmoDTO filtro) {
        return IdwFacade.getInstancia().getTRitmo(filtro);
    }

    @WebMethod
    public DwTRitmosDTO removeTRitmo(DwTRitmosDTO filtro) {
        return IdwFacade.getInstancia().removeTRitmo(filtro);
    }

    @WebMethod
    public PesquisasDTO pesquisaRitmo(PesquisaDTO filtro) {
        return IdwFacade.getInstancia().pesquisaRitmo(filtro);
    }

    @WebMethod
    public ListaDTOAnaliseProducaoEficienciaHoraAHora getRelatorioEficienciaHoaraAHora(FiltroRelatorioAnaliseEficienciaDTO filtro) {
        return IdwFacade.getInstancia().getRelatorioEficienciaHoaraAHora(filtro);
    }

    @WebMethod
    public OmEmpresaDTO setOmEmpresa(OmEmpresaDTO filtro) {
        return IdwFacade.getInstancia().setOmEmpresa(filtro);
    }

    @WebMethod
    public OmEmpresasDTO removeOmEmpresa(OmEmpresasDTO filtro) {
        return IdwFacade.getInstancia().removeOmEmpresa(filtro);
    }

    @WebMethod
    public OmEmpresasDTO getOmEmpresa(OmEmpresaDTO filtro) {
        return IdwFacade.getInstancia().getOmEmpresa(filtro);
    }

    @WebMethod
    public PesquisasDTO pesquisaEmpresa(PesquisaDTO filtro) {
        return IdwFacade.getInstancia().pesquisaEmpresa(filtro);
    }

    @WebMethod
    public RelatorioProducaoRegulagemDTO getProdRegulagemDTO(FiltroRelatorioProdRegulagemDTO filtro) {
        return IdwFacade.getInstancia().getProdRegulagemDTO(filtro);
    }

    @WebMethod
    public GraficosParettoRitmoDTO getGraficoParettoRitmoDTO(FiltroDetalhePTInjetDTO filtroMaquina) {
        return IdwFacade.getInstancia().getGraficoParettoRitmoDTO(filtroMaquina);
    }

    @WebMethod
    public TodosCiclosDestacandoParadasDTO getTodosCiclosDestacandoParadas(FiltroDetalhePTInjetDTO filtro) {
        return IdwFacade.getInstancia().getTodosCiclosDestacandoParadas(filtro);
    }

    @WebMethod
    public Integer ValidarNumeroDeSerie(String cdpt, String nrop, String ns, String cdproduto, Long idpt, Boolean isAvaliarMontagem) {
        return IdwFacade.getInstancia().getValidarNumeroDeSerie(cdpt, nrop, ns, cdproduto, idpt, isAvaliarMontagem);
    }

    @WebMethod
    public Integer ValidarNumeroDeSerieAgramkow(String cdpt, String nrop, String ns, String cdproduto, Long idpt, Boolean isAvaliarMontagem) {
        return IdwFacade.getInstancia().getValidarNumeroDeSerieAgramkow(cdpt, nrop, ns, cdproduto, idpt, isAvaliarMontagem);
    }
    
    @WebMethod
    public void regristrarPassagem(String cdPt, String cdOp, String cb, Date dthr, String qtde) {
        IdwFacade.getInstancia().regristrarPassagem(cdPt, cdOp, cb, dthr, qtde);
    }

    @WebMethod
    public void regristrarPassagemAgramkow(String cdPt, String cdOp, String cb, Date dthr, String qtde) {
        IdwFacade.getInstancia().regristrarPassagemAgramkow(cdPt, cdOp, cb, dthr, qtde);
    }
    
    @WebMethod
    public void regristrarTesteSimples(String cdPt, String cdOp, String cb, Date dthr, Integer stTeste, String qtde) {
        IdwFacade.getInstancia().regristrarTesteSimples(cdPt, cdOp, cb, dthr, stTeste, qtde);
    }

    @WebMethod
    public void regristrarTesteDefeito(String cdPt, String cdOp, String cb, Date dthr, String cdDefeito, 
    								   String qtde, String cdAreaResponsavel, String posicoesMecanicas) {
        IdwFacade.getInstancia().regristrarTesteDefeito(cdPt, cdOp, cb, dthr, cdDefeito, qtde, cdAreaResponsavel, posicoesMecanicas);
    }

    @WebMethod
    public void registrarMontagem(String cdPt, String cdOp, String cb, Date dthr, MontagensDTO lista, String qtde) {
        IdwFacade.getInstancia().registrarMontagem(cdPt, cdOp, cb, dthr, lista, qtde);
    }

    @WebMethod
    public void registrarMontagemAntecipada(String cdPt, String cdOp, String cb, Date dthr, MontagensDTO lista, String qtde, Boolean isFechouAntecipadamente, String reSupervisor, String cbSerial) {
        IdwFacade.getInstancia().registrarMontagemAntecipada(cdPt, cdOp, cb, dthr, lista, qtde, isFechouAntecipadamente, reSupervisor, cbSerial);
    }

    @WebMethod
    public DwFolha getDwFolhaPassagem(String cdPt, String nrop, String cb) {
        return IdwFacade.getInstancia().getDwFolhaPassagem(cdPt, nrop, cb);
    }

    @WebMethod
    public DwTOperacoesDTO getTiposOperacao() {
        return IdwFacade.getInstancia().getTiposOperacao();
    }

    @WebMethod
    public void setDwOperacao(DwOperacaoDTO dto) {
        IdwFacade.getInstancia().setDwOperacao(dto);
    }

    @WebMethod
    public DwOperacoesDTO setListaDwOperacao(DwOperacoesDTO listaDTO) {
        return IdwFacade.getInstancia().setListaDwOperacao(listaDTO);
    }

    @WebMethod
    public DwOperacoesDTO getDwOperacao(DwOperacaoDTO filtro) {
        return IdwFacade.getInstancia().getDwOperacao(filtro);
    }

    @WebMethod
    public DwOperacaoDTO getDwOperacaoByCodigo(DwOperacaoDTO filtro) {
        return IdwFacade.getInstancia().getDwOperacaoByCodigo(filtro);
    }

    @WebMethod
    public ListaRelatorioOPProcessadaDTO getListaRelatorioOPProcessadaDTO(FiltroRelatorioOPProcessadaDTO filtro) {
        return IdwFacade.getInstancia().getListaRelatorioOPProcessadaDTO(filtro);
    }

    @WebMethod
    public IpBalanceamentoDTO balancear(IpBalanceamentoDTO dto) {
        return IdwFacade.getInstancia().balancear(dto);
    }

    @WebMethod
    public ListaTipoAlgoritmoBalanceamentoDTO getTipoAlgoritmosBalanceamento() {
        return IpBalanceamentoTemplate.getTipoAlgoritmos();
    }

    @WebMethod
    public IpBalanceamentoDTO setBalanceamento(IpBalanceamentoDTO dto) {
        return IdwFacade.getInstancia().setBalanceamento(dto);
    }

    @WebMethod
    public IpBalanceamentosDTO excluirBalanceamentos(IpBalanceamentosDTO dtos) {
        return IdwFacade.getInstancia().excluirBalanceamentos(dtos);
    }

    @WebMethod
    public IpBalanceamentosDTO pesquisarBalanceamento(IpBalanceamentoDTO filtro) {
        return IdwFacade.getInstancia().pesquisarBalanceamento(filtro);
    }

    @WebMethod
    public IpBalanceamentoDTO firmarBalanceamento(IpBalanceamentoDTO dto) {
        return IdwFacade.getInstancia().firmarBalanceamento(dto);
    }

    @WebMethod
    public RelatorioProdutividadeR42DTO getRelatorioProdutividadeR42DTO(FiltroRelatorioProdutividadeR42DTO filtro) {
        return IdwFacade.getInstancia().getRelatorioProdutividadeR42DTO(filtro);
    }

    @WebMethod
    public Boolean isNumeroSerieRefugado(String cb) {
        return IdwFacade.getInstancia().isNumeroSerieRefugado(cb);
    }

    @WebMethod
    public RelatorioProducaoR043DTO getRelatorioProducaoR043(FiltroRelatorioProducaoR043DTO filtro) {
        return IdwFacade.getInstancia().getRelatorioProducaoR043(filtro);
    }

    @WebMethod
    public ListaComboDTO getTiposClasseABC() {
        return ClassificacaoABCRN.getTiposClasseABCCritica();
    }

    @WebMethod
    public ListaRelatorioDuplicacaoDePartesAcoplamentoDTO getListaRelatorioDuplicacaoDePartesAcoplamentoDTO(
            FiltroRelatorioDuplicacaoDePartesAcoplamentoDTO filtro) {

        return IdwFacade.getInstancia().getListaRelatorioDuplicacaoDePartesAcoplamento(filtro);

    }

    @WebMethod
    public DetalhamentoDefeitoDTO getOcorrenciaParettoDefeito(FiltroDetalheDefeito filtro) {
        return IdwFacade.getInstancia().getOcorrenciaParettoDefeito(filtro);
    }

    @WebMethod
    public GraficoParettoDefeitosDTO getGraficoParettoDefeito(FiltroDetalheDefeito filtro) {
        return IdwFacade.getInstancia().getGraficoParettoDefeito(filtro);
    }

    @WebMethod
    public PTsDTO pesquisarPtByGtComLayout(PtDTO pt) {
        return IdwFacade.getInstancia().pesquisarPtByGtComLayout(pt);
    }

    @WebMethod
    public ListaPeproDTO pesquisarDwPeproTodos() {
        return IdwFacade.getInstancia().pesquisarDwPeproTodos();
    }

    @WebMethod
    public String gerarNS(OmRegrasNscb regra, OmProduto omproduto, OmPt ompt, String cdcp) {
        return IdwFacade.getInstancia().gerarNS(regra, omproduto, ompt, cdcp);
    }

    @WebMethod
	public String montarSequencialSemanalAnual(String prefixo, int tamanhoSeqSemana) {
    	return IdwFacade.getInstancia().montarSequencialSemanalAnual(prefixo, tamanhoSeqSemana);
    }

    @WebMethod
    public ClassificacoesABCDTO removeClassificacaoABC(ClassificacoesABCDTO filtro) {
        return IdwFacade.getInstancia().removeClassificacaoABC(filtro);
    }
    

    
    @WebMethod
    public ListaGraficoBIParetoDetAreaRespDTO getDetalhamentoGraficoPerdasBIAreaRespPar(
            DetalheMonitorizacaoPTInjetDTO indicadores, String cdArea, String cdParada, String cdMaquina, String cdProduto, Boolean isComPeso, Boolean isSemPeso) {
        return IdwFacade.getInstancia().getDetalhamentoGraficoPerdasBIAreaRespPar(indicadores, cdArea, cdParada, cdMaquina, cdProduto, isComPeso, isSemPeso);
    }
    
    @WebMethod
    public MontagensDTO isCodigoBarrasPossuiMontagem(String cb) {
        return IdwFacade.getInstancia().isCodigoBarrasPossuiMontagem(cb);
    }
    @WebMethod
    public MontagensDTO getUltimaMontagemComSerial(String cb) {
        return IdwFacade.getInstancia().getUltimaMontagemComSerial(cb);
    }
    
    @WebMethod
    public MontagensDTO isCBJaMontado(String cb) {
    	return IdwFacade.getInstancia().isCBJaMontado(cb);
    }

    @WebMethod
	public MontagensDTO isCBJaMontadoNoPt(String cb, String cdpt, String cdcp) {
    	return IdwFacade.getInstancia().isCBJaMontado(cb, cdpt, cdcp);
	}
    
    @WebMethod
	public MontagensDTO getUltimaMontagemNoPosto(String cb, String cdpt, String cdcp) {
    	return IdwFacade.getInstancia().getUltimaMontagemNoPosto(cb, cdpt, cdcp);
    }


    @WebMethod
    public OpsIntegracaoDTO getOpsParaIntegrar(String cdop) {
    	return IdwFacade.getInstancia().getOpsParaIntegrar(cdop);
    }
    
    @WebMethod
	public ProdutosDTO pesquisarFolhaComOsProdutosConsiderandoEstrutura(ProdutosDTO produtos, OmPt ompt) {
		return IdwFacade.getInstancia().pesquisarFolhaComOsProdutosConsiderandoEstrutura(produtos, ompt);
	}

    @WebMethod
	public DwConsolidDTOs pesquisarDwConsolidByHoraApontamentoManualRefugo(Date dtReferencia, DwTurno dwturno, OmPt ompt, PpCp ppcp, 
			String cdproduto, DwPepro dwpepro, DwFolha dwfolha, DwCal dwcal){
		return IdwFacade.getInstancia().pesquisarDwConsolidByHoraApontamentoManualRefugo(dtReferencia, dwturno, ompt, ppcp, cdproduto, dwpepro, dwfolha, dwcal);
	}
    @WebMethod
	public PesquisasDTO pesquisarOmJob(PesquisaDTO filtro) {
    	return IdwFacade.getInstancia().pesquisarOmJob(filtro);
    }
    @WebMethod
	public ListaOmJobLogDTO pesquisarOmJoblog(FiltroPesquisaOmJobDTO filtro) {
    	return IdwFacade.getInstancia().pesquisarOmJoblog(filtro);
    }
    @WebMethod
	public ListaOmJobdetLogDTO pesquisarOmJobdetlog(Long idJoblog) {
    	return IdwFacade.getInstancia().pesquisarOmJobdetlog(idJoblog);
    }
    @WebMethod
	public  ListaTurnosDTO obtemTurnosPeriodo(OmPt ompt, Date dtHrIni, Date dtHrFim) {
    	return IdwFacade.getInstancia().obtemTurnosPeriodo(ompt, dtHrIni, dtHrFim);
    }
    @WebMethod
    public OmEmpresaDTO getEmpresaAtiva() {
    	return IdwFacade.getInstancia().getEmpresaAtiva();
    }
    @WebMethod
    public ListaRelatorioAlimentacaoDTO getListaRelatorioAlimentacaoDTO(Long idAlimentacao, Boolean isApenasRealimentacao, Date dtHrInicioLeitura, Date dtHrFimLeitura){
    	return IdwFacade.getInstancia().getListaRelatorioAlimentacaoDTO(idAlimentacao, isApenasRealimentacao, dtHrInicioLeitura, dtHrFimLeitura);
    }
    @WebMethod
    public RelatorioParRegulagemDTO getParRegulagemDTO(FiltroRelatorioProdRegulagemDTO filtro) {
        return IdwFacade.getInstancia().getParRegulagemDTO(filtro);
    }

    @WebMethod
	public RelatorioR100DTO getRelatorioR100DTO(FiltroR100DTO filtro) {
		return IdwFacade.getInstancia().getRelatorioR100DTO(filtro);
	}
	
    @WebMethod
	public GTsDTO getOmGtLigadosAosPTs() {
		return IdwFacade.getInstancia().getOmGtLigadosAosPTs();
	}

    @WebMethod
	public void setDiarioBordo(DiarioBordoDTO obs) {
		IdwFacade.getInstancia().setDiarioBordo(obs);
	}

    @WebMethod
    public DiariosBordoDTO getDiariosBordoDTO(String ns) {
		return IdwFacade.getInstancia().getDiariosBordoDTO(ns);
	}

    @WebMethod
	public RelatorioR101DTO getRelatorioR101DTO(FiltroR101DTO filtro) {
		return IdwFacade.getInstancia().getRelatorioR101DTO(filtro);
	}
    
    @WebMethod
    public MontagensDTO cancelarPalete(MontagensDTO palete) {
    	return IdwFacade.getInstancia().cancelarPalete(palete);
    }
    @WebMethod
    public MontagensDTO cancelarCaixa(String cbCaixa, String cdPt, String login, String motivo, String cdcp) {
    	return IdwFacade.getInstancia().cancelarCaixa(cbCaixa, cdPt, login, motivo, cdcp);
    }
    @WebMethod
	public ListaMSDTO pesquisarMsDTOExcesao(MsDTO msdto) {
    	return IdwFacade.getInstancia().pesquisarMsDTOExcesao(msdto);
	}
    @WebMethod
	public void transferirUps(MsDTO origem, MsDTO destino, IcDTO icupdto) {
    	IdwFacade.getInstancia().transferirUps(origem, destino, icupdto);
	}
    
    @WebMethod
	public DwNserie getHistoricoNS(String cb) {
    	return IdwFacade.getInstancia().getHistoricoNS(cb);
    }
    
    @WebMethod
    public MsEvt incluirEventoLog(EventoColetado evento) {
    	return IdwFacade.getInstancia().incluirEventoLog(evento);
    }
    @WebMethod
    public MsEvt incluirEvento(EventoColetado evento) {
    	return IdwFacade.getInstancia().incluirEventoLog(evento);
    }

    @WebMethod
	public PpCp pesquisarPpCpByNrDocCdPt(String cdcp, String cdPt) {
    	return IdwFacade.getInstancia().pesquisarPpCpByNrDocCdPtClone(cdcp, cdPt);
    }

    @WebMethod
	public PassagensDTO getPassagens(String cdPt, String codigoBarras) {
    	return IdwFacade.getInstancia().getPassagens(cdPt, codigoBarras);
    }

    @WebMethod
	public PassagensDTO getPassagensQC(String cdPt, String codigoBarras) {
    	return IdwFacade.getInstancia().getPassagensQC(cdPt, codigoBarras);
    }
    
    @WebMethod
    public void trocarOP(String cdPt, String nrop, Date dthrevento) {
    	IdwFacade.getInstancia().trocarOP(cdPt, nrop, dthrevento);
    }
    
    @WebMethod
    public GraficoParettoLogVRotSDTO getGraficoParettoLogVRot(FiltroDetalheLogVRotDTO filtro) {
        return IdwFacade.getInstancia().getGraficoParettoLogVRot(filtro);
    }
    
    @WebMethod
	public ProdutosDTO pesquisarProdutosComBanco(String cdProduto) {
    	return IdwFacade.getInstancia().pesquisarProdutosComBanco(cdProduto);
    }
    @WebMethod
	public void registrarBatismoBC(String cb, String idRegistro) {
    	IdwFacade.getInstancia().registrarBatismoBC(cb, idRegistro);
    }
    @WebMethod
	public ListaCPDTO definePpCpParaOProduto(OmGt omgt, String cdproduto, String nrop) {
    	return IdwFacade.getInstancia().definePpCpParaOProduto(omgt, cdproduto, nrop);
    }
    @WebMethod
	public ListaIwsAgendaDeParadaDTO getAgendaParada(String cdPt) {
    	return IdwFacade.getInstancia().getAgendaParada(cdPt);
    }
    @WebMethod
	public String getLoteProdutivo(String cdPt) {
    	return IdwFacade.getInstancia().getLoteProdutivo(cdPt);
    }    

    @WebMethod
	public EventoAOIDTO processaArquivoAoi(String cdup, String nrop, String nomeArquivo,  String conteudoArquivo, EventoColetado eventos) {
    	return IdwFacade.getInstancia().processaArquivoAoi(cdup, nrop, nomeArquivo, conteudoArquivo, eventos);
    }
    
    @WebMethod
	public EmailDTO enviarEmail(EmailDTO email)  {
    	return IdwFacade.getInstancia().enviarEmail(email);
    }
    
    @WebMethod
    public String getOpOndeMPUsadapeloCF(String ns, String cdproduto) {
    	return IdwFacade.getInstancia().getOpOndeMPUsadapeloCF(ns, cdproduto);
    }

    @WebMethod
    public String getCdProdSistCorp(String cdProduto) {
    	return IdwFacade.getInstancia().getCdProdSistCorp(cdProduto);
    }

    @WebMethod
	public ListaTipoGTDTO getTipoGTDTO(TipoGTDTO filtro) {
		return IdwFacade.getInstancia().getTipoGTDTO(filtro);
	}

    @WebMethod
	public TipoGTDTO setTipoGTDTO(TipoGTDTO dto) {
		return IdwFacade.getInstancia().setTipoGTDTO(dto);
	}
    
    @WebMethod
	public TipoGTDTO excluirTipoGTDTO(TipoGTDTO filtro) {
		return IdwFacade.getInstancia().excluirTipoGTDTO(filtro);
	}

    @WebMethod
	public ListaTipoPTDTO getTipoPTDTO(TipoPTDTO filtro) {
		return IdwFacade.getInstancia().getTipoPTDTO(filtro);
	}

    @WebMethod
	public TipoPTDTO setTipoPTDTO(TipoPTDTO dto) {
		return IdwFacade.getInstancia().setTipoPTDTO(dto);
	}
    
    @WebMethod
	public TipoPTDTO excluirTipoPTDTO(TipoPTDTO filtro) {
		return IdwFacade.getInstancia().excluirTipoPTDTO(filtro);
	}
}
