package idw.webservices.dto;

public class ExportacaoModeloResumidoHorizontalDTO {

	private String plataforma;
	private String sku;
	private String complemento;
	private String ns;
	private String reSupervisor;
	private String nmSupervisor;
	// Montagem
	private String dataMontagem;
	private String horaMontagem;
	private String reOperador;
	private String nmOperador;
	private String idPostoMontagem;
	private String statusEfeitoMontagem;
	private String componenteMontado1;
	private String componenteMontado2;
	private String dsComponenteMontado1;
	private String dsComponenteMontado2;
	
	// Teste funcional
	private String dataFuncional;
	private String horaFuncional;
	private String reOperadorFuncional;
	private String nmOperadorFuncional;
	private String idPostoFuncional;
	private String duracaoFuncional;
	private String statusEfeitoFuncional;
	
	//Teste passa / não passa
	private String dataEletrico;
	private String horaEletrico;
	private String reOperadorEletrico;
	private String nmOperadorEletrico;
	private String idPostoEletrico;
	private String statusEfeitoEletrico;
		//Testa passa / código defeito
	private String dataVisual;
	private String horaVisual;
	private String reOperadorVisual;
	private String nmOperadorVisual;
	private String idPostoVisual;
	private String tempoTesteVisual;
	private String statusEfeitoVisual;
	
		//Apenas registro de passagem
	private String dataPassagem;
	private String horaPassagem;
	private String reOperadorPassagem;
	private String nmOperadorPassagem;
	private String idPostoPassagem;
	private String statusEfeitoPassagem;
	
		//Reprocesso causa-ação
	private String dataReprocesso;
	private String horaReprocesso;
	private String reOperadorReprocesso;
	private String nmOperadorReprocesso;
	private String idPostoReprocesso;
	private String componenteMontado1Reprocesso;
	private String componenteMontado2Reprocesso;
	private String dsComponenteMontado1Reprocesso;
	private String dsComponenteMontado2Reprocesso;
	private String dataSaidaReprocesso;
	private String horaSaidaReprocesso;
	private String causa;
	private String acao;
	

	public String getDataFuncional() {
		return dataFuncional;
	}
	public void setDataFuncional(String dataFuncional) {
		this.dataFuncional = dataFuncional;
	}
	public String getHoraFuncional() {
		return horaFuncional;
	}
	public void setHoraFuncional(String horaFuncional) {
		this.horaFuncional = horaFuncional;
	}
	public String getReOperadorFuncional() {
		return reOperadorFuncional;
	}
	public void setReOperadorFuncional(String reOperadorFuncional) {
		this.reOperadorFuncional = reOperadorFuncional;
	}
	public String getNmOperadorFuncional() {
		return nmOperadorFuncional;
	}
	public void setNmOperadorFuncional(String nmOperadorFuncional) {
		this.nmOperadorFuncional = nmOperadorFuncional;
	}
	public String getIdPostoFuncional() {
		return idPostoFuncional;
	}
	public void setIdPostoFuncional(String isPostoFuncional) {
		this.idPostoFuncional = isPostoFuncional;
	}
	public String getDuracaoFuncional() {
		return duracaoFuncional;
	}
	public void setDuracaoFuncional(String duracaoFuncional) {
		this.duracaoFuncional = duracaoFuncional;
	}
	public String getStatusEfeitoFuncional() {
		return statusEfeitoFuncional;
	}
	public void setStatusEfeitoFuncional(String statusEfeitoFuncional) {
		this.statusEfeitoFuncional = statusEfeitoFuncional;
	}

