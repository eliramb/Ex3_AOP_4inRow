package Ex3.FourInRow;

import org.springframework.stereotype.Component;

@Component
public class Player extends AbstractPlayer {

    public Player(){}
    public Player(char _playerChar, IBoard _board) {
        super();
        board = _board;
        discType = new DiscType(_playerChar);
    }

    @Override
    public Position alignDisc(Position position) {
        board.alignDisc(position, discType);
        return position;
    }

}
