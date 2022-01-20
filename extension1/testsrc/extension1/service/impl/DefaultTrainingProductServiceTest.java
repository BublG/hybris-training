package extension1.service.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import extension1.service.TrainingProductService;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

@IntegrationTest
public class DefaultTrainingProductServiceTest extends ServicelayerTest {
    @Resource
    private TrainingProductService trainingProductService;

    @Before
    public void setup() {
        System.out.println("setup");
        //...
    }

    @Test(expected = UnknownIdentifierException.class)
    public void shouldThrownExceptionWhenGetProductWithNotExistingCodeAndName() {
        trainingProductService.getProductForCodeAndName("code", "name");
    }

    //other tests...
}
