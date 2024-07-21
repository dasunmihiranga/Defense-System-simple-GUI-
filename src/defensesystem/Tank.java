
package defensesystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Tank extends javax.swing.JFrame implements Observer{
    private int ammo;
    private int soldier;
    private boolean isSelectPosition;
    
    public Tank(MainController mainController,int num) {
       
        initComponents();
        setTitle("Tank");
        getContentPane().setBackground(Color.darkGray);
        setVisible(true);
        setResizable(false);
        setLocation(700,3);
        soldierSpinner.setValue(2000);
        soldier=2000;
        ammoSpinner.setValue(70);
        ammo=70;
        btnSend.addActionListener((ActionEvent e) -> {
            mainController.setMainMessage(txtMessage.getText(),num);
            txtMessageArea.setText(txtMessageArea.getText()+"Me : "+txtMessage.getText()+"\n");
            txtMessage.setText("");
            
        });
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
        btnShoot.setEnabled(false);
        btnMissile.setEnabled(false);
        btnRedar.setEnabled(false);
        btnRotate.setEnabled(false);
        
        positionCheckbox.addActionListener((ActionEvent e) -> {
            if(positionCheckbox.isSelected()){
                isSelectPosition=true;
                
            }else{
                isSelectPosition=false;
                btnShoot.setEnabled(false);
                btnMissile.setEnabled(false);
                btnRedar.setEnabled(false);
                btnRotate.setEnabled(false);
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
                    btnRedar.setEnabled(false);
                    btnMissile.setEnabled(false);
                    btnRotate.setEnabled(false);
                    break;
                case MEDIUM:
                    btnShoot.setEnabled(true);
                    btnRedar.setEnabled(false);
                    btnMissile.setEnabled(false);
                    btnRotate.setEnabled(false);
                    break;
                case HIGH:
                    btnShoot.setEnabled(true);
                    btnRedar.setEnabled(true);
                    btnMissile.setEnabled(false);
                    btnRotate.setEnabled(false);
                    break;
                case STRONG:
                    btnShoot.setEnabled(true);
                    btnRedar.setEnabled(true);
                    btnMissile.setEnabled(true);
                    btnRotate.setEnabled(false);
                    break;
                case CLOSED:
                     btnShoot.setEnabled(true);
                    btnRedar.setEnabled(true);
                    btnMissile.setEnabled(true);
                    btnRotate.setEnabled(true);
                    break;
                default :
                     btnShoot.setEnabled(false);
                    btnRedar.setEnabled(false);
                    btnMissile.setEnabled(false);
                    btnRotate.setEnabled(false);
                    
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

        jTextField1 = new javax.swing.JTextField();
        lblArea = new javax.swing.JLabel();
        btnShoot = new javax.swing.JButton();
        btnRedar = new javax.swing.JButton();
        btnMissile = new javax.swing.JButton();
        btnRotate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessageArea = new javax.swing.JTextArea();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        soldierSpinner = new javax.swing.JSpinner();
        ammoSpinner = new javax.swing.JSpinner();
        positionCheckbox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        btnRedar.setBackground(new java.awt.Color(0, 255, 255));
        btnRedar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRedar.setForeground(java.awt.Color.darkGray);
        btnRedar.setText("Redar Operation");
        btnRedar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedarActionPerformed(evt);
            }
        });

        btnMissile.setBackground(new java.awt.Color(0, 255, 255));
        btnMissile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMissile.setForeground(java.awt.Color.darkGray);
        btnMissile.setText("Missile Operation");
        btnMissile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMissileActionPerformed(evt);
            }
        });

        btnRotate.setBackground(new java.awt.Color(0, 255, 255));
        btnRotate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRotate.setForeground(java.awt.Color.darkGray);
        btnRotate.setText("Rotate Shooting");
        btnRotate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotateActionPerformed(evt);
            }
        });

        txtMessageArea.setBackground(java.awt.Color.darkGray);
        txtMessageArea.setColumns(20);
        txtMessageArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMessageArea.setForeground(new java.awt.Color(0, 255, 255));
        txtMessageArea.setRows(5);
        jScrollPane1.setViewportView(txtMessageArea);

        txtMessage.setBackground(java.awt.Color.darkGray);
        txtMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(0, 255, 255));

        btnSend.setBackground(new java.awt.Color(255, 95, 31));
        btnSend.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSend.setForeground(java.awt.Color.darkGray);
        btnSend.setText("Send");

        jLabel2.setBackground(java.awt.Color.darkGray);
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Soldier Count");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Ammo Count");

        positionCheckbox.setBackground(java.awt.Color.darkGray);
        positionCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        positionCheckbox.setForeground(new java.awt.Color(0, 255, 255));
        positionCheckbox.setText("Position");
        positionCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionCheckboxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Tank Control Panel");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 95, 31));
        jLabel4.setText("Area Clearence -> ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 95, 31));
        jLabel5.setText("Receive Message");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 95, 31));
        jLabel6.setText("Send Message");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 95, 31));
        jLabel7.setText("Tank Updates");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 95, 31));
        jLabel8.setText("Functions Enable");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnSend)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(soldierSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(ammoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(90, 90, 90)))
                            .addComponent(positionCheckbox))
                        .addGap(0, 82, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(243, 243, 243))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMissile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRedar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnShoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRotate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(soldierSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(219, 219, 219))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ammoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnShoot)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRedar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMissile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRotate)
                                .addGap(3, 3, 3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(positionCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShootActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShootActionPerformed

    private void btnRedarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRedarActionPerformed

    private void btnRotateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRotateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRotateActionPerformed

    private void btnMissileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMissileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMissileActionPerformed

    private void positionCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionCheckboxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ammoSpinner;
    private javax.swing.JButton btnMissile;
    private javax.swing.JButton btnRedar;
    private javax.swing.JButton btnRotate;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JCheckBox positionCheckbox;
    private javax.swing.JSpinner soldierSpinner;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextArea txtMessageArea;
    // End of variables declaration//GEN-END:variables

    

   

}
