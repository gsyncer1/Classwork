import java.util.Map;

/**
 * A class representing the <identifier> nonterminal symbol in an abstract
 * syntax tree. This class has no public constructors; the public 
 * interface for creating an instance of the class is the static
 * <tt>parse(String s)</tt> factory method.
 * @author Glenn Briones cs12faq
 */
public class Identifier extends ASTNode {
	
	private String identifier;
	
	private Identifier (String id) {
		identifier = id;
	}

	/**
	 * A factory method that parses a String according ot the definition
	 * for <identifier>. The definition is:<br>
	 * Any string that starts with a JavaIdentifierStart character,
	 * followed by 0 or more JavaIdentifierPart characters.
	 * PRE-CONDITION: specified String must be trimmed
	 * @param s the String to parse
	 * @return an Identifier object that is the root of an abstract
	 * syntax subtree resulting from the parse, or <tt>null</tt> if
	 * the String cannot be parsed as a <identifier>
	 */
	public static Identifier parse(String s) {
		if(s.length() == 0) return null;
		String string = s.trim();
		//Check that String is is a valid java identifier
		char[] charArray = string.toCharArray();
		if(!Character.isJavaIdentifierStart(charArray[0])) return null;
		for(int i=1; i<charArray.length; i++)
			if(!Character.isJavaIdentifierPart(charArray[i])) return null;
		
		//String s is a valid identifier, create Identifier
		Identifier result = new Identifier(string);
		
		return result;
	}
	
	/**
	 * TODO: MAKE THIS MORE SPECIFIC
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
		Double result = symtab.get(identifier);
		if(result == null) 
			throw new RuntimeException("UNINITIALIZED VARIABLE: " + identifier);
		return result.doubleValue();
	}
	
	/**
	 * Return the String representation of this identifier.
	 * @return the String representation of this identifier
	 */
	public String toString() {
		return identifier;
	}

}
