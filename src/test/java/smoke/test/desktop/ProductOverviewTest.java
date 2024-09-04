package smoke.test.desktop;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.WebsiteData;
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
import parameters.RetryRule;
import parameters.WebsiteParameters;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@RunWith(Parameterized.class)
public class ProductOverviewTest extends WebsiteParameters {
    public ProductOverviewTest (String envName, String envUrl){
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
    public void checkPOPElements() {
        open("");
        $(By.xpath(BasePage.acceptCookie)).click();
        CategoryPage.getCategoryUrl();
        $(CategoryPage.categoryTitle).shouldBe(Condition.visible);
        $(CategoryPage.breadcrumbs).shouldBe(Condition.visible);
        $(CategoryPage.categoryImage).shouldBe(Condition.visible);
        $(CategoryPage.filteringBlock).shouldBe(Condition.visible);
        $(CategoryPage.gridToolBar).shouldBe(Condition.visible);
        $(CategoryPage.productGrid).shouldBe(Condition.visible);
        List<SelenideElement> productsInCategory = $$(CategoryPage.productName);
        int productsIndex = productsInCategory.size();
        if(productsIndex!=36)
            $(CategoryPage.pagination).shouldNotBe(Condition.visible);
        else {
            $$(CategoryPage.pagination).shouldHave(CollectionCondition.size(2));
        }

    }

    @Test
    public void checkGridElements() {
        open("");
        $(By.xpath(BasePage.acceptCookie)).click();
        CategoryPage.getCategoryUrl();
        List<SelenideElement> productsInCategory = $$(CategoryPage.products);
        int productsIndex = productsInCategory.size();
        $$(CategoryPage.productImage).shouldHave(CollectionCondition.size(productsIndex));
        $$(CategoryPage.productName).shouldHave(CollectionCondition.size(productsIndex));
        $$(CategoryPage.productPrice).shouldHave(CollectionCondition.size(productsIndex));
        $$(CategoryPage.addToCartButton).shouldHave(CollectionCondition.size(productsIndex));
        $$(CategoryPage.moreInfoButton).shouldHave(CollectionCondition.size(productsIndex));
        $$(CategoryPage.compareCheckbox).shouldHave(CollectionCondition.size(productsIndex));
        $(CategoryPage.categoryImage).scrollTo();
        $(CategoryPage.lazyLoadPlaceholder).shouldNotBe(Condition.visible);
    }

    @Test
    public void checkSearchResultPageElements() {
        open("");
        $(By.xpath(BasePage.acceptCookie)).click();
        $(BasePage.searchField).setValue(WebsiteData.searchQuery).pressEnter();
        $(CategoryPage.searchPageTitle).shouldBe(Condition.visible);
        $(CategoryPage.breadcrumbs).shouldBe(Condition.visible);
        $(CategoryPage.filteringBlock).shouldBe(Condition.visible);
        $(CategoryPage.gridToolBar).shouldBe(Condition.visible);
        $(CategoryPage.productGrid).shouldBe(Condition.visible);
        List<SelenideElement> productsInSearchResult = $$(CategoryPage.products);
        int productsIndex = productsInSearchResult.size();
        if(productsIndex!=36)
            $(CategoryPage.pagination).shouldNotBe(Condition.visible);
        else {
            $$(CategoryPage.pagination).shouldHave(CollectionCondition.size(2));
        }

    }
}
