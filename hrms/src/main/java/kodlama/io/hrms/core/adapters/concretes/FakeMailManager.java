package kodlama.io.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.adapters.abstracts.FakeMailService;


@Service
public class FakeMailManager implements FakeMailService {

	@Override
	public boolean isMailValidation(String email) {
		System.out.println(email+ "mail adresi için doğrulama başarılı!");
		return true;
	}

}
