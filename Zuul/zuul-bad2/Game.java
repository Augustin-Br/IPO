
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
    }

    /**
     * Procédure qui affiche les informations de la localisation
     */
    private void printLocationInfo(){
        System.out.println("You are " + this.aCurrentRoom.getLongDescription());
    }

    /**
     * Procédure qui permet un changement de pièce
     * @param pInstruction (Command) ->  Commande entré par le joueur
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

    /**
     * Procédure qui affiche le message de bienvenue
     */
    private void printWelcome(){
        System.out.println("Welcome to the World of Zuul! \n World of Zuul is a new, incredibly boring adventure game. \n Type 'help' if you need help. \n \n");
        printLocationInfo();
    }

    /**
     * Procédure qui affiche le message d'aide
     */
    private void printHelp(){
        System.out.println("You are lost. You are alone. \n You wander around the island. \n \n Your command words are: ");
        System.out.println(this.aParser.getCommands());
    }

    /**
     * Procédure qui permet de quitter le jeu
     * @param pQuit (Command) -> Commande entré par le joueur
     * @return -> boolean
     */
    private boolean quit(final Command pQuit){
        if (pQuit.hasSecondWord()){
            System.out.println("Quit what?");
            return false;
        }else{
            return true;
        }
    }

    /**
     * Fonction qui permet de traiter les commandes
     * @param pInstruction (Command) -> Commande entré par le joueur
     * @return -> boolean (true si la commande est "quit" et que le joueur souhaite quitter le jeu)
     */
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
        } else if (pInstruction.getCommandWord().equals("look")) {
            if (pInstruction.hasSecondWord()){
                System.out.println("I don't know how to look at something in particular yet");
            }else {
                look();
            }
            return false;
        }else if (pInstruction.getCommandWord().equals("eat")) {
            if (pInstruction.hasSecondWord()){
                System.out.println("What do you want to eat ?");
            }else {
                eat();
            }
            return false;
        }else{
            System.out.println("I don't know what you mean...");
            return false;
        }
    }

    /**
     * Procédure qui permet de jouer
     */
    public void play(){
        this.printWelcome();
        boolean vFinished = false;
        while (!vFinished){
            Command vCommand = aParser.getCommand();
            vFinished = processCommand(vCommand);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    /**
     * Procédure qui permet d'afficher la description de la pièce
     */
    private void look(){
        System.out.println(this.aCurrentRoom.getLongDescription());
    }

    /**
     * Procédure qui permet au personnage de manger
     */
    private void eat(){
        System.out.println("You have eaten now and you are not hungry any more.");
    }
} // Game
