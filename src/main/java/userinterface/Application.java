package userinterface;

import javax.swing.*;
import java.awt.*;

public class Application {
    public final JFrame application = new JFrame();
    public static final CardLayout cards = new CardLayout();
    public static final JPanel screens = new JPanel(cards);

    public Application() {
        application.add(screens);
        application.setSize(400, 500);
    }

    public void addScreen(JPanel screen, String name) {
        screens.add(screen, name);
    }

    public void render() {
        cards.show(screens, "main");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
