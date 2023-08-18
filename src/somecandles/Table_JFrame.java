package somecandles;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Table_JFrame extends javax.swing.JFrame implements ActionListener {

    int candleClickCount = 0;
    
    //
    // Timer, Flames
    int timerElapsedTime = 0;            // test numbers:    60000, 3600000
    int timerSeconds = 0;
    int timerMinutes = 0;
    int timerHours = 0;
    
    boolean timerStarted = false;
    
    String timerSeconds_string = String.format("%02d", timerSeconds);
    String timerMinutes_string = String.format("%02d", timerMinutes);
    String timerHours_string = String.format("%02d", timerHours);
    
    
    /**
     * Creates new form Table_JFrame
     */
    public Table_JFrame() {
        initComponents();
        
        scaleTableImg();
        scaleBowlImg();
        initTimer();
        hideFireGIF();
        scaleCandlesImg();
        
    }
    
    
    public void scaleTableImg() {
    
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/table_texture.png"));
        Image img = icon.getImage();
        
        Image imgScale = img.getScaledInstance(imgBackground.getWidth(), imgBackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imgBackground.setIcon(scaledIcon);
    
    }
    
    public void scaleCandlesImg() {
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
        Image img = icon.getImage();
        
        Image imgScale = img.getScaledInstance(imgCandle1.getWidth(), imgCandle1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imgCandle1.setIcon(scaledIcon);
        
        imgScale = img.getScaledInstance(imgCandle2.getWidth(), imgCandle2.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        imgCandle2.setIcon(scaledIcon);
        
        imgScale = img.getScaledInstance(imgCandle3.getWidth(), imgCandle3.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        imgCandle3.setIcon(scaledIcon);
        
        imgScale = img.getScaledInstance(imgCandle4.getWidth(), imgCandle4.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        imgCandle4.setIcon(scaledIcon);
        
        imgScale = img.getScaledInstance(imgCandle5.getWidth(), imgCandle5.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        imgCandle5.setIcon(scaledIcon);
        
        imgScale = img.getScaledInstance(imgCandle6.getWidth(), imgCandle6.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        imgCandle6.setIcon(scaledIcon);
        
        imgScale = img.getScaledInstance(imgCandle7.getWidth(), imgCandle7.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        imgCandle7.setIcon(scaledIcon);
        
        imgScale = img.getScaledInstance(imgCandle8.getWidth(), imgCandle8.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        imgCandle8.setIcon(scaledIcon);
        
        imgScale = img.getScaledInstance(imgCandle9.getWidth(), imgCandle9.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        imgCandle9.setIcon(scaledIcon);
        
        imgScale = img.getScaledInstance(imgCandle_10.getWidth(), imgCandle_10.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        imgCandle_10.setIcon(scaledIcon);
        
    }
    
    public void scaleBowlImg() {
    
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/bowl.png"));
        Image img = icon.getImage();
        
        Image imgScale = img.getScaledInstance(imgBowl.getWidth(), imgBowl.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imgBowl.setIcon(scaledIcon);
    
    }
    
    
    // Overridden interface method. (Don't remove!)
    // This method is empty because MouseClicked events are
    // handled elsewhere.
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    
    Timer timerObject = new Timer(1000, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
            
            timerElapsedTime = timerElapsedTime + 1000;               // ( iterating by 1 second )

            //System.out.println(timerTestLabel + " ! ");
            
            if(timerElapsedTime >= 6000){                           // ( after 6 seconds ... ) 
                timerStarted = false;
                hideFireGIF();
                resetTimer();
                
            } else {
                timerHours = (timerElapsedTime/3600000);
                timerMinutes = (timerElapsedTime/60000) % 60;
                timerSeconds = (timerElapsedTime/1000) % 60;

                timerSeconds_string = String.format("%02d", timerSeconds);
                timerMinutes_string = String.format("%02d", timerMinutes);
                timerHours_string = String.format("%02d", timerHours);
                
                timerTestLabel.setText(timerHours_string+":"+timerMinutes_string+":"+timerSeconds_string);
            
            }

        }
        
        
    });
    
            
    private void initTimer(){
    
        timerTestLabel.setVisible(false);
        //timerTestLabel.setVisible(true);
        
        timerTestLabel.setText(timerHours_string+":"+timerMinutes_string+":"+timerSeconds_string);
    
    }

    private void startTimer(){
    
        timerObject.start();
        
    }
    
    private void resetTimer(){
        
        timerObject.stop();
        
        timerElapsedTime = 0;
        timerSeconds = 0;
        timerMinutes = 0;
        timerHours = 0;
        
        timerSeconds_string = String.format("%02d", timerSeconds);
        timerMinutes_string = String.format("%02d", timerMinutes);
        timerHours_string = String.format("%02d", timerHours);

        timerTestLabel.setText(timerHours_string+":"+timerMinutes_string+":"+timerSeconds_string);
        
    }
    
    
    private void hideFireGIF() {
        
        gifFlames.setVisible(false);
        
    }

    private void showFireGIF() {
        
        gifFlames.setVisible(true);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JTabbedPane();
        panelTab1_Game = new javax.swing.JPanel();
        timerTestLabel = new javax.swing.JLabel();
        gifFlames = new javax.swing.JLabel();
        imgBowl = new javax.swing.JLabel();
        imgCandle8 = new javax.swing.JLabel();
        imgCandle9 = new javax.swing.JLabel();
        imgCandle_10 = new javax.swing.JLabel();
        imgCandle1 = new javax.swing.JLabel();
        imgCandle2 = new javax.swing.JLabel();
        imgCandle3 = new javax.swing.JLabel();
        imgCandle6 = new javax.swing.JLabel();
        imgCandle5 = new javax.swing.JLabel();
        imgCandle4 = new javax.swing.JLabel();
        imgCandle7 = new javax.swing.JLabel();
        imgBackground = new javax.swing.JLabel();
        panelTab2_About = new javax.swing.JPanel();
        imgAbout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Some Candles");
        setResizable(false);

        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panelTab1_Game.setMinimumSize(new java.awt.Dimension(500, 498));
        panelTab1_Game.setPreferredSize(new java.awt.Dimension(500, 498));
        panelTab1_Game.setLayout(null);

        timerTestLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerTestLabel.setText("00:00:00");
        panelTab1_Game.add(timerTestLabel);
        timerTestLabel.setBounds(140, 20, 50, 20);

        gifFlames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fire_gif.gif"))); // NOI18N
        panelTab1_Game.add(gifFlames);
        gifFlames.setBounds(110, -132, 500, 498);

        imgBowl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bowl.png"))); // NOI18N
        imgBowl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgBowlMouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgBowl);
        imgBowl.setBounds(260, 190, 200, 200);

        imgCandle8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candle_a.png"))); // NOI18N
        imgCandle8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCandle8MouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgCandle8);
        imgCandle8.setBounds(190, 320, 79, 184);

        imgCandle9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candle_a.png"))); // NOI18N
        imgCandle9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCandle9MouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgCandle9);
        imgCandle9.setBounds(130, 220, 79, 184);

        imgCandle_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candle_a.png"))); // NOI18N
        imgCandle_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCandle_10MouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgCandle_10);
        imgCandle_10.setBounds(110, 140, 79, 184);

        imgCandle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candle_a.png"))); // NOI18N
        imgCandle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCandle1MouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgCandle1);
        imgCandle1.setBounds(140, 60, 79, 184);

        imgCandle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candle_a.png"))); // NOI18N
        imgCandle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCandle2MouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgCandle2);
        imgCandle2.setBounds(270, 10, 79, 184);

        imgCandle3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candle_a.png"))); // NOI18N
        imgCandle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCandle3MouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgCandle3);
        imgCandle3.setBounds(410, 30, 79, 184);

        imgCandle6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candle_a.png"))); // NOI18N
        imgCandle6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCandle6MouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgCandle6);
        imgCandle6.setBounds(460, 320, 79, 184);

        imgCandle5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candle_a.png"))); // NOI18N
        imgCandle5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCandle5MouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgCandle5);
        imgCandle5.setBounds(520, 220, 79, 184);

        imgCandle4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candle_a.png"))); // NOI18N
        imgCandle4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCandle4MouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgCandle4);
        imgCandle4.setBounds(500, 110, 79, 184);

        imgCandle7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candle_a.png"))); // NOI18N
        imgCandle7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCandle7MouseClicked(evt);
            }
        });
        panelTab1_Game.add(imgCandle7);
        imgCandle7.setBounds(330, 350, 79, 184);

        imgBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/table_texture.png"))); // NOI18N
        panelTab1_Game.add(imgBackground);
        imgBackground.setBounds(6, 6, 693, 580);

        mainPanel.addTab("Game", panelTab1_Game);

        imgAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/some_candles_about.png"))); // NOI18N

        javax.swing.GroupLayout panelTab2_AboutLayout = new javax.swing.GroupLayout(panelTab2_About);
        panelTab2_About.setLayout(panelTab2_AboutLayout);
        panelTab2_AboutLayout.setHorizontalGroup(
            panelTab2_AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTab2_AboutLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(imgAbout)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        panelTab2_AboutLayout.setVerticalGroup(
            panelTab2_AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTab2_AboutLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(imgAbout)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        mainPanel.addTab("About", panelTab2_About);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Objects Clicked, Event Handling">  
    private void imgBowlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgBowlMouseClicked

        if(timerStarted == false){
            timerStarted = true;
            startTimer();
            showFireGIF();
            //System.out.println("CLICK");
            
        }
        
    }//GEN-LAST:event_imgBowlMouseClicked

    private void imgCandle_10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCandle_10MouseClicked

        JLabel currentLabelObject = imgCandle_10;

        ImageIcon icon;
        Image img = null;
        if(candleClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/candle_b.png"));
            img = icon.getImage();

            candleClickCount++;

        } else if(candleClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
            img = icon.getImage();

            candleClickCount = 0;
            //System.out.println(candleClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgCandle_10MouseClicked

    private void imgCandle9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCandle9MouseClicked

        JLabel currentLabelObject = imgCandle9;

        ImageIcon icon;
        Image img = null;
        if(candleClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/candle_b.png"));
            img = icon.getImage();

            candleClickCount++;

        } else if(candleClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
            img = icon.getImage();

            candleClickCount = 0;
            //System.out.println(candleClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgCandle9MouseClicked

    private void imgCandle8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCandle8MouseClicked

        JLabel currentLabelObject = imgCandle8;

        ImageIcon icon;
        Image img = null;
        if(candleClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/candle_b.png"));
            img = icon.getImage();

            candleClickCount++;

        } else if(candleClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
            img = icon.getImage();

            candleClickCount = 0;
            //System.out.println(candleClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgCandle8MouseClicked

    private void imgCandle7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCandle7MouseClicked

        JLabel currentLabelObject = imgCandle7;

        ImageIcon icon;
        Image img = null;
        if(candleClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/candle_b.png"));
            img = icon.getImage();

            candleClickCount++;

        } else if(candleClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
            img = icon.getImage();

            candleClickCount = 0;
            //System.out.println(candleClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgCandle7MouseClicked

    private void imgCandle6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCandle6MouseClicked

        JLabel currentLabelObject = imgCandle6;

        ImageIcon icon;
        Image img = null;
        if(candleClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/candle_b.png"));
            img = icon.getImage();

            candleClickCount++;

        } else if(candleClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
            img = icon.getImage();

            candleClickCount = 0;
            //System.out.println(candleClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgCandle6MouseClicked

    private void imgCandle5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCandle5MouseClicked

        JLabel currentLabelObject = imgCandle5;

        ImageIcon icon;
        Image img = null;
        if(candleClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/candle_b.png"));
            img = icon.getImage();

            candleClickCount++;

        } else if(candleClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
            img = icon.getImage();

            candleClickCount = 0;
            //System.out.println(candleClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
    }//GEN-LAST:event_imgCandle5MouseClicked

    private void imgCandle4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCandle4MouseClicked

        JLabel currentLabelObject = imgCandle4;

        ImageIcon icon;
        Image img = null;
        if(candleClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/candle_b.png"));
            img = icon.getImage();

            candleClickCount++;

        } else if(candleClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
            img = icon.getImage();

            candleClickCount = 0;
            //System.out.println(candleClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgCandle4MouseClicked

    private void imgCandle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCandle3MouseClicked

        JLabel currentLabelObject = imgCandle3;

        ImageIcon icon;
        Image img = null;
        if(candleClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/candle_b.png"));
            img = icon.getImage();

            candleClickCount++;

        } else if(candleClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
            img = icon.getImage();

            candleClickCount = 0;
            //System.out.println(candleClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgCandle3MouseClicked

    private void imgCandle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCandle2MouseClicked

        JLabel currentLabelObject = imgCandle2;

        ImageIcon icon;
        Image img = null;
        if(candleClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/candle_b.png"));
            img = icon.getImage();

            candleClickCount++;

        } else if(candleClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
            img = icon.getImage();

            candleClickCount = 0;
            //System.out.println(candleClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgCandle2MouseClicked

    private void imgCandle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCandle1MouseClicked

        JLabel currentLabelObject = imgCandle1;

        ImageIcon icon;
        Image img = null;
        if(candleClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/candle_b.png"));
            img = icon.getImage();

            candleClickCount++;

        } else if(candleClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/candle_a.png"));
            img = icon.getImage();

            candleClickCount = 0;
            //System.out.println(candleClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgCandle1MouseClicked
    // </editor-fold> 
    
    
    // Create and display multiple forms //
    public Table_JFrame(int numberOfInstances) {
        
        if(numberOfInstances > 0){
            for (int i = 0; i < numberOfInstances; i++) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Table_JFrame().setVisible(true);
                    }
                });
            }
        }
        
    }
    
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
            java.util.logging.Logger.getLogger(Table_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table_JFrame().setVisible(true);
            }
        });
 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gifFlames;
    private javax.swing.JLabel imgAbout;
    private javax.swing.JLabel imgBackground;
    private javax.swing.JLabel imgBowl;
    private javax.swing.JLabel imgCandle1;
    private javax.swing.JLabel imgCandle2;
    private javax.swing.JLabel imgCandle3;
    private javax.swing.JLabel imgCandle4;
    private javax.swing.JLabel imgCandle5;
    private javax.swing.JLabel imgCandle6;
    private javax.swing.JLabel imgCandle7;
    private javax.swing.JLabel imgCandle8;
    private javax.swing.JLabel imgCandle9;
    private javax.swing.JLabel imgCandle_10;
    private javax.swing.JTabbedPane mainPanel;
    private javax.swing.JPanel panelTab1_Game;
    private javax.swing.JPanel panelTab2_About;
    private javax.swing.JLabel timerTestLabel;
    // End of variables declaration//GEN-END:variables
}
