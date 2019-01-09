<%-- 
    Document   : address
    Created on : Dec 1, 2018, 12:42:04 AM
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
        <h1>Addresses!</h1>
        
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
                Address
            </th>
            <th>
                City
            </th>
            <th>
                Postal Code
            </th>
            
        </thead> 
        <tbody>
            <c:forEach var="address" items="${addressesList}">                    
                <tr>
                    <td class="opt_visible">
                        <c:out value="${address.id}" />
                    </td>
                    <td class="opt_visible">
                        <c:out value="${address.personId.id}" />
                    </td>
                    <td>
                        <c:out value="${address.address}" />
                    </td>
                    <td>
                        <c:out value="${address.city}" />
                    </td>
                    <td>
                        <c:out value="${address.postalCode}" />
                    </td>
                    <td>
                        <a href="persons/${address.personId.id}/addresses/<c:out value="${address.id}" />/forms">
                            <button>
                                Update
                            </button>
                    </td>
                    <td>
                        <a href="persons/${address.personId.id}/addresses/<c:out value="${address.id}" />/delete">
                            <button>
                                Delete
                            </button>
                    </td>                                                                        
                </tr>

            </c:forEach>
        </tbody>

        </table>
        <button>   <a href="persons/${personId}/addresses/forms">Add Address</a></button>


</body>
</html>