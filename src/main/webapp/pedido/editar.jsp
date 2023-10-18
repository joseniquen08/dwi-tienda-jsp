<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Pedido</title>
<link rel="stylesheet" type="text/css" href="../resources/css/global.css" >
<link rel="stylesheet" type="text/css" href="../resources/css/clientes.css" >
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<div class="menu">
		<h1>INGRESAR NUEVOS DATOS ACTUALIZADOS</h1>
		<a href="../pedidos.jsp" class="btn-back">Regresar</a>
	</div>
	<div class="formContainer">
		<form action="ServletPOSTPedidoEdit" method="POST">
			<div class="form-control">
				<label>Ingrese ID del pedido:</label>
				<input type="text" name="idE"/>
			</div>
			<hr/>
			<div class="form-control">
				<label>CANTIDAD:</label>
				<input type="text" autocomplete="off" name="cantidadE"/>
			</div>
			<div class="form-control">
				<label>C�DIGO PEDIDO:</label>
				<input type="text" autocomplete="off" name="pedidocodE"/>
			</div>
			<div class="form-control">
				<label>TIPO ART�CULO:</label>
				<input type="text" autocomplete="off" name="tipoarticuloE"/>
			</div>
			<div class="form-control">
				<label>TALLA:</label>
				<input type="text" autocomplete="off" name="tallaE"/>
			</div>
			<div class="form-control">
				<label>COLOR:</label>
				<input type="text" autocomplete="off" name="colorE"/>
			</div>
			<div class="form-control">
				<label>DETALLES:</label>
				<input type="text" autocomplete="off" name="detallesE"/>
			</div>
			<div class="form-control">
				<label>SUBTOTAL:</label>
				<input type="text" autocomplete="off" name="subtotalE"/>
			</div>
			<div class="form-control">
				<button type="submit">Actualizar</button>
			</div>
		</form>
	</div>
</body>
</html>