package sample;

public class Row {
    private String sportsClubName;
    public String location;
    private int numOfWins=0;
    private int numOfDrwas=0;
    private int numOfDefeats=0;
    private int numOfGoalsRecieved=0;
    private double numOfGoalsScored=0;
    private double numOfPoints=0;
    private int numOfMatchesPlayed=0;
    private Date date;
    private String name1;
    private String name2;
    private int score1;
    private int score2;
    private Date date1;

    public String getSportsClubName() {
        return sportsClubName;
    }

    public String getLocation() {
        return location;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public int getNumOfDrwas() {
        return numOfDrwas;
    }

    public int getNumOfDefeats() {
        return numOfDefeats;
    }

    public int getNumOfGoalsRecieved() {
        return numOfGoalsRecieved;
    }

    public double getNumOfGoalsScored() {
        return numOfGoalsScored;
    }

    public double getNumOfPoints() {
        return numOfPoints;
    }

    public int getNumOfMatchesPlayed() {
        return numOfMatchesPlayed;
    }

    public Date getDate() {
        return date;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public Date getDate1() {
        return date1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public void setNumOfGoalsRecieved(int numOfGoalsRecieved) {
        this.numOfGoalsRecieved = numOfGoalsRecieved;
    }

    public void setNumOfGoalsScored(double numOfGoalsScored) {
        this.numOfGoalsScored = numOfGoalsScored;
    }

    public void setNumOfPoints(double numOfPoints) {
        this.numOfPoints = numOfPoints;
    }


    public void setSportsClubName(String sportsClubName) {
        this.sportsClubName = sportsClubName;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }


    public void setNumOfDrwas(int numOfDrwas) {
        this.numOfDrwas = numOfDrwas;
    }


    public void setNumOfDefeats(int numOfDefeats) {
        this.numOfDefeats = numOfDefeats;
    }


    public void setNumOfMatchesPlayed(int numOfMatchesPlayed) {
        this.numOfMatchesPlayed = numOfMatchesPlayed;
    }
}
