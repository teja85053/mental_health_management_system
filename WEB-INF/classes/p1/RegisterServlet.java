package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RegisterServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		DAO dao=new DAO();
		if(dao.doRegister(name,phone,pwd,email,age,gender))
		{
			response.sendRedirect("Register.jsp?msg=RegistrationSuccessful");
		}
		else
		{
			response.sendRedirect("Register.jsp?msg=RegistrationFailed");
		}
	}

}
