package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	JobAdvertisement getById(int id);
	List<JobAdvertisement> getByIsActiveTrue(); 
	
	List<JobAdvertisement> getByIsActiveTrueOrderByDeadlineDate(); 
	
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
	List<JobAdvertisement> getByEmployer_CompanyName(String companyName); 
	
}
