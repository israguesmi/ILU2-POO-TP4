package produit;

public class Poisson extends Produit {
	
	private String date;
	
	public Poisson(String date) {
		super("poisson", "pièce");
		this.date = date;
	}
	
	public String description() {
		StringBuilder chaine = new StringBuilder();
		chaine.append(super.getNom() + " pêchés " + date + ".");
		return chaine.toString();
	}

}
