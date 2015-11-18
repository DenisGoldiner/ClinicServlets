<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 09.11.2015
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/user/create" method="POST">
  <table>
    <tr>
      <td align="right">Client Name : </td>
      <td>
        <input type="text" name="clientName">
      </td>
    </tr>
    <tr>
      <td align="right">Pet Name : </td>
      <td>
        <input type="text" name="petName">
      </td>
    </tr>
    <tr>
      <td align="right">Pet Age : </td>
      <td>
        <input type="text" name="petAge">
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit" align="center" value="Submit"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
