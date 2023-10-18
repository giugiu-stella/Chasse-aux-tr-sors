
/**
 *Classe Equipage, calcule le nombre d'équipages
 */

/**
 * @author Carla Giuliani (Mini-projet du 16/11/2020)
 * 
 */
public class Equipages {
    
    public static int nbrequipages;
    
    /**
     * initialise le nombre d'équipages à 0
     */
    public Equipages(){
        nbrequipages=0;
    }

    /**
     * permet d'incrémenter de 1 le nombre d'équipage
     */
    public static void Incrementer(){
        nbrequipages++;
    }

    /**
     * permet de décrémenter de 1 le nombre d'équipages
     */
    public static void Decrementer(){
        nbrequipages--;
    }


}
