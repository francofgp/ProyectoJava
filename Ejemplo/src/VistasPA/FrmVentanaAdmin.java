/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistasPA;

/**
 *
 * @author Chelo
 */
public class FrmVentanaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FrmComercio
     */
    public FrmVentanaAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        btnAceptar = new javax.swing.JButton();
        btnAceptar1 = new javax.swing.JButton();
        btnAceptar3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAceptar4 = new javax.swing.JButton();
        btnAceptar5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnAceptar6 = new javax.swing.JButton();
        btnAceptar7 = new javax.swing.JButton();
        btnAceptar8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(1174, 772));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptar.setBackground(new java.awt.Color(153, 204, 0));
        btnAceptar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(153, 204, 0));
        btnAceptar.setText("Registrar ");
        btnAceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 0)));
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 110, 30));

        btnAceptar1.setBackground(new java.awt.Color(153, 204, 0));
        btnAceptar1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAceptar1.setForeground(new java.awt.Color(153, 204, 0));
        btnAceptar1.setText("Registrar");
        btnAceptar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 0)));
        btnAceptar1.setContentAreaFilled(false);
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 110, 30));

        btnAceptar3.setBackground(new java.awt.Color(153, 204, 0));
        btnAceptar3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAceptar3.setForeground(new java.awt.Color(153, 204, 0));
        btnAceptar3.setText("Eliminar");
        btnAceptar3.setToolTipText("");
        btnAceptar3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 0)));
        btnAceptar3.setContentAreaFilled(false);
        btnAceptar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 110, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 430, 350));

        btnAceptar4.setBackground(new java.awt.Color(153, 204, 0));
        btnAceptar4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAceptar4.setForeground(new java.awt.Color(153, 204, 0));
        btnAceptar4.setText("Modificar ");
        btnAceptar4.setToolTipText("");
        btnAceptar4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 0)));
        btnAceptar4.setContentAreaFilled(false);
        btnAceptar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 110, 30));

        btnAceptar5.setBackground(new java.awt.Color(153, 204, 0));
        btnAceptar5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAceptar5.setForeground(new java.awt.Color(153, 204, 0));
        btnAceptar5.setText("Guardar");
        btnAceptar5.setToolTipText("");
        btnAceptar5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 0)));
        btnAceptar5.setContentAreaFilled(false);
        btnAceptar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 100, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Rubro");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 60, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setText("Categor�a");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 110, 30));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 430, 350));

        btnAceptar6.setBackground(new java.awt.Color(153, 204, 0));
        btnAceptar6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAceptar6.setForeground(new java.awt.Color(153, 204, 0));
        btnAceptar6.setText("Modificar ");
        btnAceptar6.setToolTipText("");
        btnAceptar6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 0)));
        btnAceptar6.setContentAreaFilled(false);
        btnAceptar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 460, 110, 30));

        btnAceptar7.setBackground(new java.awt.Color(153, 204, 0));
        btnAceptar7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAceptar7.setForeground(new java.awt.Color(153, 204, 0));
        btnAceptar7.setText("Guardar");
        btnAceptar7.setToolTipText("");
        btnAceptar7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 0)));
        btnAceptar7.setContentAreaFilled(false);
        btnAceptar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 100, 30));

        btnAceptar8.setBackground(new java.awt.Color(153, 204, 0));
        btnAceptar8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAceptar8.setForeground(new java.awt.Color(153, 204, 0));
        btnAceptar8.setText("Eliminar");
        btnAceptar8.setToolTipText("");
        btnAceptar8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 0)));
        btnAceptar8.setContentAreaFilled(false);
        btnAceptar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar8ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 460, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1300, 680));

        jPanel3.setBackground(new java.awt.Color(153, 204, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EAT");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DELIVERY");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("email:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 230, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Configuracion");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton5.setContentAreaFilled(false);
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 120, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        new FrmCategoria().setVisible(true);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        new FrmRubro().setVisible(true);
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void btnAceptar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptar3ActionPerformed

    private void btnAceptar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptar4ActionPerformed

    private void btnAceptar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptar5ActionPerformed

    private void btnAceptar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptar6ActionPerformed

    private void btnAceptar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptar7ActionPerformed

    private void btnAceptar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptar8ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentanaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnAceptar3;
    private javax.swing.JButton btnAceptar4;
    private javax.swing.JButton btnAceptar5;
    private javax.swing.JButton btnAceptar6;
    private javax.swing.JButton btnAceptar7;
    private javax.swing.JButton btnAceptar8;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
