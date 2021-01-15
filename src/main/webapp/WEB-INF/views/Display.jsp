<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<H1><center>Appointment Confirmation</center></H1>
<h2>
Doctor Name Available: <input type="text" name="doctorAvailable"></h2>

<c:if test="${patientList!=null}">
							     <table border="1"'>
									<thead>
										<tr>
										<th>ID</th>
											<th>Name</th>
											<th>age</th>
											<th>DOB</th>
											<th>BloodGroup</th>
											<th>Address</th>
											<th>MobileNumber</th>
											<th>EmailId</th>
											<th>DOAppointment</th>
											<th>Send Mail</th>
										</tr>
									</thead>
				<c:forEach items="${patientList}" var="plist" >
					<tr >
					<td>${plist.getId()}</td>
					    <td>${plist.getName()}</td>
						<td>${plist.getAge()}</td>
						<td>${plist.getDob()}</td>
						<td>${plist.getBloodGroup()}</td>	
						<td>${plist.getAddress()}</td>
						<td>${plist.getMobileNumber()}</td>
						<td>${plist.getEmailId()}</td>
						<td>${plist.getDateOfAppointment()}</td>
						<td><button type="button" onclick="window.open('sendMail?toSend=${plist.getEmailId()}','_self')" >Send Mail</button></td>				
					</tr>
					</c:forEach>
								</table>
								</c:if>

</body>



</html>