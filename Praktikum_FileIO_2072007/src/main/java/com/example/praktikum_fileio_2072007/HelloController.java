package com.example.praktikum_fileio_2072007;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloController {
    public TextArea txt;
    public Path p;
    public void Open(ActionEvent actionEvent) throws IOException {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Text Documents", "*.txt");
        chooser.getExtensionFilters().add(extensionFilter);
        chooser.setSelectedExtensionFilter(extensionFilter);
        File f = chooser.showOpenDialog(txt.getScene().getWindow());

        if(f != null){
            p = Paths.get(f.toURI());
            String file = Files.readString(p);
            txt.setText(file);
        }
    }

    public void SaveAs() throws IOException {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Text Documents", "*.txt");
        chooser.getExtensionFilters().add(extensionFilter);
        chooser.setSelectedExtensionFilter(extensionFilter);
        File f = chooser.showSaveDialog(txt.getScene().getWindow());

        if(f != null) {
            p = Paths.get(f.toURI());
            Files.write(p,txt.getText().getBytes());
        }
    }

    public void Save(ActionEvent actionEvent) throws IOException {
        if(p == null) {
            SaveAs();
        } else {
            Files.write(p,txt.getText().getBytes());
        }

    }
}