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

@Route("")
public class MainView extends VerticalLayout {

    private InfoExtractorService infoExtractorService;

    public MainView(InfoExtractorService utilityFacade) {
        infoExtractorService = utilityFacade;
        Label label = new Label("Hello");
        TextArea textField = new TextArea();
        textField.setPlaceholder("Enter Text Here");
        Button button = new Button("Extract",
                buttonClickEvent -> handleExtraction(textField.getValue()));
        add(new H1("Info Extractor"));
        add(label, textField, button);
    }

    private void handleExtraction(String string) {
        Notification.show("Extracted!");
        Grid<InfoDTO> grid = new Grid<>(InfoDTO.class);
        grid.setDataProvider(DataProvider.ofItems(infoExtractorService.apply(string)));
        grid.setHeightByRows(true);
        add(grid);
    }
}
