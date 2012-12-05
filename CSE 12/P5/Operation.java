import java.util.Map;

/**
 * A class representing the <operation> nonterminal symbol in an
 * abstract syntax tree. This class has no public constructors;
 * the public interface for creating an instance of the class is the
 * static <tt>parse(String s)</tt> factory method.
 * @author Glenn Briones cs12faq
 */
public class Operation extends ASTNode {

	/**
	 * Determines the operation type.
	 * if opType == 0; <operation> is just a term;
	 * if opType == 1, then evaluate <operation> + <term>;
	 * if optype == 2, then evaluate <operation> - <term>;
	 */
	private int opType;
	
	/**
	 * Constructs an Operation object that uses the super class's
	 * ctor to assign the children of this node and to specify
	 * the operation type
	 * @param operType the type of operation
	 * @param n the list of children of this Operation node
	 */
	private Operation(int operType, ASTNode... n) {
		super(n);
		opType = operType;
	}
	
	/**
	 * A factory method that parses a String according to the BNF
	 * definition for <operation>.
	 * @param s the String to parse
	 * @return an Operation object that is the root of an abstract
	 * syntax (sub)tree resulting from the parse, or <tt>null</tt>
	 * if the String cannot be parsed as an <operation>.
	 */
	public static Operation parse(String s) {
		ASTNode result = Term.parse(s);
		if(result != null) {
			Operation opNode = new Operation(0, result);
			return opNode;
		}
		
		for(int i=s.length()-1; i>=0; i--) {
			//Try to parse the string into left and right operands of "+"
			if(s.charAt(i) == '+') {
				String leftAddOperand = s.substring(0, i).trim();
				String rightAddOperand = s.substring(i+1, s.length()).trim();
				
				ASTNode opResult = Operation.parse(leftAddOperand);
				ASTNode termResult = Term.parse(rightAddOperand);
				if((opResult != null) && (termResult != null))
				{
					Operation opNode = new Operation(1, opResult, termResult);
					return opNode;
				}
			}
			//Try to parse the string into left and right operands of "-"
			if(s.charAt(i) == '-') {
				String leftSubOperand = s.substring(0, i).trim();
				String rightSubOperand = s.substring(i+1, s.length()).trim();
				
				ASTNode opResult = Operation.parse(leftSubOperand);
				ASTNode termResult = Term.parse(rightSubOperand);
				if((opResult != null) && (termResult != null))
				{
					Operation opNode = new Operation(2, opResult, termResult);
					return opNode;
				}
			}
		}
		
		//String did not satisfy definition of Operation
		return null;
	}
	
	/**
	 * Evaluate the abstract syntax (sub)tree that is rooted at this
	 * ASTNode in the context of the given symbol table, and return the
	 * result.
	 * @param symtab A map from variable identifiers to values, to use as
	 * a symbol table in the evaluation.
	 * @return the <tt>double value that is the result of evaluating the
	 * syntax (sub)tree rooted at this ASTNode.
	 */
	@Override
	public double eval(Map<String, Double> symtab) {
		Double leftOp, rightOp;
		switch(opType) {
		case 1:
			leftOp = getChild(0).eval(symtab);
			rightOp = getChild(1).eval(symtab);
			return leftOp + rightOp;
		case 2:
			leftOp = getChild(0).eval(symtab);
			rightOp = getChild(1).eval(symtab);
			return leftOp - rightOp;
		default:
			//Assume default to be opType == 0
			return getChild(0).eval(symtab);
		}
	}

}
