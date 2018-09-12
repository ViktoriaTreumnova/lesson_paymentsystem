package ru.yamoney.test

import org.hamcrest.Description
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.jupiter.api.Test
import java.awt.SystemColor.text
import java.math.BigDecimal

class CustomMatcher(val text: String = "4454"): TypeSafeMatcher<Payment>() {
    override fun matchesSafely(shop:Payment): Boolean {
        return shop.shopId.contains(text)
    }
    override fun describeTo(description: Description){
        description.appendText("Ты заплатил в имеющийся магазин $text")
    }
    fun customMatcherContains (text: String) = CustomMatcher(text)
}

class HomeWorkTests {
    @Test
    fun transferToUser(){
        val receivingUser = "Вася"
        val sum = BigDecimal("123")
        val transferOperation = Transfer("Вася", sum, receivingUser)
        MatcherAssert.assertThat("Перевод должен быть для Вовы", receivingUser, Matchers.comparesEqualTo("Вова"))
    }

    @Test
    fun paymentDestination() {
        val shop: CustomMatcher
        val sum = BigDecimal("123")
        val paymentOperation = Payment("Вася", sum, "4454")
       //CustomMatcher(shop) // Боже, как объявить свой кастомный матчер в коде?
    }

    @Test
    fun checkBalance() {
        val receivingUser = "Вася"
        val sum = BigDecimal("123")
        val startBalance = BigDecimal("123")
        val transferOperation = Transfer("Вася", sum, receivingUser)
        val balance = transferOperation.calculate(startBalance)
        MatcherAssert.assertThat ("Баланс отрицательный", balance, Matchers.comparesEqualTo(startBalance))

    }

}