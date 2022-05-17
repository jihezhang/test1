package com.ithiema;

import com.ithiema.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot16MongodbApplicationTests {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	void contextLoads() {
		Book book = new Book();
		book.setId(1);
		book.setDescription("SpringBoot");
		book.setType("SpringBoot");
		book.setName("SpringBoot");
		mongoTemplate.save(book);
	}

	@Test
	void test() {
		List<Book> all = mongoTemplate.findAll(Book.class);
		System.out.println(all);
	}

}
