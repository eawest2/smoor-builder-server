package com.smoorbuilderserver.utils.serializers;

import java.io.Serializable;
import java.util.List;

import com.smoorbuilderserver.model.CombatActionDescription;

public class CombatActionDescriptionSerilaizer implements Serializable {
    
	private List<CombatActionDescription> combatActionDescription;

    public void Actions() {}

	public List<CombatActionDescription> getCombatActionDescription() {
		return combatActionDescription;
	}

	public void setCombatActionDescription(List<CombatActionDescription> combatActionDescription) {
		this.combatActionDescription = combatActionDescription;
	}
}