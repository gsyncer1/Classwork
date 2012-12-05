import junit.framework.TestCase;


public class FactorTest extends TestCase {
	public void testParseConstant() {
		String testString = "  9.2752   ";
		ASTNode testNode = Factor.parse(testString);
		assertNotNull(testNode);
	}
	
	public void testParseIdentifier() {
		String testString = "   foobar   ";
		ASTNode testNode = Factor.parse(testString);
		assertNotNull(testNode);
	}
	
	public void testEvalConstant() {
		String testString = "  9.17573    ";
		ASTNode testNode = Factor.parse(testString);
		assertEquals(9.17573, testNode.eval(new java.util.HashMap<String,Double>()));
	}

}
