package ms.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

import idw.model.pojos.MsIc;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.util.IdwLogger;
import ms.coleta.ICThread;
import ms.coleta.dto.AndonDTO;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.IIC;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;

@SuppressWarnings("serial")
public class IcDTO implements Serializable{
	public static final int _CONEXAO_TCP = 1;
	public static final int _CONEXAO_RS485 = 2;
	public static final int _CONEXAO_RS232 = 3;
	public static final int _CONEXAO_USB = 4;

	private Integer idIc;
	private Date dthr_heartbeat;
	private Integer tp_ic;  

	private String url_conexao;
	private PortaEthernetDTO portaEthernet;
	private PortaSerial232DTO portaRS232;
	private PortaSerial485DTO portaRS485;
	private PortaUSBDTO portaUSB;
	private int tpCalculoAndon; // 0 - Calculo hora
								// 1 - Calculo turno
	private String cd_ic;
	private String ds_ic;
	private Integer revisao;
	private Date dthr_stativo;
	private Date dthr_revisao;
	private Integer st_ativo;
	private String firmware;
	private boolean stAndonConfiguravelAtivo = false;
	private String loginusuario;
	private String cdPerfilAndon;
	
	private Boolean isAutenticacao;
	private String loginAD;
	private  String sernhaAD;
	private String emailsScriptPadraoNC;
	private String emailAoiNC;

	// Alessandre: o atributo abaixo foi colocado apenas para suprir a necessidade
	// da tela de cadastro de IC simplificada
	// Em 09-10-12 verifiquei q portas tem um similar msIcUpDTOLocais
	private List<IcUpDTO> portas;
	
	
	private boolean isRemoverThread = false;
	private transient ICThread threadGerenciadora;
	private transient IdwLogger log;
	private List<IcUpDTO> msIcUpDTOLocais = new CopyOnWriteArrayList<IcUpDTO>();
	private List<AndonDTO> ultimosParametrosAndon = new ArrayList<AndonDTO>(); // Mantem o registro dos eventos ativos no andon deste IC

	public IcDTO() {
		
	}
	public IcDTO(MsIc msic){
		if (msic != null) {
			this.cd_ic = msic.getCdIc();
			this.ds_ic=msic.getDsIc();
			this.idIc = msic.getIdIc().intValue();
			this.url_conexao = msic.getUrlConexao();
			this.firmware = msic.getFirmware();
			this.st_ativo = msic.getStAtivo().intValue();
		}
	}
	
	public PortaEthernetDTO getPortaEthernet() {
		return portaEthernet;
	}
	public void setPortaEthernet(PortaEthernetDTO portaEthernet) {
		this.portaEthernet = portaEthernet;
	}
	public int getTpCalculoAndon() {
		return tpCalculoAndon;
	}
	public void setTpCalculoAndon(int tpCalculoAndon) {
		this.tpCalculoAndon = tpCalculoAndon;
	}
	public void setStAndonConfiguravelAtivo(boolean stAndonConfiguravelAtivo) {
		this.stAndonConfiguravelAtivo = stAndonConfiguravelAtivo;
	}
	public boolean getStAndonConfiguravelAtivo() {
		return stAndonConfiguravelAtivo;
	}

