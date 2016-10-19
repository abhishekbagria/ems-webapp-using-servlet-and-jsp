package JSPandServletEMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
        		
		String un=null,pw=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String doctype = "<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>";
		out.print(doctype+
				"<html>"
				+ "<head><title>Log In Checker</title>"
				+ "</head>"
				+ "<body>"
				+request.getParameter("username")
				+request.getParameter("password")
				+ "</body>"
				+ "</html>");
			
			
			un  = request.getParameter("username");
			pw  = request.getParameter("password");
			System.out.println(un);
			System.out.println(pw);
			if(un.equals("admin") && pw.equals("admin123")){
				
						
				
				response.sendRedirect(request.getContextPath()+"/list");
				
//				try{
//			        Connection conn = MysqlCon.getDBConnection();
//
//			     // Execute SQL query
//			        Statement stmt = conn.createStatement();
//			        
//			        String InsertQuery = "SELECT name, dateofbirth, gender, address, phonenumber FROM emp";
//			         ResultSet rs = stmt.executeQuery(InsertQuery);
//			         while(rs.next()){
////				            Retrieve by column name
////			        	 	un = rs.getString("username");
////				            pw = rs.getString("password");
//				            String name = rs.getString("name");
//				            String date = rs.getString("dateofbirth");
//				            String gen = rs.getString("gender");
//				            String adr = rs.getString("address");
//				            String pn = rs.getString("phonenumber");
//				            i++;
//
//							data.setName(name);
//							data.setDateOfBirth(date);
//							data.setGender(gen);
//							data.setAddress(adr);
//							data.setPhoneNum(pn);
//							System.out.println(data.getName());
//							System.out.println(data.getDateOfBirth());
//							System.out.println(data.getGender());
//							System.out.println(data.getAddress());
//							System.out.println(data.getPhoneNum());
//				            HttpSession session = request.getSession();
//				            session.setAttribute("sn",i);
//				        	session.setAttribute("name",name);
//				        	session.setAttribute("date",date);
//				        	session.setAttribute("gen",gen);
//				        	session.setAttribute("adr",adr);
//				        	session.setAttribute("pn",pn);
//				        	response.sendRedirect(request.getContextPath()+"/list.jsp");
//			         }
//			         
////			         rs.close();
////			         statement.close();
////			         conn.close();
//		            
//		        } catch (SQLException e) {
//		            System.out.println("Exception Message " + e.getLocalizedMessage());
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		        }
				
			}
			
			else{
			try{
		        Connection conn = MysqlCon.getDBConnection();

		         // Execute SQL query
		        PreparedStatement statement = conn.prepareStatement("SELECT username, password FROM emp WHERE username=? AND password=?");
		        statement.setString(1, un);
	            statement.setString(2, pw);
		        ResultSet rs = statement.executeQuery();
		        if(rs.next()) {
		        	HttpSession session = request.getSession();
		        	session.setAttribute("uname",un);
		        	session.setAttribute("pword",pw);
		        	response.sendRedirect(request.getContextPath()+"/home");
//		            response.sendRedirect(request.getContextPath()+"/home.jsp");
//		            request.setAttribute("errMsg", "");
		        }else{
		        	HttpSession session = request.getSession();
		        	  session.setAttribute("wrong_uname_pass", "1");
		        	  response.sendRedirect(request.getContextPath()+"/index.jsp");
//		            request.setAttribute("errMsg", "username and password are incorrect");
//		            response.sendRedirect(request.getContextPath());
//		            // The following will keep you in the login page
//		            RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+"/index.jsp");
//		            rd.forward(request, response); 
		        }
		         
//		         rs.close();
//		         statement.close();
//		         conn.close();
	            
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}

}
