package test.autologin;


import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.security.auto.login.AutoLoginException;
import com.liferay.portal.kernel.util.LocaleUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoLogin  implements com.liferay.portal.kernel.security.auto.login.AutoLogin {

    @Override
    public String[] handleException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception e) throws AutoLoginException {

        return new String[0];
    }

    @Override
    public String[] login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AutoLoginException {
        return new String[0];
    }
}
