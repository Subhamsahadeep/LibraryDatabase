/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.HeadlessException;
import java.sql.SQLException;
/**
 *
 * @author SUBHAM
 */
public class ReturnFrame extends javax.swing.JFrame {
Connection conn=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
    /**
     * Creates new form ReturnFrame
     */
    public ReturnFrame() {
        initComponents();
        conn=javaconnect.ConnecrDb();
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
        jButton1 = new javax.swing.JButton();
        surname = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        callno = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setText("RETURN BOOK");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 310, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Surname");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Book CallNo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 70, -1));

        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 120, -1));
        getContentPane().add(surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 100, -1));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, -1));
        getContentPane().add(callno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 100, -1));

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/100_Books_home_img.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 650, 250));

        setSize(new java.awt.Dimension(660, 292));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AfterLibLogin ss=new AfterLibLogin();
        ss.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                 String ab=null,bc=null;
            String cd=null,df=null;
            String d=callno.getText();
             int flag=1;
        try{
            String sql="Select * from IssuedBooks where CallNo=? and Stu_Name=? and Stu_Surname=?";
            pst=conn.prepareStatement(sql);
             pst.setString(1,callno.getText());
            pst.setString(2,name.getText());
            pst.setString(3,surname.getText());
            rs=pst.executeQuery();
            
            cd=name.getText();
            df=surname.getText();
           
            int b=1;int a=0;
                if(b==1)
                {
                     callno.setBackground(Color.red);
                   callno.setForeground(Color.white);
                    name.setBackground(Color.red);
                   name.setForeground(Color.white);
                    surname.setBackground(Color.red);
                   surname.setForeground(Color.white);
                }
            if(rs.next())
            {
                flag=2;
                ab=name.getText();
                bc=surname.getText();
            
                
                a=1;
                    callno.setBackground(Color.green);
                    callno.setForeground(Color.black);
                    name.setBackground(Color.green);
                    name.setForeground(Color.black);
                    surname.setBackground(Color.green);
                    surname.setForeground(Color.black);
                     JOptionPane.showMessageDialog(null, "All are correct");
                  
                
               
            }
              if(a==0)
                {
                    JOptionPane.showMessageDialog(null, "Any of these is not correct");
                    callno.setText("");
                    name.setText("");
                    surname.setText("");
                     callno.setBackground(Color.white);
                    callno.setForeground(Color.black);
                    name.setBackground(Color.white);
                    name.setForeground(Color.black);
                    surname.setBackground(Color.white);
                    surname.setForeground(Color.black);
                    
                }
        }
        catch(HeadlessException | SQLException e){
             JOptionPane.showMessageDialog(null, e);
        }finally{
          try{
              rs.close();
              pst.close();
          }
          catch(SQLException e)
          {
      }
        }
        if(flag==2)
        {
         int p=JOptionPane.showConfirmDialog(null,"Do you really want to Return?","Return",JOptionPane.YES_NO_OPTION);

        if(p==0){
           
        String sql="delete from IssuedBooks where CallNo=? and Stu_Name=? and Stu_Surname=?";
        try{
            
            pst=conn.prepareStatement(sql);
            pst.setString(1,callno.getText());
            pst.setString(2,name.getText());
           pst.setString(3,surname.getText());
            
                pst.execute();
                
                String sq="select Quantity,Issued from Books where CallNo=?";
            
             pst=conn.prepareStatement(sq);
             pst.setString(1, callno.getText());
             
             rs=pst.executeQuery();
             
             String w=null,q=null;
              int a=0;
             if(rs.next())
             {
                 
                 w=rs.getString("Quantity");
                 q=rs.getString("Issued");
                 JOptionPane.showMessageDialog(null, "Returned");
             }
             
             int x,y;
             x=Integer.parseInt(w);
             y=Integer.parseInt(q);
             
             
             String s =" UPDATE Books SET Quantity='"+(x+1)+"', Issued='"+(y-1)+"' where CallNo= '"+callno.getText()+"' ";
             pst=conn.prepareStatement(s);
             
             pst.execute();
                    callno.setText("");
                    name.setText("");
                    surname.setText("");
                     callno.setBackground(Color.white);
                    callno.setForeground(Color.black);
                    name.setBackground(Color.white);
                    name.setForeground(Color.black);
                    surname.setBackground(Color.white);
                    surname.setForeground(Color.black);
                
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }finally{
          try{
              rs.close();
              pst.close();
          }
          catch(SQLException e)
          {
      }
          
      }
        }
        
        
      
        
        
       
        
    }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField callno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name;
    private javax.swing.JTextField surname;
    // End of variables declaration//GEN-END:variables
}
