package edu.mum.library.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.mum.library.business.Address;
import edu.mum.library.business.Author;
import edu.mum.library.business.Book;
import edu.mum.library.business.LibraryMember;
import edu.mum.library.business.Publication;
import edu.mum.library.business.Role;
import edu.mum.library.business.User;
import edu.mum.library.data.impl.DataObjectFactory;

public class DBInit {

	public static void populate() {
		DataAccessObject dao = DataObjectFactory.getDataObject();

		createUsers(dao);

		createBooks(dao);

		createPublications(dao);

		Address address = new Address("1000 N 4th St", "Fairfield", "IA", 52557);

		int num = 1;
		LibraryMember member = new LibraryMember(num, "Gustavo", "Sousa", address, "123234353");
		dao.save(new Integer(num).toString(), member);

		num = 2;
		member = new LibraryMember(num, "Diego", "Lussich", address, "12376813");
		dao.save(new Integer(num).toString(), member);

		num = 3;
		member = new LibraryMember(num, "Neymar", "Jr.", address, "7374547472");
		dao.save(new Integer(num).toString(), member);

		num = 4;
		member = new LibraryMember(num, "Steve", "Jobs", address, "67896583544");
		dao.save(new Integer(num).toString(), member);
	}

	private static void createPublications(DataAccessObject dao) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Publication publication = new Publication("National Geographic", 7);
			String date = "05-03-2017";
			publication.setDate(format.parse(date));
			dao.save(publication.getTitle() + date, publication);

			publication = new Publication("Science Magazine", 7);
			date = "05-04-2017";
			publication.setDate(format.parse(date));
			dao.save(publication.getTitle() + date, publication);

			publication = new Publication("Science Magazine", 7);
			date = "12-03-2017";
			publication.setDate(format.parse(date));
			dao.save(publication.getTitle() + date, publication);

			publication = new Publication("TIME Magazine", 7);
			date = "12-03-2017";
			publication.setDate(format.parse(date));
			dao.save(publication.getTitle() + date, publication);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void createBooks(DataAccessObject dao) {
		Address address = new Address("1000 N 4th St", "Fairfield", "IA", 52557);

		Author author = new Author("Cay", "Horstmann", address, "+59898830609",
				"Addison-Wesley, 2015 (recommended) Covers Java 8",
				"This guy is awsome");
		dao.save(author.getName() + author.getLastName(), author);
		String isbn = "00124325";
		Book book = new Book("Core Java for the Impatient", isbn, author, 21);
		book.addCopy();
		book.addCopy();
		dao.save(isbn, book);

		isbn = "00254387";
		book = new Book("Core Java Volume I--Fundamentals", isbn, author, 21);
		dao.save(isbn, book);

		isbn = "10295687";
		author = new Author("Jacquie", "Barker", address, "+59898862409", "Apress, 2005", "This guy is awsome");
		book = new Book("Beginning Java Objects: From Concepts to Code", isbn, author, 21);
		book.addCopy();
		book.addCopy();
		dao.save(isbn, book);

		isbn = "123445673";
		author = new Author("Martin", "Fowler", address, "+59898862409", "UML syntax and best practices",
				"This guy is awsome");
		book = new Book("UML Distilled", isbn, author, 21);
		dao.save(isbn, book);
	}

	private static void createUsers(DataAccessObject dao) {
		String password = "123";
		User user = new User("lib", password, Role.LIBRARIAN);
		dao.save("lib", user);

		user = new User("admin", password, Role.ADMINISTRATOR);
		dao.save("admin", user);

		user = new User("super", password, Role.LIBRARIAN_ADMINISTRATOR);
		dao.save("super", user);
	}

}
