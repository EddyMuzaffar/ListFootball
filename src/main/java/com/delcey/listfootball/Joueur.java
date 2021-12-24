package com.delcey.listfootball;

import java.util.Locale;

//Class Joueur
public class Joueur {

    // Identity
    private String name;
    private String id;
    private String picture;
    private String city;



    //State
    private String speed;
    private String stamina;
    private String dribbling;
    private String defending;
    private String shooting;
    private String passing;
    private String score;

    //Constructor

    public Joueur(String name, String id, String speed, String stamina, String dribbling, String defending, String shooting, String passing, String score, String picture, String city) {
        this.name = name.toUpperCase();
        this.id = "#"+id;
        this.speed = "Speed: "+getTron(speed);
        this.stamina = "Stamina: "+getTron(stamina);
        this.dribbling = "Dribbling: "+getTron(dribbling);
        this.defending = "Defending: "+getTron(defending);
        this.shooting = "Shooting: "+getTron(shooting);
        this.passing = "Passing: "+getTron(passing);
        this.score = "Score: "+getTron(score);
        this.picture = picture;
        this.city = getCity(city);
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getSpeed() {


        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getStamina() {
        return stamina;
    }

    public void setStamina(String stamina) {
        this.stamina = stamina;
    }

    public String getDribbling() {
        return dribbling;
    }

    public void setDribbling(String dribbling) {
        this.dribbling = dribbling;
    }

    public String getDefending() {
        return defending;
    }

    public void setDefending(String defending) {
        this.defending = defending;
    }

    public String getShooting() {
        return shooting;
    }

    public void setShooting(String shooting) {
        this.shooting = shooting;
    }

    public String getPassing() {
        return passing;
    }

    public void setPassing(String passing) {
        this.passing = passing;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String rank) {
        this.city = rank;
    }


    //Fonction troncter les valeurs
    public String getTron(String d) {
        if (d.length() >= 4) {
            String a = d.substring(0, 4);
            return a;
        }
        return d;
    }

    //Fonction verifier si la ville est connue
    public String getCity (String a){
        String b = "Inconnu";
        if(a.isEmpty()){
            return b;
        }
        return a;
    }
}
