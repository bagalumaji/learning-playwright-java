package com.bagal.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public final class MouseActionTests {
    @Test
    void doubleClickTest(){
        try(Playwright playwright = Playwright.create()){
           Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://testautomationpractice.blogspot.com/");
            Locator textbox1 = page.locator("#field1");
            System.out.println("textbox1.inputValue() = " + textbox1.inputValue());
            page.locator("text=Copy Text").dblclick();
            assertThat(textbox1).hasValue("Hello World!");
            Locator textbox2 = page.locator("#field2");
            System.out.println("textbox2.inputValue() = " + textbox2.inputValue());
            assertThat(textbox2).hasValue("Hello World!");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
