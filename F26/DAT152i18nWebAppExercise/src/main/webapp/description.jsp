<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>DAT152 description</title>
</head>
<body>
<fmt:setBundle basename="no.hvl.dat152.lab26.Info" var="info"/>
<a href="index.jsp"><fmt:message key="coursedeschomelink" bundle="${info}"/></a>
<p><fmt:message key="coursedescription" bundle="${info}"/></p>
</body>
</html>
