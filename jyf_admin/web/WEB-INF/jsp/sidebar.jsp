<%@page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%--<div class="accordion" id="menu_list">--%>
    <%--<c:forEach var="menuBean" items="${MENU_BEAN_LIST}">--%>
        <%--<c:if test="${menuBean.menu.valid}">--%>
            <%--<div class="accordion-group">--%>
                <%--<div class="accordion-heading">--%>
                    <%--<a class="accordion-toggle" data-toggle="collapse" data-parent="#menu_list"--%>
                       <%--href="#collapse_${menuBean.menu.id}">--%>
                        <%--${menuBean.menu.name}--%>
                    <%--</a>--%>
                <%--</div>--%>
                <%--<div id="collapse_${menuBean.menu.id}" class="accordion-body collapse in">--%>
                    <%--<c:forEach var="permission" items="${menuBean.permissionList}">--%>
                        <%--<c:if test="${permission.valid}">--%>
                            <%--<div class="accordion-inner">--%>
                                <%--<a href="<c:url value="${permission.url}"/>">${permission.name}</a>--%>
                            <%--</div>--%>
                        <%--</c:if>--%>
                    <%--</c:forEach>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</c:if>--%>
    <%--</c:forEach>--%>
<%--</div>--%>

<div class="panel-group" id="accordion">
    <c:forEach var="menuBean" items="${MENU_BEAN_LIST}">
    <c:if test="${menuBean.menu.valid}">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse_${menuBean.menu.id}">
                    ${menuBean.menu.name}
                </a>
            </h4>
        </div>
        <div id="collapse_${menuBean.menu.id}" class="panel-collapse collapse in">
            <div class="panel-body">
                <div class="list-group">
                <c:forEach var="permission" items="${menuBean.permissionList}">
                    <c:if test="${permission.valid}">
                        <a href="<c:url value="${permission.url}"/>" class="list-group-item">${permission.name}</a>
                    </c:if>
                </c:forEach>
                </div>
            </div>
        </div>
    </div>
    </c:if>
    </c:forEach>
</div>