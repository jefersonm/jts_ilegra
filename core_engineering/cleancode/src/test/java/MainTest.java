import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void executableTest() {
        Main mainTest = new Main();
        Assert.assertNotNull(mainTest.running());
    }
}
