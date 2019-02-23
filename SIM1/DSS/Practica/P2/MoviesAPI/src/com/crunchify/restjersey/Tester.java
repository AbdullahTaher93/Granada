package com.crunchify.restjersey;


import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;


import org.glassfish.jersey.client.ClientConfig;
public class Tester {

	public static void main(String[] args) {
		
		
		ClientConfig config = new ClientConfig();
	      Client client = ClientBuilder.newClient(config);
	      WebTarget service = client.target(getBaseURI());
	      
	      MoviesModel movi;
	      
	       movi = new MoviesModel("4","THE MULE","In his first performance in six years, Clint Eastwood brings an elegiac gracefulness and good humor—not to mention defiant toughness—to the role of a 90-year-old flower aficionado named Earl who opts to work as a drug runner in The Mule. Eastwood’s lined visage and creaky comportment can’t dull his fiery spirit in this based-on-real-events drama, which finds the Hollywood icon amusingly raging against modernity’s Internet-and-smartphone addictions, even as his down-on-his-luck character grapples with the familial cost of putting personal obsessions above all else. Pursued by Bradley Cooper’s ambitious DEA agent, who’s similarly striving to meet the requirements of a demanding boss (Laurence Fishburne), Eastwood’s protagonist proves another one of his broken-down big-screen warriors. Full of ladies’ man charm and self-deprecating wit, his turn is as assured as his typically efficient direction, which balances suspense and poignancy with aplomb. It’s further confirmation that the legendary filmmaker hasn’t lost his nimble, self-referential touch.",6.5,"https://www.esquire.com/entertainment/movies/g14465325/best-movies-of-2018/");
	      Response response = service.path("rest").path("movie").path(movi.getid()).request(MediaType.APPLICATION_XML).put(Entity.entity(movi,MediaType.APPLICATION_XML),Response.class);
	      
	   // Return code should be 201 == created resource
	      System.out.println(response.getStatus());
	      
	      
	   // Get the Movie
	      System.out.println(service.path("rest").path("movie").request().accept(MediaType.TEXT_XML).get(String.class));

//	    // Get JSON for application (Make sure to add the jersey-media-json-jackson dependency to add support for JSON)
//	    System.out.println(service.path("rest").path("movies").request().accept(MediaType.APPLICATION_JSON).get(String.class));

	      // Get XML for application
	      System.out.println(service.path("rest").path("movies").request().accept(MediaType.APPLICATION_XML).get(String.class));
		
	      
	      
	    //Get Movie with id 1
	      Response checkDelete = service.path("rest").path("movies/1").request().accept(MediaType.APPLICATION_XML).get();
	      
	      //Delete Movie with id 1
	      service.path("rest").path("Movie/1").request().delete();
	      
	      
	      
	      
	    //Get get all Movies id 1 should be deleted
	      System.out.println(service.path("rest").path("movie").request().accept(MediaType.APPLICATION_XML).get(String.class));
	      
	      
	      
	      //Create a Movie
	      Form form =new Form();
	      form.param("id", "5");
	      form.param("Cast away","description");
	      response = service.path("rest").path("movie").request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);
	      System.out.println("Form response " + response.getStatus());

	      //Get all the movie, id 4 should have been created
	      System.out.println(service.path("rest").path("movie").request().accept(MediaType.APPLICATION_XML).get(String.class));

	  
	}
	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/com.crunchify.restjerse.rest.movie").build();
	  }

	  
}


