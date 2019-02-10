package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Contribuinte> list = new ArrayList<>();
		double sum = 0.0;

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();

			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExp = sc.nextDouble();
				list.add(new PessoaFisica(name, anualIncome, healthExp));
			} else if (ch == 'c') {
				System.out.print("Number of employees: ");
				Integer numEmp = sc.nextInt();
				list.add(new PessoaJuridica(name, anualIncome, numEmp));
			}

		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		for (Contribuinte c : list) {
			System.out.println(c.getNome() + ": $ " + String.format("%.2f", c.valorImposto()));
			sum += c.valorImposto();
		}

		System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", sum));
		sc.close();
	}

}
