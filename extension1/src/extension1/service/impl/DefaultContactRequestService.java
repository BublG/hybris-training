package extension1.service.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import extension1.dao.ContactRequestDao;
import extension1.model.ContactRequestModel;
import extension1.service.ContactRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultContactRequestService implements ContactRequestService {
    private static final String SAMPLE_SENDER = "contactRequest.sample.sender";
    private static final String SAMPLE_MESSAGE = "contactRequest.sample.message";

    @Resource
    private ConfigurationService configurationService;

    private ContactRequestDao contactRequestDao;

    @Autowired
    public void setContactRequestDao(ContactRequestDao contactRequestDao) {
        this.contactRequestDao = contactRequestDao;
    }

    @Override
    public ContactRequestModel getContactRequest(String sender) {
        final List<ContactRequestModel> result = contactRequestDao.findBySender(sender);
        final int resultCount = result.size();
        if (resultCount == 0) {
            throw new UnknownIdentifierException(
                    "ContactRequest with sender '" + sender + "' not found!"
            );
        } else if (resultCount > 1) {
            throw new AmbiguousIdentifierException(
                    "ContactRequest with sender '" + sender + "' is not unique, " + resultCount
                            + " requests found!"
            );
        }
        return result.get(0);
    }

    @Override
    public ContactRequestModel getSampleContactRequest() {
        ContactRequestModel contactRequestModel = new ContactRequestModel();
        contactRequestModel.setSender(configurationService.getConfiguration().getString(SAMPLE_SENDER));
        contactRequestModel.setMessage(configurationService.getConfiguration().getString(SAMPLE_MESSAGE));
        return contactRequestModel;
    }
}
