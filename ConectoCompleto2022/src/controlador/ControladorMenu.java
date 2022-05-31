/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmInserta;
import vista.FrmMenu;

public class ControladorMenu implements ActionListener {
    
    FrmMenu vMe  = new FrmMenu();
    FrmInserta vIn = new FrmInserta();
    
    public ControladorMenu(FrmMenu vMe, FrmInserta vIN){
        this.vMe = vMe;
        this.vIn = vIn;
        
        vMe.btnIsertar.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vMe.btnIsertar){
            this.vIn.setVisible(true);
            this.vIn.setLocationRelativeTo(vMe);
            this.vIn.setResizable(false);
        }
    }
    
}
