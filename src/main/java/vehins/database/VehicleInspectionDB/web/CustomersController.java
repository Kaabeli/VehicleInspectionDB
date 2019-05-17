package vehins.database.VehicleInspectionDB.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vehins.database.VehicleInspectionDB.domain.CustomersRepository;
import vehins.database.VehicleInspectionDB.domain.InspectionRepository;
import vehins.database.VehicleInspectionDB.domain.Customers;

@Controller
public class CustomersController {
	
	@Autowired
	private CustomersRepository repository;
	
	@Autowired
	private InspectionRepository irepository;
	
	@RequestMapping(value = {"/login", "/"})
	public String login() {
		return "login";
	}
	
	//GET
	@RequestMapping(value ="/customerslist", method = RequestMethod.GET)
	public String CustomersList(Model model) {
		model.addAttribute("customers", repository.findAll());
		return "customerslist";
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public @ResponseBody List<Customers> customerlistRest() {
		return (List<Customers>) repository.findAll();
	}
	
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Customers> findCustomersRest(@PathVariable("id") Long CustomerId) {
		return repository.findById(CustomerId);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/addcustomer")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customers());
		model.addAttribute("inspections", irepository.findAll());
		return "addcustomer";
	}
	
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String save(Customers customer) {
		repository.save(customer);
		return "redirect:customerslist";
	}
	
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable("id") Long CustomerId, Model model) {
		repository.deleteById(CustomerId);
		return "redirect:../customerslist";
	}
	
	@RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
	public String editCustomer(@PathVariable("id") Long CustomerId, Model model) {
		model.addAttribute("customer", repository.findById(CustomerId));
		model.addAttribute("inspections", irepository.findAll());
		return "editcustomer";
	}

}
