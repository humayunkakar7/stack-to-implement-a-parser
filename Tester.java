package a2posted;

/**
 * This class contains a main method that you can use to test your implementation
 * of StringStack and LanguageParser.
 * 
 * The tests provided below are given to you as examples. For full marks, your parser
 * will have to be entirely correct. Passing only the tests below does not mean that
 * your parser is truly correct.
 * 
 * As such, you are strongly encouraged to write more tests and to share your test
 * code with other students.
 * 
 * DO NOT SUBMIT THIS FILE.  Use it for your own testing only.   
 */

public class Tester {
	
	public static void main (String[] args) {
		
		StringSplitter splitter;
		
		// Here is an example of how StringSplitter works.
		
		splitter = new StringSplitter("if true then foo=3 else foo=25 end");
		System.out.println("The splitter has " + splitter.countTokens() + " tokens.");
		System.out.println("Let's enumerate the tokens:");
		
		while (splitter.hasMoreTokens()) {
			String token = splitter.nextToken();
			System.out.println(token);
		}
		
		System.out.println("\nNow the splitter has no more tokens.");
		System.out.println("Calling nextToken() will return an empty string: " + splitter.nextToken());

		System.out.println("\nNow let's test the parser.");
		System.out.println("#, correct answer, your answer\n");
		
		// In the prints below, the expected result is printed first, followed by the
		// parser's result.
		
		splitter = new StringSplitter("foo=23");
		System.out.println("1 true, " + LanguageParser.isStatement(splitter));
		
		splitter = new StringSplitter("foo = 23");
		System.out.println("2 false, " + LanguageParser.isStatement(splitter));
		
		splitter = new StringSplitter("true");
		System.out.println("3 false, " + LanguageParser.isStatement(splitter));
		
		splitter = new StringSplitter("if true then a=2 else false end");
		System.out.println("4 false, " + LanguageParser.isStatement(splitter));

		splitter = new StringSplitter("if true a=2 else false end");
		System.out.println("5 false, " + LanguageParser.isStatement(splitter));
		
		splitter = new StringSplitter("if true then a=2 else a=3 end");
		System.out.println("6 true, " + LanguageParser.isStatement(splitter));
		
		splitter = new StringSplitter("if true then if true then a=2 else if true then a=2 else b=3 end end else if true then if true then a=2 else b=3 end else if true then if true then a=2 else b=3 end else b=3 end end end");
		System.out.println("7 true, " + LanguageParser.isStatement(splitter));
		
		splitter = new StringSplitter("if true then else end");
		System.out.println("8 false, " + LanguageParser.isStatement(splitter));
		
		splitter = new StringSplitter("if true then a=2 else if true then a=3 else a=4 end a=5 end");
		System.out.println("9 false, " + LanguageParser.isStatement(splitter));

		splitter = new StringSplitter("a=3 b=4");
		System.out.println("10 false, " + LanguageParser.isStatement(splitter));

		splitter = new StringSplitter("b=0 if true then c=0 end");
		System.out.println("11 false, " + LanguageParser.isStatement(splitter));

		splitter = new StringSplitter("if true then b=0 end end");
		System.out.println("12 false, " + LanguageParser.isStatement(splitter));

		splitter = new StringSplitter("if true then if false then b=99 else if true then c=0 end end end");
		System.out.println("13 false, " + LanguageParser.isStatement(splitter));

		splitter = new StringSplitter("if false then if true then c=5 else d=5 end else b=31 end");
		System.out.println("14 true, " + LanguageParser.isStatement(splitter));

		splitter = new StringSplitter("if a=2 then a=2 else b=31 end");
		System.out.println("15 false, " + LanguageParser.isStatement(splitter));

		splitter = new StringSplitter("if true then a=3 else b=3 end if true then c=4 else c=5 end");
		System.out.println("16 false, " + LanguageParser.isStatement(splitter));



	}
	
}
