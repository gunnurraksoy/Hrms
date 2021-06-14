package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobExperience;


public interface JobExperienceDao extends JpaRepository<JobExperience,Integer> {

	List<JobExperience> findAllByCandidate_Id(int  candidateId);
		
	List<JobExperience> getAllByCandidate_IdOrderByLeavingDateDesc(int jobSeekerId);
}
