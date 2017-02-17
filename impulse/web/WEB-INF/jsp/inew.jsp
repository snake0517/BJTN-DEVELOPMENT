<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Add Interaction</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Impulse</h2>
        </div>

        <form:form method="post" action="save" cssClass="w3-container" commandName="interactions">
 <form:hidden path="clientid"  />
            
 
        
        <div class="w3-padding-8">
          
          
            <p><b>${interactions.client.firstName}</b></p>
          
         </div>
      
            <div class="w3-padding-8">
                <label><b>Contact Date</b></label>
                <form:input path="occurredOn" cssClass="w3-input w3-border"  />
                <form:errors path="occurredOn" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>
            <div class="w3-padding-8">
                <label><b>Contact Person</b></label>
                <form:input path="contactPerson" cssClass="w3-input w3-border"  />
                <form:errors path="contactPerson" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>
            <div class="w3-padding-8">
                <label><b>Contact Type</b></label>
                <form:select path="contactType" cssClass="w3-select w3-border">
                    <form:option value="">Contact Type</form:option>
                    <form:options items="${interactions.contact}"  />
                </form:select>
            </div>
            <div class="w3-padding-8">
                <label><b>Notes</b></label>
                <form:input path="notes" cssClass="w3-input w3-border"  />
                <form:errors path="notes" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>
    </div>

</div>