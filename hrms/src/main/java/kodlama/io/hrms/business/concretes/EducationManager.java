package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EducationDao;
import kodlama.io.hrms.entities.concretes.Education;


@Service
public class EducationManager implements EducationService{
	
	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Okul bilgisi eklendi");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Data listelendi");

	}

	

	@Override
	public DataResult<List<Education>> findAllByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<Education>>(educationDao.findAllByCandidate_Id(candidateId));
	}

	@Override
	public DataResult<List<Education>> getAllByCandidate_IdOrderByLeavingDateDesc(int candidateId) {
		
		return new SuccessDataResult<List<Education>>(educationDao.getAllByCandidate_IdOrderByLeavingDateDesc(candidateId));
	}
}
