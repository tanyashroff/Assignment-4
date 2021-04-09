package edu.umd.enpm614.assignment4;

import java.io.File;
import java.util.Objects;

public class SeleniumTest {
    public static final String VERSION_88 = "v88";
    public static final String VERSION_89 = "v89";
    public static final String VERSION_90 = "v90";
    /* **************************************************************************
     * ********   This is a helper class DO NOT change code in here    **********
     * **************************************************************************/
    public static void setUpWebDriver() {
        setUpWebDriver(VERSION_89);
    }

    public static void setUpWebDriver(String chromeVersion) {
        String resource = getResourceName(chromeVersion);
        ClassLoader classLoader = SeleniumTest.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(resource),
                resource + " not found.").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
    }

    private static String getResourceName(String chromeVersion) {
        String osName = System.getProperty("os.name").toLowerCase();
        OperatingSystemType osType = OperatingSystemType.getType(osName);
        switch (osType) {
            case LINUX: return "chromedriver_linux64_" + chromeVersion;
            case MAC_OS: return "chromedriver_mac64_" + chromeVersion;
            case WINDOWS: return "chromedriver_win32_" + chromeVersion + ".exe";
            case UNKNOWN: default: throw new IllegalStateException("Unknown OS Type!");
        }
    }

    private enum OperatingSystemType {
        WINDOWS, MAC_OS, LINUX, UNKNOWN;
        private static OperatingSystemType getType(String os) {
            if (os.contains("win")) {
                return WINDOWS;
            } else if (os.contains("mac")) {
                return MAC_OS;
            } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
                return LINUX;
            } else {
                return UNKNOWN;
            }
        }
    }
}
