<%-- 
    Document   : addressForm
    Created on : Dec 1, 2018, 12:42:16 AM
    Author     : Dovile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <h1>Welcome to address form </h1>
        
        <a href="${pageContext.request.contextPath}/persons/${address.personId.id}/addresses"><button>To Addresses</button></a>

         <form:form method="POST" action="save" modelAttribute="address">
              <table>
                     <tbody>
                            <tr>
                                <td><form:label path="id" >Id</form:label></td>
                                <td><form:input path="id" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="personId.id">Person Id</form:label></td>
                                <td><form:input path="personId.id" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="address">Address</form:label></td>
                                <td><form:input path="address" /></td>
                            </tr>
                          
                            <tr>
                                <td><form:label path="city">City</form:label></td>
                                <td><form:input path="city"/></td>
                            </tr>
                            <tr>
                                <td><form:label path="postalCode">Postal Code</form:label></td>
                                <td><form:input path="postalCode"/></td>
                            </tr>
                             <tr>              
                                <td><input type="submit" value="Submit"/></td>
                            </tr>
                    </tbody>
              </table>
    </form:form>
</body>
</html>
