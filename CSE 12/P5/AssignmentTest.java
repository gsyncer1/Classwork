import junit.framework.TestCase;


public class AssignmentTest extends TestCase {
	public void testParse(){
		String testString = " area = 9 ";
		ASTNode testNode = Assignment.parse(testString);
		assertTrue(testNode != null);
		assertTrue(testNode.getChild(0) instanceof Identifier);
		assertTrue(testNode.getChild(1) instanceof Expr);
	}
	
	public void testParseNull() {
		String testString = "2 * 3";
		ASTNode testNode = Assignment.parse(testString);
		assertTrue(testNode == null);
	}
	
	//TODO: WRITE TEST FOR EVAL
	public void testEval() {
		String testString = " area = 9 ";
		ASTNode testNode = Assignment.parse(testString);
		assertEquals(9.0, testNode.eval(new java.util.HashMap<String,Double>()));
	}
}
