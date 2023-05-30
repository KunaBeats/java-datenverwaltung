package com.example.psabschlussprojekt.logic.db;

import java.sql.Connection;
import java.util.List;

/**
 * Stellt die Methoden für die CRUD-Operationen bereit
 */
public interface Dao<T> {
    /**
     * Fügt ein Objekt in die db ein
     *
     * @param dbConnection {@link Connection} : Verbindung zur Datenbank
     * @param object
     */
    void create(Connection dbConnection, T object);

    /**
     * Zum Auslesen der Datensätze einer Tabelle
     *
     * @param dbConnection {@link Connection} : Verbindung zur Datenbank
     * @return {@link List<T>} : Liste von Objekten
     */
    List<T> readAll(Connection dbConnection);

    /**
     * Aktualisiert ein Objekt der db
     *
     * @param dbConnection {@link Connection} : Verbindung zur Datenbank
     * @param object       : T : Instanz einer Klasse
     */
    void update(Connection dbConnection, T object);

    /**
     * Löscht ein Objekt aus der db
     *
     * @param dbConnection {@link Connection} : Verbindung zur Datenbank
     * @param object       : T : Instanz einer Klasse
     */
    void delete(Connection dbConnection, T object);
}
