
public class TestSimulation{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        
        System.out.println("\n");

        // création de notre simulation
        Simulation s= new Simulation(20,15); 
        
        System.out.println("\n");
        
        //affichage du terrain avant l'arrivée des pirates
        s.getTerrain().affiche();

        Pirates [] agents=s.getTagent();
        Ressource [] ressources=s.getTressource();

        // affichage des ressources et de leur position 
        for(int j=0;j<ressources.length;j++){
            System.out.println(ressources[j].toString());

        }
        System.out.println("\n");
        System.out.println("\n");

        //affichage des noms des pirates avec le poids maximum pouvant être porté
        for(int k=0;k<agents.length;k++){
            System.out.println("le pirate "+agents[k].getnom()+ " peut porter maximum "+agents[k].getpoidsPorte()+ " kilos de trésors.");

        }

        //simulaion des déplacement avec récoltes de trésors et retour au bateau

        int cpt=0;

        while(cpt<agents.length){
            cpt=0;
           
            for(int i=0; i<agents.length;i++){
               
                if((agents[i].getTrajet())<7){

                    System.out.println("\n");
                    System.out.println("\n");

                    System.out.println("C'est moi le pirate : "+agents[i].getnom());
                    
                    System.out.println("\n");
                   
                    System.out.println("avant son trajet le pirate est aux coordonnées ("+ agents[i].getnLigne()+ ", "+ agents[i].getnColonne()+")");
                
                    //si le pirate a trouvé un trésor, il s'empresse de le ramener à son bateau

                    if(agents[i].tresorRecolte!=0){
                        System.out.println("le pirate retourne au bateau");
                        agents[i].seDeplacer(agents[i].bateau.bateaunLigne,agents[i].bateau.bateaunColonne);
                    }
                    
                    // sinon il continue ses recherches
                    else{
                        Case c=s.PlusProcheTresor(agents[i]);
                        agents[i].seDeplacer(c.getnombrelignes(),c.getnombrecolonnes());
                        s.Recolte(agents[i]);
                    }
        
                    System.out.println("le pirate après son trajet est aux coordonnées ("+agents[i].getnLigne()+","+agents[i].getnColonne()+") et il lui reste "+ agents[i].getniveauEnergie()+ " points d'énergie");
                
                    
                    // s'il est arrivé à son bateau il dépose tous les trésors 

                    if(agents[i].tresorRecolte!=0 && (agents[i].getnLigne()==agents[i].bateau.bateaunLigne && agents[i].getnColonne() ==agents[i].bateau.bateaunColonne)){
                
                        s.DeposeTresor(agents[i], agents[i].bateau);
                    }

                    System.out.println("nbr de trésors sur le pirate : "+ agents[i].tresorRecolte );
                    System.out.println("nbr de trésors dans son bateau: "+ agents[i].bateau.tresors);
                }
                else{
                    cpt++;
                }
            }
        }

        System.out.println("\n");
        System.out.println("\n");

        // affichage des satistiques
        s.Stat();

        System.out.println("\n");
        System.out.println("\n");

        // affichage des trésors récoltés par les pirates
        s.Tresorstotaux(agents);

        System.out.println("\n");
        System.out.println("\n");

        // affichage des trajets finaux des pirates

        for(int h=0;h<agents.length;h++){
            System.out.println("nbr de trajets finaux: "+agents[h].getTrajet());
        }   
        
        // affichage du terrain après le passage des pirates
        s.getTerrain().affiche();
    }
}

