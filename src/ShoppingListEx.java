import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class ShoppingListEx implements Initializable {

    @FXML
    private Button AddButton;

    @FXML
    private Button LoadButton;

    @FXML
    private Button SaveButton;

    @FXML
    private TextField textfield;

    @FXML
    private Button RemoveButton;

    @FXML
    private ListView<String> listview;

      ObservableList<String> items;
      ObservableList<String> lists = FXCollections.observableArrayList();
      
      
      @Override 
      
      public void initialize(URL location, ResourceBundle resources) {
      listview.setItems(lists);  
      listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

                                                                     }

    @FXML
    void AddListener(ActionEvent event) {
    
     
    String text = textfield.getText();
    text = text.trim();
    text = text.toLowerCase();
    lists.add(text);
    textfield.setText("");
      }
    

    @FXML
    void RemoveListener(ActionEvent event) {
    try{ 
       
        final int selectedIdx = listview.getSelectionModel().getSelectedIndex();
        if (selectedIdx >= -1) {
        final int newSelectedIdx = (selectedIdx == listview.getItems().size() - 1)
        ? selectedIdx - 1: selectedIdx;
        listview.getItems().remove(selectedIdx);
        listview.getSelectionModel().select(newSelectedIdx);
        }
                                           
        }catch (Exception ex) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText("Error");
         alert.setContentText("Select something to remove");
         alert.showAndWait();
         } 
         }         
                                            

    @FXML
    void SaveListener(ActionEvent event) {
    try {
         File file = new File("list.txt");
         if(!file.exists()) {
         file.createNewFile();
         }

         PrintWriter pw = new PrintWriter(file);
         items = listview.getItems();
         for(String i : items) {
         pw.println(i);
         }
         pw.close();
         
         
         {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText("Update");
         alert.setContentText("Data File Saved");
         alert.showAndWait();
         }                  ;
         }catch (Exception ex)
      {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText("Error");
         alert.setContentText("Error Saving Data File");
         alert.showAndWait();
         }                                          }

    @FXML
    void LoadListener(ActionEvent event) throws IOException{
      File file = new File("list.txt");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line;
      while((line = br.readLine()) != null) {
      listview.getItems().add(line);      }
      br.close();
      fr.close();
      }
      }    