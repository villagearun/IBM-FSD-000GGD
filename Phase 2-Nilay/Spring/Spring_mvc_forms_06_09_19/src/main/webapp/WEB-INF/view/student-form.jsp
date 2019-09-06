<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
first name:<form:input path="firstName"/><br/><br>

last name:<form:input path="lastName"/><br/><br>

Choose country:<form:select path="country">
  <form:options items="${student.countryoptions}"/>
  </form:select>
  <br/><br>
  
  Favourite Languages:
    <form:radiobutton path="favouriteLanguage" value="C"/>C
     <form:radiobutton path="favouriteLanguage" value="C++"/>C++
      <form:radiobutton path="favouriteLanguage" value="Java"/>Java
       <form:radiobutton path="favouriteLanguage" value="C#"/>C#<br><br>
       
  Operating Systems:
  <form:checkbox path="operatingSystems" value="Android"/>Android
  <form:checkbox path="operatingSystems" value="Ios"/>IOs
  <form:checkbox path="operatingSystems" value="Blackberry"/>Blackberry
  <form:checkbox path="operatingSystems" value="Windows"/>Windows
  
  
  
<input type="submit">
</form:form>
</body>
</html>