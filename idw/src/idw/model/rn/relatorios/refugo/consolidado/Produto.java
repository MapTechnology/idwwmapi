package idw.model.rn.relatorios.refugo.consolidado;

import java.math.BigDecimal;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsolpr;
import idw.model.rn.FolhaRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;

public class Produto {
    
    private String produto;
    private BigDecimal pecasProduzidas = BigDecimal.ZERO;
    private BigDecimal pecasRefugadas = BigDecimal.ZERO;
    private BigDecimal pecasBoas = BigDecimal.ZERO;
    private BigDecimal cavidade = BigDecimal.ZERO;

    public Produto(DAOGenerico dao, DwConsolpr consolpr) {
        this.produto = consolpr.getOmProduto().getCdProduto();
        
        this.pecasProduzidas = consolpr.getPcsProducaoBruta();
        
        this.pecasRefugadas = consolpr.getPcsProducaoRefugada();
        
        FolhaRN folhaRN = new FolhaRN(dao);
        try {
			BigDecimal pcsCiclo = folhaRN.getPcsPorCicloAtivas(consolpr.getDwConsol().getDwConsolid().getDwFolha(), consolpr.getOmProduto());
			this.cavidade = pcsCiclo;
		} catch (SemPcsPorCicloAtivasException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}        
        
        
        calcularValores();
    }
    
    public void adicionar(Produto produto) {
        this.pecasProduzidas = AritmeticaUtil.somar(
                pecasProduzidas,
                produto.getPecasProduzidas());
        this.pecasRefugadas = AritmeticaUtil.somar(
                pecasRefugadas,
                produto.getPecasRefugadas());
        calcularValores();
    }
    
    private void calcularValores() {
        calcularPecasBoas();
    }
    
    private void calcularPecasBoas() {
        this.pecasBoas = FormulasInjet.calcularProducaoLiquida(
                pecasProduzidas,
                pecasRefugadas);
    }
    
    public String getChave() {
        return getProduto();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Produto) {
            Produto objeto = (Produto) obj;
            if(objeto.getChave().equals(getChave())) {
                return true;
            }
        }
        return false;
    }

    //GETTERS E SETTERS
    public String getProduto() {
        return produto;
    }

    public BigDecimal getPecasProduzidas() {
        return pecasProduzidas;
    }

    public BigDecimal getPecasRefugadas() {
        return pecasRefugadas;
    }

    public BigDecimal getPecasBoas() {
        return pecasBoas;
    }

	public BigDecimal getCavidade() {
		return cavidade;
	}

	public void setCavidade(BigDecimal cavidade) {
		this.cavidade = cavidade;
	}
    
    
}
