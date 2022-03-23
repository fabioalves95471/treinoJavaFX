package com.fabiomalves.treinoJavaFX;

public enum Views {

    INICIO("inicio/inicio.fxml"),
    FLUTUANTE("");
    
    private String pathFxml;
    
    Views(String pathFxml) {
        this.pathFxml = pathFxml;
    }
    public String getPathFxml () {
        return this.pathFxml;
    }
}
