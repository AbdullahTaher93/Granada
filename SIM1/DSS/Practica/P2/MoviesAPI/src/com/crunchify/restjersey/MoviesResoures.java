package com.crunchify.restjersey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;



// Will map the resource to the URL Movies
@Path("/movies")
public class MoviesResoures {
	
	
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    
    
 // Return the list of Movies to the user in the browser
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    
    
    public List<MoviesModel> getMoviesBrowser() {
        List<MoviesModel> movies = new ArrayList<MoviesModel>();
        movies.addAll(MoviesDao1.instance.getModel().values());
        return movies;
    }
    
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String movieshtml() {
    	 List<MoviesModel> movies = new ArrayList<MoviesModel>();
         movies.addAll(MoviesDao1.instance.getModel().values());
         String output="";
         for(int i=0;i<movies.size();i++)
         {
        	  output=output+"<!DOCTYPE html>\r\n" + 
        	  		"<html>\r\n" + 
        	  		"<body>\r\n" + 
        	  		"\r\n" + 
        	  		"<h3>Movie ID:  </h3>"+movies.get(i).getid()+"\r\n" +
        	  		"<h3>Movie Name:  </h3>"+movies.get(i).getname()+"\r\n" +
        	  		"<h3>Movie Description:  </h3>"+movies.get(i).getdescription()+"\r\n" +
        	  		"<h3>Movie rating:  </h3>"+movies.get(i).getrating()+"\r\n" +
        	  		""+"<h3>Image of Movie</h3>\r\n" +
        	  		"<img src= "+movies.get(i).getimages()+" \">\r\n" + 
        	  		"\r\n" + 
        	  		"</body>\r\n" + 
        	  		"</html>";
         }
    	
         
    	return output;
    }
   
    
 // Return the list of Movies for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<MoviesModel> getmovies() {
        List<MoviesModel> movies = new ArrayList<MoviesModel>();
        movies.addAll(MoviesDao1.instance.getModel().values());
        return movies;
    }
    
    
    
    // retun the number of Movies
    // Use http://localhost:8080/com.crunchify.restjersey/rest/movies/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = MoviesDao1.instance.getModel().size();
        return String.valueOf(count);
    }
    
    
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newmoveis(@FormParam("id") String id,
            @FormParam("name") String name,
            @FormParam("description") String description,
            @FormParam("rating") Double rating,
            @FormParam("images") String images,
            
            
        @Context HttpServletResponse servletResponse) throws IOException {
        MoviesModel movies = new MoviesModel(id, name,description,rating,images);
        
        MoviesDao1.instance.getModel().put(id, movies);

        servletResponse.sendRedirect("../Movies.html");
    }
    
    
    
 // Defines that the next path parameter after Movie is
    // treated as a parameter and passed to the MoviesResource
    // Allows to type http://localhost:8080/com.crunchify.restjersey/rest/movies/1
    // 1 will be treaded as parameter Movie and passed to MoviesResource
    @Path("{movie}")
    public MoviesResource getmovie(@PathParam("movie") String id) {
        return new MoviesResource(uriInfo, request, id);
    }

}



