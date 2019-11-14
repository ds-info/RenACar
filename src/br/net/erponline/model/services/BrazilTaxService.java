package br.net.erponline.model.services;

public class BrazilTaxService {
	public double tax(double amount) {
		if (amount <= 100) {
			return (amount * 20) / 100;
		} else {
			return (amount * 15) / 100;
		}
	}
}