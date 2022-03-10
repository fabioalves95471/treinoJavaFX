package com.fabiomalves.treinoJavaFX.inicio;

import com.fabiomalves.treinoJavaFX.aplicativosCriados.flutuante.Flutuante;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ControllerInicio {

    Stage stageAplications;
    @FXML
    Button bFlutuante;
    
    public void setStageAplications (Stage stageAplications) {
        this.stageAplications = stageAplications;
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


}
