package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidatesDao extends JpaRepository<Candidate, Integer>{
	Candidate findByIdentityNumberEquals(String findIdentityNumber);
	Candidate findByEmailEquals(String findEmail);
}
