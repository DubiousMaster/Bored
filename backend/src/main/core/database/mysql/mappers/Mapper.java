package main.core.database.mysql.mappers;

import main.core.database.DataRepository;
import main.core.database.mysql.MySqlRepository;
import main.models.Entity;

abstract class Mapper {
	private final DataRepository repository;
	protected final DataRepository getRepository() {
		return this.repository;
	}
	
	protected Mapper() {
		this.repository = new MySqlRepository();
	}
	
	public abstract Entity toEntity();
}
