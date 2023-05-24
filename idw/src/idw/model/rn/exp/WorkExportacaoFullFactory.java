package idw.model.rn.exp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.jdbc.Work;

import idw.util.ArquivosDiretorios;
import idw.util.Compress;
import idw.webservices.dto.ExpArquivoExportadoDTO;
import idw.webservices.dto.ExpDetalheLinhaExportadaDTO;
import idw.webservices.dto.ExpLinhaExportadaDTO;
import idw.webservices.dto.ExportacaoDTO;
import idw.webservices.dto.FiltroExportacaoDTO;
import ms.util.UtilsThreads;

public class WorkExportacaoFullFactory implements Work{

	private FiltroExportacaoDTO filtro;
	private StringBuilder sql;
	private BufferedWriter arquivoExportado;
	private List<String> nomeArquivos = new ArrayList<String>();
	private ExportacaoDTO exportacao;
	private ExportacaoFullFactory expRN;
	
	public WorkExportacaoFullFactory(FiltroExportacaoDTO filtro, StringBuilder sql, ExportacaoDTO exportacao, ExportacaoFullFactory expRN){
		this.filtro = filtro;
		this.sql = sql;
		this.exportacao = exportacao;
		this.expRN = expRN;
	}
	
	@Override
	public void execute(Connection connection) throws SQLException {
		PreparedStatement  ps = null;
		
		try {
			ps = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try{
			if (filtro.getFiltro().getDthrIentrada() !=null && filtro.getFiltro().getDthrFentrada() !=null){
				ps.setTimestamp(1, new java.sql.Timestamp(filtro.getFiltro().getDthrIentrada().getTime()));
				ps.setTimestamp(2, new java.sql.Timestamp(filtro.getFiltro().getDthrFentrada().getTime()));
			}else if (filtro.getFiltro().getDthrIentrada() !=null){
				ps.setTimestamp(1, new java.sql.Timestamp(filtro.getFiltro().getDthrIentrada().getTime()));
			}else if (filtro.getFiltro().getDthrFentrada() !=null){
				ps.setTimestamp(1, new java.sql.Timestamp(filtro.getFiltro().getDthrFentrada().getTime()));
			}
		} catch (Exception e){
			
		}
		//determina a lista de arquivos que sera retornada List<ArquivoExportadoDTO
		if (filtro.getFiltro().getQtTotallinhas() == null){
			filtro.getFiltro().setQtTotallinhas(BigDecimal.valueOf(0l));
		}
		
		ResultSet rs = null;
		int arquivo = 0;
		int linha = 0;
		int qtdTotalLinha = 0;
		ExpArquivoExportadoDTO expArquivo = new ExpArquivoExportadoDTO();

		try {
			rs = ps.executeQuery();
			// Apagar primeiro arquivo
			ArquivosDiretorios.delete(filtro.getPath() + "/" + filtro.getPrefixo() + "1.csv");
			
			// Varre o resultset gravando os dados no arquivo csv
			while (rs.next()) {
				if (filtro.getFiltro().getQtTotallinhas() != null && filtro.getFiltro().getQtTotallinhas().intValue() > 0 && qtdTotalLinha >= filtro.getFiltro().getQtTotallinhas().intValue()){
					break;
				}
				linha++;
				qtdTotalLinha++;
				if (arquivoExportado == null || (filtro.getFiltro().getQtLinhasporarquivo() != null && linha > filtro.getFiltro().getQtLinhasporarquivo().intValue())){

					linha = 1;
					arquivo ++;
					
					// Usar novo arquivo para gravar as linhas
					try {
						String nomeArquivo = filtro.getPath() + "/" + filtro.getPrefixo() + String.valueOf(arquivo) + ".csv";
						nomeArquivos.add(nomeArquivo);
						arquivoExportado = new BufferedWriter(new FileWriter(new File(nomeArquivo), false));
					} catch (IOException e) {
						exportacao.setResultadoEvento(exportacao.getERRO_IO());
						return;
					}
				}

				ExpLinhaExportadaDTO expLinha = null;

				// Inicializa expLinha
				expLinha = new ExpLinhaExportadaDTO(rs);

				List<ExpDetalheLinhaExportadaDTO> detalhes = new ArrayList<ExpDetalheLinhaExportadaDTO>();

				ExpDetalheLinhaExportadaDTO detalhe = null;
				detalhe = new ExpDetalheLinhaExportadaDTO(rs);
				detalhes.add(detalhe);

				expLinha.setDetalhes(detalhes);
				
				expArquivo.setLinhas(new ArrayList<ExpLinhaExportadaDTO>());
				expArquivo.getLinhas().add(expLinha);

				expArquivo.setConteudo(expRN.exportaModeloDetalhamentoTestes(expArquivo));
				
				// Salvando linha em arquivo
				try {
					arquivoExportado.write(expArquivo.getConteudo());
				} catch (IOException e) {
					exportacao.setResultadoEvento(exportacao.getERRO_IO());
					return;
				} catch (NullPointerException e){}
				
				// Limpando memoria
				expLinha = null;
				UtilsThreads.pausaNaThread(10l);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Finaliza
		try {
			if (arquivoExportado != null){
				arquivoExportado.close();
				exportacao.setResultadoEvento(exportacao.getEVENTO_BEM_SUCEDIDO());
			} else {
				exportacao.setResultadoEvento(exportacao.getERRO_SEM_INFORMACAO());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Alessandre: comentei a linha abaixo para poder passar exatamente os arquivos e nao uma mascara
		//Compress.compactar(filtro.getPath() + "/", filtro.getPrefixo(), ".csv", filtro.getPath() + "/" + filtro.getPrefixo() + ".zip");
		Compress.compactar(nomeArquivos, filtro.getPath() + "/" + filtro.getPrefixo() + ".zip");
		

		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
