package view;

import model.Banco;
import model.Conta;

import javax.swing.*;

public class TelaSaldo {

    public TelaSaldo(Banco banco) {
        String cpf = JOptionPane.showInputDialog("CPF:");
        Conta conta = banco.buscarContaPorCpf(cpf);

        if (conta != null) {
            JOptionPane.showMessageDialog(null,
                    "Cliente: " + conta.getCliente().getNome() +
                            "\nSaldo: R$ " + conta.getSaldo());
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        }
    }
}