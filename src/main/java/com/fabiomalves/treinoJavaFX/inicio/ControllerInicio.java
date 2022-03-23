package com.fabiomalves.treinoJavaFX.inicio;

import com.fabiomalves.treinoJavaFX.Aplicativo;
import com.fabiomalves.treinoJavaFX.aplicativosCriados.flutuante.Flutuante;
import com.fabiomalves.treinoJavaFX.aplicativosCriados.testeStage.TesteStage;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerInicio {

    Stage stageAplications;
    @FXML
    Button bFlutuante;
    @FXML
    Button bRegex;
    @FXML
    Button bTesteStage;

    public ControllerInicio () {
        // Carrega o stageAplications.
        stageAplications = new Stage();
        stageAplications.initModality(Modality.APPLICATION_MODAL);
        stageAplications.initOwner(Aplicativo.getStagePrincipal());
    }
    
    @FXML
    private void bFlutuanteEventAction () {
        new Flutuante().start(stageAplications);
    }
    @FXML
    private void bFlutuanteEventKey (KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            if(ke.getEventType().equals(KeyEvent.KEY_PRESSED))
                bFlutuante.pseudoClassStateChanged(PseudoClass.getPseudoClass("armed"), true);
            if(ke.getEventType().equals(KeyEvent.KEY_RELEASED)){
                bFlutuante.pseudoClassStateChanged(PseudoClass.getPseudoClass("armed"), false);
                bFlutuanteEventAction();
            }
        }
        if (ke.getCode().equals(KeyCode.SPACE) && ke.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            bFlutuanteEventAction();
        }
    }
    @FXML
    private void bRegexEventAction () {
        try {
            Parent parent = FXMLLoader.load(this.getClass().getResource("/com/fabiomalves/treinoJavaFX/aplicativosCriados/regex/regex.fxml"));
            Scene sceneRegex = new Scene(parent);
            stageAplications.setScene(sceneRegex);
            stageAplications.show();         
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.print(ioe.getMessage());
            System.out.println("Não Funcionou");
        }
    }
    @FXML
    private void bRegexEventKey (KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            if(ke.getEventType().equals(KeyEvent.KEY_PRESSED))
                bRegex.pseudoClassStateChanged(PseudoClass.getPseudoClass("armed"), true);
            if(ke.getEventType().equals(KeyEvent.KEY_RELEASED)){
                bRegex.pseudoClassStateChanged(PseudoClass.getPseudoClass("armed"), false);
                bRegexEventAction();
            }
        }
        if (ke.getCode().equals(KeyCode.SPACE) && ke.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            bRegexEventAction();
        }
    }
    @FXML
    private void bTesteStageEventAction () {
        new TesteStage().start(stageAplications);
    }
    @FXML
    private void bTesteStageEventKey (KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            if(ke.getEventType().equals(KeyEvent.KEY_PRESSED))
                bFlutuante.pseudoClassStateChanged(PseudoClass.getPseudoClass("armed"), true);
            if(ke.getEventType().equals(KeyEvent.KEY_RELEASED)){
                bFlutuante.pseudoClassStateChanged(PseudoClass.getPseudoClass("armed"), false);
                bFlutuanteEventAction();
            }
        }
        if (ke.getCode().equals(KeyCode.SPACE) && ke.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            bFlutuanteEventAction();
        }
    }

}
