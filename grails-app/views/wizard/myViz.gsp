<%--
 Created by Temi Varghese on 28/11/2014.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>${name} trees</title>
    <r:require modules="bugherd"/>
    <r:require modules="css"/>
</head>

<body>
<div class="container"  style="min-height: 700px">
    <div class="row-fluid">
        <div class="span12">
            <ul class="breadcrumb">
                <li><a href="${createLink(uri:'/')}">Home</a> <span class="divider">/</span></li>
                <li><a href="${createLink(controller: 'wizard', action: 'start')}">Start PhyloLink</a></li>
            </ul>
        </div>
    </div>
    <g:if test="${flash.message}">
        <div class="message alert-info" role="status">${flash.message}</div>
    </g:if>
    <legend>${name} Visualisations</legend>
    <p style="font-size:14px; max-width: 60em">List of all visualisation you created. You can click
        on visualisation name to view it. Or, use
        <span class="label label-info">back</span> button to go to previous page</p>
    <g:if test="${viz.size() != 0}">
        <table class="table table-hover table-bordered">
            <thead>
            <tr>
                <th>Visualisation</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${viz}" var="v" status="i">
                <tr>
                    <td width="90%">
                        <div>
                            <div class="btn btn-link" >
                                <a href="${createLink(controller: 'phylo', action: 'show')}/${v.getId()}">${v.getTitle()}</a>
                            </div>
                        </div>
                    </td>
                    <td>
                        <a id="deleteTreeLink${v.getId()}" class="btn btn-default btn-small" data-toggle="modal" href="#${v.getId()}ConfirmationModal"><i class="fa fa-trash"></i>&nbsp;Delete</a>

                        <div id="${v.getId()}ConfirmationModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="Confirmation" aria-hidden="true">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h3 id="myModalLabel">Confirmation</h3>
                            </div>
                            <div class="modal-body">
                                <p>Are you sure you wish to delete this visualisation?</p><p>This operation cannot be undone.</p>
                            </div>
                            <div class="modal-footer">
                                <g:form method="DELETE" controller="phylo" action="deleteViz" params="[id: v.id]" class="inline-block">
                                    <g:actionSubmit value="Delete" controller="phylo" action="deleteViz" params="[id: v.id]" class="btn btn-warning"/>
                                </g:form>
                                <button id="closeDownloadModal" class="btn closeDownloadModal" data-dismiss="modal" aria-hidden="true">Close</button>
                            </div>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </g:if>
    <g:else>
        <div>
        </div>
    </g:else>
    <div name="back" class="btn" onclick="window.location = '${createLink(controller: 'wizard',action: 'start')}'"><i
            class="icon icon-arrow-left"></i> Back</div>
</div>
</body>
</html>