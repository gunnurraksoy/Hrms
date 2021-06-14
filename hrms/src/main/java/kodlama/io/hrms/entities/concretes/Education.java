package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="educations")
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName ;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@Column(name = "leaving_date")
	private LocalDate leavingDate;
	
	@Column(name="is_graduated")
	private boolean isGraduated;
	
	//@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "candidate_id ",referencedColumnName = "id")
	private Candidate candidate;
}
