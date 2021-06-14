package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.SkillDao;

import kodlama.io.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{

	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}
	
	
	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Yetenek bilgisi eklendi");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(),"Data listelendi");
	}

	@Override
	public DataResult<List<Skill>> findAllByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<Skill>>(skillDao.findAllByCandidate_Id(candidateId));
	}

}
