package org.doubt.tanner;

import java.util.ArrayList;
import java.util.List;

import org.osbot.rs07.script.MethodProvider;

public final class ActionController {
	private List<Action> actions = new ArrayList<>();

	public int onLoop() throws InterruptedException {
		for	(Action action : actions) {
			if (action.shouldExecute()) {
				action.execute();
				break;
			}
		}

		return MethodProvider.random(500, 800);
	}

	public void addAction(Action action) {
		actions.add(action);

		actions.sort((a, b)->a.getPriority().compareTo(b.getPriority()));
	}
}