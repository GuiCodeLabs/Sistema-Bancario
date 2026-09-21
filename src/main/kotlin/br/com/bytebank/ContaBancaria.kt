package br.com.bytebank

open class ContaBancaria(
    val cliente: Cliente,
    val numero: Int,
    saldoInicial: Double = 0.0
) {
    var saldo: Double = 0.0
        private set

    private val historico = mutableListOf<String>()

    init {
        if (saldoInicial > 0) {
            saldo = saldoInicial
            registrarOperacao("Conta criada com saldo inicial de R$ ${formatarValor(saldoInicial)}.")
        } else {
            registrarOperacao("Conta criada com saldo inicial de R$ 0,00.")
        }
    }

    fun depositar(valor: Double): Boolean {
        if (valor <= 0) {
            println("Valor de depósito inválido!")
            return false
        }

        adicionarAoSaldo(
            valor,
            "Depósito de R$ ${formatarValor(valor)} realizado."
        )

        println("Depósito realizado com sucesso!")
        return true
    }

    open fun sacar(valor: Double): Boolean {
        if (valor <= 0) {
            println("Valor de saque inválido!")
            return false
        }

        val saqueRealizado = retirarDoSaldo(
            valor,
            "Saque de R$ ${formatarValor(valor)} realizado."
        )

        if (!saqueRealizado) {
            println("Saldo insuficiente para realizar esta operação!")
            return false
        }

        println("Saque realizado com sucesso!")
        return true
    }

    fun transferir(destino: ContaBancaria, valor: Double): Boolean {
        if (destino === this) {
            println("Não é possível transferir para a mesma conta!")
            return false
        }

        if (valor <= 0) {
            println("Valor de transferência inválido!")
            return false
        }

        val transferenciaRealizada = retirarDoSaldo(
            valor,
            "Transferência de R$ ${formatarValor(valor)} enviada para a conta ${destino.numero}."
        )

        if (!transferenciaRealizada) {
            println("Saldo insuficiente para realizar esta operação!")
            return false
        }

        destino.receberTransferencia(this, valor)
        println("Transferência realizada com sucesso!")
        return true
    }

    fun consultarSaldo(): Double {
        return saldo
    }

    open fun exibirDados() {
        println("Cliente: ${cliente.nome}")
        println("CPF: ${cliente.cpf}")
        println("Conta: $numero")
        println("Saldo atual: R$ ${formatarValor(saldo)}")
    }

    fun exibirHistorico() {
        println("====================================")
        println("HISTÓRICO DE OPERAÇÕES")
        println("====================================")

        for (operacao in historico) {
            println(operacao)
        }
    }

    protected fun adicionarAoSaldo(valor: Double, descricao: String) {
        if (valor > 0) {
            saldo += valor
            registrarOperacao(descricao)
        }
    }

    protected fun retirarDoSaldo(valor: Double, descricao: String): Boolean {
        if (valor <= 0 || valor > saldo) {
            return false
        }

        saldo -= valor
        registrarOperacao(descricao)
        return true
    }

    protected fun registrarOperacao(descricao: String) {
        historico.add(descricao)
    }

    protected fun formatarValor(valor: Double): String {
        return "%.2f".format(valor)
    }

    private fun receberTransferencia(origem: ContaBancaria, valor: Double) {
        adicionarAoSaldo(
            valor,
            "Transferência de R$ ${formatarValor(valor)} recebida da conta ${origem.numero}."
        )
    }
}
