package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	
	Result add(JobExperience jobExperience);
	DataResult<List<JobExperience>> getAll();
	DataResult<List<JobExperience>> findAllByCandidate_Id(int  candidateId);
	
	DataResult<List<JobExperience>> getAllByCandidate_IdOrderByLeavingDateDesc(int candidateId);

}
