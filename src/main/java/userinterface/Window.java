package userinterface;

import frameworksdrivers.DatabaseDriver;
import frameworksdrivers.DbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This is the main window screen for the application. A user may initialize this class to begin adding screens.
 * This application window will check if there is an available connection to the database. This class hides the
 * implementation details of the GUI.
 */
public class Window extends WindowAdapter {
    public final JFrame application = new JFrame();
    public static final CardLayout cards = new CardLayout();
    public static final JPanel screens = new JPanel(cards);

    public Window() {
        application.add(screens);
        application.setSize(400, 500);
        application.addWindowListener(this);

        if (!DbConnection.testConnection()) {
            application.setVisible(false);
            application.dispose();
        }
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

    /**
     * This method makes sure that upon closing the application window, the session database information is deleted.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Deleting session information.");
        DatabaseDriver databaseDriver = new DatabaseDriver();
        databaseDriver.getSessionDbGateway().deleteStudentSession();
        databaseDriver.getSessionDbGateway().deleteCourseSession();
    }
}
