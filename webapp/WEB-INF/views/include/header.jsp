<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<div id="header">
			<h1>도서대여서비스</h1>
			<h5>관리자 아이디와 비밀번호는 manager 입니다.</h5>
			<ul>
			<c:choose>
				<c:when test="${empty authUser }">
				<li><a href="${pageContext.servletContext.contextPath }/user/login">로그인</a><li>
				<li><a href="${pageContext.servletContext.contextPath }/user/join">회원가입</a><li>
				</c:when>
				<c:otherwise>
				<li><a href="${pageContext.servletContext.contextPath }/admin?p=1">관리자페이지</a><li>
				<li><a href="${pageContext.servletContext.contextPath }/user/modify">회원정보수정</a><li>
				<li><a href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a><li>
				<li>${authUser.name }님 안녕하세요 ^^;</li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>