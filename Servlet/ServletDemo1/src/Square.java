

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Square
 */
@WebServlet("/Square")
public class Square extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter writer = response.getWriter();
			//writer.write("Result from requestDispatcher is : " + request.getAttribute("result"));
			//writer.write("Result from Redirect is: " + request.getParameter("result") );
			
			HttpSession session = request.getSession();
			int result = (int) session.getAttribute("result");
			writer.write("Result from session is: " + result );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
