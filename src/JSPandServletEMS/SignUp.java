package JSPandServletEMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=null,pw=null,cpw,dob,gen,adr,pn,name;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String doctype = "<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>";
		out.print(doctype+
				"<html>"
				+ "<head><title>Sign Up Form</title>"
				+ "</head>"
				+ "<body>"
				+request.getParameter("username")
				+request.getParameter("password")
				+request.getParameter("confirmpassword")
				+request.getParameter("name")
				+request.getParameter("birthday")
				+request.getParameter("gender")
				+request.getParameter("address")
				+request.getParameter("phone")
				+ "</body>"
				+ "</html>");
			
			
			un  = request.getParameter("username");
			pw  = request.getParameter("password");
			cpw = request.getParameter("confirmpassword");
			name = request.getParameter("name");
			dob = request.getParameter("birthday");
			gen = request.getParameter("gender");
			adr = request.getParameter("address");
			pn  = request.getParameter("phone");
			
			if(pw.equals(cpw)){
			try{
				EmployeeData data = new EmployeeData();
				data.setUsername(un);
				data.setPassword(pw);
				data.setName(name);
				data.setDateOfBirth(dob);
				data.setGender(gen);
				data.setAddress(adr);
				data.setPhoneNum(pn);
				
				Connection connection = MysqlCon.getDBConnection();
				
				PreparedStatement statement = connection.prepareStatement("SELECT username FROM emp WHERE username=?");
		        statement.setString(1, un);
		        ResultSet rs = statement.executeQuery();
		        if(rs.next()){
		        	HttpSession session = request.getSession();
		        	  session.setAttribute("username_already_exist", "1");
		        	  response.sendRedirect(request.getContextPath()+"/sign_up.jsp");
		        }
		        else{
		        PreparedStatement insertPreparedStatement = null;
		   	        
		        String InsertQuery = "INSERT INTO emp(username, password, name, dateofbirth, gender, address, phonenumber) values(?,?,?,?,?,?,?)";
		        
		            insertPreparedStatement = connection.prepareStatement(InsertQuery);
		            insertPreparedStatement.setString(1, data.getUsername());
		            insertPreparedStatement.setString(2, data.getPassword());
		            insertPreparedStatement.setString(3, data.getName());
		            insertPreparedStatement.setString(4, data.getDateOfBirth());
		            insertPreparedStatement.setString(5, data.getGender());
		            insertPreparedStatement.setString(6, data.getAddress());
		            insertPreparedStatement.setString(7, data.getPhoneNum());
		            insertPreparedStatement.executeUpdate();
		            insertPreparedStatement.close();
		            
		            HttpSession session = request.getSession();
		        	  session.setAttribute("sign_up_successful", "1");
		            response.sendRedirect(request.getContextPath()+"/index.jsp");
		         
//		         rs.close();
//		         statement.close();
//		         conn.close();
		        }
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
				
			}
		}
			else{
				HttpSession session = request.getSession();
	        	  session.setAttribute("password_did_not_match", "1");
	        	  response.sendRedirect(request.getContextPath()+"/sign_up.jsp");
				
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
