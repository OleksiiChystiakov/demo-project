package smoke.test.desktop;


import com.codeborne.selenide.*;
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
import pages.CategoryPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import parameters.RetryRule;
import parameters.WebsiteParameters;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

@RunWith(Parameterized.class)
public class ProductPageTest extends WebsiteParameters {

    public ProductPageTest (String envName, String envUrl){
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
    public void checkPDPElements() {
        open("");
        $(By.xpath(BasePage.acceptCookie)).click();
        CategoryPage.getCategoryUrl();
        ProductPage.getProductUrl();
        $(ProductPage.topLinks).shouldBe(Condition.visible);
        $(ProductPage.imageSection).shouldBe(Condition.visible);
        $(ProductPage.priceBox).shouldBe(Condition.visible);
        $(ProductPage.addToCartButton).shouldBe(Condition.visible);
        $(ProductPage.productDescription).shouldBe(Condition.visible);
        $(ProductPage.serviceSection).shouldBe(Condition.visible);

    }

    @Test
    public void checkAddToCartFunction() {
        open("");
        $(By.xpath(BasePage.acceptCookie)).click();
        CategoryPage.getCategoryUrl();
        String firstProductName = $(CategoryPage.productName).getText();
        $(CategoryPage.addToCartButton).shouldBe(Condition.visible).click();
        ProductPage.getProductUrl();
        String secondProductName = $(ProductPage.productName).getText();
        $(ProductPage.addToCartButton).click();
        if($(ProductPage.proceedToCartButtonInPopup).is(Condition.visible))
            $(ProductPage.proceedToCartButtonInPopup).click();
        else {
            $(BasePage.viewCartButtonInMiniCart).click();
        }
        $(ShoppingCartPage.productName1).shouldHave(Condition.text(firstProductName));
        $(ShoppingCartPage.productName2).shouldHave(Condition.text(secondProductName));


    }
}
