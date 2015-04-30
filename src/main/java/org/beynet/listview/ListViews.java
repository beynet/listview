package org.beynet.listview;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Optional;

public class ListViews extends Application {
    public static void main(String ... args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.currentStage = primaryStage;
        this.persons = new ListView<>();

        //define the cell factory
        this.persons.setCellFactory(param -> {
            return new PersonCell();
        });

        // associate the listview with a custom observable list
        this.persons.setItems(FXCollections.observableArrayList(param -> new Observable[]{param.firstNameProperty(),param.lastNameProperty()} ) );


        //une hbox pour tous nos futurs bouttons
        HBox buttonsbox = new HBox();
        // this button will add a new person
        Button addPerson = new Button("aj. person");
        addPerson.setOnAction(event -> {
            TextInputDialog askForName = new TextInputDialog();
            askForName.setContentText("new person name");
            Optional<String> result=askForName.showAndWait();
            result.ifPresent((name)->{
                String[] names=name.split(" ");
                if (names.length==2) {
                    persons.getItems().add(new Person(names[0],names[1]));
                }
            });
        });
        //this button will permute the selected person name and first name
        Button permut = new Button("permut");
        permut.setOnAction(event -> {
            Person selected = this.persons.getSelectionModel().getSelectedItem();
            if (selected!=null) {
                selected.permutFirstNameAndLastName();
            }
        });

        buttonsbox.getChildren().addAll(addPerson,permut);

        // premier empilement vertical
        VBox vbox = new VBox();
        vbox.getChildren().add(persons);
        vbox.getChildren().add(buttonsbox);


        persons.getItems().add(new Person("John", "Doe"));
        persons.getItems().add(new Person("MyNameIs", "Person"));

        Group group = new Group();
        group.getChildren().add(vbox);


        currentScene = new Scene(group, 300, 200);
        currentStage.setScene(currentScene);
        currentStage.show();

        persons.setPrefHeight(currentScene.getHeight() - 50);
    }


    private static Stage currentStage;
    private static Scene currentScene;
    private static ListView<Person> persons;

}