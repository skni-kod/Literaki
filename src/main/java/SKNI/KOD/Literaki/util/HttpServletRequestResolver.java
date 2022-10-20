package SKNI.KOD.Literaki.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestResolver {
    public static String getServerPathFromRequest(HttpServletRequest httpServletRequest){
        return httpServletRequest.getScheme()+"://"+httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort();
    }
}
