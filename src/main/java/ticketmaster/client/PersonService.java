package ticketmaster.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import ticketmaster.shared.Person;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("person")
public interface PersonService extends RemoteService {
	String register(Person person) throws IllegalArgumentException;

	String redeem(String id) throws IllegalArgumentException;

	List<Person> report() throws IllegalArgumentException;
}
