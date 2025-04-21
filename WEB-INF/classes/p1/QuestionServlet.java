package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");


        
        // Retrieve the selected answers for the other questions here

        // Check the selected answers against the correct answers
        
        
//        response.getWriter().println("count 1 : "+count1);
//        response.getWriter().println("count 2 : " + count2);
//        response.getWriter().println("count 3 : " + count3);
//        response.getWriter().println("range : " + range);
       
      
        Connection con;
        try {
        	int count=0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver is loaded");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","praveen","1505");
			System.out.println("Connected..");
			PreparedStatement pstmt= con.prepareStatement("select * from progress where=?");
			pstmt.setString(1, name);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				count=1;
			}
			if(count==1)
			{
				response.sendRedirect("UserHome.jsp?msg=AlreadyUser");
			}
			if(count==0)
			{
				//insertion
				String question1 = request.getParameter("q1");
		        String question2 = request.getParameter("q2");
		        String question3 = request.getParameter("q3");
		        String question4 = request.getParameter("q4");
		        String question5 = request.getParameter("q5");
		        String question6 = request.getParameter("q6");
		        String question7 = request.getParameter("q7");
		        String question8 = request.getParameter("q8");
		        String question9 = request.getParameter("q9");
		        String question10 = request.getParameter("q10");
		        
		        
		        int count1=0;
		        int count2=0;
		        int count3=0;
		        
		        request.setAttribute("name", name);

		        if (question1.equals("a")) 
		        {
		        	count1=count1+1;
		        }
		        else if(question1.equals("b")) 
		        {
		        	count2+=1;
		        	
		    	}
		        else if(question1.equals("c")) 
		        {
		            	count3+=1;
		            	
		    	}
		        if (question2.equals("a")) 
		        {
		        	count1=count1+1;
		        }
		        else if(question2.equals("b")) 
		        {
		        	count2+=1;
		        	
		        }
		        else if(question2.equals("c")) 
		        {
		            	count3+=1;
		            	
		        }
		        if (question3.equals("a")) 
		        {
		        	count1=count1+1;
		        }
		        else if(question3.equals("b"))
		        {
		        	count2+=1;
		        	
		        }
		        else if(question3.equals("c"))
		        {
		            	count3+=1;
		            	
		        }
		        if (question4.equals("a")) 
		        {
		        	count1=count1+1;
		        }
		        else if(question4.equals("b"))
		        {
		        	count2+=1;
		        	
		        }
		        else if(question4.equals("c"))
		        {
		            	count3+=1;
		            	
		        }
		        if (question5.equals("a")) 
		        {
		        	count1=count1+1;
		        }
		        else if(question5.equals("b"))
		        {
		        	count2+=1;
		        	
		        }
		        else if(question5.equals("c")) 
		        {
		            	count3+=1;
		            	
		        }
		        if (question6.equals("a")) 
		        {
		        	count1=count1+1;
		        }
		        else if(question6.equals("b"))
		        {
		        	count2+=1;
		        	
		        }
		        else if(question6.equals("c")) 
		        {
		            	count3+=1;            	
		        }
		        if (question7.equals("a"))
		        {
		        	count1=count1+1;
		        }
		        else if(question7.equals("b")) 
		        {
		        	count2+=1;
		        	
		        }
		        else if(question7.equals("c"))
		        {
		            	count3+=1;
		            	
		        }
		        if (question8.equals("a"))
		        {
		        	count1=count1+1;
		        }
		        else if(question8.equals("b"))
		        {
		        	count2+=1;
		        	
		        }
		        else if(question8.equals("c"))
		        {
		            	count3+=1;	
				}
		        if (question9.equals("a")) 
		        {
		        	count1=count1+1;
		        }
		        else if(question9.equals("b"))
		        {
		        	count2+=1;
		        	
		    	}
		        else if(question9.equals("c"))
		        {
		            	count3+=1;
		        }
		        if (question10.equals("a")) 
		        {
		        	count1=count1+1;
		        }
		        else if(question10.equals("b"))
		        {
		        	count2+=1;	
		        }
		        else if(question10.equals("c")) 
		        {
		            	count3+=1;
		        }
		        
		        float totala=(float) count1*0.75f;
		        float totalb=(float) count2*0.50f;
		        float totalc=(float) count3*0.25f;
		        float range= totala+totalb+totalc;
		        
		        
				PreparedStatement pstmt1= con.prepareStatement("insert into progress(name,progress,role) values(?,?,?)");
				pstmt1.setString(1, name);
				pstmt1.setFloat(2, range);
				pstmt1.setString(3,"true");
				pstmt1.executeUpdate();
				response.sendRedirect("Question.jsp?msg=NewLogin");
			}

			}
        catch(Exception e)
        {
        	System.out.println(e);
        }
}
}       
