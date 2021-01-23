package rs.ac.metropolitan.kanbanbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "label")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Label extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "label_id")
	private Integer labelId;
	@Column(name = "name")
	private String name;
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "task_label", joinColumns = @JoinColumn(name = "label_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
	private List<Task> taskList;
	
}