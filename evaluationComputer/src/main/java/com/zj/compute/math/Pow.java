
package com.zj.compute.math;

import java.util.ArrayList;

import com.zj.compute.EvaluationConstants;
import com.zj.compute.Evaluator;
import com.zj.compute.function.Function;
import com.zj.compute.function.FunctionConstants;
import com.zj.compute.function.FunctionException;
import com.zj.compute.function.FunctionHelper;
import com.zj.compute.function.FunctionResult;

/**
 * This class is a function that executes within Evaluator. The function returns
 * the value of the first argument raised to the second power of the second
 * argument. See the Math.pow(double, double) method in the JDK for a complete
 * description of how this function works.
 */
public class Pow implements Function {
	/**
	 * Returns the name of the function - "pow".
	 * 
	 * @return The name of this function class.
	 */
	public String getName() {
		return "pow";
	}

	/**
	 * Executes the function for the specified argument. This method is called
	 * internally by Evaluator.
	 * 
	 * @param evaluator
	 *            An instance of Evaluator.
	 * @param arguments
	 *            A string argument that will be converted into two double
	 *            values and evaluated.
	 * 
	 * @return The value of the first argument raised to the second power of the
	 *         second argument.
	 * 
	 * @exception FunctionException
	 *                Thrown if the argument(s) are not valid for this function.
	 */
	public FunctionResult execute(final Evaluator evaluator, final String arguments)
			throws FunctionException {
		Double result = null;

		ArrayList numbers = FunctionHelper.getDoubles(arguments,
				EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);

		if (numbers.size() != 2) {
			throw new FunctionException("Two numeric arguments are required.");
		}

		try {
			double argumentOne = ((Double) numbers.get(0)).doubleValue();
			double argumentTwo = ((Double) numbers.get(1)).doubleValue();
			result = new Double(Math.pow(argumentOne, argumentTwo));
		} catch (Exception e) {
			throw new FunctionException("Two numeric arguments are required.", e);
		}

		return new FunctionResult(result.toString(), 
				FunctionConstants.FUNCTION_RESULT_TYPE_NUMERIC);
	}
}