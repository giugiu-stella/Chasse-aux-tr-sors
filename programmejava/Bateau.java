
/**
 *Classe Pirates hérité de la classe Agents, créer des agents qui sont des pirates
 */

/**
 * @author Carla Giuliani (Mini-projet du 16/11/2020)
 * 
 */
public class Bateau {
    public int bateaunLigne,bateaunColonne;
    public int tresors;
    
    /**
     * initialise le  caractéristiques du bateau
     * @param x
     * correspond à bateauunLigne
     * @param y
     * correspond à bateauunColonne
     */
    public Bateau(int x , int y){
        bateaunLigne=x;
        bateaunColonne=y;
        tresors=0;
    }
    
    
}
