<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	out.println(request.getParameter("uname"));
	%>
<%! int n1=10,n2=20; %>
<%= n1+n2 %>

<% List list=Arrays.asList(1,2,3,4);

Iterator itr=list.iterator();

while(itr.hasNext()){

    out.println(itr.next());
    

}

%>
</body>
</html>