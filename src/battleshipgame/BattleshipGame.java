
package battleshipgame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class BattleshipGame {

    static String [][] board;
    static String [][] displayBoard;
    static String [] scoreboard;
    static Random rand = new Random();
    static Scanner input = new Scanner(System.in);
    static int ship1Xaxis;
    static int ship1Yaxis;
    static int ship3Xaxis;
    static int ship2Yaxis;
    static int ship5Yaxis;
    static int score;
    public static final String redBackground = "\u001B[41m";
    public static final String reset = "\u001B[0m";
    public static final String purpleBackground = "\u001B[45m";
    public static final String blueBackground = "\u001B[44m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String boldWhite = "\033[1;37m";
    public static final String greenBackground = "\u001B[42m";
    public static void setUpBoard(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j< 10; j++){
                board[i][j] = "[ ]";
            } 
        }
    }
     public static void setUpDisplayBoard(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j< 10; j++){
                displayBoard[i][j] = "[ ]";
            }
        }
    }
     
    public static void setUpShips(){
        boolean doesItFit = false;
        int ship1Yaxis = rand.nextInt(6);
        int ship1Xaxis = rand.nextInt(10);
        for (int i = 0; i < 5; i++) {
            board[ship1Yaxis+i][ship1Xaxis] = "[0]";
        }


        while(doesItFit == false){
            int ship2Yaxis = rand.nextInt(10);
            int ship2Xaxis = rand.nextInt(5);
            
            if(board[ship2Yaxis][ship2Xaxis].equals("[0]")||board[ship2Yaxis][ship2Xaxis+1].equals("[0]")||board[ship2Yaxis][ship2Xaxis+2].equals("[0]")||board[ship2Yaxis][ship2Xaxis+3].equals("[0]")||board[ship2Yaxis][ship2Xaxis+4].equals("[0]")||board[ship2Yaxis][ship2Xaxis+5].equals("[0]")){
                
            }else{
                doesItFit = true;
                for (int i = 0; i < 6; i++) {
                    board[ship2Yaxis][ship2Xaxis+i] = "[0]";
                }
            }
        }
        doesItFit = false;
        while(doesItFit == false){
            int ship3Yaxis = rand.nextInt(7);
            int ship3Xaxis = rand.nextInt(10);
            
            if(board[ship3Yaxis][ship3Xaxis].equals("[0]")||board[ship3Yaxis+1][ship3Xaxis].equals("[0]")||board[ship3Yaxis+2][ship3Xaxis].equals("[0]")||board[ship3Yaxis+3][ship3Xaxis].equals("[0]")||ship1Xaxis == ship3Xaxis){
                
            }else{
                doesItFit = true;
                for (int i = 0; i < 4; i++) {
                    board[ship3Yaxis+i][ship3Xaxis] = "[0]";
                }
            }
        }
        doesItFit = false;
        while(doesItFit == false){
            int ship4Yaxis = rand.nextInt(8);
            int ship4Xaxis = rand.nextInt(10);
            
            if(board[ship4Yaxis][ship4Xaxis].equals("[0]")||board[ship4Yaxis+1][ship4Xaxis].equals("[0]")||board[ship4Yaxis+2][ship4Xaxis].equals("[0]")||ship1Xaxis == ship3Xaxis||ship4Xaxis == ship3Xaxis){
                
            }else{
                doesItFit = true;
                for (int i = 0; i < 3; i++) {
                    board[ship4Yaxis+i][ship4Xaxis] = "[0]";
                }
            }
        }
        doesItFit = false;
        while(doesItFit == false){
            int ship5Yaxis = rand.nextInt(10);
            int ship5Xaxis = rand.nextInt(7);
            
            if(board[ship5Yaxis][ship5Xaxis].equals("[0]")||board[ship5Yaxis][ship5Xaxis+1].equals("[0]")||board[ship5Yaxis][ship5Xaxis+2].equals("[0]")||board[ship5Yaxis][ship5Xaxis+3].equals("[0]")||ship5Yaxis == ship2Yaxis){
                
            }else{
                doesItFit = true;
                for (int i = 0; i < 4; i++) {
                    board[ship5Yaxis][ship5Xaxis+i] = "[0]";
                }
            }
        }
        doesItFit = false;
        while(doesItFit == false){
            int ship6Yaxis = rand.nextInt(10);
            int ship6Xaxis = rand.nextInt(9);
            
            if(board[ship6Yaxis][ship6Xaxis].equals("[0]")||board[ship6Yaxis][ship6Xaxis+1].equals("[0]")|ship6Yaxis == ship2Yaxis||ship6Yaxis == ship5Yaxis){
                
            }else{
                doesItFit = true;
                for (int i = 0; i < 2; i++) {
                    board[ship6Yaxis][ship6Xaxis+i] = "[0]";
                }
            }
        }
    }
    
    public static void board(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j<10 ; j++){
                
                System.out.print(board[i][j]);
            }
            System.out.println(""); 
        }
    }
    public static void displayBoard(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j<10 ; j++){
                if(displayBoard[i][j].equals("[ ]")){
                    System.out.print(blueBackground+boldWhite+displayBoard[i][j]+reset);
            
                }
                else{
                    System.out.print(purpleBackground+boldWhite+displayBoard[i][j]+reset);
                }
            
            }
                System.out.println(""); 
        }
    }
    
    public static void play(){
        int lives = 15;
        score = 0;
        while(lives>0){
            System.out.println("You have "+lives+" lives left, good luck!");
            try{
                System.out.print("X coordinate: ");
                int xGuess = Integer.parseInt(input.nextLine());
                System.out.print("Y coordinate: ");
                int yGuess = Integer.parseInt(input.nextLine());;
                if(board[yGuess-1][xGuess-1].equals("[0]")){
                    System.out.println("Well done you are correct");
                    displayBoard[yGuess-1][xGuess-1] = "[0]";                   
                    displayBoard();
                    score = score + 1;
                }    
                else{
                    System.out.println("You are wrong");
                    lives = lives - 1;
                    
                }
            }
            catch(Exception e){
                System.out.println("Please input coordinates as a number and between 1-10 inclusively");
            }
            if (score == 24){
                System.out.println("CONGRATULATIONS, YOU HAVE WON!");
                break;
            }
        }
    }
    
    public static void endBoard(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j<10 ; j++){
                if(displayBoard[i][j].equals(board[i][j])){
                    if(displayBoard[i][j].equals("[ ]")){
                        System.out.print(blueBackground+boldWhite+displayBoard[i][j]+reset);
                    }
                    else{
                        System.out.print(purpleBackground+boldWhite+displayBoard[i][j]+reset);
                    }
                }
                else{
                    System.out.print(redBackground+boldWhite+"[0]"+reset);
                }
            }
            System.out.println(""); 
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to battleships, there will be 5 ships on a 10x10 grid. Try your best to guess them.");
        board = new String [10][10];
        displayBoard = new String [10][10];
        scoreboard = new String[10];        
        int games = 0;
        boolean again = false;
        
        while(again == false){
            setUpBoard();
            setUpShips();
            setUpDisplayBoard();
            displayBoard();
            
            System.out.print("What is your name?: ");
            String name = input.next();
            
            play();
            
            games = games + 1;
            
            if(score != 24){
                System.out.println("You have lost with a score of: "+score+", better luck next time!");
                System.out.println("The remaining ships:");
                endBoard();
            }
            scoreboard[games-1] = name+" "+score ;
            System.out.println("Scoreboard:");
            for (int i = 0; i < 10; i++) {
                if(scoreboard[i]!=null){
                    System.out.println(scoreboard[i]);
                }
            }
            System.out.print("Would you like to play again?(yes/no): ");
            try{
                if(input.next().equals("no")){
                    System.out.println("Thanks for playing!");
                    again = true;
                }
            }
            catch(Exception e){
                System.out.println("Please type either yes or no.");
            }
        }
        
    }
    
}
