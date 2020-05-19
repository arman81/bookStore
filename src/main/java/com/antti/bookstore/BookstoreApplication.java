package com.antti.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.antti.bookstore.domain.Book;
import com.antti.bookstore.domain.BookRepository;
import com.antti.bookstore.domain.User;
import com.antti.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory
			.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, UserRepository urepository) {
		return (args) -> {
			log.info("Commandline works?");
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			
			
			Book bk = new Book("Cormen", "Algorithm and Data Structures Design",
					"978-0-316-12908-4", 2011);
			Book bk2 = new Book("Donal Knuth", "The Art of Programming",
					"978-1-841-49990-1", 2004);


			repository.save(bk);
			repository.save(bk2);

			log.info("Books found with findAll():");
			log.info("-------------------------------");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("-------------------------------");
			
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (User user : urepository.findAll()) {
				log.info(user.toString());
			}
			log.info("-------------------------------");
			
			
			
		};

	}
}