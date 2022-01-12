/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package extension1.setup;

import static extension1.constants.Extension1Constants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import extension1.constants.Extension1Constants;
import extension1.service.Extension1Service;


@SystemSetup(extension = Extension1Constants.EXTENSIONNAME)
public class Extension1SystemSetup
{
	private final Extension1Service extension1Service;

	public Extension1SystemSetup(final Extension1Service extension1Service)
	{
		this.extension1Service = extension1Service;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		extension1Service.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return Extension1SystemSetup.class.getResourceAsStream("/extension1/sap-hybris-platform.png");
	}
}
