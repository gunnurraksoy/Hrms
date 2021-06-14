package kodlama.io.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.CoverLetter;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.Image;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.concretes.Link;
import kodlama.io.hrms.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CvDto {
	
	
	private Candidate candidate;
	
	
	private List<Education> educations;
	private List<JobExperience> jobExperiences;
	private List<Language> languages;
	private List<CoverLetter> coverLetters;
	private List<Skill> skills;
	private List<Image> images;
	private List<Link> links;

}
