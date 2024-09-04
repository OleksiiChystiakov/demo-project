package smoke.test.desktop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.CustomerData;
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
import pages.CheckoutPage;
import pages.ProductPage;
import parameters.RetryRule;
import parameters.WebsiteParameters;

import static com.codeborne.selenide.Selenide.*;

@RunWith(Parameterized.class)
public class CheckoutTest extends WebsiteParameters {

    public CheckoutTest (String envName, String envUrl){
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
    public void checkBillingCheckoutStep() {
        open("");
        $(By.xpath(BasePage.acceptCookie)).click();
        ProductPage.goToCheckout();
        $(CheckoutPage.emailField).setValue(CheckoutPage.generateRandomEmail());
        $(CheckoutPage.firstNameField).setValue(CustomerData.firstName);
        $(CheckoutPage.lastNameField).setValue(CustomerData.lastName);
        $(CheckoutPage.streetField).setValue(CustomerData.street);
        $(CheckoutPage.houseNumberField).setValue(CustomerData.houseNumber);
        $(CheckoutPage.postCodeField).setValue(CustomerData.postcode);
        $(CheckoutPage.cityField).setValue(CustomerData.city);
        if($(CheckoutPage.regionDropdown).is(Condition.visible))
        {
            $(CheckoutPage.regionDropdown).selectOption(2);
        }
        $(CheckoutPage.telephoneField).setValue(CustomerData.telephone);
        $(CheckoutPage.proceedToBillingButton).click();
        $(CheckoutPage.paymentMethods).shouldBe(Condition.visible);
        $(CheckoutPage.creditCardRadioButton).click();
        $(CheckoutPage.creditCardForm).shouldBe(Condition.visible);
    }
}
