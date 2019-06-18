package org.doubt.tanner;

import org.osbot.rs07.Bot;

public abstract class Action {
	protected Bot bot;
	protected ActionPriority priority;

	public Action(Bot bot, ActionPriority priority) {
		this.bot = bot;
		this.priority = priority;
	}

	public Action(Bot bot) {
		this.bot = bot;
		this.priority = ActionPriority.MEDIUM;
	}

	public abstract boolean shouldExecute();
	public abstract void execute() throws InterruptedException;

	public ActionPriority getPriority() {
		return priority;
	}
}