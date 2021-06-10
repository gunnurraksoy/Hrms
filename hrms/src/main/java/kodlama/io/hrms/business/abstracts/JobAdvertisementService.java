package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result addJobAdvertisment(JobAdvertisement jobAdvertisement);
	Result setIsActivate(int id, boolean isActivate);

	DataResult<List<JobAdvertisement>> getAll(); 

	DataResult<List<JobAdvertisement>> getByIsActiveTrue(); 

	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByDeadlineDate(); 

	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
	DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName); 
	
}