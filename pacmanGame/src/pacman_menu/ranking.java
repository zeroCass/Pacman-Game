package pacman_menu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class ranking extends javax.swing.JFrame implements FileManage {
    ArrayList nicknames;
    ArrayList scores;
    
    public ranking() throws IOException {
        nicknames = new ArrayList();
        scores = new ArrayList();
        initComponents();
        this.setResizable(false);
        readFile(nicknames, scores);
           
        table_rankingStyle(); //define table style settings
        DefaultTableModel ranking_model = new DefaultTableModel(new Object[]{"", ""}, 0);
        for (int i = 0; i < nicknames.size(); i++) { //runs theought the array
                //creates the line object and inserts the data on the line for all players (one per line)
                Object line [] = new Object[]{nicknames.get(i).toString(), scores.get(i).toString()};
                //add the line to the model
                ranking_model.addRow(line);
            }
        tableRanking.setModel(ranking_model);
        tableRanking.setEnabled(false);
        background_2.setVisible(false);
    }
    
    @Override
    public void readFile(ArrayList nicknames, ArrayList scores) throws IOException {
        FileManage.super.readFile(nicknames, scores);
    }
    
       @Override
    public void removeLine(String toRemove) { 
        boolean nickname_found = false; 
        int idx_array = 0;
        
        for(int i = 0; i < nicknames.size(); i++){
            if(nicknames.get(i).toString().equals(toRemove)){
                idx_array = i; nickname_found = true;
            }
        }
        
        if(nickname_found){
            if(nicknames.get(idx_array).toString().equals("zero.Cass") || nicknames.get(idx_array).toString().equals("MayaisKS")){
                JOptionPane.showMessageDialog(null, "This Score cannot be removed", "Remove Score", JOptionPane.PLAIN_MESSAGE);
            } else {
                nicknames.remove(idx_array); scores.remove(idx_array);
                JOptionPane.showMessageDialog(null, "This Score has been successfully removed", "Remove Score", JOptionPane.PLAIN_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "This Nickname and Score cannot be found", "Remove Score", JOptionPane.PLAIN_MESSAGE);
        }
            
        saveFile();
        this.setVisible(false);
    }
    
    @Override
    public void saveFile() {
        FileManage.SAVE_FILE.setWritable(true); //allows writing the writing of the file


        try {
            FileManage.verifyDirectory();
            //FileOutputStream output = new FileOutputStream(FileManage.SAVE_FILE, FileManage.ATTACH); //if true add new text at the end of the file
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(FileManage.SAVE_FILE));
                for(int i = 0; i < nicknames.size(); i++){
                    String playerScores = nicknames.get(i) + "_" + scores.get(i) + "\n";
                    bw.write(playerScores);     
                }
                bw.close();
        } catch (IOException ex) {
            Logger.getLogger(saveScore.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileManage.SAVE_FILE.setReadOnly(); //sets the file to read-only mode
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        background_ranking = new javax.swing.JPanel();
        title_ranking = new javax.swing.JLabel();
        button_back = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRanking = new javax.swing.JTable();
        text_name = new javax.swing.JLabel();
        text_score = new javax.swing.JLabel();
        openPanel_button = new javax.swing.JButton();
        background_2 = new javax.swing.JPanel();
        text = new javax.swing.JLabel();
        insert_text = new javax.swing.JTextField();
        save_buttonScore = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pacman Ranking");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/menu_images/incon_page.png")).getImage());
        setName("Pacman Ranking"); // NOI18N

        background_ranking.setBackground(new java.awt.Color(0, 0, 0));
        background_ranking.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(238, 43, 42)));
        background_ranking.setMaximumSize(new java.awt.Dimension(900, 600));

        title_ranking.setFont(new java.awt.Font("CrackMan", 0, 48)); // NOI18N
        title_ranking.setForeground(new java.awt.Color(238, 43, 42));
        title_ranking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/ranking_button.png"))); // NOI18N
        title_ranking.setText("RANKING");

        button_back.setBackground(new java.awt.Color(0, 0, 0));
        button_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/back_red.png"))); // NOI18N
        button_back.setActionCommand("Back");
        button_back.setBorderPainted(false);
        button_back.setDefaultCapable(false);
        button_back.setFocusPainted(false);
        button_back.setFocusable(false);
        button_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_backActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 43, 42)));
        jPanel1.setFocusable(false);

        tableRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME:", "SCORE:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRanking.setOpaque(false);
        jScrollPane1.setViewportView(tableRanking);
        if (tableRanking.getColumnModel().getColumnCount() > 0) {
            tableRanking.getColumnModel().getColumn(0).setResizable(false);
            tableRanking.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        text_name.setFont(new java.awt.Font("CrackMan", 3, 36)); // NOI18N
        text_name.setForeground(new java.awt.Color(255, 255, 255));
        text_name.setText("NAME:");

        text_score.setFont(new java.awt.Font("CrackMan", 3, 36)); // NOI18N
        text_score.setForeground(new java.awt.Color(255, 255, 255));
        text_score.setText("SCORE:");

        openPanel_button.setBackground(new java.awt.Color(0, 0, 0));
        openPanel_button.setFont(new java.awt.Font("CrackMan", 0, 18)); // NOI18N
        openPanel_button.setForeground(new java.awt.Color(238, 43, 42));
        openPanel_button.setText("Click here if you want to remove something score!");
        openPanel_button.setBorderPainted(false);
        openPanel_button.setDefaultCapable(false);
        openPanel_button.setFocusPainted(false);
        openPanel_button.setFocusable(false);
        openPanel_button.setRequestFocusEnabled(false);
        openPanel_button.setRolloverEnabled(false);
        openPanel_button.setVerifyInputWhenFocusTarget(false);
        openPanel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openPanel_buttonActionPerformed(evt);
            }
        });

        background_2.setBackground(new java.awt.Color(0, 0, 0));
        background_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 43, 42)));

        text.setBackground(new java.awt.Color(0, 0, 0));
        text.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        text.setForeground(new java.awt.Color(255, 255, 255));
        text.setText(" Enter the name corresponding to the Score you want to remove:");

        insert_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_textActionPerformed(evt);
            }
        });

        save_buttonScore.setBackground(new java.awt.Color(0, 0, 0));
        save_buttonScore.setFont(new java.awt.Font("CrackMan", 0, 18)); // NOI18N
        save_buttonScore.setForeground(new java.awt.Color(255, 255, 255));
        save_buttonScore.setText("save");
        save_buttonScore.setBorderPainted(false);
        save_buttonScore.setDefaultCapable(false);
        save_buttonScore.setFocusable(false);
        save_buttonScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonScoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background_2Layout = new javax.swing.GroupLayout(background_2);
        background_2.setLayout(background_2Layout);
        background_2Layout.setHorizontalGroup(
            background_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_2Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(background_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_2Layout.createSequentialGroup()
                        .addComponent(insert_text, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save_buttonScore)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_2Layout.createSequentialGroup()
                        .addComponent(text)
                        .addGap(87, 87, 87))))
        );
        background_2Layout.setVerticalGroup(
            background_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_2Layout.createSequentialGroup()
                .addComponent(text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(background_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_buttonScore))
                .addGap(0, 0, 0))
        );

        text.getAccessibleContext().setAccessibleName(" Enter the name corresponding to the Score you want to remove");

        javax.swing.GroupLayout background_rankingLayout = new javax.swing.GroupLayout(background_ranking);
        background_ranking.setLayout(background_rankingLayout);
        background_rankingLayout.setHorizontalGroup(
            background_rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_rankingLayout.createSequentialGroup()
                .addGroup(background_rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_rankingLayout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(title_ranking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_back, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background_rankingLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(text_name, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(text_score, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_rankingLayout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addGroup(background_rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(background_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(background_rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_rankingLayout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(87, 87, 87))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_rankingLayout.createSequentialGroup()
                            .addComponent(openPanel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(168, 168, 168)))))
        );
        background_rankingLayout.setVerticalGroup(
            background_rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_rankingLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(background_rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(title_ranking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_back, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(background_rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_name)
                    .addComponent(text_score))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openPanel_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(background_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        button_back.getAccessibleContext().setAccessibleName("Back");
        button_back.getAccessibleContext().setAccessibleDescription("go back to menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_ranking, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_ranking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void table_rankingStyle(){
        tableRanking.setRowHeight(45);
        
        tableRanking.setShowGrid(true);
        tableRanking.setGridColor(Color.red);

        tableRanking.setBackground(Color.BLACK);
        tableRanking.setForeground(Color.WHITE);
        
        tableRanking.setSelectionBackground(Color.WHITE);
        tableRanking.setSelectionForeground(Color.BLACK);
        
        tableRanking.setFont(new Font("Comic Sans MS", Font.ITALIC, 24)); 
    }    
    
    private void button_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_backActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_button_backActionPerformed

    private void openPanel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openPanel_buttonActionPerformed
        background_2.setVisible(true);
    }//GEN-LAST:event_openPanel_buttonActionPerformed

    private void insert_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insert_textActionPerformed

    private void save_buttonScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonScoreActionPerformed
       String toRemove = insert_text.getText();
       removeLine(toRemove);
    }//GEN-LAST:event_save_buttonScoreActionPerformed

    public static void main(String args[]) {
        /* Set the Windows Classic look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ranking().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ranking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background_2;
    private javax.swing.JPanel background_ranking;
    private javax.swing.JButton button_back;
    private javax.swing.JTextField insert_text;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton openPanel_button;
    private javax.swing.JButton save_buttonScore;
    private javax.swing.JTable tableRanking;
    private javax.swing.JLabel text;
    private javax.swing.JLabel text_name;
    private javax.swing.JLabel text_score;
    private javax.swing.JLabel title_ranking;
    // End of variables declaration//GEN-END:variables
    
}
