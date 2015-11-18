<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 09.11.2015
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <title></title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/user/CreateUser.jsp">Add Client</a>
<table border="1">
  <tr>
    <td>clientName petName petAge</td>
    <td>Actions</td>
  </tr>
  <c:forEach items="${clients}" var="client" varStatus="status">
    <tr valign="top">
      <td>${client.ClientName} ${client.pet.petName} ${client.pet.petAge}</td>
      <td>
        <a href="${pageContext.servletContext.contextPath}/user/edit?id=${client.id}">Edit</a>
        <a href="${pageContext.servletContext.contextPath}/user/delete?id=${client.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
