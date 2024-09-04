package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class HomePage {
    public static String mainHomePageBanner = ".main-banner.clearfix";
    public static String productsWidgets = ".promotion-slider-products";
    public static String catalogPreviewBlock = ".catalog-preview";
    public static String inspirationBlock = ".inspiration";
    public static String addToCartButton = ".promotion-slider .action.tocart.primary";

    public static void addProductToCart(){
        $(HomePage.mainHomePageBanner).scrollTo();
        $(HomePage.addToCartButton).shouldBe(Condition.visible).click();
        $(BasePage.successMessage).shouldBe(Condition.visible);
        sleep(1000);
        $(BasePage.minicartIcon).click();
        $(BasePage.viewCartButtonInMiniCart).shouldBe(Condition.visible).click();
    }

}
