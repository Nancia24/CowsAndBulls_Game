 /**
  * CowsAndBulls implements the logic for a cows and bulls guessing game the player has Constants
  * CSC1016S assignment 06
  * @author Nancia Mwaramba
  * @version 22/09/2022
  */
 
public class CowsAndBulls {
   
public final static int NUM_DIGITS = 4;
public final static int MAX_VALUE = 9876;
public final static int MIN_VALUE = 1234;
public final static int MAX_GUESSES = 10;
public static int guesses = 10;
private Result result = new Result(0, 0);
int mystery;

// Constructor
// Create a CowsAndBulls game using the given randomisation seed value to generate
// a mystery number of NUM_DIGITS length, and that gives the player MAX_GUESSES guesses.
public CowsAndBulls(int seed){
    NumberPicker numlist = new NumberPicker(seed, 1, 9);
    int c = 0;
    mystery= numlist.nextInt();
    for (c=0; c<NUM_DIGITS-1; c++){
        mystery = mystery*10 + numlist.nextInt();
    } 
     
}

// Methods
// Obtain the number of guesses remaining.
public int guessesRemaining(){
    return guesses;
}
// Evaluates a guess that the mystery number is guessNumber, returning the outcome in the form
// of a Result object. Decrements guesses remaining.
// Assumes that game is not over.
public Result guess(int guessNumber){
    int bulls = NumberUtils.countMatches(guessNumber, mystery);
    int cows = NumberUtils.countIntersect( guessNumber, mystery) - bulls;
    result = new Result(cows, bulls);
    guesses--;
    return result;
}
// End the game, returning the secretNumber.
public int giveUp(){
    guesses=0;
 return mystery;
}
// Returns true if (i) the secret number has been guessed, or (ii) there are no more guesses.  
public boolean gameOver(){
    return (guesses == 0 | result.isCorrect());

}

}
