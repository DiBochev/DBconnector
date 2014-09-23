package testDB;

public class Main {

	public static void main(String[] args) {
		String DBName = "STUDENTS";
		DBConnector.Connect(DBName);
		String tableName  = "tableName";
		String column1 = "column1";
		String column11 = "varchar(255)";
		String column2 = "column2";
		String column21 = "varchar(255)";
		String column3 = "column3";
		String column31 = "varchar(255)";
		DBConnector.CreateTable(tableName, column1,column11, column2, column21, column3, column31);
		//DBConnector.DropTable(tableName);
		DBConnector.TableInsert(tableName, "'test'", "'test'", "'test'");
		DBConnector.TableView(tableName, column1, column2, column3);
		DBConnector.ConnectionClose();
	}

}
