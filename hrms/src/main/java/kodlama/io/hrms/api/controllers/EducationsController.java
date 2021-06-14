package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {
	
	private EducationService educationService;

	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		return educationService.add(education);
	}

    @GetMapping("/getall")
    public DataResult<List<Education>> getAll(){
        return educationService.getAll();
    }
    
    @GetMapping("/findAllByCandidate_Id/{id}")
    public DataResult<List<Education>> findAllByCandidate_Id(@PathVariable int  id){
        return educationService.findAllByCandidate_Id(id);
    }
    
    @GetMapping("getAllByCandidate_IdOrderByLeavingDateDesc/{id}")
    public DataResult<List<Education>> getAllByCandidate_IdOrderByLeavingDateDesc(@PathVariable int  id){
    	return educationService.getAllByCandidate_IdOrderByLeavingDateDesc(id);
    }
    
    
	

}
