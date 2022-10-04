<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<form action='checkbox' method='post'>
	<label><input type='checkbox' name='fruit' value='사과'/>사과</label>
	<label><input type='checkbox' name='fruit' value='포도'/>포도</label>
	<label><input type='checkbox' name='fruit' value='딸기'/>딸기</label>
	<input type='submit'/> <!-- 파라미터 밸류가 n개이다, 핸들러가 어떻게 처리할 것인가 -->
</form>