package com.example.alertspoc;

import com.example.alertspoc.model.ResultTagAttribute;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import org.springframework.boot.actuate.metrics.web.servlet.WebMvcTagsContributor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.alertspoc.MetricsControllerAdvice.RESULT_METRICS_ATTRIBUTE;

@Component
public class CustomTagsContributor implements WebMvcTagsContributor {

    public static final String RESULT_TAG = "result";

    @Override
    public Iterable<Tag> getTags(HttpServletRequest request, HttpServletResponse response, Object handler, Throwable exception) {
        var attribute = request.getAttribute(RESULT_METRICS_ATTRIBUTE);
        if (attribute instanceof ResultTagAttribute result) {
            return Tags.of(RESULT_TAG, result.value);
        }
        return Tags.of(RESULT_TAG, "null"); // the tag needs to be always present even if it doesn't have a value to avoid exception
    }

    @Override
    public Iterable<Tag> getLongRequestTags(HttpServletRequest request, Object handler) {
        return Tags.empty();
    }

}
