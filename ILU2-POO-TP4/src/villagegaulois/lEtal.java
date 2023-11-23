package villagegaulois;

import personnages.Gaulois;

public interface lEtal {
	
	Gaulois getVendeur();
	double donnerPrix();
	int contientProduit(String Produit, int quantiteSouhaitee);
	double acheterProduit(int quantiteSouhaitee);
	String etalEtal();

}
