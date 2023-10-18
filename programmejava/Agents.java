import java.util.Random;
/**
 * Classe Agents, fait référence aux individus  afin de les déplacer sur un terrain et également de pouvoir calculer une distance 
 */

/**
 * @author Carla Giuliani (Mini-projet du 16/11/2020)
 *
 */

 public class Agents{
     
    protected int nLigne, nColonne;
    protected int niveauEnergie=7;
    protected int poidsPorte;
    public int tresorRecolte;
    protected String nom;
    protected int Trajet;
    public Bateau bateau;
    /** 
     * initialise aléatoirement les coordonnées de l'objet courant au bord de l'île, l'énergie à 7 points, le nombre de trésors récoltés à 0 kg et le poids porté aléatoirement entre 0 et 30 kg 
     */
    public Agents(){
        nLigne=(int)(Math.random()*11);
        if(nLigne!=0){
            nColonne=0;
        }
        else{
            nColonne=(int)(Math.random()*11);
        }
        tresorRecolte=0;
        poidsPorte=(int)(Math.random()*31);
    
        Random rand = new Random();
        String str="";
       for(int i = 0 ; i < 5 ; i++){
            char c = (char)(rand.nextInt(26) + 97);
            str += c;
            
        }
        nom=str;
        bateau = new Bateau(nLigne, nColonne);
        Trajet=0;
    }
    /**
     * 
     * @param nom
     * nom du pirate
     */
    public Agents(String nom){
        nLigne=(int)(Math.random()*11);
        if(nLigne!=0){
            nColonne=0;
        }
        else{
            nColonne=(int)(Math.random()*11);
        }
        tresorRecolte=0;
        poidsPorte=(int)(Math.random()*31);
        this.nom=nom;
        bateau = new Bateau(nLigne, nColonne);
        Trajet=0;
    }
    /**
     * 
     * @param nligne
     * @param ncolonne
     * coordonnées du pirate
     */
    public Agents(int nligne, int ncolonne){
        nLigne=nligne;
        nColonne=ncolonne;
        tresorRecolte=0;
        poidsPorte=(int)(Math.random()*31);
    
        Random rand = new Random();
        String str="";
       for(int i = 0 ; i < 5 ; i++){
            char c = (char)(rand.nextInt(26) + 97);
            str += c;
            
        }
        nom=str;
        bateau = new Bateau(nLigne, nColonne);
        Trajet=0;
    
    } 
    /**
     * 
     * @param nligne
     * @param ncolonne
     * coordonnées du pirates
     * @param nom
     * nom du pirate
     */
    public Agents(int nligne, int ncolonne,String nom){
        nLigne=nligne;
        nColonne=ncolonne;
        tresorRecolte=0;
        poidsPorte=(int)(Math.random()*31);
        this.nom=nom;
        bateau = new Bateau(nLigne, nColonne);
        Trajet=0;
    } 
    /**
     * cette méthode sert à déplacer les agents sur le terrain
	 * @param xnew
     * nouvelle coordonnée nLigne de l'objet courant
     * @param ynew
     * nouvelle coordonnée nColonne de l'objet courant
     
     */
    public void seDeplacer(int xnew,int ynew){
        System.out.println("Le pirate va se déplacer au coordonnées ("+ xnew+","+ynew+")");
        System.out.println("\n");

        if(xnew==nLigne && ynew==nColonne){
            System.out.println("Le pirate est déjà au coordonnées indiquées");
        }

        if(Trajet<7){
            if(xnew>nLigne && ynew==nColonne){
                while(xnew>nLigne && niveauEnergie>0){
                    nLigne++;
                    niveauEnergie--;
                    if(tresorRecolte>(poidsPorte/4)){
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte*(2/4))){
                            niveauEnergie--;
                        }
                    }
                   
                
                }

            }
            if(xnew==nLigne && ynew>nColonne){
                while(ynew>nColonne && niveauEnergie>0){
                    nColonne++;
                    niveauEnergie--;
                    if(tresorRecolte>(poidsPorte/4)){
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte*(2/4))){
                            niveauEnergie--;
                        }
                    }
               
                }

            }
            if(xnew>nLigne && ynew>nColonne){
                if(xnew==ynew && nLigne==nColonne){
                    while(ynew>nColonne && niveauEnergie>0){
                        nColonne++;
                        nLigne++;
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte/4)){
                            niveauEnergie--;
                            if(tresorRecolte>(poidsPorte*(2/4))){
                                niveauEnergie--;
                            }
                        }
                    }
                }
                else{
                    while(ynew>nColonne && niveauEnergie>0){
                        nColonne++;
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte/4)){
                            niveauEnergie--;
                            if(tresorRecolte>(poidsPorte*(2/4))){
                                niveauEnergie--;
                            }
                        }
                   
                    }
                    while(xnew>nLigne && niveauEnergie>0){
                        nLigne++;
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte/4)){
                            niveauEnergie--;
                            if(tresorRecolte>(poidsPorte*(2/4))){
                                niveauEnergie--;
                            }
                        }
                    
                    }
                }
        
            }
        
            if(xnew<nLigne && ynew==nColonne){
                while(xnew<nLigne && niveauEnergie>0){
                    nLigne--;
                    niveauEnergie--;
                    if(tresorRecolte>(poidsPorte/4)){
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte*(2/4))){
                            niveauEnergie--;
                        }
                    }
                  
                }
    
            }
            if(xnew==nLigne && ynew<nColonne){
                while(ynew<nColonne && niveauEnergie>0){
                    nColonne--;
                    niveauEnergie--;
                    if(tresorRecolte>(poidsPorte/4)){
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte*(2/4))){
                            niveauEnergie--;
                        }
                    }
                 
                }
            }
            if(xnew<nLigne && ynew>nColonne){
                while(ynew>nColonne && niveauEnergie>0){
                    nColonne++;
                    niveauEnergie--;
                    if(tresorRecolte>(poidsPorte/4)){
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte*(2/4))){
                            niveauEnergie--;
                        }
                    }
                    
                }
                while(xnew<nLigne && niveauEnergie>0){
                    nLigne--;
                    niveauEnergie--;
                    if(tresorRecolte>(poidsPorte/4)){
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte*(2/4))){
                            niveauEnergie--;
                        }
                    }
                    
                }
            }   
            if(xnew>nLigne && ynew<nColonne){
                while(ynew<nColonne && niveauEnergie>0){
                    nColonne--;
                    niveauEnergie--;
                    if(tresorRecolte>(poidsPorte/4)){
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte*(2/4))){
                            niveauEnergie--;
                        }
                    }
                   
                }
                while(xnew>nLigne && niveauEnergie>0){
                    nLigne++;
                    niveauEnergie--;
                    if(tresorRecolte>(poidsPorte/4)){
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte*(2/4))){
                            niveauEnergie--;
                        }
                    }
                  
                }
            }
         
            if(xnew<nLigne && ynew<nColonne){
                if(xnew==ynew && nLigne==nColonne){
                    while(ynew<nColonne && niveauEnergie>0){
                        nColonne--;
                        nLigne--;
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte/4)){
                            niveauEnergie--;
                            if(tresorRecolte>(poidsPorte*(2/4))){
                                niveauEnergie--;
                            }
                        }
                       
                    }
                }
                else{
                    while(ynew<nColonne && niveauEnergie>0){
                        nColonne--;
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte/4)){
                            niveauEnergie--;
                            if(tresorRecolte>(poidsPorte*(2/4))){
                                niveauEnergie--;
                            }
                        }
                        
                    }
                    while(xnew<nLigne && niveauEnergie>0){
                        nLigne--;
                        niveauEnergie--;
                        if(tresorRecolte>(poidsPorte/4)){
                            niveauEnergie--;
                            if(tresorRecolte>(poidsPorte*(2/4))){
                                niveauEnergie--;
                            }
                        }
                    }
                }
            }
            Trajet++;
            if(niveauEnergie<=0){
                System.out.println("Le pirate est épuisé, il fait une pause à la case ("+nLigne+','+nColonne+')');
                niveauEnergie=7;

            }
        }
    
    
    }
    /** 
     * Accesseur du niveauEnergie
     * @return niveauEnergie
     * 
    */
    public int getniveauEnergie(){
        return niveauEnergie;
    }
    /** 
     * Accesseur de nLigne
     * @return nLigne
     * */
    public int getnLigne(){
        return nLigne;
    }
    /** 
     * Accesseur de nColonne
     * @return nColonne*/
    public int getnColonne(){
        return nColonne;
    }
    /** 
     * Accesseur de poidsPorte
     * @return poidsPorte 
     * */
    public int getpoidsPorte(){
        return poidsPorte;
    }
    
    /** 
     * Accesseur du nom
     * @return nom
     * 
    */
    public String getnom(){
        return nom;
    }
      /**
       * Accesseur du Trajet
       * @return Trajet
       * 
       * */
      public int getTrajet(){
        return Trajet;
    }
    /**
	 * @param x
     * coordonnée nLigne d'un objet
     * @param y
     * coordonnée nColonne d'un objet
     * @return Cette méthode renvoit la distance euclienne entre l'objet courant et la case de coordonnées passées en paramètre
	 */
    public double distance(int x,int y){
        return Math.sqrt((x-nLigne)*(x-nLigne)+(y-nColonne)*(y-nColonne));
    }
    
}