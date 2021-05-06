package ssst.healthdiary;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jpa.rp.dstu3.PatientResourceProvider;
import ca.uhn.fhir.jpa.rp.dstu3.PractitionerResourceProvider;
import ca.uhn.fhir.rest.server.RestfulServer;
import org.hl7.fhir.dstu3.model.DomainResource;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fhir/*")
public class SimpleRestfulServer extends RestfulServer {
        //Initialize
    @Override
    protected void initialize()throws ServletException{
        //create a context for the appropriate version
        setFhirContext(FhirContext.forDstu3());
        //Register Resource Providers
        registerProvider(new PatientResourceProvider());
        registerProvider(new PractitionerResourceProvider());

    }
}