package testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// jdbc:mysql://localhost:3306/?user=root

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root",
					"Godsaveus57");

			if (con == null) {
				System.out.println("Connection failed");
			} else {
				System.out.println("Success..Connection with Oracle DB is established");
			}

			// connection established
			Statement statement = con.createStatement();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the student number: ");
			int no = scanner.nextInt();
			System.out.println("Enter the student name: ");
			String name = scanner.next();
			System.out.println("Enter the course enrolled: ");
			String course = scanner.next();
			String sqlQuery = "insert into student values (" + no + ", '" + name + "', '" + course + "')";
			System.out.println(sqlQuery);
			int result = statement.executeUpdate(sqlQuery);
			if (result == 0) {
				System.out.println("Failed to insert the Record");
			} else {
				System.out.println("Record inserted Successfully");
			}
			statement.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
