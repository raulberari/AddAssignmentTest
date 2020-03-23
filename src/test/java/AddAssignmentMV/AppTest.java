package AddAssignmentMV;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import AddAssignmentMV.Exceptions.ValidatorException;
import AddAssignmentMV.Repository.XMLFileRepository.TemaLabXMLRepo;
import AddAssignmentMV.Service.XMLFileService.TemaLabXMLService;
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
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addAssignmentStringWeek() {

        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);


        String[] params={"5","test description","abc","8"};

        try{
            tmsrv.add(params);
        }catch (Exception ex){
            if (ex instanceof NumberFormatException) {
                assertTrue("Expected an int parameter for assignment week", false);
            }
        }
    }

    @Test
    public void addAssignmentBigNumberWeek() {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);



        String[] params = {"10", "Test description", "10", "0"};
        try{
            tmsrv.add(params);
        }catch (Exception ex){
            assertTrue("Turn in week should be between 1 and 14", ex instanceof ValidatorException);

        }
    }
}
