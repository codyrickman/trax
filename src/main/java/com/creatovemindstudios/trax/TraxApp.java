package com.creatovemindstudios.trax;

import com.vaadin.flow.server.startup.ServletContextListeners;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.*;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import java.net.URI;
import java.net.URL;

public class TraxApp {

    public static final String JAR_PATTERN = "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern";

    public static void main(String[] args) throws Exception {
        URL webRootLocation = TraxApp.class.getResource("/webapp/");
        URI webRootUri = webRootLocation.toURI();

        WebAppContext context = new WebAppContext();
        context.setBaseResource(Resource.newResource(webRootUri));
        context.setContextPath("/");
        context.setAttribute(JAR_PATTERN, ".*");
        context.setConfigurationDiscovered(true);
        context.setConfigurations(new Configuration[]{
                new AnnotationConfiguration(),
                new WebInfConfiguration(),
                new WebXmlConfiguration(),
                new MetaInfConfiguration(),
                new FragmentConfiguration(),
                new EnvConfiguration(),
                new PlusConfiguration(),
                new JettyWebXmlConfiguration()
        });
        context.getServletContext().setExtendedListenerTypes(true);
        context.addEventListener(new ServletContextListeners());

        Server server = new Server(8080);
        server.setHandler(context);
        WebSocketServerContainerInitializer.configureContext(context);
        server.start();
        server.join();

    }

}
