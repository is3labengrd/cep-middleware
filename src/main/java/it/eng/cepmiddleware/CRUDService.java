package it.eng.cepmiddleware;

import java.util.Collection;
import java.util.Optional;

public interface CRUDService<T, ID> {

	public void create(T entity) throws Exception;
	public Optional<T> read(ID entityId);
	public Collection<T> read();
	public void update(T entity) throws Exception;
	public void delete(ID entityId) throws Exception;

}
