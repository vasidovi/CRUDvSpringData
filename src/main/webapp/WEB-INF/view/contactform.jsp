<%-- 
    Document   : contactForm
    Created on : Dec 1, 2018, 12:41:53 AM
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
        <h1>Welcome to contact form </h1>
        
                <a href="${pageContext.request.contextPath}/persons/${contact.personId.id}/contacts"><button>To Contacts</button></a>


         <form:form method="POST" action="save" modelAttribute="contact">
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
                                <td><form:label path="contactType">Contact type</form:label></td>
                                <td><form:input path="contactType" /></td>
                            </tr>
                          
                            <tr>
                                <td><form:label path="contact">Contact</form:label></td>
                                <td><form:input path="contact"/></td>
                            </tr>
                             <tr>              
                                <td><input type="submit" value="Submit"/></td>
                            </tr>
                    </tbody>
              </table>
    </form:form>
</body>
</html>
