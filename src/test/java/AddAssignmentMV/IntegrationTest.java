package AddAssignmentMV;

import AddAssignmentMV.Exceptions.ValidatorException;
import AddAssignmentMV.Repository.XMLFileRepository.NotaXMLRepo;
import AddAssignmentMV.Repository.XMLFileRepository.StudentXMLRepo;
import AddAssignmentMV.Repository.XMLFileRepository.TemaLabXMLRepo;
import AddAssignmentMV.Service.XMLFileService.NotaXMLService;
import AddAssignmentMV.Service.XMLFileService.StudentXMLService;
import AddAssignmentMV.Service.XMLFileService.TemaLabXMLService;
import AddAssignmentMV.Validator.NotaValidator;
import AddAssignmentMV.Validator.StudentValidator;
import AddAssignmentMV.Validator.TemaLabValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test for simple App.
 */
public class IntegrationTest
{
    @Test
    public void addAssignmentAlreadyAdded() {
        TemaLabValidator validator = new TemaLabValidator();
        TemaLabXMLRepo temaRepo = new TemaLabXMLRepo(validator, "StudentXML.xml");
        TemaLabXMLService temaService = new TemaLabXMLService(temaRepo);

        int repoSize = temaRepo.getSize();
        String[] params = {"1", "GoodDescription", "2", "4"};
        try {
            temaService.add(params);
        } catch (Exception ex) {
            assertTrue("Could not add correct example", ex instanceof ValidatorException);
        }
        assertEquals(temaRepo.getSize(), repoSize + 1);
        repoSize = temaRepo.getSize();
        try {
            temaService.add(params);
        } catch (Exception ex) {
            assertTrue("Could not add correct example", ex instanceof ValidatorException);
        }
        if (temaRepo.getSize() == repoSize + 1) {
            assertTrue("Duplicate assignment added", false);
        }
        else if(temaRepo.getSize() == repoSize) {
            assertTrue("Duplicate assignment not added", true);
        }
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
    public void addGradeValueOutOfBounds() {
        NotaValidator validator = new NotaValidator();
        NotaXMLRepo notaRepo = new NotaXMLRepo(validator, "NotaXML.xml");
        NotaXMLService notaService = new NotaXMLService(notaRepo);

        int repoSize = notaRepo.getSize();
        String[] params = {"1", "1", "1", "11", "2020-04-01 13:00"};
        try {
            notaService.add(params);
        } catch (Exception ex) {
            assertTrue("The grade value should be between 0 and 10", ex instanceof ValidatorException);
        }
        if (notaService.getSize() == repoSize + 1) {
            assertTrue("The grade value should be between 0 and 10", false);
        }
    }

    @Test
    public void bigBangIntegration() {
        addAssignmentAlreadyAdded();
        addStudentEmptyName();
        addGradeValueOutOfBounds();
    }
}
