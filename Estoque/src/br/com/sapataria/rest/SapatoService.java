package br.com.sapataria.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
import br.com.sapataria.dao.SapatoDAO;
import br.com.sapataria.entidade.Sapato;
 
@Path("/")
public class SapatoService {

	private static final String CHARSET_UTF8 = ";charset=utf-8";
	 
    private SapatoDAO sapatoDAO;
     
    @PostConstruct
    private void init() {
        sapatoDAO = new SapatoDAO();
    }
     
    @GET
    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public List<Sapato> listarSapatos() {
        List<Sapato> lista = null;
        try {
            lista = sapatoDAO.listarSapatos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
     
     
    @POST
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    @Produces(MediaType.TEXT_PLAIN)
    public String addSapato(Sapato sapato) {
        String msg = "";
  
        try {
            int idGerado = sapatoDAO.addSapato(sapato);
            msg = String.valueOf(idGerado);
        } catch (Exception e) {
            msg = "Erro ao adicionar o sapato!";
            e.printStackTrace();
        }
 
        return msg;
    }
     
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public Sapato buscarSapatoPorId(@PathParam("id") int idSapato) {
        Sapato sapato = null;
        try {
            sapato = sapatoDAO.buscarSapatoPorId(idSapato);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sapato;
    }
 
    @PUT
    @Path("/id/{id}")
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    @Produces(MediaType.TEXT_PLAIN)
    public String editarSapato(Sapato sapato, @PathParam("id") int idSapato) {
        String msg = "";
                  
        try {
            sapatoDAO.editarSapato(sapato, idSapato);             
            msg = "Sapato editado com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao editar o sapato!";
            e.printStackTrace();
        }
         
        return msg;
    }
     
    @DELETE
    @Path("/id/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String removerSapato(@PathParam("id") int idSapato) {
        String msg = "";
         
        try {
            sapatoDAO.removerSapato(idSapato);
             
            msg = "Sapato removido com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao remover o sapato!";
            e.printStackTrace();
        }
         
        return msg;
    }
    
    @GET
    @Path("/nome/{nome}")
    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public List<Sapato> buscarSapatoPorNome(@PathParam("nome") String nomeSapato) {
    	List<Sapato> lista = null;
        try {
            lista = sapatoDAO.buscarSapatoPorNome(nomeSapato);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
	
}
