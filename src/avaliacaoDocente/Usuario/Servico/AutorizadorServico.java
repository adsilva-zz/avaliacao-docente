package avaliacaoDocente.Usuario.Servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorServico extends HandlerInterceptorAdapter{

	@Override
	  public boolean preHandle(HttpServletRequest request, 
	      HttpServletResponse response,
	      Object controller) throws Exception {

	      String uri = request.getRequestURI();
	      if(uri.endsWith("avaliacaodocente") || uri.endsWith("logar") || uri.contains("imagens") || uri.contains("css")){
	    	  return true;
	      }
	      
	      if(request.getSession().getAttribute("logado") != null) {
	        return true;
	      }
	      
	      response.sendRedirect("logar");
	      return false;
	  }
}
