package view;

import model.Banco;
import persistencia.BancoArquivo;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private Banco banco;

    public TelaPrincipal() {
        banco = BancoArquivo.carregar();

        setTitle("Banco Digital");
        setSize(400, 300);
        setLayout(new GridLayout(6,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btnAbrir = new JButton("Abrir Conta");
        JButton btnDeposito = new JButton("Depósito");
        JButton btnSaque = new JButton("Sacar");
        JButton btnSaldo = new JButton("Ver Saldo");
        JButton btnTransferencia = new JButton("Transferência");

        add(btnAbrir);
        add(btnDeposito);
        add(btnSaque);
        add(btnSaldo);
        add(btnTransferencia);

        btnAbrir.addActionListener(e -> new TelaAbrirConta(banco));
        btnDeposito.addActionListener(e -> new TelaDeposito(banco));
        btnSaque.addActionListener(e -> new TelaSaque(banco));
        btnSaldo.addActionListener(e -> new TelaSaldo(banco));
        btnTransferencia.addActionListener(e -> new TelaTransferencia(banco));

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}