import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Patient extends javax.swing.JFrame {

    public Patient() {
        initComponents();
        Connect();
        AutoID();
        patient_table();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost/nhospital", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AutoID() {

        try {
            Statement s = con.createStatement();
            rs = s.executeQuery("select MAX(patientno) from patient");
            rs.next();
            rs.getString("MAX(patientno)");

            if (rs.getString("MAX(patientno)") == null) {

                lblpno.setText("PS001");

            } else {
                long id = Long.parseLong(rs.getString("MAX(patientno)").substring(2, rs.getString("MAX(patientno)").length()));
                id++;

                lblpno.setText("PS" + String.format("%03d", id));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void patient_table() {
        try {
            pst = con.prepareStatement("select * from patient");

            rs = pst.executeQuery();

            ResultSetMetaData Rsm = rs.getMetaData();
            int c;
            c = Rsm.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();

            df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("patientno"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("phone"));
                    v2.add(rs.getString("address"));
                }

                df.addRow(v2);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblpno = new javax.swing.JLabel();
        txtpname = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1400, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 800));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Add");
        jButton1.setMaximumSize(new java.awt.Dimension(119, 37));
        jButton1.setMinimumSize(new java.awt.Dimension(119, 37));
        jButton1.setPreferredSize(new java.awt.Dimension(119, 37));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Delete");
        jButton3.setMaximumSize(new java.awt.Dimension(119, 37));
        jButton3.setMinimumSize(new java.awt.Dimension(119, 37));
        jButton3.setPreferredSize(new java.awt.Dimension(119, 37));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("Exit");
        jButton4.setMaximumSize(new java.awt.Dimension(119, 37));
        jButton4.setMinimumSize(new java.awt.Dimension(119, 37));
        jButton4.setPreferredSize(new java.awt.Dimension(119, 37));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient No", "Patient Name ", "Phone", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Patient No");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Patient Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Phone");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");

        lblpno.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblpno.setForeground(new java.awt.Color(255, 255, 0));
        lblpno.setText("jLabel5");

        txtpname.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        txtphone.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtaddress.setRows(5);
        jScrollPane1.setViewportView(txtaddress);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtpname)
                    .addComponent(txtphone)
                    .addComponent(jScrollPane1)
                    .addComponent(lblpno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblpno))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Patient Registration");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("View  Top  Doctors");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(43, 43, 43)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jButton5)))
                .addGap(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel5)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String pno = lblpno.getText();
        String pname = txtpname.getText();
        String phone = txtphone.getText();
        String address = txtaddress.getText();

        try {
            pst = con.prepareStatement("insert into patient(patientno,name,phone,address)values(?,?,?,?)");
            pst.setString(1, pno);
            pst.setString(2, pname);
            pst.setString(3, phone);
             pst.setString(4, address);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Patient Inserted");

            AutoID();
            txtpname.setText("");
            txtphone.setText("");
            txtaddress.setText("");
            txtpname.requestFocus();
            patient_table();
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();

        lblpno.setText(d1.getValueAt(SelectIndex, 0).toString());
        txtpname.setText(d1.getValueAt(SelectIndex, 1).toString());
        txtphone.setText(d1.getValueAt(SelectIndex, 2).toString());
        txtaddress.setText(d1.getValueAt(SelectIndex, 3).toString());

        jButton1.setEnabled(false);

// TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String pname = txtpname.getText();
        String phone = txtphone.getText();
        String address = txtaddress.getText();
        String pno = lblpno.getText();

        try {
            pst = con.prepareStatement("update patient set name = ?,phone = ?, address = ? where patientno = ?");

            pst.setString(1, pname);
            pst.setString(2, phone);
            pst.setString(3, address);
            pst.setString(4, pno);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Patient Updated");

            AutoID();
            txtpname.setText("");
            txtphone.setText("");
            txtaddress.setText("");

            patient_table();

            jButton1.setEnabled(true);

// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String pno = lblpno.getText();

        try {
            pst = con.prepareStatement("delete from patient where patientno = ?");

            pst.setString(1, pno);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Patient Deleted");

            AutoID();
            txtpname.setText("");
            txtphone.setText("");
            txtaddress.setText("");

            patient_table();

            jButton1.setEnabled(true);

// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        topdoctor td = new topdoctor();
        td.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblpno;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtpname;
    // End of variables declaration//GEN-END:variables
}
