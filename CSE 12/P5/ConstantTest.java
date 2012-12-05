import java.util.Map;

import junit.framework.TestCase;


public class ConstantTest extends TestCase {
	public void testParse() {
		String testString1 = "  0   ";
		String testString2 = "  1.0  ";
		
		assertNotNull(Constant.parse(testString1));
		assertNotNull(Constant.parse(testString2));
	}
	
	public void testParseNull() {
		String testString = "   b  ";
		assertNull(Constant.parse(testString));
	}
	
	public void testEval() {
		String testString1 = " 0  ";
		String testString2 = "   1.0    ";
		
		ASTNode testNode1 = Constant.parse(testString1);
		ASTNode testNode2 = Constant.parse(testString2);
		
		Map<String, Double> symtab = new java.util.HashMap<String, Double>();
		assertEquals(0.0, testNode1.eval(symtab));
		assertEquals(1.0, testNode2.eval(symtab));
	}
}
