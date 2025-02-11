/*
 * SkinsRestorer
 *
 * Copyright (C) 2023 SkinsRestorer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */
package net.skinsrestorer.sponge.listeners;

import lombok.RequiredArgsConstructor;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.lifecycle.ConstructPluginEvent;

@RequiredArgsConstructor
public class ForceAliveListener implements EventListener<ConstructPluginEvent> {
    @SuppressWarnings("unused")
    private final Object object; // Object to keep alive

    @Override
    public void handle(ConstructPluginEvent event) {
        // Ignore this event. We only need the field above to be alive.
        // This is required, so we can store an eventbus listener without causing a memory leak.
    }
}
