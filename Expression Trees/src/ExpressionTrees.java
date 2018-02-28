import java.util.Stack;

/**
 * <p></p> 
 * Feb 26, 2018
 * @author Patrick Riley
 */

/**
 * @author rileyp
 *
 */
public class ExpressionTrees extends TreeNode implements Expressions {

	public ExpressionTrees(Object initValue, TreeNode initLeft, TreeNode initRight) {
		super(initValue, initLeft, initRight);
	}

	@Override
	public TreeNode buildTree(String[] exp) {
		Stack<ExpressionTrees> s = new Stack<ExpressionTrees>();

		for (String o : exp) {
			try {
				Integer.parseInt(o);
				s.push(new ExpressionTrees(o, null, null));
			} catch (NumberFormatException e) {
				ExpressionTrees r = new ExpressionTrees(o, s.pop(), s.pop());
				s.push(r);
			}
		}
		return s.pop();
	}

	@Override
	public int evalTree() {
		return recurEval(this);
	}

	private int recurEval(TreeNode r) {
		if (r == null)
			return 0;
		else {
			if (r.getLeft() == null && r.getRight() == null)
				return Integer.parseInt((String) r.getValue());
			else {
				int left = recurEval(r.getLeft());
				int right = recurEval(r.getRight());
				if (r.getValue().equals("*"))
					return left * right;
				else
					return left + right;
			}
		}

	}

	@Override
	public String toPrefixNotation() {
		if (this != null) {
			String ret = (String) getValue();
			String left = ((ExpressionTrees) this.getLeft()).toPrefixNotation();
			String right = ((ExpressionTrees) this.getRight()).toPrefixNotation();
			return ret + left + right;
		} else
			return "";

	}

	@Override
	public String toInfixNotation() {
		if (this != null) {
			String ret = "(";
			ret += (String) ((ExpressionTrees) this.getLeft()).toInfixNotation();
			ret += (String) this.getValue();
			ret += (String) ((ExpressionTrees) this.getRight()).toInfixNotation();
			return ret + ")";
		}
		else
			return "";

	}

	@Override
	public String toPostfixNotation() {
		if (this != null) {
			String left = ((ExpressionTrees) this.getLeft()).toPostfixNotation();
			String right = ((ExpressionTrees) this.getRight()).toPostfixNotation();
			return left + right + (String) this.getValue();
		} else
			return "";
	}

	@Override
	public int postfixEval(String[] exp) {
		// TODO Auto-generated method stub
		return 0;
	}
}
