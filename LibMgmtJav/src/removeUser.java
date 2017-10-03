
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class removeUser
 */
@WebServlet("/removeUser")
public class removeUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();
		
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "LibraryDataBase";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "root";
		
		Statement st;
		try {
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url+dbName,userName,password);
		System.out.println("Connected to the database");

		//String bookID = request.getParameter("bookID");
		String ID = request.getParameter("ID");
		//String issueDate = request.getParameter("issueDate");
		//String returnDate = request.getParameter("returnDate");
		//String flag = "Y";
		System.out.println(ID );

		MySQLDataStoreUtilities.removeUserDetails(ID);
		
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/userRemoveSuccess");
		rd.forward(request, response);
		
		} catch (Exception e) {
			  e.printStackTrace();
			  }
		
		
		// TODO Auto-generated method stub

	}

}
