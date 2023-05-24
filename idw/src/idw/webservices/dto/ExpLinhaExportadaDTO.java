package idw.webservices.dto;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPassdef;
import idw.model.pojos.DwPassmon;
import idw.model.pojos.DwPasstf;
import idw.model.pojos.OmCfg;
import idw.model.rn.DataHoraRN;
import idw.util.Util;

@SuppressWarnings("serial")
public class ExpLinhaExportadaDTO implements Serializable {
	
	private String fase;
	private Date dthr_Entrada;
	private String plataforma;
	private String sku;
	private String complemento;
	private String nserie;
	private String matriculaSupervisor;
	private String nomeSupervisor;
	private String matriculaOperador;
	private String nomeOperador;
	private String idComponente1;
	private String dsComponente1;
	private String idComponente2;
	private String dsComponente2;
	private String duracaoTesteHHMMSSmmm;
	private Date dthr_Saida;
	private String statusTeste;
	private String dsStatusTeste;
	private List<ExpCausaDTO> defeitos;	
	private List<ExpDetalheLinhaExportadaDTO> detalhes;
	private String idPt;
	private String[] tiposFolha = {
			"Montagem",
			"Teste el�trico",
			"Teste Visual",
			"Teste funcional",
			"Apenas registro de passagem",
			"Reprocesso",
			"Programa IAC",
			"Vari�vel resposta"
			};

