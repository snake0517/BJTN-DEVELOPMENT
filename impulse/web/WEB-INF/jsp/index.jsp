<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sec:authorize access="hasRole('ROLE_USER')">
    <c:url value="/j_spring_security_logout" var="logoutUrl" />


    <%@ include file="theme/header.jsp" %>

    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-dashboard"></i> Dashboard</b></h5>
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
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Status</th>

            <th>Action</th>
        </tr>  

        <c:forEach var="client" items="${list}">   
            <tr>  
                <td>${client.clientid}</td>
                <td>${client.firstName}</td>  
                <td>${client.lastName}</td>
                <td>${client.status}</td>
                <td>
                   
                    <a href="<c:url value="/client/summaryclient/${client.clientid}" />"><button class="w3-btn w3-round w3-red">View</button></a>
                </td>  
            </tr>  
        </c:forEach>  
    </table> 

    

    </div>

    <%@ include file="theme/footer.jsp" %>
</sec:authorize>

<sec:authorize access="isAnonymous()">
    <c:redirect url="/login"/>
</sec:authorize>