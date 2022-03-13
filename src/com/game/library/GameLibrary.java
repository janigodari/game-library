package com.game.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameLibrary {

    private Map<String, Game> games = new HashMap<String, Game>();

    public GameLibrary(){};

    public GameLibrary(Map<String, Game> game) {
        this.games = game;
    }

    public Game getGame(String name){
        return games.get(name);
    }

    public Boolean addGame(Game game){
        Game valid = games.put(game.getName(), game);
        if (valid != null) {
            return true;
        }
        return false;
    }

    public Boolean deleteGame(String name){
        return games.remove(name) != null;
    }

    public Boolean renameGame(String newGameName, String oldGameName){
        if (games.containsKey(oldGameName)) {
            Game game = games.get(oldGameName);
            game.setName(newGameName);

            games.remove(oldGameName);
            games.put(newGameName, game);

            return true;
        } else {
            return false;
        }
    }

    public Boolean checkGameInList(String name){
        return games.containsKey(name);
    }

    public ArrayList<Game> getAllGames(){
        return new ArrayList<Game>(games.values());
    }
}
