package edu.miu.cs.cs544.exceptions;

public class NoSuchResourceException extends RuntimeException {

	private long resourceId;
	private String resourceType;

	public NoSuchResourceException(String resourceType ) {
		super();
		this.resourceType = resourceType;
		this.resourceId = resourceId;
	}
	
	public long getResourceId() {
		return resourceId;
	}
	
	public String getResourceType() {
		return resourceType;
	}

}
