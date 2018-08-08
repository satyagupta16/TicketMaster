package ticketmaster.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import ticketmaster.shared.Person;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TicketMaster implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Person service.
	 */
	private final PersonServiceAsync personService = GWT.create(PersonService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Label lblName = new Label("Name");
		lblName.setWidth("50px");
		TextBox txtName = new TextBox();

		HorizontalPanel hPanelName = new HorizontalPanel();
		hPanelName.setSpacing(30);
		hPanelName.add(lblName);
		hPanelName.add(txtName);

		Label lblId = new Label("ID");
		lblId.setWidth("50px");
		TextBox txtId = new TextBox();

		HorizontalPanel hPanelID = new HorizontalPanel();
		hPanelID.setSpacing(30);
		hPanelID.add(lblId);
		hPanelID.add(txtId);

		Label lblAddress = new Label("Address");
		lblAddress.setWidth("50px");
		TextBox txtAddress = new TextBox();

		HorizontalPanel hPanelAddress = new HorizontalPanel();
		hPanelAddress.setSpacing(30);
		hPanelAddress.add(lblAddress);
		hPanelAddress.add(txtAddress);

		Label lblPhone = new Label("Phone");
		lblPhone.setWidth("50px");
		TextBox txtPhone = new TextBox();

		HorizontalPanel hPanelPhone = new HorizontalPanel();
		hPanelPhone.setSpacing(30);
		hPanelPhone.add(lblPhone);
		hPanelPhone.add(txtPhone);

		Label lblType = new Label("Type");
		lblType.setWidth("50px");
		TextBox txtType = new TextBox();

		HorizontalPanel hPanelType = new HorizontalPanel();
		hPanelType.setSpacing(30);
		hPanelType.add(lblType);
		hPanelType.add(txtType);

		PushButton btnRegister = new PushButton("Register");
		btnRegister.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Person person = new Person();
				person.setName(txtName.getText());
				person.setId(txtId.getText());
				person.setAddress(txtAddress.getText());
				person.setPhone(txtPhone.getText());
				person.setType(txtType.getText());

				personService.register(person, new AsyncCallback<String>() {
					@Override
					public void onSuccess(String result) {
						Window.alert("Saved " + person.toString());
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Error " + caught.getMessage());
					}
				});
			}
		});

		VerticalPanel vPanelReg = new VerticalPanel();
		vPanelReg.add(hPanelName);
		vPanelReg.add(hPanelID);
		vPanelReg.add(hPanelAddress);
		vPanelReg.add(hPanelPhone);
		vPanelReg.add(hPanelType);
		vPanelReg.add(btnRegister);

		Label lblRegId = new Label("Reg ID");
		lblRegId.setWidth("50px");
		TextBox txtRegId = new TextBox();

		HorizontalPanel hPanelRegID = new HorizontalPanel();
		hPanelRegID.setSpacing(30);
		hPanelRegID.add(lblRegId);
		hPanelRegID.add(txtRegId);

		PushButton btnRedeem = new PushButton("Redeem");
		btnRedeem.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Redeem clicked!");
			}
		});

		VerticalPanel vPanelRedeem = new VerticalPanel();
		vPanelRedeem.add(hPanelRegID);
		vPanelRedeem.add(btnRedeem);

		TabLayoutPanel tabLayoutPanel = new TabLayoutPanel(3.0, Unit.EM);
		tabLayoutPanel.add(vPanelReg, "Registration");
		tabLayoutPanel.add(vPanelRedeem, "Redemption");
		tabLayoutPanel.add(new HTML("Work in progress .."), "Report");
		tabLayoutPanel.setSize("800px", "600px");

		RootPanel.get("gwtContainer").add(tabLayoutPanel);
	}
}
