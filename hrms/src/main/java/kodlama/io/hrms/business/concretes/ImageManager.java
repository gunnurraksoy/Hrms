package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.core.adapters.abstracts.CloudinaryService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

import kodlama.io.hrms.dataAccess.abstracts.ImageDao;
import kodlama.io.hrms.entities.concretes.Image;


@Service 
public class ImageManager implements ImageService {
	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public ImageManager(ImageDao imageDao,CloudinaryService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
	}


	@Override
	public Result add(Image image, MultipartFile imageFile) {
		@SuppressWarnings("unchecked")
		Map<String,String> uploadImage = this.cloudinaryService.uploadImageFile(imageFile).getData();
		image.setImageUrl(uploadImage.get("url"));
		
		this.imageDao.save(image);
		return new SuccessResult("Fotoğraf  eklendi");
	}



	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(),"Data listelendi");
	}


	@Override
	public DataResult<Image> findAllByCandidate_Id(int id) {
		return new SuccessDataResult<Image>(this.imageDao.findAllByCandidate_Id(id));
	}

}

	


	
	


