package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		List<TaxPayer> listPayers = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int numberPayers = scan.nextInt();
		
		for (int i=0; i<numberPayers; i++) {
			System.out.println("Tax payer #"+ (i+1) +" data: ");
			System.out.print("Individual or company (i/c)? ");
			char type = scan.next().charAt(0);
			scan.nextLine();
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = scan.nextDouble();
			
			if (type == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = scan.nextDouble();
				listPayers.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else if (type == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = scan.nextInt();
				listPayers.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		
		double sum = 0.0;
		System.out.println("\nTAXES PAID:");
		for (TaxPayer payers : listPayers) {
			System.out.println(payers.toString());
			sum += payers.Tax();
		}
		
		System.out.println("\nTOTAL TAXES: " + String.format("%.2f", sum));
		
		scan.close();

	}

}
