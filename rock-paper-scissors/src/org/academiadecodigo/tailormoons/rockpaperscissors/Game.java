package org.academiadecodigo.tailormoons.rockpaperscissors;

public class Game {

    private final Player player1;
    private final Player player2;
    private HandType guessPlayer1;
    private HandType guessPlayer2;
    boolean gameOver = false;
    private int nrRounds;

    public Game(int nrRounds, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.nrRounds = nrRounds;
    }

    public void start() {
        int countRound = 1;
        System.out.println("Let the games begin! Enter the arena " + player1.getName() + " and " + player2.getName() + ".");

        while (!gameOver) {
            guessPlayer1= player1.showHand();
            guessPlayer2 = player2.showHand();

            System.out.println("Show me your hands! Round " + countRound);

            determineRoundWinner(guessPlayer1, guessPlayer2);
            incrementVictories();
            printMessages();
            countRound++;
            winCondition();

            }

        }


public void printMessages() {

        if (determineRoundWinner(guessPlayer1, guessPlayer2) == Result.TIE) {
            System.out.println("It's a tie! " + guessPlayer1);
        } else if (determineRoundWinner(guessPlayer1, guessPlayer2) == Result.WIN ) {
            System.out.println((guessPlayer1 + "(" + player1.getName() +  ") vs " + guessPlayer2 + " . " + player1.getName() + " is the winner!"));
        } else System.out.println((guessPlayer2 + "(" + player2.getName() + ") vs " + guessPlayer1 + " . " + player2.getName() + " is the winner!"));

}



    public void winCondition() {
        if (player2.getVictories() == nrRounds) {
            System.out.println("Stop the game. " + player2.getName() + " has won! The final score was " + player2.getVictories() + ":" + player1.getVictories() + "!");
            gameOver = true;
        }
        else if (player1.getVictories() == nrRounds) {
            System.out.println("Stop the game. " + player1.getName() + " has won! The final score was " + player1.getVictories() + ":" + player2.getVictories() + "!");
            gameOver = true;
        }
    }

public Result determineRoundWinner(HandType guessPlayer1, HandType guessPlayer2) {

        if(guessPlayer1 == guessPlayer2) {
            return Result.TIE;
        }

        switch(guessPlayer1) {
            case ROCK:
                return ((guessPlayer2 == HandType.SCISSORS || guessPlayer2 == HandType.LIZARD) ? Result.WIN : Result.LOSE);
            case PAPER:
                return ((guessPlayer2 == HandType.ROCK || guessPlayer2 == HandType.SPOCK) ? Result.WIN : Result.LOSE);
            case SCISSORS:
                return (( guessPlayer2 == HandType.PAPER || guessPlayer2 == HandType.LIZARD) ? Result.WIN : Result.LOSE);
            case SPOCK:
                return ((guessPlayer2 == HandType.ROCK || guessPlayer2 == HandType.SCISSORS) ? Result.WIN : Result.LOSE);
            case LIZARD:
                return ((guessPlayer2 == HandType.SPOCK || guessPlayer2 == HandType.PAPER) ? Result.WIN : Result.LOSE);


        }



 return null;
}

public void incrementVictories() {
    if (determineRoundWinner(guessPlayer1, guessPlayer2) == Result.WIN ) player1.incrementVictories();
    else if (determineRoundWinner(guessPlayer1, guessPlayer2) == Result.LOSE ) player2.incrementVictories();
}


}

