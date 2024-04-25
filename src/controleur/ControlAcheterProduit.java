package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;


public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public Gaulois[] controlrechercherVendeursProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	
	
	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	public Etal trouverEtalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public String[] donnerInfosMarche() {
		return village.donnerEtatMarche();
	}
	
	public int acheterProduit(String nomVendeur, int quantiteAcheter) {
		Etal etal = trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(quantiteAcheter);
	}
}
