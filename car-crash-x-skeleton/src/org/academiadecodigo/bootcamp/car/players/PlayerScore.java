package org.academiadecodigo.bootcamp.car.players;

import org.academiadecodigo.bootcamp.car.players.playerOne.PlayerOne;
import org.academiadecodigo.bootcamp.car.players.playerTwo.PlayerTwo;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class PlayerScore {

    private Grid grid;
    private PlayerOne playerOne;
    private PlayerTwo playerTwo;
    private int playerOneScore;
    private int playerTwoScore;
    Text playerOneScoreText;
    Text playerTwoScoreText;


    public PlayerScore(Grid grid, PlayerOne playerOne, PlayerTwo playerTwo) {
        this.grid = grid;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }


    public void createPlayerScoreText() {
        playerOneScoreText = new Text(SimpleGfxGrid.getX(), 0, "Player one score: " + 0);
        playerTwoScoreText = new Text(75 * SimpleGfxGrid.getCellSize(), 0, "Player two score: " + 0);
    }

    public void updatePlayerScoreText() {
        playerOneScoreText.delete();
        playerTwoScoreText.delete();
        playerOneScoreText = new Text(75 * SimpleGfxGrid.getCellSize(), 0, "Player two score: " + playerOneScore);
        playerTwoScoreText = new Text(75 * SimpleGfxGrid.getCellSize(), 0, "Player two score: " + playerTwoScore);
    }

    public void updatePlayerScore() {
        playerOneScore = playerOne.getTakeDowns();
        playerTwoScore = playerTwo.getTakeDowns();
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }
}
