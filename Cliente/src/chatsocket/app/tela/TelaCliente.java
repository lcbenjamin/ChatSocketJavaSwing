package chatsocket.app.tela;

import chatsocket.app.bean.Mensagem;
import chatsocket.app.bean.Mensagem.Comando;
import static chatsocket.app.bean.Mensagem.Comando.CONECTAR;
import static chatsocket.app.bean.Mensagem.Comando.DESCONECTAR;
import static chatsocket.app.bean.Mensagem.Comando.ENVIAR_UM;
import chatsocket.app.servico.ClienteService;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import chatsocket.app.util.ClienteUtil;
import java.net.UnknownHostException;

/**
 * @author Lucas Costa
 */
public class TelaCliente extends javax.swing.JFrame {

    private Socket socket;
    private Mensagem mensagem;
    private ClienteService service;
    private ClienteUtil clienteUtil = new ClienteUtil();
    public static Map<String,String> dadosCliente = new HashMap<>(); 
    public static Map<String,String> dadosServidor = new HashMap<>(); 

    /**
     * Creates new form ClienteFrame
     */
    public TelaCliente() {
        initComponents();
    }

    private class ListenerSocket implements Runnable {

        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            Mensagem mensagem = null;
            try {
                while ((mensagem = (Mensagem) input.readObject()) != null) {
                    Comando comando = mensagem.getComando();

                    switch (comando) {
                        case CONECTAR:
                            conectado(mensagem);
                            break;
                        case DESCONECTAR:
                            desconectar();
                            socket.close();
                            break;
                        case ENVIAR_UM:
                            break;
                        case ENVIAR_TODOS:
                            receber(mensagem);
                            break;    
                        case USERS_ONLINE:
                            atualizarOnlines(mensagem);
                            break;
                        default:
                            break;
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void conectado(Mensagem message) {
        if (message.getTextoMensagem().contains(":ERRO 01")) {
            JOptionPane.showMessageDialog(this, "Conexão não realizada!\nA senha digitada não confere");
            try {
                this.socket.close();
            } catch (IOException ex) {
                Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }

        this.mensagem = message;
        this.btnConectar.setEnabled(false);

        this.btnDesconectar.setEnabled(true);
        this.txtAreaSaida.setEnabled(true);
        this.txtAreaExibicao.setEnabled(true);
        this.btnEnviar.setEnabled(true);
        this.btnLimpar.setEnabled(true);
        this.txtAreaExibicao.append(message.getTextoMensagem() + "\n");
        JOptionPane.showMessageDialog(this, "Você está conectado no chat!");
        
    }

    private void desconectar() {

        this.btnConectar.setEnabled(true);

        this.btnDesconectar.setEnabled(false);
        this.txtAreaSaida.setEnabled(false);
        this.txtAreaExibicao.setEnabled(false);
        this.btnEnviar.setEnabled(false);
        this.btnLimpar.setEnabled(false);
     
        this.listaUsuarioConectados.removeAll();
        

        this.txtAreaExibicao.setText("");
        this.txtAreaSaida.setText("");

        JOptionPane.showMessageDialog(this, "Você saiu do chat!");
    }

    private void receber(Mensagem mensagem) {
            this.txtAreaExibicao.append("["+ clienteUtil.obtemDataEHoraAtual() + "] " + mensagem.getNomeExibicao()+ " diz: " + mensagem.getTextoMensagem() + "\n");
    }

    @SuppressWarnings("unchecked")
    private void atualizarOnlines(Mensagem message) {
        System.out.println(message.getListaOnlines().toString());

        Set<String> names = message.getListaOnlines();

        names.remove(message.getNomeUnico());

        String[] array = names.toArray(new String[names.size()]);

        this.listaUsuarioConectados.setListData(array);
        this.listaUsuarioConectados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listaUsuarioConectados.setLayoutOrientation(JList.VERTICAL);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaUsuarioConectados = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaExibicao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaSaida = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnDesconectar = new javax.swing.JButton();
        btnConfigurarServidor = new javax.swing.JButton();
        btnConfigurarPerfil = new javax.swing.JButton();
        btnConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios Online"));

        jScrollPane3.setViewportView(listaUsuarioConectados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addGap(8, 8, 8))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtAreaExibicao.setEditable(false);
        txtAreaExibicao.setColumns(20);
        txtAreaExibicao.setRows(5);
        txtAreaExibicao.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaExibicao);

        txtAreaSaida.setColumns(20);
        txtAreaSaida.setRows(5);
        txtAreaSaida.setEnabled(false);
        jScrollPane2.setViewportView(txtAreaSaida);

        btnEnviar.setText("Enviar");
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.setEnabled(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpar)
                        .addGap(2, 2, 2)
                        .addComponent(btnEnviar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnEnviar))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnDesconectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/desconectar.png"))); // NOI18N
        btnDesconectar.setText("Desconectar");
        btnDesconectar.setToolTipText("Sair do chat");
        btnDesconectar.setEnabled(false);
        btnDesconectar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDesconectar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });

        btnConfigurarServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/cloud-service.png"))); // NOI18N
        btnConfigurarServidor.setText("Servidor");
        btnConfigurarServidor.setToolTipText("Configurações do Servidor");
        btnConfigurarServidor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfigurarServidor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConfigurarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarServidorActionPerformed(evt);
            }
        });

        btnConfigurarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/user.png"))); // NOI18N
        btnConfigurarPerfil.setText("Perfil");
        btnConfigurarPerfil.setToolTipText("Configurações do perfil do usuário");
        btnConfigurarPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfigurarPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConfigurarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarPerfilActionPerformed(evt);
            }
        });

        btnConectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatsocket/app/icons/Conectar.png"))); // NOI18N
        btnConectar.setText("Conectar");
        btnConectar.setToolTipText("Conectar ao chat");
        btnConectar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConectar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConfigurarServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfigurarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfigurarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfigurarServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.txtAreaSaida.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        String text = this.txtAreaSaida.getText();
        String login = this.mensagem.getNomeUnico();
        String nomeExibicao = this.mensagem.getNomeExibicao();

        this.mensagem = new Mensagem();

        if (this.listaUsuarioConectados.getSelectedIndex() > -1) {
            this.mensagem.setNomeUnico((String) this.listaUsuarioConectados.getSelectedValue());
            this.mensagem.setComando(Comando.ENVIAR_UM);
            this.listaUsuarioConectados.clearSelection();
        } else {
            this.mensagem.setComando(Comando.ENVIAR_TODOS);
        }

        if (!text.isEmpty()) {
            this.mensagem.setNomeExibicao(nomeExibicao);
            this.mensagem.setNomeUnico(login);
            this.mensagem.setTextoMensagem(text);
            this.service.enviar(this.mensagem);
        }

        this.txtAreaSaida.setText("");
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        Mensagem mensagem = new Mensagem();
        mensagem.setNomeUnico(this.mensagem.getNomeUnico());
        mensagem.setComando(Comando.DESCONECTAR);
        this.service.enviar(mensagem);
        desconectar();
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void btnConfigurarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarServidorActionPerformed
        TelaConfigurarServidor tela = new TelaConfigurarServidor();
        tela.setVisible(true);
    }//GEN-LAST:event_btnConfigurarServidorActionPerformed

    private void btnConfigurarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarPerfilActionPerformed
        TelaConfigurarPerfil tela = new TelaConfigurarPerfil();
        tela.setVisible(true);
    }//GEN-LAST:event_btnConfigurarPerfilActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed

        // Dados do Usuário
        String login = dadosCliente.get("LOGIN");
        String nomeExibicao = dadosCliente.get("NOME_EXIBICAO");
        String senha = dadosCliente.get("SENHA");
        String avatar;
        
        // Caso a imagem do avatar não seja setada ele envia a padrão, caso seja envia a escolhida pelo usuario
        if(dadosCliente.get("AVATAR") == null){
          avatar = dadosCliente.get("/chatsocket/app/icons/user_padrao.png");    
        }else{
          avatar = dadosCliente.get("AVATAR");  
        }
        
        //Dados Servidor
        String ipServidor = dadosServidor.get("IP_SERVIDOR");
        String portaServidor = dadosServidor.get("PORTA_SERVIDOR");
          
        /* Valida dados Obrigatorios*/
        if(login == null){
             JOptionPane.showMessageDialog(this, "O campo não pode ser vazio!\nPerfil >> Login");
        } else if(nomeExibicao == null){
             JOptionPane.showMessageDialog(this, "O campo não pode ser vazio!\nPerfil >> Nome Exibição");
        } else if(senha == null){
             JOptionPane.showMessageDialog(this, "O campo não pode ser vazio!\nPerfil >> Senha");
        } else if(ipServidor == null){
             JOptionPane.showMessageDialog(this, "O campo não pode ser vazio!\nServidor >> Endereço do Servidor");
        } else if(portaServidor == null){
             JOptionPane.showMessageDialog(this, "O campo não pode ser vazio!\nServidor >> Porta de comunicação");
        } else {
            
            // Conectar ao servidor
            this.mensagem = new Mensagem();
            this.mensagem.setComando(Comando.CONECTAR);
            this.mensagem.setNomeExibicao(nomeExibicao);
            this.mensagem.setNomeUnico(login);
            this.mensagem.setSenha(senha);
            this.mensagem.setAvatar(avatar);
            this.service = new ClienteService();
            
            try {
                this.socket = this.service.conectar(ipServidor,Integer.parseInt(portaServidor));
                new Thread(new ListenerSocket(this.socket)).start();
                this.service.enviar(mensagem);
            } catch (IOException ex) {
                Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "O servidor não pode ser alcançado");
            }            
        }       
    }//GEN-LAST:event_btnConectarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnConfigurarPerfil;
    private javax.swing.JButton btnConfigurarServidor;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaUsuarioConectados;
    private javax.swing.JTextArea txtAreaExibicao;
    private javax.swing.JTextArea txtAreaSaida;
    // End of variables declaration//GEN-END:variables
}
