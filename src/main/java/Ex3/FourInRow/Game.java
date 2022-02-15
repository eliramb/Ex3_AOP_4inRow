package Ex3.FourInRow;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.Vector;
@Component
public class Game {

    int col;
    int row;

    public static char XPLAYER = 'X';
    public static char OPLAYER = 'O';

    public boolean gameover = false;
    public boolean computerplays;
    public IPlayer currentPlayer;

    //array of two players :  man- man or man-computer
    public Vector<IPlayer> Players;

    //for multiple ui notification which intends to implement "Observer" design pattern
    public GameManager gameManager;

    public Vector<Menu> gameMenu;
    private final Scanner terminalInput ;
    public Game() {
        InitGameMenu();
        Players = new Vector<>();
        gameManager = new GameManager();
        terminalInput = new Scanner(System.in);
    }

    public void AddMenu(Menu menu){
        gameMenu.add(menu);
    }

    //init the game menu
    private void InitGameMenu() {
        String quit ="0. Exit";
        String play_friend = "1. play against friend";
        String play_pc = "2. play against computer";

        Menu m1 = new Menu(quit);
        Menu m2 = new Menu(play_friend);
        Menu m3 = new Menu(play_pc);

        gameMenu = new Vector<>() ;

        AddMenu(m1);
        AddMenu(m2);
        AddMenu(m3);
    }

    public boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private int getChoice() {
        int choice=1;
        boolean badchoice;
        do {
            String sChoice = terminalInput.nextLine();
            if(isInteger(sChoice)) {
                choice = Integer.parseInt(sChoice);
                badchoice = choice < 0 || choice > 2;
            }
            else{
                badchoice=true;
            }
            if (badchoice) System.out.println("Input incorrect! Please try again.");

        }while(badchoice);
        return choice;
    }

    public int userChoice() {

        int choice = getChoice();
        if(choice==0){
            System.out.println("Bye bye!!!");
            terminalInput.close();
            return 0;
        }

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        IBoard board1 = context.getBean(IBoard.class);

        IBoard board = (IBoard) DebugProxy.newInstance(board1);

        board.printBoard();
        Players.clear();

        Player player1 = new Player(OPLAYER,board);//first human player
        Players.add(player1);
        currentPlayer = player1;

        IPlayer player2=null;
        if(choice==1){
            player2 = new Player(XPLAYER,board);//Second human player
        }
        if(choice==2){
            player2 =new ComputerPlayer(XPLAYER, board);
            computerplays = true;
        }
        Players.add(player2);

        return choice;
    }

    //print the menu
    public void printMenu(){
        for (Menu menu : gameMenu) {
            menu.printMenu();
        }
        System.out.print("Please choose an option:");
    }

    //add Player
    public void AddPlayer(IPlayer player){
        Players.add(player);
    }

    public boolean isComputerPlayer(IPlayer player){

        try{
            var p = (ComputerPlayer)player;
            return p!=null;
        }
        catch (Exception ignored){
        }
        return false;
    }

    public static int playerNum (IPlayer player) {
        var asbPlayer = (AbstractPlayer)player;
        if (asbPlayer.discType.type==XPLAYER) return 2; else return 1;
    }

    public boolean play( ) {
        if(currentPlayer == null) return false;
        IBoard iboard=(((AbstractPlayer)currentPlayer).board);
        Board board= iboard.getBoard();
        gameover = false;

        System.out.println("Starting a game of 'Four in a Line'.");
        do {
            // loop as long as the chosen column is full
            // we request the player to enter a column which is not full

            do {
                if (computerplays &&  isComputerPlayer(currentPlayer)) {

                    ComputerPlayer cp = (ComputerPlayer)currentPlayer;
                    Position p = cp.gameLevel.ComputerChoice(cp.board.getBoard());

                    col = p.col;
                    System.out.print("Computer put a disk in column ");
                    System.out.println(col+1);

                } else {
                    System.out.print("Player " + playerNum(currentPlayer) + ", choose a column: ");
                    col = Integer.parseInt(terminalInput.nextLine()); // no exception handling...
                    col--; // the real index

                }

                row = -1;

                // is this really a column number?
                if (col<0 || col>=board.COLUMNS)
                    System.out.println("Illegal column number");
                else
                    // find the row and check if winning
                    if (iboard.isColumnFull(col)) {
                        row = iboard.firstEmptyRow(col);
                        System.out.println();
                    } else
                        // column is full, try again
                        System.out.println("Column is full.");

            } while (row==-1);
            // now we have a valid (row,col) cell
            Position position=new Position(row, col);

            currentPlayer.alignDisc(position);

            // in any case we print the board
            iboard.printBoard();

            if (iboard.winningDisk(position)) {
                gameover = true;
                showWinner(currentPlayer,computerplays);
            } else
            if (board.boardIsFull()) {
                gameover = true;
                showWinner(currentPlayer,computerplays); // tie
            }
            // switch to next player
            changePlayer();

        } while (!gameover);
        return false;
    }

    public void changePlayer() {
        var player = (AbstractPlayer)currentPlayer;

        if(Players.get(0) == currentPlayer){
            currentPlayer = Players.get(1);
        }
        else currentPlayer = Players.get(0);
    }

    public static void showWinner(IPlayer winner,boolean isComp) {
        if (winner == null)
            System.out.print("Board is full! game has ended with a tie!");
        else
        if (isComp && playerNum(winner)==2) System.out.println("Game has ended! The computer won!");
        else System.out.println("Game has ended! Player " + playerNum(winner) + " won!");
        System.out.println();
    }
}