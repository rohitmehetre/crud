

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
		String f=req.getParameter("name");
		String p=req.getParameter("pass");
		String rp=req.getParameter("rpass");
		String e=req.getParameter("email");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into data values(?,?,?,?,?)");
			ps.setString(1, I);
			ps.setString(2, f);
			ps.setString(3, p);
			ps.setString(4,rp);
			ps.setString(5, e);
            int i=ps.executeUpdate();
            if(i>0)
            {
            	out.print("Data is inserted successfully.");
            	out.println("<a href=welcome.html>Home</a>");
            }
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		out.close();

		
	}

	

}
