package scenarioTest;

import produit.*;
import villagegaulois.*;
import personnages.*;

public class ScenarioTest {
	public static void main(String[] args) {
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
		Gaulois obelix = new Gaulois("Obélix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		Etal[] marche = new Etal[3];
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();
		
		marche[0] = etalSanglier1;
		marche[1] = etalSanglier2;
		marche[2] = etalPoisson;
		
		etalSanglier1.installerVendeur(obelix, sangliersObelix, 8);
		etalSanglier2.installerVendeur(asterix, sangliersAsterix, 10);
		etalPoisson.installerVendeur(ordralfabetix, poissons, 7);
		
		System.out.println(etalSanglier2.etalEtal());
		System.out.println(etalSanglier1.etalEtal());
		System.out.println(etalPoisson.etalEtal());
		
		int nombreSanglierVoulu = 3;
		int nombreSanglier = 0;
		int i = 0;
		int sanglierEtal;	
		while (nombreSanglier < 3 && i < marche.length) {
			sanglierEtal = marche[i].contientProduit("sanglier", nombreSanglierVoulu - nombreSanglier);
			System.out.println("A l'etal " + i + " je paye " + marche[i].acheterProduit(sanglierEtal) + " sous.");
			nombreSanglier += sanglierEtal;
			i ++;
		}
		
		System.out.println("Je voulais " + nombreSanglierVoulu + " sangliers, j'en ai acheté " + nombreSanglier + "\n");
		
		System.out.println(etalSanglier2.etalEtal());
		System.out.println(etalSanglier1.etalEtal());
		System.out.println(etalPoisson.etalEtal());
		
	}
	
}
