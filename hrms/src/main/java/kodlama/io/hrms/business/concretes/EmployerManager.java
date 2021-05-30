package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.adapters.abstracts.FakeHrmsCheckService;
import kodlama.io.hrms.core.adapters.abstracts.FakeMailService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private FakeMailService fakeMailService;
	private FakeHrmsCheckService fakeHrmsCheckService;
	
	public EmployerManager(EmployerDao employerDao,FakeMailService fakeMailService,
			FakeHrmsCheckService fakeHrmsCheckService) {
		super();
		this.employerDao = employerDao;
		this.fakeMailService = fakeMailService;
		this.fakeHrmsCheckService = fakeHrmsCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Employer employer) {
		String[] domain = employer.getEmail().split("@");
		String website=employer.getWebAddress().substring(4);

		if (employer.getCompanyName() == null || employer.getWebAddress() == null
				|| employer.getPhoneNumber() == null || employer.getEmail() == null
				|| employer.getPassword() == null) {
			return new ErrorResult("Herhangi bir alan boş geçilemez");
		} else

		if (!domain[1].equals(website)) {
			return new ErrorResult("e-posta ve web sitesi uyusmuyor.");
		} else

		if (employerDao.findByEmailEquals(employer.getEmail()) != null
				|| employerDao.findByWebAddressEquals(employer.getWebAddress()) != null) {
			return new ErrorResult("Bu e posta zaten kullaniliyor");
		} else

		if (!fakeMailService.isMailValidation(employer.getEmail())) {
			return new ErrorResult("Mail dogrulamasi gerceklesmedi. Kayit basarisiz");
		} else if (!fakeHrmsCheckService.confirmUser()) {
			return new ErrorResult("Kayit dogrulanmadi. Islem basarisiz!");
		} 
		else {
			employerDao.save(employer);
			return new SuccessResult("Kayit Basarili bir sekilde olusturuldu");
		}
	}

	

}
