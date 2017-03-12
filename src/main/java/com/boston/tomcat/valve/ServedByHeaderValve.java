package com.boston.tomcat.valve;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServedByHeaderValve extends ValveBase {
    private static final String HOSTNAME;

    public ServedByHeaderValve() { }

    public void invoke(Request request, Response response) throws IOException, ServletException {
        response.setHeader("Served-By", HOSTNAME);
        this.getNext().invoke(request, response);
    }

    static {
        String hostname;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException var2) {
            hostname = "unknown";
        }
        HOSTNAME = hostname;
    }
}
