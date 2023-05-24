/*
 * Created on 22/12/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package idw.servlets;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import idw.webservices.dto.UsuarioDTO;


@SuppressWarnings("serial")
public class CfwsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Verifica validade da sessao

		if (request.getParameter("estilo") != null) {
	        String estilo = request.getParameter("estilo");
	        String nextURL = "";
	        
	        if (estilo.equals("logout")) {
	        	getServletContext().setAttribute("sessaousuario", null);
				request.getSession().invalidate();
				estilo = "login";
			}
	        
	        // Se for para download do arquivo de exportacao
	        if (estilo.equals("salvaexportacao")){
	        	String arquivo = request.getParameter("arquivo");
	        	String destino = request.getParameter("destino");
	        	doDownload(request, response, arquivo, destino);
	        	return;
	        }
	        if (estilo.equals("filtroExportacao")){
	        	String acao = request.getParameter("acao");
	        	if (acao.equals("exportar")){
	        		estilo = "filtroValidacao";
	        	}else if (acao.equals("salvar")){
	        		estilo = "filtroValidacao";
	        	}else if (acao.equals("abrir")){
	        		estilo = "pesquisasFiltro";
	        	}
	        }
			HttpSession session = request.getSession(true);
			session.getAttribute("sessaousuario");
			UsuarioDTO sessaoUsuario = null;
		    sessaoUsuario = (UsuarioDTO) session.getAttribute("sessaousuario");
		    if (sessaoUsuario == null && !estilo.equals("loginValidacao") && !estilo.equals("relVisualizar")){
		    	estilo = "login";
		    }

	        nextURL="/cfwsweb/" + estilo + ".jsp";
	        
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextURL);
	        dispatcher.forward(request,response);
	    }
	    else {
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cfwsweb/login.jsp");
	        dispatcher.forward(request,response);
	    }
	}

	private void doDownload(HttpServletRequest req, HttpServletResponse resp, String filename, String original_filename) throws IOException {
		File f = new File(filename);
		int length = 0;
		ServletOutputStream op = resp.getOutputStream();
		ServletContext context = getServletConfig().getServletContext();
		String mimetype = context.getMimeType(filename);

		//
		// Set the response and go!
		//
		//
		resp.setContentType((mimetype != null) ? mimetype
				: "application/octet-stream");
		resp.setContentLength((int) f.length());
		resp.setHeader("Content-Disposition", "attachment; filename=\""
				+ original_filename + "\"");

		//
		// Stream to the requester.
		//
		byte[] bbuf = new byte[2048];
		DataInputStream in = new DataInputStream(new FileInputStream(f));

		while ((in != null) && ((length = in.read(bbuf)) != -1)) {
			op.write(bbuf, 0, length);
		}

		in.close();
		op.flush();
		op.close();
	}
	
}
