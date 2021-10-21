package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import java.awt.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.scene.image.ImageView;

import static java.lang.Integer.valueOf;
import static sample.Menu.addingPage;


public  class AddingPage  implements Initializable {


    @FXML
    public TextField nameText, brandText;
    @FXML
    private Button savebutton, backbutton2;
    @FXML
    private ChoiceBox<String> choiceBox1;
    @FXML
    private ComboBox<Integer> mmchoice, rrrchoice, ddchoice;
    @FXML
    public Label typelabel, brandlabel, namelebe;
    @FXML
    private ImageView myImageView;

    private Desktop desktop = Desktop.getDesktop();
    final FileChooser fileChooser = new FileChooser();
    private String[] type = {"Cleanser", "Exfoliator", "Serum", "Face Oil", "Sunscreen","Moisturizer","Chemical Peel", "Toner","Face Mask"};
    private Integer[] mm = {valueOf("1"), valueOf("2"), valueOf("3"),valueOf("4"),valueOf("5"),valueOf("6"),valueOf("7"),valueOf("8"),valueOf("9"),valueOf("10"),valueOf("11"),valueOf("12")};
    private Integer[] dd = {valueOf("1"), valueOf("2"), valueOf("3"),valueOf("4"),valueOf("5"),valueOf("6"),valueOf("7"),valueOf("8"),valueOf("9"),valueOf("10"),valueOf("11"),valueOf("12"),valueOf("13"), valueOf("14"), valueOf("15"),valueOf("16"),valueOf("17"),valueOf("18"),valueOf("19"),valueOf("20"),valueOf("21"),valueOf("22"),valueOf("23"),valueOf("24"),valueOf("25"),valueOf("26"),valueOf("27"),valueOf("28"),valueOf("29"),valueOf("30"),valueOf("31")};
    private Integer[] rrr = {valueOf("2020"), valueOf("2021"), valueOf("2022"), valueOf("2023"), valueOf("2024"), valueOf("2025"), valueOf("2026"), valueOf("2027"), valueOf("2028"), valueOf("2029"), valueOf("2030"), valueOf("2031"), valueOf("2032"), valueOf("2033"), valueOf("2034")};

    private Window stage;

    public void gotomenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sample.fxml"));
        Parent root = fxmlLoader.load();
        addingPage.close();
    }
    public void handlesave(ActionEvent actionEvent) {
        System.out.println(nameText.getText());
        System.out.println(brandText.getText());
        String filename = nameText.getText();


        try {

            FileWriter productfile = new FileWriter(nameText.getText() + ".txt");
            productfile.write("Name: " + nameText.getText() + "\n");
            productfile.write("Brand: " + brandText.getText() + "\n");
            productfile.write("Type: " + choiceBox1.getValue() + "\n");
            productfile.write("Exp. date: " + mmchoice.getValue() + " " + ddchoice.getValue() + " " + rrrchoice.getValue());
            productfile.flush();
            productfile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Success...");
    }




        @Override
        public void initialize (URL url, ResourceBundle resourceBundle){
            choiceBox1.getItems().addAll(type);
            choiceBox1.setOnAction(this::getType);
            mmchoice.getItems().addAll(mm);
            mmchoice.setOnAction(this::getMm);
            ddchoice.getItems().addAll(dd);
            ddchoice.setOnAction(this::getDd);
            rrrchoice.getItems().addAll(rrr);
            rrrchoice.setOnAction(this::getRrr);


        }
        private void getType (ActionEvent actionEvent){
            String producttype = choiceBox1.getValue();
            System.out.println(producttype);
        }
        private void getMm (ActionEvent actionEvent){
            Integer mounth = mmchoice.getValue();
            System.out.println(mounth);

        }
        private void getDd (ActionEvent actionEvent){
            Integer day = ddchoice.getValue();
            System.out.println(day);
        }
        private void getRrr (ActionEvent actionEvent){
            Integer year = rrrchoice.getValue();
            System.out.println(year);

        }

    }
