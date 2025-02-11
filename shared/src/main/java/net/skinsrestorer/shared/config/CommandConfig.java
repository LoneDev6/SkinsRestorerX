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
package net.skinsrestorer.shared.config;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
import ch.jalu.configme.properties.Property;

import java.util.List;

import static ch.jalu.configme.properties.PropertyInitializer.newListProperty;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class CommandConfig implements SettingsHolder {

    @Comment({
            "For all player commands to work by default, you need to give players the permission 'skinsrestorer.player'.",
            "This option allows you to force the default permission (skinsrestorer.player) to be given to all players if the value is not set explicitly.",
            "A value of 'false' will disable this behaviour, and players will need to be given the permission explicitly.",
    })
    public static final Property<Boolean> FORCE_DEFAULT_PERMISSIONS = newProperty("commands.forceDefaultPermissions", true);
    @Comment({
            "Players cooldown in seconds when changing skins (set to 0 to disable).",
            "SkinErrorCooldown is used when an error or invalid url occurs.",
            "Can be bypassed with 'skinsrestorer.bypasscooldown'."
    })
    public static final Property<Integer> SKIN_CHANGE_COOLDOWN = newProperty("commands.skinChangeCooldown", 30);

    public static final Property<Integer> SKIN_ERROR_COOLDOWN = newProperty("commands.skinErrorCooldown", 5);
    public static final Property<Boolean> RESTRICT_SKIN_URLS_ENABLED = newProperty("commands.restrictSkinUrls.enabled", false);
    @SuppressWarnings("HttpUrlsUsage")
    public static final Property<List<String>> RESTRICT_SKIN_URLS_LIST = newListProperty("commands.restrictSkinUrls.list",
            "https://i.imgur.com",
            "http://i.imgur.com",
            "https://storage.googleapis.com",
            "http://storage.googleapis.com",
            "https://cdn.discordapp.com",
            "http://cdn.discordapp.com",
            "https://textures.minecraft.net",
            "http://textures.minecraft.net"
    );
    public static final Property<Boolean> DISABLED_SKINS_ENABLED = newProperty("commands.disabledSkins.enabled", false);
    public static final Property<List<String>> DISABLED_SKINS = newListProperty("commands.disabledSkins.list", "steve", "owner");
    @Comment({
            "Allows the usage of per-skin permission.",
            "Example: skinsrestorer.skin.xknat OR skinsrestorer.skin.Pistonmaster",
            "with \"skinsrestorer.ownskin\" players can run /skin set %playerusername%.",
            "[!] Only enable if you have set up permissions properly and know what you are doing."
    })
    public static final Property<Boolean> PER_SKIN_PERMISSIONS = newProperty("commands.perSkinPermissions", false);
    @Comment({
            "Removes < > and [ ] encasing from command arguments.",
            "Example: /skin set <skin> will become /skin set skin if this is enabled.",
            "This is useful to prevent players from incorrectly using the command, as those brackets are not supposed to be there.",
            "This will also send a message to the player that they incorrectly use the command, but the command will still run fixed arguments."
    })
    public static final Property<Boolean> REMOVE_BRACKETS = newProperty("commands.removeBrackets", true);
    @Comment({
            "Override the automatically generated translated help message with a custom one.",
            "This is useful if you want to have a custom help message for your server.",
            "This only affects the base help message when running /skin with no parameters, not the error/subcommand help messages."
    })
    public static final Property<Boolean> CUSTOM_HELP_ENABLED = newProperty("commands.customHelp.enabled", false);
    @Comment({
            "The custom help message to send to the player when running /skin with no parameters."
    })
    public static final Property<List<String>> CUSTOM_HELP_MESSAGE = newListProperty("commands.customHelp.message",
            "<yellow>Skin plugin Help",
            "<gray>---------------------",
            "<gray>/skin set <skin> - <yellow>Set your skin"
    );
    @Comment({
            "<!! Warning !!>",
            "This option will disable the /skin command from being registered on the server.",
            "Do not disable this unless you are overriding the /skin command with a different plugin or you don't want the skin command.",
            "Requires a server restart to take effect."
    })
    public static final Property<Boolean> DISABLE_SKIN_COMMAND = newProperty("commands.disableSkinCommand", false);
    @Comment({
            "<!! Warning !!>",
            "This option will disable the /skins command from being registered on the server.",
            "Do not disable this unless you are overriding the /skins command with a different plugin or you don't want the GUI command.",
            "Requires a server restart to take effect."
    })
    public static final Property<Boolean> DISABLE_GUI_COMMAND = newProperty("commands.disableGUICommand", false);

    @Override
    public void registerComments(CommentsConfiguration conf) {
        conf.setComment("commands",
                "\n",
                "\n############",
                "\n# Commands #",
                "\n############",
                "\n",
                "Control behaviour of commands."
        );
        conf.setComment("commands.disabledSkins",
                "Skins in this list will be disabled, so users can't set them.",
                "Can be bypassed with 'skinsrestorer.bypassdisabled'."
        );
        conf.setComment("commands.restrictSkinUrls",
                "When enabled, only websites from the list below is allowed to be set using /skin url <url>",
                "[?] this is useful if you host your own image server."
        );
    }
}
