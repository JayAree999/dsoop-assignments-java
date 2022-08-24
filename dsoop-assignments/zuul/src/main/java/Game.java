/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.  Users
 * can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * <p>
 * To play this game, create an instance of this class and call the "play"
 * method.
 * <p>
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game.  It also evaluates and
 * executes the commands that the parser returns.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;


    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room playground, theater, pub, lab, office, dog, cat;
        TransporterRoom transporter;
        RoomRandomizer roomRandomizer;

        // create the rooms
        playground = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        dog = new Room("in a dog house");
        cat = new Room("in a cat house");


        // initialise room exits

        playground.setExit("east", theater);
        playground.setExit("south", lab);
        playground.setExit("west", pub);

        playground.setExit("up", dog);
        playground.setExit("down", cat);

        dog.setExit("down", playground);
        cat.setExit("up", playground);
        theater.setExit("west", playground);

        pub.setExit("east", playground);

        lab.setExit("north", playground);
        lab.setExit("east", office);


        office.setExit("west", lab);
        roomRandomizer = new RoomRandomizer();
        roomRandomizer.addRoom(playground);
        roomRandomizer.addRoom(theater);
        roomRandomizer.addRoom(pub);
        roomRandomizer.addRoom(office);
        roomRandomizer.addRoom(dog);
        roomRandomizer.addRoom(cat);
//
//         create a transporter room
        transporter = new TransporterRoom("in a weird futuristic room filled by a glowing blue light",
                roomRandomizer);
        transporter.setExit("north",lab);
        transporter.setExit("south",roomRandomizer.findRandomRoom());

        lab.setExit("south", transporter);

        currentRoom = playground;  // start game outside
        previousRoom=null;
    }

    /**
     * Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */


    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(printLocationInfo());


    }


//        if (currentRoom.northExit != null) {
//            System.out.print("north ");
//        }
//        if (currentRoom.eastExit != null) {
//            System.out.print("east ");
//        }
//        if (currentRoom.southExit != null) {
//            System.out.print("south ");
//        }
//        if (currentRoom.westExit != null) {
//            System.out.print("west ");
//        }
//        System.out.println();


    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */






    private boolean processCommand(Command command) {
        boolean wantToQuit = false;
        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                command.isUnknown();
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case BACK:
                back(command);
                break;


            case LOOK:
                look(command);
                break;


            case GO:
                goRoom(command);
                break;


            case QUIT:
                wantToQuit = quit(command);
                break;


        }
        return wantToQuit;


//
//        if (command.isUnknown()) {
//            System.out.println("I don't know what you mean...");
//            return false;
//        }
//
//        String commandWord = command.getCommandWord();
//        if (commandWord.equals("help")) {
//            printHelp();
//        } else if (commandWord.equals("go")) {
//            goRoom(command);
//        } else if (commandWord.equals("quit")) {
//            wantToQuit = quit(command);
//        }
//
//        return wantToQuit;
    }


    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help look back");
    }

    /**
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */

    private String printLocationInfo() {

        StringBuilder info = new StringBuilder();
        info.append("You are " + currentRoom.getDescription());
        info.append("\n");
        info.append("Exits: ");

        for (String exit : currentRoom.exits.keySet()) {
            info.append(exit + " ");
        }

        return info.toString();
    }


//                if (currentRoom.northExit != null) {
//                    System.out.print("north ");
//                }
//                if (currentRoom.eastExit != null) {
//                    System.out.print("east ");
//                }
//                if (currentRoom.southExit != null) {
//                    System.out.print("south ");
//                }
//                if (currentRoom.westExit != null) {
//                    System.out.print("west ");
//                }


    private void goRoom(Command command) {

        previousRoom=currentRoom;
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;

        nextRoom = currentRoom.exits.get(direction);

//        if (direction.equals("north")) {
//
//            nextRoom = currentRoom.northExit;
//        }
//        if (direction.equals("east")) {
//            nextRoom = currentRoom.eastExit;
//        }
//        if (direction.equals("south")) {
//            nextRoom = currentRoom.southExit;
//        }
//        if (direction.equals("west")) {
//            nextRoom = currentRoom.westExit;
//        }


        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;

            System.out.println(printLocationInfo());

//            System.out.println("You are " + currentRoom.getDescription());
//            System.out.print("Exits: ");
//            if (currentRoom.northExit != null) {
//                System.out.print("north ");
//            }
//            if (currentRoom.eastExit != null) {
//                System.out.print("east ");
//            }
//            if (currentRoom.southExit != null) {
//                System.out.print("south ");
//            }
//            if (currentRoom.westExit != null) {
//                System.out.print("west ");
//            }
//            System.out.println();
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    private void look(Command command) {

        System.out.println(printLocationInfo());


    }

    private void back(Command command) {

        if (previousRoom==null){
            System.out.println("No way back");
            System.out.println(printLocationInfo());

        }

        currentRoom=previousRoom;
        System.out.println("You are back!");
        System.out.println(printLocationInfo());




    }
}

















