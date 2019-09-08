package ir.shayandaneshvar.infoextractor.services;

import ir.shayandaneshvar.infoextractor.services.operators.Operator;
import org.springframework.stereotype.Service;

@Service
public class InfoExtractorService implements Operator<InfoDTO> {
    private CompositeInfoFacade compositeInfoFacade;

    public InfoExtractorService(CompositeInfoFacade compositeInfoFacade) {
        this.compositeInfoFacade = compositeInfoFacade;
    }

    @Override
    public InfoDTO apply(String string) {
        TextInfo textInfo = compositeInfoFacade.apply(string);
        InfoDTO infoDTO = new InfoDTO(textInfo);
        //save in db
        return infoDTO;
    }
}
