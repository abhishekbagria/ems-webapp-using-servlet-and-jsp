<%@page import="JSPandServletEMS.EmployeeData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="home.css">
<link rel="icon" type="image/png" href="images/infoobjects_index.png">
<title>Home</title>

</head>
<body>

<% 
String un = (String)session.getAttribute("username");
String pw = (String)session.getAttribute("password");
String name = (String)session.getAttribute("name");
String dob = (String)session.getAttribute("dob");
String gen = (String)session.getAttribute("gen");
String adr = (String)session.getAttribute("adr");
String pn = (String)session.getAttribute("pn");
%>

<div class="whole">
<div class="gif">
<img src="images/hathi_mera_friend.gif">
<h1><span class="c1">INFO</span><span class="c2">OBJECTS INC.</span></h1>
</div><br/>


<div class="container actions" style="max-width: 300px">
  <!-- Trigger the modal with a button -->
  <button type="button" data-toggle="modal" data-target="#myModal1">Edit</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Let Us Edit</h4>
        </div>
        <div class="modal-body">
        <div class="normal">
<center><img src="images/infoobjects_logo.png"></center><br/>
         <form name="editForm" action="Edit" method="POST">				
			<input style="line-height: 2.0;" type="text" name="name" value=<%=name%> required/><br/>
			<input style="line-height: 2.0;" type="text" name="birthday" value=<%=dob%> required/><br/>
			<input style="line-height: 2.0;" type="text" name="gender" value=<%=gen%> required/><br/>
			<textarea type="text" rows="4" cols="20" name="address" value=<%=adr%> required></textarea><br/>
			<input style="line-height: 2.0;" type="text" name="phone" value=<%=pn%> required/><br/>
			<%session.setAttribute("username", un);
			session.setAttribute("password", pw);
			%>
			<input type="submit" href="#" value="submit"/>
		</form>
		</div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
  <button type="button" data-toggle="modal" data-target="#myModal2">Change Password</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Let Us Edit</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  

<!--
</div>


<div class="actions">
<a class="sitex" href="/EMSUsingJSPandServlet/edit.jsp">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;
--><a class="sitex" href="/EMSUsingJSPandServlet/logout"><button>Logout</button></a>
</div>

<div class="normal">
<center><img src="images/infoobjects_logo.png"></center><br/>




<table>
<thead>
<tr>
<th>Attribute</th>
<th>Value</th>
</tr>
</thead>
<tbody>
<tr>
<td>Name</td>
<td><%=name%></td>
</tr>
<tr>
<td>Date Of Birth</td>
<td><%=dob%></td>
</tr>
<tr>
<td>Gender</td>
<td><%=gen%></td>
</tr>
<tr>
<td>Address</td>
<td><%=adr%></td>
</tr>
<tr>
<td>Phone Number:</td>
<td><%=pn%></td>
</tr>
</tbody>
</table>
</div>
</div><br/><br/>
<div class="footer">
<a class="site" href="http://www.infoobjects.com">Home</a>
<a class="site" href="http://www.infoobjects.com/our-team/">Our Team</a>
<a class="site" href="http://www.infoobjects.com/employment/">Employment Oportunities</a>
<a class="site" href="http://www.infoobjects.com/privacy">Privacy Policy</a>
<a class="site" href="http://www.infoobjects.com/clients/">Clients</a>
<a class="site" href="http://www.infoobjects.com/contact-us/">Contact Us</a>
<a class="site" href="http://www.infoobjects.com/activities/">Activities</a>
<a class="site" href="http://www.infoobjects.com/media/">Videos</a>
<a class="site" href="https://drive.google.com/drive/folders/0ByJJ623UFsU3flNjSWZ6RG5pLWpLUHV2NHE0TnBWWXhmNnJfUnlmcUdVOUFUSW9zUFZnTTQ">Sandbox</a>
<br/>
<center><img src="images/spark-logo.png"></center>
</div>



<%


//if(session.getAttribute("userId")!=null){
response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);

//}
%> 
<%
//String userId = (String)session.getAttribute("userId");
//if(userId != null) {
//   response.sendRedirect(request.getContextPath());
//   }
//if(session.getAttribute("log_out_successful") != null){
//	session.setAttribute("log_out_successful", null);
//	session.setAttribute("cant_go_back", "1");
//	response.sendRedirect(request.getContextPath()+"/index.jsp");
//} %>

<%
//if(session.getAttribute("cant_go_back") != null && session.getAttribute("log_out_successful") == null){
//	response.sendRedirect(request.getContextPath()+"/index.jsp");
//} %>
</body>
</html>