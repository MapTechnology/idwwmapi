
<%@page import="idw.model.pojos.injet.Ijtbpro"%>
<%@page import="idw.model.rn.injet.ProdutoInjetRN"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="idw.model.dao.DAOGenerico"%>
<%@page import="idw.model.rn.RelatorioProducaoRN"%>
<%@page import="idw.model.rn.injet.dto.ProdutoInjetDTO"%>
<%@page import="idw.model.pojos.injet.Ijgrpdetinj"%>
<%@page import="idw.model.rn.injet.IjgrpdetinjRN"%>
<%@page import="idw.model.rn.injet.dto.MaquinaInjetDTO"%>
<%@page import="idw.model.rn.injet.dto.AnalisePeriodoInjetDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="idw.model.rn.injet.AnalisePeriodoInjetRN"%>
<%@page import="ms.util.ConversaoTipos"%>
<%@page import="idw.model.rn.DataHoraRN"%>
<%@page import="idw.model.rn.injet.dto.FiltroAnalisePeriodoInjetDTO"%>
<%@page import="idw.model.rn.injet.dto.RelatorioProducaoDTO"%>
<%@page import="idw.model.pojos.injet.Ijgrpinj"%>
<%@page import="idw.model.dao.injet.DAOGenericoInjet"%>
<%@page import="idw.model.rn.injet.IjgrpinjRN"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	
 	String dtInicial = request.getParameter("dtinicial");
 	String dtFinal = request.getParameter("dtfinal");
 	String turnos = request.getParameter("turnos");
 	if(turnos.equals("null")){
 		turnos = null;
 	}
 	String maquinas = request.getParameter("grupoMaquinas");
 	
 	FiltroAnalisePeriodoInjetDTO periodoInjetRN = new FiltroAnalisePeriodoInjetDTO();
 	AnalisePeriodoInjetDTO analisePeriodoInjetDTO = new AnalisePeriodoInjetDTO();

 	SimpleDateFormat formatterString = new SimpleDateFormat("dd/MM/yyyy");
 	List <RelatorioProducaoDTO> listaRelatorioDTO = new ArrayList<RelatorioProducaoDTO>();
 	try{
 		periodoInjetRN.setDtInicio(formatterString.parse(dtInicial));
 		periodoInjetRN.setDtFim(formatterString.parse(dtFinal));
 		periodoInjetRN.setCdTurno(turnos);
 		periodoInjetRN.setCdMaquinaGrupo(maquinas);
 	}catch(Exception e){		
 	}
	
 	BigDecimal totalKw;
 	List<Ijgrpdetinj> listaMaquinas = new ArrayList<Ijgrpdetinj>();
 	IjgrpdetinjRN lmaquinas = new IjgrpdetinjRN(new DAOGenericoInjet());
  	lmaquinas.iniciaConexaoBanco();
  	listaMaquinas = lmaquinas.listamaquinas(periodoInjetRN.getCdMaquinaGrupo());
  	lmaquinas.finalizaConexaoBanco();
 	
  	//for (Ijgrpdetinj ijgrpdetinj : listaMaquinas){  
 		
  		//String cdMaquina = ijgrpdetinj.getIjgrpinj().getCdgrpinj();
  		//periodoInjetRN.setCdMaquina(ijgrpdetinj.getIjtbinj().getCdinjetora());
 		
  		AnalisePeriodoInjetRN analisePeriodoInjetRN = new AnalisePeriodoInjetRN(new DAOGenericoInjet());
  		analisePeriodoInjetRN.iniciaConexaoBanco();
 				
  		analisePeriodoInjetDTO = analisePeriodoInjetRN.analisarPeriodo(periodoInjetRN);
 		
  		List<MaquinaInjetDTO> lisMaquinas = new ArrayList<MaquinaInjetDTO>();
 		
  		lisMaquinas = analisePeriodoInjetDTO.getIndicadoresPorMaquina();
		analisePeriodoInjetRN.finalizaConexaoBanco();
  		for (MaquinaInjetDTO dto : lisMaquinas){
  			
  		 	RelatorioProducaoDTO producaoDTO = new RelatorioProducaoDTO();

  			producaoDTO.setNomeMaquina(dto.getDsMaquina());
  			
  			List<ProdutoInjetDTO> listaProdutos = new ArrayList<ProdutoInjetDTO>();
  			listaProdutos = dto.getProdutos();

  			for(ProdutoInjetDTO produtoInjetDTO : listaProdutos){
  	  			producaoDTO.setDsProduto(produtoInjetDTO.getIjtbpro().getDsproduto());
  			}
  			  						
  			producaoDTO.setHorasTrabalhadas(DataHoraRN.formatSegundosParaHHMMSS(dto.getMaquinaTotalDTO().getTempoTrabalhadoSegundos().intValue()));
  			producaoDTO.setHorasDisponiveis(DataHoraRN.formatSegundosParaHHMMSS(dto.getMaquinaTotalDTO().getTempoDisponiveisSegundos().intValue()));
  			producaoDTO.setQtdPrevista(dto.getMaquinaTotalDTO().getProducaoPrevistaUnidade());
  			producaoDTO.setPsPrevisto(dto.getMaquinaTotalDTO().getProducaoPrevistaTn());
  			producaoDTO.setProducaoRefugada(dto.getMaquinaTotalDTO().getProducaoRefugadaUnidade());
  			producaoDTO.setPsProducaoRefugada(dto.getMaquinaTotalDTO().getProducaoRefugadaTn());
  			producaoDTO.setProducaoLiquida(dto.getMaquinaTotalDTO().getProducaoLiquidaUnidade());
  			producaoDTO.setPsProducaoLiquida(dto.getMaquinaTotalDTO().getProducaoLiquidaTn());
  			producaoDTO.setProducaoBruta(dto.getMaquinaTotalDTO().getProducaoBrutaUnidade());
  			producaoDTO.setPsProducaoBruta(dto.getMaquinaTotalDTO().getProducaoBrutaTn());
  			producaoDTO.setIndRefugo(dto.getMaquinaTotalDTO().getIndiceRefugo());
  			producaoDTO.setIndParada(dto.getMaquinaTotalDTO().getIndiceParada());
  			producaoDTO.setOee(dto.getMaquinaTotalDTO().getOee());
  			
  			RelatorioProducaoRN relatorioProducaoRN = new RelatorioProducaoRN(new DAOGenerico());
  			relatorioProducaoRN.iniciaConexaoBanco();
  			try{
	  			totalKw = relatorioProducaoRN.getValores(periodoInjetRN.getDtInicio(), periodoInjetRN.getDtFim(), dto.getCdMaquina(), turnos);
	  			relatorioProducaoRN.finalizaConexaoBanco();
	  			
	  			System.out.println("totalKw=" + totalKw.doubleValue() + " tempotrabalhado=" + dto.getMaquinaTotalDTO().getTempoTrabalhadoHorasFormatado());
	 			
	  			producaoDTO.setKwh( totalKw.doubleValue());
	  			
	  			if (producaoDTO.getPsProducaoBruta() != null && producaoDTO.getPsProducaoBruta().doubleValue() > 0d)
	 				producaoDTO.setKwhTon( totalKw.doubleValue() / producaoDTO.getPsProducaoBruta().doubleValue());
	  			else
	  				producaoDTO.setKwhTon( 0d );
	  			
	  			if (producaoDTO.getProducaoBruta() != null && producaoDTO.getProducaoBruta().doubleValue() > 0d)
	 				producaoDTO.setKwhProducaoBruta( totalKw.doubleValue() / producaoDTO.getProducaoBruta().doubleValue());
	  			else
	  				producaoDTO.setKwhProducaoBruta( 0d );
	  			
  			}catch(Exception e ){
  				e.printStackTrace();
  			}
  			//}
  			listaRelatorioDTO.add(producaoDTO);			
  		}
  		
  	//}
 	
 %>
