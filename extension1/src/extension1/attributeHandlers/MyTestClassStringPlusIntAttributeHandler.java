package extension1.attributeHandlers;

import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;
import extension1.model.MyTestClassModel;

public class MyTestClassStringPlusIntAttributeHandler
        extends AbstractDynamicAttributeHandler<String, MyTestClassModel> {

    @Override
    public String get(MyTestClassModel model) {
        if (model.getInt() == null || model.getString() == null) {
            return null;
        }
        return model.getString() + model.getInt();
    }
}
