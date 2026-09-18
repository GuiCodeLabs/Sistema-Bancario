class ContaCorrente(
    cliente: Cliente,
    numero: Int,
    saldoInicial: Double,
    private val taxaMensal: Double = 30.0
) : ContaBancaria(cliente, numero, saldoInicial) {

    fun aplicarTaxaMensal() {
        if (retirarDoSaldo(taxaMensal)) {
            println("Taxa mensal de ${formatarValor(taxaMensal)} aplicada.")
        } else {
            println("Saldo insuficiente para aplicar a taxa mensal.")
        }
    }

    override fun exibirDados() {
        println("Tipo de conta: Corrente")
        super.exibirDados()
    }
}