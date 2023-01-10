package com.docmatter.ims.util;

import java.util.UUID;

public class HashUtil {
    public static int getUuidHash(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().hashCode();
    }
}
