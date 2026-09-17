package br.com.bytebank

class ContaPoupanca(
    cliente: Cliente,
    numero: Int,
    saldoInicial: Double,
    private val taxaRendimento: Double = 0.005
) : ContaBancaria(cliente, numero, saldoInicial) {

    fun aplicarRendimento() {

        if (saldo <= 0 || taxaRendimento <= 0) {
            println("Não foi possível aplicar o rendimento.")
            return
        }

        val rendimento = saldo * taxaRendimento

        adicionarAoSaldo(rendimento)

        registrarOperacao(
            "Rendimento de ${formatarValor(rendimento)} aplicado."
        )

        println(
            "Rendimento de ${formatarValor(rendimento)} aplicado com sucesso!"
        )
    }

    override fun exibirDados() {
        println("Tipo da conta: Conta Poupança")
        super.exibirDados()
    }
}

