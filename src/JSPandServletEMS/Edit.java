package JSPandServletEMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dob,gen,adr,pn,name;
		HttpSession session = request.getSession();
		String un = (String)session.getAttribute("username");
		String pw = (String)session.getAttribute("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String doctype = "<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>";
		out.print(doctype+
				"<html>"
				+ "<head><title>Sign Up Form</title>"
				+ "</head>"
				+ "<body>"
				+request.getParameter("name")
				+request.getParameter("birthday")
				+request.getParameter("gender")
				+request.getParameter("address")
				+request.getParameter("phone")
				+ "</body>"
				+ "</html>");

			name = request.getParameter("name");
			dob = request.getParameter("birthday");
			gen = request.getParameter("gender");
			adr = request.getParameter("address");
			pn  = request.getParameter("phone");
			
			try{
				EmployeeData data = new EmployeeData();
				data.setUsername(un);
				data.setPassword(pw);
				data.setName(name);
				data.setDateOfBirth(dob);
				data.setGender(gen);
				data.setAddress(adr);
				data.setPhoneNum(pn);
//				System.out.println(data.getUsername());
//				System.out.println(data.getPassword());
//				System.out.println(data.getName());
//				System.out.println(data.getDateOfBirth());
//				System.out.println(data.getGender());
//				System.out.println(data.getAddress());
//				System.out.println(data.getPhoneNum());
				
				Connection connection = MysqlCon.getDBConnection();
		        PreparedStatement insertPreparedStatement = null;
		        
//		        String InsertQuery = "INSERT INTO emp(name, dateofbirth, gender, address, phonenumber) values(?,?,?,?,?) WHERE username = '"+un+"'  AND password = '"+pw+"'";
		        String InsertQuery = "UPDATE emp SET name=?, dateofbirth=?, gender=?, address=?, phonenumber=? WHERE username = '"+un+"'  AND password = '"+pw+"'";

		            insertPreparedStatement = connection.prepareStatement(InsertQuery);
		            insertPreparedStatement.setString(1, data.getName());
		            insertPreparedStatement.setString(2, data.getDateOfBirth());
		            insertPreparedStatement.setString(3, data.getGender());
		            insertPreparedStatement.setString(4, data.getAddress());
		            insertPreparedStatement.setString(5, data.getPhoneNum());
		            insertPreparedStatement.executeUpdate();
		            insertPreparedStatement.close();
		            
		            session.setAttribute("uname",data.getUsername());
		        	session.setAttribute("pword",data.getPassword());
		        	response.sendRedirect(request.getContextPath()+"/home");
		            		         
//		         rs.close();
//		         statement.close();
//		         conn.close();
	            
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
				
			}
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
