package userinterface;

import javax.swing.*;
import java.awt.*;

/**
 * This class contains the generic properties holding all the screens as well as the card layout. These
 * properties hold the ability to change between different screens.
 */
public class GenericProperties {
    private final JPanel screens;
    private final CardLayout cards;

    public GenericProperties(JPanel screens, CardLayout cards) {
        this.screens = screens;
        this.cards = cards;
    }

    public JPanel getScreens() {
        return screens;
    }

    public CardLayout getCards() {
        return cards;
    }
}
