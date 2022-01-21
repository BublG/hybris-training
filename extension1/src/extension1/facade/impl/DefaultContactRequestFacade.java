package extension1.facade.impl;

import extension1.data.ContactRequestData;
import extension1.facade.ContactRequestFacade;
import extension1.model.ContactRequestModel;
import extension1.service.ContactRequestService;

import javax.annotation.Resource;
import java.util.Date;

public class DefaultContactRequestFacade implements ContactRequestFacade {
    @Resource
    private ContactRequestService contactRequestService;

    @Override
    public ContactRequestData getContactRequestDetails(String sender) {
        ContactRequestModel contactRequestModel = contactRequestService.getContactRequest(sender);
        ContactRequestData contactRequestData = new ContactRequestData();
        contactRequestData.setMessage(contactRequestModel.getMessage());
        contactRequestData.setSender(contactRequestModel.getSender());
        contactRequestData.setDate(new Date().toString());
        return contactRequestData;
    }
}
