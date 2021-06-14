package kodlama.io.hrms.core.adapters.abstracts;


import java.util.Map;

import org.springframework.web.multipart.MultipartFile;



import kodlama.io.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);


}
