/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.com;

/**
 *
 * @author User
 */
public class Player {
    private int gamesPlayed;
    private int gamesWon;

    public void playedGame() {
        gamesPlayed++;
    }

    public void wonGame() {
        gamesWon++;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

}
