package br.com.pifalafatec;

import br.com.pifalafatec.entity.Role;
import br.com.pifalafatec.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PifalafatecApplication implements CommandLineRunner {
	@Autowired RoleRepository rr;
	public static void main(String[] args) {
		SpringApplication.run(PifalafatecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Role first = new Role();
		first.setId(1);
		first.setName("ROLE_ADMIN");
		rr.save(first);


	}
}
