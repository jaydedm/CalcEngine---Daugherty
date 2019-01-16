package com.company.myapp;


import com.company.calcengine.Adder;
import com.company.calcengine.CalculateBase;
import com.company.calcengine.CalculateHelper;
import com.company.calcengine.Divider;
import com.company.calcengine.InvalidStatementException;
import com.company.calcengine.MathEquation;
import com.company.calcengine.Multiplyer;
import com.company.calcengine.Subtracter;

public class Main {


	public static void main(String[] args){

		String[] statements = {
				"add 1.0",  //error
				"add xx 25.0", //error
				"addX 0.0 0.0", //error
				"Divide 100.0 50.0",  //100.0 /50.0 =2.0
				"Add 25.0 92.0",	  //
				"Subtract 225.0 17.0",
				"multiply 11. 3.0"
		};

		CalculateHelper helper = new CalculateHelper();
		for(String statement:statements) {
			try {
				helper.process(statement);
				System.out.println(helper);
			} catch(InvalidStatementException e) {
				System.out.println(e.getMessage());
				if(e.getCause() != null)
					System.out.println("  Original exception: " + e.getCause().getMessage());

			}
		}
	}


    static void useMathEquation() {

		MathEquation[] equations = new MathEquation[4];
		equations[0] = new MathEquation('d', 100.0, 50.0);
		equations[1] = new MathEquation('a', 25.0, 92.0);
		equations[2] = new MathEquation('s', 225.0, 17.0);
		equations[3] = new MathEquation('m', 11.0, 3.0);


		for (MathEquation equation : equations) {
			equation.execute();
			System.out.print("result = ");
			System.out.println(equation.getResult());
		}

		System.out.println();
		System.out.println("Using Overloads");
		System.out.println();

		double leftDouble = 9.0d;
		double rightDouble = 4.0d;

		int leftInt = 9;
		int rightInt = 4;

		MathEquation equationOverLoad = new MathEquation('d');

		equationOverLoad.execute(leftDouble, rightDouble);
		System.out.print("results=");
		System.out.println(equationOverLoad.getResult());

		equationOverLoad.execute(leftInt, rightInt);
		System.out.print("results=");
		System.out.println(equationOverLoad.getResult());

		equationOverLoad.execute((double) leftInt, rightInt);
		System.out.print("results=");
		System.out.println(equationOverLoad.getResult());

	}

	static void useCalulatorBase() {

			System.out.println();
			System.out.println("Using Inheritance");
			System.out.println();

		CalculateBase[] calculators = {
				new Divider(100.0,50.0),
				new Adder(25.0,92.0),
				new Subtracter(225.0,17.0),
				new Multiplyer(11.0,3.0)
		};

		for(CalculateBase calculator:calculators) {
			calculator.calculate();
			System.out.print("results=");
			System.out.println(calculator.getResult());
		}
		}

    }


