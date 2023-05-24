package idw.model.rn.relatorios.consolidados;

import java.math.BigDecimal;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmPt;
import idw.model.rn.FolhaRN;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO.TipoPeso;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO.TipoProducao;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import ms.util.ConversaoTipos;

public class Produto {
    
    public static final BigDecimal KG = new BigDecimal(1000);
    public static final BigDecimal TON = new BigDecimal(1000000);
    
    private final FiltroRelatorioConsolidadosDTO filtro;
    
    //Marcos Sardinha: 2017-06-24 >> precisa quebrar por idFolha ... passou a ser chave
    private Long idFolha;    
    private String ferramenta; // é importante ter a ferramenta no produto pq o posto pode ter varias ferramentas com produtos em comum
    							// sem a ferramenta aqui os produtos seriam acumulados de forma independente gerando valores errados
    							// visto que o relatorio mostra produtos dependentes da ferramenta
    private String produto;
    private BigDecimal pecasPrevistas = BigDecimal.ZERO;
    private BigDecimal pecasProduzidas = BigDecimal.ZERO;
    private BigDecimal pecasRefugadas = BigDecimal.ZERO;
    private BigDecimal pecasBoas = BigDecimal.ZERO;
    private BigDecimal indiceRefugo = BigDecimal.ZERO;
    private BigDecimal eficienciaRealizacao = BigDecimal.ZERO;
    
    //campos usados em calculos internos
    private BigDecimal tempoAtivo = BigDecimal.ZERO;
    private BigDecimal cicloPadrao = BigDecimal.ZERO;
    private BigDecimal cavidadesAtivas = BigDecimal.ZERO;
    private BigDecimal fatorContagem = BigDecimal.ONE;
    private BigDecimal pecaOuPeso = BigDecimal.ONE;
    private OmPt pt;
    private DAOGenerico dao;
    
    public Produto(FiltroRelatorioConsolidadosDTO filtro, DAOGenerico dao) {
    	super();
        this.filtro = filtro;
        this.dao = dao;
    }

    public Produto(FiltroRelatorioConsolidadosDTO filtro, String ferramenta, DwConsolpr consolpr,  DAOGenerico dao) {
    	super();
        this.filtro = filtro;
        this.dao = dao;
    
        this.idFolha = consolpr.getDwConsol().getDwConsolid().getDwFolha().getIdFolha();
        this.ferramenta = ferramenta;
        this.produto = consolpr.getOmProduto().getCdProduto();
        
        this.pecaOuPeso = getPecasOuPeso(consolpr);

        //Marcos Sardinha: 2017-09-01 >> Defeito #4456
        this.pecasPrevistas = quantidadePrevista(consolpr);
        this.pecasPrevistas = AritmeticaUtil.multiplicar(pecasPrevistas, pecaOuPeso);
        
        this.pecasProduzidas =  consolpr.getPcsProducaoBruta();
        this.pecasProduzidas = AritmeticaUtil.multiplicar(pecasProduzidas, pecaOuPeso);
        
        this.pecasRefugadas = consolpr.getPcsProducaoRefugada();
        this.pecasRefugadas = AritmeticaUtil.multiplicar(pecasRefugadas, pecaOuPeso);
        
        this.pecasBoas = consolpr.getPcsProducaoLiquida();
        
        this.pt =  consolpr.getDwConsol().getDwConsolid().getOmPt();
        
        calcularValores();
    }
    
