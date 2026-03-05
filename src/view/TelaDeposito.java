package view;

import model.Banco;
import model.Conta;
import persistencia.BancoArquivo;

import javax.swing.*;

public class TelaDeposito {

    public TelaDeposito(Banco banco) {

        String cpf = JOptionPane.showInputDialog("CPF:");
        Conta conta = banco.buscarContaPorCpf(cpf);

        if (conta != null) {
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor:"));
            conta.depositar(valor);
            BancoArquivo.salvar(banco);
            JOptionPane.showMessageDialog(null, "Depósito realizado!");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        }
    }
}