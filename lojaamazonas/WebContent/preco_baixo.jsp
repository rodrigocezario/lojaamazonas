<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header class="section-heading">
	<a href="#" class="btn btn-outline-primary float-right">Ver todos</a>
	<h3 class="section-title">Produtos que baixaram de preço</h3>
</header>
<!-- sect-heading -->
<jsp:useBean id="daoPrecoBaixo" class="br.edu.unifebe.dao.ProdutoDao" />
<fmt:setLocale value="pt_BR"/>
<c:set var="parcelas" value="10" />

<ul class="row">
	<c:forEach var="produto" items="${daoPrecoBaixo.menoresPrecos}">
		<li class="col-md-3">
			<div href="#" class="card card-product-grid">
				<a href="#" class="img-wrap"> 
					<img src="images/produtos/${produto.fotoCapa}.jpg">
				</a>
				<figcaption class="info-wrap">
					<a href="#" class="title">${produto.nome}</a>
					<p class="text-muted">
						<del> De: <fmt:formatNumber value="${produto.precoNormal}" type="currency" /></del>
					</p>
					<div class="price mt-1">
						Por: <fmt:formatNumber value="${produto.precoVenda}" type="currency" />
					</div>
					<p class="text-muted">
						<c:out value="${parcelas}" />X de <fmt:formatNumber value="${produto.precoVenda / parcelas}" type="currency" /> sem juros
					</p>
				</figcaption>
			</div>
		</li>
	</c:forEach>
</ul>