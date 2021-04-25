<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>INDEX</title>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">WELCOME TO EMPLOYEE WEBAPP</h1>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Employee Name</th>
							<th scope="col">About Employee</th>
							<th scope="col">Salary</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${Employees }" var="p">
							<tr>
								<th scope="row">${p.id }</th>
								<td>${p.name }</td>
								<td>${p.about }</td>
								<td class="font-weight-bold">&#x20B9;${p.salary }</td>
								<td><a href="delete/${p.id}"><i	class="far fa-trash-alt text-danger" style="font-size: 50px;"></i></a>
								<a href="update/${p.id}"><i	class="fas fa-user-edit text-info" style="font-size: 50px;"></i></a>
								</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
				<div class="container text-center">
					<a href="addemployee" class="btn btn-outline-success">ADD</a>



				</div>
			</div>

		</div>


	</div>


</body>
</html>