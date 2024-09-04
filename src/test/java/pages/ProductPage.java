package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    public static String topLinks = ".product-info-top-links";
    public static String imageSection = ".product.media";
    public static String priceBox = ".product-info-main .price-box";
    public static String addToCartButton = "#product-addtocart-button";
    public static String productDescription = ".page-detailed-content";
    public static String serviceSection = ".under-tabs #service-section";
    public static String productName = ".base";
    public static String proceedToCartButtonInPopup = ".l-popup-last.border .button";




    public static void getProductUrl(){
        List<SelenideElement> productsInCategory = $$(CategoryPage.productName);
        int productsIndex = productsInCategory.size();
        Random random = new Random();
        int randomProductIndex = random.nextInt(productsIndex);
        String productURL = productsInCategory.get(randomProductIndex).attr("href");
        open(productURL);
        sleep(1000);
    }

    public static void goToCheckout(){
        CategoryPage.getCategoryUrl();
        ProductPage.getProductUrl();
        $(ProductPage.addToCartButton).click();
        sleep(2500);
        if($(ProductPage.proceedToCartButtonInPopup).is(Condition.visible))
            open("/checkout/");
        else {
            $(BasePage.proceedToCheckoutButton).shouldBe(Condition.visible).click();
        }
        $(CheckoutPage.loader).shouldHave(Condition.attribute("style"));
        $(CheckoutPage.shippingMethodSection).shouldBe(Condition.visible);
        $(CheckoutPage.checkoutTotalBlock).shouldBe(Condition.visible);

    }
}
