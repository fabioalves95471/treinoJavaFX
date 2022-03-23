package com.fabiomalves.treinoJavaFX.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;

import com.fabiomalves.treinoJavaFX.Views;

public class MyUtil {

    private static String pathTreinoJavaFX = "/com/fabiomalves/treinoJavaFX/";

    public static FXMLLoader FXML_loader (Views views) {
        URL url = Views.class.getResource(pathTreinoJavaFX+ views.getPathFxml());
        return new FXMLLoader(Views.class.getResource(pathTreinoJavaFX+ views.getPathFxml()));
    }

    public static Parent FXML_load (FXMLLoader loader) {
        try {
            Parent parent = loader.load();
            return parent;
        } catch (IOException e) {
            e.printStackTrace();
			System.exit(0);
            return null;
        }

    }

    public static Parent FXML_load (Views views) {
        try {
            FXMLLoader loader = new FXMLLoader(Views.class.getResource(pathTreinoJavaFX+ views.getPathFxml()));
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
}
