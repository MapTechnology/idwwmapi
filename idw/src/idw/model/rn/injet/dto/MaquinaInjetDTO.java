package idw.model.rn.injet.dto;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.injet.Ijgrpinj;
import idw.model.pojos.injet.Ijlogope;
import idw.model.pojos.injet.Ijmolpro;
import idw.model.pojos.injet.Ijreapar;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.Ijtbmol;
import idw.model.pojos.injet.Ijtbpro;
import idw.model.pojos.injet.VMaqAnoBi;
import idw.model.pojos.injet.VMaqAnoPa;
import idw.model.pojos.injet.VMaqDataBi;
import idw.model.pojos.injet.VMaqDataPa;
import idw.model.pojos.injet.VMaqMesBi;
import idw.model.pojos.injet.VMaqMesPa;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.DiversosInjetRN;
import idw.model.rn.injet.FuncoesApoioInjet;


@SuppressWarnings("serial")
public class MaquinaInjetDTO implements Serializable{

	public static int FRENTE_NAMETA = 0; 
	public static int FRENTE_SEMCONEXAO = 1;
	public static int FRENTE_PARADA = 2;
	public static int FRENTE_FORAMETA = 3;

	public static String DS_FRENTE_NAMETA = "NAMETA"; 
	public static String DS_FRENTE_SEMCONEXAO = "SEMCONEXAO";
	public static String DS_FRENTE_PARADA = "PARADA";
	public static String DS_FRENTE_FORAMETA = "FORAMETA";
	public static String DS_FRENTE_TODAS = "TODAS";

	public static int FUNDO_PARADASEMPESO = 4;
	public static int FUNDO_AGUARDANDOMOLDE = 5;
	public static int FUNDO_PARADANAOINFORMADA = 6;
	public static int FUNDO_OPCONCLUIDA = 7;
	public static int FUNDO_IRMAIOR = 8;
	public static int FUNDO_ALERTA = 9;
	public static int FUNDO_ALERTAINSPECAO = 10;
	public static int FUNDO_OPA90 = 11;
	public static int FUNDO_VAZIO = 12;

	public static String DS_FUNDO_PARADASEMPESO = "PARADASEMPESO";
	public static String DS_FUNDO_AGUARDANDOMOLDE = "AGUARDANDOMOLDE";
	public static String DS_FUNDO_PARADANAOINFORMADA = "PARADANAOINFORMADA";
	public static String DS_FUNDO_OPCONCLUIDA = "OPCONCLUIDA";
	public static String DS_FUNDO_IRMAIOR = "IRMAIOR";
	public static String DS_FUNDO_ALERTA = "ALERTA";
	public static String DS_FUNDO_ALERTAINSPECAO = "ALERTAINSPECAO";
	public static String DS_FUNDO_OPA90 = "OPA90";
	public static String DS_FUNDO_VAZIO = "VAZIO";
	public static String DS_FUNDO_TODAS = "TODAS";

	public static String DS_OPERADOR_COM = "COMOPERADOR";
	public static String DS_OPERADOR_SEM = "SEMOPERADOR";
	public static String DS_OPERADOR_TODOS = "TODOSOPERADORES";

	private String cdMaquina;
	private String dsMaquina;
	private String nrop;
	private Ijtbinj ijtbinj;

	private Ijtbmol ijtbmolAtualNaMaquina;
	
	private int corFrente;
	private int corFundo;
	
	private List<DadosParaECPonderadaInjetDTO> dadosECPonderada = new ArrayList<DadosParaECPonderadaInjetDTO>();
	private List<Ijlogope> operadoresTurno = new ArrayList<Ijlogope>();
	private List<Ijlogope> operadoresAcumulado = new ArrayList<Ijlogope>();
	private List<ParadaInjetDTO> paradas = new ArrayList<ParadaInjetDTO>();
	private List<RefugoInjetDTO> refugos = new ArrayList<RefugoInjetDTO>();
	private List<ProdutoInjetDTO> produtos = new ArrayList<ProdutoInjetDTO>();
	private List<Ijgrpinj> gruposQueMaquinaPertence = new ArrayList<Ijgrpinj>();
	private List<TrocaOPInjetDTO> trocasDeOP = new ArrayList<TrocaOPInjetDTO>();
	private List<AlertaInjetDTO> alertas = new ArrayList<AlertaInjetDTO>();
	private List<CicloInjetDTO> ciclos = new ArrayList<CicloInjetDTO>();

