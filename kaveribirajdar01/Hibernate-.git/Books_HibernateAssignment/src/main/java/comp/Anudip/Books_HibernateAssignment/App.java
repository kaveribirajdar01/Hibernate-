package comp.Anudip.Books_HibernateAssignment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	
	public static SessionFactory getConfiguration() 
	{
		Configuration conf = new Configuration().configure().addAnnotatedClass(Book.class);
		SessionFactory ss = conf.buildSessionFactory();
		return ss;
	}
	
	public static void create_book(Session ss,Transaction t) {
		
		Book b1=new Book(1,"The India Story",750,"Bimal Jalal","Available");
		Book b2=new Book(2,"Let us Dream",430,"Pope Francis ","Not Available");
		Book b3=new Book(3,"Vivekadeepini",299,"Adi Shankaracharya","Available");
		Book b4=new Book(4,"Hit Refresh",320,"Satya Nadella", "Not Available");
		Book b5=new Book(5,"Agnipankh",300,"A.P.J. Abdul Kalam", "Available");
		
		ss.save(b1);
		ss.save(b2);
		ss.save(b3);
		ss.save(b4);
		ss.save(b5);
		
		t.commit();
	}
	public static void get_books(Session ss,Transaction t) {
		Query query = ss.createQuery("from Book");
		List<Book> books = query.list();
		for(Book getbooks:books) {
			System.out.println("Book id: "+getbooks.getBook_id()+" Book Name: "+getbooks.getBook_name()+" Book price: "+getbooks.getBook_price()+" Author Name: "+getbooks.getAuthor_name()+" Library Name: "+getbooks.getLibraryName()+" Availability: "+getbooks.getAvailability());
		}
	}
	
	public static void updateBook(Session ss, Transaction t) {
		t.begin();
		Book b = ss.find(Book.class, 2);
		b.setBook_name("William Shakespeare");
		ss.save(b);
		t.commit();

	}
	public static void deleteBook(Session ss, Transaction t) {
		t.begin();
		Book b = ss.find(Book.class, 2);

		ss.delete(b);
		t.commit();

	}
		
	
    public static void main( String[] args )
    {
    	SessionFactory sessionfactory = getConfiguration();
		Session session = sessionfactory.openSession();
		Transaction t = session.beginTransaction();
		createBook(session, t);
		updateBook(session,t);
		deleteBook(session,t);
		getAllBook(session, t);
		System.out.println("Successful...");
    	
     }

	private static void getAllBook(Session session, Transaction t) {
		// TODO Auto-generated method stub
		
	}

	private static void createBook(Session session, Transaction t) {
		// TODO Auto-generated method stub
		
	}
}
