<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
    <head>
        <title>Manage User Roles</title>
        <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
    </head>
    <body>
        <h1>Edit User Role</h1>  

        <form:form method="POST" action="/impulse/user_role/editsave">    
            <table >    
                <tr>  
                    <td></td>    
                    <td><form:hidden  path="user_role_id" /></td>  
                </tr>   
                <tr>    
                    <td>Username : </td>   
                    <td><form:input path="username"  /></td>  
                </tr> 
                <tr>    
                    <td>Role : </td>   
                    <td><form:input path="role"  /></td>  
                </tr> 

                <tr>    
                    <td> </td>    
                    <td><input type="submit" value="Edit Save" /></td>    
                </tr>    
            </table>    
        </form:form>    

    </body>
</html>