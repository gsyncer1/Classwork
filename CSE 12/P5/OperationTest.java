import junit.framework.TestCase;


public class OperationTest extends TestCase {
		//TEST OPERATION AFTER TESTING TERM AND FACTOR
	public void testEval() {
		String testString1 = "1   -   2  *   3";
		String testString2 = "2   *  3  -  1";
		String testString3 = "1  +  2  *  3   -   4   / 5";
		ASTNode testNode1 = Operation.parse(testString1);
		ASTNode testNode2 = Operation.parse(testString2);
		ASTNode testNode3 = Operation.parse(testString3);
		assertEquals(-5.0, testNode1.eval(new java.util.HashMap<String, Double>()));
		assertEquals(5.0, testNode2.eval(new java.util.HashMap<String, Double>()));
		assertEquals(6.2, testNode3.eval(new java.util.HashMap<String, Double>()));
	}
}
