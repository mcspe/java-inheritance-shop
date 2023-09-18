package org.java.shop;

public class Cuffia extends Prodotto {
	
	private String colore;
	private boolean wireless;
	
	public Cuffia(String nome, String marca, double prezzo, int iva, String colore, boolean wireless) {
		super(nome, marca, prezzo, iva);
		setColore(colore);
		setWireless(wireless);
	}
	
	@Override
	protected void setCodice() {
		codice = "Pn_cf_" + String.format("%06d", ++contProd);
	}
	
	public void setColore(String colore) {
		this.colore = colore;
	}
	
	public String getColore() {
		return colore;
	}
	
	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}
	
	public boolean isWireless() {
		return wireless;
	}
	
	@Override
	protected void setSconto() {
		sconto = (wireless) ? 2 : 7;
	}
	
	@Override
	protected String getCat() {
		return "Cuffie";
	}
	
	@Override
	public String toString() {
		return "Categoria: " + getCat() + 
				"\nMarca: " + getMarca() + 
				"\nNome: " + getNome() + 
				"\nCodice Prodotto: " + getCodice() + 
				"\nColore: " + getColore() + "\"" +
				(isWireless() ? "\nWireless" : "\nCablate") +
				"\nPrezzo base: " + df.format(getPrezzoBase()) + "€" +
				"\nIva: " + getIva() + "%" + 
				"\nPrezzo :" + df.format(getPrezzoConIva()) + "€" +
				((scontato) ? ("\nPrezzo con Tessera Fedeltà : " + df.format(getPrezzoScontato())) : "");
	}

}
