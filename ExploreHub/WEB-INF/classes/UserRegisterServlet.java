import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//UserRegister 
public class UserRegisterServlet extends HttpServlet
{
	private String Load_Driver = "com.mysql.cj.jdbc.Driver";
	private String  dbms_url = "jdbc:mysql://localhost:3306/ExploreHub";
	private String dbms_user = "root";
	private String dbms_pass = "root";
	private String Register_query;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		String User_Name = request.getParameter("name");
		String User_Enroll_Id = request.getParameter("enroll_id");
		String User_Email = request.getParameter("email");
		int User_Department = Integer.parseInt(request.getParameter("department"));
		String User_Role_Type = request.getParameter("type");
		String User_Password = request.getParameter("password");
		Register_query = "INSERT INTO Users (enroll_id, name, email, password, role, department_id) values ('"+User_Enroll_Id+"','"+User_Name+"','"+User_Email+"','"+User_Password+"','"+User_Role_Type+"',"+User_Department+")";
			 out.println("<html><body>");
			try
			{
				Class.forName(Load_Driver);
				Connection con = DriverManager.getConnection(dbms_url,dbms_user,dbms_pass);
				Statement st = con.createStatement();
				int n = st.executeUpdate(Register_query);
			if(n!=0)
			{
				out.println("<h1>register Successfully</h1>");
				response.sendRedirect("login.html");
			}
			else{
				out.println("<h1>Registeration Not Done Successfully</h1>");
			}
			con.close();
			}
			catch(Exception e)
			{
				out.println(e);
			}
			
	}
}
