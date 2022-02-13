package Ex3.FourInRow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;
    private int col;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        board= new Board();
        col =1;
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        board = null;
    }

    @Test
    public void winNum()
    {
        assertEquals(board.WIN,4);
    }

    @Test
    public void rowsNum()
    {
        assertEquals(board.ROWS,6);
    }

    @Test
    public void columnsNum()
    {
        assertEquals(board.COLUMNS,7);
    }

    @org.junit.jupiter.api.Test
    void initializeBoard() {
        board.initializeBoard();
        Board testBoard = new Board();
        for (int i = 0; i < testBoard.ROWS; i++){
            for (int j = 0; j < testBoard.COLUMNS; j++){
                testBoard.board[i][j]= testBoard.EMPTY;
                assertEquals(board.board[i][j] ,testBoard.board[i][j]);}}
    }

    @org.junit.jupiter.api.Test
    void isColumnFull() {
        for (int i = 0; i < board.ROWS; i++){
            board.board[i][col]='X';}
        assertFalse(board.isColumnFull(col));
    }

    @org.junit.jupiter.api.Test
    void firstEmptyRow() {;
        board.initializeBoard();
        assertEquals(board.firstEmptyRow(col),5);}

    @org.junit.jupiter.api.Test
    void winningDisk() {
        board.initializeBoard();
        board.alignDisc(new Position(0,1),new DiscType('X'));
        board.alignDisc(new Position(0,2),new DiscType('X'));
        assertFalse(board.winningDisk(new Position(0,2)));
        board.alignDisc(new Position(0,3),new DiscType('X'));
        board.alignDisc(new Position(0,4),new DiscType('X'));
        assertTrue(board.winningDisk(new Position(0,4)));

    }

    @org.junit.jupiter.api.Test
    void alignDisc() {
        board.alignDisc(new Position(1,0),new DiscType('X'));
        assertEquals(board.board[1][0],'X');
    }

    @org.junit.jupiter.api.Test
    void boardIsFull() {
        for (int i=0; i<board.COLUMNS; i++)
            board.board[0][i] = ' ';
        assertFalse(board.boardIsFull());
    }
}