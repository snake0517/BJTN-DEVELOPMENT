<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
  <head>
    <title>Manage User Role</title>
    <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
  </head>
  <body>
    <h1>Add User Role</h1>  
    <form:form method="post" action="save">    
      <table >    
        <tr>    
          <td>Username : </td>   
          <td><form:input path="username"  /></td>  
        </tr> 
        <tr>    
          <td>Role : </td>   
          <td><form:input path="role"  /></td>  
        </tr> 
        
        
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
        </tr>    
      </table>    
    </form:form>
  </body>
</html>
