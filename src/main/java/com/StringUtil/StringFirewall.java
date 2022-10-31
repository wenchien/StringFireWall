package com.StringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringFirewall implements Serializable {

    private List<String> allowedStringRules = new ArrayList<>();

    private StringFirewall() {

    }

    public static StringFirewall getStringFirewall() {
        return new StringFirewall();
    }

    public StringFirewall allow(List<String> customStringRules) {
        this.allowedStringRules.addAll(customStringRules);
        return this;
    }

    public StringFirewall allow(StringFirewallOption option) {
        return allow(option.toString());
    }

    public StringFirewall allow(String regex){
        this.allowedStringRules.add(regex);
        return this;
    }

    public boolean evaluate(String source) {
        boolean isOk = false;

        StringBuilder sb = new StringBuilder();
        if (this.allowedStringRules.size() <= 0) {
            return false;
        }

        for (String rule : this.allowedStringRules) {
            Pattern pattern = Pattern.compile(rule);
            Matcher matcher = pattern.matcher(source);
            if(matcher.find()) {
                sb.append(matcher.group());
            }
        }

        if (sb.toString().length() == source.length()) {
            isOk = true;
        }

        return isOk;
    }

}
