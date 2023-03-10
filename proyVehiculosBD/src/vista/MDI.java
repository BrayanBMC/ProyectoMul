/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/**
 *
 * @author User
 */
public class MDI extends javax.swing.JFrame {

    /**
     * Creates new form MDI
     */
    public MDI() {
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

        escritorio = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        btnReg = new javax.swing.JButton();
        btnCon = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        opcRegistrar = new javax.swing.JMenuItem();
        opcSalir = new javax.swing.JMenuItem();
        menuConsultar = new javax.swing.JMenu();
        opcLista = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(204, 255, 255));
        escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jToolBar1.setBackground(new java.awt.Color(204, 255, 204));
        jToolBar1.setRollover(true);

        btnReg.setBackground(new java.awt.Color(204, 255, 204));
        btnReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir.png"))); // NOI18N
        btnReg.setFocusable(false);
        btnReg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReg.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnReg);

        btnCon.setBackground(new java.awt.Color(204, 255, 204));
        btnCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/investigar.png"))); // NOI18N
        btnCon.setFocusable(false);
        btnCon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCon);

        btnSalir.setBackground(new java.awt.Color(204, 255, 204));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salida.png"))); // NOI18N
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);

        menuArchivo.setMnemonic('f');
        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        opcRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        opcRegistrar.setMnemonic('o');
        opcRegistrar.setText("Registrar");
        menuArchivo.add(opcRegistrar);

        opcSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        opcSalir.setMnemonic('x');
        opcSalir.setText("Salir");
        opcSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(opcSalir);

        menuBar.add(menuArchivo);

        menuConsultar.setMnemonic('e');
        menuConsultar.setText("Consultar");
        menuConsultar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        opcLista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        opcLista.setMnemonic('t');
        opcLista.setText("Lista de Vehiculos");
        menuConsultar.add(opcLista);

        menuBar.add(menuConsultar);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcSalirActionPerformed
        int resp = JOptionPane.showConfirmDialog(this,"??Est?? seguro de salir?","Confirmaci??n",
                   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp==JOptionPane.YES_OPTION){
                this.dispose();
            } 
    }//GEN-LAST:event_opcSalirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
                int resp = JOptionPane.showConfirmDialog(this,"??Est?? seguro de salir?","Confirmaci??n",
                   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp==JOptionPane.YES_OPTION){
                this.dispose();
            } 
    }//GEN-LAST:event_btnSalirActionPerformed
    
    public JButton getBtnCon() {
        return btnCon;
    }

    public void setBtnCon(JButton btnCon) {
        this.btnCon = btnCon;
    }

    public JButton getBtnReg() {
        return btnReg;
    }

    public void setBtnReg(JButton btnReg) {
        this.btnReg = btnReg;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JToolBar getjToolBar1() {
        return jToolBar1;
    }

    public void setjToolBar1(JToolBar jToolBar1) {
        this.jToolBar1 = jToolBar1;
    }

    public JMenu getMenuArchivo() {
        return menuArchivo;
    }

    public void setMenuArchivo(JMenu menuArchivo) {
        this.menuArchivo = menuArchivo;
    }

    public JMenu getMenuConsultar() {
        return menuConsultar;
    }

    public void setMenuConsultar(JMenu menuConsultar) {
        this.menuConsultar = menuConsultar;
    }

    public JMenuItem getOpcLista() {
        return opcLista;
    }

    public void setOpcLista(JMenuItem opcLista) {
        this.opcLista = opcLista;
    }

    public JMenuItem getOpcRegistrar() {
        return opcRegistrar;
    }

    public void setOpcRegistrar(JMenuItem opcRegistrar) {
        this.opcRegistrar = opcRegistrar;
    }

    public JMenuItem getOpcSalir() {
        return opcSalir;
    }

    public void setOpcSalir(JMenuItem opcSalir) {
        this.opcSalir = opcSalir;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCon;
    private javax.swing.JButton btnReg;
    private javax.swing.JButton btnSalir;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuConsultar;
    private javax.swing.JMenuItem opcLista;
    private javax.swing.JMenuItem opcRegistrar;
    private javax.swing.JMenuItem opcSalir;
    // End of variables declaration//GEN-END:variables

}
