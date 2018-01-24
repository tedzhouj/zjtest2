package com.zj.compute.newfunc;

import java.util.ArrayList;

import com.zj.compute.EvaluationConstants;
import com.zj.compute.Evaluator;
import com.zj.compute.function.Function;
import com.zj.compute.function.FunctionConstants;
import com.zj.compute.function.FunctionException;
import com.zj.compute.function.FunctionHelper;
import com.zj.compute.function.FunctionResult;

public class IF implements Function {


	public String getName() {
		return "if";
	}


	public FunctionResult execute(Evaluator evaluator, String arguments)
			throws FunctionException {
		String exceptionMessage = "Three string arguments are required.";
		ArrayList strings = FunctionHelper.getStrings(arguments, 
				EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
		
		if (strings.size() != 3) {
			throw new FunctionException(exceptionMessage);
		}
		
		String argumentOne=strings.get(0).toString();
		
		if(argumentOne.equals(EvaluationConstants.BOOLEAN_STRING_TRUE)){
			return new FunctionResult(strings.get(1).toString(), 
					FunctionConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}else{
			return new FunctionResult(strings.get(2).toString(), 
					FunctionConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	
}
