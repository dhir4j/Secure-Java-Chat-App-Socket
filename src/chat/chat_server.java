package chat;
/**
 *
 * @author dhir4j
 */
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import static javax.swing.JOptionPane.showMessageDialog;

public class chat_server extends javax.swing.JFrame {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;
    private ServerSocket server;
    private int totalClients = 100;
    private int port = 6789;
    private int secretKey = 0;
    private String messageMSG;
    EncryDecry encyrDecry = new EncryDecry();
  
    public chat_server() {
        
        initComponents();
        this.setTitle("Server");
        this.setVisible(true);
        status.setVisible(true);
    }
    
    public void startRunning()
    {
        try
        {
            server=new ServerSocket(port, totalClients);
            while(true)
            {
                try
                {
                    status.setText(" Waiting for Someone to Connect...");
                    connection=server.accept();
                    status.setText(" Now Connected to "+connection.getInetAddress().getHostName());


                    output = new ObjectOutputStream(connection.getOutputStream());
                    output.flush();
                    input = new ObjectInputStream(connection.getInputStream());

                    whileChatting();

                }catch(EOFException eofException)
                {
                }
            }
        }
        catch(IOException ioException)
        {
                ioException.printStackTrace();
        }
    }
    
   private void whileChatting() throws IOException
   {
        String message="";    
        tfKey.setEditable(true);
        do{
                try
                {
                        message = (String) input.readObject();
                        chatArea.append("\n"+message);
                }catch(ClassNotFoundException classNotFoundException)
                {
                        
                }
        }while(!message.equals("Client - END"));
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        tfKey = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lableKey = new javax.swing.JLabel();
        btnKey = new javax.swing.JButton();
        btnPlainText = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(102, 255, 204));
        setMaximumSize(new java.awt.Dimension(556, 394));
        setMinimumSize(new java.awt.Dimension(556, 394));
        setPreferredSize(new java.awt.Dimension(556, 394));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(556, 394));
        jPanel1.setMinimumSize(new java.awt.Dimension(556, 394));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(556, 394));
        jPanel1.setLayout(null);

        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 530, 220);

        tfKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKeyActionPerformed(evt);
            }
        });
        jPanel1.add(tfKey);
        tfKey.setBounds(40, 320, 40, 20);

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton1.setText("Send");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(460, 350, 80, 40);

        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setText("...");
        jPanel1.add(status);
        status.setBounds(10, 60, 300, 40);

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("Server");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 10, 190, 60);

        jLabel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-10, 40, 50, 410);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(10, 350, 420, 40);

        lableKey.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        lableKey.setText("Key");
        jPanel1.add(lableKey);
        lableKey.setBounds(10, 320, 24, 20);

        btnKey.setBackground(new java.awt.Color(153, 255, 153));
        btnKey.setText("Send Key");
        btnKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyActionPerformed(evt);
            }
        });
        jPanel1.add(btnKey);
        btnKey.setBounds(280, 320, 100, 23);

        btnPlainText.setBackground(new java.awt.Color(153, 255, 153));
        btnPlainText.setText("Send Plain Text");
        btnPlainText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlainTextActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlainText);
        btnPlainText.setBounds(390, 320, 150, 23);

        btnClear.setBackground(new java.awt.Color(255, 102, 102));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear);
        btnClear.setBounds(100, 320, 72, 23);

        btnDecrypt.setBackground(new java.awt.Color(255, 255, 153));
        btnDecrypt.setText("Decrypt");
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });
        jPanel1.add(btnDecrypt);
        btnDecrypt.setBounds(180, 320, 90, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(566, 426));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void tfKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKeyActionPerformed
       String skey = tfKey.getText();
        secretKey = Integer.parseInt(skey);
    }//GEN-LAST:event_tfKeyActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        sendMessage(jTextField1.getText());
	jTextField1.setText("");
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void sendMessage(String message)
    {
        try
        {
            messageMSG = message;
            chatArea.append("\nME(Server) - "+message);
            String encryptedmsg = encyrDecry.encrypt(message, secretKey);
            
            output.writeObject("                                                             (enc):" + encryptedmsg);
            
           
            output.flush();
        }
        catch(IOException ioException)
        {
            chatArea.append("\n Unable to Send Message");
        }
    }
    
    
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
    private javax.swing.JLabel lableKey;
    private javax.swing.JLabel status;
    private javax.swing.JTextField tfKey;
    // End of variables declaration//GEN-END:variables
}
