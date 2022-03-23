package com.fabiomalves.treinoJavaFX;

import com.fabiomalves.treinoJavaFX.inicio.ControllerInicio;
import com.fabiomalves.treinoJavaFX.util.MyUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Aplicativo extends Application {
    ScrollPane parentInicio;
    Scene scenePrincipal;
    static Stage stagePrincipal;
    FXMLLoader loaderPrincipal;
    ControllerInicio controllerInicio;

    public void start (Stage primaryStage) {
        stagePrincipal = primaryStage;
        Font.loadFont(this.getClass().getResource("/com/fabiomalves/treinoJavaFX/standard/Bebas-Regular.ttf").toExternalForm(), 20);
        Font.loadFont(this.getClass().getResource("/com/fabiomalves/treinoJavaFX/standard/Dinomouse-Regular.otf").toExternalForm(), 10);
        Font.loadFont(this.getClass().getResource("/com/fabiomalves/treinoJavaFX/standard/Curse-Casual.ttf").toExternalForm(), 10);
        carregaTelaInicialeApresenta();

    }
    private void carregaTelaInicialeApresenta() {
        loaderPrincipal = MyUtil.FXML_loader(Views.INICIO);
        parentInicio = (ScrollPane)MyUtil.FXML_load(loaderPrincipal);
        scenePrincipal = new Scene(parentInicio);
        stagePrincipal.setScene(scenePrincipal);
        stagePrincipal.show();
//        controllerInicio = loaderPrincipal.getController(); // Pega o controller da tela inicial.
    }

    public static Stage getStagePrincipal () {
        return stagePrincipal;
    }
    public static void main (String[] args) {
        launch (args);
    }
}
