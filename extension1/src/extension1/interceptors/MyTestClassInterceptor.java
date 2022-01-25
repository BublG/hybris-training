package extension1.interceptors;

import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import extension1.events.MyTestClassEvent;
import extension1.model.MyTestClassModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MyTestClassInterceptor implements PrepareInterceptor<MyTestClassModel> {
    private static final String CONTENT_TEMPLATE = "MyTestClass string: %s; int: %d";

    @Resource
    private EventService eventService;

    @Override
    public void onPrepare(MyTestClassModel model, InterceptorContext interceptorContext) throws InterceptorException {
        eventService.publishEvent(new MyTestClassEvent(String.format(CONTENT_TEMPLATE,
                model.getString(), model.getInt())));
    }
}
