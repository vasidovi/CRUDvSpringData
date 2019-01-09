<%-- 
    Document   : index
    Created on : Nov 27, 2018, 11:10:07 AM
    Author     : Eim
--%>

<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Persons!</h1>

        <table>
            <thead>
            <th>
                Id
            </th>
            <th>
                First Name   
            </th>
            <th>
                Last Name
            </th>
            <th>
                Birth Date
            </th>
            <th>
                Salary
            </th>
        </thead> 
        <tbody>
            <c:forEach var="person" items="${list}">                    
                <tr>
                    <td class="opt_visible">
                        <c:out value="${person.id}" />
                    </td>
                    <td>
                        <c:out value="${person.firstName}" />
                    </td>
                    <td>
                        <c:out value="${person.lastName}" />
                    </td>
                    <td>
                        <fmt:setTimeZone value="Europe/London" scope="session"/>
                        <fmt:formatDate value="${person.birthDate}" pattern="yyyy-MM-dd" />
                    </td>
                    <td>
                        <c:out value="${person.salary}" />
                    </td>
                    <td>
                        <a href="persons/<c:out value="${person.id}" />/forms">
                            <button>
                                Update
                            </button>
                    </td>
                    <td>
                        <a href="persons/<c:out value="${person.id}" />/delete">
                            <button>
                                Delete
                            </button>
                    </td>
                    <td>
                        <a href="persons/<c:out value="${person.id}" />/contacts">
                            <button>
                                Contacts
                            </button>
                    </td>
                    <td>
                        <a href="persons/<c:out value="${person.id}" />/addresses">
                            <button>
                                Addresses
                            </button>
                    </td>                                                       
                </tr>



            </c:forEach>
        </tbody>

    </table>
    <button>   <a href="persons/forms">Add Person</a></button>

</body>

</html>
