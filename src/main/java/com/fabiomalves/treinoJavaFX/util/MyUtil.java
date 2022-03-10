package com.fabiomalves.treinoJavaFX.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;

import com.fabiomalves.treinoJavaFX.FxmlCriado;

public class MyUtil {

    private static String pathTreinoJavaFX = "/com/fabiomalves/treinoJavaFX/";

    public static FXMLLoader FXML_loader (FxmlCriado fxmlCriado) {
        URL url = FxmlCriado.class.getResource(pathTreinoJavaFX+fxmlCriado.getPathFxml());
        return new FXMLLoader(FxmlCriado.class.getResource(pathTreinoJavaFX+fxmlCriado.getPathFxml()));
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

    public static Parent FXML_load (FxmlCriado fxmlCriado) {
        try {
            FXMLLoader loader = new FXMLLoader(FxmlCriado.class.getResource(pathTreinoJavaFX+fxmlCriado.getPathFxml()));
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
}
