package extension1.events;

import de.hybris.platform.servicelayer.event.events.AbstractEvent;

public class MyTestClassEvent extends AbstractEvent {
    private String content;

    public MyTestClassEvent(String content) {
        super();
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
