<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
       
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>ILOJA</title>
</head>
<jsp:useBean id="dao" class="org.libertas.crud.ProdutoDao" scope="page"/>
<body style="background-color: red">
	<h2 style="text-align: center;">LOJA</h2><br/><br/>
	<div class="dropdown" style="text-align: center">
  		<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    		Cadastrar
  		</button>
  		<div class="dropdown-menu" aria-labelledby="dropdownMenu2" style="background-color: red">
   			<a class="dropdown-item" href="cadastro.jsp">Novo Produto</a>
  		</div>
	</div>
	<br/><br/><br/>
		
	<div class="table-responsive" style="width: 80%; margin-left: 10%">
	<table border="1px" class="table table- table-sm" >
	  <thead>
	    <tr>
				<th scope="col">id</th>
				<th scope="col">Descrição</th>
				<th scope="col">Marca</th>
				<th scope="col">Preço de Custo</th>
				<th scope="col">Preço de Venda</th>
				<th scope="col">Saldo</th>
				<th scope="col">Excluir</th>
		</tr>
	  </thead>	
			<c:forEach var="p" items="${dao.listar()}">
				<tbody>
					<tr>
						<td class="bg-light">${p.idproduto}</td>
						<td class="bg-light">${p.descricao}</td>
						<td class="bg-light">${p.marca}</td>
						<td class="bg-light">${p.precoCusto}</td>
						<td class="bg-light">${p.precoVenda}</td>
						<td class="bg-light">${p.saldo}</td>
						<td><a class="btn btn-secondary" href="Excluir.jsp?idproduto=${p.getIdproduto()}" role="button">Excluir</a></td>
					</tr>
				</tbody>
			</c:forEach>
		
	</table>
	<table border="1px" class="table table table-sm" >
	  <thead>
	    <tr>
	    	<th scope="col">Total Preço de Venda</th>
			<th scope="col">Total Preço de Custoa</th>
			<th scope="col">Saldo Total</th>

		</tr>
	  </thead>	
	  	
	   	<tbody>
			<tr>
				<td class="bg-light">${dao.getTotalPrecoVenda(dao.listar())}</td>
				<td class="bg-light">${dao.getTotalPrecoCusto(dao.listar())}</td>
				<td class="bg-light">${dao.getTotalSaldo(dao.listar())}</td>
				
			</tr>
		</tbody>
		
	</table>
	</div>
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" 
integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" 
crossorigin="anonymous"></script>
</body>
</html>