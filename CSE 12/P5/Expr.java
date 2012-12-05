import java.util.Map;


/**
 * A class representing the <expr> nonterminal symbol in an abstract
 * syntax tree. This class has no publci constructors; the public
 * interface for creating an instance of the class is the static
 * <tt>parse(String s)</tt> factory method.
 * @author Glenn Briones cs12faq
 *
 */
public class Expr extends ASTNode {
	
	private Expr() { super(); }
	private Expr(ASTNode n) { super(n); }

	/**
	 * A factory method that parses a String according to the BNF definition
	 * for <expr>.
	 * @param s the String to parse
	 * @return an Expr object that is the root of an abstract syntax
	 * (sub)tree resulting from the parse, or <tt>null</tt> if the String
	 * cannot be parsed as an <expr>.
	 */
	public static Expr parse(String s)
	{
		if(Assignment.parse(s) != null) {
			//the string satisfies the def'n of <Assignment>
			//Make a new Expr node with the result of Assignment.parse(s)
			Expr result = new Expr();
			result.addChild(Assignment.parse(s));
			return result;
		} else if (Operation.parse(s) != null) {
			//the string satisfies the def'n of <Operation>;
			//make a new Expr node, with the result of Operation.parse(s)
			Expr result = new Expr();
			//as its child, and return it
			result.addChild(Operation.parse(s));
			return result;
		} else //the string does not satisfy the def'n of <Expression>
			return null;
	}
	
	
	/**
	 * Evaluate the abstract syntax (sub)tree that is rooted at this
	 * ASTNode in the context of the given symbol table, and return
	 * the result.
	 * @param symtab A map from variable identifiers to values, to use as a
	 * symbol table in the evaluation
	 * @return the <tt>double</tt> value that is the result of evaluating
	 * the abstract syntax <sub>tree rooted at this ASTNode
	 */
	@Override
	public double eval(Map<String, Double> symtab) {
		return getChild(0).eval(symtab);
	}

}
