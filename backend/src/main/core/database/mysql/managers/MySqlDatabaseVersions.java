package main.core.database.mysql.managers;

public enum MySqlDatabaseVersions {
	MySqlDatabase("MySqlDatabase");
	
	private String versionName;
	public String getVersionName() { return this.versionName; }
	private MySqlDatabaseVersions(String versionName) {
		this.versionName = versionName;
	}
}
