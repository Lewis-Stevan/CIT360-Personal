import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUnitTest {

	String message = "Hello World";
	MessageUtility messageUtil = new MessageUtility(message);

	@Test
	public void testPrintMessage() {
		assertEquals(message, messageUtil.printMessage());
	}
}