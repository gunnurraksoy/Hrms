package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.adapters.abstracts.FakeMailService;
import kodlama.io.hrms.core.adapters.abstracts.FakeMernisService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidatesDao;
import kodlama.io.hrms.entities.concretes.Candidate;



@Service
public class CandidateManager implements CandidateService {
	
	private CandidatesDao candidateDao;
	private FakeMernisService fakeMernisService;
	private FakeMailService fakeMailService;


	@Autowired
	public CandidateManager(CandidatesDao candidateDao,FakeMernisService fakeMernisService,FakeMailService fakeMailService) {
		super();
		this.candidateDao = candidateDao;
		this.fakeMernisService=fakeMernisService;
		this.fakeMailService=fakeMailService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		if(candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty()
				|| candidate.getIdentityNumber() == null|| candidate.getBirthYear()==null
				|| candidate.getEmail() == null || candidate.getPassword() == null ) {
			return new ErrorResult("Herhangi bir alan boş bırakılamaz ! ");
			
			
		}else if(candidateDao.findByIdentityNumberEquals(candidate.getIdentityNumber())!= null) {
				return new ErrorResult("Kullanilan bir  TCkimlik no  girdiniz!");
				
				
		}else if(candidateDao.findByEmailEquals(candidate.getEmail()) != null) {
			return new ErrorResult("Kullanilan bir email adresi  girdiniz!");
		}else if(!fakeMernisService.checkIfRealPerson(candidate.getFirstName(), candidate.getLastName(), candidate.getIdentityNumber(), candidate.getBirthYear())) {
			return new ErrorResult("Mernis Dogrulamasi basarisiz. Bilgilerinizi  tekrar kontrol ediniz! ");
		}else if(!fakeMailService.isMailValidation(candidate.getEmail())) {
			return new ErrorResult("Eposta dogrulamasi yapmadiniz. Kaydiniz olusmadi");
			
		}else {
			candidateDao.save(candidate);
			return new SuccessResult("Kayıt başarılı bir şekilde tamamlandı!");
		}
		
	}

}
