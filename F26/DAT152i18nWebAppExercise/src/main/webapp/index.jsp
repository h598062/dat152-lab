<%@ page import="java.util.Locale" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exercise F25 - Globalization and Custom Tags</title>
</head>
<body>
<p>
    <jsp:include page="SetupLanguage.jsp"/>
</p>
<fmt:setBundle basename="no.hvl.dat152.lab26.Info" var="info"/>
<jsp:useBean id="now" class="java.util.Date"/>
<h1><fmt:message key="title" bundle="${info}"/></h1>
<p><fmt:message key="datetxt" bundle="${info}"/> <fmt:formatDate value="${now}"/></p>
<p><fmt:message key="minidesc" bundle="${info}">
    <fmt:param value="50"/><fmt:param value="100"/></fmt:message></p>
<table>
    <thead>
    <tr>
        <th><fmt:message key="course-table-title" bundle="${info}"/></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><fmt:message key="course-table-code" bundle="${info}"/></td>
        <td><fmt:message key="course-table-code-val" bundle="${info}"/></td>
    </tr>
    <tr>
        <td><fmt:message key="course-table-coursename" bundle="${info}"/></td>
        <td><fmt:message key="course-table-coursename-val" bundle="${info}"/></td>
    </tr>
    <tr>
        <td><fmt:message key="course-table-semester" bundle="${info}"/></td>
        <td><fmt:message key="course-table-semester-val" bundle="${info}"/></td>
    </tr>
    <tr>
        <td><fmt:message key="course-table-lecturers" bundle="${info}"/></td>
        <td><fmt:message key="course-table-lecturers-val" bundle="${info}"/></td>
    </tr>
    </tbody>
</table>
<p><a href="description.jsp"><fmt:message key="coursedesclink" bundle="${info}"/></a></p>
<h1><fmt:message key="examtitle" bundle="${info}"/></h1>
<%
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    String dateInString = "28-11-2024";
    Date examDate = formatter.parse(dateInString);
    request.setAttribute("examDate", examDate);
%>
<table>
    <tbody>
    <tr>
        <td><fmt:message key="exam-table-date" bundle="${info}"/> <fmt:formatDate value="${examDate}"/></td>
    </tr>
    <tr>
        <td><fmt:message key="exam-table-duration" bundle="${info}"/>
            <fmt:message key="exam-table-duration-val" bundle="${info}"><fmt:param value="4"/></fmt:message></td>
    </tr>
    <tr>
        <td><fmt:message key="exam-table-type" bundle="${info}"/> <fmt:message key="exam-table-type-val"
                                                                               bundle="${info}"/></td>
    </tr>
    <tr>
        <td><fmt:message key="exam-table-passmark" bundle="${info}"/> <fmt:message key="exam-table-passmark-val"
                                                                                   bundle="${info}"/></td>
    </tr>
    </tbody>
</table>
</body>
</html>
