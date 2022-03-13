package com.game.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
    private static final String CSV_SPLIT_BY = ",";
    private static String csvFile;

    public ReadFile(String csvFile) {
        this.csvFile = csvFile;
    }

    public static Map<String, Game> readGameFromFile() {

        Map<String, Game> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] gameDetails = line.split(CSV_SPLIT_BY);

                Game game = new Game();
                game.setName(gameDetails[0]);
                game.setNrPlayers(gameDetails[1]);
                game.setDuration((gameDetails[2]));
                game.setDifficulty(gameDetails[3]);

                map.put(game.getName(), game);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
