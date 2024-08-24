package com.bagal.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class ClickAndFillTests {
    @Test
    void fillTest() throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://the-internet.herokuapp.com/inputs");
            page.locator("//input[@type=\"number\"]").fill("123");
            Thread.sleep(5000);
            page.close();
            browserContext.close();
            browser.close();
        }
    }
    @Test
    void clickTest() throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://the-internet.herokuapp.com/add_remove_elements/");
            page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Add Element")).click();
            Thread.sleep(5000);
            page.close();
            browserContext.close();
        }
    }
}
