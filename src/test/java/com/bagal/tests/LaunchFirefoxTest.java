package com.bagal.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class LaunchFirefoxTest {
    @Test
    void testLaunchFirefox() {
        try(Playwright playwright= Playwright.create()){
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("firefox"));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.google.com");
            System.out.println("page.title() = " + page.title());
            page.close();
            context.close();
            browser.close();
        }
    }
}
