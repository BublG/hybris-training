package extension1.dao.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import extension1.dao.ContactRequestDao;
import extension1.service.ContactRequestService;
import org.junit.Assert;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import org.junit.Test;

@UnitTest
public class DefaultContactRequestDaoUnitTest {
    private final ContactRequestDao contactRequestDao = new DefaultContactRequestDao();
    private ContactRequestService contactRequestService;

    @Before
    public void setup() {
        contactRequestService = mock(ContactRequestService.class);
    }

    @Test
    public void shouldReturnEmptyListWhenSenderNotExists() {
        Assert.assertEquals(0, contactRequestDao.findBySender("NotExistingSender").size());
    }
}
