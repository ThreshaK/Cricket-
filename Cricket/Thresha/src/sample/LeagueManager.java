package sample;

import java.io.IOException;

public interface LeagueManager {

    String addNewFootBallClub();
    SportsClub deleteFootBallClub();
    void displayTable();
    SportsClub Statistic();
    String enterStatus() throws IOException;
    void openGUI();
    void saveData(String fileName,String fileName2) throws IOException;
    void retriveData() throws IOException, ClassNotFoundException;




}
