package com.ivan.system;


import java.io.IOException;

public class SystemCtl {
    public static void systemCtl(String status, String serviceName) throws IOException, InterruptedException {
        String[] serviceCommand = new String[]{
                "sudo",
                "systemctl",
                status,
                serviceName
        };
        Process process = Runtime.getRuntime().exec(serviceCommand);
        process.waitFor();
    }
}
