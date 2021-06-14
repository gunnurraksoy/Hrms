package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.LinkService;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Link;


@RestController
@RequestMapping("/api/links")
public class LinksController {
	
	private LinkService linkService;

	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Link link) {
		return linkService.add(link);
	}

    @GetMapping("/getall")
    public DataResult<List<Link>> getAll(){
        return linkService.getAll();
    }
    
    @GetMapping("/findAllByCandidate_Id/{id}")
    public DataResult<List<Link>> findAllByCandidate_Id(@PathVariable int  id){
        return linkService.findAllByCandidate_Id(id);
    }
    
    
	

}
