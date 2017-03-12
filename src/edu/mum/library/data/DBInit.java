package edu.mum.library.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.mum.library.business.Address;
import edu.mum.library.business.Author;
import edu.mum.library.business.Book;
import edu.mum.library.business.Publication;
import edu.mum.library.business.Role;
import edu.mum.library.business.User;
import edu.mum.library.data.impl.DataAccessObjectImpl;
import edu.mum.library.data.impl.DataObjectFactory;

public class DBInit {

	public static void populate() {
		DataAccessObject dao = (DataAccessObjectImpl) DataObjectFactory.getDataObject(DataAccessObject.class);

		String password = "123";
		User user = new User("lib", password, Role.LIBRARIAN);
		dao.save("lib", user);

		user = new User("admin", password, Role.ADMINISTRATOR);
		dao.save("admin", user);

		user = new User("super", password, Role.LIBRARIAN_ADMINISTRATOR);
		dao.save("super", user);
		// Creating books
		Address add1 = new Address("1000 N 4th St", "Fairfield", "IA", 52557);
		Author a1 = new Author("James", "Tolkien", add1, "+59898830609", "Wrote the Lord of the Rings saga",
				"This guy is awsome");
		dao.save(a1.getName() + a1.getLastName(), a1);
		Book b1 = new Book("The Lord of the Rings - The Two Towers", "00124325", a1, 21);
		b1.setDate(new Date());
		dao.save("00124325", b1);


		Address add2=new Address("1100 N 4th St","Fairfield","IA",52557);
		Author a2=new Author("Pablo","Neruda",add2,"+59898834020","It was mentioned on Arjona's song","Wrote some boooks");
		dao.save(a2.getName()+a2.getLastName(),a2);
		Book b2 =new Book("I don't know this book","10166625",a2,7);
		dao.save("10166625",b2);
		Publication pub=new Publication("Times",7);
		pub.setDate(new Date());
		dao.save(pub.getTitle() + new SimpleDateFormat("dd-MM-yyyy").format(new Date()), pub);
		Publication pub1=new Publication("Science",7);
		pub1.setDate(new Date());
		dao.save(pub1.getTitle() + new SimpleDateFormat("dd-MM-yyyy").format(new Date()), pub1);

	}

}
