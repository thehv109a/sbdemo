package thehv.shares;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.Pattern;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.Normalizer;

public class AppUtils {
    public static String jsonIfy(Object object) throws JsonProcessingException {
        return (object != null) ? new ObjectMapper().writeValueAsString(object) : null;
    }

    public static Long bigDecimal2Long(BigDecimal bigDecimalVal) {
        return bigDecimalVal != null ? bigDecimalVal.longValue() : null;
    }

    public static Long double2Long(Double doubleVal) {
        return doubleVal != null ? doubleVal.longValue() : null;
    }

    public static Long jdbc2Long(Object object) {
        return object == null ? null
                : (object instanceof BigDecimal) ? ((BigDecimal) object).longValue() : (Long) object;
    }

    public static Double bigDecimal2Double(BigDecimal bigDecimalVal) {
        return bigDecimalVal != null ? bigDecimalVal.doubleValue() : null;
    }

    public static ArrayList<Object> getSameElement(Object element, int num) {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            objects.add(element);
        }
        return objects;
    }

    public static List<String> divMysql(String... strings) {
        String sql = strings[0];
        if (strings.length > 1) {
            HashMap<String, String> params = new HashMap<>();
            for (int i = 1; i < strings.length; i += 2) {
                String paramName = UUID.randomUUID().toString();
                sql = sql.replace(strings[i], paramName);
                params.put(paramName, strings[i + 1]);
            }
            for (String key : params.keySet()) {
                sql = sql.replace(key, params.get(key));
            }
        }
        return Arrays.asList(sql.split(";"));
    }

    public static String transDateSQLByMonth(String dateStr, int value) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateStr));
        cal.add(Calendar.MONTH, value);
        return df.format(cal.getTime());
    }

    public static String replaceOutHtmlByTag(String html, String tag, String replace) {
        int iStart = html.indexOf("<" + tag + ">");
        int iEnd = html.indexOf("</" + tag + ">") + tag.length() + 3;
        return new StringBuilder(html).replace(iStart, iEnd, replace).toString();
    }

    public static String getHtmlByTag(String html, String tag) {
        int iStart = html.indexOf("<" + tag + ">");
        int iEnd = html.indexOf("</" + tag + ">") + tag.length() + 3;
        return html.substring(iStart, iEnd);
    }

    public static boolean isNullOrEmptyStr(String s) {
        return (s == null || s.isEmpty()) ? true : false;
    }

    public static String mininizeString(String input) {
        return input.replace("\n", " ").replaceAll("\\s+", " ");
    }

    public static String getAppPath() throws IOException {
        return new File(".").getCanonicalPath();
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static Date getFirstDateInMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static String formatVNMoney(long money) {
        DecimalFormat formatter = new DecimalFormat("###,###,###,###");
        return formatter.format(money);
    }

    public static int getDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String fixNull(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        } else {
            return s;
        }
    }

    public static String reverseString(String s) {
        s = fixNull(s);
        String sReverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            sReverse += s.charAt(i);
        }
        return sReverse;
    }

    public static String toUnsign(String s) {
        s = fixNull(s);
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public static String toAlias(String s) {
        s = toUnsign(s);
        s = s.toLowerCase();
        String sNew = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sNew += s.charAt(i);
            } else {
                sNew += " ";
            }
        }
        sNew = sNew.trim();
        while (sNew.indexOf("  ") >= 0) {
            sNew = sNew.replace("  ", " ");
        }
        sNew = sNew.replace(" ", "-");
        return sNew;
    }

    public static String toAlias(String s, int id) {
        return toAlias(s) + "-" + id;
    }

    public static int idFromAlias(String s) {
        int k = s.lastIndexOf("-");
        return Integer.parseInt(s.substring(k + 1));
    }

    public static String fromAlias(String s) {
        int k = s.lastIndexOf("-");
        return s.substring(0, k);
    }

    public static String removeAllSpace(String s) {
        s = fixNull(s);
        return s.replaceAll("\\s", "");
    }

    public static String removeMoreThanOneSpace(String s) {
        s = fixNull(s);
        return s.trim().replaceAll(" +", " ");
    }
}