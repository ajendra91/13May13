package com.kodinor;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import com.kodinor.entity.product.Product;
import com.kodinor.entity.user.User;
import com.kodinor.repository.product.ProductRepository;
import com.kodinor.repository.user.UserRepository;

@SpringBootApplication
public class SpringDataManyDbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataManyDbsApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct
	void init () {
		
		User chickCorea = new User("Chick", "Corea");
		userRepository.save(chickCorea);
		
		Product cleanCode = new Product("Mad Hatter", 19);
		productRepository.save(cleanCode);
		
		
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}
	
}
