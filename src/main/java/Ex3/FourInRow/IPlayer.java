package Ex3.FourInRow;

import org.springframework.stereotype.Component;

@Component
public interface IPlayer {

   Position alignDisc(Position position);
}
