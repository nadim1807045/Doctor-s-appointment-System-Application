
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author amlan
 */
public class Channel extends javax.swing.JFrame {

    /**
     * Creates new form Channel
     */
    public Channel() {
        initComponents();
        this.setLocationRelativeTo(null);
        Connect();
        AutoID();
        LoadDoctor();
        LoadPatient();
        Channel_table();
    }

    String id;
    String docname;
    String newid;
    String newdocname;

//    public Channel(String dname1) {
//        initComponents();
//        String x = new ChannelPatient().docname;
//        dname.setText(x);
//
////        this.id = chno;
//        this.docname = dname1;
//
////        newid = id;
////        newdocname = docname;
////        txtchno.setText(newid);
////        txtchno.setEnabled(false);
//
//        dname.setText(docname);
//        Connect();
//        AutoID();
//    }
//    String x = new ChannelPatient().docname;
//    String dname.setText(x);
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String chno;

    public class Doctor {

        String id;
        String name;

        public Doctor(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return name;
        }

    }

    public class Patient {

        String id;
        String name;

        public Patient(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return name;
        }

    }

    public void LoadPatient() {
        try {
            pst = con.prepareStatement("Select * from Patient");
            rs = pst.executeQuery();
            txtpatient.removeAll();

            while (rs.next()) {
                txtpatient.addItem(new Patient(rs.getString(1), rs.getString(2)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Channel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void LoadDoctor() {
        try {
            pst = con.prepareStatement("Select * from Doctor");
            rs = pst.executeQuery();
            txtdoctor.removeAll();

            while (rs.next()) {
                txtdoctor.addItem(new Doctor(rs.getString(1), rs.getString(2)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Channel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost/nhospital", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
         static int a= 0;
    public void AutoID() {

        try {
            Statement s = con.createStatement();
            rs = s.executeQuery("select MAX(channelno) from channel");
            rs.next();
            rs.getString("MAX(channelno)");

            if (rs.getString("MAX(channelno)") == null) {

                lblchno.setText("CH001");

            } else {
                long id = Long.parseLong(rs.getString("MAX(channelno)").substring(2, rs.getString("MAX(channelno)").length()));
                id++;

                lblchno.setText("CH" + String.format("%03d", id));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblchno = new javax.swing.JLabel();
        txtdoctor = new javax.swing.JComboBox();
        txtpatient = new javax.swing.JComboBox();
        txtroom = new javax.swing.JSpinner();
        txtdate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        viewReq = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(204, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Channel Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 0, 51))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 102));
        jLabel1.setText("Channel No");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 102));
        jLabel2.setText("Doctor Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 102));
        jLabel3.setText("Patient Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 102));
        jLabel4.setText("Room No");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setText("Channel Date");

        lblchno.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblchno.setForeground(new java.awt.Color(255, 255, 255));
        lblchno.setText("jLabel6");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        viewReq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewReq.setText("View Request");
        viewReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(viewReq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(166, 166, 166)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblchno, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtpatient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addComponent(txtroom, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblchno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpatient, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtroom, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viewReq, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Channel No", "Doctor Name", "Patient Name", "Room No", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fix Appointment");

        jButton5.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jButton5.setText("CLOSE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\WALTON\\Documents\\eye.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(246, 246, 246))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel6)
                        .addGap(148, 148, 148)
                        .addComponent(jLabel7)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel7)
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            a=1;
        String chno = lblchno.getText();

        Doctor d = (Doctor) txtdoctor.getSelectedItem();
        Patient p = (Patient) txtpatient.getSelectedItem();

        String room = txtroom.getValue().toString();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(txtdate.getDate());

        try {
            pst = con.prepareStatement("insert into channel(channelno,doctorname,patientname,roomno,date)values(?,?,?,?,?)");
            pst.setString(1, chno);
            pst.setString(2, d.id);
            pst.setString(3, p.id);
            pst.setString(4, room);
            pst.setString(5, date);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Channel Created");

            AutoID();
            lblchno.setText("");
            txtdoctor.setSelectedIndex(-1);
            txtpatient.setSelectedIndex(-1);
            txtroom.setValue(0);

            Channel_table();
        }
        catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        chno = d1.getValueAt(selectIndex, 0).toString();

//        JOptionPane.showMessageDialog(this, chno);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       

        try {
            pst = con.prepareStatement("delete from channel where channelno = ?");
            pst.setString(1, chno);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Channel Deleted");

            AutoID();
            lblchno.setText("");
            txtdoctor.setSelectedIndex(-1);
            txtpatient.setSelectedIndex(-1);
            txtroom.setValue(0);

            Channel_table();

// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void viewReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReqActionPerformed
                ReqAdmn obj = new ReqAdmn();
           obj.setVisible(true);
    }//GEN-LAST:event_viewReqActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    public void Channel_table() {
        try {
            pst = con.prepareStatement("select * from channel");

            rs = pst.executeQuery();

            ResultSetMetaData Rsm = rs.getMetaData();
            int c;
            c = Rsm.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();

            df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("channelno"));
                    v2.add(rs.getString("doctorname"));
                    v2.add(rs.getString("patientname"));
                    v2.add(rs.getString("roomno"));
                    v2.add(rs.getString("date"));
                }

                df.addRow(v2);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Channel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblchno;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JComboBox txtdoctor;
    private javax.swing.JComboBox txtpatient;
    private javax.swing.JSpinner txtroom;
    private javax.swing.JButton viewReq;
    // End of variables declaration//GEN-END:variables
}
