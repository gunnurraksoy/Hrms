package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Education;

public interface EducationService {
	Result add(Education education);
	DataResult<List<Education>> getAll();
	DataResult<List<Education>> findAllByCandidate_Id(int candidateId);
	DataResult<List<Education>> getAllByCandidate_IdOrderByLeavingDateDesc(int candidateId);
}
