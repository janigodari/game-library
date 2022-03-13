package com.game.library;

public class Game {

    private String name;
    private String nrPlayers;
    private String duration;
    private String difficulty;

    public Game(){};

    public Game(String name, String nrPlayers, String duration, String difficulty) {
        this.name = name;
        this.nrPlayers = nrPlayers;
        this.duration = duration;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public String getNrPlayers() {
        return nrPlayers;
    }

    public String getDuration() {
        return duration;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNrPlayers(String nrPlayers) {
        this.nrPlayers = nrPlayers;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", nrPlayers='" + nrPlayers + '\'' +
                ", duration='" + duration + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }

}
