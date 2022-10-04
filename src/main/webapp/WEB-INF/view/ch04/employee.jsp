<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
${employee.employeeId} / ${employee.lastName} / ${employee.hireDate}
<!-- ${employee.hireDate}: get hireDate로 번역된다 > getter를 준비한 이유 -->
<!-- setter는 만들지 않는다 > 마이바티스가 알아서 세팅해주기 때문(or mapping) -->