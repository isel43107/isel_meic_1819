<!-- paginator.tag -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ attribute name="baseUrl" type="java.lang.String" required="true" rtexprvalue="true" description="The base page URL/path"%>
<%@ attribute name="paginCurrentIndex" type="java.lang.Integer" required="true" rtexprvalue="true" description="The current paging"%>
<%@ attribute name="paginBeginIndex" type="java.lang.Integer" required="true" rtexprvalue="true" description="The begin index paging"%>
<%@ attribute name="paginEndIndex" type="java.lang.Integer" required="true" rtexprvalue="true" description="The end index paging"%>
<%@ attribute name="paginTotalPages" type="java.lang.Integer" required="true" rtexprvalue="true" description="The total paging"%>


<c:url var="firstUrl"   value="?page=1" />
<c:url var="lastUrl"    value="?page=${paginTotalPages}" />
<c:url var="prevUrl"    value="?page=${paginCurrentIndex - 1}" />
<c:url var="nextUrl"    value="?page=${paginCurrentIndex + 1}" />

<div>
    <ul class="pagination">
        <c:choose>
            <c:when test="${paginCurrentIndex == 1}">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="pageNum" begin="${paginBeginIndex}" end="${paginEndIndex}">
            <c:url var="pageUrl" value="?page=${pageNum}" />
            <c:choose>
                <c:when test="${i == paginCurrentIndex}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${pageNum}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${pageNum}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${paginCurrentIndex == paginTotalPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
<!-- paginator.tagEND -->

