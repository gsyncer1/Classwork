import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(IdentifierTest.class);
		suite.addTestSuite(ExprTest.class);
		suite.addTestSuite(TermTest.class);
		suite.addTestSuite(ConstantTest.class);
		suite.addTestSuite(AssignmentTest.class);
		suite.addTestSuite(FactorTest.class);
		suite.addTestSuite(OperationTest.class);
		//$JUnit-END$
		return suite;
	}

}
