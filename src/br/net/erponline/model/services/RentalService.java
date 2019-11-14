package br.net.erponline.model.services;

import br.net.erponline.model.entity.CarRental;
import br.net.erponline.model.entity.Invoice;

public class RentalService {
	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) {
		// pegando as datas em milissegundos
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		
		double hours = ((double) (t2 - t1) /1000 / 60 / 60);
		
		double basicPayment;
		if (hours < 12) {
			basicPayment = Math.ceil(hours) * this.pricePerHour;
		} else {
			basicPayment = Math.ceil(hours / 24) * this.pricePerDay;
		}
		
		double tax = taxService.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment, tax));
		
	}
}