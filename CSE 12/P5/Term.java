import java.util.Map;

/**
 * A class representing the <term> nontemrinal symbol in an abstract
 * syntax tree. This class has no public constructors; the public
 * interface for creating an instance of the class is the static
 * </tt>parse(String s)</tt> factory method.
 * @author Glenn Briones cs12faq
 *
 */
public class Term extends ASTNode {
	
	/**
	 * Determines the operation type of the Term.
	 * opType = 1 if <term> satisfies definition <term> * <factor>
	 * opType = 2 if <term> satisfies definition <term> / <factor>
	 */
	private int opType;
	
	private Term(int oper, ASTNode factor) {
		super(factor);
		opType = oper;
	}
	
	private Term(int oper, ASTNode term, ASTNode factor) { 
		super(term, factor);
		opType = oper;
	}

	/**
	 * A factory method that parses a String according to the BNF
	 * definition for <term>.
	 * @param s
	 * @return a Term object that is the root of an abstract syntax
	 * (sub)tree resulting from the parse, or <tt>null</tt> cannot
	 * be parsed as a <term>
	 */
	public static Term parse(String s) {
		String string = s.trim();
		ASTNode node = Factor.parse(string);
		if(node != null) {
			Term result = new Term(0, node);
			return result;
		}
		
		for(int i=s.length()-1; i>=0; i--) {
			//try to parse the string into left and right factors of "*"
			if(s.charAt(i) == '*') {
				String leftMultFactor = s.substring(0, i).trim();
				String rightMultFactor = s.substring(i+1, s.length()).trim();
				
				ASTNode termResult = Term.parse(leftMultFactor);
				ASTNode factorResult = Factor.parse(rightMultFactor);
				if((termResult != null) && (factorResult != null))
				{
					Term termNode = new Term(1, termResult, factorResult);
					return termNode;
				}
			}
			//Try to parse the string into left and right factors of "/"
			if(s.charAt(i) == '/') {
				String dividend = s.substring(0, i).trim();
				String divisor = s.substring(i+1, s.length()).trim();
				
				ASTNode termResult = Term.parse(dividend);
				ASTNode factorResult = Factor.parse(divisor);
				if((termResult != null) && (factorResult != null))
				{
					Term termNode = new Term(2, termResult, factorResult);
					return termNode;
				}
			}
		}
		
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
		switch(opType) {
		case 1:
			Double leftFactor = getChild(0).eval(symtab);
			Double rightFactor = getChild(1).eval(symtab);
			return leftFactor * rightFactor;
		case 2:
			Double dividend = getChild(0).eval(symtab);
			Double divisor = getChild(1).eval(symtab);
			return dividend / divisor;
		default:
			return getChild(0).eval(symtab);
		}
	}

}
