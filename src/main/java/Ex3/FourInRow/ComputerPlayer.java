package Ex3.FourInRow;

import java.lang.reflect.Proxy;

public class ComputerPlayer extends AbstractPlayer {

    public IGameLevel gameLevel;

    public ComputerPlayer(char playerChar, IBoard _board) {
        super();
        board = _board;
        discType = new DiscType(playerChar);
        gameLevel = (IGameLevel) DebugProxy.newInstance(new EasyLevel());
    }

    @Override
    public Position alignDisc(Position position) {
        board.alignDisc(position, discType);
        return position;
    }
}
