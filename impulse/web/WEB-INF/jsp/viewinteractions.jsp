<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
    <head>
        <title>Manage Interactions</title>
        <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
    </head>
    <body>

        <h1>Manage Interactions</h1>  
        <a href="interactionsform">Add New Interactions</a><br/><br/>
        <table border="1" width="70%" cellpadding="2">  
            <tr>
                <th>Id</th>
                <th>First Name</th>

                <th>Action</th>
            </tr>  

            <c:forEach var="interactions" items="${list}">   
                <tr>  
                    <td>${interactions.clientid}</td>  
                    <td>${interactions.contactPerson}</td> 

                    <td><a href="editinteractions/${interactions.clientid}">Edit</a> <a href="deleteinteractions/${interactions.clientid}">Delete</a></td>  
                </tr>  
            </c:forEach>  
        </table>  
        <br/> 
    </body>
</html>