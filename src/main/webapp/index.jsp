<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DevShop</title>
<link rel="stylesheet" type="text/css" href="resources/css/output.css" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body class="bg-gray-50 font-poppins flex flex-col">
	<header class="flex justify-center py-6">
		<h1 class="text-3xl font-bold">TIENDA JSP</h1>
	</header>
	<main class="mx-auto w-full max-w-2xl h-full py-4">
		<section class="grid grid-cols-2 gap-6">
			<a href="articulos.jsp" class="h-48 border shadow-xl rounded-lg flex flex-col justify-center items-center space-y-3 hover:bg-stone-100">
				<i class="fa-solid fa-shirt text-3xl"></i>
				<span class="text-2xl font-medium">Artículos</span>
			</a>
			<a href="pedidos.jsp" class="h-48 border shadow-xl rounded-lg flex flex-col justify-center items-center space-y-3 hover:bg-stone-100">
				<i class="fa-solid fa-rectangle-list text-3xl"></i>
				<span class="text-2xl font-medium">Pedidos</span>
			</a>
			<a href="clientes.jsp" class="h-48 border shadow-xl rounded-lg flex flex-col justify-center items-center space-y-3 hover:bg-stone-100">
				<i class="fa-solid fa-users text-3xl"></i>
				<span class="text-2xl font-medium">Clientes</span>
			</a>
			<a href="trabajadores.jsp" class="h-48 border shadow-xl rounded-lg flex flex-col justify-center items-center space-y-3 hover:bg-stone-100">
				<i class="fa-solid fa-people-group text-3xl"></i>
				<span class="text-2xl font-medium">Trabajadores</span>
			</a>
		</section>
	</main>
</body>
</html>