package extension1.service.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import extension1.model.ContactRequestModel;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

@IntegrationTest
public class DefaultContactRequestServiceTest extends ServicelayerTransactionalTest {
    @Resource
    private DefaultContactRequestService defaultContactRequestService;

    @Test
    public void shouldCorrectUsePropertiesValues() {
        ContactRequestModel contactRequestModel = defaultContactRequestService.getSampleContactRequest();
        Assert.assertEquals("sender", contactRequestModel.getSender());
        Assert.assertEquals("some message", contactRequestModel.getMessage());
    }
}
