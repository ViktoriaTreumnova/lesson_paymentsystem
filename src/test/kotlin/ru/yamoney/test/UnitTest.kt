package ru.yamoney.test

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.comparesEqualTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

class UnitTest {

    @Test
    fun checkDeposit() {
        val sum = BigDecimal("222.11")
        val depositOperation = Deposit("Vasya", sum)
        val initialBalance = BigDecimal("2")
        val newBalance = depositOperation.calculate(initialBalance)

        assertThat ("баланс совпал", newBalance, comparesEqualTo(initialBalance+sum))
    }

}
