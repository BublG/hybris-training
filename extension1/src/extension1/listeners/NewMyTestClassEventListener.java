package extension1.listeners;

import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;
import extension1.events.MyTestClassEvent;
import extension1.model.NewsModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class NewMyTestClassEventListener extends AbstractEventListener<MyTestClassEvent> {
    @Resource
    private ModelService modelService;

    @Override
    protected void onEvent(MyTestClassEvent event) {
        if (event != null && event.getSource() != null) {
            NewsModel news = new NewsModel();
            news.setDate(new Date());
            news.setContent(event.getContent());
            modelService.save(news);
        }
    }
}
