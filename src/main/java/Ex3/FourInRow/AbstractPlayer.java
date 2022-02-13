package Ex3.FourInRow;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractPlayer implements IPlayer {
    DiscType discType;
    IBoard board;

    public abstract Position alignDisc(Position position);

}
