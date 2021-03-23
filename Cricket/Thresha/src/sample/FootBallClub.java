package sample;

import java.io.Serializable;
import java.util.Comparator;

public class FootBallClub extends SportsClub implements Serializable,Comparable {
    private static final double serialVersionUID = 1D;
    private int numOfWins = 0;
    private int numOfDrwas = 0;
    private int numOfDefeats = 0;
    private int numOfGoalsRecieved = 0;
    private double numOfGoalsScored = 0;
    private double numOfPoints = 0;
    private int numOfMatchesPlayed = 0;
    private Date date;


    public FootBallClub(String sportClubName, String location) {
        super.setSportsClubName(sportClubName);
        super.setLocation(location);
    }

    public FootBallClub(String sportsClubName, String location, int numOfWins, int numOfDrwas, int numOfDefeats, int numOfGoalsRecieved, double numOfGoalsScored, double numOfPoints, int numOfMatchesPlayed, Date date) {
        super(sportsClubName, location);
        this.numOfWins = numOfWins;
        this.numOfDrwas = numOfDrwas;
        this.numOfDefeats = numOfDefeats;
        this.numOfGoalsRecieved = numOfGoalsRecieved;
        this.numOfGoalsScored = numOfGoalsScored;
        this.numOfPoints = numOfPoints;
        this.numOfMatchesPlayed = numOfMatchesPlayed;
        this.date = date;
    }

    public FootBallClub() {
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins() {
        this.numOfWins = numOfWins + 1;
    }

    public int getNumOfDrwas() {
        return numOfDrwas;
    }

    public void setNumOfDrwas() {
        this.numOfDrwas = numOfDrwas + 1;
    }

    public int getNumOfDefeats() {
        return numOfDefeats;
    }

    public void setNumOfDefeats() {
        this.numOfDefeats = numOfDefeats + 1;
    }

    public int getNumOfGoalsRecieved() {
        return numOfGoalsRecieved;
    }

    public void setNumOfGoalsRecieved(int NumOfGoalsRecieved) {
        numOfGoalsRecieved = numOfGoalsRecieved + NumOfGoalsRecieved;
    }

    public double getNumOfGoalsScored() {
        return numOfGoalsScored;
    }

    public void setNumOfGoalsScored(double NumOfGoalsScored) {
        numOfGoalsScored = numOfGoalsScored + NumOfGoalsScored;
    }

    public double getNumOfPoints() {
        return numOfPoints;
    }

    public void setNumOfPoints(double NumOfPoints) {
        numOfPoints = numOfPoints + NumOfPoints;
    }

    public int getNumOfMatchesPlayed() {
        return numOfMatchesPlayed;
    }

    public void setNumOfMatchesPlayed() {
        this.numOfMatchesPlayed = numOfMatchesPlayed + 1;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString() +
                "numOfWins=" + numOfWins +
                ", numOfDraws=" + numOfDrwas +
                ", numOfDefeats=" + numOfDefeats +
                ", numOfGoalsReceived=" + numOfGoalsRecieved +
                ", numOfGoalsScored=" + numOfGoalsScored +
                ", numOfPoints=" + numOfPoints +
                ", numOfMatchesPlayed=" + numOfMatchesPlayed +
                ", date = " + date + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        double sortByPoints = ((FootBallClub)o).getNumOfPoints();
        return (int) (sortByPoints-this.numOfPoints);
    }
    public static final Comparator<FootBallClub> sortByGoalsScored = new Comparator<FootBallClub>() {

        public int compare(FootBallClub f1, FootBallClub f2) {
            double score1 = f1.getNumOfGoalsScored();
            double score2 = f2.getNumOfGoalsScored();

            return (int) (score2-score1);

        }
    };

    public static final Comparator<FootBallClub> sortByWins = new Comparator<FootBallClub>() {

        public int compare(FootBallClub f1, FootBallClub f2) {
            double wins1 = f1.getNumOfWins();
            double wins2 = f2.getNumOfWins();

            return (int) (wins2-wins1);

        }
    };
}

