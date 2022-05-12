<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>

<title>Insert title here</title>
</head>
<body>
	<h1>직원목록</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>아이디</th>
				<th>성</th>
				<th>이름</th>
				<th>생일</th>
				<th>사진</th>
				<th>특이사항</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees }" var="emp">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.firstName }</td>
				<td>${emp.lastName }</td>
				<td>${emp.birthDate }</td>
				<td>${emp.photo }</td>
				<td>${emp.notes }</td>
			</tr>
			</c:forEach>
		</tbody>
		
	</table>
	
	
</body>
</html>