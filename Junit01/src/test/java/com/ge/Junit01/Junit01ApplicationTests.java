package com.ge.Junit01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalcTest{

	@Test
	public void test() {
		Calc c=new Calc();
		assertEquals(2,c.divide(10,5));
	}

}
