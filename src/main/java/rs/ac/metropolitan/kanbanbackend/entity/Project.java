package rs.ac.metropolitan.kanbanbackend.entity;

import java.time.*;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "project")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Project extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "project_id")
	private Integer projectId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "project_status", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "status_id"))
	private List<Status> statusList;
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "user_project", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> userId;
	
}