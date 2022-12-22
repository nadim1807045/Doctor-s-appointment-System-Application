import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Load extends Application {
   public static void main(String[] args) {
        launch(args);
    }
  public void start (Stage stage) throws Exception{
      WebView myWebView = new WebView();
      final WebEngine engine = myWebView.getEngine();
       engine.load("https://bddoctorlist.com/");
      Button btn = new Button("HEALTH  TIPS!!!");
      btn.setOnAction(new EventHandler<ActionEvent>(){
      
     public void handle(ActionEvent event){
          engine.load("https://bengali.boldsky.com/health/"); }
      });
       Button btn1 = new Button("BACK!!!");
      btn1.setOnAction(new EventHandler<ActionEvent>(){
      
     public void handle(ActionEvent event){
          engine.load("https://bddoctorlist.com/"); }
      });
       Button btn2 = new Button("VIEW MEDICINE!!!");
      btn2.setOnAction(new EventHandler<ActionEvent>(){
      
     public void handle(ActionEvent event){
          engine.load("https://medex.com.bd/generics#"); }
      });
 
      VBox root = new VBox();
      root.getChildren().addAll(myWebView,btn,btn1,btn2);
      
      Scene scene = new Scene(root,800, 700);
      stage.setScene(scene);
      
      stage.show();
  }   
}
