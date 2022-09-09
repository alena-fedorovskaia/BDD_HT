package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestInitializer extends BaseTest {
    @Before
    public void initDriver() {
        setup();
    }

    @After
    public void afterScenario() {
        cleanUp();
    }
}
