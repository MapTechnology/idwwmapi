package idw.model.rn.exp;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;

import org.hibernate.Session;

import idw.model.pojos.DwExpcvspf;
import idw.webservices.dto.ExpArquivoExportadoDTO;
import idw.webservices.dto.ExpDetalheLinhaExportadaDTO;
import idw.webservices.dto.ExpLinhaExportadaDTO;
import idw.webservices.dto.ExportacaoDTO;
import idw.webservices.dto.ExportacaoModeloResumidoHorizontalDTO;
import idw.webservices.dto.FiltroExportacaoDTO;


public abstract class ExportacaoFactory {
	private Session session;
	protected FiltroExportacaoDTO filtro;

	public void setFiltro(FiltroExportacaoDTO filtro){
		this.filtro = filtro;
	}
	
	public StringBuilder getPlataformasEscolhidasParaIn(){
		StringBuilder retorno = new StringBuilder();
		boolean isPrimeiro = true;
		for (DwExpcvspf itemList : filtro.getFiltro().getDwExpcvspfs()) {
			DwExpcvspf subItem = (DwExpcvspf)itemList.clone();
			if (isPrimeiro == false){
				retorno.append(",");
			}
			if (subItem.getOmProgrp() != null){
				isPrimeiro = false;
				retorno.append("'");
				retorno.append(subItem.getOmProgrp().getCdProgrp());
				retorno.append("'");
			}
		}

		return retorno;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	/**
     * Creates a standalone DAOFactory that returns unmanaged DAO
     * beans for use in any environment Hibernate has been configured
     * for. Uses HibernateUtil/SessionFactory and Hibernate context
     * propagation (CurrentSessionContext), thread-bound or transaction-bound,
     * and transaction scoped.
     */
    @SuppressWarnings("unchecked")
	public static final Class _factory[] = 
		{
    	ExportacaoPadraoFactory.class,
    	ExportacaoPadraoFactory.class,
    	ExportacaoFullFactory.class
		};
 
    /**
     * Factory method for instantiation of concrete factories.
     */
	public static ExportacaoFactory instance(Class factory) {
        try {
            return (ExportacaoFactory)factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }

    // Add your DAO interfaces here
    public abstract ExportacaoDTO exportaCVS();

	protected String exportaModeloDetalhamentoTestes(ExpArquivoExportadoDTO arquivo){
		StringBuilder s = new StringBuilder();

		if (arquivo.isGravarCabecalho() == true){
			//s.append("Id;");
			s.append("Data;");
			s.append("hh:mm:ss.ff;");
			s.append("N� S�rie;");
			s.append("Etapa;");
			s.append("Sub-Etapa;");
			s.append("Status;");
			s.append("Corrente;");
			s.append("Tens�o;");
			s.append("Fluxo na Entrada;");
			s.append("Fluxo na Sa�da");

			arquivo.setGravarCabecalho(false);
		}
		
		SimpleDateFormat formatterData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:ss");

		for (ExpLinhaExportadaDTO linha : arquivo.getLinhas()){
			for (ExpDetalheLinhaExportadaDTO detalhe : linha.getDetalhes()){				
				s.append("\n");
//				s.append(detalhe.getIdReceita());
//				s.append(";");
				//			s.append("Data;");
				if (detalhe.getDthrMedicao() != null)
					s.append(formatterData.format(detalhe.getDthrMedicao()));
				else
					s.append("dt nula");
				s.append(";");
				//			s.append("hh:mm:ss.ff;");
				if (detalhe.getDthrMedicao() != null)
					s.append(formatterHora.format(detalhe.getDthrMedicao()) + ":" + detalhe.getMsDthrMedicao());
				else
					s.append("dt nula");
				s.append(";");
				//			s.append("N� S�rie;");
				s.append(TrataNULL(linha.getNserie()));
				s.append(";");
				//			s.append("Etapa;");
				s.append(TrataNULL(detalhe.getOrdemEtapa()));
				s.append(";");
				//			s.append("Sub-Etapa;");
				s.append(TrataNULL(detalhe.getOrdemSubetapa()));
				s.append(";");
				//			s.append("Status;");
				s.append(TrataNULL(detalhe.getStatus()));
				s.append(";");
				//			s.append("Corrente;");
				s.append(TrataNULL(detalhe.getCorrente()));
				s.append(";");
				//			s.append("Tens�o;");
				s.append(TrataNULL(detalhe.getTensao()));
				s.append(";");
				//			s.append("Fluxo na Entrada;");
				s.append(TrataNULL(detalhe.getDsFluxoEntrada()));
				s.append(";");
				//			s.append("Fluxo na Sa�da");
				s.append(TrataNULL(detalhe.getDsFluxoSaida()));
			}
		}
		return s.toString();
	}
	private String TrataNULL(String texto){
		return texto != null ? texto : "";
	}
	protected String exportaModeloResumidoEmpilhado(ExpArquivoExportadoDTO arquivo){
		StringBuilder s = new StringBuilder();

		if (arquivo.isGravarCabecalho() == true){
			//header
			s.append("TIPO DE DADO;");
			s.append("Data;");
			s.append("Hora;");
			s.append("Plataforma;");
			s.append("SKU;");
			s.append("Tensao/Cor/Versao;");
			s.append("N.Serie;");
			s.append("RE Supervisor;");
			s.append("Nome Supervisor;");
			s.append("RE Operador;");
			s.append("Nome Operador;");
			s.append("ID Posto;");
			s.append("Componente Montado;");
			s.append("Componente Montado;");
			s.append("Tempo de Teste;");
			s.append("Descricao do Efeito;");
			s.append("Status/Efeito;");
			s.append("Data Saida;");
			s.append("Hora Saida;");
			s.append("Descricao da Causa;");
			s.append("Causa;");
			s.append("Descricao da Acao;");
			s.append("Acao");
			arquivo.setGravarCabecalho(false);
		}
		SimpleDateFormat formatterData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:ss");

		for (ExpLinhaExportadaDTO linha : arquivo.getLinhas()){			
			s.append("\n");
			//			s.append("TIPO DE DADO;"); to do
			s.append(TrataNULL(linha.getFase()));
			s.append(";");
			//			s.append("Data;");
			if (linha.getDthr_Entrada() != null)
				s.append(formatterData.format(linha.getDthr_Entrada()));
			else
				s.append("");
			s.append(";");
			//			s.append("Hora;");
			if (linha.getDthr_Entrada() != null)
				s.append(formatterHora.format(linha.getDthr_Entrada()));
			else
				s.append("");

			s.append(";");
			//			s.append("Plataforma;"); to do
			s.append(TrataNULL(linha.getPlataforma()));
			s.append(";");
			//			s.append("SKU;");
			s.append(TrataNULL(linha.getSku()));
			s.append(";");
			//			s.append("Tens�o/Cor/Vers�o;"); to do
			s.append(TrataNULL(linha.getComplemento()));
			s.append(";");
			//			s.append("N� S�rie;");
			s.append(TrataNULL(linha.getNserie()));
			s.append(";");
			//			s.append("RE Supervisor;"); to do
			s.append(TrataNULL(linha.getMatriculaSupervisor()));
			s.append(";");
			//			s.append("Nome Supervisor;"); to do
			s.append(TrataNULL(linha.getNomeSupervisor()));
			s.append(";");			
			//			s.append("RE Operador;"); to do
			s.append(TrataNULL(linha.getMatriculaOperador()));
			s.append(";");
			//			s.append("Nome Operador;"); to do
			s.append(TrataNULL(linha.getNomeOperador()));
			s.append(";");			
			//			s.append("ID Posto;"); to do
			s.append(TrataNULL(linha.getIdPt()));
			s.append(";");
			//			s.append("Placa Pot�ncia;"); to do
			s.append(TrataNULL(linha.getIdComponente1()));
			s.append(" ");
			s.append(TrataNULL(linha.getDsComponente1()));
			s.append(";");
			//			s.append("Pot�ncia Interface;"); to do
			s.append(TrataNULL(linha.getIdComponente2()));
			s.append(" ");
			s.append(TrataNULL(linha.getDsComponente2()));
			s.append(";");
			//			s.append("Tempo de Teste;");
			s.append(TrataNULL(linha.getDuracaoTesteHHMMSSmmm()));
			s.append(";");
			//			s.append("Descri��o do Efeito;");
			try {
				// Alessandre> em 19-8-13 comentei o if para habilitar o status no reprocesso
				//if (!linha.getFase().equals("Reprocesso")){
					s.append(TrataNULL(linha.getDsStatusTeste()));
				//}
			} catch (Exception e) {
				s.append("");
			}			
			s.append(";");
			//			s.append("Status/Efeito;");
			try {
				// Alessandre> em 19-8-13 comentei o if para habilitar o status no reprocesso
				//if (!linha.getFase().equals("Reprocesso")){
					s.append(TrataNULL(linha.getStatusTeste()));
				//}
			} catch (Exception e) {
				s.append("");
			}			
			s.append(";");
			//			s.append("Data Saida;");
			s.append(formatterData.format(linha.getDthr_Saida()));
			s.append(";");
			//			s.append("Hora Saida;");
			s.append(formatterHora.format(linha.getDthr_Saida()));
			s.append(";");
			//			s.append("Descri��o da Causa;");
			try {
				s.append(TrataNULL(linha.getDefeitos().get(0).getDsDefeito()));
			} catch (Exception e) {
				s.append("");
			}				
			s.append(";");
			//			s.append("Causa;");
			try {
				s.append(TrataNULL(linha.getDefeitos().get(0).getCdDefeito()));
			} catch (Exception e) {
				s.append("");
			}	
			s.append(";");
			//			s.append("Descri��o da A��o;");
			try {
				s.append(TrataNULL(linha.getDefeitos().get(0).getAcao().getDsAcao()));
			} catch (Exception e) {
				s.append("");
			}	
			s.append(";");
			//			s.append("Acao\n");
			try {
				s.append(TrataNULL(linha.getDefeitos().get(0).getAcao().getCdAcao()));
			} catch (Exception e) {
				s.append("");
			}
		}
		return s.toString();
	}

	@SuppressWarnings("unchecked")
	protected String exportaModeloResumidoHorizontal(ExpArquivoExportadoDTO arquivo){
		StringBuilder s = new StringBuilder();

		//		Receita de testes funcionais";
		//		"Montagem - Associa��o de NS";
		//		"Teste passa / n�o passa";
		//		"Testa passa / c�digo defeito";
		//		"Apenas registro de passagem";
		//		"Reprocesso causa-a��o"};
		//		
		SimpleDateFormat formatterData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:ss");

		String nsAvaliado = null;
		ExportacaoModeloResumidoHorizontalDTO linhaDTO = new ExportacaoModeloResumidoHorizontalDTO();
		s.append(linhaDTO.getCabecalho(arquivo));

		// Ordena pelo numero de serie, fase e data e hora de saida
		Collections.sort(arquivo.getLinhas(), new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				ExpLinhaExportadaDTO p1 = (ExpLinhaExportadaDTO) o1;
				ExpLinhaExportadaDTO p2 = (ExpLinhaExportadaDTO) o2;
				
//				Calendar dthr1 = Calendar.getInstance();
//				dthr1.setTime(p1.getDthr_Saida());
//
//				Calendar dthr2 = Calendar.getInstance();
//				dthr2.setTime(p2.getDthr_Saida());
//				
//				return (dthr1.before(dthr2) ? -1 : (dthr1.after(dthr2) ? +1 : 0));
				return p1.compareToModeloResumidoHorizontal(p2);
			}
		});
		
		for (ExpLinhaExportadaDTO linha : arquivo.getLinhas()){
			boolean isIniciaNovaLinha = false;
			// Obtem 1o numero serie a ser avaliado
			if (nsAvaliado == null){
				nsAvaliado = linha.getNserie();
				isIniciaNovaLinha = true;
			}
			// Se mudou o numero de serie
			if (!linha.getNserie().equals(nsAvaliado)){
				nsAvaliado = linha.getNserie();
				// Gera string com a linha
				s.append(linhaDTO.getLinhaExportada());
				
				// Inicia nova linha
				isIniciaNovaLinha = true;
			}
			if (isIniciaNovaLinha == true){
				linhaDTO = new ExportacaoModeloResumidoHorizontalDTO();
				//			//Dados do Produto
				linhaDTO.setPlataforma(TrataNULL(linha.getPlataforma()));
				linhaDTO.setSku(TrataNULL(linha.getSku()));
				linhaDTO.setComplemento(TrataNULL(linha.getComplemento()));
				linhaDTO.setNs(TrataNULL(linha.getNserie()));
				linhaDTO.setReSupervisor(TrataNULL(linha.getMatriculaSupervisor()));
				linhaDTO.setNmSupervisor(TrataNULL(linha.getNomeSupervisor()));
			}
			
			
			
			
			

			if (linha.getFase().equals("Montagem")){			
				if (linha.getDthr_Entrada() != null){
					linhaDTO.setDataMontagem(formatterData.format(linha.getDthr_Entrada()));
					linhaDTO.setHoraMontagem(formatterHora.format(linha.getDthr_Entrada()));
				} else {
					linhaDTO.setDataMontagem(formatterData.format(linha.getDthr_Saida()));
					linhaDTO.setHoraMontagem(formatterHora.format(linha.getDthr_Saida()));
				}
				linhaDTO.setReOperador(TrataNULL(linha.getMatriculaOperador()));
				linhaDTO.setNmOperador(TrataNULL(linha.getNomeOperador()));
				linhaDTO.setIdPostoMontagem(TrataNULL(linha.getIdPt()));
				linhaDTO.setStatusEfeitoMontagem("ok");		
				linhaDTO.setComponenteMontado1(TrataNULL(linha.getIdComponente1()));
				linhaDTO.setDsComponenteMontado1(TrataNULL(linha.getDsComponente1()));
				linhaDTO.setComponenteMontado2(TrataNULL(linha.getIdComponente2()));
				linhaDTO.setDsComponenteMontado2(TrataNULL(linha.getDsComponente2()));
			}

			
			

			
			if (linha.getFase().equals("Teste funcional")){			
				if (linha.getDthr_Entrada() != null){
					linhaDTO.setDataFuncional(formatterData.format(linha.getDthr_Entrada()));
					linhaDTO.setHoraFuncional(formatterHora.format(linha.getDthr_Entrada()));
				} else {
					linhaDTO.setDataFuncional(formatterData.format(linha.getDthr_Saida()));
					linhaDTO.setHoraFuncional(formatterHora.format(linha.getDthr_Saida()));
				}
				linhaDTO.setReOperadorFuncional(TrataNULL(linha.getMatriculaOperador()));
				linhaDTO.setNmOperadorFuncional(TrataNULL(linha.getNomeOperador()));
				linhaDTO.setIdPostoFuncional(TrataNULL(linha.getIdPt()));
				linhaDTO.setDuracaoFuncional(TrataNULL(linha.getDuracaoTesteHHMMSSmmm()));
				linhaDTO.setStatusEfeitoFuncional(TrataNULL(linha.getStatusTeste()));
			}

			
			
			
			
			if (linha.getFase().equals("Teste el�trico")){			
				if (linha.getDthr_Entrada() != null){
					linhaDTO.setDataEletrico(formatterData.format(linha.getDthr_Entrada()));
					linhaDTO.setHoraEletrico(formatterHora.format(linha.getDthr_Entrada()));
				} else {
					linhaDTO.setDataEletrico(formatterData.format(linha.getDthr_Saida()));
					linhaDTO.setHoraEletrico(formatterHora.format(linha.getDthr_Saida()));
				}
				
				linhaDTO.setReOperadorEletrico(TrataNULL(linha.getMatriculaOperador()));
				linhaDTO.setNmOperadorEletrico(TrataNULL(linha.getNomeOperador()));
				linhaDTO.setIdPostoEletrico(TrataNULL(linha.getIdPt()));
				linhaDTO.setStatusEfeitoEletrico(TrataNULL(linha.getStatusTeste()));
			}
			
			
			
			
			
			
			
			
			if (linha.getFase().equals("Teste Visual")){			
				//			//Testa passa / c�digo defeito
				//				s.append("Data;");
				if (linha.getDthr_Entrada() != null){
					linhaDTO.setDataVisual(formatterData.format(linha.getDthr_Entrada()));
					linhaDTO.setHoraVisual(formatterHora.format(linha.getDthr_Entrada()));
				} else {
					linhaDTO.setDataVisual(formatterData.format(linha.getDthr_Saida()));
					linhaDTO.setHoraVisual(formatterHora.format(linha.getDthr_Saida()));
				}
				linhaDTO.setReOperadorVisual(TrataNULL(linha.getMatriculaOperador()));
				linhaDTO.setNmOperadorVisual(TrataNULL(linha.getNomeOperador()));
				linhaDTO.setIdPostoVisual(TrataNULL(linha.getIdPt()));
				linhaDTO.setTempoTesteVisual(TrataNULL(linha.getDuracaoTesteHHMMSSmmm()));
				linhaDTO.setStatusEfeitoVisual(TrataNULL(linha.getStatusTeste()));				
			}
			
			
			
			
			
			
			
			
			
			if (linha.getFase().equals("Posto verifica��o")){			
				//			//Apenas registro de passagem
				if (linha.getDthr_Entrada() != null){
					linhaDTO.setDataPassagem(formatterData.format(linha.getDthr_Entrada()));
					linhaDTO.setHoraPassagem(formatterHora.format(linha.getDthr_Entrada()));
				} else {
					linhaDTO.setDataPassagem(formatterData.format(linha.getDthr_Saida()));
					linhaDTO.setHoraPassagem(formatterHora.format(linha.getDthr_Saida()));
				}
				linhaDTO.setReOperadorPassagem(TrataNULL(linha.getMatriculaOperador()));
				linhaDTO.setNmOperadorPassagem(TrataNULL(linha.getNomeOperador()));
				linhaDTO.setIdPostoPassagem(TrataNULL(linha.getIdPt()));
				linhaDTO.setStatusEfeitoPassagem(TrataNULL(linha.getStatusTeste()));
			}
			
			
			
			
			
			
			
			if (linha.getFase().equals("Reprocesso")){			
				//			//Reprocesso causa-a��o
				//				s.append("Data;");
				if (linha.getDthr_Entrada() != null){
					linhaDTO.setDataReprocesso(formatterData.format(linha.getDthr_Entrada()));
					linhaDTO.setHoraReprocesso(formatterHora.format(linha.getDthr_Entrada()));
				} else {
					linhaDTO.setDataReprocesso(formatterData.format(linha.getDthr_Saida()));
					linhaDTO.setHoraReprocesso(formatterHora.format(linha.getDthr_Saida()));
				}
				linhaDTO.setReOperadorReprocesso(TrataNULL(linha.getMatriculaOperador()));
				linhaDTO.setNmOperadorReprocesso(TrataNULL(linha.getNomeOperador()));
				linhaDTO.setIdPostoReprocesso(TrataNULL(linha.getIdPt()));
				linhaDTO.setComponenteMontado1Reprocesso(TrataNULL(linha.getIdComponente1()));
				linhaDTO.setDsComponenteMontado1Reprocesso(TrataNULL(linha.getDsComponente1()));
				linhaDTO.setComponenteMontado2Reprocesso(TrataNULL(linha.getIdComponente2()));
				linhaDTO.setDsComponenteMontado2Reprocesso(TrataNULL(linha.getDsComponente2()));
				linhaDTO.setDataSaidaReprocesso(formatterData.format(linha.getDthr_Saida()));
				linhaDTO.setHoraSaidaReprocesso(formatterHora.format(linha.getDthr_Saida()));
				linhaDTO.setCausa(TrataNULL(linha.getDefeitos().get(0).getCdDefeito()));
				if (linha.getDefeitos() != null && linha.getDefeitos().size() > 0 && linha.getDefeitos().get(0).getAcao() != null)
					linhaDTO.setAcao(TrataNULL(linha.getDefeitos().get(0).getAcao().getCdAcao()));
				else
					linhaDTO.setAcao("");
			}
			
			s.append(linhaDTO.getLinhaExportada());
		}
		

		return s.toString();
	}
}
