package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class LocatorTests {
    @Test
    void locator1Test() throws InterruptedException {
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://www.saucedemo.com/");
            System.out.println("page.url() = " + page.url());
            System.out.println("page.title() = " + page.title());
            // finding the locators
            Locator textBoxUserName = page.locator("id=user-name");
            Locator textBoxPassword = page.locator("id=password");
            Locator btnLogin = page.locator(".submit-button.btn_action");

            textBoxUserName.fill("standard_user");
            textBoxPassword.fill("secret_sauce");
            btnLogin.click();
            Thread.sleep(10000);
        }

    }
}
