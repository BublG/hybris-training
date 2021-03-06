package extension1.service.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.impl.DefaultProductService;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import javax.annotation.Resource;

public class DefaultTrainingProductService extends DefaultProductService {
    @Resource
    private FlexibleSearchService flexibleSearchService;

    public ProductModel getProductForCodeAndName(String code, String name) {
        final FlexibleSearchQuery query = new FlexibleSearchQuery("SELECT {pk} FROM {Product} WHERE "
                + "{code}=?code AND {name} LIKE %?name%");
        query.addQueryParameter(ProductModel.CODE, code);
        query.addQueryParameter(ProductModel.NAME, name);
        final SearchResult<ProductModel> result = flexibleSearchService.search(query);
        final int resultCount = result.getTotalCount();
        if (resultCount == 0) {
            throw new UnknownIdentifierException("Product not found!");
        } else if (resultCount > 1) {
            throw new AmbiguousIdentifierException("Product code and name is not unique!");
        }
        return result.getResult().get(0);
    }

    @Override
    public ProductModel getProductForCode(String code) {
        return getProductForCodeAndName(code,"AMD");
    }
}
