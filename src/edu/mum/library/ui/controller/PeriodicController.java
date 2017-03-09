package edu.mum.library.ui.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import edu.mum.library.business.Publication;
import edu.mum.library.business.bo.PublicationBO;
import edu.mum.library.business.bo.impl.BusinessObjectFactory;
import edu.mum.library.ui.util.AppContext;
import edu.mum.library.ui.util.SearchTableEntry;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PeriodicController {

	@FXML
	private Label namePeriodic;

	@FXML
	private Label datePeriodic;

	@FXML
	private Label availability;

	@FXML
	private Button checkoutButton;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM/dd/yyyy");

	@FXML
	public void initialize() {
		SearchTableEntry entry = (SearchTableEntry) AppContext.getParam(AppContext.PUBLICATION);
		PublicationBO periodicBO = (PublicationBO) BusinessObjectFactory.getBusinessObject(PublicationBO.class);

		Publication publication = periodicBO.findById(entry.getId());

		this.namePeriodic.setText(publication.getTitle());
		LocalDate date = publication.getDate();

		this.datePeriodic.setText(this.formatter.format(date));
		this.availability.setText(new Boolean(publication.isAvailable()).toString());

		if (!publication.isAvailable()) {
			this.checkoutButton.setDisable(true);
		} else {
			this.checkoutButton.setDisable(false);
		}
	}

}