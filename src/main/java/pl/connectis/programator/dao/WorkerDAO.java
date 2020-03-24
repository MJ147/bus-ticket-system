package pl.connectis.programator.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.connectis.programator.model.Worker;

import java.util.List;

@Repository
public interface WorkerDAO extends CrudRepository<Worker, Long> {

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
