
package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
       
        char[][] gameBoard={{' ', '|', ' ','|',' '},
                            {'-', '+', '-', '+', '-'},
                            {' ', '|', ' ','|',' '},
                            {'-', '+', '-', '+', '-'},
                            {' ', '|', ' ','|',' '}};
        printBoard(gameBoard);
       
        while(true){    
            playerMove(gameBoard);
            if(checkWinner(gameBoard))
                break;
            
            cpuMove(gameBoard);
           if(checkWinner(gameBoard))
                break;
        }
    }
    
    public static void printBoard(char[][] gameBoard)
    {
        for(char[] r: gameBoard)
        {
            for(char c: r)
            {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
    public static boolean isValid(char[][] gameBoard,int cpupos)
    {
        switch(cpupos)
        {
            case 1: return(gameBoard[0][0]==' ');
            case 2: return(gameBoard[0][2]==' ');
            case 3: return(gameBoard[0][4]==' ');
            case 4: return(gameBoard[2][0]==' ');
            case 5: return(gameBoard[2][2]==' ');
            case 6: return(gameBoard[2][4]==' ');
            case 7: return(gameBoard[4][0]==' ');
            case 8: return(gameBoard[4][2]==' ');
            case 9: return(gameBoard[4][4]==' ');
            default: return false;
        }      
    }
    public static void placemove(char[][] gameBoard, int pos,String user)
    {
        char symbol=' ';
        if(user.equals("player"))
             symbol='X';
        else if(user.equals("CPU"))
             symbol='O';
         switch(pos)
        {
                case 1: gameBoard[0][0]= symbol;
                    break;
                case 2: gameBoard[0][2]= symbol;
                    break;
                case 3: gameBoard[0][4]= symbol;
                    break;
                case 4: gameBoard[2][0]= symbol;
                    break;
                case 5: gameBoard[2][2]= symbol;
                    break;
                case 6: gameBoard[2][4]= symbol;
                    break;
                case 7: gameBoard[4][0]= symbol;
                    break;
                case 8: gameBoard[4][2]= symbol;
                    break;
                case 9: gameBoard[4][4]= symbol;
                    break;
                default: break;
       }
    }
    
    public static boolean winCondition(char[][] gameBoard,char sym )
    {
        if((gameBoard[0][0]== sym && gameBoard[0][2]== sym && gameBoard[0][4]== sym ) ||
           (gameBoard[2][0]== sym && gameBoard[2][2]== sym && gameBoard[2][4]== sym ) ||
           (gameBoard[4][0]== sym && gameBoard[4][2]== sym && gameBoard[4][4]== sym ) ||
           (gameBoard[0][0]== sym && gameBoard[2][0]== sym && gameBoard[4][0]== sym ) ||
           (gameBoard[0][2]== sym && gameBoard[2][2]== sym && gameBoard[4][2]== sym ) ||
           (gameBoard[0][4]== sym && gameBoard[2][4]== sym && gameBoard[4][4]== sym ) ||
           (gameBoard[0][0]== sym && gameBoard[2][2]== sym && gameBoard[4][4]== sym ) ||
           (gameBoard[0][4]== sym && gameBoard[2][2]== sym && gameBoard[4][0]== sym ) )
          return true;
        else 
          return false;
    }
    
    public static boolean checkWinner(char[][] gameBoard)
    {
        if(winCondition(gameBoard,'X'))
        {
            System.out.println("YOU WON!!"); 
            return true;
        }
        
        if(winCondition(gameBoard,'O'))
        {
            System.out.println("YOU LOST!!"); 
            return true;
        }
        
        for (int i = 0; i < gameBoard.length; i++) {
                for (int j = 0; j < gameBoard[i].length; j++) {
                    if (gameBoard[i][j] == ' ') {
                        return false;
                    }
                }
            }
        System.out.println("ITS A TIE!!");
        return true;
    }

    public static void playerMove(char[][] gameBoard) {
       int pos;
       Scanner s = new Scanner(System.in);
             while(true){
              System.out.print("Your turn! Place a move(1-9): ");
              pos = s.nextInt();
             if(isValid(gameBoard, pos))
                 break;
             else
                 System.out.println("Invalid Move");
            }
        placemove(gameBoard, pos, "player");
        printBoard(gameBoard);
    }

    public static void cpuMove(char[][] gameBoard) {
        Random ran = new Random();
            int cpupos;
            while(true){
            cpupos = ran.nextInt(9) + 1;
            if(isValid(gameBoard, cpupos)){
                System.out.println("CPU choose :"+cpupos);
                break;}
            }
            placemove(gameBoard, cpupos, "CPU");
            printBoard(gameBoard);
    }
}