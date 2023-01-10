//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.docmatter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * replicated from the same-named class from the lib
 */
public class PropertiesUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private PropertiesUtil() {
    }

    public static Properties loadProperties(String propfile) throws Exception {
        Object is = null;

        try {
            is = new FileInputStream(new File(propfile));
        } catch (Exception var11) {
            try {
                is = PropertiesUtil.class.getClassLoader().getResourceAsStream(propfile);
            } catch (Exception var10) {
                var10.printStackTrace();
                logger.error("property file load: " + propfile, var10);
                throw var10;
            }
        }

        if (is == null) {
            logger.debug("No property file: " + propfile);
            return null;
        } else {
            Properties var3;
            try {
                Properties pr = new Properties();
                pr.load((InputStream)is);
                var3 = pr;
            } catch (IOException var9) {
                logger.error("property file load exception: " + propfile, var9);
                throw var9;
            } finally {
                if (is != null) {
                    ((InputStream)is).close();
                }

            }

            return var3;
        }
    }

    public static void show(Properties p) {
        if (p != null) {
            Enumeration keys = p.keys();

            while(keys.hasMoreElements()) {
                String k = (String)keys.nextElement();
                logger.info(k + " = " + p.getProperty(k));
            }

        }
    }
}
