

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int result = num1 + num2;
		
		try {
			PrintWriter writer = res.getWriter();
			writer.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
