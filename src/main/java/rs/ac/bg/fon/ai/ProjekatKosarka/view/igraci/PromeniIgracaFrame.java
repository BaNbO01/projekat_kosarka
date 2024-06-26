/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.view.igraci;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.ai.ProjekatKosarka.controller.UIController;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Drzava;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Pozicija;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tim;

/**
 *
 * @author Korisnik
 */
@Component
@Scope("prototype")
public class PromeniIgracaFrame extends javax.swing.JDialog {


    private boolean mode;
    
    IgraciPretraziFrame parent;
    private UIController controller;
    private Igraci igrac;
    /**
     * Creates new form PromeniIgracaFrame
     * @param parent
     * @param modal
     * @param igrac
     */
    public PromeniIgracaFrame(IgraciPretraziFrame parent, boolean modal,Igraci igrac,UIController controller) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.igrac = igrac;
        this.controller = controller;
      this.parent = parent;
          
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtVisina = new javax.swing.JTextField();
        txtBroj1 = new javax.swing.JTextField();
        cmbTim = new javax.swing.JComboBox<>();
        cmbPozicija = new javax.swing.JComboBox<>();
        cmbDrzava = new javax.swing.JComboBox<>();
        txtDatumRodjenja = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ime");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Prezime");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Visina");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tim");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Broj");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Drzava");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Pozicija");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Datum rodjenja");

        txtIme.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtPrezime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtVisina.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtBroj1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cmbTim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cmbPozicija.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbPozicija.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PG", "SG", "SF", "PF", "C" }));

        cmbDrzava.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtDatumRodjenja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIme)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                            .addComponent(txtVisina, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                            .addComponent(txtBroj1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                            .addComponent(cmbTim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPozicija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDrzava, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumRodjenja)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnObrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBroj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtVisina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDrzava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnObrisi))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        try {
            controller.obrisiIgraca(igrac);
            JOptionPane.showMessageDialog(this, "Obrisan je igrac");
            dispose();
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            
            String ime = null;
            String prezime = null;
            Double visina = null;
            Integer broj = null;
            Pozicija pozicija = null;
            if (!txtIme.getText().isBlank()) {
                ime = txtIme.getText();
            }
            if (!txtPrezime.getText().isBlank()) {
                prezime = txtPrezime.getText();
            }
            if (!txtVisina.getText().isBlank()) {
                visina = Double.valueOf(txtVisina.getText());
            }
            if (!txtBroj1.getText().isBlank()) {
                broj = Integer.valueOf(txtBroj1.getText());
            }

         
            pozicija = Pozicija.valueOf(String.valueOf(cmbPozicija.getSelectedItem()));
              igrac.setBroj(broj);
            igrac.setPozicija(pozicija);
            igrac.setIme(ime);
            igrac.setPrezime(prezime);
            igrac.setVisina(visina);
            igrac.setTimId((Tim)cmbTim.getSelectedItem());
             SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        igrac.setDatumRodjenja(formater.parse(txtDatumRodjenja.getText()));
            igrac.setDrzavaId((Drzava)cmbDrzava.getSelectedItem());
            
            
            controller.sacuvaj(igrac);
            parent.modelTabele.fireTableDataChanged();
            dispose();
            JOptionPane.showMessageDialog(this, "Uspesno sacuvano");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Drzava> cmbDrzava;
    private javax.swing.JComboBox<String> cmbPozicija;
    private javax.swing.JComboBox<Tim> cmbTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtBroj1;
    private javax.swing.JTextField txtDatumRodjenja;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtVisina;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
           txtIme.setText(igrac.getIme());
        txtPrezime.setText(igrac.getPrezime());
        txtBroj1.setText(String.valueOf(igrac.getBroj()));
        txtVisina.setText(String.valueOf(igrac.getVisina()));
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        txtDatumRodjenja.setText(formater.format(igrac.getDatumRodjenja()));
        if(mode){
            btnObrisi.setVisible(true);
            btnSacuvaj.setVisible(false);
         txtIme.setEditable(false);
         txtPrezime.setEditable(false);
         txtVisina.setEditable(false);
         txtBroj1.setEditable(false);
         txtDatumRodjenja.setEditable(false);
        cmbTim.setModel(new DefaultComboBoxModel<Tim>(new Tim[]{igrac.getTimId()}));
        cmbDrzava.setModel(new DefaultComboBoxModel<Drzava>(new Drzava[]{igrac.getDrzavaId()}));
        }
        else{
               try {
                   btnSacuvaj.setVisible(true);
                   btnObrisi.setVisible(false);
                    txtIme.setEditable(true);
         txtPrezime.setEditable(true);
         txtVisina.setEditable(true);
         txtBroj1.setEditable(true);
         txtDatumRodjenja.setEditable(true);
                   List<Tim> timovi = controller.vratiSveTimove(igrac.getTimId());
                   System.out.println(timovi);
                   List<Drzava> drzave = controller.vratiDrzave(igrac.getDrzavaId());
                   cmbTim.setModel(new DefaultComboBoxModel(timovi.toArray()));
                   cmbTim.setSelectedItem((Tim)igrac.getTimId());
                   cmbDrzava.setModel(new DefaultComboBoxModel(drzave.toArray()));
                   cmbPozicija.setSelectedItem(String.valueOf(igrac.getPozicija()));
                   cmbDrzava.setSelectedItem((Drzava)igrac.getDrzavaId());
               } catch (Exception ex) {
                   JOptionPane.showMessageDialog(this, ex.getMessage());
                   dispose();
                  
               }
        }
        
    }

    void setIgrac(Igraci igrac) {
        this.igrac = igrac;
          prepareForm();
    }
    
    public void setMode(boolean mode) {
        this.mode = mode;
    }
}
