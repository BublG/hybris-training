package extension1.controller;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public ModelAndView showPage(@RequestParam(required = false) String uid) {
        UserModel user;
        if (uid == null) {
            user = userService.getCurrentUser();
        } else {
            user = userService.getUserForUID(uid);
        }
        final Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        return new ModelAndView("user", model);
    }
}
