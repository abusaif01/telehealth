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
	
//	Vector <Disease> diseasesList=(Vector<Disease>)treatmentDecision.root.childs;
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/main_layout.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

<title>Health Problem Description </title>
</head>
<body>

<div id="pTitle" >
<p class="text-center text-success">Dear Patient(name) , Please describe your health problem below</p>
</div>
<div id="">
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
	<p class="span4"> </p>
<input   type="submit" title="Submit Your Health Condition" />
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
	var httpRes;
	
	if(selected==0)
	{
		infoDiv.innerHTML="";
		return;
	}
	httpRes=new XMLHttpRequest("additionalInfo");
	httpRes.onreadystatechange=function()
	{
		if(httpRes.readyState==4 && httpRes.status==200)
		{
			infoDiv.innerHTML=httpRes.responseText;	
		}
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