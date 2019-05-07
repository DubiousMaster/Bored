package main.core.db.mysql.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.core.models.Entity;

abstract class Mapper {
	protected Mapper() { }
	
	public abstract Mapper fillMapper(ResultSet set) throws SQLException;
	public abstract Entity toEntity();
}
