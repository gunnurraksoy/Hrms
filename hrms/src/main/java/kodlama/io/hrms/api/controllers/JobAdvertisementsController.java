package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("api/jobAdvertisement")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	
	@PostMapping("/add")
	public Result addJobAdvertisment(@RequestBody JobAdvertisement jobAdvertisement) {
		 return this.jobAdvertisementService.addJobAdvertisment(jobAdvertisement);
		 
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	
	
	
	@GetMapping("/getByIsActiveTrueOrderByDeadlineDate")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByDeadlineDate(){
		return this.jobAdvertisementService.getByIsActiveTrueOrderByDeadlineDate();
	}
	
	
	
	@GetMapping("/getByIsActiveTrueAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName){
		return this.jobAdvertisementService.getByIsActiveTrueAndEmployer_CompanyName(companyName);
	}
	
	
	
	@GetMapping("/getByEmployer_CompanyName")
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName) {
		return this.jobAdvertisementService.getByEmployer_CompanyName(companyName);
	}
	
	
	@PostMapping("/setIsActivate")
	public Result setIsActivate(int id , Boolean isActivate) {
		return this.jobAdvertisementService.setIsActivate(id, isActivate);
	}
	

}
