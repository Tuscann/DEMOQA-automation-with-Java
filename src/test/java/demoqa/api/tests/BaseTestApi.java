package demoqa.api.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTestApi {
    public SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
    }
}
