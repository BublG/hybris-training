package extension1.dao;

import de.hybris.platform.servicelayer.internal.dao.Dao;
import extension1.model.ContactRequestModel;

import java.util.List;

public interface ContactRequestDao extends Dao {
    public List<ContactRequestModel> findBySender(String sender);
}
