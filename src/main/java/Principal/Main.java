package Principal;

public class Main {
    public static void main(String[] args) {
        Cliente eduardo = new Cliente();
        eduardo.setNome("Eduardo");

        Conta cc = new ContaCorrente(eduardo);
        Conta cp = new Poupanca(eduardo);

        Banco banco = new Banco();
        banco.setNome("Meu Banco");
        banco.adicionarConta(cc);
        banco.adicionarConta(cp);

        cc.depositar(200);
        cc.transferir(100, cp);

        cc.imprimitExtrato();
        cp.imprimitExtrato();

        banco.listarContasEClientes();
    }
}
