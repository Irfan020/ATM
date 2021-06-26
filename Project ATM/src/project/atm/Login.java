
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

public class Login extends javax.swing.JFrame {
    private Container c;
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Login() {
        initComponents();
        setIcon();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personal Account System - - Login Dialog");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Account ID:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 64, 128, 22);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Password:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 130, 128, 22);

        pass.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pass.setText("111111");
        pass.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                passComponentAdded(evt);
            }
        });
        getContentPane().add(pass);
        pass.setBounds(327, 127, 257, 28);

        id.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        id.setText("100000");
        getContentPane().add(id);
        id.setBounds(327, 61, 257, 28);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Account Type:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 212, 128, 22);

        type.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clerk Account", "Saving Account", "Credit Account", "Checking Account" }));
        getContentPane().add(type);
        type.setBounds(327, 209, 257, 28);

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/atm/icon2.png"))); // NOI18N
        jButton1.setText("LogIn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 333, 144, 41);

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/atm/icon3.png"))); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(452, 333, 132, 41);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
        try{
            String query = "SELECT * FROM `accountinfo` WHERE AccountID=? and Password=? and AccountType=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/AccountInfo", "root","");
            pst = con.prepareStatement(query);
            pst.setString(1, id.getText());
            pst.setString(2, pass.getText());
            pst.setString(3, String.valueOf(type.getSelectedItem()));
            rs = pst.executeQuery();
            
            
            if(rs.next()){
                if(type.getSelectedIndex()==0){
                dispose();
                AllMenu frame = new AllMenu();
                //AllMenu.inid.setText(Login.id.getText());
                AllMenu.jButton5.setEnabled(false);
                AllMenu.jButton6.setEnabled(false);
                AllMenu.jButton7.setEnabled(false);
                frame.setVisible(true);
                }else{
                    dispose();
                AllMenu frame = new AllMenu();
                //AllMenu.inid.setText(Login.id.getText());
                AllMenu.jButton2.setEnabled(false);
                AllMenu.jButton3.setEnabled(false);
                AllMenu.jButton4.setEnabled(false);
                
                frame.setVisible(true);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "ID/Password/AccountType is Wrong");
            }
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        id.setText("");
        pass.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void passComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_passComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_passComponentAdded

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pass;
    public static javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("i1.png")));
    }
}
