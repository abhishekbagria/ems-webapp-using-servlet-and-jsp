<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>




<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="login.css">
<link rel="icon" type="image/png" href="images/infoobjects_index.png">
<title>Sign In | InfoObjects</title>
</head>
<body>


<div class="whole">
<div class="gif">
<img src="images/hathi_mera_friend.gif">
<h1><span class="c1">INFO</span><span class="c2">OBJECTS INC.</span></h1>
</div>
<div class="normal">
<center><img src="images/infoobjects_logo.png"></center><br/>
<p id="validate"><p id="success"></p></p>
<form action="Login" method="POST" id="signin" onSubmit="return validateLogin()">
<input style="line-height: 2.0;" type="text" name="username" placeholder="Username" required><br/>
<input style="line-height: 2.0;" type="password" name="password" placeholder="Password" required></br>
<input id="si" type="submit" href="#" value="Sign in"/>
</form>
<strong style="color:grey; font-size: 0.6875em; line-height: 2.0;text-align: right;">New to Infoobjects?</strong><a href="/EMSUsingJSPandServlet/sign_up.jsp" class="signup">Sign up</a>
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
if(session.getAttribute("wrong_uname_pass") != null){
%>
<script>
	document.getElementById("validate").innerHTML="Wrong Username or Password";
</script>
<%
session.removeAttribute("wrong_uname_pass");
}
%>
<%
if(session.getAttribute("sign_up_successful") != null){
%>
<script>
document.getElementById("success").innerHTML="You have signed up Successfully\n Try Signing In";
</script>

<%
session.removeAttribute("sign_up_successful");
}

%>
<%
if(session.getAttribute("log_out_successful") != null){
%>
<script>
document.getElementById("success").innerHTML="You have logged out Successfully";
</script>

<%
session.removeAttribute("log_out_successful");
session.invalidate();
}

%>

<%
//if(session.getAttribute("cant_go_back") != null && session.getAttribute("log_out_successful") == null){
%>
<script>
//document.getElementById("validate").innerHTML="Please Sign In Again";
</script>

<%
//session.removeAttribute("log_out_successful");
//session.removeAttribute("cant_go_back");
//session.invalidate();
//}

%>
</body>
</html>