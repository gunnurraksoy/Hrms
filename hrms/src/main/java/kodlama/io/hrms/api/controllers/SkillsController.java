package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlama.io.hrms.business.abstracts.SkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

import kodlama.io.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {
	
	private SkillService skillService;

	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Skill skill) {
		return skillService.add(skill);
	}

    @GetMapping("/getall")
    public DataResult<List<Skill>> getAll(){
        return skillService.getAll();
    }
    
    @GetMapping("/findAllByCandidate_Id/{id}")
    public DataResult<List<Skill>> findAllByCandidate_Id(@PathVariable int  id){
        return skillService.findAllByCandidate_Id(id);
    }
    
    
	

}