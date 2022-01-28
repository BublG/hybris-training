package extension1.constraints;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.validation.exceptions.HybrisConstraintViolation;
import de.hybris.platform.validation.services.ValidationService;
import extension1.model.MyTestClassModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import java.util.Set;

@IntegrationTest
public class MaxConstraintTest extends ServicelayerTransactionalTest {
    @Resource
    private ModelService modelService;
    @Resource
    private ValidationService validationService;

    @Before
    public void setup() throws Exception {
        createCoreData();
        importCsv("/impex/essentialdata-constraints.impex", "UTF-8");
        validationService.reloadValidationEngine();
    }

    @Test
    public void testMaxConstraint() {
        MyTestClassModel myTestClassModel = modelService.create(MyTestClassModel.class);
        myTestClassModel.setInt(1500);
        Set<HybrisConstraintViolation> violations = validationService.validate(myTestClassModel);
        Assert.assertEquals(1, violations.size());
        for (final HybrisConstraintViolation hybrisConstraintViolation : violations) {
            Assert.assertEquals(Max.class, hybrisConstraintViolation.getConstraintModel().getClass());
        }
    }
}
