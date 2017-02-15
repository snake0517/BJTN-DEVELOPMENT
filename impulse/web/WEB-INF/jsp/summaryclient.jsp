<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> View Client</b></h5>
</header>

<div class="w3-row-padding w3-margin-bottom">

    <c:if test="${not empty message}">
        <c:choose>
            <c:when test="${message.type eq 'INFO'}">
                <div class="w3-panel w3-border w3-pale-yellow w3-border-yellow"><p>${message.message}</p></div>
                    </c:when>
                    <c:when test="${message.type eq 'ERROR'}">
                <div class="w3-panel w3-border w3-pale-red w3-border-red"><p>${message.message}</p></div>
                    </c:when>
                </c:choose>

    </c:if>

    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">  

        <c:forEach var="client" items="${list}"> 
            <tr>
                <th>Id</th>
                <td>${client.clientid}</td>
            </tr> 
            <tr>
                <th>First Name</th>
                <td>${client.firstName}</td>
            </tr> 
            <tr>
                <th>Last Name</th>
                <td>${client.lastName}</td>
            </tr> 
        </c:forEach>
    </table>
</div>
<%@ include file="theme/footer.jsp" %>