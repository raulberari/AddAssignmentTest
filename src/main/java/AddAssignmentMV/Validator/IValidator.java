package AddAssignmentMV.Validator;
import AddAssignmentMV.Exceptions.ValidatorException;

public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}