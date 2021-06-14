package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.dtos.CvDto;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	
	Result add(Candidate candidate, String passwordAgain);

	DataResult<CvDto> getCvById(int id);
	
	DataResult<Candidate> findById(int id);
}
