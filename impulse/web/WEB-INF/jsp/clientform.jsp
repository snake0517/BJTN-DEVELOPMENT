<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
  <head>
    <title>Manage Clients</title>
    <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
  </head>
  <body>
    <h1>Add New Client</h1>  
    <form:form method="post" action="save">    
      <table >    
        <tr>    
          <td>Name : </td>   
          <td><form:input path="FirstName"  /></td>  
        </tr> 
        <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
        </tr>    
      </table>    
    </form:form>
  </body>
</html>