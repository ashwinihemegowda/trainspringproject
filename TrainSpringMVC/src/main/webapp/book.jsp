<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <!DOCTYPE html>
<html>
<body>
<form action="">
<table>
 <c:forEach var="train" items="${find}">
     <tr>
     <td>Train no:</td>
     <td><input type="text" value="${train.trainNo}" readonly></td><br>
     <td>Train name:</td>
     <td><input type="text" value=${train.trainName} readonly></td><br>
   <td>  Source:</td>
   <td><input type="text" value=${train.source} readonly></td><br>
     <td>destination:</td>
     <td><input type="text" value=${train.destination} readonly></td><br>
     <td>Ticket price:</td>
     <td><input type="text" value=${train.ticketPrice} readonly></td><br>
     </tr>
     </c:forEach>
     </table>
<button>submit</button>
</form>
</body>
</html>