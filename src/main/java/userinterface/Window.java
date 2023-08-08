package userinterface;

import frameworksdrivers.DatabaseDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends WindowAdapter {
    public final JFrame application = new JFrame();
    public static final CardLayout cards = new CardLayout();
    public static final JPanel screens = new JPanel(cards);

    public Window() {
        application.add(screens);
        application.setSize(400, 500);
        application.addWindowListener(this);
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

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Deleting session information.");
        DatabaseDriver databaseDriver = new DatabaseDriver();
        databaseDriver.getSessionDbGateway().deleteStudentSession();
        databaseDriver.getSessionDbGateway().deleteCourseSession();
    }
}
