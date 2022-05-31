/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.ejemplogui;

import controlador.Controlador;
import modelo.ModeloLogico;
import vista.FrmOperaciones;

/**
 *
 * @author Gerax
 */
public class ComEjemploGui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        FrmOperaciones ope = new FrmOperaciones();
        ModeloLogico m1 = new ModeloLogico();
        Controlador c = new Controlador(ope, m1);
        ope.setVisible(true);
    }

    
}
