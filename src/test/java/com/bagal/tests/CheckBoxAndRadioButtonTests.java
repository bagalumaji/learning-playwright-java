package com.bagal.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.assertions.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckBoxAndRadioButtonTests {
    @Test
    public void testCheckBoxTest() {
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");

            Locator clickOnCheckBox = page.getByLabel("Click on check box");
          //  Thread.sleep(5000);
            assertThat(clickOnCheckBox).isChecked();
            clickOnCheckBox.uncheck();

            //Thread.sleep(3000);
            clickOnCheckBox.check();
            //Thread.sleep(5000);

            page.close();
            browserContext.close();
            browser.close();
        }
    }
}
