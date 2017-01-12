<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
    <head>
        <title>Manage Interactions</title>
        <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
    </head>
    <body>
        <h1>Edit Interactions</h1>  

        <form:form method="POST" action="/impulse/interactions/editsave">    
            <table >    
                <tr>  
                    <td></td>    
                    <td><form:hidden  path="clientid" /></td>  
                </tr>   
                <tr>    
                    <td>Occurred On : </td>   
                    <td><form:input path="occuredOn"  /></td>  
                </tr> 
                <tr>    
                    <td>Contact Person : </td>   
                    <td><form:input path="contactPerson"  /></td>  
                </tr> 
                <tr>    
                    <td>Contact Type : </td>   
                    <td><form:input path="contactType"  /></td>  
                </tr> 
                <tr>    
                    <td>Notes : </td>   
                    <td><form:input path="notes"  /></td>  
                </tr> 


                <tr>    
                    <td> </td>    
                    <td><input type="submit" value="Edit Save" /></td>    
                </tr>    
            </table>    
        </form:form>    

    </body>
</html>