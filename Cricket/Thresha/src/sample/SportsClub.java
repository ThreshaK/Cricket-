package sample;

import com.sun.java_cup.internal.runtime.Scanner;

import java.io.Serializable;

public class SportsClub implements Serializable {
    private String sportsClubName;
    public String location;

    public SportsClub(String sportsClubName, String location) {
        this.sportsClubName = sportsClubName;
        this.location = location;

    }
    public SportsClub(String sportsClubName) {
        this.sportsClubName = sportsClubName;

    }


    public SportsClub() {
    }

    public String getSportsClubName() {
        return sportsClubName;
    }

    public void setSportsClubName(String sportsClubName) {
        this.sportsClubName = sportsClubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return
                "sportsClubName='" + sportsClubName + '\'' +
                        ", location='" + location + '\'' ;
    }
}
