package chatsocket.app.tela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import chatsocket.app.servico.Servidor;
import chatsocket.app.bean.Mensagem;
import static chatsocket.app.bean.Mensagem.Comando.CONECTAR;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 * @since setembro/2018
 * @author lucas Costa @lcbenjamin
 */
public class PainelDeControle extends javax.swing.JFrame {

    private Servidor servidor;
    public static final List<String> USUARIOS_ONLINES = new ArrayList<>();
    
    public PainelDeControle() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        outputTextLOG = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaUsuarioConectados = new javax.swing.JList<>();
        btnAtualizarPorta = new javax.swing.JButton();
        textAtualizarPorta = new javax.swing.JTextField();
        labelPorta = new javax.swing.JLabel();
        btnOnOff = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");
        setResizable(false);

        outputTextLOG.setEditable(false);
        outputTextLOG.setColumns(20);
        outputTextLOG.setRows(5);
        jScrollPane3.setViewportView(outputTextLOG);

        listaUsuarioConectados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane4.setViewportView(listaUsuarioConectados);

        btnAtualizarPorta.setText("Atualizar");
        btnAtualizarPorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarPortaActionPerformed(evt);
            }
        });

        textAtualizarPorta.setText("10588");

        labelPorta.setText("Porta:");

        btnOnOff.setText("ON");
        btnOnOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnOffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelPorta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAtualizarPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarPorta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOnOff))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAtualizarPorta)
                            .addComponent(textAtualizarPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPorta)
                            .addComponent(btnOnOff))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarPortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarPortaActionPerformed

    }//GEN-LAST:event_btnAtualizarPortaActionPerformed

    private void btnOnOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnOffActionPerformed
        
    }//GEN-LAST:event_btnOnOffActionPerformed

    public void exibirLogTela(String log){
        this.outputTextLOG.append(log + "\n");
    }  
    
    public void mantemListaOnlines(Mensagem mensagem){
        
        if(mensagem.getComando() == CONECTAR){
            PainelDeControle.USUARIOS_ONLINES.add(mensagem.getNomeExibicao());
        }
        String[] array = (String[]) USUARIOS_ONLINES.toArray(new String[USUARIOS_ONLINES.size()]);
        
        this.listaUsuarioConectados.setListData(array);
        this.listaUsuarioConectados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listaUsuarioConectados.setLayoutOrientation(JList.VERTICAL);
        
    }

    public JButton getBtnAtualizarPorta() {
        return btnAtualizarPorta;
    }
    public void setBtnAtualizarPorta(JButton btnAtualizarPorta) {
        this.btnAtualizarPorta = btnAtualizarPorta;
    }
    public JToggleButton getBtnOnOff() {
        return btnOnOff;
    }
    public void setBtnOnOff(JToggleButton btnOnOff) {
        this.btnOnOff = btnOnOff;
    }
    public JList<String> getListaUsuarioConectados() {
        return listaUsuarioConectados;
    }
    public void setListaUsuarioConectados(JList<String> listaUsuarioConectados) {
        this.listaUsuarioConectados = listaUsuarioConectados;
    }
    public JTextArea getOutputTextLOG() {
        return outputTextLOG;
    }
    public void setOutputTextLOG(JTextArea outputTextLOG) {
        this.outputTextLOG = outputTextLOG;
    }
    public JTextField getTextAtualizarPorta() {
        return textAtualizarPorta;
    }
    public void setTextAtualizarPorta(JTextField textAtualizarPorta) {
        this.textAtualizarPorta = textAtualizarPorta;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarPorta;
    private javax.swing.JToggleButton btnOnOff;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelPorta;
    private javax.swing.JList<String> listaUsuarioConectados;
    private javax.swing.JTextArea outputTextLOG;
    private javax.swing.JTextField textAtualizarPorta;
    // End of variables declaration//GEN-END:variables
}
