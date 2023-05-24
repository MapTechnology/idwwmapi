package ms.coleta.dto;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import ms.model.dto.UpDTO;

public class ClienteRegistrado {
	private String ip;
	private int porta;
	private String urlConexao;
	private List<UpDTO> upsDoIHM = new ArrayList<UpDTO>();
	private Session sessaoWs;
	
	public void addUpDTO(UpDTO updto) {
		if (isContemUP(updto) == false)
			upsDoIHM.add(updto);
	}
	public void setUpsDoIHM(List<UpDTO> ups) {
		this.upsDoIHM = ups;
	}
	public List<UpDTO> getUpsDoIHM() {
		return this.upsDoIHM;
	}
	
	public boolean isContemUP(UpDTO updto) {
		boolean isRetorno = false;
		for (UpDTO up : upsDoIHM) {
			if (up.getCd_up().equals(updto.getCd_up())) {
				isRetorno = true;
				break;
			}
		}
		return isRetorno;
	}
	public String getUrlConexao() {
		return this.urlConexao;
	}

	public void setUrlConexao(String urlConexao) {
		this.urlConexao = urlConexao;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getIp() {
		return this.ip;
	}

	public int getPorta() {
		return this.porta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;		
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + porta;
		result = prime * result
				+ ((urlConexao == null) ? 0 : urlConexao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()){
			ClienteRegistrado cr = (ClienteRegistrado) o;
			return (cr.urlConexao.equals(urlConexao) && cr.porta == porta);
		}
		return false;
	}
	public Session getSessaoWs() {
		return sessaoWs;
	}
	public void setSessaoWs(Session sessaoWs) {
		this.sessaoWs = sessaoWs;
	}
	
	
}
