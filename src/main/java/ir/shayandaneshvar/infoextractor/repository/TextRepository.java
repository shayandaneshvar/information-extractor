package ir.shayandaneshvar.infoextractor.repository;


import ir.shayandaneshvar.infoextractor.services.TextInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends CrudRepository<TextInfo, Long> {
}
