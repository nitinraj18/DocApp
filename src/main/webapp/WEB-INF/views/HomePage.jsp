<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.File" %>
<%@ page isELIgnored="false"%>


<!DOCTYPE html>
<style>
#center {
	margin: auto;
	width: 80%;
	padding: 10px;
}

td {
	border: 1px solid #000;
}

tr td:last-child {
	width: 1%;
	white-space: nowrap;
}
</style>
<head>
<script>
	if (window.history.replaceState) {
		window.history.replaceState(null, null, window.location.href);
	}
</script>

</head>
<title>Patient Appointment Form</title>
<body>
 <div align="center">
  <h1>Patient Appointment Form</h1>
  <form class="needs-validation" action="savepatient" method="post" enctype="multipart/form-data">
   <table style="width: 50%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Age</td>
     <td><input type="text" name="age" /></td>
    </tr>
    <tr>
     <td>DOB</td>
     <td><input type="date" name="dob" /></td>
    </tr>
    <tr>
     <td>Blood Group</td>
     <td><input type="text" name="bloodGroup" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" /></td>
    </tr>
    <tr>
     <td>Mobile Number</td>
     <td><input type="text" name="mobileNumber" /></td>
    </tr>
    <tr>
     <td>Email Id</td>
     <td><input type="text" name="emailId" /></td>
    </tr>
    <tr>
     <td>Date of Appointment</td>
     <td><input type="date" name="dateOfAppointment" /></td>
    </tr>
    <tr>
     <td>Upload file</td>
     <td><input type="file" name="reportPath" id="reportPath" multiple accept="application/pdf"/></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
 
 <a href="viewdata">View Data</a>
</body>
</html></body>
</html>


