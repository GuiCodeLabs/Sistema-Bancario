package br.com.bytebank

fun main() {
    println("====================================")
    println("      BANCO BYTEBANK EVOLUTION      ")
    println("====================================")

    val cliente1 = Cliente("Maria Silva", "111.222.333-44")
    val cliente2 = Cliente("João Pedro", "999.888.777-66")
    val contaCorrente = ContaCorrente(cliente1, 1001)
    val contaPoupanca = ContaPoupanca(cliente2, 2002)

    println("\n--- DADOS DAS CONTAS ---")
    contaCorrente.exibirDados()
    contaPoupanca.exibirDados()

    println("\n--- DEPÓSITOS ---")
    contaCorrente.depositar(1000.0)
    contaCorrente.depositar(-50.0)

    println("\n--- SAQUES ---")
    contaCorrente.sacar(200.0)
    contaCorrente.sacar(5000.0)

    println("\n--- OPERAÇÕES ESPECÍFICAS ---")
    contaCorrente.aplicarTaxaMensal()
    contaPoupanca.aplicarRendimento()

    println("\n--- TRANSFERÊNCIA ---")
    contaCorrente.transferir(contaPoupanca, 300.0)

    println("\n--- SALDOS ATUAIS ---")
    println("Saldo CC: R$ ${contaCorrente.consultarSaldo()}")
    println("Saldo CP: R$ ${contaPoupanca.consultarSaldo()}")

    println("\n====================================")
    println("       HISTÓRICO DE OPERAÇÕES       ")
    println("====================================")
    println("Histórico de ${cliente1.nome}:")
    contaCorrente.exibirHistorico()

    println("\nHistórico de ${cliente2.nome}:")
    contaPoupanca.exibirHistorico()
}