	public ExpLinhaExportadaDTO(ResultSet rs){
		try {
			this.setNserie(rs.getString("ns"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ExpLinhaExportadaDTO(DwPassagem dwPassagem){
		try {
			this.setFase(tiposFolha[dwPassagem.getDwConsolid().getDwFolha().getTpFolha()]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.setDthr_Entrada(DataHoraRN.getDataComMilisegundos(dwPassagem.getDthrInicio(), dwPassagem.getMsDthrinicio()) );				
		} catch (Exception e) {				
		}

		try {
			this.setSku(dwPassagem.getDwNserie().getOmProduto().getCdProduto() + "-" + dwPassagem.getDwNserie().getOmProduto().getDsProduto());
		} catch (Exception e) {				
		}

		try {
			this.setPlataforma(dwPassagem.getDwNserie().getOmProduto().getOmProgrp().getDsProgrp());
		} catch (Exception e) {				
		}

		try {
			this.setComplemento(dwPassagem.getDwNserie().getOmProduto().getDsComplemento());
		} catch (Exception e) {				
		}

		try {
			this.setNserie(dwPassagem.getDwNserie().getNs());
		} catch (Exception e) {				
		}

		try {
			this.setMatriculaSupervisor(dwPassagem.getOmUsrByIdUsrsupervisor().getCdUsr());
		} catch (Exception e) {				
		}

		try {
			this.setNomeSupervisor(dwPassagem.getOmUsrByIdUsrsupervisor().getDsNome());
		} catch (Exception e) {				
		}

		try {
			this.setMatriculaOperador(dwPassagem.getOmUsrByIdUsroperador().getCdUsr());
		} catch (Exception e) {				
		}

		try {
			this.setNomeOperador(dwPassagem.getOmUsrByIdUsroperador().getDsNome());
		} catch (Exception e) {				
		}

		try {
			this.setIdPt(dwPassagem.getOmPt().getCdPt());
		} catch (Exception e) {				
		}
		
		try {
			this.setDuracaoTesteHHMMSSmmm(DataHoraRN.formatSegundosParaHHMMSS(dwPassagem.getSegCiclo().intValue()));
		} catch (Exception e) {				
		}

		try {
			this.setDthr_Saida(DataHoraRN.getDataComMilisegundos(dwPassagem.getDthr(), dwPassagem.getMsDthr()));				
		} catch (Exception e) {				
		}

	}
	public String getIdPt() {
		return idPt;
	}
	public void setIdPt(String idPt) {
		this.idPt = idPt;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public Date getDthr_Entrada() {
		return dthr_Entrada;
	}
	public void setDthr_Entrada(Date dthrEntrada) {
		dthr_Entrada = dthrEntrada;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNserie() {
		return nserie;
	}
	public void setNserie(String nserie) {
		this.nserie = nserie;
	}
	public String getMatriculaSupervisor() {
		return matriculaSupervisor;
	}
	public void setMatriculaSupervisor(String matriculaSupervisor) {
		this.matriculaSupervisor = matriculaSupervisor;
	}
	public String getNomeSupervisor() {
		return nomeSupervisor;
	}
	public void setNomeSupervisor(String nomeSupervisor) {
		this.nomeSupervisor = nomeSupervisor;
	}
	public String getMatriculaOperador() {
		return matriculaOperador;
	}
	public void setMatriculaOperador(String matriculaOperador) {
		this.matriculaOperador = matriculaOperador;
	}
	public String getNomeOperador() {
		return nomeOperador;
	}
	public void setNomeOperador(String nomeOperador) {
		this.nomeOperador = nomeOperador;
	}
	public String getIdComponente1() {
		return idComponente1;
	}
	public void setIdComponente1(String idComponente1) {
		this.idComponente1 = idComponente1;
	}
	public String getDsComponente1() {
		return dsComponente1;
	}
	public void setDsComponente1(String dsComponente1) {
		this.dsComponente1 = dsComponente1;
	}
	public String getIdComponente2() {
		return idComponente2;
	}
	public void setIdComponente2(String idComponente2) {
		this.idComponente2 = idComponente2;
	}
	public String getDsComponente2() {
		return dsComponente2;
	}
	public void setDsComponente2(String dsComponente2) {
		this.dsComponente2 = dsComponente2;
	}
	public String getDuracaoTesteHHMMSSmmm() {
		return duracaoTesteHHMMSSmmm;
	}
	public void setDuracaoTesteHHMMSSmmm(String duracaoTesteHHMMSSmmm) {
		this.duracaoTesteHHMMSSmmm = duracaoTesteHHMMSSmmm;
	}
	public List<ExpCausaDTO> getDefeitos() {
		return defeitos;
	}
	public void setDefeitos(List<ExpCausaDTO> defeitos) {
		this.defeitos = defeitos;
	}
	public Date getDthr_Saida() {
		return dthr_Saida;
	}
	public void setDthr_Saida(Date dthrSaida) {
		dthr_Saida = dthrSaida;
	}
	public List<ExpDetalheLinhaExportadaDTO> getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(List<ExpDetalheLinhaExportadaDTO> detalhes) {
		this.detalhes = detalhes;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getStatusTeste() {
		return statusTeste;
	}
	public void setStatusTeste(String statusTeste) {
		this.statusTeste = statusTeste;
	}
	public String getDsStatusTeste() {
		return dsStatusTeste;
	}
	public void setDsStatusTeste(String dsStatusTeste) {
		this.dsStatusTeste = dsStatusTeste;
	}
	public int compareToModeloResumidoHorizontal(ExpLinhaExportadaDTO exp){
		int result = nserie.compareTo(exp.nserie);
		return result == 0 ? (fase.compareTo(exp.fase)) : result;
	}
	
	public void inicializaComponentesMontados(DwPassagem dwPassagem){
		// Obtem os componentes montados
		try {
			for (DwPassmon dwPassmon : dwPassagem.getDwPassmons()){
				if (this.getIdComponente1() == null){
					this.setIdComponente1(dwPassmon.getOmProduto().getCdProduto());
					this.setDsComponente1(dwPassmon.getOmProduto().getDsProduto());
				} else if (this.getIdComponente2() == null) {
					this.setIdComponente2(dwPassmon.getOmProduto().getCdProduto());
					this.setDsComponente2(dwPassmon.getOmProduto().getDsProduto());
				}
			}
		} catch (Exception e) {					
		}

	}
	
	public void inicializaStatusUltimoTeste(DwPassagem dwPassagem, OmCfg omCfg){
		// Obtem o status do Teste
		try {
			int tpFolha = dwPassagem.getDwConsolid().getDwFolha().getTpFolha();

			// se Montagem ou Reprocesso
			if (tpFolha == 1 ){
				this.setStatusTeste("");
				this.setDsStatusTeste("");
			}else if (tpFolha == 0 || tpFolha == 5){ // Se receita de testes
				if (dwPassagem.getStNserie() == 1 /* teste com sucesso */){
					this.setStatusTeste("0");
					this.setStatusTeste("OK");
				}else{
					if (dwPassagem.getDwPasstfs() != null){
						for (DwPasstf dwPasstf : dwPassagem.getDwPasstfs()){
							if (dwPasstf.getStEtapa() == 1 /*falha*/){
								this.setStatusTeste(dwPasstf.getOrdemetapa().toString());
								this.setDsStatusTeste(Util.removeCaracter(dwPasstf.getDwFtEtapa().getDsEtapa(), "\n"));
								break;
							}
						}
					}
				}

			}else if (tpFolha == 3){ // Teste visual
				if (dwPassagem.getStNserie() == 1 /* passou */){
					this.setStatusTeste("0");
					this.setDsStatusTeste("OK");
				}else{
					for (DwPassdef dwPassdef : dwPassagem.getDwPassdefs()){							
						this.setStatusTeste(dwPassdef.getDwTDefeito().getCdTdefeito());
						this.setDsStatusTeste(dwPassdef.getDwTDefeito().getDsTdefeito());
						break;						
					}
				}
			}else if (tpFolha == 2){ // Teste eletrico
				if (dwPassagem.getStNserie() == 1 /* sucesso */){
					this.setStatusTeste("0");
					this.setDsStatusTeste("OK");
				}else{
					this.setStatusTeste("1");
					this.setDsStatusTeste("FALHA");
				}
			}else if (dwPassagem.getDwEst().getIdEst() == omCfg.getDwEstByIdEstexpedicao().getIdEst()){
				if (dwPassagem.getStNserie() == 1){
					this.setStatusTeste("0");
					this.setDsStatusTeste("OK");
				}else{
					this.setStatusTeste("1");
					this.setDsStatusTeste("FALHA");							
				}					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public long inicializaCausaDoDefeito(DwPassagem dwPassagem){
		long idPassCau = 0; // Ira assumir o id da causa apontada no reprocesso. Esse id pode ser referente a um teste funcional, visual, eletrico ou montagem
		// se existir um idPasscau na passagem, usa-lo
		if (dwPassagem.getDwPasscau() != null && dwPassagem.getDwPasscau().getIdPasscau() > 0){
			idPassCau = dwPassagem.getDwPasscau().getIdPasscau();
		}
		
		// obtem o idPasscau a partir do teste funcional
		for (DwPasstf dwpasstf : dwPassagem.getDwPasstfs()){
			if (dwpasstf.getDwPasscau() != null && dwpasstf.getDwPasscau().getIdPasscau() > 0){
				idPassCau = dwpasstf.getDwPasscau().getIdPasscau();
				break;
			}
		}
		// obtem o idPasscau a partir dos defeitos apontados
		for (DwPassdef dwpassdef : dwPassagem.getDwPassdefs()){
			if (dwpassdef.getDwPasscau() != null && dwpassdef.getDwPasscau().getIdPasscau() > 0){
				idPassCau = dwpassdef.getDwPasscau().getIdPasscau();
				break;
			}
		}
		return idPassCau;
	}
}
