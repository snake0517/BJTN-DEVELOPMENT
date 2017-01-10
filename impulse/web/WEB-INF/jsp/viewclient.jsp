<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
  <head>
    <title>Manage Clients</title>
    <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
  </head>
  <body>

    <h1>Manage Clients</h1>  
    <a href="artistform">Add New Client</a><br/><br/>
    <table border="1" width="70%" cellpadding="2">  
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
      </tr>  

      <c:forEach var="client" items="${list}">   
        <tr>  
          <td>${client.Clientid}</td>  
          <td>${client.Firstname}</td>  
          <td><a href="editartist/${client.Clientid}">Edit</a> <a href="deleteartist/${client.Clientid}">Delete</a></td>  
        </tr>  
      </c:forEach>  
    </table>  
    <br/> 
  </body>
</html>