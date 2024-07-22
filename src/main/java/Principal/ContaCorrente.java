package Principal;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void imprimitExtrato() {
        System.out.println("=== Extrato de Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}
