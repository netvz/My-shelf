package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class Menu {
    @FXML
    public Button MyProducts;
    @FXML
    public Button AddNew;

    public static Stage productPage;
    public static Stage addingPage;


    public void productpage () throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        productPage = new Stage();
        productPage.setTitle("My Products");
        productPage.setScene(new Scene(root));
        productPage.showAndWait();
        productPage.setResizable(false);
        productPage.close();

    }


public void addingpage () throws IOException {
   Parent root = FXMLLoader.load(getClass().getResource("AddingProduct.fxml"));
    addingPage = new Stage();
    addingPage.setTitle("Add new Product");
    addingPage.setScene(new Scene(root));
    addingPage.showAndWait();
    addingPage.setResizable(false);
    addingPage.close();

}

}
