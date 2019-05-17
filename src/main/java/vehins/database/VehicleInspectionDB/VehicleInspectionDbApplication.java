package vehins.database.VehicleInspectionDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import vehins.database.VehicleInspectionDB.domain.CustomersRepository;
import vehins.database.VehicleInspectionDB.domain.Inspection;
import vehins.database.VehicleInspectionDB.domain.InspectionRepository;
import vehins.database.VehicleInspectionDB.domain.User;
import vehins.database.VehicleInspectionDB.domain.UserRepository;

@SpringBootApplication
public class VehicleInspectionDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleInspectionDbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner VehicleInspectionTest(CustomersRepository repository, InspectionRepository irepository, UserRepository urepository) {
		return (args) -> {
			irepository.save(new Inspection("Passed"));
			irepository.save(new Inspection("Rejected"));
			irepository.save(new Inspection("Scheduled"));
			irepository.save(new Inspection("Make a Query"));

			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "");
			urepository.save(user1);
			urepository.save(user2);
					
		};
	}

}
