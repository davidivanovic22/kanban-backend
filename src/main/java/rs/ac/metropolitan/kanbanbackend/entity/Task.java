package rs.ac.metropolitan.kanbanbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "task")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Task extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "task_id")
	private Integer taskId;
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	@ManyToOne
	private Project projectId;
	@JoinColumn(name = "status_id", referencedColumnName = "status_id")
	@ManyToOne
	private Status statusId;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@ManyToOne
	private User userId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "due_date")
	private LocalDate dueDate;
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "task_label", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "label_id"))
	private List<Label> labelList;
	
}