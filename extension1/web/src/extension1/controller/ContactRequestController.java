package extension1.controller;

import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import extension1.model.ContactRequestModel;
import extension1.service.ContactRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/contactRequest")
public class ContactRequestController {
    @Resource
    private ContactRequestService contactRequestService;
    @Resource
    private ModelService modelService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showContactRequest(@RequestParam(required = false) String sender) {
        ContactRequestModel contactRequest = null;
        if (sender != null) {
            try {
                contactRequest = contactRequestService.getContactRequest(sender);
            } catch (final UnknownIdentifierException e) {
                // OK, nothing found
            }
        }
        final Map<String, Object> model = new HashMap<>();
        model.put("contactRequest", contactRequest);
        return new ModelAndView("contactRequest", model);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView sendMessage(@RequestParam(required = false) String newSender,
                                    @RequestParam(required = false) String newMessage) {
        ContactRequestModel contactRequest = new ContactRequestModel();
        modelService.attach(contactRequest);
        if (newSender != null) {
            contactRequest.setSender(newSender);
        }
        if (newMessage != null) {
            contactRequest.setMessage(newMessage);
        }
        modelService.save(contactRequest);
        final Map<String, Object> model = new HashMap<>();
        model.put("contactRequest", contactRequest);
        return new ModelAndView("contactRequest", model);
    }
}
