package testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root",
					"Godsaveus57");

			if (con == null) {
				System.out.println("Connection failed");
			} else {
				System.out.println("Success..Connection with Oracle DB is established");
			}

			Statement statement = con.createStatement();

			// Create the table
			String createTableQuery = "CREATE TABLE product2 (product_no INT, product_name VARCHAR(50), product_quantity INT, product_price INT)";
			statement.executeUpdate(createTableQuery);
			System.out.println("Table 'product2' created successfully.");

			// Insert 10 records into the table using a loop
			Scanner scanner = new Scanner(System.in);
			for (int i = 0; i < 10; i++) {
				System.out.println("Enter the product number: ");
				int no = scanner.nextInt();
				System.out.println("Enter the product name: ");
				String name = scanner.next();
				System.out.println("Enter the quantity: ");
				int quantity = scanner.nextInt();
				System.out.println("Enter the price: ");
				int price = scanner.nextInt();
				String insertQuery = "INSERT INTO product2 VALUES (" + no + ", '" + name + "', '" + quantity + "', '"
						+ price + "')";
				System.out.println(insertQuery);
				int result = statement.executeUpdate(insertQuery);
				if (result == 0) {
					System.out.println("Failed to insert the record.");
				} else {
					System.out.println("Record inserted successfully.");
				}
			}

			statement.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
