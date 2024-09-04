package pages;

import java.util.Random;

public class CheckoutPage {
    public static String loader = "#html-body > div.loading-mask";
    public static String shippingMethodSection = "#opc-shipping_method";
    public static String checkoutTotalBlock = ".opc-block-summary";
    public static String emailField = "#customer-email";
    public static String firstNameField = "#shipping-new-address-form input[name=\"firstname\"]";
    public static String lastNameField = "#shipping-new-address-form input[name=\"lastname\"]";
    public static String streetField = "#shipping-new-address-form input[name=\"street[0]\"]";
    public static String houseNumberField = "#shipping-new-address-form input[name=\"street[1]\"]";
    public static String postCodeField = "#shipping-new-address-form input[name=\"postcode\"]";
    public static String cityField = "#shipping-new-address-form input[name=\"city\"]";
    public static String telephoneField = "#shipping-new-address-form input[name=\"telephone\"]";
    public static String regionDropdown = "#shipping-new-address-form select[name=\"region_id\"]";
    public static String regionOption = "#shipping-new-address-form select[name=\"region_id\"] option:nth-child(2)";
    public static String proceedToBillingButton = ".button.action.continue.primary";
    public static String paymentMethods = ".payment-group";
    public static String creditCardRadioButton = ".adyen-sprite.adyen_cc";
    public static String creditCardForm = ".adyen-checkout__card__form";


    public static String generateRandomEmail() {
        Random randomEmailSuffix = new Random();
        String customerEmail = "automationTest"+randomEmailSuffix.nextInt( 99999)+"@valantic.com";
        return customerEmail;
    }
}
