package com.game.library;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    private static final char DEFAULT_SEPARATOR = ',';
    private  String csvFile;

    public WriteFile(String csvFile) {
        this.csvFile = csvFile;
    }

    public void writeGameInFile(List<Game> games) throws IOException {
        FileWriter writer = new FileWriter(csvFile);

        StringBuilder sb = new StringBuilder();
        for (Game game: games) {
            sb.append(game.getName())
                    .append(DEFAULT_SEPARATOR)
                    .append(game.getNrPlayers())
                    .append(DEFAULT_SEPARATOR)
                    .append(game.getDuration())
                    .append(DEFAULT_SEPARATOR)
                    .append(game.getDifficulty())
                    .append("\n");
        }
        writer.append(sb.toString());
        writer.close();
    }
}
