package produit;

import personnages.Gaulois;

public class Sanglier extends Produit{
	
	private Gaulois chasseur;
	private int poids;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", "kg");
		this.chasseur = chasseur;
		this.poids = poids;
	}
	
	public String description() {
		StringBuilder chaine = new StringBuilder();
		chaine.append(super.getNom() + " de " + poids + " " + super.getUnite() + " chassé par " + chasseur + ".");
		return chaine.toString();
	}
	
	@Override
	public int calculerPrix(int prix) {
		return (prix * poids) / 1000;
	}

}
