package Ex3.FourInRow;

public class EasyLevel implements IGameLevel{
    private final DiscType XPLAYER = new DiscType('X');
    private final DiscType OPLAYER = new DiscType('O');
    private final DiscType EMPTY = new DiscType(' ');

    @Override
    public Position ComputerChoice(IBoard board) {
    // returns a column number within 0...COLUMNS, -1 if board is full
        int emptyrow= 0;
        Position position=null;
        // first check if a move can win
        for (int i=0; i<board.getBoard().COLUMNS; i++) {
            if (board.isColumnFull(i)) {
                emptyrow = board.firstEmptyRow(i);
                position =new Position(emptyrow, i);
                board.alignDisc(position, XPLAYER);
                if (board.winningDisk(position)) {
                    board.alignDisc(position, EMPTY); // reset
                    return position;
                }
                board.alignDisc(position, EMPTY); // reset
            }
        }
        // otherwise then pick up any move that will prevent other player to win
        // in case there is a win on next turn
        int counter = 0; // i count other player possible winnings
        int chosenrow = 0;
        for (int i=0; i<board.getBoard().COLUMNS; i++) {
            if (board.isColumnFull(i)) {
                emptyrow = board.firstEmptyRow(i);
                position = new Position(emptyrow,i);
                board.alignDisc(position, OPLAYER); // assume the other player does this
                if (board.winningDisk(position)) {
                    board.alignDisc(position, EMPTY); // reset
                    counter++; // we found a winning disc
                    chosenrow = i; // remember the row
                }
                board.alignDisc(position, EMPTY); // reset
            }
        }
        // we block the player if there is exactly one winning disc

        if (counter==1){
            position.row = emptyrow;
            position.col = chosenrow;
            return position;
        }

        // else if other player wins no matter what, pick up first non full column
        for (int i=0; i<board.getBoard().COLUMNS; i++)
            if (board.isColumnFull(i)){
                assert position != null;
                position.row = -1;
                position.col = i;

                return position;
            }
        return null;
    }
}
