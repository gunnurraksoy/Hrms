package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

import kodlama.io.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;

	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return jobExperienceService.add(jobExperience);
	}

    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll(){
        return jobExperienceService.getAll();
    }
    
    @GetMapping("/findAllByCandidate_Id/{id}")
    public DataResult<List<JobExperience>> findAllByCandidate_Id(@PathVariable int  id){
        return jobExperienceService.findAllByCandidate_Id(id);
    }
    
    @GetMapping("getAllByCandidate_IdOrderByLeavingDateDesc/{id}")
    public DataResult<List<JobExperience>> getAllByCandidate_IdOrderByLeavingDateDesc(@PathVariable int  id){
    	return jobExperienceService.getAllByCandidate_IdOrderByLeavingDateDesc(id);
    }
    

}
