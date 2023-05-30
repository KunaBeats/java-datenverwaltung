package com.example.psabschlussprojekt.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Hier befinden sich die Daten der Spieler.
 * Instanzen dieser Klasse stellen Spieler aus der Realität dar.
 */
public class Player {
    public static final String DEFAULT_STRING_VALUE = "noValueSet";
    public static final int DEFAULT_INT_VALUE = -1;
    //region Konstanten
//endregion

//region Attribute
    private Integer id;
    private StringProperty lastName;
    private StringProperty firstName;
    private StringProperty team;
    private IntegerProperty age;
//endregion

//region Konstruktoren

    public Player() {
        lastName = new SimpleStringProperty(DEFAULT_STRING_VALUE);
        firstName = new SimpleStringProperty(DEFAULT_STRING_VALUE);
        team = new SimpleStringProperty(DEFAULT_STRING_VALUE);
        age = new SimpleIntegerProperty(DEFAULT_INT_VALUE);
    }

    public Player(String lastName, String firstName, String team, int age) {
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.team = new SimpleStringProperty(team);
        this.age = new SimpleIntegerProperty(age);
    }

//endregion

//region Methoden

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getTeam() {
        return team.get();
    }

    public StringProperty teamProperty() {
        return team;
    }

    public void setTeam(String team) {
        this.team.set(team);
    }

    public Integer getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(Integer age) {
        this.age.set(age);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", lastName=" + lastName +
                ", firstName=" + firstName +
                ", team=" + team +
                ", age=" + age +
                '}';
    }

    //endregion
}
