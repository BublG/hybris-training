package extension1.service;

import extension1.model.ContactRequestModel;

public interface ContactRequestService {
    ContactRequestModel getContactRequest(String sender);
    ContactRequestModel getSampleContactRequest();
}
