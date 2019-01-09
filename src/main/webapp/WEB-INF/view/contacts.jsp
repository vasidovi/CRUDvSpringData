<%-- 
    Document   : contacts
    Created on : Nov 30, 2018, 11:47:50 PM
    Author     : Dovile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.request.contextPath}/">
    </head>
    <body>
        <h1>Contacts!</h1>
         
                <button>   <a href="">To Persons</a></button>       
        
        <table>
            <thead>
            <th>
                Id
            </th>
            <th>
                P_Id
            </th>
            <th>
               Contact Type
            </th>
            <th>
                Contact
            </th>
        </thead> 
        <tbody>
            <c:forEach var="contact" items="${contactsList}">                    
                <tr>
                    <td class="opt_visible">
                        <c:out value="${contact.id}" />
                    </td>
                    <td class="opt_visible">
                        <c:out value="${contact.personId.id}" />
                    </td>
                    <td>
                        <c:out value="${contact.contactType}" />
                    </td>
                    <td>
                        <c:out value="${contact.contact}" />
                    </td>
                    <td>
                        <a href="persons/${contact.personId.id}/contacts/<c:out value="${contact.id}" />/forms">
                            <button>
                                Update
                            </button>
                    </td>
                    <td>
                        <a href="persons/${contact.personId.id}/contacts/<c:out value="${contact.id}" />/delete">
                            <button>
                                Delete
                            </button>
                    </td>                                                                        
                </tr>

            </c:forEach>
        </tbody>

        </table>
        <button>   <a href="persons/${personId}/contacts/forms">Add Contact</a></button>


</body>
</html>
