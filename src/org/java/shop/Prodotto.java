package org.java.shop;

public class Prodotto {
	
	private String codice;
	private static int contProd = 0;
	private String nome;
	private String marca;
	private double prezzo;
	private int iva;
	
	public Prodotto(String nome, String marca, double prezzo, int iva) {
		setCodice();
		setNome(nome);
		setMarca(marca);
		setPrezzo(prezzo);
		setIva(iva);
	}
	
	private void setCodice() {
		codice = "Pn_" + String.format("%06d", ++contProd);
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
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setIva(int iva) {
		this.iva = iva;
	}
	
	public int getIva() {
		return iva;
	}
	
	public double getPrezzoConIva() {
		double vatAmount = Math.round(prezzo * iva / 100);
		return prezzo + vatAmount;
	}

}
