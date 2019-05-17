package vehins.database.VehicleInspectionDB.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface InspectionRepository extends CrudRepository<Inspection, Long> {
	
	List<Inspection> findByName(String name);

}
