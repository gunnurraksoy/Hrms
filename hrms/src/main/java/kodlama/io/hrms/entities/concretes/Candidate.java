package kodlama.io.hrms.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
@Table(name="candidates")
public class Candidate extends User {
	

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "identity_number")
	private String identityNumber;
	
	@Column(name = "birth_year")
	private String birthYear;


	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<JobExperience> jobExperiences;
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CoverLetter> coverLetters;
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Language> languages;
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Skill> skills;
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Link> links;

	
}
