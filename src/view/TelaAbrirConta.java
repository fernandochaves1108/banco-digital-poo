package view;

import model.*;
import persistencia.BancoArquivo;

import javax.swing.*;

public class TelaAbrirConta extends JFrame {

    public TelaAbrirConta(Banco banco) {

        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();

        String[] tipos = {"Corrente", "Poupança"};
        JComboBox<String> tipoConta = new JComboBox<>(tipos);

        Object[] campos = {
                "Nome:", nome,
                "CPF:", cpf,
                "Tipo:", tipoConta
        };

        int op = JOptionPane.showConfirmDialog(null, campos, "Abrir Conta", JOptionPane.OK_CANCEL_OPTION);

        if (op == JOptionPane.OK_OPTION) {
            Cliente cliente = new Cliente(nome.getText(), cpf.getText());

            Conta conta;
            if (tipoConta.getSelectedIndex() == 0)
                conta = new ContaCorrente(cliente, banco.gerarNumeroConta());
            else
                conta = new ContaPoupanca(cliente, banco.gerarNumeroConta());

            banco.adicionarConta(conta);
            BancoArquivo.salvar(banco);

            JOptionPane.showMessageDialog(null, "Conta criada!");
        }
    }
}