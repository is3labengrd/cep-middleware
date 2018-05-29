package it.eng.cepmiddleware.engine;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import it.eng.cepmiddleware.Converter;
import it.eng.cepmiddleware.rule.Rule;

public class PerseoCore implements CEPEngine {
	
	private String hostUrl;
	private String name;

	public PerseoCore(String name, String hostUrl) {
		this.hostUrl = hostUrl;
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String getHostUrl() {
		return hostUrl;
	}

	public void setHostUrl(String hostUrl) {
		this.hostUrl = hostUrl;
	}
	
	public ResponseEntity<?> createRule(Rule rule) {
		PerseoCoreRuleAdapter adaptedRule = new PerseoCoreRuleAdapter(rule);
		try {
			HttpResponse<Object> response = Unirest.post(hostUrl + "/perseo-core/rules")
			  .header("accept", "application/json")
			  .body(adaptedRule)
			  .asObject(Object.class);
			return new ResponseEntity<Object>(
				response.getBody(),
				HttpStatus.resolve(response.getStatus())
			);
		} catch (UnirestException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	public ResponseEntity<?> getRule(String ruleId) {
		try {
			HttpResponse<Object> response = Unirest.get(hostUrl + "/perseo-core/rules/" + ruleId)
			  .header("accept", "application/json")
			  .asObject(Object.class);
			return new ResponseEntity<Object>(
				response.getBody(),
				HttpStatus.resolve(response.getStatus())
			);
		} catch (UnirestException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	public ResponseEntity<?> getRules() {
		try {
			HttpResponse<Object> response = Unirest.get(hostUrl + "/perseo-core/rules")
			  .header("accept", "application/json")
			  .asObject(Object.class);
			return new ResponseEntity<Object>(
				response.getBody(),
				HttpStatus.resolve(response.getStatus())
			);
		} catch (UnirestException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_GATEWAY);
		}
	}

	@Override
	public ResponseEntity<?> deleteRule(String ruleId) {
		try {
			System.out.println(hostUrl + "/perseo-core/rules" + ruleId);
			HttpResponse<Object> response = Unirest.delete(hostUrl + "/perseo-core/rules/" + ruleId)
			  .header("accept", "application/json")
			  .asObject(Object.class);
			return new ResponseEntity<Object>(
				response.getBody(),
				HttpStatus.resolve(response.getStatus())
			);
		} catch (UnirestException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_GATEWAY);
		}
	}

	@Override
	public Converter<? extends Rule, Map<String, Object>> getConverter() {
		return new PerseoCoreConverter(this.getName());
	}
	
}
