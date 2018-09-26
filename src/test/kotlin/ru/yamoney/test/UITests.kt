package ru.yamoney.test

import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeDriver

class UITests {

    @Test
        fun UITest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\treumnova\\Desktop\\chromedriver.exe")
     val webDriver = ChromeDriver()
        webDriver.get("http://money.yandex.ru")
        webDriver.close()
    }
}