package rs.ac.metropolitan.kanbanbackend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import rs.ac.metropolitan.kanbanbackend.entity.Status;
import rs.ac.metropolitan.kanbanbackend.repository.StatusRepository;
import rs.ac.metropolitan.kanbanbackend.service.StatusService;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class StatusServiceImpl implements StatusService {
	private final StatusRepository statusRepository;

	@Override
	public List<Status> findAll() {
		return statusRepository.findAll();
	}

	@Override
	public Status findById(Integer StatusID) {
		return statusRepository.findById(StatusID)
				.orElseThrow(() -> new NoSuchElementException("StatusService.notFound"));
	}

	@Override
	public Status save(Status status) {
		return statusRepository.save(status);
	}

	@Override
	public Status update(Status status) {
		return statusRepository.save(status);
	}

	@Override
	public void deleteById(Integer StatusID) {
		statusRepository.deleteById(StatusID);
	}


}