package Ex3.FourInRow;

import java.awt.*;

public class DiscType {
    public char type;
    public Color color;

    public DiscType(char type){
        this.type = type;
    }

    public char getType(){
        return type;
    }
    public Color getColor(){
        return color;
    }
    public void draw(Position position, char type, Color color){}
    @Override
    public String toString() {
        var str = "DiscType = "+type ;
        return str;
    }
}
