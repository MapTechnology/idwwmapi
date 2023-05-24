package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.LazyInitializationException;
import org.hibernate.SessionException;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwCal;
import idw.model.pojos.PpPlancol;
import idw.model.pojos.PpPlanec;
import idw.model.pojos.PpPlano;
import idw.model.pojos.PpPlanptgt;

@SuppressWarnings("serial")
public class PlanoDTO extends PpPlano implements Serializable{

	public static final int _STATUS_CADASTRADO = 0;
	public static final int _STATUS_FIRMADO = 1;
	public static final int _STATUS_CANCELADO = 2;

	private Date dtReferenciaAntecipacao;
	private String mensagem = "";
	
	private ResultadoDTO resultadoDTO = new ResultadoDTO();
	
	public PlanoDTO(PpPlano plano, DAOGenerico dao) {
		setPlanoDTO(plano, dao);
	}
	
	public PlanoDTO() {
	}
	public void setPlanoDTO(PpPlano plano, DAOGenerico dao) {
		this.setIdPlano(plano.getIdPlano());
		this.setCdPlano(plano.getCdPlano());
		this.setDsPlano(plano.getDsPlano());
		this.setDthrPrevisaoinicio(plano.getDthrPrevisaoinicio());
		this.setDtRevisao(plano.getDtRevisao());
		this.setDtStativo(plano.getDtStativo());
		this.setIndOee(plano.getIndOee());
		this.setIsConsiderarcm(plano.getIsConsiderarcm());
		this.setIsSimular(plano.getIsSimular());
		this.setIsConsiderarest(plano.getIsConsiderarest());
		this.setIsConsiderarindisp(plano.getIsConsiderarindisp());
		this.setIsConsiderarmo(plano.getIsConsiderarmo());
		this.setIsConsiderarmp(plano.getIsConsiderarmp());
		this.setIsConsideraroeefinalserie(plano.getIsConsideraroeefinalserie());
		this.setIsConsiderarprodutoturno(plano.getIsConsiderarprodutoturno());
		this.setIsConsiderarrap(plano.getIsConsiderarrap());
		this.setIsConsiderarcal(plano.getIsConsiderarcal());
		this.setIsDeterminadocal(plano.getIsDeterminadocal());
		this.setIsModelo(plano.getIsModelo());
		this.setRevisao(plano.getRevisao());
		this.setStAtivo(plano.getStAtivo());
		this.setStPlano(plano.getStPlano());

		//if(dao != null && dao.getSession() != null && plano.getDwCal() != null) {
		if(plano.getDwCal() != null) {		
			try {
				this.setDwCal((DwCal)plano.getDwCal().clone());
			}catch(SessionException e) {
				this.setDwCal(null);
			}
		}
		else {
			this.setDwCal(null);
		}
		
		if(dao != null && dao.getSession() != null && plano.getPpTpplano() != null) {
			try {
				this.setPpTpplano(plano.getPpTpplano().clone());
			}catch(SessionException e) {
				this.setPpTpplano(null);
			}
		}
		else {
			this.setPpTpplano(null);
		}
		
		if(plano.getOmUsrByIdUsrrevisao() != null) {
			try {
				this.setOmUsrByIdUsrrevisao(plano.getOmUsrByIdUsrrevisao().clone(false));
			} catch (SessionException e){
				// Essa excessao ocorre qdo a excessao eh uma StatelessSession e o pojo nao estava na lista do hql
				//
				this.setOmUsrByIdUsrrevisao(null);
			}
		}
		else {
			this.setOmUsrByIdUsrrevisao(null);
		}
		if(plano.getOmUsrByIdUsrstativo() != null) {
			try {
				this.setOmUsrByIdUsrstativo(plano.getOmUsrByIdUsrstativo().clone(false));
			} catch (SessionException e){
				this.setOmUsrByIdUsrstativo(null);
			}
		}
		else {
			this.setOmUsrByIdUsrstativo(null);
		}

		if(dao != null && dao.getSession() != null && plano.getPpPlancols() != null) {
			try {
				for (PpPlancol c : plano.getPpPlancols()){
					this.getPpPlancols().add(c.clone(false));
				}
			} catch (SessionException e){
				this.setPpPlancols(null);
			}
		} else {
			this.setPpPlancols(null);
		}
		
		if(dao != null && dao.getSession() != null && plano.getPpPlanptgts() != null) {
			try {
				for (PpPlanptgt p : plano.getPpPlanptgts()){
					this.getPpPlanptgts().add(p.clone(true));
				}
			} catch (SessionException e){
				this.setPpPlanptgts(null);
			}
		}
		else {
			this.setPpPlanptgts(null);
		}
		
		try {
			if (dao != null && dao.getSession() != null && plano.getPpPlanecs() != null){
				for (PpPlanec p : plano.getPpPlanecs()){
					this.getPpPlanecs().add(p.clone());
				}
			}
		} catch (SessionException e){
			// Na statelesssession essa excessao ocorre se o pojo nao estiver no hql
			this.setPpPlanecs(null);
		} catch (LazyInitializationException e){
			// Na statelesssession essa excessao ocorre se o pojo nao estiver no hql
			this.setPpPlanecs(null);
		}
	}
	
	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

	public boolean isStatusCadastrado(){
		return (getStPlano() != null && getStPlano() == _STATUS_CADASTRADO);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getDtReferenciaAntecipacao() {
		return dtReferenciaAntecipacao;
	}
	
	public void setDtReferenciaAntecipacao(Date dtReferenciaAntecipacao) {
		this.dtReferenciaAntecipacao = dtReferenciaAntecipacao;
	}
}
