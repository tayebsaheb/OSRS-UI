package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Controller {

    @FXML
    private TextField Username;

    @FXML
    private Button Poop;


    @FXML
    private Label Attack;
    @FXML
    private Label Defence;
    @FXML
    private Label Strength;
    @FXML
    private Label Range;
    @FXML
    private Label Prayer;
    @FXML
    private Label Magic;
    @FXML
    private Label Runecrafting;
    @FXML
    private Label Con;
    @FXML
    private Label Health;
    @FXML
    private Label Agility;
    @FXML
    private Label Herblore;
    @FXML
    private Label Thieving;
    @FXML
    private Label Crafting;
    @FXML
    private Label Fletching;
    @FXML
    private Label Slayer;
    @FXML
    private Label Hunter;
    @FXML
    private Label Mining;
    @FXML
    private Label Smithing;
    @FXML
    private Label Woodcutting;
    @FXML
    private Label Fishing;
    @FXML
    private Label Cooking;
    @FXML
    private Label Firemaking;
    @FXML
    private Label Farming;
    @FXML
    private Label Total;
    @FXML
    AnchorPane apMain;



    public void searchUser() throws MalformedURLException, IOException {

        BufferedReader br = null;

        try {
            String user = Username.getText();
            String u = "https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player="+user;
            URL url = new URL(u);

            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";

            int counter = 0 ;

            while ((line = br.readLine()) != null) {


                    String[] Skill = line.split(",");
                    System.out.println(Skill[1]);


                    switch (counter){
                        case 0: Total.setText(Skill[1]);
                                break;
                        case 1: Attack.setText(Skill[1]);
                                break;
                        case 2: Defence.setText(Skill[1]);
                            break;
                        case 3: Strength.setText(Skill[1]);
                            break;
                        case 4: Health.setText(Skill[1]);
                            break;
                        case 5: Range.setText(Skill[1]);
                            break;
                        case 6: Prayer.setText(Skill[1]);
                            break;
                        case 7: Magic.setText(Skill[1]);
                            break;
                        case 8: Cooking.setText(Skill[1]);
                            break;
                        case 9: Woodcutting.setText(Skill[1]);
                            break;
                        case 10: Fletching.setText(Skill[1]);
                            break;
                        case 11: Fishing.setText(Skill[1]);
                            break;
                        case 12: Firemaking.setText(Skill[1]);
                            break;
                        case 13: Crafting.setText(Skill[1]);
                            break;
                        case 14: Smithing.setText(Skill[1]);
                            break;
                        case 15: Mining.setText(Skill[1]);
                            break;
                        case 16: Herblore.setText(Skill[1]);
                            break;
                        case 17: Agility.setText(Skill[1]);
                            break;
                        case 18: Thieving.setText(Skill[1]);
                            break;
                        case 19: Slayer.setText(Skill[1]);
                            break;
                        case 20: Farming.setText(Skill[1]);
                            break;
                        case 21: Runecrafting.setText(Skill[1]);
                            break;
                        case 22: Hunter.setText(Skill[1]);
                            break;
                        case 23: Con.setText(Skill[1]);
                            break;





                }

                if(counter == 23)
                    break;

                counter++;
            }






        } catch (MalformedURLException e) {
            System.out.println("Error");
        }


       //Attack.setText(Username.getText());
    }





    public void Poop() throws Exception{
       Stage primaryStage = (Stage) Poop.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
        System.out.println("done");
        primaryStage.setTitle("Old School Runescape Grand Exchange Search");
        primaryStage.setScene(new Scene(root, 375, 250));
        primaryStage.show();

        System.out.println("switched");
    }



}
