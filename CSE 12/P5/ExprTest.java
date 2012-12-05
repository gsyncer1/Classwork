import junit.framework.TestCase;


public class ExprTest extends TestCase {
	public void testEval () {
		String testString = "(8 + 376) - 0.0 + (12 - 3.14159)";
		ASTNode testNode = Expr.parse(testString);
		assertNotNull(testNode);
		assertEquals(392.85841, testNode.eval(new java.util.HashMap<String, Double>()));
	}
}