	private String cdLingua;
	private BigDecimal eo_padrao;
	private BigDecimal ec_padrao;
	private BigDecimal ir_padrao;
	private Date dthrITurno;
	private Date dthrFTurno;

	private MaquinaTotalInjetDTO maquinaTotalDTO = new MaquinaTotalInjetDTO();
	private MaquinaPlanejamentoInjetDTO maquinaPlanejamentoDTO = new MaquinaPlanejamentoInjetDTO();
	
	private ParadaInjetDTO paradaAtualUltimaParada = new ParadaInjetDTO();
	
	/**
	 * @return the maquinaTotalDTO
	 */
	public MaquinaTotalInjetDTO getMaquinaTotalDTO() {
		return maquinaTotalDTO;
	}

	/**
	 * @param maquinaTotalDTO the maquinaTotalDTO to set
	 */
	public void setMaquinaTotalDTO(MaquinaTotalInjetDTO maquinaTotalDTO) {
		this.maquinaTotalDTO = maquinaTotalDTO;
	}

	/**
	 * @return the ijtbinj
	 */
	public Ijtbinj getIjtbinj() {
		return ijtbinj;
	}

	/**
	 * @param ijtbinj the ijtbinj to set
	 */
	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@Override
	public boolean equals(Object objeto){
		MaquinaInjetDTO maquinaPassada = (MaquinaInjetDTO) objeto;
		return (this.getIjtbinj().getCdinjetora().equals(maquinaPassada.getIjtbinj().getCdinjetora()));
	}

