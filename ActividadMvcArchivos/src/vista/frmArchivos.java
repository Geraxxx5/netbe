/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author Gerax
 */
public class frmArchivos extends javax.swing.JFrame {

    /**
     * Creates new form frmArchivos
     */
    public frmArchivos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuItem = new javax.swing.JMenuItem();
        FiloChooser = new javax.swing.JFileChooser();
        Notificaciones = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        entryTexto = new javax.swing.JTextArea();
        Menubar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        AbrirArch = new javax.swing.JMenuItem();
        GuardarArch = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        textoMayus = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        MenuItem.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        entryTexto.setColumns(20);
        entryTexto.setRows(5);
        jScrollPane1.setViewportView(entryTexto);

        jMenu1.setText("File");
        jMenu1.setActionCommand("File\n");

        AbrirArch.setText("Abrir");
        jMenu1.add(AbrirArch);

        GuardarArch.setText("Guardar");
        jMenu1.add(GuardarArch);

        Menubar.add(jMenu1);

        jMenu2.setText("Edit");

        textoMayus.setText("Texto Mayusculas");
        jMenu2.add(textoMayus);

        jMenuItem4.setText("Texto Negrita");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Texto ");
        jMenu2.add(jMenuItem5);

        Menubar.add(jMenu2);

        setJMenuBar(Menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmArchivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem AbrirArch;
    public javax.swing.JFileChooser FiloChooser;
    public javax.swing.JMenuItem GuardarArch;
    public javax.swing.JMenuItem MenuItem;
    public javax.swing.JMenuBar Menubar;
    public javax.swing.JOptionPane Notificaciones;
    public javax.swing.JTextArea entryTexto;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JMenuItem textoMayus;
    // End of variables declaration//GEN-END:variables
}
