<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
First name is:${stu.firstName}<br/><br>
Last name is:${stu.lastName}<br/><br>
My country is...${stu.country}<br><br>
Favourite language is...${stu.favouriteLanguage }<br><br>
Operating system is... 
<c:forEach var="operatingSystems" items="${stu.operatingSystems}">
${operatingSystems}<br>
</c:forEach>
<br>
</body>
</html>