package it.eng.cepmiddleware.api.v1.engines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.eng.cepmiddleware.Service;
import it.eng.cepmiddleware.engine.EngineInfoTokenRepository;
import it.eng.cepmiddleware.responses.PlainResponseBody;

@org.springframework.stereotype.Service
public class GetEngineService implements Service {

	@Autowired private EngineInfoTokenRepository repository;
	private ResponseEntity engineNotFound = new ResponseEntity<>(
		new PlainResponseBody("Engine doesn't exist"),
		HttpStatus.NOT_FOUND
	);

	@Override
	public ResponseEntity<?> execute(Object... parameters) {
		if (parameters[0] instanceof String) {
			String engineId = (String) parameters[0];
			return getEngine(engineId);
		}
		return ResponseEntity.badRequest().build();
	}

	private ResponseEntity<?> getEngine(String engineId) {
		return repository.findById(engineId)
			.<ResponseEntity>map(
				(engineInfo) -> new ResponseEntity<>(
					engineInfo,
					HttpStatus.OK
				)
			)
			.orElse(engineNotFound)
		;
	}

}
