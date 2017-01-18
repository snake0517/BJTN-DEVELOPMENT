<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
    <head>
        <title>Manage Clients</title>
        <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
    </head>
    <body>

        <h1>Manage Clients</h1>  
        <a href="clientform">Add New Client</a><br/><br/>
        <table border="1" width="70%" cellpadding="2">  
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Action</th>
            </tr>  

            <c:forEach var="client" items="${list}">   
                <tr>  
                    <td>${client.clientid}</td>  
                    <td>${client.firstName}</td> 
                    <td>${client.lastName}</td>
                    <td><a href="editclient/${client.clientid}">Edit</a> <a href="deleteclient/${client.clientid}">Delete</a></td>  
                </tr>  
            </c:forEach>  
        </table>  
        <br/> 
    </body>
</html>