import java.util.Scanner;
import java.lang.Math;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int rock = 0;
    int paper = 1;
    int scissor = 2;
    int totalrounds = 0;
    int player = 0;
    int computermove = 0;
    int newgame = 0;
    int computerscore = 0;
    int playerscore = 0;
    boolean again = true;
    char playagain = '6';
    char playermove = '6';
    
    System.out.println("\nWelcome to Rock Paper Scissors!\n");
    
    while (again) {
      computermove = (int)(Math.random()*3);
      String computer = "";
      if (computermove == 0) {
        computer = "Rock";
      } else if (computermove == 1) {
        computer = "Paper";
      } else if  (computermove == 2) {
        computer = "Scissors";
      } 
  
      while (true) {
        System.out.print("Please select one of R/P/S or Q: ");
        playermove = sc.next().charAt(0);
        playermove = Character.toUpperCase(playermove);
        if (playermove == 'R' || playermove == 'P' || playermove == 'S'
            || playermove == 'Q') {
          break;
        } 
        System.out.println("Invalid input: " + playermove);
      }
      
      if (playermove == 'R') {
        player = 0;
      } else if (playermove == 'P') {
        player = 1;
      } else if (playermove == 'S') {
        player = 2;
      } else if (playermove == 'Q') {
        player = 3;
      } 

      if (player != 3) {
        System.out.println("Computer picked: " + computer);
      }
      
      if (player == 3 || newgame == 4) {
        break;
      } else if (player > 3 || player < 0) {
        System.out.println("invalid");
      } else {
        if (computermove == player) {
          System.out.println("Tie");
        } else if ((computermove == 0 && player == 1) ||
                  (computermove == 1 && player == 2) ||
                  (computermove == 2 && player == 0)) {
          playerscore++;
          System.out.println("You win!");
        } else {
          computerscore++;
          System.out.println("Computer wins!");
        }
        System.out.println("Score: Player " + playerscore + "-" +     
        computerscore + " Computer");
        totalrounds++;
      }
      while (true) {
        System.out.print("Would you like to play again (Y/N)?: ");
        playagain = sc.next().charAt(0);
        playagain = Character.toUpperCase(playagain);
        if (playagain == 'N' || playagain == 'Y') {
          if (playagain == 'N') {
          again = false;
          newgame = 4;
          }
          break;
        }
        System.out.println("Invalid input. Try again.");
      }
      if (again) {
        System.out.println("\nLet's Go Again!!!\n");
      }
    }
    
    System.out.println("\n\t\t\t\t- Final score -");
    System.out.println("----------------------------------------------");
    System.out.print("Total Games: " + totalrounds  );
    System.out.print("\t\tYou - " + playerscore);
    System.out.println("\t\tComputer - " + computerscore);
    
    if (playerscore > computerscore) {
      System.out.println("You win!");
    } else if (playerscore < computerscore) {
      System.out.println("Computer wins!");
    } else {
      System.out.println("Tie Game!");
    }
    sc.close();
  }
}
