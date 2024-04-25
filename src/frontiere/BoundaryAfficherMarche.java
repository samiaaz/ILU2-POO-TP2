package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			System.out.println("Le marche est vide, revenez plus tard.");
		} else {
			StringBuilder chaine = new StringBuilder();
			chaine.append(nomAcheteur + " vous trouverez au marche :\n");
			for(int i =0; i < infosMarche.length; i++) {
				String vendeur=infosMarche[i];
				i++;
				String quantite = infosMarche[i];
				i++;
				String produit = infosMarche[i];
				i++;
				chaine.append("- " + vendeur +" qui vend " + quantite + " " + produit + "\n");
				
			}
			System.out.println(chaine.toString()); 
		}
	}
}
