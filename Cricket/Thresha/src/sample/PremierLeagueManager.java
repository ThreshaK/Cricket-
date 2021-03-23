package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class PremierLeagueManager extends Application implements LeagueManager ,Serializable{
    private static ArrayList<FootBallClub> footBallClubArrayList = new ArrayList<FootBallClub>();
    private static ArrayList<PlayedMatches> playedMatchesArrayList=new ArrayList<>();
    private static Stage window = null;
    private static Scanner scanner;
    String sportClubName;
    private static TableView tableView;
    private static TableView tableView1;



    @Override
    public String addNewFootBallClub() {
        FootBallClub member = null;
        boolean flag = false;

        MEMBER_TYPE type = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("> Select Membership Type : ");
        System.out.println("> 1. Default Club");
        System.out.println("> 2. University Football club ");
        System.out.println("> 3. School Football Club");
        System.out.print("> Select membership type : ");
        int option=0;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("!!!!!! Invalid Input. Enter Valid Input Type!!!!!");
            addNewFootBallClub();
        }

        switch (option) {
            case 1: {
                flag = true;
                type = MEMBER_TYPE.DEFAULTFOODBALLCLUB;
                member = new FootBallClub();
                break;
            }
            case 2: {
                flag = true;
                type = MEMBER_TYPE.UNIVERSITYFOOTBALLCLUB;
                member = new UniversityFootBallClub();
                break;
            }
            case 3: {
                flag = true;
                type = MEMBER_TYPE.SCHOOLFOOTBALLCLUB;
                member = new SchoolFootBallClub();
                break;
            }
            default:
                System.out.println("> !!!!! Try again !!!!!");
        }
        if (flag) {
            try {
                System.out.print("Enter club name : ");
                sc.nextLine();
                String sportClubName = sc.nextLine();

                System.out.print("Location : ");
                String location = sc.nextLine();


                switch (type) {
                    case SCHOOLFOOTBALLCLUB: {
                        System.out.print("> Enter school name : ");
                        String schoolName = sc.nextLine();
                        System.out.print("> Enter coach name : ");
                        String coachName = sc.nextLine();
                        ((SchoolFootBallClub) member).setSchoolName(schoolName);
                        ((SchoolFootBallClub) member).setCoachName(coachName);
                        break;
                    }
                    case UNIVERSITYFOOTBALLCLUB: {
                        try {
                            System.out.print(">  Enter university name : ");
                            String universityName = sc.nextLine();
                            System.out.print("> Enter coach name : ");
                            String coachName = sc.nextLine();
                            ((UniversityFootBallClub) member).setUniversityName(universityName);
                            ((UniversityFootBallClub) member).setCoachName(coachName);
                        } catch (InputMismatchException e) {
                            return "> Invalid input type !";
                        }
                        break;
                    }
                }
                footBallClubArrayList.add(new FootBallClub(sportClubName, location));
                System.out.println(sportClubName + " successfully Add to Premier League");



            } catch (InputMismatchException e) {
                return "> Enter valid type";
            }
        } return null;
    }

    @Override
    public SportsClub deleteFootBallClub() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter club name want to remove : ");
        sportClubName = sc.nextLine();

        for (FootBallClub footBallClub : footBallClubArrayList) {
            if (footBallClub.getSportsClubName().equals(sportClubName)) {
                footBallClubArrayList.remove(footBallClub);
                System.out.println("!!!!!!!!!" +sportClubName + " remove from the premier league !!!!!!!!!");
                return footBallClub;
            }
        }
        System.out.println("!!!!!!!!!" +sportClubName +" not in premier league !!!!!!!!!");

        return null;
    }

    @Override
    public void displayTable() {
        System.out.printf(" %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-15s %n", "Club Name", "Club Location", "wins" , "Defeats" , "Draws" ,"Goals Received", " Goals Scored" ,"Points" , "Played Matches" );
        Collections.sort(footBallClubArrayList);
        Iterator iterator = this.footBallClubArrayList.iterator();

        while(iterator.hasNext()) {
            FootBallClub viewList = (FootBallClub) iterator.next();
            System.out.printf( "%-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-15s %n",viewList.getSportsClubName(), viewList.getLocation() ,viewList.getNumOfWins(), viewList.getNumOfDefeats(), viewList.getNumOfDrwas(),viewList.getNumOfGoalsRecieved(),viewList.getNumOfGoalsScored(), viewList.getNumOfPoints(), viewList.getNumOfMatchesPlayed() );
        }
    }

    @Override
    public SportsClub Statistic() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Club Name : ");
        String clubName = sc.nextLine();
        for (SportsClub sportsClub : footBallClubArrayList) {
            if (sportsClub.getSportsClubName().equals(clubName)) {
                System.out.println(sportsClub.toString());
                return sportsClub;
            }
        }

        System.out.println("!!!!!!!!!" +clubName + " is not in Premier League !!!!!!!!!");
        return null;
    }

    @Override
    public String enterStatus() {

        Date date ;
        Scanner sc3 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("Club Name : ");
        String sportsName1 = sc2.nextLine();

        System.out.println("Enter number of goals : ");
        int ans1 = inputValidation();

        System.out.println("Club Name : ");
        String sportsName2 = sc2.nextLine();

        System.out.println("Enter number of goals : ");
        int ans2 = inputValidation();

        try {
            date = new Date();
            System.out.println("> Enter  date");
            System.out.print("> Year : ");
            date.setYear(sc3.nextInt());
            System.out.print("> Month : ");
            date.setMonth(sc3.nextInt());
            System.out.print("> Date : ");
            date.setDate(sc3.nextInt());

        } catch (InputMismatchException e) {
            return "> Invalid date!";
        }
        addmatch(sportsName1,sportsName2,ans1,ans2,date);
        return null;
    }

    public void addmatch(String clubName1,String clubName2,int ans1,int ans2,Date date){
        double points = 0;
        double goalsScored ;

        if (ans1 > ans2) {
            for (int i = 0; i < footBallClubArrayList.size(); i++) {
                footBallClubArrayList.get(i).setDate(date);
                if (footBallClubArrayList.get(i).getSportsClubName().equals(clubName1)) {
                    points = points + 5;
                    goalsScored = ans1 * 2;
                    footBallClubArrayList.get(i).setNumOfGoalsScored(goalsScored);
                    footBallClubArrayList.get(i).setNumOfWins();
                    footBallClubArrayList.get(i).setNumOfPoints(points);
                    footBallClubArrayList.get(i).setNumOfMatchesPlayed();
                    footBallClubArrayList.get(i).setNumOfGoalsRecieved(ans1);



                } else if (footBallClubArrayList.get(i).getSportsClubName().equals(clubName2)) {
                    points = points + 3;
                    goalsScored = ans2 * 2;
                    footBallClubArrayList.get(i).setNumOfGoalsScored(goalsScored);
                    footBallClubArrayList.get(i).setNumOfDefeats();
                    footBallClubArrayList.get(i).setNumOfMatchesPlayed();
                    footBallClubArrayList.get(i).setNumOfPoints(points);
                    footBallClubArrayList.get(i).setNumOfGoalsRecieved(ans2);

                }

            }
            playedMatchesArrayList.add(new PlayedMatches(clubName1,clubName2,ans1,ans2,date));

        } else if (ans1 < ans2) {
            for (int i = 0; i < footBallClubArrayList.size(); i++) {
                footBallClubArrayList.get(i).setDate(date);
                if (footBallClubArrayList.get(i).getSportsClubName().equals(clubName2)) {
                    points = points + 5;
                    goalsScored = ans1 * 2;
                    footBallClubArrayList.get(i).setNumOfGoalsScored(goalsScored);
                    footBallClubArrayList.get(i).setNumOfWins();
                    footBallClubArrayList.get(i).setNumOfPoints(points);
                    footBallClubArrayList.get(i).setNumOfMatchesPlayed();
                    footBallClubArrayList.get(i).setNumOfGoalsRecieved(ans2);




                } else if (footBallClubArrayList.get(i).getSportsClubName().equals(clubName1)) {
                    points = points + 3;
                    goalsScored = ans2 * 2;
                    footBallClubArrayList.get(i).setNumOfGoalsScored(goalsScored);
                    footBallClubArrayList.get(i).setNumOfDefeats();
                    footBallClubArrayList.get(i).setNumOfMatchesPlayed();
                    footBallClubArrayList.get(i).setNumOfPoints(points);
                    footBallClubArrayList.get(i).setNumOfGoalsRecieved(ans1);


                }

            }
            playedMatchesArrayList.add(new PlayedMatches(clubName1,clubName2,ans1,ans2,date));


        } else if (ans1 == ans2) {
            for (int i = 0; i < footBallClubArrayList.size(); i++) {
                footBallClubArrayList.get(i).setDate(date);
                if (footBallClubArrayList.get(i).getSportsClubName().equals(clubName2)) {
                    points = points + 2;
                    goalsScored = ans1 * 2;
                    footBallClubArrayList.get(i).setNumOfGoalsScored(goalsScored);
                    footBallClubArrayList.get(i).setNumOfDrwas();
                    footBallClubArrayList.get(i).setNumOfPoints(points);
                    footBallClubArrayList.get(i).setNumOfMatchesPlayed();
                    footBallClubArrayList.get(i).setNumOfGoalsRecieved(ans2);



                } else if (footBallClubArrayList.get(i).getSportsClubName().equals(clubName1)) {
                    points = points + 2;
                    goalsScored = ans2 * 2;
                    footBallClubArrayList.get(i).setNumOfGoalsScored(goalsScored);
                    footBallClubArrayList.get(i).setNumOfDrwas();
                    footBallClubArrayList.get(i).setNumOfMatchesPlayed();
                    footBallClubArrayList.get(i).setNumOfPoints(points);
                    footBallClubArrayList.get(i).setNumOfGoalsRecieved(ans1);



                }
                else {
                    System.out.println("The team you entered not in premier league");
                }
                playedMatchesArrayList.add(new PlayedMatches(clubName1,clubName2,ans1,ans2,date));
            }


        }

    }






    public void openGUI() {
        if (window != null) {
            window.showAndWait();
        } else  {
            buildGUI();
            openGUI();
        }
    }



    public void buildGUI() {

        window = new Stage();
        Image footBall=new Image("FB.jpg");
        ImageView footBallView = new ImageView();
        footBallView.setImage(footBall);
        footBallView.setFitHeight(500);
        footBallView.setFitWidth(1300);


        Label label1 = new Label("Search ");
        label1.setStyle("-fx-font-size: 25px;  -fx-font-weight : bold ; -fx-pref-height: 20px; -fx-pref-width : 150px");
        TextField txt_search = new TextField();
        Button matchbutton = new Button("Match");
        matchbutton.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-background-color : #398c15; -fx-font-weight : bold ; -fx-pref-height: 20px; -fx-pref-width : 200px");
        Button playedMatchesButton = new Button("Played Match");
        playedMatchesButton.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-background-color : #398c15; -fx-font-weight : bold ; -fx-pref-height: 20px; -fx-pref-width : 200px");
        Button sortByGoalsScoredButton = new Button("Sort By Goals Scored");
        sortByGoalsScoredButton.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-background-color : #398c15; -fx-font-weight : bold ; -fx-pref-height: 20px; -fx-pref-width : 230px");

        sortByGoalsScoredButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Collections.sort(footBallClubArrayList,FootBallClub.sortByGoalsScored);
                filter("");
            }
        });
        Button sortByWins= new Button("Sort By Wins");
        sortByWins.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-background-color : #398c15; -fx-font-weight : bold ; -fx-pref-height: 20px; -fx-pref-width : 200px");

        sortByWins.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Collections.sort(footBallClubArrayList,FootBallClub.sortByWins);
                filter("");
            }
        });



        HBox hb = new HBox();
        hb.getChildren().addAll(label1, txt_search, matchbutton, playedMatchesButton,sortByGoalsScoredButton,sortByWins);
        hb.setSpacing(10);
        TableColumn columnSportClubName, columnClubLocation, columnNoOfWins, columnNoOfDefeats, columnNoOfDraws, columnNumOfPlayedMatches, columnNumOfGoalsRecieved, columnNumOfGoalsScored, columnNumOfPoints, columnDate;


        columnSportClubName = new TableColumn("Sport Club Name");
        columnSportClubName.setCellValueFactory(new PropertyValueFactory<>("sportsClubName"));

        columnClubLocation = new TableColumn("Location");
        columnClubLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

        columnNoOfWins = new TableColumn("Wins");
        columnNoOfWins.setCellValueFactory(new PropertyValueFactory<>("NumOfWins"));

        columnNoOfDefeats = new TableColumn("Defeats");
        columnNoOfDefeats.setCellValueFactory(new PropertyValueFactory<>("NumOfDefeats"));

        columnNoOfDraws = new TableColumn("Draws");
        columnNoOfDraws.setCellValueFactory(new PropertyValueFactory<>("NumOfDrwas"));

        columnNumOfPlayedMatches = new TableColumn("Played matches");
        columnNumOfPlayedMatches.setCellValueFactory(new PropertyValueFactory<>("NumOfMatchesPlayed"));

        columnNumOfGoalsRecieved = new TableColumn("Goals Recieved");
        columnNumOfGoalsRecieved.setCellValueFactory(new PropertyValueFactory<>("NumOfGoalsRecieved"));

        columnNumOfGoalsScored = new TableColumn("Goals Scored");
        columnNumOfGoalsScored.setCellValueFactory(new PropertyValueFactory<>("NumOfGoalsScored"));

        columnNumOfPoints = new TableColumn("Points");
        columnNumOfPoints.setCellValueFactory(new PropertyValueFactory<>("NumOfPoints"));



        tableView.getColumns().addAll(columnSportClubName, columnClubLocation, columnNoOfWins, columnNoOfDefeats, columnNoOfDraws, columnNumOfPlayedMatches, columnNumOfGoalsRecieved, columnNumOfGoalsScored, columnNumOfPoints);
        tableView.setMinWidth(900);

        txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filter(newValue);
        });
        filter("");
        VBox vbox0 = new VBox(hb, tableView);
        vbox0.setSpacing(25);
        vbox0.setAlignment(Pos.CENTER);
        vbox0.setPadding(new Insets(10));
        Pane rock= new Pane();
        rock.getChildren().addAll(footBallView,vbox0);
        Scene scene0 = new Scene(rock, 1300, 500);
        window.setScene(scene0);

        Image footBall1 = new Image("FB.jpg");
        ImageView footBallView1 = new ImageView();
        footBallView1.setImage(footBall1);
        footBallView1.setFitHeight(500);
        footBallView1.setFitWidth(1300);


        Label label2 = new Label("Search ");
        label2.setStyle("-fx-font-size: 25px;  -fx-font-weight : bold ; -fx-pref-height: 20px; -fx-pref-width : 150px");
        TextField txt_search1 = new TextField();
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-background-color : #398c15; -fx-font-weight : bold ; -fx-pref-height: 20px; -fx-pref-width : 200px");

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(label2,txt_search1,backButton);
        hb2.setSpacing(10);

        TableColumn columnName1,columnName2,columnScore,columnScore2,columnDate1;

        columnName1 = new TableColumn("Club Name 1");
        columnName1.setCellValueFactory(new PropertyValueFactory<>("Name1"));

        columnName2=new TableColumn("Club Name 2");
        columnName2.setCellValueFactory(new PropertyValueFactory<>("Name2"));

        columnScore = new TableColumn("Score1");
        columnScore.setCellValueFactory(new PropertyValueFactory<>("score1"));

        columnScore2 = new TableColumn("Score2");
        columnScore2.setCellValueFactory(new PropertyValueFactory<>("score2"));

        columnDate1 = new TableColumn("Date");
        columnDate1.setCellValueFactory(new PropertyValueFactory<>("Date1"));

        tableView1.getColumns().addAll(columnName1,columnName2,columnScore,columnScore2,columnDate1);
        tableView1.setMinWidth(900);

        txt_search1.textProperty().addListener((observable, oldValue, newValue) -> {
            filter(newValue);
        });

        VBox vbox1 = new VBox(hb2, tableView1);
        vbox1.setSpacing(25);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setPadding(new Insets(10));
        Pane rock2 = new Pane();
        rock2.getChildren().addAll(footBallView1,vbox1);
        Scene scene1 = new Scene(rock2, 1000, 500);
        window.setScene(scene1);




        matchbutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    Collections.sort(footBallClubArrayList);

                    Random random = new Random();
                    Date date;
                    int no1 = 0;
                    int no2 = 0;
                    int count = footBallClubArrayList.size();

                    int num1 = random.nextInt(count);
                    int num2 = random.nextInt(count);
                    while (num1==num2){
                        num1=random.nextInt(count);
                    }
                    if (num1 != num2) {
                        Random rand = new Random();
                        no1 = rand.nextInt(100);
                        no2 = rand.nextInt(100);
                    }
                    String club = footBallClubArrayList.get(num1).getSportsClubName();
                    String club2 = footBallClubArrayList.get(num2).getSportsClubName();
                    Random randDate = new Random();
                    date = new Date();
                    date.setYear(randDate.nextInt(2500));
                    date.setMonth(randDate.nextInt(12));
                    date.setDate(randDate.nextInt(31));


                    addmatch(club, club2, no1, no2,date );

                    try {
                        saveData("output.txt","output1.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Collections.sort(footBallClubArrayList);
                    filter("");

            }



        }
        );

        playedMatchesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(scene1);

            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(scene0);
            }
        });
    }



    private static void filter(String keyword){
        tableView.getItems().clear();
        tableView1.getItems().clear();

        for(int i=0;i<footBallClubArrayList.size();i++){
            Row row= new Row();
            row.setSportsClubName(footBallClubArrayList.get(i).getSportsClubName());
            row.setLocation(footBallClubArrayList.get(i).getLocation());
            row.setNumOfWins(footBallClubArrayList.get(i).getNumOfWins());
            row.setNumOfDefeats(footBallClubArrayList.get(i).getNumOfDefeats());
            row.setNumOfDrwas(footBallClubArrayList.get(i).getNumOfDrwas());
            row.setNumOfMatchesPlayed(footBallClubArrayList.get(i).getNumOfMatchesPlayed());
            row.setNumOfGoalsRecieved(footBallClubArrayList.get(i).getNumOfGoalsRecieved());
            row.setNumOfGoalsScored(footBallClubArrayList.get(i).getNumOfGoalsScored());
            row.setNumOfPoints(footBallClubArrayList.get(i).getNumOfPoints());

            if(keyword.isEmpty() || footBallClubArrayList.get(i).getSportsClubName().toLowerCase().contains(keyword.toLowerCase()) ){
                tableView.getItems().add(row);

            }
        }
        for (int i=0; i<playedMatchesArrayList.size();i++){
            Row row1 = new Row();
            row1.setName1(playedMatchesArrayList.get(i).getClubName1());
            row1.setName2(playedMatchesArrayList.get(i).getClubName2());
            row1.setScore1(playedMatchesArrayList.get(i).getScore1());
            row1.setScore2(playedMatchesArrayList.get(i).getScore2());
            row1.setDate1(playedMatchesArrayList.get(i).getDate());

            if(keyword.isEmpty() || playedMatchesArrayList.get(i).getDate().toString().contains(keyword)) {
                tableView1.getItems().add(row1);

            }

        }

    }




    @Override
    public void saveData(String fileName1,String fileName2) throws IOException {

            FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (FootBallClub footBallClub : footBallClubArrayList) {
                objectOutputStream.writeObject(footBallClub);
            }
            FileOutputStream fileOutputStream1 = new FileOutputStream(fileName2);
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
            for (PlayedMatches playedMatches : playedMatchesArrayList){
                objectOutputStream1.writeObject(playedMatches);
            }

            System.out.println("!!!!!Saved !!!!!");
            objectOutputStream.flush();
            fileOutputStream.close();
            objectOutputStream.close();
            objectOutputStream1.flush();
            fileOutputStream1.close();
            objectOutputStream1.close();

    }

    @Override
    public void retriveData() throws IOException, ClassNotFoundException {
        File file = new File("output.txt");
        File file1 = new File("output1.txt");
        if (file.exists() && file1.exists()) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            FileInputStream fileInputStream1 = new FileInputStream(file1);
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
            for (; ; ) {
                try {
                    FootBallClub footBallClub = (FootBallClub) objectInputStream.readObject();
                    footBallClubArrayList.add(footBallClub);
                } catch (EOFException e) {
                    objectInputStream.close();
                    break;
                }
            }

            for (; ; ) {
                try {
                    PlayedMatches playedMatches = (PlayedMatches) objectInputStream1.readObject();
                    playedMatchesArrayList.add(playedMatches);

                } catch (EOFException | ClassNotFoundException e) {
                    objectInputStream1.close();
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        } else if (!file.exists() && file1.exists()) {
            file.createNewFile();
            file1.createNewFile();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        try {
            retriveData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        scanner= new Scanner(System.in);
        tableView = new TableView();
        tableView1=new TableView();
        int answer=0 ;

        while (answer != 8) {
            System.out.println("> 1. Add new sport club");
            System.out.println("> 2. Delete a sport club");
            System.out.println("> 3. Display table");
            System.out.println("> 4. Display status");
            System.out.println("> 5. Enter status");
            System.out.println("> 6. Save data");
            System.out.println("> 7. GUI");
            System.out.println("> 8. Exit");

            System.out.println("Enter your answer:");
            answer= inputValidation();
            switch (answer) {
                case 1: {
                    addNewFootBallClub();
                    break;
                }
                case 2: {
                    deleteFootBallClub();
                    break;
                }
                case 3: {
                    displayTable();
                    break;
                }
                case 4: {
                    Statistic();
                    break;
                }
                case 5: {
                    enterStatus();
                    break;
                }
                case 6: {
                    try {
                        saveData("output.txt","output1.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 7: {
                    openGUI();
                    break;
                }
                case 8: {
                    System.out.println("> Thank You!");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("> !!!!! Try again !!!!!");

            }

        }

    }

    private static int inputValidation() {
        while (!scanner .hasNextInt()) {
            System.out.println("!!!!!! Invalid Input Type !!!!!! ");
            scanner.next();
        }
        return scanner.nextInt();
    }




}
