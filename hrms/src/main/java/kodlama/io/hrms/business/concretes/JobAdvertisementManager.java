package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;


@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	
private JobAdvertisementDao jobAdvertisementDao;
	

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}


	@Override
	public Result addJobAdvertisment(JobAdvertisement jobAdvertisement) {
		 this.jobAdvertisementDao.save(jobAdvertisement);
	        return new SuccessResult("İş ilanı başarıyla eklendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Tüm iş ilanları lListelendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue(), "Tüm aktif iş ilanları listelendi" );
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByDeadlineDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByDeadlineDate(),"İş ilanları tarihe göre listelendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>> (this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_CompanyName(companyName), "Firmaya ait ilanlar getirildi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_CompanyName(companyName),"asd");
	}


	@Override
	public Result setIsActivate(int id, boolean isActivate) {
		JobAdvertisement advertisement= this.jobAdvertisementDao.getById(id);
		advertisement.setActive(isActivate);
		this.jobAdvertisementDao.save(advertisement);
		
		return (isActivate==false 
				? 
					new SuccessResult("İş ilanı pasif yapıldı") 
				: 
					new SuccessResult("İş ilanı aktif yapıldı"));
	}


}
