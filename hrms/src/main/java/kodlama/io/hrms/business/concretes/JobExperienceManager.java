package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İŞ deneyimi bilgisi eklendi");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"Data listelendi");
	}

	@Override
	public DataResult<List<JobExperience>> findAllByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.findAllByCandidate_Id(candidateId));
	}

	@Override
	public DataResult<List<JobExperience>> getAllByCandidate_IdOrderByLeavingDateDesc(int candidateId) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getAllByCandidate_IdOrderByLeavingDateDesc(candidateId));
	}

}
