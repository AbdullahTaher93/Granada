package com.crunchify.restjersey;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;



public class MoviesResource {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    
    public MoviesResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public MoviesModel getAllMovies() {
    	MoviesModel movies = MoviesDao1.instance.getModel().get(id);
        if(movies==null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return movies;
    }
    
    
    
    
    @GET
    @Produces(MediaType.TEXT_XML)
    public MoviesModel getAllMoviesHTML() {
    	MoviesModel movies = MoviesDao1.instance.getModel().get(id);
        if(movies==null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return movies;
    }
    
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putMovie(JAXBElement<MoviesModel> todo) {
    	MoviesModel moive = todo.getValue();
        return putAndGetResponse(moive);
    }
    
    
    
    @DELETE
    public void deleteMovie() {
    	MoviesModel moive = MoviesDao1.instance.getModel().remove(id);
        if(moive==null)
            throw new RuntimeException("Delete: Movie with " + id +  " not found");
    }
    
    
    private Response putAndGetResponse(MoviesModel moive ) {
        Response res;
        if(MoviesDao1.instance.getModel().containsKey(moive.getid())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        MoviesDao1.instance.getModel().put(moive.getid(), moive);
        return res;
    }

}
