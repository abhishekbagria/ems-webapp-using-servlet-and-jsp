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


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String doctype = "<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>";
		out.println(doctype+
				"<html>"
				+ "<head></head>"
				+ "<body>"
				+ request.getParameter("username")
				+ "</body>"
				+ "</html>");
		
		String x = request.getParameter("username");
//		int i = Integer.parseInt(x);
		
		Connection connection = MysqlCon.getDBConnection();
        PreparedStatement insertPreparedStatement = null;
        
        String InsertQuery = "DELETE FROM emp WHERE (username)=(?)";
        
        try {
            insertPreparedStatement = connection.prepareStatement(InsertQuery);
            insertPreparedStatement.setString(1, x);
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();
            
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath()+"/list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
