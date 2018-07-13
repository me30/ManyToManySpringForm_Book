<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Home</title>

<style type="text/css">
<%@ include file="/css/styles.css" %>
<%@ include file="/css/bootstrap.min.css" %>
</style>
</head>
<body>
<body>
	<div class="col-md-3 left-side">
		<!-- add category form -->
		<div class="add_category">
			<form action="addauthor" method="post" modelAttribute="addauthor">
				<div class="form-group">
					<label>Add Author:</label>
					<input type="text" class="form-control" autocomplete="off" name="authorname">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
		<!-- add category form over-->

		<!-- add product form -->
		<div class="add_products">
			<form:form action="addbooks" method="post" modelAttribute="book">
				<div class="form-group">
					<label>Add Book Details:</label>
					<form:input type="text" class="form-control" autocomplete="off" path="bookname" placeholder="bookname"/>
					<form:input type="text" class="form-control" autocomplete="off" path="isbn" placeholder="isbn"/>
					<form:input type="text" class="form-control" autocomplete="off" path="price" placeholder="price"/>
					<form:input type="date" class="form-control" autocomplete="off" path="createdat" placeholder="createdat"/>
					<form:select path="authors" items="${authorsdata}" multiple="true" itemValue="id" itemLabel="authorname" class="form-control input-sm" />
					
<!-- 				 	<select class="form-control" name="authors" multiple="multiple"> -->
<%-- 					<c:forEach items="${authorsdata}" var="author"> --%>
<%-- 						<option value="${author.id}">${author.authorname}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				 	</select> -->
				</div>
				
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
		</div>
		<!-- add product form over-->
		
	</div>

<div class="col-md-9 right-side">
<div class="displayrrcords">
<label class="displayrrcords-title">All Records</label>
<input type="text" name="search" id="searchbox" placeholder="Search anything" onkeypress="as()">
<table class="table table-bordered table-striped" id="allrecords">
    <thead>
      <tr>
        <th>Book Name</th>
        <th>ISBN Number</th>
        <th>Price</th>
        <th>Created Date</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${books}" var="books">
      <tr>
        <td>${books.bookname}</td>
        <td>${books.isbn}</td>
        <td>${books.price}</td>
        <td>${books.createdat}</td>
        <td><a class="btn btn-success" href="edit?id=${books.id}">Edit</a><a class="btn btn-danger" href="delete?id=${bookd.id}">Delete</a></td>
      </tr>
     </c:forEach>
     
    </tbody>
  </table>
</div>

</div>

</body>
</body>
</html>