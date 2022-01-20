package extension1.controller;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.core.model.product.ProductModel;
import extension1.service.TrainingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/trainingProduct")
public class TrainingProductController {
    @Resource
    private CatalogVersionService catalogVersionService;
    @Autowired
    @Qualifier("productService")
    private TrainingProductService trainingProductService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPage(@RequestParam(required = false) String code,
                                 @RequestParam(required = false) String name) {
        catalogVersionService.setSessionCatalogVersion("apparelProductCatalog", "Online");
        ProductModel product = null;
        if (code != null && name != null)
        {
            product = trainingProductService.getProductForCode(code, name);
        }
        final Map<String, Object> model = new HashMap<>();
        model.put("product", product);
        return new ModelAndView("trainingProduct", model);
    }
}
