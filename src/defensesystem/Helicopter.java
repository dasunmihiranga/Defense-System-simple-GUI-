package defensesystem;

import java.awt.AWTEventMulticaster;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Helicopter extends javax.swing.JFrame implements Observer{
    //private String message;
    private MainController mainController;
    private int ammo;
    private int soldier;
    private Strength strength;
    private boolean isSelectPosition;
    
    public Helicopter(MainController mainController,int num) {
        this.mainController=mainController;
        initComponents();
        getContentPane().setBackground(Color.darkGray);
        setTitle("Helicopter");
        setVisible(true);
        setResizable(false);
        setLocation(40,3);
        soldierSpinner.setValue(20);
        soldier=20;
        ammoSpinner.setValue(1500);
        ammo=1500;
        btnSend.addActionListener((ActionEvent e) -> {
           mainController.setMainMessage(txtMessage.getText(),num);
           txtMessageArea.setText(txtMessageArea.getText()+"Me : "+txtMessage.getText()+"\n");
           txtMessage.setText("");
           
           
           
           
        });
        
        btnShoot.setEnabled(false);
        btnMissile.setEnabled(false);
        btnLaser.setEnabled(false);
        
       // int soldier=(Integer)soldierSpinner.getValue();

        ammoSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                
                ammo=((Integer)ammoSpinner.getValue());
                
            }
        });
        
        soldierSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
               
                soldier=((Integer)soldierSpinner.getValue());
                
            }
        });
        positionCheckbox.addActionListener((ActionEvent e) -> {
            if(positionCheckbox.isSelected()){
                isSelectPosition=true;
                
                
            }else{
                isSelectPosition=false;
                btnShoot.setEnabled(false);
                btnMissile.setEnabled(false);
                btnLaser.setEnabled(false);
            }
        });
        
          
    }
   
    @Override
    public void AreaUsage(boolean areaMessage){
        if(areaMessage==true){
            lblArea.setText("Area Cleared");
            lblArea.setFont(new Font("Segoe UI",Font.BOLD,15));
            lblArea.setForeground(new java.awt.Color(	15, 255, 80));
        }else{
            lblArea.setText("Area Not Cleared");
            lblArea.setFont(new Font("Segoe UI",Font.BOLD,15));
            lblArea.setForeground(new java.awt.Color(255, 49, 49));
        }
    }
     @Override
    public void Message(String Mainmessage) {
        txtMessageArea.setText(txtMessageArea.getText()+Mainmessage+"\n");
        
    }
     @Override
    public void Strength(Strength strength) {
        if(isSelectPosition){
            switch(strength){
                case LOW :
                    btnShoot.setEnabled(false);
                    btnLaser.setEnabled(false);
                    btnMissile.setEnabled(false);
                    break;
                case MEDIUM:
                    btnShoot.setEnabled(true);
                    btnLaser.setEnabled(false);
                    btnMissile.setEnabled(false);
                    break;
                case HIGH:
                    btnShoot.setEnabled(true);
                    btnLaser.setEnabled(true);
                    btnMissile.setEnabled(false);
                    break;
                case STRONG:
                    btnShoot.setEnabled(true);
                    btnLaser.setEnabled(true);
                    btnMissile.setEnabled(true);
                    break;
                case CLOSED:
                    btnShoot.setEnabled(true);
                    btnLaser.setEnabled(true);
                    btnMissile.setEnabled(true);
                    break;
                default :
                    btnShoot.setEnabled(false);
                    btnLaser.setEnabled(false);
                    btnMissile.setEnabled(false);
                    
            }
        }
        
       
    }
    @Override
    public int Ammo() {
        return ammo;
    }
    @Override
    public int Soldier() {
        return soldier;
    }
    @Override
    public void PrivateMessage(String message) {
        txtMessageArea.setText(txtMessageArea.getText()+"Main Headquarters : "+message+" ( Private )"+"\n");
        
    }

    
    

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblArea = new javax.swing.JLabel();
        btnShoot = new javax.swing.JButton();
        btnMissile = new javax.swing.JButton();
        btnLaser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessageArea = new javax.swing.JTextArea();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        soldierSpinner = new javax.swing.JSpinner();
        ammoSpinner = new javax.swing.JSpinner();
        positionCheckbox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(20);

        lblArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArea.setForeground(new java.awt.Color(255, 49, 49));
        lblArea.setText("Area Not Cleared");

        btnShoot.setBackground(new java.awt.Color(0, 255, 255));
        btnShoot.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnShoot.setForeground(java.awt.Color.darkGray);
        btnShoot.setText("Shoot");
        btnShoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShootActionPerformed(evt);
            }
        });

        btnMissile.setBackground(new java.awt.Color(0, 255, 255));
        btnMissile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMissile.setForeground(java.awt.Color.darkGray);
        btnMissile.setText("Missiled Operation");

        btnLaser.setBackground(new java.awt.Color(0, 255, 255));
        btnLaser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLaser.setForeground(java.awt.Color.darkGray);
        btnLaser.setText("Laser Operation");

        txtMessageArea.setBackground(java.awt.Color.darkGray);
        txtMessageArea.setColumns(20);
        txtMessageArea.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtMessageArea.setForeground(new java.awt.Color(0, 255, 255));
        txtMessageArea.setRows(5);
        jScrollPane1.setViewportView(txtMessageArea);

        txtMessage.setBackground(java.awt.Color.darkGray);
        txtMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(0, 255, 255));
        txtMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessageActionPerformed(evt);
            }
        });

        btnSend.setBackground(new java.awt.Color(255, 95, 31));
        btnSend.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSend.setForeground(java.awt.Color.darkGray);
        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jLabel1.setBackground(java.awt.Color.darkGray);
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Soldier Count");

        jLabel2.setBackground(java.awt.Color.darkGray);
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Ammo Count");

        soldierSpinner.setValue(10);
        soldierSpinner.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                soldierSpinnerComponentMoved(evt);
            }
        });

        positionCheckbox.setBackground(java.awt.Color.darkGray);
        positionCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        positionCheckbox.setForeground(new java.awt.Color(0, 255, 255));
        positionCheckbox.setText("Position");
        positionCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionCheckboxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Helicopter Control Panel");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 95, 31));
        jLabel4.setText("Area Clearence ->  ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 95, 31));
        jLabel5.setText("Functions Enable");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 95, 31));
        jLabel6.setText("Recived Message");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 95, 31));
        jLabel7.setText("Send Message");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 95, 31));
        jLabel8.setText("Helicopter Updates");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(ammoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(soldierSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnSend)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLaser, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(positionCheckbox)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(btnShoot, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMissile)))))
                        .addContainerGap(86, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(soldierSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ammoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(btnShoot)
                        .addGap(18, 18, 18)
                        .addComponent(btnLaser)
                        .addGap(18, 18, 18)
                        .addComponent(btnMissile)
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(positionCheckbox)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMessageActionPerformed

    private void soldierSpinnerComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_soldierSpinnerComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_soldierSpinnerComponentMoved

    private void btnShootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShootActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShootActionPerformed

    private void positionCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionCheckboxActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ammoSpinner;
    private javax.swing.JButton btnLaser;
    private javax.swing.JButton btnMissile;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnShoot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JCheckBox positionCheckbox;
    private javax.swing.JSpinner soldierSpinner;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextArea txtMessageArea;
    // End of variables declaration//GEN-END:variables

    

    

    
   

   
   

   

   


  
}
