package ssst.healthdiary.backend.resource_provider;

import ca.uhn.fhir.rest.annotation.*;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.Practitioner;
import org.hl7.fhir.instance.model.api.IBaseResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class PractitionerResourceProvider implements IResourceProvider {

    public PractitionerResourceProvider() {  }

    private Map<String, Practitioner> practitionerMap = new HashMap<String, Practitioner>();

    @Override
    public Class<? extends IBaseResource> getResourceType() {
        return Practitioner.class;
    }

    @Search
    public List<Practitioner> search(@RequiredParam(name = Practitioner.SP_FAMILY) StringParam theParam) {
        List<Practitioner> practitioners = new ArrayList<Practitioner>();
        practitioners = this.searchByName(theParam.getValue());
//        practitioners = this.searchByPatient(theParam.getValue());
        return practitioners;
    }

    @Read()
    public Practitioner read(@IdParam IdType theId) {
        loadMockPractitioners();
        Practitioner retVal = practitionerMap.get(theId.getIdPart());
        if (retVal == null) {
            throw new ResourceNotFoundException(theId);
        }
        return retVal;
    }

    private List<Practitioner> searchByName(String name){
        List<Practitioner> retPractitioners;
        loadMockPractitioners();

        retPractitioners = practitionerMap.values()
                .stream()
                .filter(next -> name.toLowerCase().equals(next.getNameFirstRep().getFamily().toLowerCase()))
                .collect(Collectors.toList());
        return retPractitioners;
    }

    private List<Practitioner> searchByPatient(String name){
        List<Practitioner> retPractitioners;
        loadMockPractitioners();

        retPractitioners = practitionerMap.values()
                .stream()
                .filter(next -> name.toLowerCase().equals(next.getNameFirstRep().getFamily().toLowerCase()))
                .collect(Collectors.toList());
        return retPractitioners;
    }

    private void loadMockPractitioners() {

        Practitioner practitioner = new Practitioner();
        practitioner.setId("1");
        practitioner.addIdentifier().setSystem("http://optum.com/MRNs").setValue("002");
        practitioner.addName().setFamily("House").addGiven("Gregg").addGiven(" ");
        practitioner.addAddress().addLine("Doc Address Line 1");
        practitioner.addAddress().setCity("Pittsbugh");
        practitioner.addAddress().setCountry("Pensylvania");
        practitioner.addTelecom().setValue("111-111-1111");
        this.practitionerMap.put("1", practitioner);
        for (int i = 2; i < 5; i++) {
            practitioner = new Practitioner();
            practitioner.setId(Integer.toString(i));
            practitioner.addIdentifier().setSystem("http://optum.com/MRNs").setValue("007" + i);
            practitioner.addName().setFamily("House" + i).addGiven("Dr. ");
            practitioner.addAddress().addLine("House Line " + i);
            practitioner.addAddress().setCity("House" + i + "'s City");
            practitioner.addAddress().setCountry("USA");
            this.practitionerMap.put(Integer.toString(i), practitioner);
        }
    }
}

