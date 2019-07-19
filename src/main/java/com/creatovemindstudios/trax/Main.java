package com.creatovemindstudios.trax;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import javax.servlet.annotation.WebServlet;

@Push
@WebServlet(asyncSupported = true)
@HtmlImport(value = "frontend://styles/icons/icons-svg.html")
@HtmlImport("frontend://styles/shared-styles.html") // the application specific styles
@Viewport("user-scalable=no,initial-scale=0.5")
@Route("control")
@PWA(name = "Trax Controller", shortName = "")

public class Main extends VerticalLayout {

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        add(new Label("Hello World!!!"));
    }

}

