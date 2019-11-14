package br.net.erponline.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.net.erponline.model.entity.CarRental;
import br.net.erponline.model.entity.Vehicle;
import br.net.erponline.model.services.BrazilTaxService;
import br.net.erponline.model.services.RentalService;

public class MainProgram {

	public static void main(String[] args) throws ParseException{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY hh:MM");
		
		System.out.println("Enter rental data");
		
		System.out.print("Car model: ");
		String vehicle = sc.nextLine();
		
		System.out.println();
		System.out.print("Pickup (dd/MM/yyyy hh:MM): ");
		Date start = sdf.parse(sc.nextLine());
		
		System.out.println();
		System.out.print("Return (dd/MM/yyyy hh:MM): ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(vehicle));
		
		System.out.println();
		System.out.print("Price per Hour: ");
		double pricePerHour = sc.nextDouble();
				
		System.out.println();
		System.out.print("Price per Day: ");
		double pricePerDay = sc.nextDouble();

		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rentalService.processInvoice(carRental);
		
		System.out.println(carRental.toString());
	}
}