	public PortaSerial232DTO getPortaRS232() {
		return portaRS232;
	}
	public void setPortaRS232(PortaSerial232DTO portaRS232) {
		this.portaRS232 = portaRS232;
	}
	public PortaSerial485DTO getPortaRS485() {
		return portaRS485;
	}
	public void setPortaRS485(PortaSerial485DTO portaRS485) {
		this.portaRS485 = portaRS485;
	}
	public PortaUSBDTO getPortaUSB() {
		return portaUSB;
	}
	public void setPortaUSB(PortaUSBDTO portaUSB) {
		this.portaUSB = portaUSB;
	}
	public Integer getIdIc() {
		return idIc;
	}
	public void setIdIc(Integer idIc) {
		this.idIc = idIc;
	}
	public Date getDthr_heartbeat() {
		return dthr_heartbeat;
	}
	public void setDthr_heartbeat(Date dthrHeartbeat) {
		dthr_heartbeat = dthrHeartbeat;
	}
	public Integer getTp_ic() {
		return tp_ic;
	}
	public void setTp_ic(Integer tpIc) {
		tp_ic = tpIc;
	}
	public String getUrl_conexao() {
		return url_conexao;
	}
	public void setUrl_conexao(String urlConexao) {
		url_conexao = urlConexao;
	}
	public void setCd_ic(String cd_ic) {
		this.cd_ic = cd_ic;
	}
	public String getCd_ic() {
		return cd_ic;
	}
	public void setDs_ic(String ds_ic) {
		this.ds_ic = ds_ic;
	}
	public String getDs_ic() {
		return ds_ic;
	}
	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}
	public Integer getRevisao() {
		return revisao;
	}
	public void setSt_ativo(Integer st_ativo) {
		this.st_ativo = st_ativo;
	}
	public Integer getSt_ativo() {
		return st_ativo;
	}
	public String getFirmware() {
		return firmware;
	}
	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}
	public void setDthr_revisao(Date dthr_revisao) {
		this.dthr_revisao = dthr_revisao;
	}
	public Date getDthr_revisao() {
		return dthr_revisao;
	}
	public void setDthr_stativo(Date dthr_stativo) {
		this.dthr_stativo = dthr_stativo;
	}
	public Date getDthr_stativo() {
		return dthr_stativo;
	}
	public void setLoginUsuario(String loginusu){
		this.loginusuario=loginusu;
	}
	public String getLoginUsuario(){
		return loginusuario;
	}
	public String getCdPerfilAndon() {
		return cdPerfilAndon;
	}
	public void setCdPerfilAndon(String cdPerfilAndon) {
		this.cdPerfilAndon = cdPerfilAndon;
	}
	public List<IcUpDTO> getPortas() {
		return portas;
	}
	public void setPortas(List<IcUpDTO> portas) {
		this.portas = portas;
	}
	public boolean isRemoverThread() {
		return isRemoverThread;
	}

	public void setRemoverThread(boolean isRemoverThread) {
		this.isRemoverThread = isRemoverThread;
	}
	public IIC getInterfaceAdam() {
		// TODO Aqui acontece erro  nullpointer qdo o IC e removido do MS
		// ou na inclusao de uma nova up no ms
		return  this.threadGerenciadora.getIICAdam();
	}
	public ICThread obtemThreadGerenciadora() {
		return this.threadGerenciadora;
	}

	public void mudaThreadGerenciadora(ICThread threadGerenciadora) {
		this.threadGerenciadora = threadGerenciadora;
	}
	public void executaServicoAndonHeartbeat(IIC adam) {
		if(getStAndonConfiguravelAtivo() == true) {
			//Criando o evento de andon e a respectiva mensagem para que o serviço posssa ser chamado corretamente.
			EventoColetado eventoColetado = new EventoColetado();
			//número do serviço de andon é 4 para que o serviço seja buscado corretamente na lista se serviços disponíveis
			eventoColetado.setTipoEvento(4);
			MensagemRecebida mensagemAndon = new MensagemRecebida(eventoColetado);
			mensagemAndon.setDadosIcDTO(this);
			mensagemAndon.setLog(this.getLog());
			mensagemAndon.setIc(adam);
			try {
				getLog().info("	INICIO - Chamando serviço para mensagem " + mensagemAndon.getDescricaoServico() + " em " + DataHoraRN.getDataHoraAtualFormatada());
				ServicoFactory.getInstancia().executaServico(null, mensagemAndon);
				getLog().info("	FIM - Serviço para mensagem " + mensagemAndon.getDescricaoServico() + " finalizou em " + DataHoraRN.getDataHoraAtualFormatada());
			} catch (ServicoFalhouException e) {
				// TODO Aqui devemos salvar o evento pendente e ficar tentando
				getLog().info("Salvando evento pois o mesmo nao foi processado");
			}
		}
	}
	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}
	/*
	 * Esse metodo esta sendo chamado por uma pesquisa em IcRN que ira retornar as configuracoes para o ColetorFujiFlex
	 */
	public void inicializarIcUpDTOComMsIc(MsIc msic, PTRN rn){
		if (msic != null) {
			for (MsMsicup msicup : msic.getMsMsicups()){
				OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msicup.getMsUp().getCdUp());
				// Somente as portas do MS em questao deve ser considerada
				if (msicup.getMsMs().getStAtivo().equals(BigDecimal.ONE)) {
					IcUpDTO icupdto = new IcUpDTO(msicup, ompt);
					addOrSetIcUpDTO(icupdto);
				}
			}
			// Acho q o portas tem q deicar de existir, mas pra isso o msicupdtolocais deve ter um set e get, mas nao sei o impacto disso
			this.portas = this.msIcUpDTOLocais;
		}
	}
	public void addOrSetIcUpDTO(IcUpDTO msicupdtolocal) {
		boolean isExiste = false;
		for (IcUpDTO m : this.msIcUpDTOLocais) {
			//Alexandre 14/06/2016 - Analisar necessidade desse trecho.
			//Se for alterado o cadastro do Modulo de Sinais consequentemente todos os IDs de MsIcUp serao diferentes tambem.
			//Logo nenhuma UP sera preservada.
			if (msicupdtolocal.getIdIcUp().equals(m.getIdIcUp())) {
				m.setIsUpSendoTratada(msicupdtolocal.getIsUpSendoTratada());				
				isExiste = true;
				m.getUpDTO().atualizaFromUpDTO(msicupdtolocal.getUpDTO());
				
				// Se as urls auxiliares forem diferentes, atualizar
				if (m.getUrlAuxiliar() == null || msicupdtolocal.getUrlAuxiliar() == null || m.getUrlAuxiliar().equals(msicupdtolocal.getUrlAuxiliar()) == false)
					m.setUrlAuxiliar(msicupdtolocal.getUrlAuxiliar());

				if (m.getScriptTeste() == null || msicupdtolocal.getScriptTeste() == null || m.getScriptTeste().equals(msicupdtolocal.getScriptTeste()) == false)
					m.setScriptTeste(msicupdtolocal.getScriptTeste());

				if (m.getNomeArquivoScript() == null || msicupdtolocal.getNomeArquivoScript() == null || m.getNomeArquivoScript().equals(msicupdtolocal.getNomeArquivoScript()) == false)
					m.setNomeArquivoScript(msicupdtolocal.getNomeArquivoScript());
				
				if (m.getExtensaoArquivoScript() == null || msicupdtolocal.getExtensaoArquivoScript() == null || m.getExtensaoArquivoScript().equals(msicupdtolocal.getExtensaoArquivoScript()) == false)
					m.setExtensaoArquivoScript(msicupdtolocal.getExtensaoArquivoScript());

				break;
			}
		}
		if (isExiste == false) {
			// Alessandre: A linha abaixo deve existir para o injet, mas esta impactando no insert avaliar 5-3-13
			// alessandre: a linha abaixo pode ficar descomentada a partir de 8-4-13, resolvi o problema, qdo for necessario retornar via webservice, o facade ira remover o conteudo ciclico.
			msicupdtolocal.setIc(this);
			this.msIcUpDTOLocais.add(msicupdtolocal);
		}
	}

	public List<IcUpDTO> getMsIcUpDTOLocais() {
		return this.msIcUpDTOLocais;
	}
	
	public void setMsIcUpDTOLocais(List<IcUpDTO> valor) {
		this.msIcUpDTOLocais = valor;
	}
	
	
	public void calculaValorEficienciaUltimoCicloUP(int idIcUp, Date dtHrFim) {
		Date dtHrInicio = getDataHoraInicioCicloUP(idIcUp);
		int cicloUP = DataHoraRN.getQuantidadeSegundosNoPeriodo(dtHrInicio, dtHrFim);
		double cicloPadrao = getCicloPadraoUP(idIcUp);
		Double eficiencia = (cicloPadrao / (double)cicloUP * 100.0);
		ListIterator<IcUpDTO> msIcUpDtoIterator = msIcUpDTOLocais.listIterator();
		while(msIcUpDtoIterator.hasNext()) {
			IcUpDTO msIcUpDto = msIcUpDtoIterator.next();
			if(msIcUpDto.getIdIcUp() == idIcUp) {
				msIcUpDto.getUpDTO().setVlEficienciaUltimoCiclo(eficiencia);
			}
		}
	}
	
	public void setaDataHoraInicioCicloUP(int idIcUp, Date dtHr) {
		ListIterator<IcUpDTO> msIcUpDtoIterator = msIcUpDTOLocais.listIterator();
		while(msIcUpDtoIterator.hasNext()) {
			IcUpDTO msIcUpDto = msIcUpDtoIterator.next();
			if(msIcUpDto.getIdIcUp() != null && msIcUpDto.getIdIcUp() == idIcUp) {
				msIcUpDto.getUpDTO().setDtHrInicioCiclo(dtHr);
			}
		}
	}
	
	private double getCicloPadraoUP(int idIcUp) {
		double ciclo = 0d;
		for(IcUpDTO msIcUpDto : msIcUpDTOLocais) {
			if(msIcUpDto.getIdIcUp() == idIcUp) {
				ciclo = msIcUpDto.getUpDTO().getSegCicloPadrao();
			}
		}
		return ciclo;
	}

	private Date getDataHoraInicioCicloUP(int idIcUp) {
		Date dthr = new Date();
		for(IcUpDTO msIcUpDto : msIcUpDTOLocais) {
			if(msIcUpDto.getIdIcUp() == idIcUp) {
				dthr = msIcUpDto.getUpDTO().getDtHrInicioCiclo();
			}
		}
		return dthr;
	}
	public List<AndonDTO> getUltimosParametrosAndon() {
		return ultimosParametrosAndon;
	}	
	public void setUltimosParametrosAndon(List<AndonDTO> ultimosParametrosAndon) {
		this.ultimosParametrosAndon = ultimosParametrosAndon;
	}
	public void setCdParadaUP(int idIcUp, String cdparada) {
		ListIterator<IcUpDTO> msIcUpDtoIterator = msIcUpDTOLocais.listIterator();
		while(msIcUpDtoIterator.hasNext()) {
			IcUpDTO msIcUpDto = msIcUpDtoIterator.next();
			if(msIcUpDto.getIdIcUp() == idIcUp) {
				msIcUpDto.getUpDTO().setCdParada(cdparada);
			}
		}
	}
	public Boolean getIsAutenticacao() {
		return isAutenticacao;
	}
	public void setIsAutenticacao(Boolean isAtutenticacao) {
		this.isAutenticacao = isAtutenticacao;
	}
	public String getLoginAD() {
		return loginAD;
	}
	public void setLoginAD(String loginAD) {
		this.loginAD = loginAD;
	}
	public String getSernhaAD() {
		return sernhaAD;
	}
	public void setSernhaAD(String sernhaAD) {
		this.sernhaAD = sernhaAD;
	}
	public String getEmailsScriptPadraoNC() {
		return emailsScriptPadraoNC;
	}
	public void setEmailsScriptPadraoNC(String emailsScriptPadraoNC) {
		this.emailsScriptPadraoNC = emailsScriptPadraoNC;
	}
	public String getEmailAoiNC() {
		return emailAoiNC;
	}
	public void setEmailAoiNC(String emailAoiNC) {
		this.emailAoiNC = emailAoiNC;
	}
	
}
