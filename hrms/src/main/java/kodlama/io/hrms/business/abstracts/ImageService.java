package kodlama.io.hrms.business.abstracts;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Image;

public interface ImageService {
	
	Result add(Image resumeImage, MultipartFile imageFile);
		
	DataResult<List<Image>> getAll();
	DataResult<Image> findAllByCandidate_Id(int id);
	

}
