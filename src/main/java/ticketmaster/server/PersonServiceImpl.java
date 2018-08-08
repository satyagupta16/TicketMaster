package ticketmaster.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import ticketmaster.client.PersonService;
import ticketmaster.shared.FieldVerifier;
import ticketmaster.shared.Person;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PersonServiceImpl extends RemoteServiceServlet implements PersonService {
	private PrintWriter printWriter;

	private static SessionFactory factory;

	static {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public PersonServiceImpl() {
		try {
			FileWriter fileWriter = new FileWriter("C:\\Users\\USER\\eclipse-workspace\\TicketMaster\\Data.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String register(Person person) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidPerson(person)) {
			throw new IllegalArgumentException("Person invalid");
		}

		if (printWriter != null) {
			printWriter.println(person.toString());
			printWriter.flush();
		}

		Session session = factory.openSession();
		Transaction transaction = null;
		Integer personRowId = null;

		try {
			transaction = session.beginTransaction();
			personRowId = (Integer) session.save(person);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println(person.toString() + " saved with RowId " + personRowId);
		return "Person registered";
	}

	@Override
	public String redeem(String id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> report() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
}
