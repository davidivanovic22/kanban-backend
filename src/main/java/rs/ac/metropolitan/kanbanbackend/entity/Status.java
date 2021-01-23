package rs.ac.metropolitan.kanbanbackend.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "status")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Status extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "status_id")
	private Integer statusId;
	@Column(name = "name")
	private String name;
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "project_status", joinColumns = @JoinColumn(name = "status_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Status> statusList;
	
}