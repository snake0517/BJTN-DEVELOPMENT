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
            <tr>
                <th>Address1</th>
                <td>${client.address1}</td>
            </tr> 
            <tr>
                <th>Address2</th>
                <td>${client.address2}</td>
            </tr> 
            <tr>
                <th>City</th>
                <td>${client.city}</td>
            </tr> 
            <tr>
                <th>State</th>
                <td>${client.state}</td>
            </tr> 
            <tr>
                <th>Zip</th>
                <td>${client.zip}</td>
            </tr> 
            <tr>
                <th>Email</th>
                <td>${client.email}</td>
            </tr> 
            <tr>
                <th>Phone</th>
                <td>${client.phone}</td>
            </tr> 
            <tr>
                <th>Status</th>
                <td>${client.status}</td>
            </tr> 
            <tr>
                <th>Action</th>
                <td><a href="<c:url value="/client/editclient/${client.clientid}" />"><button class="w3-btn w3-round w3-blue">Edit</button></a>
               <a href="<c:url value="/interactions/interactionform/${client.clientid}" />"><button class="w3-btn w3-round w3-blue">New Interaction</button></a>
                
                
                </tr>
                
        
    </table>
              <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">  
        <tr>
            <th>Interaction Id</th>
            <th>Client Id</th>
            <th>Contact Date</th>
            <th>Contact Person</th>
            <th>Contact Type</th>
            <th>Action</th>
        </tr>  

        <c:forEach var="interactions" items="${list}"> 
            <tr> 
                <td>${interactions.interactionId}</td>
                <td>${interactions.clientid}</td>
                <td>${interactions.occurredOn}</td>
                <td>${interactions.contactPerson}</td>
                <td>${interactions.contactType}</td>
                <td>
                  <button onclick="document.getElementById('id01').style.display='block'" class="w3-btn w3-round w3-blue">Notes</button>

  <div id="id01" class="w3-modal">
    <div class="w3-modal-content">
      <div class="w3-container">
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-closebtn">&times;</span>
        <p>${interactions.notes}</p>
        
      </div>
    </div>
  </div>
                </td>  
            </tr>  
        </c:forEach>
    </table> 
                
</div>
<%@ include file="theme/footer.jsp" %>