<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DevShop</title>
<link rel="stylesheet" type="text/css" href="resources/css/global.css" >
<link rel="stylesheet" type="text/css" href="resources/css/index.css" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<header>
		<h1>TIENDA JSP</h1>
	</header>
	<main>
		<section>
			<a href="articulos.jsp" class="card">
				<i class="fa-solid fa-shirt"></i>
				<span>Artículos</span>
			</a>
			<a href="pedidos.jsp" class="card">
				<i class="fa-solid fa-rectangle-list"></i>
				<span>Pedidos</span>
			</a>
			<a href="clientes.jsp" class="card">
				<i class="fa-solid fa-users"></i>
				<span>Clientes</span>
			</a>
			<a href="trabajadores.jsp" class="card">
				<i class="fa-solid fa-people-group"></i>
				<span>Trabajadores</span>
			</a>
		</section>
	</main>
</body>
</html>