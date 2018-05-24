package it.eng.cepmiddleware.api.v1.engine;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.eng.cepmiddleware.Service;
import it.eng.cepmiddleware.config.CEPMiddlewareConfiguration;
import it.eng.cepmiddleware.engine.CEPEnginePayloadMaker;

@org.springframework.stereotype.Service
public class GetEngineService implements Service {
	
	@Override
	public ResponseEntity<?> execute(Object... parameters) {
		if (parameters[0] instanceof String) {
			String engineId = (String) parameters[0];
			return getEngine(engineId);
		}
		return ResponseEntity.badRequest().build();
	}

	private ResponseEntity<?> getEngine(String engineId) {
		return new ResponseEntity<Object>((new CEPEnginePayloadMaker()).visit((new CEPMiddlewareConfiguration()).getEngine(engineId)), HttpStatus.OK);
	}

}
