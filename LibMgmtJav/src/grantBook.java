
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class grantBook
 */
@WebServlet("/grantBook")
public class grantBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String CollegeId = (String) session.getAttribute("collegeId");

		List<String> pendingList = new ArrayList<String>();
		pendingList = MySQLDataStoreUtilities.checkPendingStatus();

		for (String str : pendingList) {
			String[] parts = str.split(",");
			String myid = parts[0];
			String ISBN = parts[1];

			System.out.println(myid + " " + ISBN);

			User u = MySQLDataStoreUtilities.getSignInDetails(myid);
			products p = MySQLDataStoreUtilities.getProductsDetails(ISBN);

			out.println("<div class='row'>");

			out.println("<div style='color:black' class='col-lg-11 col-md-4 col-sm-6'>");

			out.println("<div class='thumbnail'>");
			out.println("<h1>Pending Request</h1>");

			out.println("<p> CollegeID: " + u.getCollegeid() + "</p>");
			out.println("<p> Name: " + u.getFirstname() + "</p>");
			out.println("<img src=" + p.getImageURL() + ">");
			out.println("<p> ISBN: " + p.getISBN() + "</p>");
			out.println("<p> Title: " + p.getTitle() + "</p>");
			out.println("<form class = 'submit-button' method='post' action='grantBook'>");
			out.println("<input type='hidden' name='collegeId' value='" +  u.getCollegeid()  + "'>");
			out.println("<input type='hidden' name='BookISBN' value='" + p.getISBN() + "'>");
			out.println("<input class = 'submit-button' type = 'submit'>");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");

			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//String CollegeId = (String) session.getAttribute("collegeId");
		
		String CollegeId= (String) request.getParameter("collegeId");
		String bookISBN= (String) request.getParameter("BookISBN");
		
		System.out.println("Printing here"+CollegeId+ bookISBN);
		MySQLDataStoreUtilities.updateBookStatus(CollegeId, bookISBN);;
		doGet(request, response);
	}

}
