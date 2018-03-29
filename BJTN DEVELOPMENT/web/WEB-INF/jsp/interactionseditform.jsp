<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Interactions > Edit Interactions</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>BJTN DEVELOPMENT</h2>
        </div>

        <form:form method="POST" action="/impulse/interactions/editsave" cssClass="w3-container" commandName="interactions">
            <form:hidden path="interactionId"  />

            <div class="w3-padding-8">
                <label><b>Contact Date</b></label>
                <div class="w3-padding-8">
                <label><b>Contact Date</b></label>
                <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
                <link rel="stylesheet" href="/resources/demos/style.css">
                <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
                <script>
                    $(function () {
                        $("#occurredOn").datepicker();
                    });
                    </script>
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
                <form:textarea path="notes" cssClass="w3-input w3-border" cssStyle="height: 100px" />
                <form:errors path="notes" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>

    </div>
</div>

<%@ include file="theme/footer.jsp" %>