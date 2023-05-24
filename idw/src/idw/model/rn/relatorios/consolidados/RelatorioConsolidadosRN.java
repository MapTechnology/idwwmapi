package idw.model.rn.relatorios.consolidados;

import java.util.List;
import java.util.SortedMap;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.rn.AbstractRN;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO.Agrupamento;
import idw.util.IdwLogger;

public class RelatorioConsolidadosRN extends AbstractRN<DAOGenerico> {
    
    private FiltroRelatorioConsolidadosDTO filtro;

    public RelatorioConsolidadosRN() {
        super(new DAOGenerico());
    }
    
    public RelatorioConsolidadosRN(DAOGenerico dao) {
        super(dao);
    }
    
    /**
     * Metodo principal para retorno do relatorio consolidados
     */
    public RelatorioConsolidadoDTO getRelatorioConsolidados(FiltroRelatorioConsolidadosDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioConsolidadosRN.getRelatorioConsolidados");
		log.info( idLog , 0, "RelatorioConsolidadosRN.getRelatorioConsolidados filtro usado:" + filtro.toString());
    	
        this.filtro = filtro;
        List<DwConsolid> consolids = this.realizarConsulta();
        
        RelatorioConsolidadoDTO dto = new RelatorioConsolidadoDTO();
        
        if(filtro.getAgrupamento() == Agrupamento.PRODUTO) {
        	RelatorioConsolidadosProdutoRN rn = new RelatorioConsolidadosProdutoRN(getDao(), filtro);
        	
            SortedMap<String,List<GeraLinhaProduto>> linhas = rn.getLinhasAgrupadoPorProduto(consolids);
            rn.organizarListaPorProduto(linhas);
            dto = rn.getRelatorioAgrupadoPorProduto(getDao(), filtro, linhas);
            
        } else if(filtro.getAgrupamento() == Agrupamento.FERRAMENTA) {
        	
        	RelatorioConsolidadosFerramentaRN rn = new RelatorioConsolidadosFerramentaRN(getDao(), filtro);
        	
            SortedMap<String,List<GeraLinhaFerramenta>> linhas = rn.getLinhasAgrupadoPorFerramenta(consolids);
            rn.organizarListaPorFerramenta(linhas);
            dto = rn.getRelatorioAgrupadoPorFerramenta(getDao(), filtro, linhas);
            
        } else if(filtro.getAgrupamento() == Agrupamento.POSTO) {
        	
        	RelatorioConsolidadosPostoRN rn = new RelatorioConsolidadosPostoRN(getDao(), filtro);
        	
            SortedMap<String,List<GeraLinhaPosto>> linhas = rn.getLinhasAgrupadoPorPosto(consolids);
            rn.organizarListaPorPosto(linhas);
            
            dto = rn.getRelatorioAgrupadoPorPosto(getDao(), filtro, linhas);
        }
        
		log.mostrarAvaliacaoCompleta();
        return dto;
    
    }
    
    
    
    
    private List<DwConsolid> realizarConsulta() {

        MapQuery q = new MapQuery(getDaoSession());

        q.append("SELECT DISTINCT consolid");
        q.append("FROM DwConsolid consolid");
        q.append("JOIN consolid.dwConsols consol");
        q.append("JOIN consolid.ppCp ppcp");
        q.append("JOIN ppcp.ppCpprodutos cpprod");
        q.append("join cpprod.omProduto produto");
        q.append("JOIN consolid.dwTurno turno");
        q.append("JOIN consolid.omPt pt");
        q.append("JOIN consolid.dwFolha folha");

        q.append("left JOIN consol.dwConsolpas consolpa");
        q.append("left JOIN consolpa.dwConsolpaocos consolpaoco");
        q.append("LEFT JOIN folha.dwFolharaps folharap");
        q.append("LEFT JOIN folharap.dwRap rap");
        q.append("LEFT JOIN folharap.dwFolharapcoms folharapcomp");
        q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
        q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");
        q.append("LEFT JOIN pt.omObjs obj");
        q.append("LEFT JOIN obj.omGtByIdGt gt");
        q.append("WHERE consolid.tpId = :tpId");
        q.append("and (consolid.stAtivo is null or consolid.stAtivo = 1)");


        if (filtro.getRap() != null) {
            q.append("AND rap.cdRap = :cdRap");
        }
        if (filtro.getCdop() != null) {
            q.append("and cpprod.nrDoc = :nrop");
        }
        if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null) {
            q.append("and consolid.dtReferencia BETWEEN :dtInicio AND :dtFim");
        }
        if (filtro.getTurnoDTO() != null) {
            q.append("AND turno.idTurno = :idTurno");
        } else {
            q.append("AND consolid.dwTurno.idTurno != 1");
        }
        if (filtro.getOmpt() != null) {
            q.append("AND pt.idPt = :idPt");
        } else if (filtro.getOmgt() != null) {
            q.append("AND gt.idGt = :idGt");
        } else if (filtro.getDwGrupoFerramenta() != null) {
            q.append("AND gpferramenta.idGrupoFerramenta = :idGpRap");
        }

        q.defineParametro("tpId", (byte) 1);

        if (filtro.getCdop() != null) {
            q.defineParametro("nrop", filtro.getCdop());
        }
        if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null) {
            q.defineParametro("dtInicio", filtro.getPeriodoInicial());
            q.defineParametro("dtFim", filtro.getPeriodoFinal());
        }
        if (filtro.getTurnoDTO() != null) {
            q.defineParametro("idTurno", filtro.getTurnoDTO().getTurno().getIdTurno());
        }
        if (filtro.getRap() != null) {
            q.defineParametro("cdRap", filtro.getRap().getCdRap());
        }

        if (filtro.getOmpt() != null) {
            q.defineParametro("idPt", filtro.getOmpt().getIdPt());
        } else if (filtro.getOmgt() != null) {
            q.defineParametro("idGt", filtro.getOmgt().getIdGt());
        } else if (filtro.getDwGrupoFerramenta() != null) {
            q.defineParametro("idGpRap", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
        }
        return q.list();

    }
}
