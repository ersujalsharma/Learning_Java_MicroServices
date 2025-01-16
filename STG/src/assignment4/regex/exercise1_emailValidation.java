package assignment4.regex;

import java.util.ArrayList;

public class exercise1_emailValidation {
    public static void main(String[] args) {
        String str[] = {
                "http://www.sujalinformaticscenter.com",
                "http.www.sujalinformaticscenter.au",
                "https://www.sujalinformaticscenter.net",
                "https://www.sujalinformaticscenter.org",
                "https://www.sujalinformaticscenter.com",
                // add some mismatched urls
                "http://www.sujalinformaticscenter",
                "http://www.sujalinformaticscenter.",
                "http://www.sujalinformaticscenter.",
                "http://www.sujalinformaticscenter",
                "http://www.sujalinformaticscenter.com.",
                "http://www.sujalinformaticscenter.com/",
                "http://www.sujalinformaticscenter.com//",
                "http://www.sujalinformaticscenter.com//",
                "http://www.sujalinformaticscenter.com//",
                "http://www.sujalinformaticscenter.com//",
                "http://www.sujalinformaticscenter.com//",
        };
        String regex = "^(http|https)://(www.)?[a-zA-z0-9]+.(com|org|net)";
        for (String s : str) {
            System.out.println(s + " : " + s.matches(regex));
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }
}
