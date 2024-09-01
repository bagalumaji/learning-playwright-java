package com.bagal.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

public class FileUploadTests {
    @Test
    void testFileWithoutTypeFileUpload() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate("https://the-internet.herokuapp.com/upload");
            Locator dragAndDropFile = page.locator("id=drag-drop-upload");
            FileChooser fileChooser = page.waitForFileChooser(dragAndDropFile::click);
            fileChooser.setFiles(Paths.get(System.getProperty("user.dir")+ File.separator+"src/test/resources/testdata/test.txt"));
            page.waitForTimeout(1000);

            page.close();
            browserContext.close();
            browser.close();
        }
    }
    @Test
    void fileUploadWithTypeFileTest() {
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://the-internet.herokuapp.com/upload");
            page.locator("id=file-upload").setInputFiles(Paths.get(System.getProperty("user.dir")+ File.separator+"src/test/resources/testdata/test.txt"));
            page.waitForTimeout(2000);
            page.close();
            context.close();
            browser.close();
        }
    }
}
