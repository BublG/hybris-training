package extension1.setup;

import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.impex.impl.StreamBasedImpExResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

@SystemSetup(extension = "extension1")
public class Extension1CustomSetup {
    private static final Logger LOG = LoggerFactory.getLogger(Extension1SystemSetup.class);
    private ImportService importService;

    public ImportService getImportService() {
        return importService;
    }

    public void setImportService(final ImportService importService) {
        this.importService = importService;
    }

    @SystemSetup(type = SystemSetup.Type.PROJECT)
    public boolean addMyProjectData() {
        LOG.info("Starting custom project data loading for the extension1");
        impexImport("/impex/myProductImport-extension1.impex");
        LOG.info("Custom project data loading for the extension1 completed.");
        return true;
    }

    protected void impexImport(final String filename) {
        final String message = "extension1 impexing [" + filename + "]...";
        try (final InputStream resourceAsStream = getClass().getResourceAsStream(filename)) {
            LOG.info(message);
            final ImportConfig importConfig = new ImportConfig();
            importConfig.setScript(new StreamBasedImpExResource(resourceAsStream, "UTF-8"));
            importConfig.setLegacyMode(Boolean.FALSE);
            final ImportResult importResult = getImportService().importData(importConfig);
            if (importResult.isError()) {
                LOG.error(message + " FAILED");
            }
        } catch (final Exception e) {
            LOG.error(message + " FAILED", e);
        }
    }
}
