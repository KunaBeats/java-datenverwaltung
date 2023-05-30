package com.example.psabschlussprojekt.logic.db;

import com.example.psabschlussprojekt.model.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * Baut Verbindung zu Datenbanken auf und verwaltet diese.
 * hat Zugriff auf die DAO-Objekte aller Modellklassen.
 */
public class DbManager {
    //region Konstanten
    private static final String SERVER_IP = "localhost";
    private static final String DB_NAME = "spielerverwaltung";

    private static final String JDBC_PREFIX = "jdbc:mariadb://";

    private static final String CONNECTION_URL = JDBC_PREFIX + SERVER_IP + "/" + DB_NAME;
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "";
//endregion

    //region Attribute
    private static DbManager instance;
    private DaoPlayer daoPlayer;
//endregion

    //region Konstruktoren
    private DbManager() {
        daoPlayer = new DaoPlayer();
    }
//endregion

    //region Methoden
    public static synchronized DbManager getInstance() {
        if (instance == null) instance = new DbManager();
        return instance;
    }

    /**
     * Baut Verbindung zur Datenbank auf und gibt diese zurück.
     */

    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(CONNECTION_URL, DB_USERNAME, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void insertDataRecord(Player player) {
        daoPlayer.create(getConnection(), player);
    }

    public List<Player> readAllDataRecords() {return daoPlayer.readAll(getConnection());}

    public void updateDataRecord(Player player) {
        daoPlayer.update(getConnection(), player);
    }

    public void deleteDataRecord(Player player) {
        daoPlayer.delete(getConnection(), player);
    }


//endregion
}