	public void addMaquinaDTO(MaquinaInjetDTO maquina){

		// Adiciona dados para eficiencia de ciclo ponderada
		try{
			for (DadosParaECPonderadaInjetDTO dado : maquina.getDadosECPonderada()){
				boolean isExiste = false;
				for (DadosParaECPonderadaInjetDTO dado2 : this.dadosECPonderada){
					if (dado2.equals(dado)){
						isExiste = true;
						dado2.setCicloPadrao(dado2.getCicloPadrao().add(dado.getCicloPadrao()));
						dado2.setQtCicloPadrao(dado2.getQtCicloPadrao() + dado.getQtCicloPadrao());
						dado2.setQtInjNormal(dado2.getQtInjNormal().add(dado.getQtInjNormal()));
						dado2.setTempoAtivo(dado2.getTempoAtivo().add(dado.getTempoAtivo()));
						dado2.setTmpCicNormal(dado2.getTmpCicNormal().add(dado.getTmpCicNormal()));
					}
				}
				if (isExiste == false){
					this.dadosECPonderada.add(dado);
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		// Adiciona os dados de total
		this.maquinaTotalDTO.addMaquinaTotalDTO(maquina.getMaquinaTotalDTO());

		// Adiciona os detalhes das paradas se os mesmos tiverem sido processados
		for (ParadaInjetDTO paradaRecebida : maquina.paradas){
			boolean isEncontrou = false;
			for (ParadaInjetDTO paradaDaInstancia : this.paradas){
				if (paradaDaInstancia.getCdParada().equals(paradaRecebida.getCdParada())){
					isEncontrou = true;
					paradaDaInstancia.addTempoParadaSegundos(paradaRecebida.getTempoParadaSegundos());
					paradaDaInstancia.setTempoTotal(this.maquinaTotalDTO.getTempoTotalSegundos().floatValue());
				}
			}
			if (isEncontrou == false){
				ParadaInjetDTO paradaNova = new ParadaInjetDTO();
				paradaNova.setCdParada(paradaRecebida.getCdParada());
				paradaNova.setDsParada(paradaRecebida.getDsParada());
				paradaNova.setParadaPesa(paradaRecebida.isParadaPesa());
				paradaNova.setTempoParadaSegundos(paradaRecebida.getTempoParadaSegundos());
				paradaNova.setTempoTotal(this.maquinaTotalDTO.getTempoTotalSegundos().floatValue());

				this.paradas.add(paradaNova);
			}

		}
	}

	/**
	 * @return the dadosECPonderada
	 */
	public List<DadosParaECPonderadaInjetDTO> getDadosECPonderada() {
		return dadosECPonderada;
	}

	/**
	 * @param dadosECPonderada the dadosECPonderada to set
	 */
	public void setDadosECPonderada(List<DadosParaECPonderadaInjetDTO> dadosECPonderada) {
		this.dadosECPonderada = dadosECPonderada;
	}

	public void addDadosECPonderada(DadosParaECPonderadaInjetDTO dadosECPonderada) {
		this.dadosECPonderada.add(dadosECPonderada);
	}

	/**
	 * @return the operadoresTurno
	 */
	public List<Ijlogope> getOperadoresTurno() {
		return operadoresTurno;
	}

	public Ijlogope getOperadorPrincipalTurno() throws RegistroDesconhecidoException {
		Ijlogope retorno = null;
		int duracaoMaior = 0;
		if (operadoresTurno.size() <= 0)
			throw new RegistroDesconhecidoException();

		for (Ijlogope ijlogope : operadoresTurno){
			Date dthrflogou = ijlogope.getDthrlogout();
			if (dthrflogou == null)
				dthrflogou = DataHoraRN.getDataHoraAtual();
			
			int duracao = FuncoesApoioInjet.getEmSegundosIntersecaoHorarios(
					getDthrITurno(), 
					getDthrFTurno(), 
					ijlogope.getId().getDthrlogin(), 
					dthrflogou);
			
			if (duracao >= duracaoMaior){
				retorno = operadoresTurno.get(0);
			}
		}
		return retorno;
	}

	/**
	 * @param operadoresTurno the operadoresTurno to set
	 */
	public void setOperadoresTurno(List<Ijlogope> operadoresTurno) {
		this.operadoresTurno = operadoresTurno;
	}

	public void addOperadoresTurno(Ijlogope operadoresTurno) {
		this.operadoresTurno.add(operadoresTurno);
	}

	/**
	 * @return the operadoresAcumulado
	 */
	public List<Ijlogope> getOperadoresAcumulado() {
		return operadoresAcumulado;
	}

	/**
	 * @param operadoresAcumulado the operadoresAcumulado to set
	 */
	public void setOperadoresAcumulado(
			List<Ijlogope> operadoresAcumulado) {
		this.operadoresAcumulado = operadoresAcumulado;
	}

	public void addOperadoresAcumulado(
			Ijlogope operadoresAcumulado) {
		this.operadoresAcumulado.add(operadoresAcumulado);
	}

	/**
	 * @return the dthrITurno
	 */
	public Date getDthrITurno() {
		return dthrITurno;
	}

	/**
	 * @param dthrITurno the dthrITurno to set
	 */
	public void setDthrITurno(Date dthrITurno) {
		this.dthrITurno = dthrITurno;
	}

	/**
	 * @return the dthrFTurno
	 */
	public Date getDthrFTurno() {
		return dthrFTurno;
	}

	/**
	 * @param dthrFTurno the dthrFTurno to set
	 */
	public void setDthrFTurno(Date dthrFTurno) {
		this.dthrFTurno = dthrFTurno;
	}

	/**
	 * @return the cdMaquina
	 */
	public String getCdMaquina() {
		return cdMaquina;
	}

	/**
	 * @param cdMaquina the cdMaquina to set
	 */
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}

	/**
	 * @return the nrop
	 */
	public String getNrop() {
		return nrop;
	}

	/**
	 * @param nrop the nrop to set
	 */
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	/**
	 * @return the paradas
	 */
	public List<ParadaInjetDTO> getParadas() {
		return paradas;
	}

	/**
	 * @param paradas the paradas to set
	 */
	public void setParadas(List<ParadaInjetDTO> paradas) {
		this.paradas = paradas;
	}

	/**
	 * @return the dsMaquina
	 */
	public String getDsMaquina() {
		return dsMaquina;
	}

	public void addParadasPorMotivo(Ijreapar ijreapar, BigDecimal tempoParada, boolean isParadaPesa){
		if (tempoParada.floatValue() > 0){
			boolean isEncontrou = false;
			for (ParadaInjetDTO parada : this.paradas){
				if (parada.getCdParada().equals(ijreapar.getIjtbpar().getCdparada())){
					parada.addTempoParadaSegundos(tempoParada.floatValue());
					isEncontrou = true;
				}
			}
			if (isEncontrou == false){
				ParadaInjetDTO parada = new ParadaInjetDTO();
				parada.setCdParada(ijreapar.getIjtbpar().getCdparada());
				parada.setDsParada(ijreapar.getIjtbpar().getDsparada());
				parada.setTempoParadaSegundos(tempoParada.floatValue());
				parada.setParadaPesa(isParadaPesa);
				parada.setDsAreaResponsavel(ijreapar.getIjtbpar().getIjareres().getDsarea());
				this.paradas.add(parada);
			}
		}
	}

	public void addParadasPorArea(Ijreapar ijreapar, BigDecimal tempoParada){
		if (tempoParada.floatValue() > 0){
			boolean isEncontrou = false;
			for (ParadaInjetDTO parada : this.paradas){
				if (parada.getCdParada().equals(ijreapar.getIjtbpar().getIjareres().getCdarea())){
					parada.addTempoParadaSegundos(tempoParada.floatValue());
					isEncontrou = true;
				}
			}
			if (isEncontrou == false){
				ParadaInjetDTO parada = new ParadaInjetDTO();
				parada.setCdParada(ijreapar.getIjtbpar().getIjareres().getCdarea());
				parada.setDsParada(ijreapar.getIjtbpar().getIjareres().getDsarea());
				parada.setTempoParadaSegundos(tempoParada.floatValue());
				parada.setDsAreaResponsavel(parada.getDsParada());
				parada.setParadaPesa(true);
				this.paradas.add(parada);
			}
		}
	}
	/**
	 * @param dsMaquina the dsMaquina to set
	 */
	public void setDsMaquina(String dsMaquina) {
		this.dsMaquina = dsMaquina;
	}

	public List<ProdutoInjetDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoInjetDTO> produtos) {
		this.produtos = produtos;
	}

	public String getPeriodoTurno(){
		String retorno = "desconhecido";
		if (this.dthrITurno != null){
			int hora = DataHoraRN.getHourAsInt(this.dthrITurno);
			if ( hora > 6 && hora < 12){
				retorno = "Matutino";
			} else if (hora >= 12 && hora <= 18){
				retorno = "Vespertino";
			} else {
				retorno = "Noturno";
			}
		}
		return retorno;
	}

	public List<Ijgrpinj> getGruposQueMaquinaPertence() {
		return gruposQueMaquinaPertence;
	}

	public void setGruposQueMaquinaPertence(List<Ijgrpinj> gruposQueMaquinaPertence) {
		this.gruposQueMaquinaPertence = gruposQueMaquinaPertence;
	}

	public Ijgrpinj getPrincipalGrupoDaMaquina() throws RegistroDesconhecidoException{
		Ijgrpinj retorno = null;

		if (this.gruposQueMaquinaPertence.size() <= 0)
			throw new RegistroDesconhecidoException();

		for (Ijgrpinj ijgrpinj : this.gruposQueMaquinaPertence){
			if (!ijgrpinj.getCdgrpinj().equals("000001") && !ijgrpinj.getCdgrpinj().equals("999999")){
				retorno = ijgrpinj;
				break;
			}
		}

		return retorno;
	}

	public void addProdutos(Set<Ijmolpro> ijmolpros){
		for (Ijmolpro ijmolpro : ijmolpros){

			boolean isExiste = false;
			for (ProdutoInjetDTO reg : this.produtos){
				if (reg.getIjtbpro().getCdproduto().equals(ijmolpro.getIjtbpro().getCdproduto())){
					isExiste = true;
					break;
				}
			}
			if (isExiste == false){
				ProdutoInjetDTO produtoDTO = new ProdutoInjetDTO();
				Ijtbpro ijtbproclone = new Ijtbpro();
				ijtbproclone.setAcabamento(ijmolpro.getIjtbpro().getAcabamento());
				ijtbproclone.setCdproduto(ijmolpro.getIjtbpro().getCdproduto());
				ijtbproclone.setDsproduto(ijmolpro.getIjtbpro().getDsproduto());
				produtoDTO.setIjtbpro(ijtbproclone);
				produtoDTO.setQtcavativas(new BigDecimal(ijmolpro.getQtcavativas()));
				produtoDTO.setQtcavidades(new BigDecimal(ijmolpro.getQtcavidades()));
				this.produtos.add(produtoDTO);
			}
		}
	}

	public ProdutoInjetDTO getProduto(String cdProduto){
		ProdutoInjetDTO retorno = null;
		for (ProdutoInjetDTO reg : this.produtos){
			if (reg.getIjtbpro().getCdproduto().equals(cdProduto)){
				retorno = reg;
			}
		}
		return retorno;
	}

	public List<TrocaOPInjetDTO> getTrocasDeOP() {
		return trocasDeOP;
	}

	public void setTrocasDeOP(List<TrocaOPInjetDTO> trocasDeOP) {
		this.trocasDeOP = trocasDeOP;
	}
	
	public void addTrocaOP(TrocaOPInjetDTO trocaOP){
		this.trocasDeOP.add(trocaOP);
	}

	public BigDecimal getTempoRealSetup(String nrop){
		BigDecimal retorno = new BigDecimal(0);

		if (trocasDeOP != null){
			for (TrocaOPInjetDTO trocaop : trocasDeOP){
				if (trocaop.getNropEntrando().equals(nrop))
					retorno = new BigDecimal(trocaop.getTempoRealSetup().floatValue() / 3600f);
			}
		}
		return retorno;
	}

	public BigDecimal getTempoPlanejadoSetup(String nrop){
		BigDecimal retorno = new BigDecimal(0);

		if (trocasDeOP != null){
			for (TrocaOPInjetDTO trocaop : trocasDeOP){
				if (trocaop.getNropEntrando().equals(nrop)){
					retorno = trocaop.getTempoPlanejadoSetup();
				}
			}
		}
		return retorno;
	}
	
	public BigDecimal getHorasHomem(BigDecimal tempoOperacao){
		return tempoOperacao.multiply(new BigDecimal(this.operadoresTurno.size()));
	}
	
	public BigDecimal getTotalHorasLoginsOperadores(Session sessao, String cdTurno, Date dthrITurno, Date dthrFTurno){
		BigDecimal retorno = new BigDecimal(0);
		DiversosInjetRN diversosRN = new DiversosInjetRN(null);
		diversosRN.setDaoSession(sessao);

		Date dthr = diversosRN.getDtHrSistemaDeIjtreal();

		for (Ijlogope ijlogope : this.operadoresTurno){
			BigDecimal duracaoLogon = null;
			
//			if (ijlogope.getNrop().equals("101570"))
//				//System.out.println("101570");
			Date dthrLogout = ijlogope.getDthrlogout();
			
			if (dthrLogout == null)
				dthrLogout = dthr;
				
			duracaoLogon = new BigDecimal(FuncoesApoioInjet.getEmSegundosIntersecaoHorarios(
					dthrITurno,
					dthrFTurno,
					ijlogope.getId().getDthrlogin(), 
					dthrLogout
					) );

			retorno = retorno.add(new BigDecimal(duracaoLogon.floatValue() / 3600f));
			
//			//System.out.println("inicio " + ijlogope.getId().getDthrlogin() + " - fim " + ijlogope.getDthrlogout() + " = " + duracaoLogon);
		}
//		if (retorno.longValue() < 0)
//			//System.out.println("debugar");
		return retorno;
	}
	
	public void addVMaqDataBi(VMaqDataBi vm){
		MaquinaTotalInjetDTO maqtot = new MaquinaTotalInjetDTO();
		
		maqtot.setCicloMedio(vm.getSegCiclomedio());
		maqtot.setCicloPadrao(vm.getSegCiclopadrao());
		
		maqtot.setTempoAtivoSegundos(vm.getSegTempoativo());
		maqtot.setTempoParadaSegundos(vm.getSegTempoparada());
		maqtot.setTempoParadaSemPesoSegundos(vm.getSegTempoparadaSp());
		maqtot.setTempoCicloProdutivoSegundos(vm.getSegCicloprodutivo());
		maqtot.setTempoCicloImprodutivoSegundos(vm.getSegCicloimprodutivo());
		maqtot.setTempoTrabalhadoSegundos(vm.getSegTempotrabalhado());
		maqtot.setTempoRefugoSegundos(vm.getSegTemporefugadas());
		maqtot.setTempoRitmoSegundos(vm.getSegRitmo());
		maqtot.setTempoProdutivasSegundos(vm.getSegTempoprodutivas());
		maqtot.setTempoDisponiveisSegundos(vm.getSegTempodisponivel());
		maqtot.setTempoPerdaCicloSegundos(vm.getSegPerdaciclo());
		maqtot.setPerdaParadasUnidade(new BigDecimal(vm.getPcsPerdaparada()));
		maqtot.setPerdaParadasSemPesoUnidade(new BigDecimal(vm.getPcsPerdaparadaSp()));
		maqtot.setPerdaCicloUnidade(vm.getPcsPerdaciclo());
		maqtot.setPerdaCavidadeUnidade(new BigDecimal(vm.getPcsPerdacavidades()));
		maqtot.setProducaoBrutaUnidade(new BigDecimal(vm.getPcsProducaobruta()));
		maqtot.setProducaoRefugadaUnidade(new BigDecimal(vm.getPcsProducaorefugada()));
		maqtot.setProducaoPrevistaUnidade(new BigDecimal(vm.getPcsProducaoprevista()));
		maqtot.setTempoCorrecaoCTT(vm.getSegCtt());
		maqtot.setTempoPerdaCavidadeSegundos(vm.getSegPerdacav());

		maquinaTotalDTO.addMaquinaTotalDTO(maqtot);
		
	}

	public void addVMaqMesBi(VMaqMesBi vm){
		MaquinaTotalInjetDTO maqtot = new MaquinaTotalInjetDTO();
		
		maqtot.setCicloMedio(vm.getSegCiclomedio());
		maqtot.setCicloPadrao(vm.getSegCiclopadrao());
		
		maqtot.setTempoAtivoSegundos(vm.getSegTempoativo());
		maqtot.setTempoParadaSegundos(vm.getSegTempoparada());
		maqtot.setTempoParadaSemPesoSegundos(vm.getSegTempoparadaSp());
		maqtot.setTempoCicloProdutivoSegundos(vm.getSegCicloprodutivo());
		maqtot.setTempoCicloImprodutivoSegundos(vm.getSegCicloimprodutivo());
		maqtot.setTempoTrabalhadoSegundos(vm.getSegTempotrabalhado());
		maqtot.setTempoRefugoSegundos(vm.getSegTemporefugadas());
		maqtot.setTempoRitmoSegundos(vm.getSegRitmo());
		maqtot.setTempoProdutivasSegundos(vm.getSegTempoprodutivas());
		maqtot.setTempoDisponiveisSegundos(vm.getSegTempodisponivel());
		maqtot.setTempoPerdaCicloSegundos(vm.getSegPerdaciclo());
		maqtot.setPerdaParadasUnidade(new BigDecimal(vm.getPcsPerdaparada()));
		maqtot.setPerdaParadasSemPesoUnidade(new BigDecimal(vm.getPcsPerdaparadaSp()));
		maqtot.setPerdaCicloUnidade(vm.getPcsPerdaciclo());
		maqtot.setPerdaCavidadeUnidade(new BigDecimal(vm.getPcsPerdacavidades()));
		maqtot.setProducaoBrutaUnidade(new BigDecimal(vm.getPcsProducaobruta()));
		maqtot.setProducaoRefugadaUnidade(new BigDecimal(vm.getPcsProducaorefugada()));
		maqtot.setProducaoPrevistaUnidade(new BigDecimal(vm.getPcsProducaoprevista()));
		maqtot.setTempoCorrecaoCTT(vm.getSegCtt());
		maqtot.setTempoPerdaCavidadeSegundos(vm.getSegPerdacav());

		maquinaTotalDTO.addMaquinaTotalDTO(maqtot);
		
	}

	public void addVMaqAnoBi(VMaqAnoBi vm){
		MaquinaTotalInjetDTO maqtot = new MaquinaTotalInjetDTO();
		
		maqtot.setCicloMedio(vm.getSegCiclomedio());
		maqtot.setCicloPadrao(vm.getSegCiclopadrao());
		
		maqtot.setTempoAtivoSegundos(vm.getSegTempoativo());
		maqtot.setTempoParadaSegundos(vm.getSegTempoparada());
		maqtot.setTempoParadaSemPesoSegundos(vm.getSegTempoparadaSp());
		maqtot.setTempoCicloProdutivoSegundos(vm.getSegCicloprodutivo());
		maqtot.setTempoCicloImprodutivoSegundos(vm.getSegCicloimprodutivo());
		maqtot.setTempoTrabalhadoSegundos(vm.getSegTempotrabalhado());
		maqtot.setTempoRefugoSegundos(vm.getSegTemporefugadas());
		maqtot.setTempoRitmoSegundos(vm.getSegRitmo());
		maqtot.setTempoProdutivasSegundos(vm.getSegTempoprodutivas());
		maqtot.setTempoDisponiveisSegundos(vm.getSegTempodisponivel());
		maqtot.setTempoPerdaCicloSegundos(vm.getSegPerdaciclo());
		maqtot.setPerdaParadasUnidade(new BigDecimal(vm.getPcsPerdaparada()));
		maqtot.setPerdaParadasSemPesoUnidade(new BigDecimal(vm.getPcsPerdaparadaSp()));
		maqtot.setPerdaCicloUnidade(vm.getPcsPerdaciclo());
		maqtot.setPerdaCavidadeUnidade(new BigDecimal(vm.getPcsPerdacavidades()));
		maqtot.setProducaoBrutaUnidade(new BigDecimal(vm.getPcsProducaobruta()));
		maqtot.setProducaoRefugadaUnidade(new BigDecimal(vm.getPcsProducaorefugada()));
		maqtot.setProducaoPrevistaUnidade(new BigDecimal(vm.getPcsProducaoprevista()));

		maquinaTotalDTO.addMaquinaTotalDTO(maqtot);
		
	}

	public void addVMaqDataPa(VMaqDataPa vm){
		boolean isEncontrou = false;
		for (ParadaInjetDTO parada : this.paradas){
			if (parada.getCdParada().equals(vm.getIjtbpar().getCdparada())){
				parada.addTempoParadaSegundos(vm.getSegTempoparada().floatValue());
				isEncontrou = true;
			}
		}
		if (isEncontrou == false){
			ParadaInjetDTO parada = new ParadaInjetDTO();
			parada.setCdParada(vm.getIjtbpar().getCdparada());
			parada.setDsParada(vm.getDsparada());
			parada.setTempoParadaSegundos(vm.getSegTempoparada().floatValue());
			if (vm.getParadaPesa().equals("SIM"))
				parada.setParadaPesa(true);
			else
				parada.setParadaPesa(false);
			
			parada.setDsAreaResponsavel("");
			this.paradas.add(parada);
		}
	}

	public void addVMaqMesPa(VMaqMesPa vm){
		boolean isEncontrou = false;
		for (ParadaInjetDTO parada : this.paradas){
			if (parada.getCdParada().equals(vm.getCdparada())){
				parada.addTempoParadaSegundos(vm.getSegTempoparada().floatValue());
				isEncontrou = true;
			}
		}
		if (isEncontrou == false){
			ParadaInjetDTO parada = new ParadaInjetDTO();
			parada.setCdParada(vm.getCdparada());
			parada.setDsParada(vm.getDsparada());
			parada.setTempoParadaSegundos(vm.getSegTempoparada().floatValue());
			if (vm.getParadaPesa().equals("SIM"))
				parada.setParadaPesa(true);
			else
				parada.setParadaPesa(false);
			
			parada.setDsAreaResponsavel("");
			this.paradas.add(parada);
		}
	}

	public void addVMaqAnoPa(VMaqAnoPa vm){
		boolean isEncontrou = false;
		for (ParadaInjetDTO parada : this.paradas){
			if (parada.getCdParada().equals(vm.getCdparada())){
				parada.addTempoParadaSegundos(vm.getSegTempoparada().floatValue());
				isEncontrou = true;
			}
		}
		if (isEncontrou == false){
			ParadaInjetDTO parada = new ParadaInjetDTO();
			parada.setCdParada(vm.getCdparada());
			parada.setDsParada(vm.getDsparada());
			parada.setTempoParadaSegundos(vm.getSegTempoparada().floatValue());
			if (vm.getParadaPesa().equals("SIM"))
				parada.setParadaPesa(true);
			else
				parada.setParadaPesa(false);
			
			parada.setDsAreaResponsavel("");
			this.paradas.add(parada);
		}
	}

	public int getCorFrente() {
		return corFrente;
	}

	public void setCorFrente(int corFrente) {
		this.corFrente = corFrente;
	}

	public int getCorFundo() {
		return corFundo;
	}

	public void setCorFundo(int corFundo) {
		this.corFundo = corFundo;
	}

	public MaquinaPlanejamentoInjetDTO getMaquinaPlanejamentoDTO() {
		return maquinaPlanejamentoDTO;
	}

	public void setMaquinaPlanejamentoDTO(
			MaquinaPlanejamentoInjetDTO maquinaPlanejamentoDTO) {
		this.maquinaPlanejamentoDTO = maquinaPlanejamentoDTO;
	}

	public String getCdLingua() {
		return cdLingua;
	}

	public void setCdLingua(String cdLingua) {
		this.cdLingua = cdLingua;
	}

	public BigDecimal getEo_padrao() {
		return eo_padrao;
	}

	public void setEo_padrao(BigDecimal eo_padrao) {
		this.eo_padrao = eo_padrao;
	}

	public BigDecimal getEc_padrao() {
		return ec_padrao;
	}

	public void setEc_padrao(BigDecimal ec_padrao) {
		this.ec_padrao = ec_padrao;
	}

	public BigDecimal getIr_padrao() {
		return ir_padrao;
	}

	public void setIr_padrao(BigDecimal ir_padrao) {
		this.ir_padrao = ir_padrao;
	}
	
	public boolean isOperadorLogado(){
		boolean retorno = false;
		for (Ijlogope ijlogope : this.operadoresTurno){
			if (ijlogope.getDthrlogout() == null){
				retorno = true;
				break;
			}
		}
		return retorno;
	}
	
	public String getDsStatus(){
		String retorno = "";
		if (corFrente == FRENTE_FORAMETA){
			retorno = "M�quina fora da meta";
		}
		if (corFrente == FRENTE_NAMETA){
			retorno = "M�quina na meta";
		}
		if (corFrente == FRENTE_PARADA){
			retorno = "M�quina parada";
		}
		if (corFundo == FUNDO_AGUARDANDOMOLDE){
			retorno += ", sem planejamento.";
		}
		if (corFundo == FUNDO_ALERTA){
			retorno += ", com alerta";
		}
		if (corFundo == FUNDO_ALERTAINSPECAO){
			retorno += ", inspe��o pendente.";
		}
		if (corFundo == FUNDO_IRMAIOR){
			retorno += ", refugo excessivo";
		}
		if (corFundo == FUNDO_OPA90){
			retorno += ", op a 90%.";
		}
		if (corFundo == FUNDO_OPCONCLUIDA){
			retorno += ", op concluida.";
		}
		if (corFundo == FUNDO_PARADANAOINFORMADA){
			retorno += ", parada n�o informada.";
		}
		if (corFundo == FUNDO_PARADASEMPESO){
			retorno += ", parada sem peso.";
		}
		if (isOperadorLogado() == true){
			retorno += " Com operador.";
		} else{
			retorno += " Sem operador.";
		}
		if (corFrente == FRENTE_SEMCONEXAO){
			retorno = "IC Off-line";
		}
		return retorno;
	}

	public ParadaInjetDTO getParadaAtualUltimaParada() {
		return paradaAtualUltimaParada;
	}

	public void setParadaAtualUltimaParada(ParadaInjetDTO paradaAtualUltimaParada) {
		this.paradaAtualUltimaParada = paradaAtualUltimaParada;
	}

	public List<AlertaInjetDTO> getAlertas() {
		return alertas;
	}

	public void setAlertas(List<AlertaInjetDTO> alertas) {
		this.alertas = alertas;
	}
	public void addAlertas(AlertaInjetDTO alerta){
		this.alertas.add(alerta);
	}

	public List<CicloInjetDTO> getCiclos() {
		return ciclos;
	}

	public void setCiclos(List<CicloInjetDTO> ciclos) {
		this.ciclos = ciclos;
	}
	
	public void addCiclo(CicloInjetDTO ciclo){
		this.ciclos.add(ciclo);
	}

	public List<RefugoInjetDTO> getRefugos() {
		return refugos;
	}

	public void setRefugos(List<RefugoInjetDTO> refugos) {
		this.refugos = refugos;
	}
	public void addRefugos(RefugoInjetDTO refugo){
		this.refugos.add(refugo);
	}

	public Ijtbmol getIjtbmolAtualNaMaquina() {
		return ijtbmolAtualNaMaquina;
	}

	public void setIjtbmolAtualNaMaquina(Ijtbmol ijtbmolAtualNaMaquina) {
		this.ijtbmolAtualNaMaquina = ijtbmolAtualNaMaquina;
	}
}
