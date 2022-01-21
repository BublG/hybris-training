package extension1.facade;

import extension1.data.ContactRequestData;

public interface ContactRequestFacade {
    ContactRequestData getContactRequestDetails(final String sender);
}
