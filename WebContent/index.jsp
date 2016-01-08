<%@page import="tel.service.manager.DoctorManager"%>
<%@page import="java.util.List"%>
<%@page import="tel.data.model.Doctor"%>
<%@page import="tel.data.model.Patient"%>
<%@page import="tel.data.model.Message"%>
<%@page import="tel.data.model.DataConstant"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Doctor doctor=null;
	Doctor tempDoc=null;
	Patient patient=null;
	boolean isLoggedIn=false;
	String firstName=null;
	String lastName=null;
	List<Doctor> docotrList=new DoctorManager().getDoctorsList();
	
	patient=(Patient)session.getAttribute(DataConstant.SESSION_ID_PATIENT_STRING);
	doctor=(Doctor)session.getAttribute(DataConstant.SESSION_ID_DOCTOR_STRING);
	
	if(patient!=null)
	{
		isLoggedIn=true;
		firstName=patient.getFirstName();
		lastName=patient.getLastName();
	}
	else if(doctor!=null)
	{
		firstName=doctor.getFirstName();
		lastName=doctor.getLastName();
		isLoggedIn=true;
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/main_layout.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<title>Wellcome To Tele Health Service</title>

</head>

<body>
<div id="head">
  <h1>This Is Our Tele-Health Service</h1>
	<div id="log_reg" >
	<%
		if(isLoggedIn)
			{
	%>
	<div class="btn-group">
      <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
        <%
        	out.print(firstName+" "+lastName);
        %>
        <span class="caret"></span>
      </a>
      <div class="dropdown-menu">
     	 <li><a href="profile.jsp">Profile</a></li>
 		 <li><a href="#">History</a></li>
 		 <li><a href="#">History</a></li>
 		 <li><a href="#">History</a></li>
 		 <li><a href="#" onClick="userLogout()">Log Out</a></li>
      </div>
<!--       
     <ul class="dropdown-menu">
        <!-- dropdown menu links 
         <li><a href="#">Profile</a></li>
 		 <li><a href="#">History</a></li>
      </ul>
  -->
    </div>
	
	<%
			}
				else
				{
		%>
		<a href="#loginModal" data-toggle="modal">Login/Register </a>
	<%
		}
	%>
    </div>
</div>
<div id="main_body" >
<div id="main_menu">
    <table id="menu_table">
   	  <tr >
       	  <td>Home </td> 
       	  <td><a href="healthDes.jsp">Take Consultancy</a></td> 
        	<td>Record</td> 
        	<td>About Us</td>
        </tr>
    </table>
</div>

<div class="accordion" id="doctorList">
  <div class="accordion-group">
    <div class="accordion-heading">
      <a class="accordion-toggle" data-toggle="collapse" data-parent="#doctorList" href="#collapseOne" onClick="">
        Our Consultant
      </a>
    </div>
    <div id="collapseOne" class="accordion-body collapse">
      <div class="accordion-inner">
       <ul>
       <%
       		for(int i=0;i<docotrList.size();i++)
       		{
       			tempDoc= docotrList.get(i);
	       		out.println("<li><a href=\"doctors.jsp?id="+tempDoc.getUserId()+"\">");
	       		out.println(tempDoc.getFirstName()+" "+tempDoc.getLastName());
	      		out.println("</a></li>");
       		}
       	 %>
       </ul>
       
      </div>
    </div>
  </div>
</div>
 


</div>


<div id="loginModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

  <table class="table table-bordered" style="margin-bottom:0px" >
    <tr>
    <td>
     <form class="form-horizontal" method="get">
      <input type="text" class="input-small" id="userName" name="userName" placeholder="user name">
      <input type="password" class="input-small" id="userPassword" name="userPassword" placeholder="Password">
      <label class="checkbox">
        <input type="checkbox"> Remember me
      </label>
      <button type="button" class="btn" onClick="loginuser()">Log... in</button>
      <div  id="message">
      </div>
    </form>
    </td>
    <td>
      <a href="registration.jsp" >Not Registered? Register Now.</a>
    </td>
    </tr>
  </table>
</div>

<script src="js/jquery-2.0.3.js"></script>
<script src="js/bootstrap.js"></script>
<script>
function  loginuser()
{
	var httpRes;
	var userName=document.getElementById("userName");
	var userPass=document.getElementById("userPassword");
	var message=document.getElementById("message");
	httpRes=new XMLHttpRequest();
	
	httpRes.onreadystatechange=function()
	{
		if(httpRes.readyState==4 && httpRes.status==200)
		{
			if(httpRes.responseText=="1")
			{
				message.className="alert alert-success";
				message.innerHTML="Successfully Logged In";
				location.href="index.jsp";
			}
			else if(httpRes.responseText=="2")
			{
				message.className="alert alert-error";
				message.innerHTML="Wrong User Name or Password";
			}
			
			
		}
	}
	httpRes.open("GET","./logon?"+userName.name+"="+userName.value+"&"+userPass.name+"="+userPass.value,true);
	httpRes.send();
}

function userLogout()
{
	<%
	  session.setAttribute(DataConstant.SESSION_ID_PATIENT_STRING, null);
      session.setAttribute(DataConstant.SESSION_ID_DOCTOR_STRING, null);
	%>
	location.href="index.jsp";
}


</script>

</body>
</html>