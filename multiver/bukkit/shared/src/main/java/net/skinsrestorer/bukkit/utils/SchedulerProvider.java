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
package net.skinsrestorer.bukkit.utils;

import net.skinsrestorer.shared.provider.FeatureProvider;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.TimeUnit;

public interface SchedulerProvider extends FeatureProvider {
    void runAsync(Server server, Plugin plugin, Runnable runnable);

    void runSync(Server server, Plugin plugin, Runnable runnable);

    void runSyncToEntity(Server server, Plugin plugin, Entity entity, Runnable runnable);

    void runRepeatAsync(Server server, Plugin plugin, Runnable runnable, int delay, int interval, TimeUnit timeUnit);
}
