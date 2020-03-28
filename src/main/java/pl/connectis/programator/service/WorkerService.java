package pl.connectis.programator.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.connectis.programator.model.Route;
import pl.connectis.programator.model.Worker;

import java.util.List;

@Service
public interface WorkerService {

    Worker save(Worker worker);

    List<Worker> findAll();

    @Query(value = "SELECT w FROM Worker w")
    List<Worker> findAllSorted(Sort sort);

    List<Worker> findAllByIdGreaterThanOrderBySecondNameAsc(Long id);

    @Query(value = "SELECT w FROM Worker w ORDER BY w.secondName ASC")
    List<Worker> findAllSortedBySecondName();

    @Query(
            value = "SELECT * FROM worker ORDER BY second_name ASC",
            nativeQuery = true)
    List<Worker> findAllSortedBySecondNameNative();

    @Transactional
    List<Worker> removeById(Long id);

    void delete(Worker worker);


}
