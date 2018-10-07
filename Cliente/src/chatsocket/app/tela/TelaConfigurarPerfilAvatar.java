package chatsocket.app.tela;

import javax.swing.JLabel;

/**
 *
 * @author lucas Costa
 */
public class TelaConfigurarPerfilAvatar extends javax.swing.JFrame {
    
    JLabel avatarSelecionado;
    
    public TelaConfigurarPerfilAvatar(JLabel avatar) {
        initComponents();
        this.avatarSelecionado = avatar;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        avatar1 = new javax.swing.JLabel();
        avatar8 = new javax.swing.JLabel();
        avatar3 = new javax.swing.JLabel();
        avatar2 = new javax.swing.JLabel();
        avatar5 = new javax.swing.JLabel();
        avatar10 = new javax.swing.JLabel();
        avatar6 = new javax.swing.JLabel();
        avatar4 = new javax.swing.JLabel();
        avatar9 = new javax.swing.JLabel();
        avatar7 = new javax.swing.JLabel();
        avatar12 = new javax.swing.JLabel();
        avatar13 = new javax.swing.JLabel();
        avatar11 = new javax.swing.JLabel();
        avatar14 = new javax.swing.JLabel();
        avatar15 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));
        setLocationByPlatform(true);

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel2.setText("ESCOLHA SEU AVATAR");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        avatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_1.png"))); // NOI18N
        avatar1.setBorder(null);
        avatar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar1MouseClicked(evt);
            }
        });

        avatar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_8.png"))); // NOI18N
        avatar8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar8MouseClicked(evt);
            }
        });

        avatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_3.png"))); // NOI18N
        avatar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar3MouseClicked(evt);
            }
        });

        avatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_2.png"))); // NOI18N
        avatar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar2MouseClicked(evt);
            }
        });

        avatar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_5.png"))); // NOI18N
        avatar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar5MouseClicked(evt);
            }
        });

        avatar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_10.png"))); // NOI18N
        avatar10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar10MouseClicked(evt);
            }
        });

        avatar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_6.png"))); // NOI18N
        avatar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar6MouseClicked(evt);
            }
        });

        avatar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_4.png"))); // NOI18N
        avatar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar4MouseClicked(evt);
            }
        });

        avatar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_9.png"))); // NOI18N
        avatar9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar9MouseClicked(evt);
            }
        });

        avatar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_7.png"))); // NOI18N
        avatar7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar7MouseClicked(evt);
            }
        });

        avatar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_12.png"))); // NOI18N
        avatar12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar12MouseClicked(evt);
            }
        });

        avatar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_13.png"))); // NOI18N
        avatar13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar13MouseClicked(evt);
            }
        });

        avatar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_11.png"))); // NOI18N
        avatar11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar11MouseClicked(evt);
            }
        });

        avatar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_14.png"))); // NOI18N
        avatar14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar14MouseClicked(evt);
            }
        });

        avatar15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/avatar_64_15.png"))); // NOI18N
        avatar15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(avatar11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(avatar12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(avatar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(avatar2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(avatar6)
                                .addGap(18, 18, 18)
                                .addComponent(avatar7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(avatar3)
                            .addComponent(avatar8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(avatar4)
                                .addGap(18, 18, 18)
                                .addComponent(avatar5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(avatar9)
                                .addGap(18, 18, 18)
                                .addComponent(avatar10))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(avatar13)
                        .addGap(18, 18, 18)
                        .addComponent(avatar14)
                        .addGap(18, 18, 18)
                        .addComponent(avatar15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(avatar2)
                    .addComponent(avatar1)
                    .addComponent(avatar3)
                    .addComponent(avatar4)
                    .addComponent(avatar5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(avatar6)
                    .addComponent(avatar7)
                    .addComponent(avatar8)
                    .addComponent(avatar9)
                    .addComponent(avatar10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avatar12)
                    .addComponent(avatar13)
                    .addComponent(avatar11)
                    .addComponent(avatar14)
                    .addComponent(avatar15))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(118, 118, 118))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        TelaConfigurarPerfilAvatar.this.setVisible(false);
        this.avatarSelecionado.setIcon(new javax.swing.ImageIcon(getClass().getResource(TelaCliente.dadosCliente.get("AVATAR"))));
    }//GEN-LAST:event_btnSalvarActionPerformed

    /* 
    * Seta seleção de imagem para avatar
    */
    private void avatar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar1MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_1.png");
        limparBordasIcones();
        selecionarAvatar(avatar1);
  
    }//GEN-LAST:event_avatar1MouseClicked

    private void avatar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar2MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_2.png");
        limparBordasIcones();
        selecionarAvatar(avatar2);
    }//GEN-LAST:event_avatar2MouseClicked

    private void avatar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar3MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_3.png");
        limparBordasIcones();
        selecionarAvatar(avatar3);
    }//GEN-LAST:event_avatar3MouseClicked

    private void avatar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar4MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_4.png");
        limparBordasIcones();
        selecionarAvatar(avatar4);
    }//GEN-LAST:event_avatar4MouseClicked

    private void avatar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar5MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_5.png");
        limparBordasIcones();
        selecionarAvatar(avatar5);
    }//GEN-LAST:event_avatar5MouseClicked

    private void avatar6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar6MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_6.png");
        limparBordasIcones();
        selecionarAvatar(avatar6);
    }//GEN-LAST:event_avatar6MouseClicked

    private void avatar7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar7MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_7.png");
        limparBordasIcones();
        selecionarAvatar(avatar7);
    }//GEN-LAST:event_avatar7MouseClicked

    private void avatar8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar8MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_8.png");
        limparBordasIcones();
        selecionarAvatar(avatar8);
    }//GEN-LAST:event_avatar8MouseClicked

    private void avatar9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar9MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_9.png");
        limparBordasIcones();
        selecionarAvatar(avatar9);
    }//GEN-LAST:event_avatar9MouseClicked

    private void avatar10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar10MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_10.png");
        limparBordasIcones();
        selecionarAvatar(avatar10);
    }//GEN-LAST:event_avatar10MouseClicked

    private void avatar11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar11MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_11.png");
        limparBordasIcones();
        selecionarAvatar(avatar11);
    }//GEN-LAST:event_avatar11MouseClicked

    private void avatar12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar12MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_12.png");
        limparBordasIcones();
        selecionarAvatar(avatar12);
    }//GEN-LAST:event_avatar12MouseClicked

    private void avatar13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar13MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_13.png");
        limparBordasIcones();
        selecionarAvatar(avatar13);
    }//GEN-LAST:event_avatar13MouseClicked

    private void avatar14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar14MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_14.png");
        limparBordasIcones();
        selecionarAvatar(avatar14);
    }//GEN-LAST:event_avatar14MouseClicked

    private void avatar15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar15MouseClicked
        TelaCliente.dadosCliente.put("AVATAR","/chatsocket/app/icons/avatar_64_15.png");
        limparBordasIcones();
        selecionarAvatar(avatar15);
    }//GEN-LAST:event_avatar15MouseClicked

    private void selecionarAvatar(JLabel avatarSelecionado){
        avatarSelecionado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }
    
    private void limparBordasIcones(){
        avatar1.setBorder(null);
        avatar2.setBorder(null);
        avatar3.setBorder(null);
        avatar4.setBorder(null);
        avatar5.setBorder(null);
        avatar6.setBorder(null);
        avatar7.setBorder(null);
        avatar8.setBorder(null);
        avatar9.setBorder(null);
        avatar10.setBorder(null);
        avatar11.setBorder(null);
        avatar12.setBorder(null);
        avatar13.setBorder(null);
        avatar14.setBorder(null);
        avatar15.setBorder(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar1;
    private javax.swing.JLabel avatar10;
    private javax.swing.JLabel avatar11;
    private javax.swing.JLabel avatar12;
    private javax.swing.JLabel avatar13;
    private javax.swing.JLabel avatar14;
    private javax.swing.JLabel avatar15;
    private javax.swing.JLabel avatar2;
    private javax.swing.JLabel avatar3;
    private javax.swing.JLabel avatar4;
    private javax.swing.JLabel avatar5;
    private javax.swing.JLabel avatar6;
    private javax.swing.JLabel avatar7;
    private javax.swing.JLabel avatar8;
    private javax.swing.JLabel avatar9;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
