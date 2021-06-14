package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> { 
	Image findAllByCandidate_Id(int candidateId);
	Image getById(int id);
}
