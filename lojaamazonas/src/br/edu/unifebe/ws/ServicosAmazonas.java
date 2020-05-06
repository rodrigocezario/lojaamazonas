package br.edu.unifebe.ws;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.edu.unifebe.dao.ProdutoDao;
import br.edu.unifebe.modelo.Produto;

@Path("ws")
public class ServicosAmazonas {

	@GET
	@Path("/destaque") //retorna uma coleção de um tipo
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> destaque(){
		try {
			return new ProdutoDao().getSuperDestaque();
		} catch (SQLException e) {
			//throw new WebApplicationException("Erro ao carregar produtos em "
			//		+ "destaque: "+ e.getMessage());
			throw new WebApplicationException(502);
		}
	}
	
	@GET
	@Path("/produto") //listou todos os produtos (coleção)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> produto(){
		try {
			return new ProdutoDao().getListar();
		} catch (SQLException e) {
			throw new WebApplicationException(502);
		}
	}
	
	@GET
	@Path("/produto/{codigo}") //unico recurso da coleção
	@Produces(MediaType.APPLICATION_JSON)
	public Produto produto(@PathParam("codigo") int id) {
		try {
			return new ProdutoDao().getSelecionar(id);
		} catch (SQLException e) {
			throw new WebApplicationException(502);
		}
	}
	
	@GET
	@Path("/produtoresponse/{codigo}") //unico recurso da coleção
	@Produces(MediaType.APPLICATION_JSON)
	public Response produtoResponse(@PathParam("codigo") int id) {
		try {
			return Response.status(Status.OK).entity(new ProdutoDao().getSelecionar(id)).build();
		} catch (SQLException e) {
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
	}
	
	
	//oferta
	
	//superofertas
	
}
