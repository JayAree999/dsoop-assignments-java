/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

import java.util.HashMap;

public class CommandWords {



    private HashMap<String,CommandWord> validCommands;
    // a constant array that holds all valid command words


    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {

        validCommands = new HashMap<String,CommandWord>();

        validCommands.put("go",CommandWord.GO);

        validCommands.put("back",CommandWord.BACK);

        validCommands.put("help",CommandWord.HELP);
        validCommands.put("look",CommandWord.LOOK);


        validCommands.put("quit",CommandWord.QUIT);
        validCommands.put("bye",CommandWord.QUIT);




        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word.
     *
     * @return true if a given string is a valid command,
     * false if it isn't.
     */

    public CommandWord getCommandWord(String commandWord){
        CommandWord command = validCommands.get(commandWord);
        if(command!=null){
            return command;
        }
        else{
            return CommandWord.UNKNOWN;
        }

    }

    public boolean isCommand(String aString) {

        return validCommands.containsKey(aString);
    }
}
