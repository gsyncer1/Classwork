import junit.framework.TestCase;


public class TermTest extends TestCase {
	public void testParseFactor() {
		String testString1 = "  9.8  ";
		String testString2 = "  abcde  ";
		ASTNode testNode1 = Term.parse(testString1);
		ASTNode testNode2 = Term.parse(testString2);
		assertNotNull(testNode1);
		assertNotNull(testNode2);
	}
	
	public void testParseMultiply() {
		String testString1  = "  3 * 2 ";
		String testString2 = "   4   *   5   * 1";
		ASTNode testNode1 = Term.parse(testString1);
		ASTNode testNode2 = Term.parse(testString2);
		assertNotNull(testNode1);
		assertNotNull(testNode2);
	}
	
	public void testParseDivide() {
		String testString1 = "   4   /   2";
		String testString2 = "   8   /   2   /    2";
		ASTNode testNode1 = Term.parse(testString1);
		ASTNode testNode2 = Term.parse(testString2);
		assertNotNull(testNode1);
		assertNotNull(testNode2);
	}
	
	public void testParseMultiplyAndDivide() {
		String testString1 = "   4   *  3    /  2";
		String testString2 = "   3    /  4   * 9";
		ASTNode testNode1 = Term.parse(testString1);
		ASTNode testNode2 = Term.parse(testString2);
		assertNotNull(testNode1);
		assertNotNull(testNode2);
	}
}
