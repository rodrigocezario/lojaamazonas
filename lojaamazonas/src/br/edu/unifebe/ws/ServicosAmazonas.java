package br.edu.unifebe.ws;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.edu.unifebe.dao.MarcaDao;
import br.edu.unifebe.dao.ProdutoDao;
import br.edu.unifebe.modelo.Marca;
import br.edu.unifebe.modelo.Produto;

@Path("ws")
public class ServicosAmazonas {

	@GET
	@Path("/destaques") // retorna uma coleção de um tipo
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> destaque() {
		try {
			return new ProdutoDao().getSuperDestaque();
		} catch (SQLException e) {
			// throw new WebApplicationException("Erro ao carregar produtos em "
			// + "destaque: "+ e.getMessage());
			throw new WebApplicationException(Status.BAD_GATEWAY);
		}
	}

	@GET
	@Path("/produtos") // listou todos os produtos (coleção)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> produto() {
		try {
			return new ProdutoDao().getListar();
		} catch (SQLException e) {
			throw new WebApplicationException(Status.BAD_GATEWAY);
		}
	}

	@GET
	@Path("/produtos/{codigo}") // unico recurso da coleção
	@Produces(MediaType.APPLICATION_JSON)
	public Produto produto(@PathParam("codigo") int id) {
		try {
			return new ProdutoDao().getSelecionar(id);
		} catch (SQLException e) {
			throw new WebApplicationException(Status.BAD_GATEWAY);
		}
	}

	@GET
	@Path("/produtoresponse/{codigo}") // unico recurso da coleção
	@Produces(MediaType.APPLICATION_JSON)
	public Response produtoResponse(@PathParam("codigo") int id) {
		try {
			return Response.status(Status.OK).entity(new ProdutoDao().getSelecionar(id)).build();
		} catch (SQLException e) {
			throw new WebApplicationException(Status.BAD_GATEWAY);
		}
	}
	
	@GET
	@Path("/marcas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marca> marca(){
		try {
			return new MarcaDao().getListar();
		} catch (SQLException e) {
			throw new WebApplicationException(Status.BAD_GATEWAY);
		}
	}
	
	@GET
	@Path("/marcas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Marca marca(@PathParam("id") int id) {
		try {
			return new MarcaDao().getSelecionar(id);
		} catch (SQLException e) {
			throw new WebApplicationException(Status.BAD_GATEWAY);
		}
	}
	
	@POST
	@Path("/marcas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response marca(@FormParam("nome") String nome, 
			@FormParam("site") String site) {
		
		/*
		 * Para o FormParam 
		 * <form>
		 * <input type="text" id="nome">
		 * <input type="text" id="site">
		 * </form>
		 */
		
		Marca marca = new Marca();
		marca.setNome(nome);
		marca.setSite(site);
		try {
			new MarcaDao().setSalvar(marca);
			return Response.status(Status.CREATED).build();
			//cors (liberando individualmente)
			//optamos em implementar a classe CorsFilter
			//return Response.ok().
			//		header("Access-Control-Allow-Origin", "*").build();
		} catch (SQLException e) {
			throw new WebApplicationException(Status.BAD_GATEWAY);
		}
		
	}
	
	@POST
	@Path("/marcas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response marca(Marca marca) {
		try {
			new MarcaDao().setSalvar(marca);
			return Response.status(Status.CREATED).build();
		} catch (SQLException e) {
			throw new WebApplicationException(Status.BAD_GATEWAY);
		}
	}
	

}
