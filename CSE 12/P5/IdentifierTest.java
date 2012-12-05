import junit.framework.TestCase;


public class IdentifierTest extends TestCase {
	public void testParse() {
		String testString1 = " A  ";
		String testString2 = "  Glenn   ";
		String testString3 = "  $Glenn318_$   ";
		
		assertNotNull(Identifier.parse(testString1));
		assertNotNull(Identifier.parse(testString2));
		assertNotNull(Identifier.parse(testString3));
	}
	
	public void testParseNull() {
		String testString1 = " 1   ";
		String testString2 = "  22hello  ";
		String testString3 = "  jxlakxh(#&$!(%    ";
		
		assertNull(Identifier.parse(testString1));
		assertNull(Identifier.parse(testString2));
		assertNull(Identifier.parse(testString3));
	}
	
	public void testEvalRuntimeException() {
		try{
			Identifier testIdent = Identifier.parse("  A    ");
			testIdent.eval(new java.util.HashMap<String, Double>());
			fail("Should have thrown RuntimeException. Var uninitialized.");
		} catch (RuntimeException e) {
			//RuntimeException caught. Behaved as specified.
			assertTrue(true);
		}
	}
}
