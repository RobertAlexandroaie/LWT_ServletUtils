package lwt.lab.utils;

import javax.servlet.http.*;

/** Cookie that persists 1 year. Default Cookie doesn't
 *  persist past current browsing session.
 */

public class LongLivedCookie extends Cookie {
  /**
     * 
     */
    private static final long serialVersionUID = 1L;
public static final int SECONDS_PER_YEAR = 60*60*24*365;
  
  public LongLivedCookie(String name, String value) {
    super(name, value);
    setMaxAge(SECONDS_PER_YEAR);
  }
}
