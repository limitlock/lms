<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>lms</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.request.contextPath }/assets/css/admin/rent.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/admin/include/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<table class="tbl-ex">
					<tr>
						<th>번호${maxNo }</th>
						<th>예약자</th>
						<th>예약순번</th>
						<th>타이틀</th>
						<th>카테고리</th>
						<th>대여일</th>
						<th>반납일</th>
					</tr>
					<c:forEach items="${list }" step="1" var="vo" varStatus="status">
						<tr>
							<td>${maxNo -  ((p-1) * 5) - status.index }</td>
							<td>${vo.user.email }</td>
							<td>${vo.userIndex }</td>
							<td>${vo.item.getName() }</td>
							<td>${vo.item.category.name }</td>
							<td>${vo.leaseDate }</td>
							<td>${vo.returnDate }</td>
						</tr>
					</c:forEach>

				</table>
				<div class="pager">
					<ul>
						<c:if test="${prevPage}">
							<li><a
								href="${pageContext.servletContext.contextPath }/admin?p=${curPage-1 }">◀</a></li>
						</c:if>

						<c:forEach begin="1" end="${totalPage}" var="page">
							<c:choose>
								<c:when test="${totalPage < page }">
									<li>${page }</li>
								</c:when>
								<c:when test="${curPage == page }">
									<li class="selected">${page }</li>
								</c:when>
								<c:otherwise>
									<li><a
										href="${pageContext.request.contextPath }/admin?p=${page }">${page }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${nextPage }">
							<li><a
								href="${pageContext.request.contextPath }/admin?p=${curPage+1 }">▶</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<c:import url="/WEB-INF/views/admin/include/navigation.jsp" />
		</div>
	</div>
</body>
</html>