package main.core.http.mappers;

import main.models.Entity;

abstract class Mapper {

	protected Mapper() {
	}
	
	protected abstract Entity toEntity();
}
