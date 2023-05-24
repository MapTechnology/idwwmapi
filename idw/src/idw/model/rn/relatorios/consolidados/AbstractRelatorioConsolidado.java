package idw.model.rn.relatorios.consolidados;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsolid;
import idw.model.rn.AbstractRN;
import idw.util.AritmeticaUtil;
import ms.util.ConversaoTipos;

public abstract class AbstractRelatorioConsolidado  extends AbstractRN<DAOGenerico>{
    
    public AbstractRelatorioConsolidado(DAOGenerico dao) {
		super(dao);
	}

	protected RelatorioConsolidadoDTO dto;
    protected Map<String,BigDecimal> ciclosPadroes;
    protected List<DwConsolid> ids;
    
    
    /* Metodo responsavel em preencher o total Geral do relatorio
     * 
     */
    protected void preencherFormatandoCamposTotaisDoRelatorioDTO(
            Posto totalTodosOsPostos,
            Ferramenta totalTodasAsFerramentas,
            Produto totalTodosOsProdutos) {
        
        dto.setHorasTrabalhadasTotal(totalTodosOsPostos.getHorasTrabalhadasFormatado());
        dto.setHorasParadasTotal(totalTodosOsPostos.getHorasParadasFormatado());
        dto.setTempoAtivoTotal(totalTodosOsPostos.getTempoAtivoFormatado());
        dto.setIndiceParadasTotal(totalTodosOsPostos.getIndiceParadasFormatado()+"%");
        dto.setEficienciaRealizacaoTotal(totalTodosOsProdutos.getEficienciaRealizacaoFormatado()+"%");
        
        dto.setPecasPrevistasTotal(totalTodosOsProdutos.getPecasPrevistasFormatado());
        dto.setPecasProduzidasTotal(totalTodosOsProdutos.getPecasProduzidasFormatado());
        dto.setPecasRefugadasTotal(totalTodosOsProdutos.getPecasRefugadasFormatado());
        dto.setPecasBoasTotal(totalTodosOsProdutos.getPecasBoasFormatado());
        dto.setIndiceRefugosTotal(totalTodosOsProdutos.getIndiceRefugoFormatado()+"%");
        
        dto.setCicloPadraoTotal(getCicloPadraoMediaFormatado());
        dto.setCicloLidoTotal(totalTodasAsFerramentas.getCicloLidoFormatado());
        dto.setEficienciaCicloTotal(totalTodasAsFerramentas.getEficienciaCicloFormatado() + "%");
        dto.setEficienciaCicloPondTotal(totalTodasAsFerramentas.getEficienciaCicloFormatado()+"%");
        dto.setIndiceCavidadesAtivasTotal(totalTodasAsFerramentas.getIndiceCavidadesFormatado()+"%");
        
        dto.setOeeTotal(totalTodosOsPostos.getOeeFormatado()+"%");
        dto.setOeeCapTotal(totalTodosOsPostos.getOeeCapFormatado()+"%");
    }

    protected void preencherFormatandoCamposTotaisDoRelatorioDTO(
            Posto totalTodosOsPostos,
            Ferramenta totalTodasAsFerramentas,
            Produto totalTodosOsProdutos, 
            Double indPcsPorCiclo) {
        
        dto.setHorasTrabalhadasTotal(totalTodosOsPostos.getHorasTrabalhadasFormatado());
        dto.setHorasParadasTotal(totalTodosOsPostos.getHorasParadasFormatado());
        dto.setTempoAtivoTotal(totalTodosOsPostos.getTempoAtivoFormatado());
        dto.setIndiceParadasTotal(totalTodosOsPostos.getIndiceParadasFormatado()+"%");
        dto.setEficienciaRealizacaoTotal(totalTodosOsProdutos.getEficienciaRealizacaoFormatado()+"%");
        
        dto.setPecasPrevistasTotal(totalTodosOsProdutos.getPecasPrevistasFormatado());
        dto.setPecasProduzidasTotal(totalTodosOsProdutos.getPecasProduzidasFormatado());
        dto.setPecasRefugadasTotal(totalTodosOsProdutos.getPecasRefugadasFormatado());
        dto.setPecasBoasTotal(totalTodosOsProdutos.getPecasBoasFormatado());
        dto.setIndiceRefugosTotal(totalTodosOsProdutos.getIndiceRefugoFormatado()+"%");
        
        dto.setCicloPadraoTotal(getCicloPadraoMediaFormatado());
        dto.setCicloLidoTotal(totalTodasAsFerramentas.getCicloLidoFormatado());
        dto.setEficienciaCicloTotal(totalTodasAsFerramentas.getEficienciaCicloFormatado() + "%");
        dto.setEficienciaCicloPondTotal(totalTodasAsFerramentas.getEficienciaCicloFormatado()+"%");
        dto.setIndiceCavidadesAtivasTotal(ConversaoTipos.converteParaStringComFormat(indPcsPorCiclo,2) +"%");
        
        dto.setOeeTotal(totalTodosOsPostos.getOeeFormatado()+"%");
        dto.setOeeCapTotal(totalTodosOsPostos.getOeeCapFormatado()+"%");
    }
    
    protected void adicionarNoMap(Posto posto, Ferramenta ferramenta) {
        String chave = posto.getChave() + ferramenta.getChave();
        
        if(ciclosPadroes.get(chave) == null) {
            ciclosPadroes.put(chave, ferramenta.getCicloPadrao());
        }
        
        ids.addAll(posto.getIds());
    }
    
    protected void adicionarIdsDoMap(Ferramenta ferramenta) {
        ferramenta.setIds(new ArrayList<DwConsolid>());
        for(DwConsolid id : ids) {
            ferramenta.adicionar(id);
        }
        ferramenta.calcularValores();
    }
    
    private String getCicloPadraoMediaFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getCicloPadraoMedia().doubleValue(), 3) + "s";
    }
    
    private BigDecimal getCicloPadraoMedia() {
        
        if(ciclosPadroes != null && ciclosPadroes.size() > 0) {
            BigDecimal cicloPadraoAcumulado = BigDecimal.ZERO;
            for(String chave : ciclosPadroes.keySet()) {
                BigDecimal cicloPadrao = ciclosPadroes.get(chave);                
                cicloPadraoAcumulado = AritmeticaUtil.somar(cicloPadrao, cicloPadraoAcumulado);
            }
            
            return AritmeticaUtil.dividir(
                    cicloPadraoAcumulado,
                    new BigDecimal(ciclosPadroes.size()));
        }
        
        return BigDecimal.ZERO;
    }
}
