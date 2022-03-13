package com.game.library;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String filename = "src/com/game/library/games.cvs";
    private static WriteFile gameFileWriter;
    private static ReadFile gameFileReader;
    private static GameLibrary gameLibrary;

    public static void main(String[] args) throws IOException{
        gameFileWriter = new WriteFile(filename);
        gameFileReader = new ReadFile(filename);
        gameLibrary = new GameLibrary(gameFileReader.readGameFromFile());
        menuOptions();
        writeGameToDisk();

    }

    private static int menu(){
        System.out.println("Press: \n" +
                "1: Add game to the library\n" +
                "2: Delete a game from the library\n" +
                "3: Search a game\n" +
                "4: Rename a game\n" +
                "5: View all games in the library");
        System.out.print("Write your choice: ");
        return scanner.nextInt();
    }
    private static void menuOptions() throws IOException {
        int selection = menu();
        boolean valid = false;
        while (!valid){
            switch (selection){
                case 1:
                    gameAdd();
                    valid = true;
                    break;
                case 2:
                    gameDelete();
                    valid = true;
                    break;
                case 3:
                    gameSearch();
                    valid = true;
                    break;
                case 4:
                    gameRename();
                    valid = true;
                    break;
                case 5:
                    gameLibrary();
                    valid = true;
                    break;
                default:
                    selection = 0;
                    scanner.nextLine();
                    menu();
                    break;
            }
        }
    }
    public static void gameAdd() throws IOException{
        Game game = new Game();

        System.out.print("Enter game name: ");
        String name = scanner.next();
        game.setName(name);
        scanner.nextLine();

        System.out.print("Enter number of players: ");
        String nrPlayers = scanner.next();
        game.setNrPlayers(nrPlayers);

        System.out.print("Enter game duration (min): ");
        String duration = scanner.next();
        game.setDuration(duration);

        System.out.print("Enter game difficulty: ");
        String difficulty = scanner.next();
        game.setDifficulty(difficulty);

        gameLibrary.addGame(game);

        System.out.println("Game Added");

        writeGameToDisk();
        pressAnyKeyToContinue();
    };
    public static void gameDelete() throws IOException {
        System.out.print("Enter the name of the game you want to delete: ");
        String gameName = scanner.next();
        scanner.nextLine();
        if (!gameLibrary.checkGameInList(gameName)){
            System.out.println("Game not found in the library");
            pressAnyKeyToContinue();
        }else{
            gameLibrary.deleteGame(gameName);
            System.out.println("Game successfully deleted");
            writeGameToDisk();
            pressAnyKeyToContinue();
        }
    };
    public static void gameRename() throws IOException{
        System.out.print("Enter the game name: ");
        String gameName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter the new game name: ");
        String gameNewName = scanner.next();
        if (!gameLibrary.checkGameInList(gameName)){
            System.out.println("Game not found");
            pressAnyKeyToContinue();
        }else{
            gameLibrary.renameGame(gameName, gameNewName);
            System.out.println("Game renamed successfully");
            writeGameToDisk();
            pressAnyKeyToContinue();
        }
    };
    public static void gameLibrary(){
        System.out.println("\n\n");
        System.out.println("NAME"+ " | " + "NR. PLAYERS" + " | " + "DURATION" + " | " + "DIFFICULTY" + " \r");
        gameLibrary.getAllGames().forEach(game -> {
            System.out.println(game.getName()+ " " + game.getNrPlayers()
                    + "  " + game.getDuration()+ "min "  + "   " + game.getDifficulty());
        });
        pressAnyKeyToContinue();
    };
    public static void gameSearch(){
        System.out.print("Enter game name: ");
        String gameName = scanner.next();
        if (gameLibrary.checkGameInList(gameName)){
            System.out.println("Game is in file");
            Game gameSearch = gameLibrary.getGame(gameName);
            System.out.println(gameSearch.getName() + " " +
                    gameSearch.getNrPlayers() + " players " +
                    gameSearch.getDuration() + " min " +
                    gameSearch.getDifficulty());
        }else{
            System.out.println("Game is not in file");
        }
        pressAnyKeyToContinue();
    };
    public static void writeGameToDisk() throws IOException {
        gameFileWriter.writeGameInFile(gameLibrary.getAllGames());
    };
    public static void pressAnyKeyToContinue(){
        System.out.println("Press the Enter key to go to menu...");
        try{
            System.in.read();
            menuOptions();
        }catch(Exception e){

        }
    };


}
