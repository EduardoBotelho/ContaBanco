package Principal;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarContasEClientes() {
        System.out.println("=== Listagem de Contas e Clientes ===");
        for (Conta conta : contas) {
            System.out.println(String.format("Titular: %s", conta.getCliente().getNome()));
            System.out.println(String.format("Agencia: %d", conta.getAgencia()));
            System.out.println(String.format("Numero: %d", conta.getNumero()));
            System.out.println(String.format("Saldo: %.2f", conta.getSaldo()));
            System.out.println("--------------------------------------");
        }
    }
}