    private BigDecimal quantidadePrevista(DwConsolpr pr) {
    	BigDecimal retorno = BigDecimal.ZERO;
    	BigDecimal cavAtiva = (pr.getDwConsol().getQtAutoCavativas() == null ? BigDecimal.ZERO : pr.getDwConsol().getQtAutoCavativas());
    	BigDecimal cicloPadrao = (pr.getDwConsol().getSegAutoCiclopadrao());
    	BigDecimal segAutoTempoativo = AritmeticaUtil.somar((pr.getDwConsol().getSegAutoTempoativo() == null ? BigDecimal.ZERO : pr.getDwConsol().getSegAutoTempoativo()), (pr.getDwConsol().getSegManuTempoativo() == null ? BigDecimal.ZERO : pr.getDwConsol().getSegManuTempoativo()));
    	
    	if (cicloPadrao.doubleValue() > 0) {    	
    		retorno = FormulasInjet.calcularProducaoPrevista(segAutoTempoativo, cicloPadrao, cavAtiva, fatorContagem, pr.getDwConsol().getDwConsolid().getOmPt().getIndOee());
    	} 
    	
    	return retorno;
    }
    
    public void adicionar(Produto produto) {
    	
        this.pecasPrevistas = AritmeticaUtil.somar(pecasPrevistas, produto.getPecasPrevistas());
        this.pecasProduzidas = AritmeticaUtil.somar(
                pecasProduzidas,
                produto.getPecasProduzidas());
        this.pecasRefugadas = AritmeticaUtil.somar(
                pecasRefugadas,
                produto.getPecasRefugadas());
        
        this.pecasBoas = AritmeticaUtil.somar(pecasBoas, produto.getPecasBoas());
        
        calcularValores();
    }
    
    private void calcularValores() {
    	// Alessandre em 09-02-18 comitei para utilizar a producaoliquida que esta em dwconsolpr
    	/*Alan em 06/06/2018 retornei com a rotina para calcular peças boas, pois aparentemente há problemas na consolidação. Redmine #5558*/
        calcularPecasBoas();
        calcularIndiceRefugo();
        calcularEficienciaRealizacao();
    }
    
    
	//Alessandre em 09-02-18 comitei para utilizar a producaoliquida que esta em dwconsolpr*/
    /*Alan em 06/06/2018 retornei com a rotina para calcular peças boas, pois aparentemente há problemas na consolidação. Redmine #5558*/
    private void calcularPecasBoas() {
        this.pecasBoas = FormulasInjet.calcularProducaoLiquida(
                pecasProduzidas,
                pecasRefugadas);
      }
    
    private void calcularIndiceRefugo() {
        this.indiceRefugo = new BigDecimal(
                FormulasInjet.calcularIndiceRefugo(
                        pecasRefugadas,
                        pecasProduzidas));
    }
    
    private void calcularEficienciaRealizacao() {
        this.eficienciaRealizacao = new BigDecimal(
                FormulasInjet.calcularEficienciaRealizacao(
                        pecasBoas,pecasPrevistas));
    }
    
    public void calcularProducaoPrevista() {
    	FolhaRN folhaRN = new FolhaRN(dao);
    	DwFolha folha = new DwFolha();
    	folha.setIdFolha(idFolha);

    	//Marcos Sardinha: 2017-09-05 >> Defeito #4454
    	try {
			fatorContagem = folhaRN.getFatorContagemFromDwFolha(folha, pt);
		} catch (SemPacoteOuFatorException e) {
			// TODO Auto-generated catch block
			fatorContagem = BigDecimal.ONE;
		}
    	
    	tempoAtivo = (tempoAtivo == null ? BigDecimal.ZERO : tempoAtivo);
    	cicloPadrao = (cicloPadrao == null ? BigDecimal.ZERO : cicloPadrao);
    	cavidadesAtivas = (cavidadesAtivas == null ? BigDecimal.ZERO : cavidadesAtivas);
        this.pecasPrevistas = FormulasInjet.calcularProducaoPrevista(tempoAtivo, cicloPadrao, cavidadesAtivas, fatorContagem, pt.getIndOee());
        this.pecasPrevistas = AritmeticaUtil.multiplicar(this.pecasPrevistas, pecaOuPeso);
    }
    
