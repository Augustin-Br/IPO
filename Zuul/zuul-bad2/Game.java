 
/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author Brenner Augustin
 */
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    /**
     * Constructeur par défault
     */
    public Game(){
        this.createRooms();
        this.aParser = new Parser();
        //printWelcome();
    }
    
    /**
     * Procédure de création de Room
     */
    private void createRooms(){
        Room vPlace = new Room("In the public place");
        Room vForest = new Room("In the forest");
        Room vClearing = new Room("In the strange clearing");
        Room vBar = new Room("In the bar");
        Room vHotel = new Room("In the hotel");
        Room vMarket = new Room("In the market");
        Room vPort = new Room("In the port");
        Room vCove = new Room("On the cove");
        Room vAgroundBoat = new Room("In the aground boat");
        Room vBeach = new Room("On the beach");
        Room vBedroom = new Room("A classic bedroom with a comfortable bed");
        
        /*
        vPlace.setExits(vForest, vMarket, vBar, vHotel);
        vForest.setExits(null, vPlace, vClearing, null);
        vClearing.setExits(null, null, null, vForest);
        vBar.setExits(null, null, null, vPlace);
        vHotel.setExits(null, null, vPlace, null);
        vMarket.setExits(vPlace, null, vPort, vBeach);
        vPort.setExits(null, null, null, vMarket);
        vCove.setExits(null, vBeach, null, null);
        vAgroundBoat.setExits(vBeach, null, null, null);
        vBeach.setExits(vCove, vAgroundBoat, vMarket, null);
        */
        
        // Sortie de la place
        vPlace.setExits("north", vForest);
        vPlace.setExits("south", vMarket);
        vPlace.setExits("east", vBar);
        vPlace.setExits("west", vHotel);
        
        // Sortie de la foret 
        vForest.setExits("south", vPlace); 
        vForest.setExits("east", vClearing); 
        
        // Sortie de la clairière
        vClearing.setExits("west", vForest);
        
        // Sortie du bar
        vBar.setExits("west", vPlace);
        
        // Sortie de l'hotel
        vHotel.setExits("east", vPlace);
        vHotel.setExits("up", vBedroom);

        // Sortie de la chambre 
        vBedroom.setExits("down", vHotel);
        
        // Sortie du marché
        vMarket.setExits("north", vPlace);
        vMarket.setExits("east", vPort);
        vMarket.setExits("west", vBeach);
        
        // Sortie du port 
        vPort.setExits("west", vMarket);
        
        // Sortie de la crique
        vCove.setExits("south", vBeach);
        
        // Sortie du bateau échoué 
        vAgroundBoat.setExits("north", vBeach);
        
        // Sortie de la plage 
        vBeach.setExits("north", vCove);
        vBeach.setExits("south", vAgroundBoat);
        vBeach.setExits("east", vMarket);
        
        this.aCurrentRoom = vPlace;
    }
    
    /**
     * Procédure qui affiche les informations de la localisation
     */
    private void printLocationInfo(){
        System.out.println("You are " + aCurrentRoom.getDescription());
        /*
        System.out.println("Exits : ");
        if(aCurrentRoom.aNorthExit != null){
            System.out.println("north ");
        }
        if(aCurrentRoom.aSouthExit != null){
            System.out.println("south ");
        }
        if(aCurrentRoom.aEastExit != null){
            System.out.println("east ");
        }
        if(aCurrentRoom.aWestExit != null){
            System.out.println("west ");
        }
        */
       System.out.println(this.aCurrentRoom.getExitString());
    }
    
    /**
     * Procédure qui permet un changement de pièce
     * @param -> pInstruction (Command)
     */
    private void goRoom(final Command pInstruction)
    {
        // Verification que le joueur à bien indiqué une direction
        if (!pInstruction.hasSecondWord()){
            System.out.println("Go where ?");
            return;
        }
        
        Room vNextRoom = null; // définition de la prochaine piece
        String vDirection = pInstruction.getSecondWord(); // la direction indiqué par le joueur
        boolean vUnknowDirection = true; // permet de savoir si le joueur a donné une direcion valide
        String[] vTabDirection = {"north", "south", "east", "west", "up", "down"}; // tableau des directions possibles
        
        // Verification de la commande entré par le joueur
        for (int i = 0; i < vTabDirection.length; i++){
            if (vDirection.equals(vTabDirection[i])){
                vNextRoom = aCurrentRoom.getExit(vDirection);
                vUnknowDirection = false;
            }
        }
        
        // Si la commande ne corresond à aucune direction
        if(vUnknowDirection == true){
            System.out.println("Unknown direction!");
            return;
        }
        // Sinon si il n'y a pas de piece dans la direction indiqué par le joueur
        else if(vNextRoom == null){
            System.out.println("There is no door !");
            return;
        }
 
        this.aCurrentRoom = vNextRoom; // définie la prochaine piece

        printLocationInfo(); // affiche la description de la piece
    }   
    
    private void printWelcome(){
        System.out.println("Welcome to the World of Zuul! \n World of Zuul is a new, incredibly boring adventure game. \n Type 'help' if you need help. \n \n");
        /*String vNorth = "";
        String vSouth = "";
        String vEast = "";
        String vWest = "";
        if (this.aCurrentRoom.aNorthExit != null){
            vNorth = "north ";
        }
        if (this.aCurrentRoom.aSouthExit != null){
            vSouth = "south";
        }
        if (this.aCurrentRoom.aEastExit != null){
            vEast = "east";
        }
        if (this.aCurrentRoom.aWestExit != null){
            vWest = "west";
        }
        System.out.println("You are " + aCurrentRoom.getDescription().toLowerCase() + "\n Exits : " + vNorth + " " + vSouth + " " + vEast + " " + vWest);
        // You are outside the main entrance of the university \n Exits: east south west
        
        */
        printLocationInfo();
    }
    
    private void printHelp(){
        System.out.println("You are lost. You are alone. \n You wander around the island. \n \n Your command words are: \n  go quit help");
    }
    
    private boolean quit(final Command pQuit){
        if (pQuit.hasSecondWord()){
            System.out.println("Quit what?");
            return false;
        }else{
            return true;
        }
    }
    
    private boolean processCommand(final Command pInstruction){
        if(pInstruction.isUnknown()){
            System.out.println("I don't know what you mean...");
            return false;
        }else if(pInstruction.getCommandWord().equals("quit")){
            return quit(pInstruction);
        }else if (pInstruction.getCommandWord().equals("help")){
            printHelp();
            return false;
        }else if(pInstruction.getCommandWord().equals("go")){
            goRoom(pInstruction);
            return false;
        }else{
            System.out.println("I don't know what you mean...");
            return false;
        }
    }
    
    public void play(){
        this.printWelcome();
        boolean vFinished = false;
        while (vFinished == false){
            Command vCommand = aParser.getCommand();
            vFinished = processCommand(vCommand);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
} // Game
