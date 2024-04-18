package org.example.Models;

/**
 * A class with getters and setters and without an Argument constructor that represents a Player with its dependencies
 */
public class Player {
    private  String name;
    private String position;
    private  String team;
    private  int number;

    public Player() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", number=" + number +
                '}';
    }
    /**
     * @param category The user chooses which category the statistics will be generated for
     * @return Returns the category for which to make statistics
     */
    public String category_chose(String category){
        String result="";
        switch (category){

            case"team":
                result= team;
                break;
            case "name":
                result= name;
                break;
            case "position":
               result= position;
               break;
            case "number":
              result= String.valueOf(number);
                break;
            default:
                throw new RuntimeException("Wrong category selected");
        }
        return result;
    }
}
