/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secure;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author sooryagangarajk
 * 
 */
public class login extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public static String USN;
    public static String SID;
 
    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        usernameId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        passId = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        statusId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusId.setText(" ");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Student Attendance Management System V2");

        jLabel2.setText("User name:");

        submitBtn.setText("submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitBtn)
                    .addComponent(passId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usernameId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(statusId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusId, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        //TAKE THE USERNAME AND PASSWORD
        //THE CONNECTION FROM THE DATABASE

        //CHECK THE DATABASE FOR THE MATCH
        //IF SUCC INITIALIZE THE SECOND FRAME
        //ELSE INCORRECT USERNAME AND PASSWORD
        conn = MySqlConnect.ConnectDB();
        String usr = usernameId.getText();
        String pasd = passId.getText();
        String Sql = "select * from Login where UserName=? and Password=?";

        try {
            pst = conn.prepareStatement(Sql);
            pst.setString(1, usr);
            pst.setString(2, pasd);
            rs = pst.executeQuery();
            if (rs.next()) {
                //for public

                String ad = rs.getString(3);
                String usn = rs.getString(4);
                String sid = rs.getString(5);
                //JOptionPane.showMessageDialog(null, "ad:"+ad+"\nusn:"+usn+"\nSID:"+sid);
                if (ad.equals("0") && (sid != null) && (usn == null)) {
                    this.SID=sid;
                    (new TeacherFrame()).setVisible(true);
                    
                    this.setVisible(false);
                    ///////
                    try {
                //jF5_SC  jF4_SN
                conn = MySqlConnect.ConnectDB();
                String Sql5 = "INSERT INTO Log ( SID) VALUES (?)";
                PreparedStatement preparedStmt = conn.prepareStatement(Sql5);
                preparedStmt.setString(1, SID);
                

                // execute the java preparedstatement
                preparedStmt.executeUpdate();
                
            } catch (SQLException ex) {
                
            }
                    //////
                    //JOptionPane.showMessageDialog(null, "TT");
                    //statusId.setText("TT");
                    
                }
                if (ad.equals("0") && (usn != null) && (sid == null)) {
                    //students
                    this.USN=usn;
                    JOptionPane.showMessageDialog(null, "students");
                    //statusId.setText("students");
                }
                if (ad.equals("1")) {
                    //statusId.setText("Admin");
                    //JOptionPane.showMessageDialog(null, "Admin");
                    (new AdminView(true)).setVisible(true);
                    this.setVisible(false);
                }
                //this.setVisible(false);
                //for admin add data ,show all data etc.

            } else {
                statusId.setText("incorrect password or username");
            }

        } catch (Exception e) {
            //statusId.setText(e.toString());
            // usernameId.setText(e.toString());
        }

    }//GEN-LAST:event_submitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
                
                ////SGK///
//                new TT().setVisible(true);
//                new TTA().setVisible(true);
//                new TView().setVisible(true);
//                new StudentDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passId;
    private javax.swing.JLabel statusId;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField usernameId;
    // End of variables declaration//GEN-END:variables
}
