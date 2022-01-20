package extension1.service;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;

public interface TrainingProductService extends ProductService {
    ProductModel getProductForCodeAndName(String code, String name);
}
