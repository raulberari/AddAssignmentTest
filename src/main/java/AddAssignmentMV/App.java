package AddAssignmentMV;

/**
 * Hello world!
 *
 */

import AddAssignmentMV.Exceptions.*;
import AddAssignmentMV.Repository.XMLFileRepository.NotaXMLRepo;
import AddAssignmentMV.Repository.XMLFileRepository.StudentXMLRepo;
import AddAssignmentMV.Repository.XMLFileRepository.TemaLabXMLRepo;
import AddAssignmentMV.Service.XMLFileService.NotaXMLService;
import AddAssignmentMV.Service.XMLFileService.StudentXMLService;
import AddAssignmentMV.Service.XMLFileService.TemaLabXMLService;
import AddAssignmentMV.UI.*;
import AddAssignmentMV.Validator.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs, "StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn, "NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}