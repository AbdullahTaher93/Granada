package com.crunchify.restjersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MoviesModel {
	
	private String MoviesID;
	private String name;
	private String description;
	private double rating;
	private String  images;
	
public MoviesModel() {}	
public MoviesModel(String id ,String name,String des,double rating,String images) {
		this.MoviesID=id;
		this.name=name;
		this.description=des;
		this.rating=rating;
		this.images=images;
	}

//set&get id
	public void setid(String id) {
		this.MoviesID=id;
		
	}
	
	public String getid() {
		return MoviesID;
		
	}
	
	
	//set&get name
		public void setname(String name) {
			this.name=name;
			
		}
		
		public String getname() {
			return name;
			
		}
		
		
		
		//set&get description
				public void setdescription(String desc) {
					this.description=desc;
					
				}
				
				public String getdescription() {
					return description;
				}
				
				
				//set&get rating
				public void setrating(double rating) {
					this.rating=rating;
					
				}
				
				public double getrating() {
					
					return rating;
				}
				
				
				//set&get images
				public void setimages(String imgaes) {
					this.images=imgaes;
					
				}
				
				public String getimages() {
					return images;
				}

}
