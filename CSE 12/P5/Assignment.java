import java.util.Map;

/**
 * A class representing the <assignment> nonterminal symbol in the
 * abstract syntax tree. This class has no public constructors; the
 * public interface for creating an instance of the class is the static
 * <tt>parse(String s)</tt> factory method.
 * @author Glenn Briones cs12faq
 */
public class Assignment extends ASTNode {
	
	private Assignment(ASTNode... n) { super(n); }

	/**
	 * A factory method that parses a String according to the BNF
	 * definition of <assignment>.
	 * @param s the String to parse
	 * @return an Assignment object that is the root of an abstract
	 * syntax (sub)tree resulting from the parse, or <tt>null</tt>
	 * if the String cannot be parsed as a <assignment>.
	 */
	public static Assignment parse(String s) {
		//parse the string
		String leftHandSide, rightHandSide;
		String[] parseArray = s.split("=", 2);
		//check if the string was not split. return null if so.
		if(!parseArray[0].equals(s))
		{
			for(int i=0; i<parseArray.length; i++)
				parseArray[i] = parseArray[i].trim();
			leftHandSide = parseArray[0];
			rightHandSide = parseArray[1];
			ASTNode identNode = Identifier.parse(leftHandSide);
			ASTNode exprNode = Expr.parse(rightHandSide);
			if((identNode != null) && (exprNode != null))
			{
				Assignment result = new Assignment(identNode, exprNode);
				return result;
			}
		}
		//Either left hand side is not Identifier or right hand side is
		//not expression.
		return null;
	}
	

	/**
	 * Evaluate the abstract syntax (sub)tree that is rooted at this
	 * ASTNode in the context of the given symbol table, and return the
	 * result.
	 * @param symtab A map from variable identifiers to values, to use as
	 * a symbol table in the evaluation
	 * @return the <tt>double</tt> value that is the result of evaluating
	 * the abstract syntax (sub)tree rooted at this ASTNode
	 */
	@Override
	public double eval(Map<String, Double> symtab) {
		symtab.put(this.getChild(0).toString(),getChild(1).eval(symtab));
		return symtab.get(getChild(0).toString());
	}
}
