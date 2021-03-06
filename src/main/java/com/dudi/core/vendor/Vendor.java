package com.dudi.core.vendor;

import java.util.Map;

public abstract class Vendor {
    private String url;

    public Vendor(String hostUrl) {
        this.url = hostUrl;
    }

    public void setAttributes(Map<String, String> attributes) {
        StringBuilder attrInLine = new StringBuilder("?");
        for (Map.Entry<String, String> entries : attributes.entrySet()) {
            attrInLine.append(entries.getKey()).append("=").append(entries.getValue());
        }
        url = url + attrInLine.toString();
    }


}
