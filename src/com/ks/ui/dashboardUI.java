/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ks.ui;
import com.ks.dbOperations.dbOperations;
import com.ks.ui.addEntreprise;
import javax.swing.JOptionPane;


/**
 *
 * @author thyler
 */
public class dashboardUI extends javax.swing.JFrame {
    private String numEntreprise, nomEntreprise,aNumEntreprise;
    
    public String getNumEntreprise(){
        return this.numEntreprise;
    }
    
    public void setNumEntreprise(String newNumEntreprise){
        this.numEntreprise = newNumEntreprise;
    }
    
    public String getNomEntreprise(){
        return this.nomEntreprise;
    }
    
    public void setNomEntreprise(String newNomEntreprise){
        this.nomEntreprise = newNomEntreprise;
    }
    /**
     * Creates new form dashboardUI
     */
    public dashboardUI() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 500));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/thyler/testProjets/netbeans/GestionEmployee/assets/building400x400.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new dbOperations().listEntreprise());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 576, 250));

        jLabel2.setFont(new java.awt.Font("Cantarell Extra Bold", 1, 22)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Liste des entreprises");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 267, 34));

        jButton1.setText("Ajouter une entreprise");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 30));

        jButton2.setText("Gerer");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 260, -1));

        jButton3.setText("Enregistrer ");
        jButton3.setEnabled(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 300, -1));

        jButton4.setText("Retirer");
        jButton4.setEnabled(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 300, -1));

        jLabel3.setText("Selectionner un entreprise");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 310, -1));

        jButton5.setText("Annuler selection");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 260, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 190, 30));

        jLabel4.setText("Rechercher");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 7, -1, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.out.println(this.getNumEntreprise());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = this.jTable1.getSelectedRow();
        Object id = this.jTable1.getValueAt(row, 0);
        Object nom = this.jTable1.getValueAt(row, 1);
        this.setNumEntreprise(id.toString());
        this.setNomEntreprise(nom.toString());
        this.jButton2.setEnabled(true);
        this.jButton3.setEnabled(true);
        this.jButton4.setEnabled(true);
        this.jButton5.setEnabled(true);
        this.jTextField1.setText(null); 
        this.jButton2.setText("Gerer < "+this.getNomEntreprise()+" >");
        this.jButton3.setText("Enregistrer < "+this.getNomEntreprise()+" >");
        this.jButton4.setText("Retirer < "+this.getNomEntreprise()+" >"); 
        this.jLabel3.setText(null);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Cette action entrainera la suppression de tous les employees et leurs travails dans "+this.getNomEntreprise()+". Continuer?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            // delete the record from the database
            if(new dbOperations().deleteEntreprise(this.getNumEntreprise())){
                JOptionPane.showMessageDialog(null, "Toutes informations concernant "+this.getNomEntreprise()+" ont ete retirees", "Succes", JOptionPane.INFORMATION_MESSAGE);
                this.jButton2.setEnabled(false);
                this.jButton3.setEnabled(false);
                this.jButton4.setEnabled(false);
                this.jButton5.setEnabled(false);
                this.jTextField1.setText(null); 
                this.jButton2.setText("Gerer");
                this.jButton3.setText("Enregistrer");
                this.jButton4.setText("Retirer");
                this.jLabel3.setText("Selectionner une entreprise");
            }else{
                JOptionPane.showMessageDialog(null, "Une erreur s'est produite", "Erreur", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        } else {
            // do nothing
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addEntreprise addForm = new addEntreprise();
        addForm.setParent(this);
        addForm.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        this.jTable1.setModel(new dbOperations().listEntreprise());
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:                                         
        int selectedRow = this.jTable1.getSelectedRow();
        String previousNumVal = this.getNumEntreprise();
        String previousNomVal = this.getNomEntreprise();
        String newNumVal = this.jTable1.getValueAt(selectedRow,0).toString();
        String newNomVal = this.jTable1.getValueAt(selectedRow,1).toString();
        if(previousNumVal == newNumVal && previousNomVal == newNomVal){
            JOptionPane.showMessageDialog(null, "Aucune modification n'a ete faite", "Erreur", JOptionPane.INFORMATION_MESSAGE);
            this.jTable1.clearSelection();
            this.jButton2.setEnabled(false);
            this.jButton3.setEnabled(false);
            this.jButton4.setEnabled(false);
            this.jButton5.setEnabled(false);
            this.jTextField1.setText(null); 
            this.jButton2.setText("Gerer");
            this.jButton3.setText("Enregistrer");
            this.jButton4.setText("Retirer");
            this.jLabel3.setText("Selectionner une entreprise");
        }else{
            if (newNumVal.matches("^[Ss]\\d{3}$") && newNumVal.trim().length() >= 4) {
                    // input matches the pattern
                if(new dbOperations().checkNumEntreprise(newNumVal.toUpperCase()) && previousNumVal != newNumVal){
                    JOptionPane.showMessageDialog(null, "Ce numero d'entreprise est deja prise", "Erreur", JOptionPane.INFORMATION_MESSAGE);
                    this.jTable1.clearSelection();
                    this.jButton2.setEnabled(false);
                    this.jButton3.setEnabled(false);
                    this.jButton4.setEnabled(false);
                    this.jButton5.setEnabled(false);
                    this.jTextField1.setText(null); 
                    this.jButton2.setText("Gerer");
                    this.jButton3.setText("Enregistrer");
                    this.jButton4.setText("Retirer");
                    this.jLabel3.setText("Selectionner une entreprise");
                }else{
                    if(new dbOperations().updateEntreprise(previousNumVal, newNumVal, newNomVal)){
                        JOptionPane.showMessageDialog(null, "Modification reussie", "Succes", JOptionPane.INFORMATION_MESSAGE);
                        this.jTable1.clearSelection();
                        this.jButton2.setEnabled(false);
                        this.jButton3.setEnabled(false);
                        this.jButton4.setEnabled(false);
                        this.jButton5.setEnabled(false);
                        this.jTextField1.setText(null); 
                        this.jButton2.setText("Gerer");
                        this.jButton3.setText("Enregistrer");
                        this.jButton4.setText("Retirer");
                        this.jLabel3.setText("Selectionner une entreprise");
                    }else{
                        JOptionPane.showMessageDialog(null, "Une erreur s'est produite", "Erreur", JOptionPane.INFORMATION_MESSAGE);
                        this.jTable1.clearSelection();
                        this.jButton2.setEnabled(false);
                        this.jButton3.setEnabled(false);
                        this.jButton4.setEnabled(false);
                        this.jButton5.setEnabled(false);
                        this.jTextField1.setText(null); 
                        this.jButton2.setText("Gerer");
                        this.jButton3.setText("Enregistrer");
                        this.jButton4.setText("Retirer");
                        this.jLabel3.setText("Selectionner une entreprise");
                    }
                }   
            } else {
                JOptionPane.showMessageDialog(null, "Le numero d'entreprise doit suivre le format 'S001'", "Erreur", JOptionPane.INFORMATION_MESSAGE);
                this.jTable1.clearSelection();
                this.jButton2.setEnabled(false);
                this.jButton3.setEnabled(false);
                this.jButton4.setEnabled(false);
                this.jButton5.setEnabled(false);
                this.jTextField1.setText(null); 
                this.jButton2.setText("Gerer");
                this.jButton3.setText("Enregistrer");
                this.jButton4.setText("Retirer");
                this.jLabel3.setText("Selectionner une entreprise");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.jButton2.setEnabled(false);
        this.jButton3.setEnabled(false);
        this.jButton4.setEnabled(false);
        this.jButton5.setEnabled(false);
        this.jButton2.setText("Gerer");
        this.jButton3.setText("Enregistrer");
        this.jButton4.setText("Retirer");
        this.jTextField1.setText(null); 
        this.jLabel3.setText("Selectionner une entreprise");
        this.jTable1.clearSelection();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        if(this.jTextField1.getText().trim().isEmpty()){
            this.jTable1.setModel(new dbOperations().listEntreprise());
        }else{
            this.jTable1.setModel(new dbOperations().searchEntreprise(this.jTextField1.getText().toString()));
        }
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(dashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardUI().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
