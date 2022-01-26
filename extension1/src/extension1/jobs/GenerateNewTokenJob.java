package extension1.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import extension1.dao.TokenWrapperDao;
import extension1.model.TokenWrapperModel;

import javax.annotation.Resource;
import java.util.Random;

public class GenerateNewTokenJob extends AbstractJobPerformable<CronJobModel> {
    @Resource
    private ModelService modelService;
    @Resource
    private TokenWrapperDao tokenWrapperDao;

    private final Random random = new Random();

    @Override
    public PerformResult perform(CronJobModel cronJobModel) {
        TokenWrapperModel tokenWrapperModel = tokenWrapperDao.getFirst();
        tokenWrapperModel.setToken(random.nextInt());
        modelService.save(tokenWrapperModel);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}
