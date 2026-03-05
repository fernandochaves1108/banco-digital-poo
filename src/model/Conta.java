package model;

import java.io.Serializable;

public abstract class Conta implements Serializable {
    protected Cliente cliente;
    protected double saldo;
    protected int numero;

    public Conta(Cliente cliente, int numero) {
        this.cliente = cliente;
        this.numero = numero;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > saldo) return false;
        saldo -= valor;
        return true;
    }

    public double getSaldo() { return saldo; }
    public Cliente getCliente() { return cliente; }
    public int getNumero() { return numero; }
}