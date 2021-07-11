<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/styles/bootstrap.min.css" />" rel="stylesheet">


<!--
You can use this form through Camunda Tasklist
by setting the formKey of a BPMN Start Event to:
embedded:/forms/report.jsp
-->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<div class="w3-container w3-light-grey">
<div class="w3-container w3-green w3-center">
  <h2>Corona Patient Details</h2>
</div>
<div  class="w3-margin-top">
<div  class="w3-margin-top">

</div>
<form  role="form">

<div style="background: aqua; text-align: center;">
	<table border="2" class="table .table-light table-striped table-bordered table-hover table-responsive-md">
 	<form >
		<thead class="thead-red">
			<tr style="color: red;font-size: 25">
			
			<td>Employee No</td>
			
		</tr>
		</thead>
		
		<c:if test="${!empty  emp}">
			<c:forEach var="dto" items="${emp}">
				<tr>
					<td>${dto}</td>
					
				</tr>
			</c:forEach>
		</c:if>


</form>
	</table>
</div>
		

</form>
</div>
</div>
