package com.devmate.registro;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public void start(Stage stage) throws IOException {

        //Etiqueta para nombre
        Label nameLabel=new Label("Nombre");

        //Campo de texto para el nombre
        TextField nameText=new TextField();

        //Fecha de nacimiento
        Label dobLabel=new Label("Nacimiento");

        //seleccionar la fecha
        DatePicker datePicker=new DatePicker();

        //etiqueta par el genero
        Label genderLabel=new Label("Género");

        //boton de opccion
        ToggleGroup groupGender=new ToggleGroup();
        RadioButton maleRadio=new RadioButton("Hombre");
        maleRadio.setToggleGroup(groupGender);
        RadioButton femaleRadio=new RadioButton("Mujer");
        femaleRadio.setToggleGroup(groupGender);

        //tecnologias conocidas
        Label technologiesLabel=new Label("Tecnologías Conocidas");

        //educacion
        CheckBox javaCheckBox=new CheckBox("Java");
        CheckBox dotnetCheckBox=new CheckBox("Python");

        //etiqueta para la educion
        Label educationLabel=new Label("Educación");

        //calificacion
        ListView eduList=new ListView();
        ObservableList<String> data= FXCollections.observableArrayList();
        data.addAll("Licenciatura","Bachillerato","Maestría","Doctorado");
        eduList.setItems(data);
        eduList.setPrefSize(100,100);

        //ubicacion
        Label locationLabel=new Label("Localidad");

        //cuadro para seleccionar la ubicacion
        ChoiceBox<String> locationChoiceBox=new ChoiceBox<>();
        locationChoiceBox.getItems().addAll(
                "Jutiapa","Quesada","Pajarita","Moyuta","Agua Blanca"
        );

        //etiqueta de registro
        Button buttonRegister=new Button("Registrar");
        Button buttonClear=new Button("Limpiar");

        //panel de cuadricula
        GridPane gridPane=new GridPane();

        //tamaño
        gridPane.setMinSize(500,300);

        //relleno
        gridPane.setPadding(new Insets(10,10,10,10));

        //es pacios verticales y horizontales entre las columnas
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //alineacion de la cuadricula
        gridPane.setAlignment(Pos.CENTER);

        //organizar los nodos
        gridPane.add(nameLabel,0,0);
        gridPane.add(nameText,1,0);

        gridPane.add(dobLabel,0,1);
        gridPane.add(datePicker,1,1);

        gridPane.add(genderLabel,0,2);
        gridPane.add(maleRadio,1,2);
        gridPane.add(femaleRadio,2,2);

        gridPane.add(technologiesLabel,0,3);
        gridPane.add(javaCheckBox,1,3);
        gridPane.add(dotnetCheckBox,2,3);

        gridPane.add(educationLabel,0,4);
        gridPane.add(eduList,1,4);

        gridPane.add(locationLabel,0,5);
        gridPane.add(locationChoiceBox,1,5);

        gridPane.add(buttonClear,0,7);
        gridPane.add(buttonRegister,1,7);

        //estilo a los nodos
        buttonRegister.setStyle(
                "-fx-background-color:rgba(103,235,250,0.75); -fx-text-fill: #000000;"
        );
        buttonClear.setStyle(
                "-fx-background-color:rgba(206,151,251,0.75); -fx-text-fill: #000000;"
        );
        nameLabel.setStyle("-fx-font:normal bold 15px 'serif' ");
        dobLabel.setStyle("-fx-font:normal bold 15px 'serif' ");
        genderLabel.setStyle("-fx-font:normal bold 15px 'serif' ");
        technologiesLabel.setStyle("-fx-font:normal bold 15px 'serif' ");
        educationLabel.setStyle("-fx-font:normal bold 15px 'serif' ");
        locationLabel.setStyle("-fx-font:normal bold 15px 'serif' ");

        //color de fondo
        gridPane.setStyle("-fx-background-color:rgba(135,253,212,0.3);");

        //accion para el boton de borrar
        buttonClear.setOnAction(event -> {
            nameText.clear();
            datePicker.setValue(null);
            groupGender.selectToggle(null);
            javaCheckBox.setSelected(false);
            dotnetCheckBox.setSelected(false);
            eduList.getSelectionModel().clearSelection();
            locationChoiceBox.getSelectionModel().clearSelection();
        });

        //accion para el boton registrar
        buttonRegister.setOnAction(event -> {
            String nombre = nameText.getText();
            String nacimiento = datePicker.getValue().toString();
            String genero = maleRadio.isSelected() ? "Hombre" : "Mujer";
            String tecnologias = "";
            if (javaCheckBox.isSelected()) {
                tecnologias += "Java ";
            }
            if (dotnetCheckBox.isSelected()) {
                tecnologias += "Python ";
            }
            String educacion = (String) eduList.getSelectionModel().getSelectedItem();
            String localidad = locationChoiceBox.getSelectionModel().getSelectedItem();

            // Aquí podrías realizar alguna acción con los datos, como almacenarlos en una base de datos.
            System.out.println("Registro:\n" +
                    "Nombre: " + nombre + "\n" +
                    "Nacimiento: " + nacimiento + "\n" +
                    "Género: " + genero + "\n" +
                    "Tecnologías: " + tecnologias + "\n" +
                    "Educación: " + educacion + "\n" +
                    "Localidad: " + localidad);
        });

        //creando
        Scene scene=new Scene(gridPane);


        stage.setTitle("Formulario de Registro");

        //estabelcer titulo
        stage.setScene(scene);

        //mostrando el contenido
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}