package rs.ac.metropolitan.kanbanbackend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import rs.ac.metropolitan.kanbanbackend.entity.Project;
import rs.ac.metropolitan.kanbanbackend.repository.ProjectRepository;
import rs.ac.metropolitan.kanbanbackend.service.ProjectService;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class ProjectServiceImpl implements ProjectService {
	private final ProjectRepository projectRepository;

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public Project findById(Integer ProjectID) {
		return projectRepository.findById(ProjectID)
				.orElseThrow(() -> new NoSuchElementException("ProjectService.notFound"));
	}

	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project update(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void deleteById(Integer ProjectID) {
		projectRepository.deleteById(ProjectID);
	}


}