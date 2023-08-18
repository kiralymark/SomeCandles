package somecandles;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Cards_JFrame extends javax.swing.JFrame {

    private int cardClickCount = 0;
    
    
    /**
     * Creates new form Cards_JFrame
     */
    public Cards_JFrame() {
        initComponents();
        
        scaleTableImg();
        initCardContainers();
        showCards( check_playerCount() );
        initPlayerNames();
        scaleCardsImg();
        
    }

    
    private void programClose() throws HeadlessException {
        
        int inputValue = JOptionPane.showConfirmDialog(rootPane, "Do you want to close the program?", "Program Closing...", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        if(inputValue == JOptionPane.YES_OPTION){
            
            System.exit(0);
            
        }
        
    }
    
    
    private void scaleTableImg() {
    
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/table_texture.png"));
        Image img = icon.getImage();
        
        Image imgScale = img.getScaledInstance(imgBackground.getWidth(), imgBackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imgBackground.setIcon(scaledIcon);
    
    }
     
    private void scaleCardsImg() {
        
        scaleCIPlayer(imgP1Card1, imgP1Card2, imgP1Card3, imgP1Card4);
        scaleCIPlayer(imgP2Card1, imgP2Card2, imgP2Card3, imgP2Card4);
        scaleCIPlayer(imgP3Card1, imgP3Card2, imgP3Card3, imgP3Card4);
        scaleCIPlayer(imgP4Card1, imgP4Card2, imgP4Card3, imgP4Card4);
        scaleCIPlayer(imgP5Card1, imgP5Card2, imgP5Card3, imgP5Card4);
        scaleCIPlayer(imgP6Card1, imgP6Card2, imgP6Card3, imgP6Card4);

    }
    
    private void scaleCIPlayer(JLabel card1, JLabel card2, JLabel card3, JLabel card4) {
    
        JLabel currentLabelObject = card1;
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/card1_a.png"));
        Image img = icon.getImage();
        
        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        currentLabelObject = card2;
        
        icon = new ImageIcon(getClass().getResource("/img/card2_a.png"));
        img = icon.getImage();
        
        imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        currentLabelObject = card3;
        
        icon = new ImageIcon(getClass().getResource("/img/card3_a.png"));
        img = icon.getImage();
        
        imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        currentLabelObject = card4;
        
        icon = new ImageIcon(getClass().getResource("/img/card4_a.png"));
        img = icon.getImage();
        
        imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
    
    }
    
    
    private int check_playerCount() {
        //
        // reading data from a file
        String fileName = "settings.txt";

        final String ENTER = System.lineSeparator();
        String inputString = "";

        byte[] dataByte;
        Path filePath = Paths.get(fileName);

        try {
            dataByte = Files.readAllBytes(filePath);
            inputString = new String(dataByte, StandardCharsets.UTF_8);

        } catch (IOException ex) {
            Logger.getLogger(Cards_JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println(inputString);
        

        int equalsSignCount = 0;

        String[] inputStringArray = inputString.split("");      // making an array of characters
        
        String value = "";
        
        for (int i = 0; i < inputStringArray.length; i++) {
            
            if(inputStringArray[i].equals("=")){
                
                equalsSignCount++;
                     
            }
            
            if(equalsSignCount == 2){

                boolean searchForValue = true;                  
                int k = i+3;                                    // data processing after the " sign
                while(k < inputStringArray.length && searchForValue){

                    if(inputStringArray[k].matches("\"")){      // when a " sign is found, stop
                        searchForValue = false;
                        
                    } else {
                        //System.out.println(k + ", " + inputStringArray[k] + "!");
                        value = value + inputStringArray[k];
                        
                    }

                    //System.out.println(k + ", " + inputStringArray[k]);
                    k++;
                }
            
                //System.out.println(equalsSignCount);
                break;
                
            }
            
            
        }
        //System.out.println(value);
        
        return Integer.parseInt(value);

    }
    
    private void showCards(int playerCount) {
        
        JPanel[] cardHolders = {cardsP1Holder, cardsP2Holder, cardsP3Holder, cardsP4Holder, cardsP5Holder, cardsP6Holder};
        
        //System.out.println(playerCount);
        
        if(playerCount >= 1 && playerCount <= 6){
            for (int i = 0; i < cardHolders.length; i++) {

                if(playerCount == cardHolders.length){
                    cardHolders[i].setVisible(true);

                } else {

                    if(i <= (playerCount-1)){
                        cardHolders[i].setVisible(true);
                        
                    } else {
                        cardHolders[i].setVisible(false);
                    
                    }

                }

            }
        } else {
        
            throw new ArithmeticException("Problem with variable \"playerCount\"");
            
        }

        
    }
    

    private void initCardContainers() {
        
        cardsP1Holder.setBackground(new Color(0, 0, 0, 40));
        cardsP2Holder.setBackground(new Color(0, 0, 0, 40));
        cardsP3Holder.setBackground(new Color(0, 0, 0, 40));
        cardsP4Holder.setBackground(new Color(0, 0, 0, 40));
        cardsP5Holder.setBackground(new Color(0, 0, 0, 40));
        cardsP6Holder.setBackground(new Color(0, 0, 0, 40));
         
    }
    
    private void initPlayerNames() {
        //
        // reading data from a file
        String fileName = "settings.txt";

        final String ENTER = System.lineSeparator();
        String inputString = "";

        byte[] dataByte;
        Path filePath = Paths.get(fileName);

        try {
            dataByte = Files.readAllBytes(filePath);
            inputString = new String(dataByte, StandardCharsets.UTF_8);

        } catch (IOException ex) {
            Logger.getLogger(Cards_JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println(inputString);
        

        //
        // iterating through an array and setting values

        int equalsSignCount = 0;
        
        String[] inputStringArray = inputString.split("");      // making an array of characters
        
        String value = "";
        
        boolean getNextValue = false;
        
        for (int i = 0; i < inputStringArray.length; i++) {
            
            if(inputStringArray[i].equals("=")){
                
                getNextValue = true;
                equalsSignCount++;
                     
            }
            
            if((equalsSignCount >= 3 && equalsSignCount <= 8) && getNextValue){
                
                value = "";
                boolean searchForValue = true;
                int k = i+3;                                    // data processing after the " sign
                while(k < inputStringArray.length && searchForValue){

                    if(inputStringArray[k].matches("\"")){      // when a " sign is found, stop
                        searchForValue = false;
                        
                    } else {
                        //System.out.println(k + ", " + inputStringArray[k] + "!");
                        value = value + inputStringArray[k];
                        
                    }

                    //System.out.println(k + ", " + inputStringArray[k]);
                    k++;
                }
                
                getNextValue = false;
            
                //System.out.println(value);
                
                
                //System.out.println(equalsSignCount);

                if(equalsSignCount == 3){
                    //System.out.println(":" + value + ":");
                    p1Label.setText(value);

                }
                if(equalsSignCount == 4){
                    p2Label.setText(value);

                }
                if(equalsSignCount == 5){
                    p3Label.setText(value);

                }
                if(equalsSignCount == 6){
                    p4Label.setText(value);

                }
                if(equalsSignCount == 7){
                    p5Label.setText(value);

                }
                if(equalsSignCount == 8){
                    p6Label.setText(value);

                }

                
            }
   
        }
        
 
    }
  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Game = new javax.swing.JPanel();
        cardsP1Holder = new javax.swing.JPanel();
        imgP1Card1 = new javax.swing.JLabel();
        imgP1Card2 = new javax.swing.JLabel();
        imgP1Card3 = new javax.swing.JLabel();
        imgP1Card4 = new javax.swing.JLabel();
        p1Label = new javax.swing.JLabel();
        cardsP2Holder = new javax.swing.JPanel();
        imgP2Card1 = new javax.swing.JLabel();
        imgP2Card2 = new javax.swing.JLabel();
        imgP2Card3 = new javax.swing.JLabel();
        imgP2Card4 = new javax.swing.JLabel();
        p2Label = new javax.swing.JLabel();
        cardsP3Holder = new javax.swing.JPanel();
        imgP3Card1 = new javax.swing.JLabel();
        imgP3Card2 = new javax.swing.JLabel();
        imgP3Card3 = new javax.swing.JLabel();
        imgP3Card4 = new javax.swing.JLabel();
        p3Label = new javax.swing.JLabel();
        cardsP4Holder = new javax.swing.JPanel();
        imgP4Card1 = new javax.swing.JLabel();
        imgP4Card2 = new javax.swing.JLabel();
        imgP4Card3 = new javax.swing.JLabel();
        imgP4Card4 = new javax.swing.JLabel();
        p4Label = new javax.swing.JLabel();
        cardsP5Holder = new javax.swing.JPanel();
        imgP5Card1 = new javax.swing.JLabel();
        imgP5Card2 = new javax.swing.JLabel();
        imgP5Card3 = new javax.swing.JLabel();
        imgP5Card4 = new javax.swing.JLabel();
        p5Label = new javax.swing.JLabel();
        cardsP6Holder = new javax.swing.JPanel();
        imgP6Card1 = new javax.swing.JLabel();
        imgP6Card2 = new javax.swing.JLabel();
        imgP6Card3 = new javax.swing.JLabel();
        imgP6Card4 = new javax.swing.JLabel();
        p6Label = new javax.swing.JLabel();
        imgBackground = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuFileSettings = new javax.swing.JMenuItem();
        mnuFileSeparator = new javax.swing.JPopupMenu.Separator();
        mnuFileExit = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Card Selection");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_Game.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_Game.setLayout(null);

        cardsP1Holder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        imgP1Card1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card1_a.png"))); // NOI18N
        imgP1Card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP1Card1MouseClicked(evt);
            }
        });

        imgP1Card2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card2_a.png"))); // NOI18N
        imgP1Card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP1Card2MouseClicked(evt);
            }
        });

        imgP1Card3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card3_a.png"))); // NOI18N
        imgP1Card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP1Card3MouseClicked(evt);
            }
        });

        imgP1Card4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card4_a.png"))); // NOI18N
        imgP1Card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP1Card4MouseClicked(evt);
            }
        });

        p1Label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        p1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Label.setText("Player 1");
        p1Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cardsP1HolderLayout = new javax.swing.GroupLayout(cardsP1Holder);
        cardsP1Holder.setLayout(cardsP1HolderLayout);
        cardsP1HolderLayout.setHorizontalGroup(
            cardsP1HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP1HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardsP1HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgP1Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP1Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP1Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP1Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardsP1HolderLayout.setVerticalGroup(
            cardsP1HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP1HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgP1Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP1Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP1Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP1Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(p1Label)
                .addContainerGap())
        );

        panel_Game.add(cardsP1Holder);
        cardsP1Holder.setBounds(50, 60, 115, 480);

        cardsP2Holder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        imgP2Card1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card1_a.png"))); // NOI18N
        imgP2Card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP2Card1MouseClicked(evt);
            }
        });

        imgP2Card2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card2_a.png"))); // NOI18N
        imgP2Card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP2Card2MouseClicked(evt);
            }
        });

        imgP2Card3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card3_a.png"))); // NOI18N
        imgP2Card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP2Card3MouseClicked(evt);
            }
        });

        imgP2Card4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card4_a.png"))); // NOI18N
        imgP2Card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP2Card4MouseClicked(evt);
            }
        });

        p2Label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        p2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2Label.setText("Player 2");
        p2Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cardsP2HolderLayout = new javax.swing.GroupLayout(cardsP2Holder);
        cardsP2Holder.setLayout(cardsP2HolderLayout);
        cardsP2HolderLayout.setHorizontalGroup(
            cardsP2HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP2HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardsP2HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP2Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP2Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP2Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP2Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardsP2HolderLayout.setVerticalGroup(
            cardsP2HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP2HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgP2Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP2Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP2Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP2Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(p2Label)
                .addContainerGap())
        );

        panel_Game.add(cardsP2Holder);
        cardsP2Holder.setBounds(200, 60, 115, 480);

        cardsP3Holder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        imgP3Card1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card1_a.png"))); // NOI18N
        imgP3Card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP3Card1MouseClicked(evt);
            }
        });

        imgP3Card2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card2_a.png"))); // NOI18N
        imgP3Card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP3Card2MouseClicked(evt);
            }
        });

        imgP3Card3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card3_a.png"))); // NOI18N
        imgP3Card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP3Card3MouseClicked(evt);
            }
        });

        imgP3Card4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card4_a.png"))); // NOI18N
        imgP3Card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP3Card4MouseClicked(evt);
            }
        });

        p3Label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        p3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3Label.setText("Player 3");
        p3Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cardsP3HolderLayout = new javax.swing.GroupLayout(cardsP3Holder);
        cardsP3Holder.setLayout(cardsP3HolderLayout);
        cardsP3HolderLayout.setHorizontalGroup(
            cardsP3HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP3HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardsP3HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP3Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP3Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP3Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP3Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardsP3HolderLayout.setVerticalGroup(
            cardsP3HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP3HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgP3Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP3Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP3Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP3Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(p3Label)
                .addContainerGap())
        );

        panel_Game.add(cardsP3Holder);
        cardsP3Holder.setBounds(350, 60, 115, 480);

        cardsP4Holder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        imgP4Card1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card1_a.png"))); // NOI18N
        imgP4Card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP4Card1MouseClicked(evt);
            }
        });

        imgP4Card2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card2_a.png"))); // NOI18N
        imgP4Card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP4Card2MouseClicked(evt);
            }
        });

        imgP4Card3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card3_a.png"))); // NOI18N
        imgP4Card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP4Card3MouseClicked(evt);
            }
        });

        imgP4Card4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card4_a.png"))); // NOI18N
        imgP4Card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP4Card4MouseClicked(evt);
            }
        });

        p4Label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        p4Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p4Label.setText("Player 4");
        p4Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cardsP4HolderLayout = new javax.swing.GroupLayout(cardsP4Holder);
        cardsP4Holder.setLayout(cardsP4HolderLayout);
        cardsP4HolderLayout.setHorizontalGroup(
            cardsP4HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP4HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardsP4HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP4Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP4Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP4Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP4Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardsP4HolderLayout.setVerticalGroup(
            cardsP4HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP4HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgP4Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP4Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP4Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP4Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(p4Label)
                .addContainerGap())
        );

        panel_Game.add(cardsP4Holder);
        cardsP4Holder.setBounds(500, 60, 115, 480);

        cardsP5Holder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        imgP5Card1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card1_a.png"))); // NOI18N
        imgP5Card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP5Card1MouseClicked(evt);
            }
        });

        imgP5Card2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card2_a.png"))); // NOI18N
        imgP5Card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP5Card2MouseClicked(evt);
            }
        });

        imgP5Card3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card3_a.png"))); // NOI18N
        imgP5Card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP5Card3MouseClicked(evt);
            }
        });

        imgP5Card4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card4_a.png"))); // NOI18N
        imgP5Card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP5Card4MouseClicked(evt);
            }
        });

        p5Label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        p5Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p5Label.setText("Player 5");
        p5Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cardsP5HolderLayout = new javax.swing.GroupLayout(cardsP5Holder);
        cardsP5Holder.setLayout(cardsP5HolderLayout);
        cardsP5HolderLayout.setHorizontalGroup(
            cardsP5HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP5HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardsP5HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p5Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP5Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP5Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP5Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP5Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardsP5HolderLayout.setVerticalGroup(
            cardsP5HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP5HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgP5Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP5Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP5Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP5Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(p5Label)
                .addContainerGap())
        );

        panel_Game.add(cardsP5Holder);
        cardsP5Holder.setBounds(650, 60, 115, 480);

        cardsP6Holder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        imgP6Card1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card1_a.png"))); // NOI18N
        imgP6Card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP6Card1MouseClicked(evt);
            }
        });

        imgP6Card2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card2_a.png"))); // NOI18N
        imgP6Card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP6Card2MouseClicked(evt);
            }
        });

        imgP6Card3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card3_a.png"))); // NOI18N
        imgP6Card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP6Card3MouseClicked(evt);
            }
        });

        imgP6Card4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card4_a.png"))); // NOI18N
        imgP6Card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgP6Card4MouseClicked(evt);
            }
        });

        p6Label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        p6Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p6Label.setText("Player 6");
        p6Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cardsP6HolderLayout = new javax.swing.GroupLayout(cardsP6Holder);
        cardsP6Holder.setLayout(cardsP6HolderLayout);
        cardsP6HolderLayout.setHorizontalGroup(
            cardsP6HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP6HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardsP6HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p6Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP6Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP6Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP6Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgP6Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardsP6HolderLayout.setVerticalGroup(
            cardsP6HolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsP6HolderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgP6Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP6Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP6Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgP6Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(p6Label)
                .addContainerGap())
        );

        panel_Game.add(cardsP6Holder);
        cardsP6Holder.setBounds(800, 60, 115, 480);

        imgBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/table_texture.png"))); // NOI18N
        panel_Game.add(imgBackground);
        imgBackground.setBounds(0, 0, 1012, 685);

        mnuFile.setText("File");

        mnuFileSettings.setText("Settings");
        mnuFileSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileSettingsActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileSettings);
        mnuFile.add(mnuFileSeparator);

        mnuFileExit.setText("Exit");
        mnuFileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileExit);

        menuBar.add(mnuFile);

        mnuEdit.setText("Edit");
        menuBar.add(mnuEdit);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Game, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Game, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Player Cards Clicked, Event Handling"> 
    private void imgP1Card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP1Card1MouseClicked

        JLabel currentLabelObject = imgP1Card1;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card1_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgP1Card1MouseClicked

    private void imgP1Card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP1Card2MouseClicked

        JLabel currentLabelObject = imgP1Card2;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card2_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
    }//GEN-LAST:event_imgP1Card2MouseClicked

    private void imgP1Card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP1Card3MouseClicked

        JLabel currentLabelObject = imgP1Card3;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card3_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);

    }//GEN-LAST:event_imgP1Card3MouseClicked

    private void imgP1Card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP1Card4MouseClicked

        JLabel currentLabelObject = imgP1Card4;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card4_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
    }//GEN-LAST:event_imgP1Card4MouseClicked
    
    
    
    private void imgP2Card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP2Card1MouseClicked

        JLabel currentLabelObject = imgP2Card1;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card1_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
    }//GEN-LAST:event_imgP2Card1MouseClicked

    private void imgP2Card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP2Card2MouseClicked

        JLabel currentLabelObject = imgP2Card2;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card2_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
    }//GEN-LAST:event_imgP2Card2MouseClicked

    private void imgP2Card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP2Card3MouseClicked

        JLabel currentLabelObject = imgP2Card3;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card3_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP2Card3MouseClicked

    private void imgP2Card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP2Card4MouseClicked

        JLabel currentLabelObject = imgP2Card4;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card4_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP2Card4MouseClicked

    
    
    private void imgP3Card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP3Card1MouseClicked

        JLabel currentLabelObject = imgP3Card1;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card1_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP3Card1MouseClicked

    private void imgP3Card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP3Card2MouseClicked

        JLabel currentLabelObject = imgP3Card2;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card2_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP3Card2MouseClicked

    private void imgP3Card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP3Card3MouseClicked

        JLabel currentLabelObject = imgP3Card3;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card3_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP3Card3MouseClicked

    private void imgP3Card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP3Card4MouseClicked

        JLabel currentLabelObject = imgP3Card4;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card4_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP3Card4MouseClicked

    
    
    private void imgP4Card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP4Card1MouseClicked

        JLabel currentLabelObject = imgP4Card1;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card1_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
    }//GEN-LAST:event_imgP4Card1MouseClicked

    private void imgP4Card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP4Card2MouseClicked

        JLabel currentLabelObject = imgP4Card2;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card2_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP4Card2MouseClicked

    private void imgP4Card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP4Card3MouseClicked

        JLabel currentLabelObject = imgP4Card3;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card3_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP4Card3MouseClicked

    private void imgP4Card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP4Card4MouseClicked

        JLabel currentLabelObject = imgP4Card4;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card4_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP4Card4MouseClicked

    
    
    private void imgP5Card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP5Card1MouseClicked

        JLabel currentLabelObject = imgP5Card1;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card1_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP5Card1MouseClicked

    private void imgP5Card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP5Card2MouseClicked

        JLabel currentLabelObject = imgP5Card2;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card2_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
    }//GEN-LAST:event_imgP5Card2MouseClicked

    private void imgP5Card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP5Card3MouseClicked

        JLabel currentLabelObject = imgP5Card3;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card3_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP5Card3MouseClicked

    private void imgP5Card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP5Card4MouseClicked

        JLabel currentLabelObject = imgP5Card4;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card4_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP5Card4MouseClicked

    
    
    private void imgP6Card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP6Card1MouseClicked

        JLabel currentLabelObject = imgP6Card1;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card1_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP6Card1MouseClicked

    private void imgP6Card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP6Card2MouseClicked

        JLabel currentLabelObject = imgP6Card2;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card2_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
    }//GEN-LAST:event_imgP6Card2MouseClicked

    private void imgP6Card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP6Card3MouseClicked

        JLabel currentLabelObject = imgP6Card3;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card3_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP6Card3MouseClicked

    private void imgP6Card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgP6Card4MouseClicked

        JLabel currentLabelObject = imgP6Card4;

        ImageIcon icon;
        Image img = null;
        if(cardClickCount == 0){
            icon = new ImageIcon(getClass().getResource("/img/cards_b.png"));
            img = icon.getImage();

            cardClickCount++;

        } else if(cardClickCount == 1){
            icon = new ImageIcon(getClass().getResource("/img/card4_a.png"));
            img = icon.getImage();

            cardClickCount = 0;
            //System.out.println(cardClickCount);
        }

        Image imgScale = img.getScaledInstance(currentLabelObject.getWidth(), currentLabelObject.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        currentLabelObject.setIcon(scaledIcon);
        
        
    }//GEN-LAST:event_imgP6Card4MouseClicked
    // </editor-fold> 
    
    
    
    private void mnuFileSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileSettingsActionPerformed

        Icon dialogIcon = new ImageIcon(this.getClass().getResource("/img/cards_b.png"));
        Object[] optionsArray = {"WIP_1", "WIP_2", "WIP_3"};
        Object defaultOption = optionsArray[1];
        JOptionPane.showInputDialog(rootPane, "Work In Progress", "WIP", JOptionPane.DEFAULT_OPTION, dialogIcon, optionsArray, defaultOption);
        
    }//GEN-LAST:event_mnuFileSettingsActionPerformed

    private void mnuFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileExitActionPerformed

        programClose();
        
    }//GEN-LAST:event_mnuFileExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        programClose();
        
    }//GEN-LAST:event_formWindowClosing

      
    // Create and display multiple forms //
    public Cards_JFrame(int numberOfInstances) {
        
        if(numberOfInstances > 0){
            for (int i = 0; i < numberOfInstances; i++) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Cards_JFrame().setVisible(true);
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
            java.util.logging.Logger.getLogger(Cards_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cards_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cards_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cards_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cards_JFrame().setVisible(true);
            }
        });
           
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardsP1Holder;
    private javax.swing.JPanel cardsP2Holder;
    private javax.swing.JPanel cardsP3Holder;
    private javax.swing.JPanel cardsP4Holder;
    private javax.swing.JPanel cardsP5Holder;
    private javax.swing.JPanel cardsP6Holder;
    private javax.swing.JLabel imgBackground;
    private javax.swing.JLabel imgP1Card1;
    private javax.swing.JLabel imgP1Card2;
    private javax.swing.JLabel imgP1Card3;
    private javax.swing.JLabel imgP1Card4;
    private javax.swing.JLabel imgP2Card1;
    private javax.swing.JLabel imgP2Card2;
    private javax.swing.JLabel imgP2Card3;
    private javax.swing.JLabel imgP2Card4;
    private javax.swing.JLabel imgP3Card1;
    private javax.swing.JLabel imgP3Card2;
    private javax.swing.JLabel imgP3Card3;
    private javax.swing.JLabel imgP3Card4;
    private javax.swing.JLabel imgP4Card1;
    private javax.swing.JLabel imgP4Card2;
    private javax.swing.JLabel imgP4Card3;
    private javax.swing.JLabel imgP4Card4;
    private javax.swing.JLabel imgP5Card1;
    private javax.swing.JLabel imgP5Card2;
    private javax.swing.JLabel imgP5Card3;
    private javax.swing.JLabel imgP5Card4;
    private javax.swing.JLabel imgP6Card1;
    private javax.swing.JLabel imgP6Card2;
    private javax.swing.JLabel imgP6Card3;
    private javax.swing.JLabel imgP6Card4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuFileExit;
    private javax.swing.JPopupMenu.Separator mnuFileSeparator;
    private javax.swing.JMenuItem mnuFileSettings;
    private javax.swing.JLabel p1Label;
    private javax.swing.JLabel p2Label;
    private javax.swing.JLabel p3Label;
    private javax.swing.JLabel p4Label;
    private javax.swing.JLabel p5Label;
    private javax.swing.JLabel p6Label;
    private javax.swing.JPanel panel_Game;
    // End of variables declaration//GEN-END:variables
}
