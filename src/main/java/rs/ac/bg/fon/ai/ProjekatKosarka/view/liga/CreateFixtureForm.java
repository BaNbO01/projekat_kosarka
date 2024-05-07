/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.view.liga;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.ai.ProjekatKosarka.controller.UIController;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.KoloPK;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;

/**
 *
 * @author Korisnik
 */
@Component
@Scope("prototype")
public class CreateFixtureForm extends javax.swing.JDialog {
    @Autowired
    private Liga liga;
    @Autowired
    private KoloPK koloPk;
    @Autowired
    private Kolo kolo;
    private List<Liga> lige;
    private final UIController controller;
    /**
     * Creates new form CreateFixtureForm
     */
    public CreateFixtureForm(java.awt.Frame parent, boolean modal,UIController controller) {
        super(parent, modal);
        this.controller = controller;
        initComponents();
        prepareForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBrojKola = new javax.swing.JTextField();
        cmbLiga = new javax.swing.JComboBox<>();
        btnSacuvajKolo = new javax.swing.JButton();
        btnUkupnoKola = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Liga");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 21, 51, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Trenutan broj kola");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 108, 181, -1));

        txtBrojKola.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txtBrojKola, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 108, 167, -1));

        getContentPane().add(cmbLiga, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 19, 393, 34));

        btnSacuvajKolo.setText("Dodaj novo kolo");
        btnSacuvajKolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajKoloActionPerformed(evt);
            }
        });
        getContentPane().add(btnSacuvajKolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 116, 139, 34));

        btnUkupnoKola.setText("Prikazi trenutni broj kola");
        btnUkupnoKola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkupnoKolaActionPerformed(evt);
            }
        });
        getContentPane().add(btnUkupnoKola, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 71, 172, 31));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUkupnoKolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkupnoKolaActionPerformed
        try {
            liga = (Liga) cmbLiga.getSelectedItem();
            kolo.setLiga(liga);
            int brojKolaLige = controller.vratiKolaLige(kolo).size();
            txtBrojKola.setText(String.valueOf(brojKolaLige));
            koloPk.setLigaId(liga.getLigaId());
            koloPk.setKoloId(brojKolaLige+1);
            kolo.setKoloPK(koloPk);
            btnSacuvajKolo.setVisible(true);
           

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnUkupnoKolaActionPerformed

    private void btnSacuvajKoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajKoloActionPerformed
        
        try {
            controller.sacuvaj(kolo);
    JOptionPane.showMessageDialog(this, "Uspesno dodato novo kolo");
            dispose();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSacuvajKoloActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvajKolo;
    private javax.swing.JButton btnUkupnoKola;
    private javax.swing.JComboBox<Liga> cmbLiga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtBrojKola;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        try {
            lige = controller.vratiSveLige(liga);
            cmbLiga.setModel(new DefaultComboBoxModel(lige.toArray()));
            btnSacuvajKolo.setVisible(false);
            txtBrojKola.setEditable(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}