package com.fabiomalves.treinoJavaFX;

public enum FxmlCriado {

    INICIO("inicio/inicio.fxml"),
    FLUTUANTE("");
    
    private String pathFxml;
    
    FxmlCriado(String pathFxml) {
        this.pathFxml = pathFxml;
    }
    public String getPathFxml () {
        return this.pathFxml;
    }
}
