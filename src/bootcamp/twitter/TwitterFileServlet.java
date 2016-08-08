package gov.ssa.bootcamp.twitter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TwitterFileServlet
 */
@WebServlet("/TwitterFileServlet")
public class TwitterFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TwitterFileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		byte[] bytes = Files.readAllBytes(new File("C:\\Users\\admin\\Project\\ssatwitter\\src\\main\\webapp\\employee.json").toPath());
		response.setContentType("text/json");
		PrintWriter pw = response.getWriter();
		if (bytes == null) {
			//System.out.println("Not Found");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			//System.out.println("Found");
			pw.print(new String(bytes));
		}
	}

}
