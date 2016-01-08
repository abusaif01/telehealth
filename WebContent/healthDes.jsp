<%@page import="tel.data.model.DataConstant"%>
<%@page import="tel.data.model.User"%>
<%@page import="tel.data.model.tree.MyNode"%>
<%@page import="java.util.Vector"%>
<%@page import="tel.data.model.tree.Disease"%>
<%@page import="tel.data.model.tree.TreatmentDecisionTree"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Disease disease=null;
	TreatmentDecisionTree treatmentDecision=TreatmentDecisionTree.getTreatmentDecisionTree();
	MyNode root=treatmentDecision.root;
	
	User user=(User)request.getSession().getAttribute(DataConstant.SESSION_ID_PATIENT_STRING);
	if(user==null)
	{
		user=(User)request.getSession().getAttribute(DataConstant.SESSION_ID_DOCTOR_STRING);
	}
	
	if(user==null)
		response.sendRedirect("index.jsp");
//	Vector <Disease> diseasesList=(Vector<Disease>)treatmentDecision.root.childs;
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/main_layout.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/healthDes.css" />
<title>Health Problem Description </title>
</head>
<body style="background: url('resource/wallpaer_back.jpg');">

<div id="pTitle" >
<h3 class="text-center text-info"> Dear <%= user.getFirstName()+"  "+user.getLastName() %>  , Please describe your health problem below</h3> 
</div>
<div id="mainContainerDiv">
<p class="span4">Define Your Health Problem </p>
<select  id="diseasesDropDwon" onchange="diseaseSelection()" >
  <option value="0">--------</option>
   <%
   	for(int i=0;i<root.childs.size();i++)
	  {
	   	//dis=diseasesList.get(i);
	   	disease=(Disease)root.childs.get(i);
	  	out.println("<option value="+(i+1)+">"+disease.getDiseaseName()+"</option>");
	  
	  }
   %>
</select>

<div id="additionalInfo" >
<form action="./DiseasesQuery" method="post" >
	<div id="additionInfoForm">
	
	</div>
	
	<div id="btnDiv">
		
		<input  id="submitBtn" type="submit" value="Submit Your Health Condition"  class="btn btn-primary btn-large" />
	</div>
</form>

</div>
 
</div>

<script src="js/jquery-2.0.3.js"></script>
<script src="js/bootstrap.js"></script>

<script >
function diseaseSelection()
{
	var dropDwon=document.getElementById("diseasesDropDwon");
	var selected =dropDwon.options[dropDwon.selectedIndex].value;
	var infoDiv=document.getElementById("additionInfoForm");
	var btn=document.getElementById("submitBtn");
	var httpRes;
	
	if(selected==0)
	{
		infoDiv.innerHTML="";
		btn.style.display = 'none';
		return;
	}
	httpRes=new XMLHttpRequest("additionalInfo");
	httpRes.onreadystatechange=function()
	{
		if(httpRes.readyState==4 && httpRes.status==200)
		{
			infoDiv.innerHTML=httpRes.responseText;	
		}
		btn.style.display = 'block';
		
	}
	httpRes.open("GET","./DiseasesQuery?diseaseId="+selected,true);
	httpRes.send();

}

function additionalInfo()
{

	
}


</script>

</body>
</html>