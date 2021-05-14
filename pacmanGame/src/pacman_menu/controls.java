package pacman_menu;

public class controls extends javax.swing.JFrame {
    public controls() {
        initComponents();
        this.setResizable(false);
        //W/D/S/A
        show_up.setEnabled(false);
        show_right.setEnabled(false);
        show_left.setEnabled(false);
        show_down.setEnabled(false);
        //ROWS
        show_UP.setEnabled(false);
        show_RIGHT.setEnabled(false);
        show_LEFT.setEnabled(false);
        show_DOWN.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        background_controls = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        button_back = new javax.swing.JButton();
        block_1 = new javax.swing.JPanel();
        W_image = new javax.swing.JLabel();
        A_image = new javax.swing.JLabel();
        D_image = new javax.swing.JLabel();
        S_image = new javax.swing.JLabel();
        text_up = new javax.swing.JLabel();
        text_right = new javax.swing.JLabel();
        text_left = new javax.swing.JLabel();
        text_down = new javax.swing.JLabel();
        show_up = new javax.swing.JTextField();
        show_right = new javax.swing.JTextField();
        show_left = new javax.swing.JTextField();
        show_down = new javax.swing.JTextField();
        block_2 = new javax.swing.JPanel();
        up_image = new javax.swing.JLabel();
        left_image = new javax.swing.JLabel();
        right_image = new javax.swing.JLabel();
        down_image = new javax.swing.JLabel();
        text_UP = new javax.swing.JLabel();
        text_RIGHT = new javax.swing.JLabel();
        text_LEFT = new javax.swing.JLabel();
        text_DOWN = new javax.swing.JLabel();
        show_UP = new javax.swing.JTextField();
        show_RIGHT = new javax.swing.JTextField();
        show_LEFT = new javax.swing.JTextField();
        show_DOWN = new javax.swing.JTextField();
        text_or = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pacman Controls");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/menu_images/incon_page.png")).getImage());
        setName("Pacman Controls"); // NOI18N

        background_controls.setBackground(new java.awt.Color(0, 0, 0));
        background_controls.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(252, 199, 64)));

        jLabel1.setFont(new java.awt.Font("CrackMan", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 199, 64));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/controls_button.png"))); // NOI18N
        jLabel1.setText("CONTROLS");

        button_back.setBackground(new java.awt.Color(0, 0, 0));
        button_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/back_yellow.png"))); // NOI18N
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

        block_1.setBackground(new java.awt.Color(0, 0, 0));
        block_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(252, 199, 64)));

        W_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/W.png"))); // NOI18N

        A_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/A.png"))); // NOI18N

        D_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/D.png"))); // NOI18N

        S_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/S.png"))); // NOI18N

        text_up.setBackground(new java.awt.Color(0, 0, 0));
        text_up.setFont(new java.awt.Font("CrackMan", 0, 24)); // NOI18N
        text_up.setForeground(new java.awt.Color(118, 203, 218));
        text_up.setText("UP:");

        text_right.setBackground(new java.awt.Color(0, 0, 0));
        text_right.setFont(new java.awt.Font("CrackMan", 0, 24)); // NOI18N
        text_right.setForeground(new java.awt.Color(238, 43, 42));
        text_right.setText("RIGHT:");

        text_left.setBackground(new java.awt.Color(0, 0, 0));
        text_left.setFont(new java.awt.Font("CrackMan", 0, 24)); // NOI18N
        text_left.setForeground(new java.awt.Color(252, 199, 64));
        text_left.setText("LEFT:");

        text_down.setBackground(new java.awt.Color(0, 0, 0));
        text_down.setFont(new java.awt.Font("CrackMan", 0, 24)); // NOI18N
        text_down.setForeground(new java.awt.Color(255, 255, 255));
        text_down.setText("DOwn:");

        show_up.setText("     W     ");
        show_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_upActionPerformed(evt);
            }
        });

        show_right.setText("      D     ");
        show_right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_rightActionPerformed(evt);
            }
        });

        show_left.setText("      A     ");
        show_left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_leftActionPerformed(evt);
            }
        });

        show_down.setText("      S     ");
        show_down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_downActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout block_1Layout = new javax.swing.GroupLayout(block_1);
        block_1.setLayout(block_1Layout);
        block_1Layout.setHorizontalGroup(
            block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block_1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(A_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(W_image)
                    .addComponent(S_image))
                .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(block_1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(block_1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(text_up)
                                .addGap(76, 76, 76))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block_1Layout.createSequentialGroup()
                                .addComponent(text_right)
                                .addGap(31, 31, 31)))
                        .addGap(8, 8, 8)
                        .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(show_right)
                            .addComponent(show_up)))
                    .addGroup(block_1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(D_image)
                        .addGap(98, 98, 98)
                        .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_down)
                            .addComponent(text_left))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(show_left, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(show_down))))
                .addContainerGap())
        );
        block_1Layout.setVerticalGroup(
            block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(block_1Layout.createSequentialGroup()
                        .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_up)
                            .addComponent(show_up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_right)
                            .addComponent(show_right))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_left)
                            .addComponent(show_left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_down)
                            .addComponent(show_down)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block_1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(W_image)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(block_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(S_image)
                            .addComponent(A_image)
                            .addComponent(D_image))))
                .addContainerGap())
        );

        text_up.getAccessibleContext().setAccessibleName("text_up");
        text_up.getAccessibleContext().setAccessibleDescription("");
        text_right.getAccessibleContext().setAccessibleName("text_right");
        text_left.getAccessibleContext().setAccessibleName("text_left");
        text_down.getAccessibleContext().setAccessibleName("text_down");

        block_2.setBackground(new java.awt.Color(0, 0, 0));
        block_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(252, 199, 64)));

        up_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/up.png"))); // NOI18N

        left_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/left.png"))); // NOI18N

        right_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/right.png"))); // NOI18N

        down_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_images/down.png"))); // NOI18N

        text_UP.setBackground(new java.awt.Color(0, 0, 0));
        text_UP.setFont(new java.awt.Font("CrackMan", 0, 24)); // NOI18N
        text_UP.setForeground(new java.awt.Color(118, 203, 218));
        text_UP.setText("UP:");

        text_RIGHT.setBackground(new java.awt.Color(0, 0, 0));
        text_RIGHT.setFont(new java.awt.Font("CrackMan", 0, 24)); // NOI18N
        text_RIGHT.setForeground(new java.awt.Color(238, 43, 42));
        text_RIGHT.setText("RIGHT:");

        text_LEFT.setBackground(new java.awt.Color(0, 0, 0));
        text_LEFT.setFont(new java.awt.Font("CrackMan", 0, 24)); // NOI18N
        text_LEFT.setForeground(new java.awt.Color(252, 199, 64));
        text_LEFT.setText("LEFT:");

        text_DOWN.setBackground(new java.awt.Color(0, 0, 0));
        text_DOWN.setFont(new java.awt.Font("CrackMan", 0, 24)); // NOI18N
        text_DOWN.setForeground(new java.awt.Color(255, 255, 255));
        text_DOWN.setText("DOwn:");

        show_UP.setText("      ↑");
        show_UP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_UPActionPerformed(evt);
            }
        });

        show_RIGHT.setText("     →");
        show_RIGHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_RIGHTActionPerformed(evt);
            }
        });

        show_LEFT.setText("     ←");
        show_LEFT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_LEFTActionPerformed(evt);
            }
        });

        show_DOWN.setText("      ↓");
        show_DOWN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_DOWNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout block_2Layout = new javax.swing.GroupLayout(block_2);
        block_2.setLayout(block_2Layout);
        block_2Layout.setHorizontalGroup(
            block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block_2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(left_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(up_image)
                    .addGroup(block_2Layout.createSequentialGroup()
                        .addComponent(down_image)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(right_image)))
                .addGap(98, 98, 98)
                .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(block_2Layout.createSequentialGroup()
                        .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_DOWN)
                            .addComponent(text_LEFT))
                        .addGap(31, 31, 31)
                        .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(show_LEFT)
                            .addComponent(show_DOWN)))
                    .addGroup(block_2Layout.createSequentialGroup()
                        .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_UP)
                            .addComponent(text_RIGHT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(show_UP)
                            .addComponent(show_RIGHT, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))))
                .addContainerGap())
        );
        block_2Layout.setVerticalGroup(
            block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block_2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(block_2Layout.createSequentialGroup()
                        .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_UP)
                            .addComponent(show_UP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_RIGHT)
                            .addComponent(show_RIGHT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_LEFT)
                            .addComponent(show_LEFT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_DOWN)
                            .addComponent(show_DOWN)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block_2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(up_image)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(block_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(down_image)
                            .addComponent(left_image)
                            .addComponent(right_image))))
                .addContainerGap())
        );

        text_or.setBackground(new java.awt.Color(0, 0, 0));
        text_or.setFont(new java.awt.Font("CrackMan", 0, 36)); // NOI18N
        text_or.setForeground(new java.awt.Color(252, 199, 64));
        text_or.setText("OR");

        javax.swing.GroupLayout background_controlsLayout = new javax.swing.GroupLayout(background_controls);
        background_controls.setLayout(background_controlsLayout);
        background_controlsLayout.setHorizontalGroup(
            background_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_controlsLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_back, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_controlsLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(background_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(block_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(block_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_controlsLayout.createSequentialGroup()
                        .addComponent(text_or)
                        .addGap(237, 237, 237)))
                .addGap(183, 183, 183))
        );
        background_controlsLayout.setVerticalGroup(
            background_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_controlsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(background_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_back, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(50, 50, 50)
                .addComponent(block_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_or)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(block_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        button_back.getAccessibleContext().setAccessibleName("Back");
        button_back.getAccessibleContext().setAccessibleDescription("go back to menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background_controls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_controls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_backActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_button_backActionPerformed

    private void show_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_upActionPerformed
  
    }//GEN-LAST:event_show_upActionPerformed

    private void show_rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_rightActionPerformed

    }//GEN-LAST:event_show_rightActionPerformed

    private void show_leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_leftActionPerformed

    }//GEN-LAST:event_show_leftActionPerformed

    private void show_downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_downActionPerformed

    }//GEN-LAST:event_show_downActionPerformed

    private void show_UPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_UPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_show_UPActionPerformed

    private void show_RIGHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_RIGHTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_show_RIGHTActionPerformed

    private void show_LEFTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_LEFTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_show_LEFTActionPerformed

    private void show_DOWNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_DOWNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_show_DOWNActionPerformed

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
            java.util.logging.Logger.getLogger(controls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(controls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(controls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(controls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new controls().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A_image;
    private javax.swing.JLabel D_image;
    private javax.swing.JLabel S_image;
    private javax.swing.JLabel W_image;
    private javax.swing.JPanel background_controls;
    private javax.swing.JPanel block_1;
    private javax.swing.JPanel block_2;
    private javax.swing.JButton button_back;
    private javax.swing.JLabel down_image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel left_image;
    private javax.swing.JLabel right_image;
    private javax.swing.JTextField show_DOWN;
    private javax.swing.JTextField show_LEFT;
    private javax.swing.JTextField show_RIGHT;
    private javax.swing.JTextField show_UP;
    private javax.swing.JTextField show_down;
    private javax.swing.JTextField show_left;
    private javax.swing.JTextField show_right;
    private javax.swing.JTextField show_up;
    private javax.swing.JLabel text_DOWN;
    private javax.swing.JLabel text_LEFT;
    private javax.swing.JLabel text_RIGHT;
    private javax.swing.JLabel text_UP;
    private javax.swing.JLabel text_down;
    private javax.swing.JLabel text_left;
    private javax.swing.JLabel text_or;
    private javax.swing.JLabel text_right;
    private javax.swing.JLabel text_up;
    private javax.swing.JLabel up_image;
    // End of variables declaration//GEN-END:variables
}
