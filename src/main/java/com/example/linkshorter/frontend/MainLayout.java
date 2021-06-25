package com.example.linkshorter.frontend;

import com.example.linkshorter.domain.UrlService;
import com.example.linkshorter.infrastructure.entity.ShortUrlEntity;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinServletRequest;
import io.swagger.v3.oas.models.links.Link;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Andrey Markov
 * @version 1.0 24.06.2021
 */
@Route(value = "", layout = AppLayout.class)
public class MainLayout extends VerticalLayout {
    UrlService urlService;

    public MainLayout(UrlService urlService) {
        this.urlService = urlService;
        ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
        Binder<ShortUrlEntity> binder = new Binder<>(ShortUrlEntity.class);
        TextField titleField = new TextField();
        Label label = new Label();
        binder.forField(titleField)
                .bind(ShortUrlEntity::getUrlToShort, ShortUrlEntity::setUrlToShort);
        Button saveButton = new Button("Shorten URL",
                event -> {
                    try {
                        binder.writeBean(shortUrlEntity);
                        label.setText(String.format("%s/%s", getCurrentUrl(), urlService.createShortUrl(shortUrlEntity).getPrefix()));
                        System.out.println(shortUrlEntity);
                    } catch (ValidationException ignored) {
                    }
                });
        add(label);
        add(titleField);
        add(saveButton);
        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);//puts button in vertical center
    }

    private String getCurrentUrl() {
        VaadinRequest vaadinRequest = VaadinService.getCurrentRequest();
        HttpServletRequest httpServletRequest = ((VaadinServletRequest) vaadinRequest).getHttpServletRequest();
        return httpServletRequest.getRequestURL().toString().
                replace(httpServletRequest.getRequestURI(), "");
    }
}
