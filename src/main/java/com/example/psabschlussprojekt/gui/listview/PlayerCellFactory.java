package com.example.psabschlussprojekt.gui.listview;

import com.example.psabschlussprojekt.model.Player;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * baut die listview auf mit den in {@link PlayerCell} definierten Zellen.
 */
public class PlayerCellFactory implements Callback<ListView<Player>, ListCell<Player>> {
//region Konstanten
//endregion

//region Attribute
//endregion

//region Konstruktoren
//endregion

//region Methoden

    /**
     * Hier werden Zellen für jedes Element der ObservableList erzeugt und zurückgeliefert.
     *
     * @param playerListView
     * @return
     */
    @Override
    public ListCell<Player> call(ListView<Player> playerListView) {
        return new PlayerCell();
    }
//endregion
}
