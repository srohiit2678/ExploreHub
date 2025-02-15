import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//UserLogin
public class UserLoginServlet extends HttpServlet
{
	private String Load_Driver = "com.mysql.cj.jdbc.Driver";
	private String  dbms_url = "jdbc:mysql://localhost:3306/ExploreHub";
	private String dbms_user = "root";
	private String dbms_pass = "root";
	private String login_query;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		// user id is Enroll Id
		String User_Name = request.getParameter("userid");
		String User_Password = request.getParameter("password");
		login_query = "select * from users where enroll_id='"+User_Name+"' and password='"+User_Password+"'";
		Connection con;
		out.println("<html><body>");
		try
			{
				Class.forName(Load_Driver);
				con = DriverManager.getConnection(dbms_url,dbms_user,dbms_pass);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(login_query);
				if(rs.next())
				{
					out.println("<h1>Welcome to home</h1>");
					response.sendRedirect("home.html");	
				}					
			}
			catch(Exception e)
			{
				out.println(e);
			}
				out.println("</body></html>");
				out.close();
	}
}
