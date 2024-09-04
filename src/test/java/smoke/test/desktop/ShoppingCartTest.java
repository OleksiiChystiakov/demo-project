package smoke.test.desktop;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.HomePage;
import pages.ShoppingCartPage;
import parameters.RetryRule;
import parameters.WebsiteParameters;

import static com.codeborne.selenide.Selenide.*;

@RunWith(Parameterized.class)
public class ShoppingCartTest extends WebsiteParameters {

    public ShoppingCartTest (String envName, String envUrl){
        Configuration.baseUrl = envUrl;
        websiteName=envName;
    }

    private String websiteName;

    @Rule
    public RetryRule retryRule = new RetryRule(2);

    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @After
    public void cleanData() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void checkShoppingCartElements() {
        open("");
        $(By.xpath(BasePage.acceptCookie)).click();
        HomePage.addProductToCart();
        $(ShoppingCartPage.cartTitle).shouldBe(Condition.visible);
        $(ShoppingCartPage.productGrid).shouldBe(Condition.visible);
        $(ShoppingCartPage.summaryBlock).shouldBe(Condition.visible);
        $(ShoppingCartPage.proceedToCheckoutButton).shouldBe(Condition.visible);
    }
}
