package it.eng.cepmiddleware.engine.perseo_core;

import java.util.Map;

import it.eng.cepmiddleware.Converter;
import it.eng.cepmiddleware.rule.Rule;

public class PerseoCoreRuleConverter implements Converter<Rule, Map<String, Object>> {

	private String ownerEngineName;

	PerseoCoreRuleConverter(String ownerEngineName) {
		this.ownerEngineName = ownerEngineName;
	}

	@Override
	public Rule convert(Map<String, Object> source) {
		Rule rule = new Rule();
		rule.setOwner(ownerEngineName);
		rule.setDescription((String)source.get("description"));
		rule.setStatement((String)source.get("statement"));
		return rule;
	}

}