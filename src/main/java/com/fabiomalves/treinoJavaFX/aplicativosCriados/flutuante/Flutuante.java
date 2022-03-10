package com.fabiomalves.treinoJavaFX.aplicativosCriados.flutuante;
	
import com.fabiomalves.treinoJavaFX.Aplicativo;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.*;
import javafx.util.*;
import javafx.animation.*;


public class Flutuante extends Application {
	
	Rectangle rt = new Rectangle();
	int rtX = 2, rtY = 2, rotate = 0, incrRotate = 0;
	boolean vetorX = true, vetorY = true;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,700,400);
			scene.getStylesheets().add(getClass().getResource("/com/fabiomalves/treinoJavaFX/aplicativosCriados/flutuante/application.css").toExternalForm());
			
			rt.setX(rtX);
			rt.setY(rtY);
			rt.setWidth(100);
			rt.setHeight(100);
			rt.getStyleClass().add("retangulo");
			root.getChildren().add(rt);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			KeyFrame kf = new KeyFrame(Duration.millis(20), e -> {
				
				if (rtX >= (scene.getWidth()-rt.getWidth()-2) || rtX <= 1) {
					alteraRotacaoX();
					vetorX = !vetorX;
				}
				if (vetorX)		rtX += 5;
				else			rtX -= 5;
				if (rtY >= (scene.getHeight()-rt.getHeight()-2) || rtY <= 1) {
					alteraRotacaoY();
					vetorY = !vetorY;
				}
				if (vetorY)		rtY += 5;
				else			rtY -= 5;
				
				rt.setX(rtX);
				rt.setY(rtY);
				rt.setStyle("-fx-rotate: " + rotate);
				rotate += incrRotate;
			});
			Timeline tl = new Timeline(kf);
			tl.setCycleCount(-1);
			tl.play();
			primaryStage.setOnCloseRequest( e -> {
				tl.stop();
			});

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public void alteraRotacaoX () {
		if (vetorX ^ vetorY)	incrRotate += 3;
		else 					incrRotate -= 3;
	}
	public void alteraRotacaoY () {
		if (vetorX ^ vetorY)	incrRotate -= 3;
		else					incrRotate += 3;
	}
}





