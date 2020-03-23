package AddAssignmentMV.Service.TxtFileService;
import AddAssignmentMV.Domain.*;
import AddAssignmentMV.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer,Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
