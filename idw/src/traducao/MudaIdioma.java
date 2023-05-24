package traducao;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Servlet implementation class MudaIdioma
 */
public class MudaIdioma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MudaIdioma() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
          String language = request.getParameter("lingua");
          Locale locale = new Locale(language);
   
          Config.set(request.getSession(), Config.FMT_LOCALE, locale);
          Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE, locale);
   
           
          //response.sendRedirect("http://localhost:8080/idw/");
          String nextURL = "/";
          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextURL);
	      dispatcher.forward(request,response);

    }

}
