package idw.model.rn.relatorios.refugo.consolidado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolharap;
import idw.model.rn.AbstractRN;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;

public class RelatorioRefugoConsolidadoPorMoldeRN extends AbstractRN<DAOGenerico> {
    
    private FiltroRelatorioRefugoConsolidadoPorMoldeDTO filtro;

    public RelatorioRefugoConsolidadoPorMoldeRN() {
        super(new DAOGenerico());
    }
    
    public RelatorioRefugoConsolidadoPorMoldeRN(DAOGenerico dao) {
        super(dao);
    }
    
    /**
     * Metodo principal para retorno do relatorio
     */
    public RelatorioRefugoConsolidadoPorMoldeDTO getRelatorioRefugoConsolidadoPorMolde(FiltroRelatorioRefugoConsolidadoPorMoldeDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioRefugoConsolidadoPorMoldeRN.getRelatorioRefugoConsolidadoPorMolde");
		log.info( idLog , 0, "RelatorioRefugoConsolidadoPorMoldeRN.getRelatorioRefugoConsolidadoPorMolde filtro usado:" + filtro.toString());
    	
    	this.filtro = filtro;
        
        RelatorioRefugoConsolidadoPorMoldeDTO dto = new RelatorioRefugoConsolidadoPorMoldeDTO();
        
        List<DwConsolid> consolids = this.realizarConsulta();
        
        Map<String,List<GeraLinha>> linhas = getLinhasAgrupadoPorFerramenta(consolids);
        
        for(String chave : linhas.keySet()) {
            for(GeraLinha linha : linhas.get(chave)) {
            	// Marcos Sardinha: 2017-09-12 >> nao consider itens com refugo zerado
            	// dto.getLista().addAll(linha.getDTOs());
            	for (RelatorioRefugoConsolidadoPorMoldeDTO dtoRef : linha.getDTOs()) {
            		if (dtoRef.getPecasRefugadas().doubleValue() > 0d) {
            			dto.getLista().add(dtoRef);
            		}
            	}
            }
        }
        
        //Calcular ind ref e perdsas em seg
        for (RelatorioRefugoConsolidadoPorMoldeDTO refugo : dto.getLista()) {
        	refugo.setIndiceRef(new BigDecimal(FormulasInjet.calcularIndiceRefugo(refugo.getPecasRefugadas(), refugo.getPecasProduzidas())));
        	refugo.setPerdasSeg(FormulasInjet.calcularTempoRefugo(refugo.getPecasRefugadas(), refugo.getCicloMedio(), refugo.getCavidade()));
        }
        log.mostrarAvaliacaoCompleta();
        return dto;
    }
    
    private Map<String,List<GeraLinha>> getLinhasAgrupadoPorFerramenta(List<DwConsolid> consolids) {
        Map<String,List<GeraLinha>> linhasFerramentas = new HashMap<String, List<GeraLinha>>();
        for (DwConsolid id : consolids) {
            
            for(DwFolharap rap : id.getPpCp().getDwFolha().getDwFolharaps()) {
                GeraLinha novaLinha = new GeraLinha(getDao(), filtro, id, rap);
                mesclarLinhasIguaisPorFerramenta(linhasFerramentas, novaLinha);
                break;
            }
            
        }
        return linhasFerramentas;
    }
    
    private void mesclarLinhasIguaisPorFerramenta(Map<String,List<GeraLinha>> linhasFerramentas, GeraLinha novaLinha) {
        List<GeraLinha> linhasDaChave = linhasFerramentas.get(novaLinha.getChave());
        
        if(linhasDaChave == null) {
            linhasDaChave = new ArrayList<>();
            linhasFerramentas.put(novaLinha.getChave(), linhasDaChave);
        }
        
        for(GeraLinha linha: linhasDaChave) {
            
            if(linha.equals(novaLinha)) {
                linha.adicionar(novaLinha);
                return;
            }
            
        }
        
        linhasDaChave.add(novaLinha);
    }   
    
    private List<DwConsolid> realizarConsulta() {

        MapQuery q = new MapQuery(getDaoSession());

        q.append("SELECT DISTINCT consolid");
        q.append("FROM DwConsolid consolid");
        q.append("JOIN consolid.dwConsols consol");
        q.append("JOIN consolid.ppCp ppcp");
        q.append("JOIN ppcp.ppCpprodutos cpprod");
        q.append("JOIN cpprod.omProduto produto");
        q.append("JOIN consolid.dwTurno turno");
        q.append("JOIN consolid.omPt pt");
        q.append("JOIN consolid.dwFolha folha");

        q.append("LEFT JOIN consol.dwConsolpas consolpa");
        q.append("LEFT JOIN consolpa.dwConsolpaocos consolpaoco");
        q.append("LEFT JOIN folha.dwFolharaps folharap");
        q.append("LEFT JOIN folharap.dwRap rap");
        q.append("LEFT JOIN folharap.dwFolharapcoms folharapcomp");
        q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
        q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");
        q.append("LEFT JOIN pt.omObjs obj");
        q.append("LEFT JOIN obj.omGtByIdGt gt");
        q.append("WHERE consolid.tpId = :tpId");
        q.append("AND (consolid.stAtivo is null or consolid.stAtivo = 1)");


        if (filtro.getRap() != null) {
            q.append("AND folharap.dwRap = :pRap");
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
        
        if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null) {
            q.defineParametro("dtInicio", filtro.getPeriodoInicial());
            q.defineParametro("dtFim", filtro.getPeriodoFinal());
        }
        if (filtro.getTurnoDTO() != null) {
            q.defineParametro("idTurno", filtro.getTurnoDTO().getTurno().getIdTurno());
        }
        if (filtro.getRap() != null) {
            q.defineParametro("pRap", filtro.getRap());
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
