package AddAssignmentMV.Repository.MemoryRepository;

import AddAssignmentMV.Domain.Nota;
import AddAssignmentMV.Validator.IValidator;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota > {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}