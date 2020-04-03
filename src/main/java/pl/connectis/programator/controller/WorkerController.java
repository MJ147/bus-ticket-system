package pl.connectis.programator.controller;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.connectis.programator.model.Worker;
import pl.connectis.programator.service.WorkerService;

import java.util.List;

@RequestMapping("/worker")
@RestController
public class WorkerController {

    WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Worker>> getAllWorker() {
        return ResponseEntity.ok(workerService.findAll());
    }

    @GetMapping("/list/sorted-by-name")
    public ResponseEntity<List<Worker>> getAllWorkersSortedByName(@RequestParam(required = false) String method) {
        if ("native".equals(method)) {
            return ResponseEntity.ok()
                    .header("method","native")
                    .body(workerService.findAllSortedBySecondNameNative());
        } else if ("hql".equals(method)) {
            return ResponseEntity.ok()
                    .header("method", "hql")
                    .body(workerService.findAllSortedBySecondName());
        } else if ("sortobject".equals(method)) {
            return ResponseEntity.ok()
                    .header("method", "sortobject")
                    .body(workerService.findAllSorted(Sort.by(Sort.Direction.ASC, "secondName")));
        }
        return ResponseEntity.ok()
                .header("method", "default")
                .body(workerService.findAllByIdGreaterThanOrderBySecondNameAsc(0L));
    }

    @PostMapping("/save")
    public ResponseEntity<Worker> saveNewWorker(@RequestBody Worker worker) {
        return ResponseEntity.ok(workerService.save(worker));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<List<Worker>> removeWorkerById(@PathVariable Long id) {
        return ResponseEntity.ok(workerService.removeById(id));
    }

    @DeleteMapping("/delete")
    public HttpStatus delete(@RequestBody Worker worker) {
        workerService.delete(worker);
        return HttpStatus.OK;
    }
    

}
