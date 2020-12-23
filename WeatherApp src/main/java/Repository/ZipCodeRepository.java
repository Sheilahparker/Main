package Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.ZipCode;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode,Long>{
	
}
