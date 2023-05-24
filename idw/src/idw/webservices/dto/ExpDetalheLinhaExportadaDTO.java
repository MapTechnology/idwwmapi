package idw.webservices.dto;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwFtSub;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPasstf;
import idw.model.pojos.DwPasstfse;
import idw.model.pojos.DwPasstfsepmView;
import idw.model.rn.DataHoraRN;
import idw.util.Util;

@SuppressWarnings("serial")
public class ExpDetalheLinhaExportadaDTO implements Serializable {
	
	private String idReceita;
	private Date dthrMedicao;
	private String msDthrMedicao;
	private String idFase;
	private String dsFase;
	private String ordemEtapa;
	private String ordemSubetapa;
	private String idSubFase;
	private String dsSubFase;
	private String status;
	private String corrente;
	private String tensao;
	private String fluxoEntrada;
	private String flusoSaida;

	public ExpDetalheLinhaExportadaDTO(ResultSet rs){
		try {
			setDthrMedicao(DataHoraRN.getDataComMilisegundos(rs.getTimestamp("dthr_medicao"), rs.getDouble("ms_dthrmedicao")));
			setMsDthrMedicao(rs.getString("ms_dthrmedicao"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try{
			setOrdemEtapa(rs.getString("ordemetapa"));
		} catch (SQLException e){}
		try{
			setOrdemSubetapa(rs.getString("ordemsubetapa"));
		} catch (SQLException e){}
		try{
			setStatus(String.valueOf((rs.getInt("st_nserie")==(byte)1 ? 0 : 1)));
		} catch (SQLException e){}
		try{
			setCorrente(rs.getString("vlcorrente"));
		} catch (SQLException e){}
		try{
			setTensao(rs.getString("tensao"));
		} catch (SQLException e){}
		try{
			setFlusoSaida(rs.getString("fluxos"));
		} catch (SQLException e){}
		try{
			setFluxoEntrada(rs.getString("fluxoe"));
		} catch (SQLException e){}
	}

	public ExpDetalheLinhaExportadaDTO(DwPassagem dwPassagem, DwPasstf dwPasstf, DwPasstfse dwPasstfse, DwPasstfsepmView dwPasstfsepmView){
		this.setIdReceita(String.valueOf(dwPassagem.getIdPassagem()));
		try {
			this.setDthrMedicao(DataHoraRN.getDataComMilisegundos(dwPasstfsepmView.getDthrMedicao(), dwPasstfsepmView.getMsDthrmedicao().doubleValue()));
			this.setMsDthrMedicao(dwPasstfsepmView.getMsDthrmedicao().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			DwFtEtapa etapa = dwPasstf.getDwFtEtapa();
			this.setOrdemEtapa(dwPasstf.getOrdemetapa().toString());
			this.setIdFase(etapa.getCdEtapa());
			this.setDsFase(Util.removeCaracter(etapa.getDsEtapa(), "\n"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			DwFtSub sub = dwPasstfse.getDwFtSub();
			this.setOrdemSubetapa(dwPasstfse.getOrdemsubetapa().toString());
			this.setIdSubFase(String.valueOf(sub.getIdFtSub()));
			this.setDsSubFase(sub.getDsSub());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.setStatus(String.valueOf((dwPassagem.getStNserie()==(byte)1 ? 0 : 1)));							
		} catch (Exception e) {				
		}
		try {
			this.setCorrente(dwPasstfsepmView.getVlcorrente().toString());
		} catch (Exception e) {							
		}						
		try {
			this.setTensao(dwPasstfsepmView.getTensao().toString());
		} catch (Exception e) {							
		}						
		try {
				String fluxoE = "";
				if (dwPasstfsepmView.getFluxoe().intValue() == 1){
					fluxoE = "COM FLUXO";
				}else if (dwPasstfsepmView.getFluxoe().intValue() == 2){
					fluxoE = "SEM FLUXO";
				}else if (dwPasstfsepmView.getFluxoe().intValue() == 3){
					fluxoE = "COM FLUXO INICIO, SEM NO FIM";
				}else if (dwPasstfsepmView.getFluxoe().intValue() == 4){
					fluxoE = "SEM FLUXO INICIO, COM NO FIM";
				}
				this.setFluxoEntrada(fluxoE);
		} catch (Exception e) {							
		}
		try {
			String fluxoE = "";
			if (dwPasstfsepmView.getFluxos().intValue() == 1){
				fluxoE = "COM FLUXO";
			}else if (dwPasstfsepmView.getFluxos().intValue() == 2){
				fluxoE = "SEM FLUXO";
			}else if (dwPasstfsepmView.getFluxos().intValue() == 3){
				fluxoE = "COM FLUXO INICIO, SEM NO FIM";
			}else if (dwPasstfsepmView.getFluxos().intValue() == 4){
				fluxoE = "SEM FLUXO INICIO, COM NO FIM";
			}
			this.setFlusoSaida(fluxoE);
		} catch (Exception e) {							
		}
	}
	public Date getDthrMedicao() {
		return dthrMedicao;
	}
	public void setDthrMedicao(Date dthrMedicao) {
		this.dthrMedicao = dthrMedicao;
	}
	public String getIdFase() {
		return idFase;
	}
	public void setIdFase(String idFase) {
		this.idFase = idFase;
	}
	public String getDsFase() {
		return dsFase;
	}
	public void setDsFase(String dsFase) {
		this.dsFase = dsFase;
	}
	public String getIdSubFase() {
		return idSubFase;
	}
	public void setIdSubFase(String idSubFase) {
		this.idSubFase = idSubFase;
	}
	public String getDsSubFase() {
		return dsSubFase;
	}
	public void setDsSubFase(String dsSubFase) {
		this.dsSubFase = dsSubFase;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCorrente() {
		return corrente;
	}
	public void setCorrente(String corrente) {
		this.corrente = corrente;
	}
	public String getTensao() {
		return tensao;
	}
	public void setTensao(String tensao) {
		this.tensao = tensao;
	}
	public String getFluxoEntrada() {
		return fluxoEntrada;
	}
	public void setFluxoEntrada(String fluxoEntrada) {
		this.fluxoEntrada = fluxoEntrada;
	}
	public String getFlusoSaida() {
		return flusoSaida;
	}
	public void setFlusoSaida(String flusoSaida) {
		this.flusoSaida = flusoSaida;
	}
	public String getDsFluxoSaida(){
		String fluxoE = "";
		try {
			if (Integer.parseInt(getFlusoSaida()) == 1){
				fluxoE = "COM FLUXO";
			}else if (Integer.parseInt(getFlusoSaida()) == 2){
				fluxoE = "SEM FLUXO";
			}else if (Integer.parseInt(getFlusoSaida()) == 3){
				fluxoE = "COM FLUXO INICIO, SEM NO FIM";
			}else if (Integer.parseInt(getFlusoSaida()) == 4){
				fluxoE = "SEM FLUXO INICIO, COM NO FIM";
			}
		} catch (Exception e){
			
		}
		return fluxoE;

	}
	public String getDsFluxoEntrada(){
		String fluxoE = "";
		try {
			if (Integer.parseInt(getFluxoEntrada()) == 1){
				fluxoE = "COM FLUXO";
			}else if (Integer.parseInt(getFluxoEntrada()) == 2){
				fluxoE = "SEM FLUXO";
			}else if (Integer.parseInt(getFluxoEntrada()) == 3){
				fluxoE = "COM FLUXO INICIO, SEM NO FIM";
			}else if (Integer.parseInt(getFluxoEntrada()) == 4){
				fluxoE = "SEM FLUXO INICIO, COM NO FIM";
			}
		} catch (Exception e){
			
		}
		return fluxoE;

	}
	public String getOrdemEtapa() {
		return ordemEtapa;
	}
	public void setOrdemEtapa(String ordemEtapa) {
		this.ordemEtapa = ordemEtapa;
	}
	public String getOrdemSubetapa() {
		return ordemSubetapa;
	}
	public void setOrdemSubetapa(String ordemSubetapa) {
		this.ordemSubetapa = ordemSubetapa;
	}
	public String getMsDthrMedicao() {
		return msDthrMedicao;
	}
	public void setMsDthrMedicao(String msDthrMedicao) {
		this.msDthrMedicao = msDthrMedicao;
	}
	public String getIdReceita() {
		return idReceita;
	}
	public void setIdReceita(String idReceita) {
		this.idReceita = idReceita;
	}
}
