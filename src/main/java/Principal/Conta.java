package Principal;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Conta implements IConta {

    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    private String tipoConta;
    private LocalDate dataAbertura;
    private String statusConta;
    private List<Transacao> historicoTransacoes;
    private double limiteChequeEspecial;
    private double jurosMensais;
    private String chavePix;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.dataAbertura = LocalDate.now();
        this.statusConta = "Ativa";
        this.historicoTransacoes = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        saldo = saldo - valor;
        historicoTransacoes.add(new Transacao("Saque", valor));
    }

    @Override
    public void depositar(double valor) {
        saldo = saldo + valor;
        historicoTransacoes.add(new Transacao("Depósito", valor));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        historicoTransacoes.add(new Transacao("Transferência", valor));
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agência: %d%n", this.agencia);
        System.out.printf("Número: %d%n", this.numero);
        System.out.printf("Saldo : %.2f%n", this.saldo);
        System.out.printf("Data de Abertura: %s%n", this.dataAbertura);
        System.out.printf("Status da Conta: %s%n", this.statusConta);
    }
}
