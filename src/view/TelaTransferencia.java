package view;

import model.Banco;
import persistencia.BancoArquivo;

import javax.swing.*;

public class TelaTransferencia {

    public TelaTransferencia(Banco banco) {

        String origem = JOptionPane.showInputDialog("CPF Origem:");
        String destino = JOptionPane.showInputDialog("CPF Destino:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor:"));

        if (banco.transferir(origem, destino, valor)) {
            BancoArquivo.salvar(banco);
            JOptionPane.showMessageDialog(null, "Transferência realizada!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na transferência!");
        }
    }
}