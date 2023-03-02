import java.util.HashMap;

public class GameEngine {
    private Room aCurrentRoom;
    private HashMap<String, Room> aRoom;
    private Parser aParser;
    private UserInterface aGui;

    /**
     * Constructeur par défault
     */
    public GameEngine(){
        this.aRoom = new HashMap<String, Room>();
        this.aParser = new Parser();
        this.createRooms();
    }

    /**
     * Procédure qui permet de lancer le jeu
     * @param pUserInterface (UserInterface) -> Interface graphique
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }

    /**
     * Procédure qui affiche le message de bienvenue
     */
    private void printWelcome(){
        this.aGui       .println("Welcome to Objectif Pirate ! \n Type 'help' if you need help. \n \n");
        printLocationInfo();
    }

    /**
     * Procédure qui affiche les informations de la localisation
     */
    private void printLocationInfo(){
        this.aGui.println("You are " + this.aCurrentRoom.getLongDescription());
        if(this.aCurrentRoom.getImageName() != null){
            this.aGui.showImage(this.aCurrentRoom.getImageName());
        }
    }

    /**
     * Procédure de création de Room
     */
    private void createRooms(){
        Room vPlace = new Room("In the public place", "place.png");
        Room vForest = new Room("In the forest", "forest.png");
        Room vClearing = new Room("In the strange clearing", "clearing.png");
        Room vBar = new Room("In the bar", "bar.png");
        Room vHotel = new Room("In the hotel", "hotel.png");
        Room vMarket = new Room("In the market", "market.png");
        Room vPort = new Room("In the port", "port.png");
        Room vCove = new Room("On the cove", "cove.png");
        Room vAgroundBoat = new Room("In the aground boat", "agroundBoat.png");
        Room vBeach = new Room("On the beach", "beach.png");
        Room vBedroom = new Room("A classic bedroom with a comfortable bed", "bedroom.png");

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
        vHotel.setExits("south-east", vMarket);

        // Sortie de la chambre
        vBedroom.setExits("down", vHotel);

        // Sortie du marché
        vMarket.setExits("north", vPlace);
        vMarket.setExits("east", vPort);
        vMarket.setExits("west", vBeach);
        vMarket.setExits("north-west", vHotel);

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

        // Ajout des pièces dans la HashMap
        this.aRoom.put("place", vPlace);
        this.aRoom.put("forest", vForest);
        this.aRoom.put("clearing", vClearing);
        this.aRoom.put("bar", vBar);
        this.aRoom.put("hotel", vHotel);
        this.aRoom.put("market", vMarket);
        this.aRoom.put("port", vPort);
        this.aRoom.put("cove", vCove);
        this.aRoom.put("agroundboat", vAgroundBoat);
        this.aRoom.put("beach", vBeach);
        this.aRoom.put("bedroom", vBedroom);
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand( final String pCommandLine )
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );

        if ( vCommand.isUnknown() ) {
            this.aGui.println( "I don't know what you mean..." );
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord.equals( "help" ) ) {
            this.printHelp();
        }else if ( vCommandWord.equals( "go" ) ) {
            this.goRoom(vCommand);
        }else if ( vCommandWord.equals( "look" ) ) {
            if (vCommand.hasSecondWord()){
                this.aGui.println("I don't know how to look at something in particular yet");
            }else {
                look();
            }
        }else if ( vCommandWord.equals( "eat" ) ) {
            eat();
        }else if ( vCommandWord.equals( "quit" ) ) {
            if ( vCommand.hasSecondWord() ) {
                this.aGui.println("Quit what?");
            }else {
                this.endGame();
            }
        }
    }

    /**
     * Procédure qui permet d'afficher la description de la pièce
     */
    private void look(){
        this.aGui.println(this.aCurrentRoom.getLongDescription());
    }

    /**
     * Procédure qui permet au personnage de manger
     */
    private void eat(){
        this.aGui.println("You have eaten now and you are not hungry any more.");
    }


    /**
     * Procédure qui affiche le message d'aide
     */
    private void printHelp(){
        this.aGui.println("You are lost. You are alone. \n You wander around the island. \n \n Your command words are: ");
        this.aGui.println(this.aParser.getCommandString());
    }

    /**
     * Procédure qui permet un changement de pièce
     * @param pInstruction (Command) ->  Commande entré par le joueur
     */
    private void goRoom(final Command pInstruction)
    {
        // Verification que le joueur à bien indiqué une direction
        if (!pInstruction.hasSecondWord()){
            this.aGui.println("Go where ?");
            return;
        }

        Room vNextRoom = null; // définition de la prochaine piece
        String vDirection = pInstruction.getSecondWord(); // la direction indiqué par le joueur
        boolean vUnknowDirection = true; // permet de savoir si le joueur a donné une direcion valide
        String[] vTabDirection = {"north", "south", "east", "west", "up", "down", "north-west", "south-east", "south-west", "north-east"}; // tableau des directions possibles

        // Verification de la commande entré par le joueur
        for (int i = 0; i < vTabDirection.length; i++){
            if (vDirection.equals(vTabDirection[i])){
                vNextRoom = aCurrentRoom.getExit(vDirection);
                vUnknowDirection = false;
            }
        }

        // Si la commande ne corresond à aucune direction
        if(vUnknowDirection){
            this.aGui.println("Unknown direction!");
            return;
        }
        // Sinon si il n'y a pas de piece dans la direction indiqué par le joueur
        else if(vNextRoom == null){
            this.aGui.println("There is no door !");
            return;
        }

        this.aCurrentRoom = vNextRoom; // définie la prochaine piece

        printLocationInfo(); // affiche la description de la piece
    }

    /**
     * Print out the opening message for the player.
     */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }
}