<html>
<head>
	
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
 <table border="0" cellpadding="0" cellspacing="0">



       	  <tr>
            	<td id="logo">&nbsp;
                	
                </td>
           
            <td id="botaohome">
                 <a class="MenuHome" href="control?estilo=index">
                        <fmt:message key="Home"/>
                        </a>
                 </td>
            
                
<td id="botaoexportacao">
                 <a class="MenuExpo"><!--  href="control?estilo=exportacao"> -->
                    	<fmt:message key="Exportação"/>
                    </a>
                       
                </td>
                
                             
<td id="botaograficogerencial">
<a class="MenuTopoGrafico"><!--  href="control?estilo=exportacaoRel"> -->
                    	<fmt:message key="Gráfico_Gerencial"/>
                    </a>
            </td>
                
<td id="botaorelatproducao">
<a class="MenuRelatProducao" href="control?estilo=relatorioProducao">
                    	<fmt:message key="Relatório_de_Produção"/>
                    </a>
            </td>

			<td id="botaoreprocesso"><a class="MenuReprocesso"
				href="control?estilo=reprocesso"> <fmt:message key="reprocesso" />
			</a></td>
                
			<td id="botaologout"> <a class="MenuTopoLogout" href="control?estilo=logout">
                    	Logout
                    </a>
            </td>
                 
                 
            <td id="botaoembranco">&nbsp;
            </td>
  </tr>
            
        </table>
        
        
        <!-- tabela para segunda linha -->
