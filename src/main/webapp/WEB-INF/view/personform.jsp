<%-- 
    Document   : personform
    Created on : Nov 28, 2018, 5:41:22 PM
    Author     : Dovile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ page isELIgnored="false" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <title>JSP Page</title>
        <style>
            input#id { width: 25px; }
            input{ width: 150px;}
            label{width: 50px;}

            thead tr th:first-child,
            tbody tr td:first-child {

                max-width: 100px;
                font-weight: bold;
            }


        </style>

        <base href="${pageContext.request.contextPath}/persons/forms">
    </head>
    <body>
        <h1>Welcome to Person form </h1>

        <a href="${pageContext.request.contextPath}"><button>To Persons</button></a>


         <form:form method="POST" action="save" modelAttribute="person">
                         <table>
                           <tr style="display: none">
                                        <td><form:label path="id" >Id</form:label></td>
                                        <td><form:input path="id" /></td>
                                    </tr>
                                <tr>
                                        <td><form:label path="firstName">First Name</form:label></td>
                                        <td><form:input path="firstName" /></td>
                                    </tr>
                <tr>
                                        <td><form:label path="lastName">Last Name</form:label></td>
                                        <td><form:input path="lastName" /></td>
                                    </tr>
                <tr>
                                        <td><form:label path="birthDate">Birth Date</form:label></td>

                                            <td>

                        <form:input path="birthDate" type="date" /></td>
                                    </tr>
                <tr>
                                        <td><form:label path="salary">Salary</form:label></td>
                                        <td><form:input path="salary" pattern="\d+(.\d{2})?"/></td>
                                    </tr>              
                                    <td><input type="submit" value="Submit"/></td>
                                </tr>
                        </table>
                </form:form>


    <script















</body>

</html>
