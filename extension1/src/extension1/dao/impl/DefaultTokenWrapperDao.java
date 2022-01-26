package extension1.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import extension1.dao.TokenWrapperDao;
import extension1.model.TokenWrapperModel;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DefaultTokenWrapperDao implements TokenWrapperDao {
    @Resource
    private FlexibleSearchService flexibleSearchService;

    @Override
    public TokenWrapperModel getFirst() {
        final String queryString =
                "SELECT {p:" + TokenWrapperModel.PK + "} "
                        + "FROM {" + TokenWrapperModel._TYPECODE + " AS p} ";
       List<TokenWrapperModel> tokenWrappers = flexibleSearchService.<TokenWrapperModel>search(queryString).getResult();
       return tokenWrappers.size() > 0 ? tokenWrappers.get(0) : null;
    }
}
