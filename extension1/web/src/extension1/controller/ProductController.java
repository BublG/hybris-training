package extension1.controller;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import extension1.setup.Extension1SystemSetup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private CatalogVersionService catalogVersionService;
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "/product")
    public ModelAndView showProduct(@RequestParam(required = false) String code) {
        catalogVersionService.setSessionCatalogVersion("apparelProductCatalog", "Online");
        ProductModel product = null;
        if (code != null)  {
            product = productService.getProductForCode(code);
        }
        Map<String, Object> model = new HashMap<>();
        model.put("product", product);
        return new ModelAndView("product", model);
    }
}
