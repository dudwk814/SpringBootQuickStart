package com.rubypaper.Chapter03;

import com.rubypaper.Chapter03.controller.BoardController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(
				properties = {"author.name=Gurum",
						"author.age=45",
						"author.nation=Korea"})
class Chapter03ApplicationTests {

	@Autowired
	private Environment environment;

	@Test
	void contextLoads() {

		System.out.println("이름 : " + environment.getProperty("author.name"));
		System.out.println("나이 : " + environment.getProperty("author.age"));
		System.out.println("국가 : " + environment.getProperty("author.nation"));
	}

}
