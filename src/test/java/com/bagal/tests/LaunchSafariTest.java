package com.bagal.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class LaunchSafariTest {
    @Test
    void launchSafariTest() {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.google.com/");
            System.out.println("page.title() = " + page.title());
            page.close();
            context.close();
            browser.close();
        }
    }
}