<table border="0" cellpadding="0" cellspacing="0">
        	<tr>
            	<td id="abaixodobotao">
                	
                </td>
             </tr>
           
         </table>
         
         <!-- tabela para terceira linha -->
		<table border="0" cellpadding="0" cellspacing="0">
        	<tr>
           	  <td id="linha">
                	
                </td>
          </tr>
           
    </table>
         
         
          <!-- tabela para quarta linha -->
		<table border="0" cellpadding="0" cellspacing="0">
        	<tr>
            
                      
            	<td align="left" valign="top" id="areaexportacao">   
            		<div id="filtro1">
					<fieldset id = texto>
						<legend><fmt:message key="Relatório_de_Produção"/></legend>
						
						<table id = "tbRelatorio" border="1">
							<tr>
								<th><fmt:message key="Máquinas"/> </th> 
								<th> <fmt:message key="Produto"/></th>  
								<th><fmt:message key="Horas_Trabalhadas"/> </th> 
								<th><fmt:message key="Horas_Disponíveis"/></th>  
								<th><fmt:message key="Quantidade_Prevista"/> </th>
								<th><fmt:message key="Peso_Previsto"/> </th> 
								<th><fmt:message key="Produção_Refugada"/></th>  
								<th><fmt:message key="Peso_Produção_Refugada"/> 
								</th> <th><fmt:message key="Produção_Líquida"/> </th>  
								<th><fmt:message key="Peso_Produção_Líquida"/> </th>
								<th><fmt:message key="Produção_Bruta"/> </th> 
								<th> <fmt:message key="Peso_Produção_Bruta"/></th>  
								<th><fmt:message key="Índice_Refugo"/> </th> 
								<th><fmt:message key="Índice_Parada"/></th> 
								<th><fmt:message key="OEE"/></th>
								<th>Kw/h </th> 
								<th> Kwh/ton</th>
								<th> <fmt:message key="kwhproducaobruta"/> </th>
							</tr>
								<% 
									DecimalFormat dformat = new DecimalFormat("0.0000");
								
									for(RelatorioProducaoDTO dto : listaRelatorioDTO){
										out.println("<tr>");
								 		out.println("<td>" + dto.getNomeMaquina() + "</td>");
								 		out.println("<td>" + dto.getDsProduto() + "</td>");
								 		out.println("<td>" + dto.getHorasTrabalhadas() + "</td>");
								 		out.println("<td>" + dto.getHorasDisponiveis() + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getQtdPrevista(), 0) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getPsPrevisto(), 2) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getProducaoRefugada(), 0) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getPsProducaoRefugada(), 2) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getProducaoLiquida(), 0) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getPsProducaoLiquida(), 2) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getProducaoBruta(), 0) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getPsProducaoBruta(), 2) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getIndRefugo(), 2) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getIndParada(), 2) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getOee(), 2) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getKwh(), 2) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getKwhTon(), 2) + "</td>");
								 		out.println("<td>" + ConversaoTipos.converteParaString(dto.getKwhProducaoBruta(), 2) + "</td>");
								 		out.println("</tr>");
								 		
								 		
									}
									
								%> 
							
						</table>
		
						</fieldset>
						</div>      
                </td>
               
                                                       
          </tr>
           
    </table>
         
        	
<!--              tabela para decima linha -->
		<table border="0" cellpadding="0" cellspacing="0">
        	<tr>
            	<td id="rodape">&nbsp;
                </td>
           </tr>
           
    </table>
    </body>
</html>
    