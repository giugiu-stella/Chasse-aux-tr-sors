/**
 *Classe Simulation, fait une simulation de pirates récoltants des trésors. 
 */

/**
 * @author Carla Giuliani (Mini-projet du 16/11/2020)
 * 
 */

public class Simulation{
    private Terrain  t= new Terrain(10,10); 
    private Pirates [] tagent;
    private Ressource [] tressource;
    private Equipages nbrEquipages=new Equipages();
  
    /** 
     * initialise le tableau de ressources avec un poids aléatoire (qui équivaut à la quantité) puis place ces resources aléatoirement sur le terrain (ici l'île) et initalise le tableau d'agents.
     * @param m 
     * nombre de ressources, taille du tableau de ressources
     * @param n 
     * nombre d'agents, taille du tableau d'agents
     */
   public Simulation(int m, int n){
       tressource= new Ressource[m];
       for(int i=0; i<tressource.length ;i++){
            int quantite=(int)(Math.random()*21);
            if(quantite!=0){
                tressource[i]= new Ressource("trésor",quantite);
            }
            else{
                while(quantite==0){
                    quantite=(int)(Math.random()*21);
                }
                tressource[i]= new Ressource("trésor",quantite);
            }

       }
       
       for(int j=0;j<tressource.length;j++){
            int x=(int)(Math.random()*9);
            int y=(int)(Math.random()*9);
        if(t.caseEstVide(x,y)==true){
            t.setCase(x,y,tressource[j]);
        }
        else{ 
            while(t.caseEstVide(x,y)!=true){
                x=(int)(Math.random()*9);
                y=(int)(Math.random()*9);
            }
            t.setCase(x,y,tressource[j]);
        }
            
       }
       
       tagent= new Pirates[n];
       for(int k=0; k<tagent.length;k++){
           if((int)(Math.random()%11)==4 && k>0){

                tagent[k]= tagent[k-1].copie();
                
            }
           else{
            tagent[k]= new Pirates();
            
           }
       }
       
      
   }

   /**
    * Accesseur du terrain
    * @return t
    */
   public Terrain getTerrain(){
       return t;
   }
   /**
    * Accesseur du tableau d'agents
    * @return tagent
    */
   public Pirates [] getTagent(){
       return tagent;
   }
   /**
    * Accesseur du tableau de ressources
    * @return tressource
    */
   public Ressource [] getTressource(){
    return tressource;
}
    
   /**
    * 
    * @param pirate
    * agent avec toutes ses caractéristiques  
    * @return les coordonnées du trésor le plus proche
    */
   public Case PlusProcheTresor(Pirates pirate){
       double dist=-1;
       int nblig=0;
       int nbcol=0;
       for(int h=0;h<t.nbColonnes;h++){
           for(int p=0;p<t.nbLignes;p++){
               if((t.caseEstVide(p,h))==false){
                   if(pirate.distance(p,h)<dist||dist==-1){
                       dist=pirate.distance(p,h);
                       nblig=p;
                       nbcol=h;
                   }
               }
           }

        }
       System.out.println("le trésor le plus proche se trouve à la case ("+nblig+","+nbcol+").");
       Case c= new Case(nblig,nbcol);
       return c;

   }
   /**
    * @return renvoit true s'il n'y a plus de trésors sur le terrain sinon false
    */
   public boolean PlusDesTresors(){
       for(int i=0;i<t.nbLignes;i++){
            for(int j=0;j<t.nbColonnes;j++){
                if(t.caseEstVide(i,j)==false){
                    return false;
                }
            }
        }
        return true;
   }
   
   /**
    * Cette méthode permet de récupérer les ressources sur soi et ainsi les retirer du terrain 
    * @param agent
    * agent correspondant à un pirate avec toutes ses caractéristiques
    */
   public void Recolte(Pirates agent){
       if(t.caseEstVide(agent.getnLigne(),agent.getnColonne())==false){
           if((t.getCase(agent.getnLigne(),agent.getnColonne()).getQuantite()>agent.getpoidsPorte())){
               
                t.getCase(agent.getnLigne(),agent.getnColonne()).setQuantite((t.getCase(agent.getnLigne(),agent.getnColonne()).getQuantite())-((agent.getpoidsPorte())));
                
               agent.tresorRecolte= (agent.getpoidsPorte());

           }
           if((t.getCase(agent.getnLigne(),agent.getnColonne()).getQuantite()+agent.tresorRecolte)<=agent.getpoidsPorte()){

               agent.tresorRecolte=(t.getCase(agent.getnLigne(),agent.getnColonne()).getQuantite());

               Ressource r=(t.videCase(agent.getnLigne(),agent.getnColonne()));
           }
        
       }
   }

   
   /**
    * méthode qui permet de déposer les trésors que l'on a sur soi
    * @param pirate
    * @param bateau
    */
   public void DeposeTresor(Pirates pirate, Bateau bateau){
       pirate.bateau.tresors+= pirate.tresorRecolte;

       pirate.tresorRecolte=0;

    }
   
   /**
    * affiche le pourcentage et le nombre de ressources récoltées
    */
   public void Stat(){
       int rest=0;
       int nbrressources=tressource.length;

       for(int o=0;o<t.nbColonnes;o++){
        for(int q=0;q<t.nbLignes;q++){
            if((t.caseEstVide(q,o))==false){
                rest++;
            }
        }
        }
        int recolte= nbrressources-rest;
        double pourcentage = (recolte*1.0/nbrressources*1.0)*100;
        System.out.println(pourcentage+ " % des ressources ont été récolté totalement (plus aucun trésor à cette case) soit "+recolte +" sur "+nbrressources+" ressources sur le terrain");
    }
    /**
     * Cette méthode affiche la quantité de trésor amassé sur son bateau par chaque par chaque pirate 
     * @param tagent
     */
    public void Tresorstotaux(Pirates [] tagent){
        int [] tab=new int[tagent.length];
        int k=0;
        String str="";
        boolean bool=false;
        boolean passe=false;
        for(int i=0;i<tagent.length;i++){
            str=tagent[i].getnom();
            for(int j=i+1;j<tagent.length;j++){
                if(tagent[i].bateau.bateaunLigne== tagent[j].bateau.bateaunLigne && tagent[i].bateau.bateaunColonne== tagent[j].bateau.bateaunColonne){
                    
                    tagent[i].bateau.tresors+=tagent[j].bateau.tresors;
                    
                    str+= ", "+ tagent[j].getnom();
                    tab[k]=j;
                    k++;
                    passe=true;

                }
            }
            for(int l=0;l<k;l++){
                if(tab[l]==i){
                    bool=true;
                }
            }
            if(bool==false){
                nbrEquipages.Incrementer();
                if(passe==true){
                    System.out.println("les pirates "+ str +" ont récolté au total " + tagent[i].bateau.tresors);
                }
                else{
                    System.out.println("le pirate "+ str +" a récolté au total " + tagent[i].bateau.tresors );
                }
            }
            str="";
            bool=false;
            passe=false;
        }
        System.out.println("\n");
        System.out.println("il y a "+nbrEquipages.nbrequipages +" d'équipages sur l'île");
        }
}




