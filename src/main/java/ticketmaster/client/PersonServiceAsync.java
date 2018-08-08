package ticketmaster.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import ticketmaster.shared.Person;

/**
 * The async counterpart of <code>PersonService</code>.
 */
public interface PersonServiceAsync {
	void register(Person person, AsyncCallback<String> callback);

	void redeem(String id, AsyncCallback<String> callback);

	void report(AsyncCallback<List<Person>> callback);
}
