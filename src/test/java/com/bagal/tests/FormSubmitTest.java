package com.bagal.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FormSubmitTest {
    @Test
    void testFormSubmit() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.lambdatest.com/selenium-playground");
            page.getByText("Input Form Submit").click();
            page.waitForLoadState();
            boolean headingFormDemo = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Form Demo")).isVisible();


            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name")).fill("sayaji");
            page.getByPlaceholder("Email", new Page.GetByPlaceholderOptions().setExact(true)).fill("sayajibagal@gmail.com");
            page.locator("#inputPassword4").fill("Sayaji@123456");
            page.locator("#company").fill("Self Employee");
            page.locator("#websitename").fill("https://www.google.com");
            Locator comboxCountry = page.locator("//select[@name='country']");
            comboxCountry.selectOption("India");
            assertThat(comboxCountry).hasValue("IN");
            page.locator("#inputCity").fill("Pune");
            page.locator("#inputAddress1").fill("Hadapsar");
            page.locator("#inputAddress2").fill("Hadapsar");
            page.locator("#inputState").fill("Maharashtra");
            page.locator("#inputZip").fill("411028");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
            //  page.pause();
            boolean isVisibleText = page.getByText("Thanks for contacting us, we will get back to you shortly.").isVisible();

        }
    }
}
