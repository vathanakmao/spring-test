<%@include file="lib/jstl.jsp"%>

<p>Request start time: <fmt:formatDate value="${startTime}" pattern="dd-MM-yyyy hh:mm:ss:SS"/></p>
<p>Request end time: <fmt:formatDate value="${endTime}" pattern="dd/MM/yyyy hh:mm:ss:SS"/><p>
<p>Handling time: ${handlingTime} second.</p>