    private BigDecimal getPecasOuPeso(DwConsolpr consolpr) {
        if(filtro.getTipoProducao() == TipoProducao.PECAS) {
            return BigDecimal.ONE;
        }
        
        BigDecimal peso = BigDecimal.ZERO;
        if(filtro.getTipoProducao() == TipoProducao.PESO_BRUTO) {
            peso = consolpr.getOmProduto().getGPesoBruto();
        } else if(filtro.getTipoProducao() == TipoProducao.PESO_LIQUIDO) {
            peso = consolpr.getOmProduto().getGPesoLiquido();
        }

        if(peso == null) {
            //produto nao possui peso
            return BigDecimal.ONE;
        }
        
        if(filtro.getTipoPeso() == TipoPeso.KG) {
            peso = peso.divide(KG);
        } else if(filtro.getTipoPeso() == TipoPeso.TON) {
            peso = peso.divide(TON);
        }
        
        return peso;
    }
    
    private int getNumeroCasasDecimaisProducao() {
        if(filtro.getTipoProducao() == TipoProducao.PECAS) {
            return 2;
        } else {
            if(filtro.getTipoPeso() == TipoPeso.KG) {
                return 3;
            } else if(filtro.getTipoPeso() == TipoPeso.TON) {
                return 5;
            }
        }
        
        return 0;
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
    
    //GETTERS FORMATADO.
    public String getPecasPrevistasFormatado() {
    	// Se a qtde de casas decimais for 0 entao a unidade eh peca, assim nao usar a ConversaoTipos pois arredonda
    	// e a producao prevista deve ser inteira
    	if (getNumeroCasasDecimaisProducao() == 0)
    		return String.valueOf(getPecasPrevistas().intValue());
        return ConversaoTipos.converteParaStringComFormat(
                getPecasPrevistas().doubleValue(), 
                getNumeroCasasDecimaisProducao());
    }
    
    public String getPecasProduzidasFormatado() {
        return ConversaoTipos.converteParaStringComFormat(
                getPecasProduzidas().doubleValue(), 
                getNumeroCasasDecimaisProducao());
    }
    
    public String getPecasRefugadasFormatado() {
        return ConversaoTipos.converteParaStringComFormat(
                getPecasRefugadas().doubleValue(), 
                getNumeroCasasDecimaisProducao());
    }
    
    public String getPecasBoasFormatado() {
        return ConversaoTipos.converteParaStringComFormat(
                getPecasBoas().doubleValue(), 
                getNumeroCasasDecimaisProducao());
    }
    
    public String getIndiceRefugoFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getIndiceRefugo().doubleValue(), 2);
    }
    
    public String getEficienciaRealizacaoFormatado() {
        return ConversaoTipos.converteParaStringComFormat(getEficienciaRealizacao().doubleValue(), 2);
    }

    //GETTERS E SETTERS
    public String getProduto() {
        return produto;
    }

    public BigDecimal getPecasPrevistas() {
        return pecasPrevistas;
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

    public BigDecimal getIndiceRefugo() {
        return indiceRefugo;
    }

    public BigDecimal getEficienciaRealizacao() {
        return eficienciaRealizacao;
    }

    public BigDecimal getTempoAtivo() {
        return tempoAtivo;
    }

    public void setTempoAtivo(BigDecimal tempoAtivo) {
        this.tempoAtivo = tempoAtivo;
    }

    public BigDecimal getCicloPadrao() {
        return cicloPadrao;
    }

    public void setCicloPadrao(BigDecimal cicloPadrao) {
        this.cicloPadrao = cicloPadrao;
    }

    public BigDecimal getCavidadesAtivas() {
        return cavidadesAtivas;
    }

    public void setCavidadesAtivas(BigDecimal cavidadesAtivas) {
        this.cavidadesAtivas = cavidadesAtivas;
    }

	public String getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}

	public Long getIdFolha() {
		return idFolha;
	}

	public void setIdFolha(Long idFolha) {
		this.idFolha = idFolha;
	}

	public BigDecimal getFatorContagem() {
		return fatorContagem;
	}

	public void setFatorContagem(BigDecimal fatorContagem) {
		this.fatorContagem = fatorContagem;
	}
}
