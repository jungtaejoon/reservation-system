package kr.or.connect.jgb.config.resolver;

import java.io.InputStream;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class HtmlViewResolver extends InternalResourceViewResolver {

    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
       
        String url = getPrefix() + viewName + getSuffix();
        InputStream stream = getServletContext().getResourceAsStream(url);
        if (stream == null) {
            return new NonExistentView();
        } else {
            stream.close();
        }
        return super.buildView(viewName);
    }
    
    private static class NonExistentView extends AbstractUrlBasedView {

        //private static Log logger = LogFactory.getLogger(NonExistentView.class);

        protected boolean isUrlRequired() {
            //logger.entering("isUrlRequired");
            return false;
        }

        public boolean checkResource(Locale locale) throws Exception {
            //logger.entering("checkResource");
            return false;
        }

        protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                HttpServletResponse response) throws Exception {
            //logger.entering("renderMergedOutputModel");
            // Purposely empty, it should never get called
        }
    }
}