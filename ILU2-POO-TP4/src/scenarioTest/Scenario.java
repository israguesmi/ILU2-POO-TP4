package scenarioTest;

import personnages.Gaulois;
import produit.*;
import village.*;
import villagegaulois.*;
import vilagegauloisold.DepenseMarchand;

public class Scenario {

	public static void main(String[] args) {

		IVillage village = new IVillage() {
			
			lEtal[] marche = new lEtal[100];
			int nombreEtal = 0;
			DepenseMarchand[] depenseMarchand = new DepenseMarchand[100];
			int nombreDepense = 0;
			
			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				if (nombreEtal == 100) return false;
				else {
					etal.installerVendeur(vendeur, produit, prix);
					marche[nombreEtal] = etal;
					nombreEtal ++;
					return true;
				}
			}
			
			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				int nombreProduit = 0;
				int i = 0;
				int produitEtal;	
				double prix;
				while (nombreProduit < 3 && i < nombreEtal) {
					produitEtal = marche[i].contientProduit(produit, quantiteSouhaitee - nombreProduit);
					prix = marche[i].acheterProduit(produitEtal);
					nombreProduit += produitEtal;
					depenseMarchand[nombreDepense] = new DepenseMarchand(marche[i].getVendeur(), produitEtal, produit, prix);
					nombreDepense ++;
					i++;
				}
				return depenseMarchand;
			}
			
			@Override
			public String toString() {
				for (int i = 0; i < nombreEtal; i++) {
					System.out.println(marche[i].etalEtal());
				}
				return super.toString();
			} 
		};

		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}
