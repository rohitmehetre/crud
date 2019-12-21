

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadUser
 */
@WebServlet("/ReadUser")
public class ReadUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

 
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String I=req.getParameter("id");
		String f=req.getParameter("fname");
		String p=req.getParameter("pass");
		String e=req.getParameter("email");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "root");
			Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select  * from data");
            out.print("<html>");
            out.print("<body>");
            out.print("<table border=1px width=100%>");
            out.print("<tr>");
            out.print("<th>id</th>");
            out.print("<th>uname</th>");
            out.print("<th>pass</th>");
            out.print("<th>rpass</th>");
            out.print("<th>email</th>");
            out.print("</tr>");
            
            while (rs.next()) {
                out.print("<tr>");
                out.print("<td>"+rs.getString(1)+"</td>");
                out.print("<td>"+rs.getString(2)+"</td>");
                out.print("<td>"+rs.getString(3)+"</td>");
                out.print("<td>"+rs.getString(4)+"</td>");
                out.print("<td>"+rs.getString(5)+"</td>");
                out.print("</tr>");
                
                
                
            }
            out.print("</table>");
			out.println("<a href=welcome.html>Home</a>"); 
            out.print("</body>");
            out.print("</html>");
        }
		catch(Exception e1)
		{
			e1.printStackTrace();
		}

		
	}

	

}
