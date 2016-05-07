<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Table</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
 <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
      
      <c:url var="addAction" value="/productTable/add" ></c:url>
 
<form:form action="${addAction}" commandName="product">
<table>
    <c:if test="${!empty product.name}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="name" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="category">
                <spring:message text="Category"/>
            </form:label>
        </td>
        <td>
            <form:input path="category" />
        </td>
    </tr>
    <tr>
    <tr>
        <td>
            <form:label path="price">
                <spring:message text="Price"/>
            </form:label>
        </td>
        <td>
            <form:input path="price" />
        </td>
    </tr>
    <tr>
    
        <td colspan="2">
            <c:if test="${!empty product.name}">
                <input type="submit"  value="<spring:message text="Edit "/>" />
            </c:if>
            <c:if test="${empty product.name}">
                <input type="submit"
                    value="<spring:message text="Add "/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<table id="product" class="table table-striped" >
 
        <thead>  
          <tr>  
            <th>ID</th>  
            <th>Name</th>  
            <th>Price</th>  
            <th>Category</th>  
          </tr>  
        </thead>  
        <tbody>  
          <c:forEach items="${listProduct}" var="prod">
     <tr>
       <td>${prod.id}</td>
       <td>${prod.name}</td>
       <td>${prod.price}</td>
       <td>${prod.category}</td>
       <td align="center"><a href="Details?id=${prod.id}">Details</a>
       
     </tr>
    </c:forEach> 
          
        </tbody>  
      </table>  
      
      <script>
$(document).ready(function(){
    $('#product').dataTable();
});
</script>
  
</body>
</html>