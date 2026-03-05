package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Banco implements Serializable {

    private List<Conta> contas = new ArrayList<>();
    private int proximoNumero = 1;

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarContaPorCpf(String cpf) {
        for (Conta c : contas) {
            if (c.getCliente().getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public int gerarNumeroConta() {
        return proximoNumero++;
    }

    public boolean transferir(String cpfOrigem, String cpfDestino, double valor) {
        Conta origem = buscarContaPorCpf(cpfOrigem);
        Conta destino = buscarContaPorCpf(cpfDestino);

        if (origem != null && destino != null && origem.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}