/**
 * This is the Provided Interface for the Expression Trees Assignment
 * @author Terri Kelly; Edited by Patrick Riley
 *
 */
public interface Expressions {

/**
 * 
 * @param exp array of expressions in postfix notation
 * @return the root TreeNode of the Expression Tree
 */
TreeNode buildTree(String[] exp);

/**
 * This evaluates the numerical value of the tree
 * @return the numerical value of the tree
 */
int evalTree();

/**
 * Converts the Expression Tree to Prefix Notation
 * @return the tree in Prefix Notation
 */
String toPrefixNotation();

/**
 * Converts the Expression Tree to Infix Notation
 * @return the tree in Infix Notation
 */
String toInfixNotation();

/**
 * Converts the Expression Tree to Postfix Notation
 * @return the tree in Infix Notation
 */
String toPostfixNotation();

/**
 * Evaluates a postfix expression
 * @param exp the postfix expression as an array
 * @return the numerical value of the postfix expression
 */
int postfixEval(String[] exp);
}