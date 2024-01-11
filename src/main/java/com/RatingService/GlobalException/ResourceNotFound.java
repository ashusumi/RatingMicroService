package com.RatingService.GlobalException;

public class ResourceNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFound() {
		super("No Ratings Found");
		
	}
	
	public ResourceNotFound(String msg) {
		super(msg);
		
	}

	
}
