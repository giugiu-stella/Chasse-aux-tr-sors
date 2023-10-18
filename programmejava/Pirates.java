
/**
 *Classe Pirates hérité de la classe Agents, créer des agents qui sont des pirates
 */

/**
 * @author Carla Giuliani (Mini-projet du 16/11/2020)
 * 
 */
public class Pirates extends Agents{
    /**
     * initialise le pirate
     *@param nom
     * nom du pirate
     */
    public Pirates(String nom){
        super(nom);
    }

    /**
     * initialise le pirate
     */
    public Pirates(){
        super();
    }
    /**
     * initialise le pirate
     * @param ligne
     * @param colonne
     * coordonnées du pirates 
     */
    public Pirates(int ligne, int colonne){
        super(ligne,colonne);
    }

    /**
     * méthode qui copie le pirate (objet courant) pour créer un nouveau pirate aux mêmes coordonnées
     * @return un pirate
     */
    public Pirates copie(){
        return new Pirates(this.nLigne,this.nColonne);
    }
}
