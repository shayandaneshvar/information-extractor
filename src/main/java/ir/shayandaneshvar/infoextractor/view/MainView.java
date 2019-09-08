package ir.shayandaneshvar.infoextractor.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.Route;
import ir.shayandaneshvar.infoextractor.services.InfoDTO;
import ir.shayandaneshvar.infoextractor.services.InfoExtractorService;

import java.util.Collections;
import java.util.Comparator;

@Route("")
public class MainView extends VerticalLayout {

    private InfoExtractorService infoExtractorService;

    public MainView(InfoExtractorService utilityFacade) {
        add(new H1("Info Extractor"));
        infoExtractorService = utilityFacade;
        Grid<InfoDTO> grid = new Grid<>(InfoDTO.class);
        grid.setHeightByRows(true);
        Label label = new Label("Hello");
        add(label);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        add(horizontalLayout);
        TextField textField = new TextField("Enter Tag");
        TextArea textArea = new TextArea();
        textArea.setPlaceholder("Enter Text Here");
        Button button = new Button("Extract",
                buttonClickEvent -> handleExtraction(textField.getValue(),
                        textArea.getValue(), grid));
        horizontalLayout.add(textField, textArea);
        add(button);
        add(grid);
        setAlignItems(Alignment.CENTER);
        textArea.setWidthFull();
    }

    private void handleExtraction(String value, String text, Grid<InfoDTO> grid) {
        Notification.show("Extracted!");
        infoExtractorService.getData().add(infoExtractorService.apply(value, text));
        Collections.sort(infoExtractorService.getData(),
                Comparator.comparing(InfoDTO::getTag));
        grid.setDataProvider(DataProvider.ofCollection(infoExtractorService.getData()));
    }
}
