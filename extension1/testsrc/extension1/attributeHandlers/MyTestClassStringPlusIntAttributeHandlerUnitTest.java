package extension1.attributeHandlers;

import de.hybris.bootstrap.annotations.UnitTest;
import extension1.model.MyTestClassModel;
import org.junit.Assert;
import org.junit.Test;

@UnitTest
public class MyTestClassStringPlusIntAttributeHandlerUnitTest {

    @Test
    public void shouldReturnNullWhenIntOrStringIsNull() {
        MyTestClassModel testClassModel = new MyTestClassModel();
        MyTestClassStringPlusIntAttributeHandler handler = new MyTestClassStringPlusIntAttributeHandler();

        testClassModel.setString(null);
        testClassModel.setInt(5);
        Assert.assertNull(handler.get(testClassModel));

        testClassModel.setInt(null);
        Assert.assertNull(handler.get(testClassModel));

        testClassModel.setString("abc");
        Assert.assertNull(handler.get(testClassModel));
    }

    @Test
    public void shouldConcatStringAndIntWhenBothNotNull() {
        MyTestClassModel testClassModel = new MyTestClassModel();
        MyTestClassStringPlusIntAttributeHandler handler = new MyTestClassStringPlusIntAttributeHandler();

        testClassModel.setString("abc");
        testClassModel.setInt(5);
        Assert.assertEquals("abc5", handler.get(testClassModel));
    }
}
