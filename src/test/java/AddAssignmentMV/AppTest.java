package AddAssignmentMV;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import AddAssignmentMV.Exceptions.ValidatorException;
import AddAssignmentMV.Repository.XMLFileRepository.StudentXMLRepo;
import AddAssignmentMV.Repository.XMLFileRepository.TemaLabXMLRepo;
import AddAssignmentMV.Service.XMLFileService.StudentXMLService;
import AddAssignmentMV.Service.XMLFileService.TemaLabXMLService;
import AddAssignmentMV.Validator.StudentValidator;
import AddAssignmentMV.Validator.TemaLabValidator;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void addAssignmentStringWeek() {
//
//        TemaLabValidator vt=new TemaLabValidator();
//        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
//        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
//
//
//        String[] params={"5","test description","abc","8"};
//
//        try{
//            tmsrv.add(params);
//        }catch (Exception ex){
//            if (ex instanceof NumberFormatException) {
//                assertTrue("Expected an int parameter for assignment week", false);
//            }
//        }
//    }
//
//    @Test
//    public void addAssignmentCheckNumberOfWeek() {
//        TemaLabValidator vt=new TemaLabValidator();
//        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
//        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
//
//
//
//        String[] params = {"10", "Test description", "10", "0"};
//        try{
//            tmsrv.add(params);
//        }catch (Exception ex){
//            assertTrue("Turn in week should be between 1 and 14", ex instanceof ValidatorException);
//
//        }
//    }

    @Test
    public void addStudentCorrect() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Borza Andrei", "921", "andrei@borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Could not add the correct example", false);
        }

        assertEquals(studentRepo.getSize(), repoSize + 1);
    }

    @Test
    public void addStudentEmptyName() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "", "921", "andrei@borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Name should not be the empty string", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Name should not be the empty string", false);
        }
    }


    @Test
    public void addStudentEmptyGroup() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "", "andrei@borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Group should not be the empty string", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Group should not be the empty string", false);
        }
    }

    @Test
    public void addStudentEmptyMail() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "AndreiB orza", "921", "", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Email should not be the empty string", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Email should not be the empty string", false);
        }
    }

    @Test
    public void addStudentEmptyProfessor() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "921", "andrei@borza.com", ""};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Professor should not be the empty string", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Professor should not be the empty string", false);
        }
    }


    @Test
    public void addStudentGroupWithText() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "921Andrei", "andrei@borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Group should be a number", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Group should be a number", false);
        }
    }

    @Test
    public void addStudentGroupNoNumber() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "Hello", "andrei@borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Group should be a number", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Group should be a number", false);
        }
    }
    @Test
    public void addStudentSmallerGroupNumber() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "911", "andrei@borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Group should be between 921 and 927", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Group should be between 921 and 927", false);
        }
    }

    @Test
    public void addStudentBiggerGroupNumber() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "931", "andrei@borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Group should be between 921 and 927", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Group should be between 921 and 927", false);
        }
    }

    @Test
    public void addStudentEmailNoAtCharacter() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "921", "andrei.borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Email should contain a single @ sign", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Email should contain a single @ sign", false);
        }
    }

    @Test
    public void addStudentEmailTooManyAtCharacters() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "921", "andrei@borza@com@ro", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Email should contain a single @ sign", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Email should contain a single @ sign", false);
        }
    }

    @Test
    public void addStudentEmailTwoAtCharacters() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "921", "andrei@borza@com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Email should contain a single @ sign", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Email should contain a single @ sign", false);
        }
    }

    @Test
    public void addStudentGroupSmallerThanLowerBoundary() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "920", "andrei.borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Group should be between 921 and 927", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Group should be between 921 and 927", false);
        }
    }

    @Test
    public void addStudentGroupBiggerThanLowerBoundary() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "922", "andrei.borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Group should be between 921 and 927", false);
        }

        assertEquals(studentRepo.getSize(), repoSize + 1);
    }

    @Test
    public void addStudentGroupSmallerThanHigherBoundary() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "926", "andrei.borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Group should be between 921 and 927", false);
        }

        assertEquals(studentRepo.getSize(), repoSize + 1);
    }

    @Test
    public void addStudentGroupEqualToHigherBoundary() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "927", "andrei.borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Group should be between 921 and 927", false);
        }

        assertEquals(studentRepo.getSize(), repoSize + 1);
    }

    @Test
    public void addStudentGroupBiggerThanHigherBoundary() {
        StudentValidator validator = new StudentValidator();
        StudentXMLRepo studentRepo = new StudentXMLRepo(validator, "StudentXML.xml");
        StudentXMLService studentService = new StudentXMLService(studentRepo);

        int repoSize = studentRepo.getSize();
        String[] params = {"1", "Andrei Borza", "928", "andrei.borza.com", "Gabriel Mircea"};
        try {
            studentService.add(params);
        } catch (Exception ex) {
            assertTrue("Group should be between 921 and 927", ex instanceof ValidatorException);
        }
        if (studentRepo.getSize() == repoSize + 1) {
            assertTrue("Group should be between 921 and 927", false);
        }
    }
}
