<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/prodapt" user="root" password="root"/>
<sql:query var="rs" dataSource="${db}">select * from employee</sql:query>
<c:forEach var="emp" items="${rs.rows}">
<c:out value="${emp.eid}"></c:out>
<c:out value="${emp.eName}"></c:out>
<c:out value="${emp.eDest}"></c:out>
<c:out value="${emp.eSal}"></c:out>
</c:forEach>
</body>
</html>