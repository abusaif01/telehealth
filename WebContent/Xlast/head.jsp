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
	Doctor doctor=(Doctor)request.getSession().getAttribute(DataConstant.SESSION_ID_DOCTOR_STRING);
	Patient patient=(Patient)request.getSession().getAttribute(DataConstant.SESSION_ID_PATIENT_STRING);
	Doctor tempDoc=null;



	boolean isLoggedIn=false;
	String firstName=null;
	String lastName=null;
	List<Doctor> docotrList=new DoctorManager().getDoctorsList();
	
	
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
<title>Welcome To E-Health Service</title>

</head>

<body>
<div id="head">
  <h2>WelCome To Our E-Health Service</h2>
 <!--  <div  id=image1 class="headImages"> <img src="resource/mibile_doctor (2).jpg" />  </div> -->
  <div id="image2" class="headImages"><img src="resource/mibile_doctor (2).jpg" /></div>
  <div id="image3" class="headImages"></div>
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
 		 
 		 <li><a href="#" onClick="userLogout()">Log Out</a></li>
      </div>

    </div>
	
	<%
			}
				else
				{
		%>
		<a href="#loginModal" data-toggle="modal" >Login/Register </a>
	<%
		}
	%>
    </div>
</div>
<div id="main_body" >
<div id="main_menu">

<div class="navbar ">
  <div class="navbar-inner">
  <ul class="nav" id="menuNav">
  
  <li class="active"> <a  href="#"> Home</a> </li>
 <li> <a  href= <%
				if(isLoggedIn)
				{
					out.println("healthDes.jsp");	
				}
				else out.println("#loginModal data-toggle=\"modal\"");	
				%> >Take Consultancy</a></li>

	 <li> <a  href="#"> Record</a> </li>
	  <li> <a  href="#"> About Us</a> </li>
  </ul>
  </div>
 </div>

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
<div id="carouselDiv" style="position:relative;width: 60%; height:300px; left:20%; top:20px; ">
<div id="myCarousel" class="carousel slide">
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"> </li>
    <li data-target="#myCarousel" data-slide-to="1"> </li>
    <li data-target="#myCarousel" data-slide-to="2"> </li>
     <li data-target="#myCarousel" data-slide-to="3"> </li>
  </ol>
  <!-- Carousel items -->
  <div class="carousel-inner">
    <div class="active item"><img src="resource/slide_image/doctors_team1.jpg"   />
   		<div class="carousel-caption">
            <h4>First Image </h4>
            <p>----------------------</p>
          </div>
    </div>
    <div class="item"> <img src="resource/slide_image/doctors_team2.jpg" /> 
    	<div class="carousel-caption">
            <h4>Second Image </h4>
            <p>----------------------</p>
          </div>
    </div>
    <div class="item"><img src="resource/slide_image/doctor_on_phn.jpg" />
     	<div class="carousel-caption">
            <h4>Third Image </h4>
            <p>----------------------</p>
          </div>
     </div>
     <div class="item"><img src="resource/slide_image/doctor_on_phn_female.jpg" />
     	<div class="carousel-caption">
            <h4>Fourth Image </h4>
            <p>----------------------</p>
          </div>
     </div>
     
  </div>
  <!-- Carousel nav -->
  <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
  <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
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
       <!-- <input type="checkbox"> Remember me -->
      </label>
      <button type="button" class="btn" onClick="loginuser()">Log in</button>
      <div  id="message">
      </div>
    </form>
    </td>
    <td>
	    <div class="alert alert-block">
		  <a href="registration.jsp" >Not Registered? Register Now.</a>
		</div>
      
      <button type="button" class="btn" onclick="regLink()" >Register</button>
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
				return;
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
	httpRes=new XMLHttpRequest();
	httpRes.onreadystatechange=function()
	{
		if(httpRes.readyState==4 && httpRes.status==200)
		{
			if(httpRes.responseText=="1")
			{

				location.href="index.jsp";
				return;
			}
			else if(httpRes.responseText=="2")
			{
				message.className="alert alert-error";
				message.innerHTML="Wrong User Name or Password";
			}
			
			
		}
	}
	httpRes.open("GET","./Logout?",true);
	httpRes.send();
}

function regLink()
{
	location.href="registration.jsp";
}
</script>

</body>
</html>