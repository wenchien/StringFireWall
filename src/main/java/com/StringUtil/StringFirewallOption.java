package com.StringUtil;

public enum StringFirewallOption {

    ALLOW_ALPHABETS(""),
    ALLOW_NUMBERS(""),
    ALLOW_HTML_CHARACTERS("/&#?[a-z0-9]{2,8};/i");

    private String regex;

    StringFirewallOption(String regex) {
        this.regex = regex;
    }
}
