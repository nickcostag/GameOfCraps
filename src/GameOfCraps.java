
import java.util.Random;
import java.util.Scanner;

public class GameOfCraps {

    public static void main(String[] args) {
        int wager;
        int human_winnings = 0;
        int computer_winnings = 0;
        int num_games_to_play;
        
        final int MAX_WAGER = 100;
        Dice dice;

        num_games_to_play = promptForNumGames();
        for(int i = 1; i <= num_games_to_play; i++){

            // HUMAN'S ROUND
            System.out.println("Round: " + i + ". Your turn.");
            wager = getHumansWager(MAX_WAGER);
            dice = new Dice();
            playRound(dice);

            if(dice.getState() instanceof Win)
                human_winnings = human_winnings + wager;
            else
                human_winnings = human_winnings - wager;
            
            System.out.println("Human winnings are " + human_winnings + "\n");
            
            // COMPUTER'S ROUND
            System.out.println("Round: " + i + ". Computer's turn.");
            wager = randomly_generate(MAX_WAGER);
            System.out.println("The computer bets " + wager);
            dice = new Dice();
            playRound(dice);

            if(dice.getState() instanceof Win)
                computer_winnings = computer_winnings + wager;
            else
                computer_winnings = computer_winnings - wager;
            
            System.out.println("Computer winnings are " + computer_winnings + "\n");
        }
        
        System.out.println("Thanks for playing! Human winnings were " + human_winnings + ".\n"
                + "Computer winnings were " + computer_winnings);
    } 
        
    public static int promptForNumGames(){
        Scanner cin = new Scanner(System.in);
        int games;
        System.out.println("How many rounds would you like to play? ");
        games = cin.nextInt();
        return games;
    }

    public static int getHumansWager(int max_wager){  
        Scanner cin = new Scanner(System.in);
        int wager;
        System.out.println("Enter your wager, between 1 and: " + max_wager);
        wager = cin.nextInt();
        while(wager < 1 || wager > 100){
            System.out.println("Too high or low a bet. Enter your wager, between 1 and: " + max_wager);
            wager = cin.nextInt();    
        }
        return wager;
    }
    // prompts for and returns wager between 1 and max_wager dollars

    public static int randomly_generate(int max){  
        Random rand = new Random();
        int compWager = rand.nextInt(max) + 1;
        return compWager;
    }
    // generates random integer between 1 and max

    public static void playRound(Dice dice){
    // play until win or loss occurs
        while(!(dice.getState() instanceof Win) && !(dice.getState() instanceof Loss))
            dice.rollDice();
    }
}


