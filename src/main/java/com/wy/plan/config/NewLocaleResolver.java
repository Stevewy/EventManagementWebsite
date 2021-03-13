package com.wy.plan.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author WangYao
 * @date 2021/3/2
 * @function 解析
 */
public class NewLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("l");
        // 空就默认
        if(StringUtils.isEmpty(language)){
            return Locale.getDefault();
        }
        // 否则按它的来
        String[] split = language.split("_");
        return new Locale(split[0],split[1]);
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}

