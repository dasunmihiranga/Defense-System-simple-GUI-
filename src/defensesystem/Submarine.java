
package defensesystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Submarine extends javax.swing.JFrame implements Observer{
    private int soldier;
    private int ammo;
    private boolean isSelectPosition;

    public Submarine(MainController mainController,int num) {
        initComponents();
         setTitle("Submarine");
         getContentPane().setBackground(Color.darkGray);
        setVisible(true);
        setResizable(false);
        soldierSpinner.setValue(50);
        soldier=50;
        ammoSpinner.setValue(2000);
        ammo=2000;
        setLocation(40,365);
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
        btnSonar.setEnabled(false);
        btnTrident.setEnabled(false);
        btnTomahawk.setEnabled(false);
        
         positionCheckbox.addActionListener((ActionEvent e) -> {
            if(positionCheckbox.isSelected()){
                isSelectPosition=true;
                
            }else{
                isSelectPosition=false;
                btnShoot.setEnabled(false);
                btnSonar.setEnabled(false);
                btnTrident.setEnabled(false);
                btnTomahawk.setEnabled(false);
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
                    btnSonar.setEnabled(false);
                    btnTrident.setEnabled(false);
                    btnTomahawk.setEnabled(false);
                    break;
                case MEDIUM:
                     btnShoot.setEnabled(true);
                    btnSonar.setEnabled(false);
                    btnTrident.setEnabled(false);
                    btnTomahawk.setEnabled(false);
                    break;
                case HIGH:
                     btnShoot.setEnabled(true);
                    btnSonar.setEnabled(true);
                    btnTrident.setEnabled(false);
                    btnTomahawk.setEnabled(false);
                    break;
                case STRONG:
                    btnShoot.setEnabled(true);
                    btnSonar.setEnabled(true);
                    btnTrident.setEnabled(true);
                    btnTomahawk.setEnabled(false);
                    break;
                case CLOSED:
                    btnShoot.setEnabled(true);
                    btnSonar.setEnabled(true);
                    btnTrident.setEnabled(true);
                    btnTomahawk.setEnabled(true);
                    break;
                default :
                    btnShoot.setEnabled(false);
                    btnSonar.setEnabled(false);
                    btnTrident.setEnabled(false);
                    btnTomahawk.setEnabled(false);
                    
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
        btnTomahawk = new javax.swing.JButton();
        btnSonar = new javax.swing.JButton();
        btnTrident = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessageArea = new javax.swing.JTextArea();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        positionCheckbox = new javax.swing.JCheckBox();
        soldierSpinner = new javax.swing.JSpinner();
        ammoSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
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

        btnTomahawk.setBackground(new java.awt.Color(0, 255, 255));
        btnTomahawk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTomahawk.setForeground(java.awt.Color.darkGray);
        btnTomahawk.setText("Tomahawk Missile");

        btnSonar.setBackground(new java.awt.Color(0, 255, 255));
        btnSonar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSonar.setForeground(java.awt.Color.darkGray);
        btnSonar.setText("Sonar Operation");

        btnTrident.setBackground(new java.awt.Color(0, 255, 255));
        btnTrident.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTrident.setForeground(java.awt.Color.darkGray);
        btnTrident.setText("Trident-2 Missile");

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
        jLabel1.setText("Submarine Control Panel");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 95, 31));
        jLabel4.setText("Area Clearence -> ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 95, 31));
        jLabel5.setText("Received Message");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 95, 31));
        jLabel6.setText("Send Message");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 95, 31));
        jLabel7.setText("Submarine Updates");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 95, 31));
        jLabel8.setText("Functions Enable");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblArea)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnSend))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ammoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(soldierSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnShoot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSonar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTrident, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTomahawk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(positionCheckbox))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(soldierSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSend))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ammoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(btnShoot)
                        .addGap(18, 18, 18)
                        .addComponent(btnSonar)
                        .addGap(18, 18, 18)
                        .addComponent(btnTrident)
                        .addGap(18, 18, 18)
                        .addComponent(btnTomahawk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(positionCheckbox)
                        .addGap(50, 50, 50))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void positionCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionCheckboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ammoSpinner;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnShoot;
    private javax.swing.JButton btnSonar;
    private javax.swing.JButton btnTomahawk;
    private javax.swing.JButton btnTrident;
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
