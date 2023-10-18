<%@page import="proyecto_final.beans.PedidoArticulo"%>
<%@page import="proyecto_final.dao.DAOPedido"%>
<%@page import="proyecto_final.beans.PedidoNuevoArticulo"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos</title>
<link rel="stylesheet" type="text/css" href="resources/css/global.css" >
<link rel="stylesheet" type="text/css" href="resources/css/clientes.css" >
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<% 
		DAOPedido dao = new DAOPedido();
		List<PedidoNuevoArticulo> lst = dao.infoPedidosNuevoArticulo();
	%>
	<div class="menu">
		<h1>REGISTRO DE PEDIDOS DE NUEVOS ARTICULOS</h1>
		<a href="./" class="btn-back">Regresar</a>
	</div>
	<div class="botonesGestionar">
		<a href="pedido/ingresar.jsp">INGRESAR NUEVO PEDIDO</a>
		<a href="pedido/editar.jsp">EDITAR PEDIDO</a>
	</div>
	<div class="tablaContenedor">	
		<div class="cuerpo">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Cantidad</th>
						<th>Codigo Pedido </th>
						<th>Tipo Articulo</th>
						<th>Talla</th>
						<th>Color</th>
						<th>Detalles</th>
						<th>Subtotal</th>
					</tr>
				</thead>
				<tbody>
				<% int x = 1; %>
				<% for (PedidoNuevoArticulo n:lst) { %>
					<% if (x % 2 != 0) { %>
						<tr class="tdImpar">
					<% } else { %>
						<tr class="tdPar">
					<% } %>
							<td><%= n.getId() %></td>
							<td><%= n.getCantidad() %></td>
							<td><%= n.getPedidoCod() %></td>
							<td><%= n.getTipoArticulo() %></td>
							<td><%= n.getTalla() %></td>
							<td><%= n.getColor() %></td>
							<td><%= n.getDetalles() %></td>
							<td><%= n.getSubtotal() %></td>
						</tr>
				<% x++;} %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
