package tests;

import com.microsoft.playwright.*;

public class LaunchFirefoxBrowserTest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/");
        System.out.println("page.title() = " + page.title());
        System.out.println("page.url() = " + page.url());
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
