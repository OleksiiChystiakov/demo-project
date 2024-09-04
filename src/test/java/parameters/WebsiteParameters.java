package parameters;

import data.WebsiteData;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static data.WebsiteData.baseUrlDE;

public class WebsiteParameters {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        Object[][] data;
        switch (System.getProperty("environment"))
        {
            case "Live":
                data = new Object[][]{
                        {"store-NL", ""},
                        {"store-DE", ""},
                        {"store-BE", ""},
                        {"store-PL", ""},
                        {"store-UK", ""},
                        {"store-AT", ""},
                        {"store-FR", ""},
                        {"store-BEFR", ""},
                        {"store-EU", ""},
                        {"store-SE", ""},
                        {"store-ES", ""},
                        {"store-IE", ""},
                        {"store-IT", ""},
                        {"store-DK", ""},
                        {"store-CH-de", ""},
                        {"store-CH-it", ""},
                        {"store-CH-fr", ""},
                        {"store-PT", ""},
                        {"store-GR", ""},
                        {"store-SK", ""},
                        {"store-HU", ""},
                        {"store-RO", ""},
                        {"store-SI", ""},
                        {"store-HR", ""},
                        {"store-BG", ""},
                        {"store-CZ", ""},
                        {"store-EE", ""},
                        {"store-LV", ""},
                        {"store-LT", ""}};
                break;
            case "Stg":
                data = new Object[][]{{"store-NL", ""},
                        {"store-DE", ""},
                        {"store-BE", ""},
                        {"store-PL", ""}};
                break;
            default:
                Assert.fail();
                data = new Object[0][0];

        }
        return Arrays.asList(data);

    }
}
