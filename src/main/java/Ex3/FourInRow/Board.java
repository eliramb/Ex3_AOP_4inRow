package Ex3.FourInRow;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class Board implements IBoard {

    public  int ROWS = 6;
    public  int COLUMNS=7;
    // how many discs to win
    public  int WIN = 4;
    // the discs

    public  char EMPTY = ' ';

    public Disc[] Discs;
    public  char[][] board;

    //Ctor
    public Board(){
        board =new char[ROWS][COLUMNS];
        initializeBoard();
    }

    @Override
    public void DecorateBoard() {
    }

    public void initializeBoard() {
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                board[i][j] = EMPTY;
    }

    public void printBoard() {
        System.out.println("Printing board:");
        System.out.println();
        for (int j = 0; j < ROWS; j++) {
            System.out.print("|");
            for (int k = 0; k < COLUMNS; k++)
                System.out.print(board[j][k] + "|");
            System.out.println();
        }
        for (int k = 0; k < 2* COLUMNS+1; k++)
            System.out.print("-");
        System.out.println();
        System.out.println();
    }

    public boolean isColumnFull(int col){
        for (int i = 0; i < ROWS; i++) {
            if (board[i][col] == EMPTY)
                return true;
        }
        return false;
    }
    public int firstEmptyRow(int col)
    {
        for (int i = ROWS-1; i >=0; i--) {
            if (board[i][col] == EMPTY) return i;
        }
        return -1;
    }
    // is the disc at board[rowIndex][colIndex] winning?
    public boolean winningDisk(Position position)
    {
        int rowIndex = position.row;
        int colIndex = position.col;

        char c = board[rowIndex][colIndex];
        int count = 1;

        // horizontal right
        for (int i=colIndex+1; i < COLUMNS; i++) {
            if (board[rowIndex][i]==c)
                count++;
            else break;
        }
        if (count >= WIN) return true; // won horizontally
        // keep counting horizontal left
        for (int i=colIndex-1; i >=0; i--) {
            if (board[rowIndex][i]==c)
                count++;
            else break;
        }

        if (count >= WIN) return true; // won horizontally

        count = 1;
        // vertical down
        for (int i=rowIndex+1; i < ROWS; i++) {
            if (board[i][colIndex]==c)
                count++;
            else break;
        }

        if (count >= WIN) return true; // won vertical
        // keep counting vertical up
        for (int i=rowIndex-1; i >=0; i--) {
            if (board[i][colIndex]==c)
                count++;
            else
                break;
        }

        if (count >= WIN) return true; // won vertical

        // first diagonal:  /
        count = 1;
        // up
        int kol = colIndex+1;
        for (int i=rowIndex-1; i >= 0; i--) {
            if (kol>=COLUMNS) break; // we reached the end of the board right side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol++;
        }

        if (count >= WIN) return true;
        // keep counting down
        kol = colIndex-1;
        for (int i=rowIndex+1; i < ROWS; i++) {
            if (kol<0) break; // we reached the end of the board left side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol--;
        }

        if (count >= WIN) return true; // won diagonal "/"

        // second diagonal : \
        count = 1;
        // up
        kol = colIndex-1;
        for (int i=rowIndex-1; i >= 0; i--) {
            if (kol<0) break; // we reached the end of the board left side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol--;
        }

        if (count >= WIN) return true; // won diagonal "\"
        // keep counting down
        kol = colIndex+1;
        for (int i=rowIndex+1; i < ROWS; i++) {
            if (kol>=COLUMNS) break; // we reached the end of the board right side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol++;
        }

        return count >= WIN; // won diagonal "\"
    }

    public void alignDisc(Position position, DiscType discType)
    {
        board[position.row][position.col] = discType.type;
    }

   // @Override
    public Board getBoard() {
        return this;
    }

    public boolean boardIsFull() {
        // it's enough to check top row
        for (int i=0; i<COLUMNS; i++)
            if (board[0][i]== EMPTY) return false;
        return true;
    }

  //  @Override
    public String toString() {
        var str = "board[ "+  ROWS +" ][ "+COLUMNS+" ]";
        return str;
    }
}
