// This bookstore java program allows a bookstore clerk to enter, change and view book details in the bookstore database.
import java.util.Scanner;

public class BookStore extends Book{	// inherits methods from Book class
	
	public static void main(String[] args) {
		// create variables for main menu and sub-menus
		int mainMenu;
		int deleteMenu;
		int updateMenu;
		int searchMenu;
		
		Scanner input = new Scanner(System.in);
		
		do {
			
		System.out.println("Bookstore Main Menu");
		System.out.println();
		System.out.println("1. Enter book");
		System.out.println("2. Update book");
		System.out.println("3. Delete book");
		System.out.println("4. Search books");
		System.out.println("5. View Inventory");
		System.out.println("0. Exit");
		System.out.println();
		System.out.println("Please enter choice: ");
		
		mainMenu = input.nextInt();	//scans in user input
		input.nextLine();	// next.Line() after next.Int() fixes scanner jumping lines issue (referred to as ScannerLineHack in rest of comments)
		
		switch (mainMenu) {
		case 1:	
			Book newBook = new Book();	// instantiates object newBook from Book class
			
			System.out.println("Enter book into database \n");
			
			System.out.println("Enter id: ");
			newBook.setId(input.nextInt());	// sets attribute defined by user to newBook using setId method from Book class
			input.nextLine();
			
			System.out.println("Enter Title:");
			newBook.setTitle(input.nextLine());	// sets attribute to newBook using setTitle method from Book class
			
			System.out.println("Enter Author: ");
			newBook.setAuthor(input.nextLine());	// sets attribute to newBook using setAuthor method from Book class
		
			System.out.println("Enter Quantity: ");
			newBook.setQty(input.nextInt());	// sets attribute to newBook using setQty method from Book class
			
			BookDatabase.enterBook(newBook);	//call to method enterBook in BookDatabase class on newBook
			
			break;
			
		case 2://MAINMENU
			Book updateBook = new Book();	// instantiates object updateBook from Book class
			
			System.out.println("Update book Menu");
			System.out.println();
			System.out.println("1. Update id");
			System.out.println("2. Update Title");
			System.out.println("3. Update Author");
			System.out.println("4. Update Quantity");
			System.out.println();
			System.out.println("Please enter choice: ");
			
			
			updateMenu = input.nextInt();
			input.nextLine();	// ScannerLineHack
			
			switch (updateMenu) {
			case 1:	// updateMenu
				System.out.println("Enter book Title");
				updateBook.setTitle(input.nextLine());
				
				System.out.println("Enter new id: ");
				updateBook.setId(input.nextInt());
				
				BookDatabase.updateId (updateBook);	//call to method updateId in BookDatabase class on updateBook
				break;
			
			case 2:// updateMenu	
				System.out.println("Enter book id: ");
				updateBook.setId(input.nextInt());
				input.nextLine(); // ScannerLineHack
				
				System.out.println("Enter new Title");
				updateBook.setTitle(input.nextLine());
				
				BookDatabase.updateTitle(updateBook);	//call to method updateTitle in BookDatabase class on updateBook
				break;
		
			case 3:// updateMenu	
				System.out.println("Enter book id: ");
				updateBook.setId(input.nextInt());
				input.nextLine(); // ScannerLineHack
				
				System.out.println("Enter new Author");
				updateBook.setAuthor(input.nextLine());
				
				BookDatabase.updateAuthor(updateBook);	//call to method updateAuthor in BookDatabase class on updateBook
				break;
			
			case 4:// updateMenu	
				System.out.println("Enter book id: ");
				updateBook.setId(input.nextInt());
				
				System.out.println("Enter new Quantity: ");
				updateBook.setQty(input.nextInt());
				
				BookDatabase.updateQuantity(updateBook);	//call to method updateQuantity in BookDatabase class on updateBook
				break;
			}
			break;
		
		case 3://MAINMENU
			Book deleteBook = new Book();	// instantiates object deleteBook from Book class
			
			System.out.println("Delete book Menu");
			System.out.println();
			System.out.println("1 Delete using id");
			System.out.println("2 Delete using Title");
			System.out.println("3 Delete using Author");
			System.out.println();
			System.out.println("Please enter choice: ");
			
			deleteMenu = input.nextInt();
			input.nextLine();	// ScannerLineHack
			
			switch (deleteMenu) {
			
			case 1:	// deleteMenu
				System.out.println("Enter book id: ");
				deleteBook.setId(input.nextInt());
				input.nextLine();	// ScannerLineHack
				
				BookDatabase.deleteUsingId(deleteBook);	//call to method deleteUsingId in BookDatabase class on deleteBook
				
				break;
				
			case 2:	// deleteMenu	
				System.out.println("Enter book Title: ");
				deleteBook.setTitle(input.nextLine());
				deleteUsingTitle (deleteBook);	//call to method deleteUsingTitle in BookDatabase class on deleteBook
				break;
				
			case 3:	// deleteMenu
				System.out.println("Enter book Author: ");
				deleteBook.setAuthor(input.nextLine());
				deleteUsingAuthor(deleteBook);	//call to method deleteUsingAuthor in BookDatabase class on deleteBook
				break;
			}
			break;
			
		case 4://MAINMENU
			Book searchBook = new Book();	// instantiates object SearchBook from Book class
			
			System.out.println("Search books Menu");
			System.out.println();
			System.out.println("1 Search using id");
			System.out.println("2 Search using Title");
			System.out.println("3 Search using Author");
			System.out.println("4 Search using Quantity");
			System.out.println();
			System.out.println("Please enter choice: ");
			
			searchMenu = input.nextInt();
			input.nextLine();	// ScannerLineHack
			
			switch (searchMenu) {
			
			case 1:// searchMenu
				System.out.println("Enter book id: ");
				searchBook.setId(input.nextInt());
				BookDatabase.searchUsingId(searchBook);	//call to method searchUsingId in BookDatabase class on searchBook
				break;
			
			case 2:// searchMenu
				System.out.println("Enter book Title: ");
				searchBook.setTitle(input.nextLine());
				BookDatabase.searchUsingTitle(searchBook);	//call to method searchUsingTitle in BookDatabase class on searchBook
				break;
			
			case 3:// searchMenu
				System.out.println("Enter book Author: ");
				searchBook.setAuthor(input.nextLine());
				BookDatabase.searchUsingAuthor(searchBook);	//call to method searchUsingAuthor in BookDatabase class on searchBook
				break;
				
			case 4:// searchMenu
				System.out.println("Enter Quantity: ");
				searchBook.setQty(input.nextInt());
				BookDatabase.searchUsingQty(searchBook);	//call to method searchUsingQty in BookDatabase class on searchBook
				break;
			}
			break;
		
		case 5://mainMenu
			BookDatabase.displayInventory();	//call to method displayInventory in BookDatabase class 
			break;
		}
	} 
	while (mainMenu != 0);
	
	if (mainMenu == 0) {	
		input.close();	// close scanner resource
		System.out.println("Exiting System");	//note to indicate system session terminated
	}
	}
}
	
