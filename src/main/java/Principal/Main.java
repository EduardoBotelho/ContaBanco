package Principal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente eduardo = new Cliente();
        eduardo.setNome("Eduardo");

        ContaCorrente cc = new ContaCorrente(eduardo);
        Poupanca cp = new Poupanca(eduardo);

        // Realizar operações
        cc.depositar(200);
        cc.sacar(50);
        cc.transferir(100, cp);

        // Imprimir extratos
        cc.imprimitExtrato();
        cp.imprimitExtrato();

        // Imprimir histórico de transações da conta corrente
        System.out.println("\n=== Histórico de Transações da Conta Corrente ===");
        imprimirHistoricoTransacoes(cc.getHistoricoTransacoes());

        // Imprimir histórico de transações da poupança
        System.out.println("\n=== Histórico de Transações da Poupança ===");
        imprimirHistoricoTransacoes(cp.getHistoricoTransacoes());
    }

    public static void imprimirHistoricoTransacoes(List<Transacao> historicoTransacoes) {
        for (Transacao transacao : historicoTransacoes) {
            System.out.printf("Tipo: %s, Valor: %.2f, Data e Hora: %s%n",
                    transacao.getTipo(), transacao.getValor(), transacao.getDataHora().toString());
        }
    }
}
