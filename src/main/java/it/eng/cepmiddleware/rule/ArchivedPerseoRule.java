package it.eng.cepmiddleware.rule;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonRawValue;

import it.eng.cepmiddleware.ObjectMapperProvider;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ArchivedPerseoRule extends ArchivedRule {

	private String name;
	private String text;
	@JsonRawValue private String action;
	private String description;

	public ArchivedPerseoRule() {}

	public ArchivedPerseoRule(PerseoRule rule) {
		this.name = rule.getName();
		this.action = rule.getAction();
		this.description = rule.getDescription();
		this.text = rule.getText();
	}

	public String getName() {
		if (name != null) {
			return this.name;
		} else {
			return this.getRuleId();
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAction() {
		return action;
	}

	public void setAction(Map action) {
		this.action = ObjectMapperProvider
			.getObjectMapper()
			.writeValue(action);
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public PerseoRule extract() {
		PerseoRule result = new PerseoRule();
		result.setName(name);
		result.setText(text);
		result.setAction(action);
		result.setDescription(description);
		return result;
	}

}
