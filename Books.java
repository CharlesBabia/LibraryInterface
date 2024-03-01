package act3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface LibraryItem{
	void borrowItem();
	void returnItem();
	boolean isBorrowed();
}
class Book implements LibraryItem{
	private String title;
	private String author;
	private boolean borrowed;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.borrowed = false;
	}
	@Override
	public void borrowItem() {
		borrowed = true;
		System.out.print("The Book " + title + " is Borrowed" + "\n");
	}
	@Override
	public void returnItem() {
		borrowed = false;
		System.out.print("The Book " + title + " is Borrowed" + "\n");
	}
	@Override
	public boolean isBorrowed() {
		return borrowed;
	}
	@Override
	public String toString() {
		return "Book :" + title + " " + "Writer : " + author;
	}
	
}
class DVD implements LibraryItem{
	private String Title;
	private String Director;
	private int Runtime;
	private boolean borrowed;
	public DVD(String Title, String Director, int Runtime) {
		this.Title = Title;
		this.Director = Director;
		this.Runtime = Runtime;
		borrowed=false;
	}
	@Override
	public void borrowItem() {
		borrowed = true;
		System.out.print("The DVD " + Title + " is Borrowed" + "\n");
	}
	@Override
	public void returnItem() {
		borrowed = false;
		System.out.print("The DVD " + Title + " has been Returned" + "\n");
	}
	@Override
	public boolean isBorrowed() {
		return borrowed;
	}
	 @Override
	    public String toString() {
	        return "DVD: " + Title + " (Director: " + Director + ", Running Time: " + Runtime + " minutes)";
	    }
}
abstract class LibraryUser{
	List<LibraryItem> borrowedItems;
	public LibraryUser() {
		borrowedItems = new ArrayList<>();
	}
	public void borrowItem(LibraryItem Item){
		if (!Item.isBorrowed()) {
			Item.borrowItem();
			borrowedItems.add(Item);
		}else {
			System.out.print("Item is already borrowed" + "\n");
		}
	}
		public void returnItem (LibraryItem Item) {
			if(borrowedItems.contains(Item)) {
				Item.returnItem();
				borrowedItems.remove(Item);
			}else {
				System.out.print("This item is not borrowed by the user" + "\n");
		}
			
		}
			public abstract void printItemsBorrowed();
		
	
}
class Student extends LibraryUser{
	@Override
	public void printItemsBorrowed() {
		for (LibraryItem Item : borrowedItems) {
			System.out.print("Items borrowed by Student: " + Item.toString() + "\n");
		}
	}
}
class Teacher extends LibraryUser{
	@Override
	public void printItemsBorrowed() {
		System.out.print("Items Borrowed by Teacher: ");
		for (LibraryItem Item : borrowedItems) {
			System.out.print("- " + Item.toString() + "\n");
		}
	}
}
public class Books {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Book Title and Author?");
		Book book1 = new Book(s.nextLine(),s.nextLine());
		System.out.print("Enter Dvd Title, Director, and Runtime");
		DVD dvd1 = new DVD(s.nextLine(), s.nextLine(), s.nextInt());
		Student student = new Student();
		Teacher teacher = new Teacher();
		
		char ch;
		do {
			System.out.print("What do you want to do?" + "\n" + "1.Borrow 2.Return 3.Show Items Borrowed");	
		int n =s.nextInt();
		switch(n) {
		case 1: 
			System.out.print("Are you a 1.Student or 2.Teacher?");
			int a = s.nextInt();
			switch(a) {
			case 1 : System.out.print("What does student want to borrow? 1.Dvd 2.Book");
				int w = s.nextInt();
				if(w == 1 ) {
					student.borrowItem(dvd1);
				}
					else{
						student.borrowItem(book1);
					}
					student.printItemsBorrowed();
				break;
			
			case 2 : System.out.print("What does teacher want to borrow? 1.Dvd 2.Book");
			int r = s.nextInt();
			if (r == 1) {
				teacher.borrowItem(dvd1);
				
			}
			else{
				teacher.borrowItem(book1);
			}
			teacher.printItemsBorrowed();
			break;
			}
			break;
		case 2 : System.out.print("Are you a 1.Student or 2.Teacher?"); 
		int b = s.nextInt();
			switch(b) {
			case 1 : System.out.print("What Does Student want to return 1.Dvd 2.Book");
				int e = s.nextInt();
				if(e == 1) {
					student.returnItem(dvd1);
				}elseif(e == 2);{
					student.returnItem(book1);
				}
				student.printItemsBorrowed();
				break;
			case 2: System.out.print("What Does Teacher want to return 1.Dvd 2.Book");
			int u = s.nextInt();
			if (u == 1) {
				teacher.returnItem(dvd1);
				
			}elseif(u == 2);{
				teacher.returnItem(book1);
				
			}
			teacher.printItemsBorrowed();
			break;
			}
			break;
		case 3 : System.out.print("Are you a 1. Student or 2. Teacher");
		int u = s.nextInt();
		switch(u) {
		case 1 : student.printItemsBorrowed();
		break;
		case 2 : teacher.printItemsBorrowed();
		break;
		}
		break;
		default : System.out.print("That's Not in the Choices Clearly :<" + "\n");
		break;
		} System.out.print("Do you wish to continue? Y or N");
		ch=s.next().charAt(0);
	}while(ch =='y' || ch =='Y');
		
	}

	private static void elseif(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

