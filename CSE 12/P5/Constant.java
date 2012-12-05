import java.util.Map;

/**
 * A class representing the <constant> nonterminal symbol in an abstract
 * syntax tree. Thsi class has no public constructors; the public 
 * interface for creating an instance of the class is the static 
 * <tt>parse(String s)</tt> factory method
 * @author Glenn Briones cs12faq
 *
 */
public class Constant extends ASTNode {

	private double constant;
	
	/**
	 * Constructs a Constant object and assigns the constant to the
	 * specified value
	 * @param num the value to assign to constant
	 */
	private Constant(double num) {
		constant = num;
	}
	
	/**
	 * A factory method that parses a String according to the definition
	 * for <constant>. The definition is: Any String that can be parsed
	 * by java.lang.Double.parseDouble(s) without throwing a 
	 * NumberFormatException.
	 * @param s the STring to parse
	 * @return a Constant object that is the root of an abstract syntax
	 * subtree resulting from the parse, or <tt>null</tt> if the String
	 * cannot be parsed as a <constant>
	 */
	public static Constant parse(String s) {
		try {
			//create a new Constant object to be root of subtree
			Constant constNode = new Constant(Double.parseDouble(s));
			//return the new constant object
			return constNode;
		} catch (NumberFormatException e) {
			//String cannot be parsed as a <constant>
			return null;
		}
	}
	
	/**
	 * Evaluate the abstract syntax (sub)tree that is rooted at this
	 * ASTNode in the context of the given symbol table, and return the
	 * result.
	 * @param symtab A map from variable identifiers to values, to use
	 * as a symbol table in the evaluation
	 * @return the <tt>double</tt> value that is the result of evaluating
	 * the abstract syntax (sub)tree rooted at this ASTNode
	 */
	@Override
	public double eval(Map<String, Double> symtab) {
		return constant;
	}
	

}
