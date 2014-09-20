package testDB;

public class Main {

	public static void main(String[] args) {
			DBConnector.Connect();
			String tableName  = "tableName";
			String column1 = "column1";
			String column2 = "varchar(255)";
			String column3 = "column2";
			String column4 = "varchar(255)";
			String column5 = "column3";
			String column6 = "varchar(255)";
			DBConnector.ImportTable(tableName, column1,column2, column3, column4, column5, column6);
			DBConnector.DropTable(tableName);
			DBConnector.ConnectionClose();
	}

}
