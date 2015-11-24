<%--
 Created by Temi Varghese on 27/11/2014.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Expert Trees</title>
    <r:require modules="bugherd"/>
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
    <legend>Select an expert recommended tree</legend>
    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <th>Tree name</th>
            <th>Species covered</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${trees}" var="tree" status="i">
            <tr>
                <td class="span6">
                    <div>
                        <div class="btn btn-link"  onclick="showInfo(${i})">
                            ${tree.getTitle()}
                            <i class="icon-info-sign" title="Show more information"></i>
                        </div>
                    </div>
                </td>
                <td>
                    <g:if test="${tree.expertTreeLSID}">
                        <a
                                href="http://bie.ala.org.au/species/${tree.expertTreeLSID}"
                                target="_blank">${tree.getExpertTreeTaxonomy()}</a>
                    </g:if>
                    <g:else>
                        ${tree.getExpertTreeTaxonomy()}
                    </g:else>
                </td>
                <td style="justify: center">
                    <div class="btn btn-small btn-primary"
                         onclick="window.location = '${createLink( action: 'visualize')}?id=${tree.getId()}'">
                        <i class="icon icon-ok"></i> Open</div>
                    <a
                            href="${createLink(controller: 'viewer',action: 'show')}?studyId=${tree.getId()}"
                            class="btn btn-small" ><i class="icon icon-camera"></i> Preview tree</a>
                </td>
            </tr>
            <tr>
                <td colspan="3" style="display: none" class="info" id="info-${i}">
                    <div class="control-group" style="display: block"></div>
                %{--<label>Citation:</label>--}%<i>${tree.getReference()}</i>
                    <g:if test="${tree.doi}">
                        <div class="">
                            %{--<label>Doi:</label>--}%
                            <a href="${tree.getDoi()}">${tree.getDoi()}</a>
                        </div>
                    </g:if>
                    <g:if test="${tree.notes}">
                        <div><i>${tree.getNotes()}</i></div>
                    </g:if>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div name="back" class="btn" onclick="window.location = '${createLink(controller: 'wizard',action: 'start')}'"><i
            class="icon icon-arrow-left"></i> Back</div>
    <script>
        function showInfo(i){
//            $('.info').hide({
//                animate:'slow'
//            })
            $('#info-'+i).toggle({
                animate:'slow'
            })
        }
    </script>
</div>
</body>
</html>