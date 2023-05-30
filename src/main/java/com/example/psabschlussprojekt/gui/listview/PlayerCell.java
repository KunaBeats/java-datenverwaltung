package com.example.psabschlussprojekt.gui.listview;

import com.example.psabschlussprojekt.model.Player;
import javafx.scene.control.ListCell;

/**
 * Stellt eine Zelle dar, welche in der listview angezeigt wird
 */
public class PlayerCell extends ListCell<Player> {
//region Konstanten

    public static final String LIST_VIEW_FORMAT_STRING = "%25s%25s%45s%35s";
//endregion

//region Attribute
//endregion

//region Konstruktoren
//endregion

//region Methoden

    /**
     * Aktualisiert den Zelleninhalt, definiert die Art der Darstellung und zeigt den Inhalt an.
     *
     * @param player  neues Item
     * @param isEmpty
     */
    @Override
    protected void updateItem(Player player, boolean isEmpty) {
        super.updateItem(player, isEmpty);

        if (isEmpty || player == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(String.format(LIST_VIEW_FORMAT_STRING, player.getLastName(), player.getFirstName(), player.getTeam(), player.getAge()));
        }
    }
//endregion
}
