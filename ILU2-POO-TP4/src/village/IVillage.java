package village;

import produit.*;
import villagegaulois.*;
import personnages.*;
import vilagegauloisold.DepenseMarchand;

public interface IVillage {
	
	public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix);
	
	public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee);

}
