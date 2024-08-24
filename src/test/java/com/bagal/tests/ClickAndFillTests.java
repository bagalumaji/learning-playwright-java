package com.bagal.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class ClickAndFillTests {
    @Test
    void fillTest() throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://the-internet.herokuapp.com/inputs");
            page.locator("").fill("test data");
            Thread.sleep(5000);
            page.close();
            browserContext.close();
            browser.close();
        }
    }
}
