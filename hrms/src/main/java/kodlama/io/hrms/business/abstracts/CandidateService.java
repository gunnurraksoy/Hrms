package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	public DataResult<List<Candidate>> getAll();
	public Result add(Candidate candidate);

}
