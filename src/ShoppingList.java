import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ShoppingList extends Application {

@Override

public void start(Stage primaryStage) {

try {

         Parent root = FXMLLoader.load(getClass().getResource("Shop.fxml"));
         Scene scene = new Scene(root);
         primaryStage.setScene(scene);
         primaryStage.setResizable(false);
         primaryStage.show();
         } catch(Exception e) {
         e.printStackTrace();
                        }
                                        }

public static void main(String[] args) {
   launch(args);
   }

}