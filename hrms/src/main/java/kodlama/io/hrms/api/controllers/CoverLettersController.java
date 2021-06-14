package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CoverLetterService;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CoverLetter;


@RestController
@RequestMapping("/api/coverLettersController")
public class CoverLettersController {
	
	private CoverLetterService coverLetterService;

	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return coverLetterService.add(coverLetter);
	}

    @GetMapping("/getall")
    public DataResult<List<CoverLetter>> getAll(){
        return coverLetterService.getAll();
    }
    
    @GetMapping("/findAllByCandidate_Id/{id}")
    public DataResult<List<CoverLetter>> findAllByCandidate_Id(@PathVariable int  id){
        return coverLetterService.findAllByCandidate_Id(id);
    }
    
    
	

}
