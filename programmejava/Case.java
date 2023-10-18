

/**
 *Classe Pirates hérité de la classe Agents, créer des agents qui sont des pirates
 */

/**
 * @author Carla Giuliani (Mini-projet du 16/11/2020)
 * 
 */
public class Case{
    
    private int nombrelignes,nombrecolonnes;

    /**
     * initialise la case avec les valeurs x et y
     * @param x
     * @param y
     */
    public Case(int x,int y){
        this.nombrelignes=x;
        this.nombrecolonnes=y;
    }

    /**
     * Accesseur du nombre de lignes
     * @return nombrelignes
     *
     */
    public int getnombrelignes(){
        return nombrelignes;
    }

    /**
     * Accesseur du nombre de colonnes
     * @return nombrecolonnes
     */
    public int getnombrecolonnes(){
        return nombrecolonnes;
    }
}
