<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="signup.css">
<link rel="icon" type="image/png" href="images/infoobjects_index.png">
<title>Sign Up | InfoObjects</title>
</head>
<body>
<div class="whole">
<div class="gif">
<img src="images/hathi_mera_friend.gif">
<h1><span class="c1">INFO</span><span class="c2">OBJECTS INC.</span></h1>
</div>
<div class="normal">
<center><img src="images/infoobjects_logo.png"></center><br/>
<p id="validate"></p>
<form name="signUpForm" action="SignUp" method="POST" onSubmit="return validateSignup()">
<input style="line-height: 2.0;" type="text" name="username" 
placeholder="Username" onkeydown="return validateUserName()" required/><br/>
<input style="line-height: 2.0;" type="password" name="password" placeholder="Password" required/><br/>
<input style="line-height: 2.0;" type="password" name="confirmpassword" placeholder="Confirm Password" required/><br/>
<input style="line-height: 2.0;" type="text" name="name" placeholder="Good Name" required/><br/>
<input style="line-height: 2.0;" type="text" name="birthday" placeholder="Birthday(dd/mm/yyyy)" required/><br/>
<input style="line-height: 2.0;" type="text" name="gender" placeholder="Gender" required/><br/>
<textarea rows="4" cols="31" name="address" placeholder="Address Goes Here..." required></textarea><br/>
<input style="line-height: 2.0;" type="text" name="phone" placeholder="Phone Number" required/><br/>
<input type="submit" href="#" value="submit"/>
</form>
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
if(session.getAttribute("password_did_not_match") != null){
%>
<script>
document.getElementById("validate").innerHTML="Password Did Not Match";
</script>

<%
session.removeAttribute("password_did_not_match");
}

%>
<%
if(session.getAttribute("username_already_exist") != null){
%>
<script>
document.getElementById("validate").innerHTML="Username Already Exist. Kindly Try Another Username";
</script>

<%
session.removeAttribute("password_did_not_match");
}

%>

</body>
</html>