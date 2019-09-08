package ir.shayandaneshvar.infoextractor.services;

import ir.shayandaneshvar.infoextractor.repository.TextRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@Service
public class InfoExtractorService implements BiFunction<String, String, InfoDTO> {
    private CompositeInfoFacade compositeInfoFacade;
    private TextRepository textRepository;
    private List<InfoDTO> data;

    public List<InfoDTO> getData() {
        return data;
    }

    public InfoExtractorService(CompositeInfoFacade compositeInfoFacade,
                                TextRepository textRepository) {
        this.compositeInfoFacade = compositeInfoFacade;
        data = new ArrayList<>();
        this.textRepository = textRepository;
    }

    public void setData(List<InfoDTO> data) {
        this.data = data;
    }

    @Override
    public InfoDTO apply(String tag, String text) {
        TextInfo textInfo = compositeInfoFacade.apply(tag, text);
        InfoDTO infoDTO = new InfoDTO(textInfo);
        //save in db
        textRepository.save(textInfo);
        return infoDTO;
    }
}
