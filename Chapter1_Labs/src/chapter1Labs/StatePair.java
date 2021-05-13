package chapter1Labs;

public class StatePair <Type1 extends Comparable<Type1>, Type2 extends Comparable<Type2>> {
	   private Type1 value1;
	   private Type2 value2;
	   
	//constructor
	public StatePair(Type1 value1, Type2 value2) {
		super();
		setValue1(value1);
		setValue2(value2);
	}

	//getters and setters
	public Type1 getValue1() {
		return value1;
	}

	public void setValue1(Type1 value1) {
		this.value1 = value1;
	}

	public Type2 getValue2() {
		return value2;
	}

	public void setValue2(Type2 value2) {
		this.value2 = value2;
	}
	
	//printInfo
	public void printInfo() {
		System.out.println(value1 + ": " + value2);
	}

	//toString
	@Override
	public String toString() {
		return value1 + ": " + value2;
	}

	}