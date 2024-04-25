package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println(
					"Je suis desolee " + nomAcheteur + " mais il faut etre un habitant de notre village pour commercer ici \n");
		} else {
			System.out.println("Quel produit voulez vous acheter ?");
			String produit = scan.next();
			StringBuilder chaine = new StringBuilder();
			chaine.append("Chez quel commercant voulez vous acheter des " + produit + "\n");
			Gaulois[] listeCommercant = controlAcheterProduit.controlrechercherVendeursProduit(produit);
			if(listeCommercant == null) {
				System.out.println("Desolee, personne ne vend ce produit au marche.\n");
			} else {
				for (int i=0; i < listeCommercant.length ; i++) {
					chaine.append(i+1 +" - " + listeCommercant[i].getNom() +  "\n");
				}
				int choixUtilisateur = Clavier.entrerEntier(chaine.toString());
				String[] infosMarche = controlAcheterProduit.donnerInfosMarche();
				String nomVendeur = infosMarche[(choixUtilisateur-1)*3];
				int quantiteaVendre =  Integer.parseInt( infosMarche[((choixUtilisateur-1)*3)+1]);
				String produitvendeur = infosMarche[((choixUtilisateur-1)*3)+2];
				if(!controlAcheterProduit.verifierIdentite(nomVendeur)) {
					System.out.println(
							"Je suis desolee " + nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici \n");
				} else {
					transaction(nomAcheteur,nomVendeur,quantiteaVendre, produitvendeur);
				}
			
			}
		}
	}
		
	private void transaction(String nomAcheteur,String nomVendeur, int quantiteaVendre, String produitvendeur) {
		StringBuilder chaineproduit = new StringBuilder();
		chaineproduit.append(nomAcheteur + " se deplace jusqua l'etal du vendeur " + nomVendeur + "\n");
		chaineproduit.append("Bonjour " + nomAcheteur + "\n");
		chaineproduit.append("Combien de " + produitvendeur + " voulez vous acheter? \n");
		int nbquantite = Clavier.entrerEntier(chaineproduit.toString());
		if(quantiteaVendre==0) {
			System.out.println(nomAcheteur + " veut acheter " + nbquantite + " " + produitvendeur + ", malheuresement il n'y en a plus ! \n");
		} else if (nbquantite>quantiteaVendre){
			System.out.println(nomAcheteur + " veut acheter " + nbquantite + ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteaVendre + ". " + nomAcheteur + " achete tout le stock de " + nomVendeur + "\n");
			controlAcheterProduit.acheterProduit(nomVendeur, quantiteaVendre);
		} else {
			controlAcheterProduit.acheterProduit(nomVendeur, nbquantite);
			System.out.println(nomAcheteur + " achete " + nbquantite + " " + produitvendeur + " a " + nomVendeur);
		}
	}

			
}
