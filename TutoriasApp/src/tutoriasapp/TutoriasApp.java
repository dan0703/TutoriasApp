/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoriasapp;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import uv.fei.tutorias.bussinesslogic.TutorDAO;
import uv.fei.tutorias.domain.Tutor;

/**
 *
 * @author elrevo
 */
public class TutoriasApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Get tutors");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                TutorDAO tutorDao = new TutorDAO();
                ArrayList<Tutor> tutors= (ArrayList<Tutor>) tutorDao.findTutorsByName("juan");
                for(Tutor tutor : tutors){
                    System.out.println(String.format("Tutor found: %d %s %s",tutor.getTutorId(), tutor.getName(), tutor.getLastName()));
                        
                }
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
