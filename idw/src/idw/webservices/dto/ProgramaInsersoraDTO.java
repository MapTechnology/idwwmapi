package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import idw.model.pojos.OmPrg;
import idw.model.pojos.OmPrgpos;
import idw.model.pojos.OmPt;


@SuppressWarnings("serial")
public class ProgramaInsersoraDTO implements Serializable{
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int EVENTO_PROGRAMA_NAONECESSITAATUALIZACAO = 3;
	private int ERRO_PROGRAMA_JA_EXISTE = 1;
	private int ERRO_DESCONHECIDO = 2;
	private int ERRO_SEMCONFIGURACAO = 4;
	
	public int getERRO_SEMCONFIGURACAO() {
		return ERRO_SEMCONFIGURACAO;
	}

	public void setERRO_SEMCONFIGURACAO(int eRROSEMCONFIGURACAO) {
		ERRO_SEMCONFIGURACAO = eRROSEMCONFIGURACAO;
	}

	private OmPt ompt;
	private OmPrg omprg;
	private Set<OmPrgpos> omprgpos;
	private double cicloPadrao = 60d;
	
	private Date dthrRevisao;
	
    private int resultadoEvento;

	public OmPt getOmpt() {
		return ompt;
	}

	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}

	public OmPrg getOmprg() {
		return omprg;
	}

	public void setOmprg(OmPrg omprg) {
		this.omprg = omprg;
	}

	public Set<OmPrgpos> getOmprgpos() {
		return omprgpos;
	}

	public void setOmprgpos(Set<OmPrgpos> omprgpos) {
		this.omprgpos = omprgpos;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public int getEVENTO_PROGRAMA_NAONECESSITAATUALIZACAO() {
		return EVENTO_PROGRAMA_NAONECESSITAATUALIZACAO;
	}

	public int getERRO_PROGRAMA_JA_EXISTE() {
		return ERRO_PROGRAMA_JA_EXISTE;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public Date getDthrRevisao() {
		return dthrRevisao;
	}

	public void setDthrRevisao(Date dthrRevisao) {
		this.dthrRevisao = dthrRevisao;
	}

	public double getCicloPadrao() {
		return cicloPadrao;
	}

	public void setCicloPadrao(double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	
}
