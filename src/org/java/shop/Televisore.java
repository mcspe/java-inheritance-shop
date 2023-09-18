package org.java.shop;

public class Televisore extends Prodotto {
	
	private int dimensioni;
	private boolean smart;
	
	public Televisore(String nome, String marca, double prezzo, int iva, int dimensioni, boolean smart) {
		super(nome, marca, prezzo, iva);
		setDimensioni(dimensioni);
		setSmart(smart);
	}

	@Override
	protected void setCodice() {
		codice = "Pn_tv_" + String.format("%06d", ++contProd);
	}
	
	public void setDimensioni(int dimensioni) {
		this.dimensioni = dimensioni;
	}
	
	public int getDimensioni() {
		return dimensioni;
	}
	
	public void setSmart(boolean smart) {
		this.smart = smart;
	}
	
	public boolean isSmart() {
		return smart;
	}
	
	@Override
	protected void setSconto() {
		sconto = (!smart) ? 2 : 10;
	}
	
	@Override
	protected String getCat() {
		return "TV";
	}
	
	@Override
	public String toString() {
		return "Categoria: " + getCat() + 
				"\nMarca: " + getMarca() + 
				"\nNome: " + getNome() + 
				"\nCodice Prodotto: " + getCodice() + 
				(isSmart() ? "\\nSmartTV " : "") +
				"\nDimensioni: " + getDimensioni() + "\"" +
				"\nPrezzo base: " + df.format(getPrezzoBase()) + "€" +
				"\nIva: " + getIva() + "%" + 
				"\nPrezzo :" + df.format(getPrezzoConIva()) + "€" +
				((scontato) ? ("\nPrezzo con Tessera Fedeltà : " + df.format(getPrezzoScontato())) : "");
	}
	
}
