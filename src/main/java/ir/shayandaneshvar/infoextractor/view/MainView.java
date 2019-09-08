package ir.shayandaneshvar.infoextractor.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.Route;
import ir.shayandaneshvar.infoextractor.services.InfoDTO;
import ir.shayandaneshvar.infoextractor.services.InfoExtractorService;

import java.util.ArrayList;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    private InfoExtractorService infoExtractorService;
    List<InfoDTO> data;

    public MainView(InfoExtractorService utilityFacade) {
        data = new ArrayList<>();
        infoExtractorService = utilityFacade;
        Label label = new Label("Hello");
        TextArea textField = new TextArea();
        textField.setPlaceholder("Enter Text Here");
        Grid<InfoDTO> grid = new Grid<>(InfoDTO.class);
        grid.setHeightByRows(true);
        Button button = new Button("Extract",
                buttonClickEvent -> handleExtraction(textField.getValue(), grid));
        add(new H1("Info Extractor"));
        add(label, textField, button);
        add(grid);
        setAlignItems(Alignment.CENTER);
    }

    private void handleExtraction(String string, Grid<InfoDTO> grid) {
        Notification.show("Extracted!");
        data.add(infoExtractorService.apply(string));
        grid.setDataProvider(DataProvider.ofCollection(data));
    }
}
