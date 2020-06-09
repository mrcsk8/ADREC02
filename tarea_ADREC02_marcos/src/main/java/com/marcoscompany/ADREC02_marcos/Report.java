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
public class Report {
    private String numero_de_arquivos_copiados;
    private String tempo_utilizado_en_segundos;

    public Report(String numero_de_arquivos_copiados, String tempo_utilizado_en_segundos) {
        this.numero_de_arquivos_copiados = numero_de_arquivos_copiados;
        this.tempo_utilizado_en_segundos = tempo_utilizado_en_segundos;
    }

    public String getNumero_de_arquivos_copiados() {
        return numero_de_arquivos_copiados;
    }

    public void setNumero_de_arquivos_copiados(String numero_de_arquivos_copiados) {
        this.numero_de_arquivos_copiados = numero_de_arquivos_copiados;
    }

    public String getTempo_utilizado_en_segundos() {
        return tempo_utilizado_en_segundos;
    }

    public void setTempo_utilizado_en_segundos(String tempo_utilizado_en_segundos) {
        this.tempo_utilizado_en_segundos = tempo_utilizado_en_segundos;
    } 
}
