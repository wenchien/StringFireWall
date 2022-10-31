package com.StringUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringFirewallTest {

    @Test
    public void functionalityTest() {
        String testMsg = "asdl;ckl;jcxzcv\nadlksfjasd;fljksdafj;\ndfsdfsdfds";
        StringFirewall sf = StringFirewall.getStringFirewall().allow("").allow("");
        sf.evaluate(testMsg);
    }

}