
package project.atm;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static project.atm.Login.id;

public class AllMenu extends javax.swing.JFrame {
    private Container c;

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public AllMenu() {
        initComponents();
        setIcon();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personal Account System - - Main Dialog");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 153, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/atm/icon10.png"))); // NOI18N
        jButton1.setText("Re-Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(603, 13, 147, 41);

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/atm/icon4.png"))); // NOI18N
        jButton2.setText("Create Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(86, 126, 233, 41);

        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/atm/icon5.png"))); // NOI18N
        jButton3.setText("Statistical Analysis");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(86, 248, 233, 41);

        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/atm/icon6.png"))); // NOI18N
        jButton4.setText("Account Query");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(86, 358, 233, 41);

        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 204));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/atm/icon7.png"))); // NOI18N
        jButton5.setText("Deposit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(473, 126, 233, 41);

        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 204));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/atm/icon8.png"))); // NOI18N
        jButton6.setText("Withdraw");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(473, 248, 233, 41);

        jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 204));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/atm/icon9.png"))); // NOI18N
        jButton7.setText("Transfer");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(473, 358, 233, 41);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/AccountInfo", "root","");
            pst = con.prepareStatement("SELECT * FROM `accountinfo` WHERE AccountID=?");
            pst.setString(1, id.getText());
            rs = pst.executeQuery(); 
            
            if(rs.next()){
                dispose();
                Deposit frame = new Deposit();
                Deposit.jTextField1.setText(rs.getString("AccountID"));
                Deposit.jTextField2.setText(rs.getString("Name"));
                Deposit.jTextField3.setText(rs.getString("AccountType"));
                Deposit.jTextField5.setText(rs.getString("Balance"));
                
                frame.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
            }
        }catch(HeadlessException | SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage());
      }    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new CreateAcc().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/AccountInfo", "root","");
            pst = con.prepareStatement("SELECT * FROM `accountinfo` WHERE AccountID=?");
            pst.setString(1, id.getText());
            rs = pst.executeQuery(); 
            
            if(rs.next()){
                dispose();
                Withdraw frame = new Withdraw();
                Withdraw.jTextField1.setText(rs.getString("AccountID"));
                Withdraw.jTextField2.setText(rs.getString("Name"));
                Withdraw.jTextField3.setText(rs.getString("AccountType"));
                Withdraw.jTextField4.setText(rs.getString("Balance"));
                
                frame.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
            }
        }catch(HeadlessException | SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage());
      }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/AccountInfo", "root","");
            pst = con.prepareStatement("SELECT * FROM `accountinfo` WHERE AccountID=?");
            pst.setString(1, id.getText());
            rs = pst.executeQuery(); 
            
            if(rs.next()){
                dispose();
                Transfer frame = new Transfer();
                Transfer.jTextField1.setText(rs.getString("AccountID"));
                Transfer.jTextField2.setText(rs.getString("Name"));
                Transfer.jTextField3.setText(rs.getString("AccountType"));
                Transfer.jTextField4.setText(rs.getString("Balance"));
                
                frame.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
            }
        }catch(HeadlessException | SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage());
      }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        new Statistics().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
        new AccQuery().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AllMenu().setVisible(true);
        });
    }

    private void setIcon() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("i1.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JButton jButton6;
    public static javax.swing.JButton jButton7;
    // End of variables declaration//GEN-END:variables

    }

