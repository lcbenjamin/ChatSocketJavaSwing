package chatsocket.app.tela;

import javax.swing.JOptionPane;

/**
 * Classe responsavel pela interface de configuração do perfil do usuário
 * 
 * @author setembro/2018 Lucas Costa
 */
public class TelaConfigurarPerfil extends javax.swing.JFrame {

    public TelaConfigurarPerfil() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        textLogin = new javax.swing.JLabel();
        campoLoginUsuario = new javax.swing.JTextField();
        textNomeExibicao = new javax.swing.JLabel();
        campoNomeExibicaoUsuario = new javax.swing.JTextField();
        textNomeExibicao1 = new javax.swing.JLabel();
        campoSenhaDoUsuario = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        labelAvatar = new javax.swing.JLabel();

        setTitle("Perfil Usuario");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações de login"));

        textLogin.setText("Login:");

        campoLoginUsuario.setForeground(new java.awt.Color(1, 1, 1));
        campoLoginUsuario.setText(TelaCliente.dadosCliente.get("LOGIN"));
        campoLoginUsuario.setToolTipText("Login do usuario");

        textNomeExibicao.setText("Nome Exibição:");

        campoNomeExibicaoUsuario.setForeground(new java.awt.Color(1, 1, 1));
        campoNomeExibicaoUsuario.setText(TelaCliente.dadosCliente.get("NOME_EXIBICAO"));
        campoNomeExibicaoUsuario.setToolTipText("Nome que será exibido aos outros usuarios");
        campoNomeExibicaoUsuario.setDisabledTextColor(new java.awt.Color(203, 199, 199));

        textNomeExibicao1.setText("Senha:");

        campoSenhaDoUsuario.setText(TelaCliente.dadosCliente.get("SENHA"));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        String avatar;

        if(TelaCliente.dadosCliente.get("AVATAR") == null){
            avatar = "/chatsocket/app/icons/user_padrao.png";
        }else{
            avatar = TelaCliente.dadosCliente.get("AVATAR");
        }
        labelAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource(avatar)));
        labelAvatar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labelAvatar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        labelAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAvatarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textNomeExibicao)
                    .addComponent(textLogin)
                    .addComponent(textNomeExibicao1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(campoNomeExibicaoUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoLoginUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoSenhaDoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelAvatar)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textLogin)
                            .addComponent(campoLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNomeExibicao)
                            .addComponent(campoNomeExibicaoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelAvatar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomeExibicao1)
                    .addComponent(campoSenhaDoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        TelaConfigurarPerfil.this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if(campoLoginUsuario.getText().isEmpty() || campoNomeExibicaoUsuario.getText().isEmpty() ||
            campoSenhaDoUsuario.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos");
        }else{
            TelaCliente.dadosCliente.put("LOGIN", campoLoginUsuario.getText().toLowerCase());
            TelaCliente.dadosCliente.put("NOME_EXIBICAO",campoNomeExibicaoUsuario.getText() );
            TelaCliente.dadosCliente.put("SENHA", campoSenhaDoUsuario.getText());
            
            TelaConfigurarPerfil.this.setVisible(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void labelAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAvatarMouseClicked
        TelaConfigurarPerfilAvatar tela = new TelaConfigurarPerfilAvatar(labelAvatar);
        tela.setVisible(true);
    }//GEN-LAST:event_labelAvatarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField campoLoginUsuario;
    private javax.swing.JTextField campoNomeExibicaoUsuario;
    private javax.swing.JPasswordField campoSenhaDoUsuario;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelAvatar;
    private javax.swing.JLabel textLogin;
    private javax.swing.JLabel textNomeExibicao;
    private javax.swing.JLabel textNomeExibicao1;
    // End of variables declaration//GEN-END:variables
}