	public String getDsComponenteMontado1Reprocesso() {
		return dsComponenteMontado1Reprocesso;
	}
	public void setDsComponenteMontado1Reprocesso(
			String dsComponenteMontado1Reprocesso) {
		this.dsComponenteMontado1Reprocesso = dsComponenteMontado1Reprocesso;
	}
	public String getDsComponenteMontado2Reprocesso() {
		return dsComponenteMontado2Reprocesso;
	}
	public void setDsComponenteMontado2Reprocesso(
			String dsComponenteMontado2Reprocesso) {
		this.dsComponenteMontado2Reprocesso = dsComponenteMontado2Reprocesso;
	}

	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
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
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	public String getReSupervisor() {
		return reSupervisor;
	}
	public void setReSupervisor(String reSupervisor) {
		this.reSupervisor = reSupervisor;
	}
	public String getNmSupervisor() {
		return nmSupervisor;
	}
	public void setNmSupervisor(String nmSupervisor) {
		this.nmSupervisor = nmSupervisor;
	}
	public String getDataMontagem() {
		return dataMontagem;
	}
	public void setDataMontagem(String dataMontagem) {
		this.dataMontagem = dataMontagem;
	}
	public String getHoraMontagem() {
		return horaMontagem;
	}
	public void setHoraMontagem(String horaMontagem) {
		this.horaMontagem = horaMontagem;
	}
	public String getReOperador() {
		return reOperador;
	}
	public void setReOperador(String reOperador) {
		this.reOperador = reOperador;
	}
	public String getNmOperador() {
		return nmOperador;
	}
	public void setNmOperador(String nmOperador) {
		this.nmOperador = nmOperador;
	}
	public String getIdPostoMontagem() {
		return idPostoMontagem;
	}
	public void setIdPostoMontagem(String idPostoMontagem) {
		this.idPostoMontagem = idPostoMontagem;
	}
	public String getStatusEfeitoMontagem() {
		return statusEfeitoMontagem;
	}
	public void setStatusEfeitoMontagem(String statusEfeitoMontagem) {
		this.statusEfeitoMontagem = statusEfeitoMontagem;
	}
	public String getComponenteMontado1() {
		return componenteMontado1;
	}
	public void setComponenteMontado1(String componenteMontado1) {
		this.componenteMontado1 = componenteMontado1;
	}
	public String getComponenteMontado2() {
		return componenteMontado2;
	}
	public void setComponenteMontado2(String componenteMontado2) {
		this.componenteMontado2 = componenteMontado2;
	}
	public String getDataEletrico() {
		return dataEletrico;
	}
	public void setDataEletrico(String dataEletrico) {
		this.dataEletrico = dataEletrico;
	}
	public String getHoraEletrico() {
		return horaEletrico;
	}
	public void setHoraEletrico(String horaEletrico) {
		this.horaEletrico = horaEletrico;
	}
	public String getReOperadorEletrico() {
		return reOperadorEletrico;
	}
	public void setReOperadorEletrico(String reOperadorEletrico) {
		this.reOperadorEletrico = reOperadorEletrico;
	}
	public String getNmOperadorEletrico() {
		return nmOperadorEletrico;
	}
	public void setNmOperadorEletrico(String nmOperadorEletrico) {
		this.nmOperadorEletrico = nmOperadorEletrico;
	}
	public String getIdPostoEletrico() {
		return idPostoEletrico;
	}
	public void setIdPostoEletrico(String idPostoEletrico) {
		this.idPostoEletrico = idPostoEletrico;
	}
	public String getStatusEfeitoEletrico() {
		return statusEfeitoEletrico;
	}
	public void setStatusEfeitoEletrico(String statusEfeitoEletrico) {
		this.statusEfeitoEletrico = statusEfeitoEletrico;
	}
	public String getDataVisual() {
		return dataVisual;
	}
	public void setDataVisual(String dataVisual) {
		this.dataVisual = dataVisual;
	}
	public String getHoraVisual() {
		return horaVisual;
	}
	public void setHoraVisual(String horaVisual) {
		this.horaVisual = horaVisual;
	}
	public String getReOperadorVisual() {
		return reOperadorVisual;
	}
	public void setReOperadorVisual(String reOperadorVisual) {
		this.reOperadorVisual = reOperadorVisual;
	}
	public String getNmOperadorVisual() {
		return nmOperadorVisual;
	}
	public void setNmOperadorVisual(String nmOperadorVisual) {
		this.nmOperadorVisual = nmOperadorVisual;
	}
	public String getIdPostoVisual() {
		return idPostoVisual;
	}
	public void setIdPostoVisual(String idPostoVisual) {
		this.idPostoVisual = idPostoVisual;
	}
	public String getTempoTesteVisual() {
		return tempoTesteVisual;
	}
	public void setTempoTesteVisual(String tempoTesteVisual) {
		this.tempoTesteVisual = tempoTesteVisual;
	}
	public String getStatusEfeitoVisual() {
		return statusEfeitoVisual;
	}
	public void setStatusEfeitoVisual(String statusEfeitoVisual) {
		this.statusEfeitoVisual = statusEfeitoVisual;
	}
	public String getDataPassagem() {
		return dataPassagem;
	}
	public void setDataPassagem(String dataPassagem) {
		this.dataPassagem = dataPassagem;
	}
	public String getHoraPassagem() {
		return horaPassagem;
	}
	public void setHoraPassagem(String horaPassagem) {
		this.horaPassagem = horaPassagem;
	}
	public String getReOperadorPassagem() {
		return reOperadorPassagem;
	}
	public void setReOperadorPassagem(String reOperadorPassagem) {
		this.reOperadorPassagem = reOperadorPassagem;
	}
	public String getNmOperadorPassagem() {
		return nmOperadorPassagem;
	}
	public void setNmOperadorPassagem(String nmOperadorPassagem) {
		this.nmOperadorPassagem = nmOperadorPassagem;
	}
	public String getIdPostoPassagem() {
		return idPostoPassagem;
	}
	public void setIdPostoPassagem(String idPostoPassagem) {
		this.idPostoPassagem = idPostoPassagem;
	}
	public String getStatusEfeitoPassagem() {
		return statusEfeitoPassagem;
	}
	public void setStatusEfeitoPassagem(String statusEfeitoPassagem) {
		this.statusEfeitoPassagem = statusEfeitoPassagem;
	}
	public String getDataReprocesso() {
		return dataReprocesso;
	}
	public void setDataReprocesso(String dataReprocesso) {
		this.dataReprocesso = dataReprocesso;
	}
	public String getHoraReprocesso() {
		return horaReprocesso;
	}
	public void setHoraReprocesso(String horaReprocesso) {
		this.horaReprocesso = horaReprocesso;
	}
	public String getReOperadorReprocesso() {
		return reOperadorReprocesso;
	}
	public void setReOperadorReprocesso(String reOperadorReprocesso) {
		this.reOperadorReprocesso = reOperadorReprocesso;
	}
	public String getNmOperadorReprocesso() {
		return nmOperadorReprocesso;
	}
	public void setNmOperadorReprocesso(String nmOperadorReprocesso) {
		this.nmOperadorReprocesso = nmOperadorReprocesso;
	}
	public String getIdPostoReprocesso() {
		return idPostoReprocesso;
	}
	public void setIdPostoReprocesso(String idPostoReprocesso) {
		this.idPostoReprocesso = idPostoReprocesso;
	}
	public String getComponenteMontado1Reprocesso() {
		return componenteMontado1Reprocesso;
	}
	public void setComponenteMontado1Reprocesso(String componenteMontado1Reprocesso) {
		this.componenteMontado1Reprocesso = componenteMontado1Reprocesso;
	}
	public String getComponenteMontado2Reprocesso() {
		return componenteMontado2Reprocesso;
	}
	public void setComponenteMontado2Reprocesso(String componenteMontado2Reprocesso) {
		this.componenteMontado2Reprocesso = componenteMontado2Reprocesso;
	}
	public String getDataSaidaReprocesso() {
		return dataSaidaReprocesso;
	}
	public void setDataSaidaReprocesso(String dataSaidaReprocesso) {
		this.dataSaidaReprocesso = dataSaidaReprocesso;
	}
	public String getHoraSaidaReprocesso() {
		return horaSaidaReprocesso;
	}
	public void setHoraSaidaReprocesso(String horaSaidaReprocesso) {
		this.horaSaidaReprocesso = horaSaidaReprocesso;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public String getDsComponenteMontado1() {
		return dsComponenteMontado1;
	}
	public void setDsComponenteMontado1(String dsComponenteMontado1) {
		this.dsComponenteMontado1 = dsComponenteMontado1;
	}
	public String getDsComponenteMontado2() {
		return dsComponenteMontado2;
	}
	public void setDsComponenteMontado2(String dsComponenteMontado2) {
		this.dsComponenteMontado2 = dsComponenteMontado2;
	}
	
	public String getCabecalho(ExpArquivoExportadoDTO arquivo){
		StringBuilder s = new StringBuilder();

		if (arquivo.isGravarCabecalho() == true){
			//header 1
			s.append("Dados do Produto;"); // Plataforma
			s.append(";"); // SKU
			s.append(";"); // Complemento
			s.append(";"); // NS
			s.append(";"); // Supervisor RE
			s.append(";"); // Supervisor
			s.append("Montagem;"); // data
			s.append(";"); // hora
			s.append(";"); // RE Operador
			s.append(";"); // Operador
			s.append(";"); // Id posto
			s.append(";"); // Status
			s.append(";"); // Placa potencia
			s.append(";"); // Placa eletronica
			s.append(";"); // Placa potencia
			s.append(";"); // Placa eletronica
			s.append("Teste funcional;"); // Data
			s.append(";"); // hora
			s.append(";"); // RE Operador
			s.append(";"); // Operador
			s.append(";"); // Id Posto
			s.append(";"); // Tempo teste
			s.append(";"); // Status
			s.append("Teste visual;"); // Data
			s.append(";"); // hora
			s.append(";"); // RE Operador
			s.append(";"); // Nome operador
			s.append(";"); // Id Posto
			s.append(";"); // Status
			s.append("Teste elétrico;"); // Data
			s.append(";"); // HOra
			s.append(";"); // RE Operador
			s.append(";"); // Operador
			s.append(";"); // Id Posto
			s.append(";"); // Status
			s.append("Reprocesso"); // Data
			s.append(";"); // Hora
			s.append(";"); // RE Operador
			s.append(";"); // Nome Operador
			s.append(";"); // Id Posto
			s.append(";"); // Placa potencia
			s.append(";"); // Placa eletronica
			s.append(";"); // Data saida
			s.append(";"); // Hora saida
			s.append(";"); // Causa
			s.append(";"); // Acao
			s.append("\n");
	
			//header 2
			//Dados do Produto
			s.append("Plataforma;"); // Plataforma
			s.append("SKU;"); // SKU
			s.append("Tensão/Cor/Voltagem;"); // Complemento
			s.append("NS;"); // NS
			s.append("RE Supervisor;"); // Supervisor RE
			s.append("Supervisor;"); // Supervisor
			s.append("Data;"); // data
			s.append("Hora;"); // hora
			s.append("RE Operador;"); // RE Operador
			s.append("Operador;"); // Operador
			s.append("Posto;"); // Id posto
			s.append("Status/Efeito;"); // Status
			s.append("Componente Montado;"); // Placa potencia
			s.append("Descrição;"); // Placa potencia
			s.append("Componente Montado;"); // Placa eletronica
			s.append("Descrição;"); // Placa potencia
			s.append("Data;"); // Data teste funcional
			s.append("Hora;"); // hora
			s.append("RE Operador;"); // RE Operador
			s.append("Operador;"); // Operador
			s.append("Posto;"); // Id Posto
			s.append("Duração teste;"); // Tempo teste
			s.append("Status/Efeito;"); // Status
			s.append("Data;"); // Data Teste visual
			s.append("Hora;"); // hora
			s.append("RE Operador;"); // RE Operador
			s.append("Operador;"); // Nome operador
			s.append("Posto;"); // Id Posto
			s.append("Statu/Efeito;"); // Status
			s.append("Data;"); // Data Teste elétrico
			s.append("Hora;"); // HOra
			s.append("RE Operador;"); // RE Operador
			s.append("Operador;"); // Operador
			s.append("Posto;"); // Id Posto
			s.append("Status/Efeito;"); // Status
			s.append("Data;"); // DataReprocesso
			s.append("Hora;"); // Hora
			s.append("RE Operador;"); // RE Operador
			s.append("Operador;"); // Nome Operador
			s.append("Posto;"); // Id Posto
			s.append("Componente Montado;"); // Placa potencia
			s.append("Descrição;"); // Placa potencia
			s.append("Componente Montado;"); // Placa eletronica
			s.append("Descrição;"); // Placa potencia
			s.append("Data saida;"); // Data saida
			s.append("Hora saida;"); // Hora saida
			s.append("Causa;"); // Causa
			s.append("Ação;"); // Acao
			s.append("\n");
			arquivo.setGravarCabecalho(false);
		}
		return s.toString();
	}
	public String getLinhaExportada(){
		StringBuilder s = new StringBuilder();
		
		s.append("\n");
		//			//Dados do Produto
		//			s.append("Plataforma;");
		s.append(TrataNULL(getPlataforma())); s.append(";");
		s.append(TrataNULL(getSku())); s.append(";");
		s.append(TrataNULL(getComplemento())); s.append(";");
		s.append(TrataNULL(getNs())); s.append(";");
		s.append(TrataNULL(getReSupervisor())); s.append(";");
		s.append(TrataNULL(getNmSupervisor())); s.append(";");
		
		//			//Montagem - Associação de NS
		//				s.append("Data;");
		s.append(TrataNULL(getDataMontagem())); s.append(";");	
		s.append(TrataNULL(getHoraMontagem())); s.append(";");
		s.append(TrataNULL(getReOperador())); s.append(";");
		s.append(TrataNULL(getNmOperador())); s.append(";");		
		s.append(TrataNULL(getIdPostoMontagem())); s.append(";");
		s.append(TrataNULL(getStatusEfeitoMontagem())); s.append(";");
		s.append(TrataNULL(getComponenteMontado1())); s.append(";");
		s.append(TrataNULL(getDsComponenteMontado1())); s.append(";");
		s.append(TrataNULL(getComponenteMontado2())); s.append(";");
		s.append(TrataNULL(getDsComponenteMontado2())); s.append(";");

		s.append(TrataNULL(getDataFuncional()));  s.append(";");// Data teste funcional
		s.append(TrataNULL(getHoraFuncional()));  s.append(";");// hora
		s.append(TrataNULL(getReOperadorFuncional()));  s.append(";");// RE Operador
		s.append(TrataNULL(getNmOperadorFuncional()));  s.append(";");// Operador
		s.append(TrataNULL(getIdPostoFuncional()));  s.append(";");// Id Posto
		s.append(TrataNULL(getDuracaoFuncional()));  s.append(";");// Tempo teste
		s.append(TrataNULL(getStatusEfeitoFuncional()));  s.append(";");// Status

		
		//			//Testa passa / código defeito
		s.append(TrataNULL(getDataVisual())); s.append(";");	
		s.append(TrataNULL(getHoraVisual())); s.append(";");
		s.append(TrataNULL(getReOperadorVisual())); s.append(";");
		s.append(TrataNULL(getNmOperadorVisual())); s.append(";");		
		s.append(TrataNULL(getIdPostoVisual())); s.append(";");
		s.append(TrataNULL(getStatusEfeitoVisual())); s.append(";");

		
		//			//Teste passa / não passa
		//				s.append("Data;");
		s.append(TrataNULL(getDataEletrico())); s.append(";");	
		s.append(TrataNULL(getHoraEletrico())); s.append(";");
		s.append(TrataNULL(getReOperadorEletrico())); s.append(";");
		s.append(TrataNULL(getNmOperadorEletrico())); s.append(";");		
		s.append(TrataNULL(getIdPostoEletrico())); s.append(";");
		s.append(TrataNULL(getStatusEfeitoEletrico())); s.append(";");

		
		
		//			//Apenas registro de passagem
		//				s.append("Data;");
//		s.append(getDataPassagem()); s.append(";");	
//		s.append(getHoraPassagem()); s.append(";");
//		s.append(getReOperadorPassagem()); s.append(";");
//		s.append(getNmOperadorPassagem()); s.append(";");		
//		s.append(getIdPostoPassagem()); s.append(";");
//		s.append(getStatusEfeitoPassagem()); s.append(";");

		//			//Reprocesso causa-ação
		//				s.append("Data;");
		s.append(TrataNULL(getDataReprocesso())); s.append(";");	
		s.append(TrataNULL(getHoraReprocesso())); s.append(";");
		s.append(TrataNULL(getReOperadorReprocesso())); s.append(";");
		s.append(TrataNULL(getNmOperadorReprocesso())); s.append(";");		
		s.append(TrataNULL(getIdPostoReprocesso())); s.append(";");
		s.append(TrataNULL(getComponenteMontado1Reprocesso())); s.append(";");
		s.append(TrataNULL(getDsComponenteMontado1Reprocesso())); s.append(";");
		s.append(TrataNULL(getComponenteMontado2Reprocesso())); s.append(";");
		s.append(TrataNULL(getDsComponenteMontado2Reprocesso())); s.append(";");
		s.append(TrataNULL(getDataSaidaReprocesso())); s.append(";");
		s.append(TrataNULL(getHoraSaidaReprocesso())); s.append(";");
		s.append(TrataNULL(getCausa())); s.append(";");
		s.append(TrataNULL(getAcao())); s.append(";");

		return s.toString();
	}
	private String TrataNULL(String texto){
		return texto != null ? texto : "";
	}

}
