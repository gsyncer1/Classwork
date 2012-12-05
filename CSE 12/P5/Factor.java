import java.util.Map;

/**
 * A class representing the <factor> nonterminal symbol in an abstract
 * syntax tree. This class has no public constructors; the public
 * interface for creating an instance of the class is the static
 * <tt>parse(String s)</tt> factory method.
 * @author Glenn Briones cs12faq
 */
public class Factor extends ASTNode {
	
	private Factor(ASTNode... n) { super(n); }

	/**
	 * A factory method that parses a String according to the BNF
	 * definition for <factor>.
	 * @param s the String to parse
	 * @return a Factor object that is the root of an abstract syntax
	 * (sub)tree resulting from parse, or <tt>null</tt> if the String
	 * cannot be parsed as a <factor>.
	 */
	public static Factor parse(String s) {
		if(s.length() == 0) return null;
		ASTNode constNode = Constant.parse(s);
		if(constNode != null) {
			Factor result = new Factor(constNode);
			return result;
		}
		
		ASTNode identNode = Identifier.parse(s);
		if(identNode != null) {
			Factor result = new Factor(identNode);
			return result;
		}
		
		if((s.charAt(0) == '(') && (s.charAt(s.length()-1) == ')')) {
			String expression = s.substring(1, s.length()-1);
			expression = expression.trim();
			ASTNode exprNode = Expr.parse(expression);
			if(exprNode != null) {
				Factor result = new Factor(exprNode);
				return result;
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
		return getChild(0).eval(symtab);
	}

}
