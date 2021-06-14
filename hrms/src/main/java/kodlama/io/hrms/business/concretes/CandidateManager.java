package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.business.abstracts.LinkService;
import kodlama.io.hrms.business.abstracts.SkillService;
import kodlama.io.hrms.core.adapters.abstracts.FakeMailService;
import kodlama.io.hrms.core.adapters.abstracts.FakeMernisService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.CvDto;



@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private FakeMernisService fakeMernisService;
	private FakeMailService fakeMailService;
	
	private ImageService imageService;
	private LanguageService languageService;
	private LinkService linkService;
	private SkillService skillService;
	private EducationService educationService;
	private JobExperienceService jobExperienceService;
	private CoverLetterService coverLetterService;


	@Autowired
	public CandidateManager(CandidateDao candidateDao,FakeMernisService fakeMernisService,FakeMailService 
			fakeMailService,ImageService imageService,LanguageService languageService, SkillService skillService,
			EducationService educationService ,JobExperienceService jobExperienceService,CoverLetterService coverLetterService) {
		super();
		this.candidateDao = candidateDao;
		this.fakeMernisService=fakeMernisService;
		this.fakeMailService=fakeMailService;
		this.imageService=imageService;
		this.languageService=languageService;
		this.skillService=skillService;
		this.educationService=educationService;
		this.jobExperienceService=jobExperienceService;
		this.coverLetterService=coverLetterService;
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Candidate candidate, String passwordAgain ) {
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
			
		}else if (!Objects.equal(passwordAgain, candidate.getPassword())) {
			return new ErrorResult("Şifreler uyuşmuyor.");		
			
			
		}else {
			candidateDao.save(candidate);
			return new SuccessResult("Kayıt başarılı bir şekilde tamamlandı!");
		}
		
	}

	@Override
	public DataResult<CvDto> getCvById(int id) {
		
		
			
		CvDto cvDto = new CvDto();
		
		
		
		cvDto.setLanguages(this.languageService.findAllByCandidate_Id(id).getData());
		cvDto.setJobExperiences(this.jobExperienceService.findAllByCandidate_Id(id).getData());
		cvDto.setEducations(this.educationService.findAllByCandidate_Id(id).getData());
		cvDto.setCoverLetters(this.coverLetterService.findAllByCandidate_Id(id).getData());
		cvDto.setSkills(this.skillService.findAllByCandidate_Id(id).getData());
		return new SuccessDataResult<CvDto>(cvDto);
	
	}

	@Override
	public DataResult<Candidate> findById(int id) {
		
		return new SuccessDataResult<Candidate> (this.candidateDao.findById(id));
	}

	

}
