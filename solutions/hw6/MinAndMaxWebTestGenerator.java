package pset6;

import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MinAndMaxWebTestGenerator {
	public static void main(String[] a) {
		String suite = new MinAndMaxWebTestGenerator().createTestSuite();
		System.out.println(suite);
	}
	String createTestSuite() {
		StringBuilder sb = new StringBuilder();
		sb.append(packageDecl());
		sb.append("\n");
		sb.append(imports());
		sb.append("\n");
		sb.append(testsuite());
		return sb.toString();
	}
	String packageDecl() {
		return "package pset6;\n";
	}
	String imports() {
		return "import static org.junit.Assert.*;\n\n"
		+ "import org.junit.Test;\n\n"
		+ "import org.openqa.selenium.By;\n"
		+ "import org.openqa.selenium.WebDriver;\n"
		+ "import org.openqa.selenium.WebElement;\n"
		+ "import org.openqa.selenium.firefox.FirefoxDriver;\n"
		+ "import org.junit.AfterClass;\n"
		+ "import org.junit.BeforeClass;";
	}
	String testsuite() {
		StringBuilder sb = new StringBuilder();
		sb.append("public class MinAndMaxWebTestSuite {\n\n");
		sb.append("\tstatic WebDriver wd;\n\n"
				+ "\t@BeforeClass\n"
				+ "\tpublic static void before(){\n"
				+ "\t\tSystem.setProperty(\"webdriver.gecko.driver\", \"/Users/JocelynYu/Documents/workspace/software1/src/pset6/geckodriver\");\n"
				+ "\t\twd = new FirefoxDriver();\n"
				+ "\t}\n");
		String [] inputs = {"four","-1","0","1"};
		int id = 0;
		for (int x = 0;x<4;x++){
			for(int y = 0; y<4;y++){
				for(int z = 0; z<4;z++){
					sb.append(testcase(id,"min",inputs[x],inputs[y],inputs[z],true));
					id++;
					sb.append(testcase(id,"min",inputs[x],inputs[y],inputs[z],false));
					id++;
					sb.append(testcase(id,"max",inputs[x],inputs[y],inputs[z],true));
					id++;
					sb.append(testcase(id,"max",inputs[x],inputs[y],inputs[z],false));
					id++;
				}
			}
		}
		sb.append("\t@AfterClass\n");
		sb.append("\tpublic static void close() {\n");
		sb.append("\t\twd.quit();\n");
		sb.append("\t}\n");
		sb.append("}\n");
		return sb.toString();
	}
	
	String testcase(int id, String radio, String xval, String yval, String zval, boolean click){
		StringBuilder sb = new StringBuilder();
		sb.append("\t@Test public void t"+id+"() {\n");
		
		sb.append("\t\twd.get(\"file:///\"+System.getProperty(\"user.dir\")+\"/src/pset6/minandmax.html\");\n");
		sb.append("\t\tWebElement we = wd.findElement(By.id(\""+radio+"\"));\n");
		sb.append("\t\twe.click();\n");
		sb.append("\t\twe = wd.findElement(By.id(\"x\"));\n");
		sb.append("\t\twe.sendKeys(\""+xval+"\");\n");
		sb.append("\t\twe = wd.findElement(By.id(\"y\"));\n");
		sb.append("\t\twe.sendKeys(\""+yval+"\");\n");
		sb.append("\t\twe = wd.findElement(By.id(\"z\"));\n");
		sb.append("\t\twe.sendKeys(\""+zval+"\");\n");
		
		if (click){
			sb.append("\t\twe = wd.findElement(By.id(\"computeButton\"));\n");
			sb.append("\t\twe.click();\n");
			sb.append("\t\tWebElement result = wd.findElement(By.id(\"result\"));\n");
			sb.append("\t\tString output = result.getText();\n");
			if(xval.equals("four") || yval.equals("four")||zval.equals("four")){
				sb.append("\t\tassertEquals(\"Please enter integer values only!\", output);\n");
			}else{
				if (radio.equals("min")){
					int min;
					if (xval.equals("-1") || yval.equals("-1")||zval.equals("-1")) min = -1;
					else if(xval.equals("0") || yval.equals("0")||zval.equals("0"))min = 0;
					else min = 1;
					sb.append("\t\tassertEquals(\"min("+xval+", "+yval+", "+zval+") = "+min+"\", output);\n");
				}
				else{
					int max;
					if(xval.equals("1") || yval.equals("1")||zval.equals("1")) max = 1;
					else if(xval.equals("0") || yval.equals("0")||zval.equals("0"))max = 0;
					else max = -1;
					sb.append("\t\tassertEquals(\"max("+xval+", "+yval+", "+zval+") = "+max+"\", output);\n");
				}
				
			}
			
		}else{
			sb.append("\t\tWebElement result = wd.findElement(By.id(\"result\"));\n");
			sb.append("\t\tString output = result.getText();\n");
			sb.append("\t\tassertEquals(\"\", output);\n");
		}
//		sb.append("\twd.quit();\n");
		sb.append("\t}\n\n");
		return sb.toString();
	}
		 //implement any helper methods that you need in this class
	
}
