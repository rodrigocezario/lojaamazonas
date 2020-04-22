<%@page import="br.edu.unifebe.modelo.Marca"%>
<%@page import="java.sql.SQLException"%>
<%@page import="br.edu.unifebe.dao.MarcaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap.css" type="text/css">
<title>Insert title here</title>
</head>
<body>

	<div class="container m-5 p-2">

		<div class="row">

			<div class="col-sm">
				<h1>Lista de Marcas com scriptlet</h1>
				<%!MarcaDao dao;%>
				<%
				
				//MarcaDao dao;
					try {

						dao = new MarcaDao();

						//MarcaDao marcaDao;
				%>
				<ul>
					<%
						for (Marca marca : dao.getListar()) {
					%>
					<li><%=marca.getNome()%></li>
					<%
						}
					%>
				</ul>
				<%
					} catch (SQLException e) {
						out.print("Erro: " + e.getMessage());
					}
				%>
			</div>

			<div class="col-sm">
				<h1>Lista de Marcas com Bean</h1>
				<jsp:useBean id="marcaDao" class="br.edu.unifebe.dao.MarcaDao" />
				<ul>
					<c:forEach var="m" items="${marcaDao.listar}">
						<li><c:out value="${m.nome }" /></li>
					</c:forEach>
				</ul>
			</div>

		</div>

	</div>

</body>
</html>