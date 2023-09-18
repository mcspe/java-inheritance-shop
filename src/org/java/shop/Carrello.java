package org.java.shop;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Carrello {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final DecimalFormat df = new DecimalFormat("0.00");
		
		boolean addProd = true;
		
		Prodotto[] cartProv = new Prodotto[Short.MAX_VALUE];
		int counter = 0;
		
		while(addProd) {
			
			System.out.print("Quale prodotto vuoi aggiungere?"
					+ "\nPremi:"
					+ "\n\t1 per Smartphone"
					+ "\n\t2 per TV"
					+ "\n\t3 per Cuffie ");
			int scelta = Integer.valueOf(sc.nextLine());
			
			System.out.print("\nInserisci la marca: ");
			String marca = sc.nextLine();
			
			System.out.print("\nInserisci il nome: ");
			String nome = sc.nextLine();
			
			System.out.print("\nInserisci il prezzo base: ");
			double prezzo = Double.valueOf(sc.nextLine());
			
			System.out.print("\nInserisci l'aliquota IVA: ");
			int iva = Integer.valueOf(sc.nextLine());
			
			switch(scelta) {
				case 1:
					System.out.print("\nInserisci la quantità di memoria: ");
					int memoria = Integer.valueOf(sc.nextLine());
					cartProv[counter] = new Smartphone(nome, marca, prezzo, iva, memoria);
					break;
				case 2:
					System.out.print("\nInserisci le dimensioni in pollici: ");
					int dimensioni = Integer.valueOf(sc.nextLine());
					System.out.print("\nE' uno SmartTV? Y/N");
					String smartStr = sc.nextLine().toLowerCase();
					boolean smart = (smartStr.equals("y")) ? true : false;
					cartProv[counter] = new Televisore(nome, marca, prezzo, iva, dimensioni, smart);
					break;
				case 3:
					System.out.print("\nInserisci il colore: ");
					String colore = sc.nextLine();
					System.out.println("\nE' wireless? Y/N");
					String wirelessStr = sc.nextLine().toLowerCase();
					boolean wireless = (wirelessStr.equals("y")) ? true : false;
					cartProv[counter] = new Cuffia(nome, marca, prezzo, iva, colore, wireless);
					break;
				default:
					break;
			}
			
			System.out.print("Vuoi aggiungere un altro prodotto? Y/N");
			String end = sc.nextLine().toLowerCase();
			addProd = (end.equals("y")) ? true : false;
			counter += (end.equals("y")) ? 1 : 0;
			
		}
		
		System.out.print("\nHai una tessera fedeltà? Y/N ");
		String fideltyStr = sc.nextLine().toLowerCase();
		boolean fidelty = (fideltyStr.equals("y")) ? true : false;
		
		sc.close();
		
		Prodotto[] cart = new Prodotto[counter + 1];
		double cartTot = 0;
		for (int i = 0; i <= counter; i++) {
			cart[i] = cartProv[i];
			cart[i].setScontato(fidelty);
			System.out.println("\n"
					+ "Item Carrello n."
					+ (i + 1)
					+ "\n"
					+ cart[i]);
			cartTot += (fidelty) ? cart[i].getPrezzoScontato() :  cart[i].getPrezzoConIva();
		}
		cartProv = null;
		
		System.out.println("\nPrezzo totale: " + df.format(cartTot) + "€");
		
		

	}

}
