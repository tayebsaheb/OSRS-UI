package sample;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.scene.control.TextField;

public class testController {
//hi

    @FXML
    private Button Hiscores;

    @FXML
    private TextField geSearch;

    @FXML
    private Label Price;









    Items item = new Items();



    public void search() throws MalformedURLException, IOException {
        BufferedReader br = null;

        String itemName = geSearch.getText();
        item.setName(itemName);
        item.test();
        findID();

        System.out.println("MAde it");
        System.out.println(item.getId());
        if(item.getId().equalsIgnoreCase(""))
            Price.setText("Item not found");
        else {
            String u = "http://services.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=" + item.getId();
            URL url = new URL(u);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = "";

            line = br.readLine();
            String lineSplit;

            String result = line.substring(line.indexOf(",\"price\":") + 9, line.indexOf("},\"today\""));
            if (result.contains("\"")) {
                result = result.substring(1, result.length() - 1);
            }
            Price.setText(result);
        }
    }


    public void findID() throws IOException{
        int counter = 0;

        BufferedReader br = null;
        try {
            String u = "https://pastebin.com/raw/LhxJ7GRG";
            URL url = new URL(u);

            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";

            String next;
            while ((line = br.readLine()) != null) {

                if(counter >= 2) {

                        next = br.readLine();


                        System.out.println("Current Line: " + line);
                        System.out.println("Next Line: " + next);
                        String tester = "";

                        System.out.println(counter);
                        tester = next.substring(next.indexOf(": \"") + 3, next.length() - 1);




                        if (geSearch.getText().equalsIgnoreCase(tester)) {
                            item.setName(geSearch.getText());
                            item.setId(line.substring(line.indexOf(": ") + 2, line.length() - 1));

                            break;
                        }

                }

                item.setId("");
                Price.setText("");
                if (counter >= 6021)
                    break;
                counter++;

                    }


        }
        catch (MalformedURLException e) {
            System.out.println("Error");

        }



    }
    public void changeScene() throws Exception{
        Stage primaryStage = (Stage) Hiscores.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 500, 600));
        primaryStage.show();

    }




}
