<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>LMS</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="${pageContext.request.contextPath }"
					method="get">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호${authUser.role }</th>
						<th>타이틀</th>
						<th>카테고리</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var="count" value="${fn:length(list) }" />
					<c:forEach items="${list }" step="1" var="vo" varStatus="status">
						<tr>
							<td>${maxNo -  ((p-1) * 5) - status.index }</td>
								<c:choose>
									<c:when test="${rentIdList[status.index].item.getId() == vo.id }">
										<td>${vo.name }<font color="#ff0000">[대여중]</font><%-- <font color="#0037ff">[예약자: ${rentId.userIndex }명]</font> --%>
										</td>
										<td>${vo.category.name}</td>
										<td>
										<a href="${pageContext.servletContext.contextPath }/reserve?no=${vo.id}&userNo=${authUser.no}&p=${param.p}" class="btn">예약</a>
										</td>
									</c:when>
									<c:otherwise>
										<td>${vo.name }</td>
										<td>${vo.category.name}</td>
										<td><a href="${pageContext.servletContext.contextPath }/rent?no=${vo.id}&userNo=${authUser.no}&p=${param.p}" id="btn-rent" class="btn">대여</a></td>
									</c:otherwise>
								</c:choose>
						</tr>
					</c:forEach>
				</table>
				<div id="underpoint" class="pager">
					<ul>
						<c:set var="count" value="${fn:length(list) }" />
							<fmt:parseNumber var="totalPage" value="${(((maxNo-1)/5)+1)}"  integerOnly="true" />
						<c:choose>
							<c:when test="${param.p > 5 }">
								<fmt:parseNumber var="startPage" value="${((param.p-1)/totalPage) * totalPage + 1}" integerOnly="true" />
							</c:when>
							<c:otherwise>
								<fmt:parseNumber var="startPage" value="${((1-1)/totalPage) * totalPage + 1}" integerOnly="true" />
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${endPage > totalPage }">
								<fmt:parseNumber var="endPage"
									value="${((startPage + totalPage ) -1) } " integerOnly="true" />
							</c:when>
							<c:otherwise>
								<fmt:parseNumber var="endPage" value="${totalPage}" integerOnly="true" />
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${startPage <= param.p && param.p != 1}">
								<li><a href="${pageContext.servletContext.contextPath }/main?p=${(param.p-1) }">◀</a></li>
							</c:when>
							<c:otherwise>
								<li>◀</li>
							</c:otherwise>
						</c:choose>
						
						<c:forEach begin="${startPage }" end="${startPage+4}" step="1"
							var="i" varStatus="status">
							<c:choose>
								<c:when test="${totalPage < i }">
									<li>${i }</li>
								</c:when>
								<c:when test="${param.p == i }">
									<li class="selected">${i }</li>
								</c:when>
								<c:otherwise>
									<li><a href="${pageContext.servletContext.contextPath }/main?p=${i }">${i }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:choose>
							<c:when test="${totalPage > param.p  }">
								<li><a href="${pageContext.servletContext.contextPath }/main?p=${(param.p+1) }">▶</a></li>
							</c:when>
							<c:when test="${totalPage <= param.p }">
								<li>▶</li>
							</c:when>
						</c:choose>
					</ul>
				</div>
				<div class="bottom"></div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>