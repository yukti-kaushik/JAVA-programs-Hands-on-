package Abs_Inter;

public class String_Example {
	public static void main(String[] args) {
		String institute="Anudip Foundation";
		
		boolean a=institute.startsWith("an");
		boolean b=institute.startsWith("on");
		boolean c=institute.endsWith("on");
		boolean d=institute.endsWith("On");

	    System.out.println(" "+a);
	    System.out.println(" "+b);
	    System.out.println(" "+c);
	    System.out.println(" "+d);
	}
}
