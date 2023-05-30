package com.example.psabschlussprojekt.logic.db;

import com.example.psabschlussprojekt.model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;

/**
 * Stellt Methoden für CRUD-Anweisungen
 */
public class DaoPlayer implements Dao<Player> {

    //region Konstanten
    public static final String COL_ID = "_id";
    public static final String COL_LAST_NAME = "lastName";
    public static final String COL_FIRST_NAME = "firstName";
    public static final String COL_TEAM = "club";
    public static final String COL_AGE = "age";
    public static final String PlAYER_INSERT_STATEMENT = "INSERT INTO players (lastName, firstName, club, age) VALUES (?,?,?,?);";
    public static final String PlAYER_UPDATE_STATEMENT = "UPDATE players SET lastName=?, firstName=?, club=?, age=? WHERE _id=?;";
    public static final String PlAYER_SELECT_STATEMENT = "SELECT * FROM players";
    public static final String PlAYER_DELETE_STATEMENT = "DELETE FROM players WHERE _id=?";
//endregion

//region Attribute
//endregion

//region Konstruktoren
//endregion

//region Methoden

    @Override
    public List<Player> readAll(Connection dbConnection) {

        List<Player> players = new ArrayList<>();

        Statement statement = null;

        try {

            statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(PlAYER_SELECT_STATEMENT);

            while (resultSet.next()) {
                Player player = new Player(
                        resultSet.getString(COL_LAST_NAME),
                        resultSet.getString(COL_FIRST_NAME),
                        resultSet.getString(COL_TEAM),
                        resultSet.getInt(COL_AGE)

                );

                player.setId(resultSet.getInt(COL_ID));

                players.add(player);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                dbConnection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return players;
    }

    @Override
    public void create(Connection dbConnection, Player player) {
        PreparedStatement statement = null;

        try {
            statement = dbConnection.prepareStatement(PlAYER_INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, player.getLastName());
            statement.setString(2, player.getFirstName());
            statement.setString(3, player.getTeam());
            statement.setInt(4, player.getAge());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                int insertId = resultSet.getInt("insert_id");
                player.setId(insertId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                dbConnection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void update(Connection dbConnection, Player player) {
        PreparedStatement statement = null;

        try {

            statement = dbConnection.prepareStatement(PlAYER_UPDATE_STATEMENT);
            statement.setString(1, player.getLastName());
            statement.setString(2, player.getFirstName());
            statement.setString(3, player.getTeam());
            statement.setInt(4, player.getAge());
            statement.setInt(5, player.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                dbConnection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Connection dbConnection, Player player) {
        PreparedStatement statement = null;

        try {
            statement = dbConnection.prepareStatement(PlAYER_DELETE_STATEMENT);
            statement.setInt(1, player.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                dbConnection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


//endregion
}
