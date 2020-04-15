// BookDatabase class controls all requests to mySQl server from BookStore class using a Book class object 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class BookDatabase {
	
	public static void enterBook(Book newBook) {//method uses object instantiated in Book class as parameter
		
		try {
			// establish connection to database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlInsert = "INSERT INTO books VALUES (?,?,?,?)";	//SQL request statement
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);	
			stmt.setInt(1, newBook.getId());	// method from Book class provides attribute of object
			stmt.setString(2,  newBook.getTitle());
			stmt.setString(3,  newBook.getAuthor());
			stmt.setInt(4, newBook.getQty());
			
			int countInserted = stmt.executeUpdate();	//counter to show changes are successful
			System.out.println(countInserted + " records inserted.\n");
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void updateId (Book updateBook) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlUpdate = "UPDATE books SET id = ? WHERE Title = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
			stmt.setInt(1, updateBook.getId());
			stmt.setString(2, updateBook.getTitle());
			
			int countUpdated = stmt.executeUpdate();
			System.out.println(countUpdated + " records updated.\n");
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void updateTitle (Book updateBook) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlUpdate = "UPDATE books SET Title = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
			stmt.setString(1, updateBook.getTitle());
			stmt.setInt(2, updateBook.getId());
			
			int countUpdated = stmt.executeUpdate();
			System.out.println(countUpdated + " records updated.\n");
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
public static void updateAuthor (Book updateBook) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlUpdate = "UPDATE books SET Author = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
			stmt.setString(1, updateBook.getAuthor());
			stmt.setInt(2, updateBook.getId());
			
			int countUpdated = stmt.executeUpdate();
			System.out.println(countUpdated + " records updated.\n");
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
public static void updateQuantity (Book updateBook) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlUpdate = "UPDATE books SET Qty = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
			stmt.setInt(1, updateBook.getQty());
			stmt.setInt(2, updateBook.getId());
			
			int countUpdated = stmt.executeUpdate();
			System.out.println(countUpdated + " records updated.\n");
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void deleteUsingId(Book deleteBook) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlDelete = "DELETE FROM books WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlDelete);
			stmt.setInt(1,  deleteBook.getId());
			
			int countDeleted = stmt.executeUpdate();
			System.out.println(countDeleted + " records deleted.\n");
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteUsingTitle(Book deleteBook) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlDelete = "DELETE FROM books WHERE Title = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlDelete);
			stmt.setString(1, deleteBook.getTitle());
			
			int countDeleted = stmt.executeUpdate();
			System.out.println(countDeleted + " records deleted.\n");
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteUsingAuthor(Book deleteBook) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			
			String sqlDelete = "DELETE FROM books WHERE Author = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlDelete);
			stmt.setString(1,  deleteBook.getAuthor());
			
			int countDeleted = stmt.executeUpdate();
			System.out.println(countDeleted + " records deleted.\n");
			
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void searchUsingId (Book searchBook) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlSearch = "SELECT * FROM books WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlSearch);
			stmt.setInt(1, searchBook.getId());
			
			ResultSet rset = stmt.executeQuery();
			
			System.out.println("The records selected are: \n");
			int rowCount = 0;
			
			while(rset.next()) {	// prints out record with all fields showing
				System.out.println(rset.getInt("id") + ", " + rset.getString("Title") + ", " + rset.getString("Author") + ", " + rset.getInt("Qty"));
				++rowCount;
			}
			
			System.out.println("Total number of records = " + rowCount + "\n"); // rowCount to indicate number of records to user
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void searchUsingTitle (Book searchBook) {
		
		try {
			
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlSearch = "SELECT * FROM books WHERE Title = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlSearch);
			stmt.setString(1, searchBook.getTitle());
			
			ResultSet rset = stmt.executeQuery();
				
			System.out.println("The records selected are: \n");
			int rowCount = 0;
			
			while(rset.next()) {
				System.out.println(rset.getInt("id") + ", " + rset.getString("Title") + ", " + rset.getString("Author") + ", " + rset.getInt("Qty"));
				++ rowCount;
			}
			
			System.out.println("Total number of records = " + rowCount + "\n");
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void searchUsingAuthor (Book searchBook) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlSearch = "SELECT * FROM books WHERE Author = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlSearch);
			stmt.setString(1, searchBook.getAuthor());
			
			ResultSet rset = stmt.executeQuery();
			
			System.out.println("The records selected are: \n");
			int rowCount = 0;
			
			while(rset.next()) {
				System.out.println(rset.getInt("id") + ", " + rset.getString("Title") + ", " + rset.getString("Author") + ", " + rset.getInt("Qty"));
				++ rowCount;
			}
			
			System.out.println("Total number of records = " + rowCount + "\n");
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void searchUsingQty (Book searchBook) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlSearch = "SELECT * FROM books WHERE Qty = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlSearch);
			stmt.setInt(1, searchBook.getQty());
			
			ResultSet rset = stmt.executeQuery();
			
			System.out.println("The records selected are: \n");
			int rowCount = 0;
			
			while(rset.next()) {
				System.out.println(rset.getInt("id") + ", " + rset.getString("Title") + ", " + rset.getString("Author") + ", " + rset.getInt("Qty"));
				++ rowCount;
			}
			
			System.out.println("Total number of records = " + rowCount + "\n");
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void displayInventory () {	//method has no parameters as it displays all data in database
		
try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root", "Longboard");
			
			String sqlDisplay = "SELECT * FROM books";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sqlDisplay);
			
			System.out.println("The books in inventory are: \n ");
			int rowCount = 0;
			
			while(rset.next()) {
				System.out.println(rset.getInt("id") + ", " + rset.getString("Title") + ", " + rset.getString("Author") + ", " + rset.getInt("Qty"));
				++ rowCount;
			}
			
			System.out.println("Total number of records = " + rowCount + "\n");
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}
