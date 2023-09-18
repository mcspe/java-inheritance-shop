package org.java.shop;

import java.util.Random;

public class Smartphone extends Prodotto {
	
	private long imei;
	private int memoria;
	
	public Smartphone(String nome, String marca, double prezzo, int iva, int memoria) {
		super(nome, marca, prezzo, iva);
		setImei();
		setMemoria(memoria);
	}

	@Override
	protected void setCodice() {
		codice = "Pn_sm_" + String.format("%06d", ++contProd);
	}
	
	public void setImei() {
		Random rnd = new Random();
		imei = rnd.nextLong(1, 999999999999999l);
	}
	
	public String getImei() {
		return String.format("%015d", imei);
	}
	
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	
	public int getMemoria() {
		return memoria;
	}
	
	@Override
	protected void setSconto() {
		sconto = (memoria <= 32) ? 2 : 5;
	}
	
	@Override
	protected String getCat() {
		return "Smartphone";
	}
	
	@Override
	public String toString() {
		return "Categoria: " + getCat() + 
				"\nMarca: " + getMarca() + 
				"\nNome: " + getNome() + 
				"\nCodice Prodotto: " + getCodice() + 
				"\nCodice IMEI: " + getImei() +
				"\nMemoria: " + getMemoria() + "GB" +
				"\nPrezzo base: " + df.format(getPrezzoBase()) + "€" +
				"\nIva: " + getIva() + "%" + 
				"\nPrezzo :" + df.format(getPrezzoConIva()) + "€" +
				((scontato) ? ("\nPrezzo con Tessera Fedeltà : " + df.format(getPrezzoScontato())) : "");
	}
	
}
