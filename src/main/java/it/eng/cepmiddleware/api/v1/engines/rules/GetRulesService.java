package it.eng.cepmiddleware.api.v1.engines.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.eng.cepmiddleware.Service;
import it.eng.cepmiddleware.engine.CEPEngineProvider;

@org.springframework.stereotype.Service
public class GetRulesService implements Service {

	@Autowired CEPEngineProvider engineProvider;

	ResponseEntity<String> paramError = new ResponseEntity<String>(
		"Correct parameters not provided",
		HttpStatus.BAD_REQUEST
	);

	@Override
	public ResponseEntity<?> execute(Object... parameters) {
		if (parameters[0] instanceof String) {
			String engineId = (String) parameters[0];
			return getRules(engineId);
		}
		return paramError;
	}

	private ResponseEntity<?> getRules(String engineId) {
		return engineProvider.getCEPEngine(engineId).getRules();
	}

}
