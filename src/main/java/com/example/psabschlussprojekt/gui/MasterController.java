package com.example.psabschlussprojekt.gui;

import com.example.psabschlussprojekt.gui.listview.PlayerCellFactory;
import com.example.psabschlussprojekt.logic.PlayerHolder;
import com.example.psabschlussprojekt.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Enthält die Steuerlogik für die Gui
 */
public class MasterController implements Initializable {
    @FXML
    private ListView<Player> playerListView;

    private Player currentPlayer;

    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtTeam;

    @FXML
    private TextField txtAge;

    /**
     * Sorgt für die Initialisierung der zu generierenden Elemente
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        playerListView.setCellFactory(new PlayerCellFactory());

        playerListView.setItems(PlayerHolder.getInstance().getPlayerList());

        playerListView.getSelectionModel().selectedItemProperty().addListener((observable, prev, cur) -> {
            System.out.println(cur);
            currentPlayer = cur;
            if (currentPlayer == null) {
                txtLastName.setText("");
                txtFirstName.setText("");
                txtTeam.setText("");
                txtAge.setText("");
            } else {
                txtLastName.setText(cur.getLastName());
                txtFirstName.setText(cur.getFirstName());
                txtTeam.setText(cur.getTeam());
                txtAge.setText(cur.getAge().toString());
            }

        });


    }

    @FXML
    private void savePlayer() {

        try {

            boolean createNew = false;

            if (currentPlayer == null) {
                currentPlayer = new Player();
                createNew = true;
            }

            currentPlayer.setLastName(txtLastName.getText());
            currentPlayer.setFirstName(txtFirstName.getText());
            currentPlayer.setTeam(txtTeam.getText());
            currentPlayer.setAge(Integer.parseInt(txtAge.getText()));


            if (createNew) PlayerHolder.getInstance().getPlayerList().add(currentPlayer);


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        playerListView.getSelectionModel().clearSelection();
        txtLastName.setText("");
        txtFirstName.setText("");
        txtTeam.setText("");
        txtAge.setText("");
        currentPlayer = null;
    }

    @FXML
    private void deletePlayer() {
        if (currentPlayer != null) {
            PlayerHolder.getInstance().getPlayerList().remove(currentPlayer);
            playerListView.getSelectionModel().clearSelection();
            txtLastName.setText("");
            txtFirstName.setText("");
            txtTeam.setText("");
            txtAge.setText("");
            currentPlayer = null;
        }
    }
}