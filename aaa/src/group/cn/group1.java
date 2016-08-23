package group.cn;

import org.testng.annotations.Test;

public class group1 {
	
	@Test(groups="t1")
	public void test1(){
		System.out.println("test1");
	}
	
	@Test(groups="t2")
	public void test2(){
		System.out.println("test2");
	}
	
	@Test(groups="t3")
	public void test3(){
		System.out.println("test3");
	}
}