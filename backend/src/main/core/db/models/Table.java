package main.core.db.models;

import java.util.Collections;
import java.util.List;

public class Table {
	private String name;
	private List<String> columns;
	
	public String getName() { return this.name; }
	public List<String> getColumns() { return Collections.unmodifiableList(this.columns); }

	public Table(String name, List<String> columns) {
		this.name = name;
		this.columns = columns;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
