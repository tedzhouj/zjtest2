
package com.zj.compute.operator;

import com.zj.compute.EvaluationConstants;

/**
 * The less than operator.
 */
public class LessThanOperator extends AbstractOperator {

	/**
	 * Default constructor.
	 */
	public LessThanOperator() {
		super("<", 4);
	}

	/**
	 * Evaluates two double operands.
	 * 
	 * @param leftOperand
	 *            The left operand being evaluated.
	 * @param rightOperand
	 *            The right operand being evaluated.
	 */
	public double evaluate(final double leftOperand, final double rightOperand) {
		if (leftOperand < rightOperand) {
			return 1;
		}

		return 0;
	}

	/**
	 * Evaluates two string operands.
	 * 
	 * @param leftOperand
	 *            The left operand being evaluated.
	 * @param rightOperand
	 *            The right operand being evaluated.
	 */
	public String evaluate(final String leftOperand, final String rightOperand) {
		if (leftOperand.compareTo(rightOperand) < 0) {
			return EvaluationConstants.BOOLEAN_STRING_TRUE;
		}

		return EvaluationConstants.BOOLEAN_STRING_FALSE;
	}
}