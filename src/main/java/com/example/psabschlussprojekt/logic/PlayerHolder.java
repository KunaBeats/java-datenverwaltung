package com.example.psabschlussprojekt.logic;

import com.example.psabschlussprojekt.logic.db.DbManager;
import com.example.psabschlussprojekt.model.Player;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class PlayerHolder {
//region Konstanten
//endregion
    /**
     * Stellt Liste der Spieler als ObservableList bereit.
     */
//region Attribute
    private static PlayerHolder instance;

    private ObservableList<Player> playerList;
//endregion

    //region Konstruktoren
    private PlayerHolder() {
        playerList = FXCollections.observableArrayList(player ->
                new Observable[]{
                        player.lastNameProperty(), player.firstNameProperty(), player.teamProperty(), player.ageProperty()
                });
        playerList.addAll(DbManager.getInstance().readAllDataRecords());

        playerList.addListener((ListChangeListener<Player>) change -> {

            while (change.next()) {

                if (change.wasAdded()) {

                    for (Player playerToInsert : change.getAddedSubList()) {
                        DbManager.getInstance().insertDataRecord(playerToInsert);
                    }

                } else if (change.wasUpdated()) {

                    for (int i = change.getFrom(); i < change.getTo(); i++) {
                        Player playerToUpdate = change.getList().get(i);
                        DbManager.getInstance().updateDataRecord(playerToUpdate);
                    }

                } else if (change.wasRemoved()) {

                    for (Player playerToDelete : change.getRemoved()) {
                        DbManager.getInstance().deleteDataRecord(playerToDelete);
                    }

                }
            }
        });
    }
//endregion

    //region Methoden
    public static synchronized PlayerHolder getInstance() {
        if (instance == null) instance = new PlayerHolder();
        return instance;
    }

    public ObservableList<Player> getPlayerList() {
        return playerList;
    }
//endregion
}
