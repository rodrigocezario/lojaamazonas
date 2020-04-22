<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="section-header">
	<section class="header-top-light border-bottom">
		<div class="container">
			<nav class="d-flex flex-column flex-md-row">
				<ul class="nav mr-auto d-none d-md-flex">
					<li><a href="#" class="nav-link px-2"> <i
							class="fab fa-facebook"></i>
					</a></li>
					<li><a href="#" class="nav-link px-2"> <i
							class="fab fa-instagram"></i>
					</a></li>
					<li><a href="#" class="nav-link px-2"> <i
							class="fab fa-twitter"></i>
					</a></li>
				</ul>
				<ul class="nav">
					<li class="nav-item"><a href="#" class="nav-link"> Entrega
					</a></li>
					<li class="nav-item"><a href="#" class="nav-link"> Ajuda </a>
					</li>
					<li><a href="#" class="nav-link"> <i class="fa fa-comment"></i>
							Fale conosco pelo chat
					</a></li>
				</ul>
				<!-- navbar-nav.// -->
			</nav>
		</div>
	</section>
	<section class="header-main border-bottom">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-3 col-sm-4 col-12">
					<a href="./" class="brand-wrap"> <img class="logo"
						src="images/logo.png">
					</a>
				</div>
				<div class="col-lg-4 col-xl-5 col-sm-8 col-md-4 d-none d-md-block">
					<form action="#">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="O que você tá procurando?">
							<div class="input-group-append">
								<button class="btn btn-primary" type="submit">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
					</form>
					<!-- search-wrap .end// -->
				</div>
				<!-- col.// -->
				<div class="col-lg-5 col-xl-4 col-sm-12">
					<div class="widgets-wrap d-flex justify-content-end">
						<div class="widget- mr-2">
							<a href="#" class="icontext">
								<div class="icon">
									<i class="fa fa-2x fa-shopping-cart"></i>
								</div>
								<div class="text">
									<small class="text-muted">Carrinho</small> <br> <span>3
										itens</span>
								</div>
							</a>
						</div>
						<div class="widget-header mr-2">
							<a href="#" class="icontext">
								<div class="icon">
									<i class="fa fa-2x fa-heart"></i>
								</div>
								<div class="text">
									<small class="text-muted">Lista</small> <br> <span>Desejos</span>
								</div>
							</a>
						</div>
						<!-- widget .// -->
						<div class="widget-header dropdown">
							<a href="#" class="ml-3 icontext" data-toggle="dropdown"
								data-offset="20,10">
								<div class="icon">
									<i class="fa fa-2x fa-user-circle"></i>
								</div>
								<div class="text">
									<small class="text-muted">Entre / Cadastre-se</small> <br>
									<span>Faça seu login <i class="fa fa-caret-down"></i></span>
								</div>
							</a>
							<!-- fomulário de autenticação -->
							<div class="dropdown-menu dropdown-menu-right">
								<form class="px-4 py-3">
									<div class="form-group">
										<label>Endereço de Email</label> <input type="email"
											class="form-control" placeholder="email@exemplo.com">
									</div>
									<div class="form-group">
										<label>Password</label> <input type="password"
											class="form-control" placeholder="Senha">
									</div>
									<button type="submit" class="btn btn-primary">Entrar</button>
								</form>
								<hr class="dropdown-divider">
								<a class="dropdown-item" href="#">Esqueceu sua senha?</a>
							</div>
							<!--  dropdown-menu .// -->
						</div>
						<!-- widget  dropdown.// -->
					</div>
					<!-- widgets-wrap.// -->
				</div>
				<!-- col.// -->
			</div>
			<!-- row.// -->
		</div>
		<!-- container.// -->
	</section>
	<!-- header-main .// -->
</header>
