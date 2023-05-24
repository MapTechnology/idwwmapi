package idw.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Filtro para aplicativos Angular.
 * 
 * @author Milton
 *
 */
abstract class AngularAppFilter implements Filter {
	
	/**
	 * Nome da página principal do aplicativo Angular
	 * @return
	 */
	protected abstract String getIndexHtml();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	 * Aplica o filtro tratando quando a requisição quer pegar: <br> 
	 * * Arquivos de resource (*.js ou *.png, por exemplo) <br>
	 * * A aplicação angular, redirecionando para a página de index da aplicação. {@link #getIndexHtml()}.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI().substring(req.getContextPath().length());
		
		// Quando tiver o "." indica que a chamada foi para buscar algum resource
		// Por exemplo: *.js, *.png
		if(path.contains(".")) {
			chain.doFilter(request, response);			
		// Caso contrário, retorna a página html do aplicativo Angular 
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/" + getIndexHtml());
			rd.forward(request, response);
		}
		
	}

	@Override
	public void destroy() {
	}
}