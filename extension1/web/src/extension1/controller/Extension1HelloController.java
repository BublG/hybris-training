/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package extension1.controller;

import static extension1.constants.Extension1Constants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import extension1.service.Extension1Service;


@Controller
public class Extension1HelloController
{
	@Autowired
	private Extension1Service extension1Service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", extension1Service.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
