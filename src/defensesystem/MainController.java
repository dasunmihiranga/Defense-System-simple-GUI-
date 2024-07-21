
package defensesystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainController extends javax.swing.JFrame {
    private DefenseObservableInterface defenceObservable;
    private boolean privateCheckBoxisSelect;

    public MainController(DefenseObservableInterface defenceObservable) {
        
        this.defenceObservable=defenceObservable;
        initComponents();
        getContentPane().setBackground(Color.darkGray);
        setResizable(false);
        setLocation(725,365);
        AreaMessageCheckBox.addActionListener((ActionEvent e) -> {
            if(AreaMessageCheckBox.isSelected()){
                defenceObservable.setAreaUsage(true);
            }else{
                defenceObservable.setAreaUsage(false);
                
            }
        });
        btnSend.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(privateCheckBoxisSelect){
                    String value= Combobox.getSelectedItem().toString();
                    switch (value) {
                        case "HeliCopter":
                            defenceObservable.setPrivateMessage(txtSendField.getText(), 1);
                            txtMainArea.setText(txtMainArea.getText()+"Me :"+txtSendField.getText()+"\n");
                            txtSendField.setText("");
                            
                            break;
                            
                            
                        case "Tank":
                            defenceObservable.setPrivateMessage(txtSendField.getText(), 2);
                            txtMainArea.setText(txtMainArea.getText()+"Me :"+txtSendField.getText()+"\n");
                            txtSendField.setText("");
                            
                            break;
                            
                        case "Submarine":
                            defenceObservable.setPrivateMessage(txtSendField.getText(), 3);
                            txtMainArea.setText(txtMainArea.getText()+"Me :"+txtSendField.getText()+"\n");
                            txtSendField.setText("");
                            
                            break;
                            
                        default:
                            break;
                    }
                }else{
                    defenceObservable.setMassage("Main Headquarters : "+txtSendField.getText());
                    txtMainArea.setText(txtMainArea.getText()+"Me :"+txtSendField.getText()+"\n");
                    txtSendField.setText("");
                    
                }
            }
        });
        positionSlider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                int positionLevel=positionSlider.getValue();
                //System.out.println(positionLevel);
                if(0<positionLevel && 20>positionLevel){
                    //System.out.println("Low");
                    defenceObservable.setStrength(Strength.LOW);
                }else if(20<positionLevel && 40>positionLevel){
                    //System.out.println("Medium");
                    defenceObservable.setStrength(Strength.MEDIUM);
                }else if(40<positionLevel && 60>positionLevel){
                    //System.out.println("High");
                    defenceObservable.setStrength(Strength.HIGH);
                }else if(60<positionLevel && 80>positionLevel){
                    //System.out.println("Strong");
                    defenceObservable.setStrength(Strength.STRONG);
                }else if(positionLevel>80){
                    //System.out.println("Closed");
                    defenceObservable.setStrength(Strength.CLOSED);
                }
                
            }
        });
        
        Combobox.addItem("HeliCopter");
        Combobox.addItem("Tank");
        Combobox.addItem("Submarine");
        btnCollect.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String value= Combobox.getSelectedItem().toString();
                switch (value) {
                    case "HeliCopter":
                        {
                            int ammo=defenceObservable.getAmmo(1);
                            int soldier=defenceObservable.getSoldier(1);
                            txtSoldier.setText(Integer.toString(soldier));
                            txtAmmo.setText(Integer.toString(ammo));
                            lblInformation.setText("Unit Information ( Helicopter )");
                            
                            break;
                        }
                    case "Tank":
                        {
                            int ammo=defenceObservable.getAmmo(2);
                            int soldier=defenceObservable.getSoldier(2);
                            txtSoldier.setText(Integer.toString(soldier));
                            txtAmmo.setText(Integer.toString(ammo));
                            lblInformation.setText("Unit Information ( Tank )");
                            break;
                        }
                    case "Submarine":
                        {
                            int ammo=defenceObservable.getAmmo(3);
                            int soldier=defenceObservable.getSoldier(3);
                            txtSoldier.setText(Integer.toString(soldier));
                            txtAmmo.setText(Integer.toString(ammo));
                            lblInformation.setText("Unit Information ( Submarine )");
                            break;
                        }
                    default:
                        break;
                }
            }
        });
        
        privateCheckBox.addActionListener((ActionEvent e) -> {
            String value= Combobox.getSelectedItem().toString();
            if(privateCheckBox.isSelected()){
                privateCheckBoxisSelect=true;
                lblSendMessage.setText("Send Message ( "+value+" )");
                
                
                
            }else{
                privateCheckBoxisSelect=false;
                lblSendMessage.setText("Send Message ( Public )");
            }
        });
        
        
        
        
    }
    public void setMainMessage(String MainMessage,int num){
        switch (num){
            case 1:
                txtMainArea.setText(txtMainArea.getText()+"Helicopter : "+MainMessage+"\n");
                break;
            case 2:
               txtMainArea.setText(txtMainArea.getText()+"Tank : "+MainMessage+"\n"); 
               break;
            case 3:
                txtMainArea.setText(txtMainArea.getText()+"Submarine : "+MainMessage+"\n"); 
        }
        
       
    }
    
    

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Combobox = new javax.swing.JComboBox<>();
        btnCollect = new javax.swing.JButton();
        AreaMessageCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        positionSlider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMainArea = new javax.swing.JTextArea();
        privateCheckBox = new javax.swing.JCheckBox();
        btnSend = new javax.swing.JButton();
        txtSoldier = new javax.swing.JTextField();
        txtAmmo = new javax.swing.JTextField();
        txtSendField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblSendMessage = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblInformation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(java.awt.Color.darkGray);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.darkGray);

        Combobox.setBackground(java.awt.Color.darkGray);
        Combobox.setForeground(new java.awt.Color(0, 255, 255));
        Combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboboxActionPerformed(evt);
            }
        });

        btnCollect.setBackground(new java.awt.Color(0, 255, 255));
        btnCollect.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCollect.setForeground(java.awt.Color.darkGray);
        btnCollect.setText("Collect Informations");
        btnCollect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollectActionPerformed(evt);
            }
        });

        AreaMessageCheckBox.setBackground(java.awt.Color.darkGray);
        AreaMessageCheckBox.setForeground(new java.awt.Color(0, 255, 255));
        AreaMessageCheckBox.setText("Area Clear");
        AreaMessageCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaMessageCheckBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Slider Count");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Ammo Amount");

        positionSlider.setBackground(java.awt.Color.darkGray);
        positionSlider.setForeground(new java.awt.Color(0, 255, 255));
        positionSlider.setMajorTickSpacing(10);
        positionSlider.setPaintLabels(true);
        positionSlider.setPaintTicks(true);
        positionSlider.setValue(0);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 95, 31));
        jLabel4.setText("Position");

        txtMainArea.setBackground(java.awt.Color.darkGray);
        txtMainArea.setColumns(20);
        txtMainArea.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtMainArea.setForeground(new java.awt.Color(0, 255, 255));
        txtMainArea.setRows(5);
        jScrollPane4.setViewportView(txtMainArea);

        privateCheckBox.setBackground(java.awt.Color.darkGray);
        privateCheckBox.setForeground(new java.awt.Color(0, 255, 255));
        privateCheckBox.setText("Send Private ");

        btnSend.setBackground(new java.awt.Color(255, 95, 31));
        btnSend.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSend.setForeground(java.awt.Color.darkGray);
        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtSoldier.setBackground(java.awt.Color.darkGray);
        txtSoldier.setForeground(new java.awt.Color(0, 255, 255));

        txtAmmo.setBackground(java.awt.Color.darkGray);
        txtAmmo.setForeground(new java.awt.Color(0, 255, 255));
        txtAmmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmmoActionPerformed(evt);
            }
        });

        txtSendField.setBackground(java.awt.Color.darkGray);
        txtSendField.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtSendField.setForeground(new java.awt.Color(0, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Defense System Main Controll");

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 95, 31));
        jLabel6.setText(" Received Message");

        lblSendMessage.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSendMessage.setForeground(new java.awt.Color(255, 95, 31));
        lblSendMessage.setText("Send Message ( Public )");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 95, 31));
        jLabel7.setText("Select Unit");

        lblInformation.setBackground(new java.awt.Color(255, 51, 0));
        lblInformation.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInformation.setForeground(new java.awt.Color(255, 95, 31));
        lblInformation.setText("Unit Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(positionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addGap(16, 16, 16)
                                .addComponent(txtSoldier, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addComponent(txtAmmo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCollect)
                            .addComponent(lblInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(AreaMessageCheckBox)
                        .addGap(166, 166, 166)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtSendField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSendMessage))
                    .addComponent(privateCheckBox, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AreaMessageCheckBox)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(positionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtSoldier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAmmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCollect))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSendField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(privateCheckBox)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AreaMessageCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaMessageCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AreaMessageCheckBoxActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSendActionPerformed

    private void ComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboboxActionPerformed

    private void txtAmmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmmoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmmoActionPerformed

    private void btnCollectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCollectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AreaMessageCheckBox;
    private javax.swing.JComboBox<String> Combobox;
    private javax.swing.JButton btnCollect;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblSendMessage;
    private javax.swing.JSlider positionSlider;
    private javax.swing.JCheckBox privateCheckBox;
    private javax.swing.JTextField txtAmmo;
    private javax.swing.JTextArea txtMainArea;
    private javax.swing.JTextField txtSendField;
    private javax.swing.JTextField txtSoldier;
    // End of variables declaration//GEN-END:variables

  

    

    

 

    

    
}
