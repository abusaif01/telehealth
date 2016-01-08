<%@page import="java.util.List"%>
<%@page import="tel.data.model.DataConstant"%>
<%@page import="tel.data.model.Patient"%>
<%@page import="tel.data.model.tree.MyNode"%>
<%@page import="java.util.Vector"%>
<%@page import="tel.data.model.tree.Medicine"%>
<%@page import="tel.data.model.tree.TreatmentDecisionTree"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	TreatmentDecisionTree treatmentTree=TreatmentDecisionTree.getTreatmentDecisionTree();

	Patient patient=(Patient)request.getSession().getAttribute(DataConstant.SESSION_ID_PATIENT_STRING);
	if(patient==null)
	{
		response.sendRedirect("index.jsp");
	}

	Medicine med=null;
	Vector<Medicine> medList=(Vector<Medicine>)request.getAttribute("medicines");
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>You Prescription</title>
<link rel="stylesheet" type="text/css" href="css/prescription.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/main_layout.css" />
</head>
<body style="background: url('resource/wallpaer_back.jpg');">
<div id="presHead"> <h3> Your Prescription</h3></div>
<div id="mainContainerDiv"> 
	<div id="infos">
		<div id="ourInfo">
		<address>
		  <strong>Tele-Health Service</strong><br>
		  On Going Academic Project<br>
		  CSE JU<br>
		  <abbr title="Phone">hotline:</abbr> (+88) 01914820010
		</address>
		</div>
		<div id="patientInfo">
		<p><strong>Patient Name:</strong>  <%= patient.getFirstName()+"  "+patient.getLastName() %></p>
		<p><strong>Age:</strong> <%= patient.getAge() %> Years. </p>
		<p><strong>Weight:</strong><%= patient.getWeight() %> Kg.</p>
		</div>
	</div>
	
	<table id="treamentInfo" >
	<tr>
	<td id="healthinfos" >
	<p><strong>Disease: </strong> <%= treatmentTree.selectedDisease.getDiseaseName() %></p>
	<p><strong>Aditiona Health Info: </strong+> </p>
	
	</td>
	<td id="medicines" >
	<%
		for(int i=0;i<medList.size();i++)
		{
			med=medList.get(i);
			if(med.getMedicineName()!=null)
			{
			out.println((i+1)+" ).  <strong>");
			out.println(med.getMedicineName()+"</strong> ----- "+med.getDessity()+"  "+med.getMedTime()+" times a day  "
			+med.getMedDays()+" days. "+"</br>");
			}
		}
		
	%>
	</td>

 </tr>
</table>
 </div>
</body>
</html>