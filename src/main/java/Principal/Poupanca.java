package Principal;

public class Poupanca extends Conta{

    public Poupanca(Cliente cliente){
        super(cliente);
    }

    public void imprimitExtrato() {
        System.out.println("=== Extrato de Conta Poupança ===");
        super.imprimirInfosComuns();
    }


}
