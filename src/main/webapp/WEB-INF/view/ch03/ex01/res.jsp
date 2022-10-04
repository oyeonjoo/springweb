<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<script src='<c:url value="/res/duke.gif.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/res/box.css"/>'/>

<img src='<c:url value="/res/duke.gif"/>'/>
<!-- 내가 쓰고 싶은 것에는 res를 붙여아한다, res를 붙이지 않으면 리퀘스트가 핸들러한테 가려고 시도한다 -->
<div></div> <!-- 컨텍스트 패스 후의 주소를 적는다, 절대주소(컨텍스트 패스 포함)말고 상대주소(컨텍스트 패스x)를 적는다 -->