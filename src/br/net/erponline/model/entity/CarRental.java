package br.net.erponline.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CarRental {
	private Date start;
	private Date finish;
	
	private Vehicle vehicle;
	private Invoice invoice;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:MM");
	
	public CarRental() {

	}

	public CarRental(Date start, Date finish, Vehicle vehicle) {
		super();
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append(String.format("Vehicle: %s\n", this.vehicle.getModel()));
		result.append(String.format("Date Start: %s\n", sdf.format(this.start)));
		result.append(String.format("Date Finish: %s\n", sdf.format(this.finish)));
		result.append(String.format("Basic Payment: %.2f\n",invoice.getBasicPayment()));
		result.append(String.format("Tax Payment: %.2f\n",invoice.getTax()));
		result.append(String.format("Total Payment: %.2f\n",invoice.getTotalPayment()));
		
		return result.toString();
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}