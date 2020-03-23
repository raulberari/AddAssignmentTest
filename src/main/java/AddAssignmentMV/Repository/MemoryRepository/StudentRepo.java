package AddAssignmentMV.Repository.MemoryRepository;

import AddAssignmentMV.Domain.Student;
import AddAssignmentMV.Validator.IValidator;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}