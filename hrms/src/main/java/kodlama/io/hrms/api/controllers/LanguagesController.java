package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Language;


@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		return languageService.add(language);
	}

    @GetMapping("/getall")
    public DataResult<List<Language>> getAll(){
        return languageService.getAll();
    }
    
    @GetMapping("/findAllByCandidate_Id/{id}")
    public DataResult<List<Language>> findAllByCandidate_Id(@PathVariable int  id){
        return languageService.findAllByCandidate_Id(id);
    }
    
    
	

}
