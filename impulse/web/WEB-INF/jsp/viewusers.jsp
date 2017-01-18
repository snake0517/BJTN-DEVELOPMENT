<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
    <head>
        <title>Manage Users</title>
        <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
    </head>
    <body>

        <h1>Manage Users</h1>  
        <a href="usersform">Add New Users</a><br/><br/>
        <table border="1" width="70%" cellpadding="2">  
            <tr>
                <th>Username</th>

                <th>Action</th>

            </tr>  

            <c:forEach var="users" items="${list}">   
                <tr>  
                    <td>${users.username}</td>  


                    <td><a href="editusers/${user_role.username}">Edit</a> <a href="deleteusers/${user_role.username}">Delete</a></td>  
                </tr>  
            </c:forEach>  
        </table>  
        <br/> 
    </body>
</html>