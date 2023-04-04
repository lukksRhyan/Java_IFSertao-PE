package br.com.sistemas.aulas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Imc
 */
public class Imc extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Imc() {
    }


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		double altura =Double.parseDouble(request.getParameter("altura"));
		double peso =Double.parseDouble(request.getParameter("peso"));
		double imc = peso/ (altura *altura);

		out.println("<html>");
		out.println("<body>");
		out.println("<h1>seu icm é :" + imc +"</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
