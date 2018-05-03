<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.servletContext.contextPath }/assets/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="rent-result">
				<table class="tbl-ex">
					<tr>
						<th>이메일</th>
						<th>예약 순번</th>
						<th>타이틀</th>
						<th>카테고리</th>
						<th>대여일</th>
						<th>반납일</th>
					</tr>
					<c:forEach items="${list }" step="1" var="vo" varStatus="status">
						<tr>
							<td>${vo.email }</td>
							<td>${vo.userIndex }</td>
							<td>${vo.item.name }</td>
							<td>${vo.item.category.name}</td>
							<td>${vo.leaseDate }</td>
							<td>${vo.returnDate }</td>
						</tr>
					</c:forEach>
				</table>
				<p class="success">
					정상적으로 예약이 되었습니다. <br>
					<br> <a href="${pageContext.servletContext.contextPath }/main">목록으로돌아가기</a>
				</p>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>