package JSPandServletEMS;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int i = 0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String doctype = "<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>";
		
		out.print(doctype+
				"<html>"
				+ "<head><title></title>"
				+"<link rel='stylesheet' type='text/css' href='list.css'>"
				+ "</head>"
				+ "<body>"
				+ "<fieldset>"
				+ "<legend>This is what we have till now</legend>");
				try{
			        Connection conn = MysqlCon.getDBConnection();

			         // Execute SQL query
			        Statement stmt = conn.createStatement();
			        
			        String InsertQuery = "SELECT username, name, dateofbirth, gender, address, phonenumber FROM emp";
			         ResultSet rs = stmt.executeQuery(InsertQuery);
			       //Display values
			            out.println("<table max-width='100%' >"
			            		+ "<tr>"
			            		+ "<th>S.No.</th>"
			            		+ "<th>USERNAME</th>"
			            		+ "<th>NAME</th>"
			            		+ "<th>DATE OF BIRTH</th>"
			            		+ "<th>GENDER</th>"
			            		+ "<th>ADDRESS</th>"
			            		+ "<th>PHONE NUMBER</th>"
			            		+ "<th>ACTION</th>"
			            		+ "</tr>");
			         // Extract data from result set
			         while(rs.next()){
			            //Retrieve by column name
			            i  += 1;
			            String un = rs.getString("username");
			            String name = rs.getString("name");
			            String date = rs.getString("dateofbirth");
			            String gen = rs.getString("gender");
			            String adr = rs.getString("address");
			            String pn = rs.getString("phonenumber");
			            
			            //Display values
			            out.println("<tr>"
			            		+ "<td>"+i+"</td>"
			            		+ "<td>"+un+"</td>"
			            		+ "<td>"+name+"</td>"
			            		+ "<td>"+date+"</td>"
			            		+ "<td>"+gen+"</td>"
			            		+ "<td>"+adr+"</td>"
			            		+ "<td>"+pn+"</td>"
			            		+ "<td>Delete:<form action='Delete' method='POST' id='delForm'>"	
			            		+ "<input type='submit' name='username' form='delForm' value="+un+"></input>"
			            		+ "</form>"
			            		+"</td>"
			            		+ "</tr>");	
			         }
			         out.println("</table>");
			         out.println("<a href='"+request.getContextPath()+"/index.jsp'>LogOut</a>"
			         		+ "</body></html>");

			         // Clean-up environment
			         rs.close();
			         stmt.close();
			         conn.close();
			      }catch(SQLException se){
			         //Handle errors for JDBC
			         se.printStackTrace();
			      }catch(Exception e){
			         //Handle errors for Class.forName
			         e.printStackTrace();
			      } //end try
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
