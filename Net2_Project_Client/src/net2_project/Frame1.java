/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package net2_project;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author Ayham Dw
 */
public class Frame1 extends javax.swing.JFrame {

    /**
     * Creates new form Frame1
     */
    String dataStr = "";
    String firstServiceResponse = "";
    String secondServiceResponse = "";

    public Frame1() {
        initComponents();
    }

    public void enableButtons() {
        this.buttonPage1.setEnabled(true);
        this.buttonPage2.setEnabled(true);
        this.buttonPage3.setEnabled(true);
        this.buttonPage4.setEnabled(true);
    }

    public void disableButtons() {
        this.buttonPage1.setEnabled(false);
        this.buttonPage2.setEnabled(false);
        this.buttonPage3.setEnabled(false);
        this.buttonPage4.setEnabled(false);
    }

    public void responsePage1() {
        String urlPage1 = "http://127.0.0.1:80/NetHW/Services/Service1.php";
       
    }
     public void responsePage2() {
        String urlPage2 = "http://127.0.0.1:80/NetHW/Services/Service2.php";
       
    }
      public void responsePage3() {
        String urlPage3 = "http://127.0.0.1:80/NetHW/Services/Service3.php";
       
    }
       public void responsePage4() {
        String urlPage4 = "http://127.0.0.1:80/NetHW/Services/Service4.php";
       
    }

    public void addParameter(String ps, String vs) {
        if (ps == null || vs == null || ps.length() == 0 || vs.length() == 0) {
            return;
        }
        if (dataStr.length() > 0) {
            dataStr += "&";
        }
        try {
            dataStr += ps + "=" + URLEncoder.encode(vs, "UTF-8"); //"ASCII");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void firstVerify() {
//        DataInputStream input;
        int check;
        String username = this.usernameTextField.getText();
        String password = new String(this.passwordTextField.getPassword());
        String firstVerifyURL = "http://localhost:8085/Project_Net2/firstService.jsp";
        try {
            String string = firstVerifyURL + "?username=" + username + "&password=" + password;
            URL url = new URL(string);

//            input = new DataInputStream(url.openConnection().getInputStream());
            HttpURLConnection myConn = (HttpURLConnection) url.openConnection();
            InputStream inputStream = myConn.getInputStream();
            firstServiceResponse = "";
            while ((check = inputStream.read()) != -1) {
                firstServiceResponse = firstServiceResponse + (char) check;

            }
            this.firstResponse.setText("");
            this.firstResponse.setText(firstServiceResponse);

        } catch (IOException e) {
            System.out.println(e.toString());
            this.firstResponse.setText("Error");
        }
        if (this.secondResponse.getText().trim().equalsIgnoreCase("OK") && this.firstResponse.getText().trim().equalsIgnoreCase("OK")) {
            enableButtons();
        } else {
            disableButtons();
        }
    }

    public void secondVerify() {
//        DataInputStream input;
        int check;
        String id = this.idTextField.getText();
        String password = new String(this.passwordTextField.getPassword());
        String seoncdVerifyURL = "http://localhost:8085/Project_Net2/Net2_Servlet";
        try {
            String string = seoncdVerifyURL + "?id=" + id + "&password=" + password;
            URL url = new URL(string);

            HttpURLConnection myConn = (HttpURLConnection) url.openConnection();
            InputStream inputStream = myConn.getInputStream();
            secondServiceResponse = "";
            while ((check = inputStream.read()) != -1) {
                secondServiceResponse = secondServiceResponse + (char) check;
            }
            this.secondResponse.setText("");
            this.secondResponse.setText(secondServiceResponse);

        } catch (IOException e) {
            System.out.println(e.toString());
            this.secondResponse.setText("Error");
        }

        if (this.secondResponse.getText().trim().equalsIgnoreCase("OK") && this.firstResponse.getText().trim().equalsIgnoreCase("OK")) {
            enableButtons();
        } else {
            disableButtons();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        usernameTextField = new javax.swing.JTextField();
        firstVerify = new javax.swing.JButton();
        secondVerify = new javax.swing.JButton();
        secondResponse = new javax.swing.JLabel();
        firstResponse = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        buttonPage3 = new javax.swing.JButton();
        buttonPage4 = new javax.swing.JButton();
        buttonPage2 = new javax.swing.JButton();
        buttonPage1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Network_2 Project");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Username ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Identification");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Password");

        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        firstVerify.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstVerify.setText("Verify #1");
        firstVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstVerifyActionPerformed(evt);
            }
        });

        secondVerify.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        secondVerify.setText("Verify #2");
        secondVerify.setToolTipText("");
        secondVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondVerifyActionPerformed(evt);
            }
        });

        secondResponse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        secondResponse.setText("Second Response");

        firstResponse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstResponse.setText("First Response");

        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        buttonPage3.setText("Page #3");
        buttonPage3.setEnabled(false);
        buttonPage3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPage3ActionPerformed(evt);
            }
        });

        buttonPage4.setText("Page #4");
        buttonPage4.setEnabled(false);
        buttonPage4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPage4ActionPerformed(evt);
            }
        });

        buttonPage2.setText("Page #2");
        buttonPage2.setEnabled(false);
        buttonPage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPage2ActionPerformed(evt);
            }
        });

        buttonPage1.setText("Page #1");
        buttonPage1.setEnabled(false);
        buttonPage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPage1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstResponse, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(buttonPage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(buttonPage2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(firstVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPage3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonPage4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(secondResponse)
                            .addComponent(secondVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(firstVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secondResponse)
                    .addComponent(firstResponse))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPage3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPage4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPage2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPage1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void firstVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstVerifyActionPerformed
        firstVerify();
    }//GEN-LAST:event_firstVerifyActionPerformed

    private void secondVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondVerifyActionPerformed
        secondVerify();
    }//GEN-LAST:event_secondVerifyActionPerformed

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    private void buttonPage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPage2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPage2ActionPerformed

    private void buttonPage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPage1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPage1ActionPerformed

    private void buttonPage3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPage3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPage3ActionPerformed

    private void buttonPage4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPage4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPage4ActionPerformed

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
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPage1;
    private javax.swing.JButton buttonPage2;
    private javax.swing.JButton buttonPage3;
    private javax.swing.JButton buttonPage4;
    private javax.swing.JLabel firstResponse;
    private javax.swing.JButton firstVerify;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel secondResponse;
    private javax.swing.JButton secondVerify;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}