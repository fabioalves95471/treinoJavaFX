package com.fabiomalves.treinoJavaFX.aplicativosCriados.regex;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.apache.commons.lang.*;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.regex.*;
import java.util.ResourceBundle;


public class ControllerRegex implements Initializable {

	@FXML Label lFraseOrigem;
	@FXML Label lRegex;
	@FXML Label lResultados2;
	@FXML TextField tfFraseOrigem;
	@FXML TextField tfRegex;

	@Override
	public void initialize (URL location, ResourceBundle resources) {
		lFraseOrigem.setText("");
		lRegex.setText("");
	}
	@FXML
	void tfFraseOrigemEventKey (KeyEvent ke) {
		lFraseOrigem.setText(tfFraseOrigem.getText());
		executaRegex();
	}
	void executaRegex() {
		try {
			Pattern p = Pattern.compile(tfRegex.getText());
			Matcher m = p.matcher(lFraseOrigem.getText());
			int i = 0;
			String resultado = "";
			while (m.find()) {
				++i;
				resultado = resultado+i+": "+m.group()+"\n";
			}
			lRegex.setText(resultado);
			if (tfRegex.getText().equals("")) {
				lResultados2.setText(""+i+" (regex em branco)");
			} else {
				lResultados2.setText(""+i);
			}
		} catch (PatternSyntaxException e) {
			lResultados2.setText("#Regex Invalido");
			lRegex.setText("");

		}
	}
	@FXML
	void tfRegexEventKey (KeyEvent ke) {
		executaRegex();
	}

}
