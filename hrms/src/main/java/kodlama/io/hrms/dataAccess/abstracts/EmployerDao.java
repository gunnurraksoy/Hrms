package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Employer findByEmailEquals(String findEmail);
	Employer findByWebAddressEquals(String findWebAddress);
	Employer findByPhoneNumberEquals(String findPhoneNumber);

}
