package view;

import model.Banco;
import model.Conta;
import persistencia.BancoArquivo;

import javax.swing.*;

public class TelaSaque {

    public TelaSaque(Banco banco) {

        String cpf = JOptionPane.showInputDialog("CPF:");
        Conta conta = banco.buscarContaPorCpf(cpf);

        if (conta != null) {
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor:"));

            if (conta.sacar(valor)) {
                BancoArquivo.salvar(banco);
                JOptionPane.showMessageDialog(null, "Saque realizado!");
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        }
    }
}