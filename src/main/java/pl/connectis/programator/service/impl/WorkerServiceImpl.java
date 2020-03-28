package pl.connectis.programator.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.connectis.programator.dao.WorkerDAO;
import pl.connectis.programator.model.Worker;
import pl.connectis.programator.service.WorkerService;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    WorkerDAO workerDAO;

    public WorkerServiceImpl(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

    @Override
    public List<Worker> findAll() {
        return workerDAO.findAll();
    }

    @Override
    public List<Worker> findAllSorted(Sort sort) {
        return workerDAO.findAllSorted(sort);
    }

    @Override
    public List<Worker> findAllByIdGreaterThanOrderBySecondNameAsc(Long id) {
        return workerDAO.findAllByIdGreaterThanOrderBySecondNameAsc(id);
    }

    @Override
    public List<Worker> findAllSortedBySecondName() {
        return workerDAO.findAllSortedBySecondName();
    }

    @Override
    public List<Worker> findAllSortedBySecondNameNative() {
        return workerDAO.findAllSortedBySecondNameNative();
    }

    public Worker save(Worker worker) {
        return workerDAO.save(worker);
    }

    @Override
    public List<Worker> removeById(Long id) {
        return workerDAO.removeById(id);
    }

    @Override
    public void delete(Worker worker) {
        workerDAO.delete(worker);
    }
}
