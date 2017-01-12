<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
  <head>
    <title>Manage Clients</title>
    <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
  </head>
  <body>
    <h1>Edit Artist</h1>  
    
    <form:form method="POST" action="/Impluse/client/editsave">    
      <table >    
        <tr>  
          <td></td>    
          <td><form:hidden  path="clientid" /></td>  
        </tr>   
        <tr>    
          <td>Name : </td>   
          <td><form:input path="firstname"  /></td>  
        </tr>

        <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
        </tr>    
      </table>    
    </form:form>    

  </body>
</html>