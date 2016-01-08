<%@page import="tel.data.model.DataConstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/main_layout.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<title>New User</title>
</head>
<body style="background: url('resource/wallpaer_back.jpg');">
<p ><h3 class="text-center text-info">User Registration</h3></p>
<div id="mainContainerDiv">
<form class="form-horizontal" method="get" action="./newUser">

   <div class="control-group">
    <label class="control-label" for="firstName">You Are A</label>
    <div class="controls">
      <label class="radio inline">
        <input type="radio" name="optionsRadios" id="optionsRadios1" value="<%out.print(DataConstant.RADIO_VALUE_PATIENT_STRING) ;%>" checked>
        Patient
      </label>
    <label class="radio inline">
       <input type="radio" name="optionsRadios" id="optionsRadios2" value="<%out.print(DataConstant.RADIO_VALUE_DOCTOR_STRING);%>">
       Doctor
    </label>
    </div>
  </div>


  <div class="control-group">
    <label class="control-label" for="firstName">First Name</label>
    <div class="controls">
      <input type="text" id="firstName" name="firstName" placeholder="first Name">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="lastName">Last Name</label>
    <div class="controls">
      <input type="text" id="lastName" name="lastName" placeholder="last Name">
    </div>
  </div>
  
  <div class="control-group">
    <label class="control-label" for="userName">User Name</label>
    <div class="controls">
      <input type="text" id="userName" name="userName" placeholder="User Name">
    </div>
  </div>
  
  <div class="control-group">
    <label class="control-label" for="inputPassword">Password</label>
    <div class="controls">
      <input type="password" id="inputPassword" name="userPassword" placeholder="Password">
    </div>
  </div>
  
   <div class="control-group">
    <label class="control-label" for="userAge">Age</label>
    <div class="controls">
      <input type="text" id="userAge" name="userAge" placeholder="Age">
    </div>
  </div>
  
   <div class="control-group">
    <label class="control-label" for="userWeight">Weight</label>
    <div class="controls">
      <input type="text" id="userWeight" name="userWeight" placeholder="Weight">
    </div>
  </div>
  
  
  <div class="control-group">
    <div class="controls">
     
      <button type="submit" class="btn">Sign Up</button>
    </div>
  </div>
</form>

</div>
</body>
</html>