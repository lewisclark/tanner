package org.doubt.tanner;

import org.osbot.rs07.utility.ConditionalSleep;
import java.util.function.BooleanSupplier;

/*
Credits to Explv for this
https://osbot.org/forum/topic/127193-conditional-sleep-with-lambda-expressions/
*/

public final class Sleep extends ConditionalSleep {
    private final BooleanSupplier condition;

    public Sleep(final BooleanSupplier condition, final int timeout) {
        super(timeout);
        this.condition = condition;
    }

    public Sleep(final BooleanSupplier condition, final int timeout, final int interval) {
        super(timeout, interval);
        this.condition = condition;
    }

    @Override
    public final boolean condition() throws InterruptedException {
        return condition.getAsBoolean();
    }

    public static boolean sleepUntil(final BooleanSupplier condition, final int timeout) {
        return new Sleep(condition, timeout).sleep();
    }

    public static boolean sleepUntil(final BooleanSupplier condition, final int timeout, final int interval) {
        return new Sleep(condition, timeout, interval).sleep();
    }
}