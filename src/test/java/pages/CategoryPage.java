package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class CategoryPage {

    public static String categoryUrl = "#ui-id-2>li:not(.nav-7) a[href*='https://']";


    public static void getCategoryUrl(){
        List<SelenideElement> category = $$(CategoryPage.categoryUrl);
        int categoryIndex = category.size();
        Random random = new Random();
        int randomCategoryIndex = random.nextInt(categoryIndex);
        String categoryURL = category.get(randomCategoryIndex).attr("href");
        open(categoryURL);
    }

    public static String categoryTitle = "#page-title-heading";
    public static String breadcrumbs = ".breadcrumbs .items";
    public static String categoryDescription = ".category-description";
    public static String categoryImage = ".category-image";
    public static String filteringBlock = "#narrow-by-list #facet-filter-form";
    public static String productGrid = ".products-wrapper.grid";
    public static String gridToolBar = ".toolbar.toolbar-products.clearfix";
    public static String pagination = "#paging-label";
    public static String products = ".products-wrapper.grid .item.product";
    public static String imagePlaceHolderLazyLoad = ".products-wrapper.grid .photo.image.lazyload";
    public static String productImage = ".products-wrapper.grid img[data-src*='media/catalog/product/']";
    public static String productName = ".products-wrapper.grid .product-item-link";
    public static String productPrice = ".products-wrapper.grid .price-box";
    public static String addToCartButton = ".products-wrapper.grid .action.tocart.primary";
    public static String moreInfoButton = ".products-wrapper.grid .action.secondary";
    public static String compareCheckbox = ".products-wrapper.grid .checkbox";
    public static String stockStatusLabel = ".products-wrapper.grid .stock";
    public static String seoBlockCategory = ".seo-block.category-seo";
    public static String lazyLoadPlaceholder = "div.products.wrapper.products-wrapper.grid.products-grid > ol > li:nth-child(1) > div > a >img[src*='default/images/pixel.png']";
    public static String searchPageTitle = ".page-title";

}
