import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class UserProjectRequest extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		String userProjectName = request.getParameter("projectName");
		String userProjectDescription = request.getParameter("description");
		String userProjectMentorName = request.getParameter("mentorName");
		
		
		
		
		String userProjectGithubLink = request.getParameter("githubLink");
		
		
		String userProjectLiveLink = request.getParameter("liveLink");
		String userProjectChallenges = request.getParameter("challenges");
		
		String userProjectTechStack = request.getParameter("projectName");
		/*
		String userProjectName = requestrequest.getParameter("projectName");
		String userProjectName = request.getParameter("projectName");
		String userProjectName = request.getParameter("projectName");
		String userProjectName = request.getParameter("projectName");
		String userProjectName = request.getParameter("projectName");
		String userProjectName = request.getParameter("projectName");
		*/
				/*
				project_id int AI PK 
				title varchar(255) 
				description text 
				student_id int 
				guide_id int 
				status enum('Pending','Approved','Rejected') 
				department_id int 
				created_at timestamp 
				project_link varchar(255) 
				tech_stack varchar(255)
				*/			
		String project_Query = "insert into projects (title,description,student_id,department_id,project_link,tech_stack)  values ('"+userProjectName+"','"+userProjectDescription+"','"+""+"','"+userProjectMentorName+"','"+userProjectGithubLink+"','"+""+"','"+""+"','"+userProjectTechStack+"') ";
		out.println("<html><body>");
		int n = 1;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///ExploreHub","root","root");
			//Statement st = createStatement();
			//n = st.executeUpdate(project_Query);
			if(n!=0)
			{
			out.println("<center><h1>Your Project submited Successfully Wait For Guid Approve.</h1></center>");
			}
			else{
			out.println("<center><h1>Your Project Not Submited Cheack Details Or Fill Again.</h1></center>");				
			}
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);			
		}
		out.println("</body></html>");
		out.close();
	}
}