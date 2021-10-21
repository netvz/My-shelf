package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;

import static sample.Menu.productPage;

public class ProductPage implements Initializable {


    @FXML
    public Button backButton, sb, delbutton;
    @FXML
    private TextArea displayProducts;

    File myFolder = new File("./");
    File[] listOfFiles = myFolder.listFiles((file, name) -> name.endsWith(".txt"));
    String fileName, line = null;
    BufferedReader br;


    public void gotomenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sample.fxml"));
        Parent root = fxmlLoader.load();
        productPage.close();
    }

    public void searchbutton(ActionEvent actionEvent) {
        for (File eachFile : listOfFiles) {
            if (eachFile.isFile()) {
                try {
                    fileName = eachFile.getAbsolutePath();
                    br = new BufferedReader(new FileReader(fileName));
                    try {
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                            displayProducts.setText(displayProducts.getText() + line+ "\n");
                        }displayProducts.setText(displayProducts.getText() + "\n");
                    } catch (IOException ex) {
                        Logger.getLogger(ProductPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ProductPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }

        public void deleteButton (ActionEvent event){
            FileChooser productDel = new FileChooser();
            productDel.setTitle("Delete product");
            List<File> selectedFiles = productDel.showOpenMultipleDialog(null);
            if (selectedFiles != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Do you want to delete this file?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    for (File selectedFile : selectedFiles) {
                        selectedFile.delete();
                    }
                }
            } else {
                System.out.println("Error while deleting");
            }
        }

            @Override
            public void initialize (URL url, ResourceBundle resourceBundle){

            }
}





