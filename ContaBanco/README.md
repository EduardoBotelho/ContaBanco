# ContaBanco

##**Diagrama de Classes**
```mermaid
classDiagram
    class Main {
        +main(String[] args)
    }

    class Banco {
        -String nome
        -List<Conta> contas
        +getNome() : String
        +setNome(nome: String)
        +getContas() : List<Conta>
        +setContas(contas: List<Conta>)
        +adicionarConta(conta: Conta)
        +listarContasEClientes()
    }

    class Cliente {
        -String nome
        +getNome() : String
        +setNome(nome: String)
    }

    class Conta {
        <<abstract>>
        -int agencia
        -int numero
        -double saldo
        -Cliente cliente
        +Conta(cliente: Cliente)
        +getAgencia() : int
        +getNumero() : int
        +getSaldo() : double
        +getCliente() : Cliente
        +sacar(valor: double)
        +depositar(valor: double)
        +transferir(valor: double, contaDestino: Conta)
        +imprimirInfosComuns()
    }

    class ContaCorrente {
        +ContaCorrente(cliente: Cliente)
        +imprimitExtrato()
    }

    class Poupanca {
        +Poupanca(cliente: Cliente)
        +imprimitExtrato()
    }

    class IConta {
        <<interface>>
        +sacar(valor: double)
        +depositar(valor: double)
        +transferir(valor: double, contaDestino: Conta)
        +imprimitExtrato()
    }

    Main --> Cliente : usa
    Main --> ContaCorrente : usa
    Main --> Poupanca : usa
    Main --> Banco : usa
    Banco "1" --> "0..*" Conta : possui
    Conta *-- Cliente : refere-se
    ContaCorrente --|> Conta : estende
    Poupanca --|> Conta : estende
    Conta ..|> IConta : implementa

```

##**Detalhamento das Classes**

##**Projeto Banco Simples**
Este projeto é uma simulação de um sistema bancário simples em Java, utilizando a biblioteca Lombok para reduzir o código boilerplate. O sistema inclui funcionalidades básicas de uma conta bancária, como depósito, saque, transferência e impressão de extrato. Além disso, permite listar todas as contas e seus respectivos clientes.

##**Estrutura do Projeto**
O projeto é composto pelas seguintes classes e interfaces:

##**Classe Main**
A classe Main é responsável por iniciar a aplicação. Ela cria instâncias de Cliente, ContaCorrente, Poupanca e Banco, realiza operações de depósito e transferência, e imprime os extratos das contas.
