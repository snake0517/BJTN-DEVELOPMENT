<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
  <head>
    <title>Manage User Role</title>
    <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
  </head>
  <body>

    <h1>Manage User Role</h1>  
    <a href="user_roleform">Add New User Role</a><br/><br/>
    <table border="1" width="70%" cellpadding="2">  
      <tr>
        <th>Username</th>
        <th>Role</th>
        
        <th>Action</th>
      </tr>  

      <c:forEach var="user_role" items="${list}">   
        <tr>  
          <td>${user_role.username}</td>  
          <td>${user_role.role}</td> 
          
          <td><a href="edituserroles/${user_role.username}">Edit</a> <a href="deleteuserroles/${user_role.username}">Delete</a></td>  
        </tr>  
      </c:forEach>  
    </table>  
    <br/> 
  </body>
</html>