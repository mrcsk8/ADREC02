/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcoscompany.ADREC02_marcos;

/**
 *
 * @author Marcos
 */
public class ConfigJason {
    private String directorio_orixen;
    private String directorio_backup;

    public ConfigJason(String directorio_orixen, String directorio_backup) {
        this.directorio_orixen = directorio_orixen;
        this.directorio_backup = directorio_backup;
    }

    public String getDirectorio_orixen() {
        return directorio_orixen;
    }

    public void setDirectorio_origen(String directorio_orixen) {
        this.directorio_orixen = directorio_orixen;
    }

    public String getDirectorio_backup() {
        return directorio_backup;
    }

    public void setDirectorio_backup(String directorio_backup) {
        this.directorio_backup = directorio_backup;
    }
    
    
}
