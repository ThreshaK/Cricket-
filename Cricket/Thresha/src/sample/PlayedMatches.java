package sample;

import java.io.Serializable;
import java.util.Comparator;

public class PlayedMatches implements Serializable,Comparable<PlayedMatches> {
    private static final double serialVersionUID = 1D;
    String clubName1;
    String clubName2;
    int score1;
    int score2;
   Date date;

    public PlayedMatches(String clubName1, String clubName2, int score1, int score2, sample.Date date) {
        this.clubName1 = clubName1;
        this.clubName2 = clubName2;
        this.score1 = score1;
        this.score2 = score2;
        this.date=date;
    }

    public PlayedMatches() {
    }

    public String getClubName1() {
        return clubName1;
    }

    public void setClubName1(String clubName1) {
        this.clubName1 = clubName1;
    }

    public String getClubName2() {
        return clubName2;
    }

    public void setClubName2(String clubName2) {
        this.clubName2 = clubName2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(PlayedMatches o) {
        return 0;
    }


    @Override
    public String toString() {
        return "{" +
                "clubName1='" + clubName1 + '\'' +
                ", clubName2='" + clubName2 + '\'' +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", date=" + date +
                '}';
    }
    
}
