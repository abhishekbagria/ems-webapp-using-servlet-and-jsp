package JSPandServletEMS;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String un = (String)session.getAttribute("uname");
		String pw = (String)session.getAttribute("pword");
//		System.out.println(un);
//		System.out.println(pw);
			try{
				EmployeeData data = new EmployeeData();
				
				Connection conn = MysqlCon.getDBConnection();
				Statement statement = conn.createStatement();
		        
				String InsertQuery = "SELECT name, dateofbirth, gender, address, phonenumber "
						+ "FROM emp WHERE username = '"+un+"'  AND password = '"+pw+"'";
				
				
		         ResultSet rs = statement.executeQuery(InsertQuery);
		         if(rs.next()){
//			            Retrieve by column name
			            String name = rs.getString("name");
			            String date = rs.getString("dateofbirth");
			            String gen = rs.getString("gender");
			            String adr = rs.getString("address");
			            String pn = rs.getString("phonenumber");
			            data.setName(name);
			            data.setDateOfBirth(date);
			            data.setGender(gen);
			            data.setAddress(adr);
			            data.setPhoneNum(pn);
			            data.setUsername(un);
			            data.setPassword(pw);
			            session.setAttribute("username", data.getUsername());
			            session.setAttribute("password", data.getPassword());
			            session.setAttribute("name", data.getName());
			            session.setAttribute("dob", data.getDateOfBirth());
			            session.setAttribute("gen", data.getGender());
			            session.setAttribute("adr", data.getAddress());
			            session.setAttribute("pn", data.getPhoneNum());
			            response.sendRedirect(request.getContextPath()+"/home.jsp");
		         }
		         
		            		         
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
