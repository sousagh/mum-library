package edu.mum.library.ui.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	@FXML
	public void initialize() {
		SearchTableEntry entry = (SearchTableEntry) AppContext.getParam(AppContext.PUBLICATION);
		PublicationBO periodicBO = (PublicationBO) BusinessObjectFactory.getBusinessObject(PublicationBO.class);

		Publication publication = periodicBO.findById(entry.getId());

		this.namePeriodic.setText(publication.getTitle());
		Date date = publication.getDate();

		this.datePeriodic.setText(new SimpleDateFormat().format(date));
	}

}