package main.core.exceptions;

public class EntityNotUniqueException extends Exception {

	private static final long serialVersionUID = 8089331765382042796L;

	public EntityNotUniqueException() {
		super("The entity already exists in the given data source.");
	}
}
