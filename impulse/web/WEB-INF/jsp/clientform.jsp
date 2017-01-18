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
                    <td>First Name : </td>   
                    <td><form:input path="firstName"  /></td>  
                </tr> 
                <tr>    
                    <td>Last Name : </td>   
                    <td><form:input path="lastName"  /></td>  
                </tr> 
                <tr>    
                    <td>Address1 : </td>   
                    <td><form:input path="address1"  /></td>  
                </tr> 
                <tr>    
                    <td>Address2 : </td>   
                    <td><form:input path="address2"  /></td>  
                </tr> 
                <tr>    
                    <td>City : </td>   
                    <td><form:input path="city"  /></td>  
                </tr> 
                <tr>    
                    <td>State : </td>   
                    <td><form:input path="state"  /></td>  
                </tr> 
                <tr>    
                    <td>Zip : </td>   
                    <td><form:input path="zip"  /></td>  
                </tr> 
                <tr>    
                    <td>Email : </td>   
                    <td><form:input path="email"  /></td>  
                </tr> 
                <tr>    
                    <td>Phone : </td>   
                    <td><form:input path="phone"  /></td>  
                </tr> 
                <tr>    
                    <td>Status : </td>   
                    <td><form:input path="status"  /></td>  
                </tr> 
                <tr>    
                    <td> </td>    
                    <td><input type="submit" value="Save" /></td>    
                </tr>    
            </table>    
        </form:form>
    </body>
</html>