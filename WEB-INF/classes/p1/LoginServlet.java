package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("pwd");
		HttpSession session= request.getSession();
		try 
		{
			Connection con;
			PreparedStatement pstmt;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver is loaded");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","praveen","1505");
			System.out.println("Connected..");
			 pstmt=con.prepareStatement("select * from Register");
	            ResultSet rs=pstmt.executeQuery();
	            while(rs.next())
	            {
	                if(phone.equals(rs.getString(2)))
	                {
	                    if(pwd.equals(rs.getString(3)))
	                    {
	                    	String name=rs.getString(1);
	                    	session.setAttribute("name",name);
	                    	session.setAttribute("phone",rs.getString(2));
	                    	session.setAttribute("Email",rs.getString(4));
	                    	response.sendRedirect("UserHome.jsp");
//	                    	 RequestDispatcher dispatcher = request.getRequestDispatcher("/QuestionServlet");
//	                         dispatcher.forward(request, response);
	                    	
	                    }
	                }
	                
	            }
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Not loaded................");
			System.out.println(ex);
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
