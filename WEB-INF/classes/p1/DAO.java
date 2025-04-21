package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO 
{
	Connection con;
	public DAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver is loaded");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","praveen","1505");
			System.out.println("Connected..");
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Not loaded................");
			System.out.println(ex);
		}
		catch(SQLException ex)
		{
			System.out.println("Not Connected................");
			System.err.println(ex);
		}
	}
	public boolean doRegister(String name,String phone,String password,String email,String age,String gender)
	{
		boolean flag=false;
		try {
				PreparedStatement pstmt= con.prepareStatement("insert into Register values(?,?,?,?,?,?)");
				pstmt.setString(1,name);
				pstmt.setString(2,phone);
				pstmt.setString(3,password);
				pstmt.setString(4,email);
				pstmt.setString(5,age);
				pstmt.setString(6,gender);
				int r=pstmt.executeUpdate();
				if(r>0)
				{
					flag=true;
				}
		}catch(SQLException ex)
		{
			System.out.println("Not Connected................");
			System.err.println(ex);
		}
		return flag;
	}
boolean  loginCheck(String phone,String password,String name)
    {
		boolean flag=false;
        PreparedStatement pstmt;
        try
        {
  
            pstmt=con.prepareStatement("select *from Register");
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
                if(phone.equals(rs.getString(2)))
                {
                    if(password.equals(rs.getString(3)))
                    {
                    	flag=true;
                    }
                }
                
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
		return flag;
    }
public boolean Reset(String phone, String pwd) 
{
	boolean flag=false;
	PreparedStatement pstmt;
    try
    {

        pstmt=con.prepareStatement("update Register set pwd=? where phone=?");
        pstmt.setString(1, pwd);
        pstmt.setString(2, phone);
        int r=pstmt.executeUpdate();
        if(r>0)
        {
        	flag=true;
        }       
    }
    catch(SQLException ex)
    {
        System.out.println(ex);
    }
	return flag;
}
	public static void main(String args[])
	{
		new DAO();
	}
}
