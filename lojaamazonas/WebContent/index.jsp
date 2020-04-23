<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE HTML>
<html lang="pt-BR">

<head>
	<jsp:include page="head.jsp" />
</head>

<body>

	<jsp:include page="topo.jsp" />

	<jsp:include page="menu_topo.jsp" />

	<!-- ========================= SECTION INTRO ========================= -->
	<section class="section-intro">

		<div class="intro-banner-wrap">
			<img src="images/banners/1.jpg" class="w-100 img-fluid">
		</div>

	</section>
	<!-- ========================= SECTION INTRO END// ========================= -->


	<!-- ========================= SECTION SPECIAL ========================= -->
	<section class="section-specials padding-y border-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<figure class="itemside">
						<div class="aside">
							<span class="icon-sm rounded-circle bg-success">
								<i class="fa fa-truck white"></i>
							</span>
						</div>
						<figcaption class="info">
							<h6 class="title">Entrega rápida</h6>
							<p class="text-muted">Compre e receba hoje.<br>Suas compras chegam hoje mesmo!</p>
						</figcaption>
					</figure> 
				</div>
				<!-- col // -->
				<div class="col-md-4">
					<figure class="itemside">
						<div class="aside">						
							<span class="icon-sm rounded-circle bg-primary">
								<i class="fa fa-money-bill-alt white"></i>
							</span>
						</div>
						<figcaption class="info">
							<h6 class="title">Com até 50% de cashback*</h6>
							<p class="text-muted">Tem muuuito cashback aqui!<br>Vem acumular cashback e descontos sem precisar escolher entre eles. Partiu?</p>
						</figcaption>
					</figure> 
				</div>
				<!-- col // -->
				<div class="col-md-4">
					<figure class="itemside">
						<div class="aside">
							<span class="icon-sm rounded-circle bg-danger">
								<i class="fa fa-handshake white"></i>
							</span>
						</div>
						<figcaption class="info">
							<h6 class="title">Apoie sua comunidade</h6>
							<p class="text-muted">Compre de vendedores locais, apoie sua região.</p>
						</figcaption>
					</figure> 
				</div>
				<!-- col // -->
			</div> 
		</div> 
	</section>
	<!-- ========================= SECTION SPECIAL END// ========================= -->


	<!-- ========================= SECTION  ========================= -->
	<section class="section-name  padding-y-sm">
		<div class="container">

			<c:import url="preco_baixo.jsp" />

			<c:import url="grandes_ofertas.jsp" />
			
			<c:import url="ofertas_dia.jsp" />
			

		</div>
		<!-- produtos container // -->
	</section>
	<!-- ========================= SECTION  END// ========================= -->

	<c:import url="rodape.jsp" />


</body>

</html>