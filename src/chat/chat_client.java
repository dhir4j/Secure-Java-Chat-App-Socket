package chat;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class chat_client extends javax.swing.JFrame {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message="";
    private String serverIP;
    private Socket connection;
    private int port = 6789;
    private int secretKey = 0;
    private String messageMSG;
    EncryDecry encyrDecry = new EncryDecry();
    
    
    public chat_client(String s) {
        
        initComponents();
        
        this.setTitle("Client");
        this.setVisible(true);
        status.setVisible(true);
        serverIP = s;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfKey = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelKey = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnKey = new javax.swing.JButton();
        btnPlainText = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        tfKey.setToolTipText("text\tType your message here...");
        tfKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKeyActionPerformed(evt);
            }
        });
        jPanel1.add(tfKey);
        tfKey.setBounds(40, 340, 40, 20);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(450, 370, 80, 40);

        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 510, 250);

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Client");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 20, 180, 40);

        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setText("...");
        jPanel1.add(status);
        status.setBounds(10, 50, 300, 40);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 20, 400);

        labelKey.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        labelKey.setForeground(new java.awt.Color(255, 255, 255));
        labelKey.setText("Key");
        jPanel1.add(labelKey);
        labelKey.setBounds(10, 340, 24, 20);

        jTextField1.setToolTipText("text\tType your message here...");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(10, 370, 430, 40);

        btnClear.setBackground(new java.awt.Color(255, 102, 102));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear);
        btnClear.setBounds(90, 340, 72, 23);

        btnKey.setBackground(new java.awt.Color(153, 255, 153));
        btnKey.setText("Send Key");
        btnKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyActionPerformed(evt);
            }
        });
        jPanel1.add(btnKey);
        btnKey.setBounds(270, 340, 100, 23);

        btnPlainText.setBackground(new java.awt.Color(153, 255, 153));
        btnPlainText.setText("Send Plain Text");
        btnPlainText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlainTextActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlainText);
        btnPlainText.setBounds(380, 340, 150, 23);

        btnDecrypt.setBackground(new java.awt.Color(255, 255, 153));
        btnDecrypt.setText("Decrypt");
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });
        jPanel1.add(btnDecrypt);
        btnDecrypt.setBounds(170, 340, 90, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(542, 449));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKeyActionPerformed
        String skey = tfKey.getText();
        secretKey = Integer.parseInt(skey);
        
    }//GEN-LAST:event_tfKeyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sKey = tfKey.getText();
        String sMessage = jTextField1.getText();
        
        if (sKey.equals("")  || onlyDigits(sKey)==false || Integer.valueOf(sKey)<1 ){
        showMessageDialog(null, "Please Enter Key, Key should be in integer > 0");
        }
        else if (sMessage.equals("")){
        showMessageDialog(null, "Please Enter Message");
        }        
        else{
        secretKey = Integer.parseInt(sKey);
        sendMessage(jTextField1.getText());
	jTextField1.setText("");
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
         sendMessage(jTextField1.getText());
	jTextField1.setText("");
    }//GEN-LAST:event_jTextField1ActionPerformed

    
    
        private void sendMessage(String message)
    {
        try
        {
            messageMSG = message;
            chatArea.append("\nME(Client) - "+message);
            String encryptedmsg = encyrDecry.encrypt(message, secretKey);
            System.out.println(encryptedmsg);
            output.writeObject("                                                             (enc):" + encryptedmsg);
            output.flush();
        }
        catch(IOException ioException)
        {
            chatArea.append("\n Unable to Send Message");
        }
    }
    
    
    private void btnKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeyActionPerformed
        
        if(secretKey == 0){
            showMessageDialog(null,"Use after Sending Messge");
        }
        else{
            try {
                output.writeObject("                                                             (key):" + secretKey);
            } catch (IOException ex) {
                chatArea.append("\n Unable to Send Message");
            }
        }
    }//GEN-LAST:event_btnKeyActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        jTextField1.setText("");
        tfKey.setText("");
        chatArea.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnPlainTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlainTextActionPerformed
        if(messageMSG==null){
            showMessageDialog(null, "Use after Sending Message");
        }
            else{
            String encryptedmsg = encyrDecry.encrypt(messageMSG, secretKey);
            EncryDecry encyrDecry = new EncryDecry();
            messageMSG = encyrDecry.decrypt(encryptedmsg, secretKey);
            try {
                output.writeObject("                                                             Server(decrypt) - " + messageMSG);
            } catch (IOException ex) {
                chatArea.append("\n Unable to Send Message");
            }
        }
    }//GEN-LAST:event_btnPlainTextActionPerformed

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
       String encryptedmsg = jTextField1.getText();
        String sKey = tfKey.getText();
        
        if (sKey.equals("")  || onlyDigits(sKey)==false || Integer.valueOf(sKey)<1 ){
        showMessageDialog(null, "Please Enter Key, Key should be in integer > 0");
        }
        else if(encryptedmsg.equals("")){
            showMessageDialog(null, "Please Enter Encrypted Text in Message box below");
        }
        else{
            secretKey = Integer.parseInt(sKey);
            EncryDecry encyrDecry = new EncryDecry();
            messageMSG = encyrDecry.decrypt(encryptedmsg, secretKey);

            jTextField1.setText("Plain Text: "+messageMSG);
        }
    }//GEN-LAST:event_btnDecryptActionPerformed

    
    public void startRunning()
    {
       try
       {
            status.setText("Attempting Connection ...");
            try
            {
                connection = new Socket(InetAddress.getByName(serverIP),port);
            }catch(IOException ioEception)
            {
                    JOptionPane.showMessageDialog(null,"Server Might Be Down!","Warning",JOptionPane.WARNING_MESSAGE);
            }
            status.setText("Connected to: " + connection.getInetAddress().getHostName());


            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());

            whileChatting();
       }
       catch(IOException ioException)
       {
            ioException.printStackTrace();
       }
    }
    
    private void whileChatting() throws IOException
    {
      tfKey.setEditable(true);
      do{
              try
              {
                      message = (String) input.readObject();
                      chatArea.append("\n"+message);
              }
              catch(ClassNotFoundException classNotFoundException)
              {
              }
      }while(!message.equals("Client - END"));
    }
  
    
    private boolean onlyDigits(String str)
    {
        // Traverse the string from
        // start to end
        int n = str.length();
        for (int i = 0; i < n; i++) {
 
            // Check if character is
            // not a digit between 0-9
            // then return false
            if (str.charAt(i) < '0'
                || str.charAt(i) > '9') {
                return false;
            }
        }
          // If we reach here, that means
          // all characters were digits.
        return true;
    }   

  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnKey;
    private javax.swing.JButton btnPlainText;
    private javax.swing.JTextArea chatArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelKey;
    private javax.swing.JLabel status;
    private javax.swing.JTextField tfKey;
    // End of variables declaration//GEN-END:variables
}
