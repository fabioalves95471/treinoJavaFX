package com.fabiomalves.treinoJavaFX.aplicativosCriados.testeStage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class TesteStage extends Application {
	
	Rectangle rt = new Rectangle();
	int rtX = 2, rtY = 2, rotate = 0, incrRotate = 0;
	boolean vetorX = true, vetorY = true;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,700,400);
			scene.getStylesheets().add(getClass().getResource("/com/fabiomalves/treinoJavaFX/aplicativosCriados/testeStage/application.css").toExternalForm());
			
			rt.setX(rtX);
			rt.setY(rtY);
			rt.setWidth(100);
			rt.setHeight(100);
			rt.getStyleClass().add("retangulo");
			
			// Inserindo outro retangulo para teste
			Rectangle rt2 = new Rectangle();
			rt2.setX(rtX);
			rt2.setY(rtY);
			rt2.setWidth(100);
			rt2.setHeight(100);
			rt2.getStyleClass().add("retangulo2");

			root.getChildren().addAll(rt);

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
			
			// Insere botões (para inserir o novo stage)
			Button bStageShowAndWait = new Button("Stage__show_and_wait");
			Button bStageShow = new Button("Stage_show");
			bStageShowAndWait.setMinSize(80, 30);
			bStageShow.setMinSize(80, 30);
			root.setTop(bStageShow);
			root.setLeft(bStageShowAndWait);
			// Insere funçoes nos botões para apresentar novos stages.
			bStageShowAndWait.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					BorderPane root2 = new BorderPane();
					Scene scene2 = new Scene(root2,300,200);
					Stage stage2 = new Stage();
					stage2.setScene(scene2);
					stage2.showAndWait();
					System.out.println("texto wait");
				}
			});

		} catch(Exception e) {
			e.printStackTrace();
		}
		// 
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





