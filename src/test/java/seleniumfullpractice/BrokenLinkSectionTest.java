package seleniumfullpractice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import seleniumfullpractice.sectionObjects.BrokenLinkSection;

public class BrokenLinkSectionTest {

    BaseConfig config;
    WebDriver driver;
    BrokenLinkSection brokenLinkSection;

    @BeforeClass
    public void setUp() {
        config = BaseConfig.getInstance();
        driver = BaseConfig.getDriverInstance();
        brokenLinkSection = new BrokenLinkSection(driver);
        // config.initialize();
    }

    @Test
    public void there_are_no_broken_links() throws IOException, InterruptedException {
        List<WebElement> links = brokenLinkSection.getLinks();
        SoftAssert softAssert = new SoftAssert();
        HttpClient client = HttpClient.newHttpClient();

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url == null || url.isEmpty()) {
                System.out.println("URL is not configured");
                continue;
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .method("HEAD", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

            int respCode = response.statusCode();
            System.out.println(respCode);

            softAssert.assertTrue(respCode < 400, "The link with Text \"" + link.getText() + "\" is broken with code " + respCode);
        }
        softAssert.assertAll();
    }

}
