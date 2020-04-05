package AddAssignmentMV.Validator;

import AddAssignmentMV.Domain.Student;
import AddAssignmentMV.Exceptions.ValidatorException;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId().equals("")){
            //throw new ValidatorException("Id invalid\n");
            errors+="Id invalid\n";
        }
        if(s.getNume().equals("") || s.getNume()==null){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Nume invalid\n";
        }
        if(s.getGrupa() < 921 || s.getGrupa() > 927){
            //throw new ValidatorException("Grupa invalida\n");
            errors+="Grupa invalid\n";
        }
        if(s.getEmail().equals("") || s.getEmail()==null){
            //throw new ValidatorException("Email invalid\n");
            errors+="Email invalid\n";
        }
        if (!s.getEmail().matches("^.*@.*$") || s.getEmail().matches("^.*@.*@.*$")) {
            errors+="Email invalid\n";
        }
        if (s.getIndrumator().equals("") || s.getIndrumator() == null) {
            errors+="Profesor invalid\n";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}