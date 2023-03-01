package PW_E2E_Workshop;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.junit.jupiter.api.Test;

public class SMTests {


    @Test
    public void openSmWebsite(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("https://softwaremind.com/");

        if(page.locator("#js-cookie-modal").isVisible()){
            page.locator("#js-cookie-modal").locator(".js-cookie-agreement").click();
            page.locator("#js-cookie-modal").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
        }
        page.locator("#menu-item-1862").click();
        if(page.locator("#js-cookie-modal").isVisible()){
            page.locator("#js-cookie-modal").locator(".js-cookie-agreement").click();
            page.locator("#js-cookie-modal").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
        }
    }
}
