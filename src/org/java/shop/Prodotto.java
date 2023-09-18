package org.java.shop;

import java.text.DecimalFormat;

public class Prodotto {
	
	protected String codice;
	protected static int contProd = 0;
	private String nome;
	private String marca;
	private double prezzo;
	protected boolean scontato;
	protected int sconto;
	private int iva;
	protected final DecimalFormat df = new DecimalFormat("0.00");
	
	public Prodotto(String nome, String marca, double prezzo, int iva) {
		setCodice();
		setNome(nome);
		setMarca(marca);
		setPrezzo(prezzo);
		setIva(iva);
		setSconto();
	}
	
	protected void setCodice() {
		codice = "Pn_" + String.format("%06d", ++contProd);
	}
	
	protected void setScontato(boolean scontato) {
		this.scontato = scontato;
	}
	
	public String getCodice() {
		return codice;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public double getPrezzoBase() {
		return prezzo;
	}

	public double getPrezzoConIva() {
		double vatAmount = getPrezzoBase() * getIva() / 100;
		return prezzo + vatAmount;
	}
	
	protected void setSconto() {
		sconto = 2;
	}
	
	public double getPrezzoScontato() {
		double base = getPrezzoConIva();
		return base * (100 - sconto) / 100;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}
	
	public int getIva() {
		return iva;
	}
	
	protected String getCat() {
		return "General";
	}
	
	@Override
	public String toString() {
		return "Categoria: " + getCat() + 
				"\nMarca: " + getMarca() + 
				"\nNome: " + getNome() + 
				"\nCodice Prodotto: " + getCodice() + 
				"\nPrezzo base: " + df.format(getPrezzoBase()) + "€" +
				"\nIva: " + getIva() + "%" + 
				"\nPrezzo :" + df.format(getPrezzoConIva()) + "€" +
				((scontato) ? ("\nPrezzo con Tessera Fedeltà : " + df.format(getPrezzoScontato())) : "");
	}
}
