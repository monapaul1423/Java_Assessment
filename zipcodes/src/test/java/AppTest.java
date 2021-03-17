import java.util.List;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class AppTest extends TestCase {
  public AppTest(String testName) {
    super(testName);
  }

  public static TestSuite suite() {
    return  new TestSuite(AppTest.class);
  }

@Test
  public void testIllegalArgumentException() {
    try {
      String inputDataSet = "[92004,92002] [92003,92004]";
      ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(inputDataSet);
      List<ZipcodeGetterSetter> zipcodeList = zipcodeProcessor.stripZipcode();
    } catch (IllegalArgumentException e) {
      assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
    }
  }

@Test
  public void testExceptionWhenMoreRanges() {
    try {
      String inputDataSet = "[92004,92002,92003] [92003,92004]";
      ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(inputDataSet);
      List<ZipcodeGetterSetter> zipcodeList = zipcodeProcessor.stripZipcode();
    } catch (IllegalArgumentException e) {
      assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
    }
  }

@Test
  public void testExceptionMessageWhenLowerBoundGreater() {
    try {
      String inputDataSet = "[92004,92002] [92003,92004]";
      ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(inputDataSet);
      List<ZipcodeGetterSetter> zipcodeList = zipcodeProcessor.stripZipcode();
    } catch (IllegalArgumentException e) {
      String expectedMessage = "92004 92002:  Zipcode lower bound should be less" + " than upper bound";
      assertEquals(expectedMessage, e.getMessage());
    }
  }

@Test
  public void testExceptionMessageWhenMoreRangeGiven() {
    try {
      String inputDataSet = "[92004,92002,92003] [92003,92004]";
      ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(inputDataSet);
      List<ZipcodeGetterSetter> zipcodeList = zipcodeProcessor.stripZipcode();
    } catch (IllegalArgumentException e) {
      String expectedMessage = "92004Zipcode should have lower " + "and upper bounds";
      assertEquals(expectedMessage, e.getMessage());
    }
  }

}
