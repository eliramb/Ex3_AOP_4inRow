package Ex3.FourInRow;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class FourInRow {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        System.out.println("Welcome to Four in a Line!");

       while(true) {
            Game game = context.getBean(Game.class);
            game.printMenu();
            if( game.userChoice() ==0) return;
            game.play();
        }
    }
}
