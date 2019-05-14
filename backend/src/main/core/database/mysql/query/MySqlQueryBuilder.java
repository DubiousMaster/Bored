package main.core.database.mysql.query;

import java.util.ArrayList;
import java.util.List;

import main.util.Pair;

public final class MySqlQueryBuilder {
	private static final String parameter = " = ?";
	
	public static final String buildSelectQuery(List<Pair<String, List<String>>> selectTables) {
		List<String> tables = new ArrayList<>();
		for(Pair<String, List<String>> pairs : selectTables) {
			tables.add(pairs.getKey());
		}
		return select(selectTables) + from(tables);
	}
	
	public static final String buildSelectQuery(List<Pair<String, List<String>>> selectTables, List<Pair<String, List<String>>> whereTables) {
		List<String> tables = new ArrayList<>();
		for(Pair<String, List<String>> pairs : selectTables) {
			tables.add(pairs.getKey());
		}
		return select(selectTables) + from(tables) + where(whereTables);
	}
	
	public static final String buildInsertQuery(Pair<String, List<String>> insertTable) {
		return insert(insertTable.getKey()) + values(insertTable.getValue());
	}
	
	public static final String buildUpdateQuery(Pair<String, List<String>> updateTables, List<String> whereColumns) {
		List<Pair<String, List<String>>> whereTables = new ArrayList<>();
		whereTables.add(new Pair<>(updateTables.getKey(), whereColumns));
		return update(updateTables.getKey()) + set(updateTables.getValue()) + where(whereTables);
	}
	
	public static final String buildDeleteQuery(Pair<String, List<String>> deleteTable) {
		if(deleteTable.getValue().isEmpty()) throw new IllegalArgumentException("No arguments are provided. At least one argument must be provided.");
		List<Pair<String, List<String>>> deleteTables = new ArrayList<>();
		return delete(deleteTable.getKey()) + where(deleteTables);
	}
	
	private static final String select(List<Pair<String, List<String>>> selectColumns) {
		String select = "SELECT ";
		for(Pair<String, List<String>> pairs : selectColumns) {
			for(String column : pairs.getValue()) {
				select = select + ((pairs == selectColumns.get(0)) && column == pairs.getValue().get(0) ? "" : ", ") + pairs.getKey() + "." + column;
			}
		}
		return select;
	}
	
	private static final String from(List<String> fromTables) {
		String from = " FROM ";
		for(String table : fromTables) {
			from = from + (table == fromTables.get(0) ? "" : ", ") + table;
		}
		return from;
	}
	
	private static final String insert(String insertTable) {
		String insert = "INSERT INTO ";
		return insert + insertTable;
	}
	
	private static final String values(List<String> columns) {
		String beforeValues = "(";
		String values = " VALUES ";
		String afterValues = "(";
		for(String column : columns) {
			beforeValues = beforeValues + (column == columns.get(0) ? "" : ", ") + column;
			afterValues = afterValues + (column == columns.get(0) ? "" : ", ") + "?";
		}
		return beforeValues + ")" + values + afterValues + ")";
	}
	
	private static final String update(String updateTable) {
		String update = "UPDATE ";
		return update + updateTable;
	}
	
	private static final String delete(String deleteTable) {
		String delete = "DELETE FROM ";
		delete = delete + deleteTable;
		return delete;
	}
	
	private static final String set(List<String> updateColumns) {
		String set = " SET ";
		for(String column : updateColumns) {
			set = set + (column == updateColumns.get(0) ? "" : ", ") + column;
		}
		return set;
	}
	
	private static final String where(List<Pair<String, List<String>>> whereTables) {
		String where = " WHERE ";
		for(Pair<String, List<String>> pair : whereTables) {
			for(String column : pair.getValue()) {
				where = where + (pair == whereTables.get(0) ? "" : " AND ") + pair.getKey() + "." + column + parameter;
			}
		}
		return where;
	}
}
