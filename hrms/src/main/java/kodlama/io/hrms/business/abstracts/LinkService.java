package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Link;

public interface LinkService {
	Result add(Link link);
	DataResult<List<Link>> getAll();
	
	DataResult<List<Link>> findAllByCandidate_Id(int candidateId);


}
