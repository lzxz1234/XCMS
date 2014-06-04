package org.nutz.mvc.impl.processor;

import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionInfo;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.NutConfig;

import com.chineseall.xcms.core.Http404Exception;

/**
 * 
 * @author zozoh(zozohtnt@gmail.com)
 * @author wendal(wendal1985@gmail.com)
 *
 */
public class FailProcessor extends ViewProcessor {
    
    private static final Log log = Logs.get();

    @Override
    public void init(NutConfig config, ActionInfo ai) throws Throwable {
        view = evalView(config, ai, ai.getFailView());
    }
    
    public void process(ActionContext ac) throws Throwable {
        
        if(ac.getError() != null && ac.getError() instanceof Http404Exception) {
            log.info("404NotFoundException=" + Mvcs.getRequestPath(ac.getRequest()));
        } else if (log.isErrorEnabled())
            log.error("Catch handle error URI=" + Mvcs.getRequestPath(ac.getRequest()), ac.getError());
        super.process(ac);
    }
}
