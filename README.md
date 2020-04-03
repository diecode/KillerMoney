# KillerMoney 4 (Bukkit plugin)

## Plugin Features
- Give or charge a player with a fixed or a random (between a min/max) amount of money when they kill an entity
- Full PVP support
- Fully customizable loot drop when an entity dies
- Run a command of your choice when an entity dies
- Ban the ability to farm entities for money if they were spawned with eggs or spawners
- Multiworld entity support
- Full modularity; the only thing you need to add to the config file is what you need!
- Customizable messages
- Permission support for each entity; perfect for a rank system
- Public API

## Installing
*Note: If you have KillerMoney versions 1.x, 2.x or 3.x installed, delete it with all files and configurations.*
1. Install [vault](https://dev.bukkit.org/projects/vault) and a vault supported Economy plugin (for example Essentials, BOSEconomy, iConomy, etc.) if you want use the money reward feature.
2. Download the latest version of [KillerMoney](https://dev.bukkit.org/projects/killermoney) and copy it into your plugins folder.
3. Restart your server to load the plugin and generate the default config files.
4. Customize configuration files to your liking
  - config.yml
  - entities.yml
  - lang.yml
5. From the console, type `kmadmin reload` to reload the configuration files.
6. Send feedback for future developments! :smile:

## Configuration Documentation
- [config.yml](https://github.com/diecode/KillerMoney/blob/master/docs/Config.md)
- [entities.yml](https://github.com/diecode/KillerMoney/blob/master/docs/Entities.md)
- [lang.yml](https://github.com/diecode/KillerMoney/blob/master/docs/Lang.md)

## Commands & Permissions
| Command | Permission | Description |
| ------------- | ------------- | ------------- |
| /kmadmin info | `km.admin` | Plugin info |
| /kmadmin reload | `km.admin` | Reload config.yml, entities.yml & lang.yml |
| /kmadmin limit reset | `km.admin` | Reset money & item limits |
| /kmadmin multiplier <function> [value] |  | Set a custom multiplier for a given amount of time |
| /km help |  | Display command help |
| /km enable-messages <on\|off> |  | Enable or disable the kill messages |
|  | `km.bypass.moneylimit` | Bypass money limit |
|  | `km.bypass.itemlimit` | Bypass item limit |
|  | `km.bypass.commandlimit` | Bypass command limit |
|  | `km.bypass.cashtransferlimit` | Bypass cash transfer limit |
|  | `km.money.multiplier.NAME_FROM_CONFIG` | Money multiplier |
|  | `km.moneylimit.multiplier.NAME_FROM_CONFIG` | Money limit multiplier |

## API (WIP)

#### Events
- KMCashTransferProcessorEvent
- KMCCommandExecutionEvent
- KMCItemDropEvent
- KMEarnMoneyCashTransferDepositEvent
- KMEarnMoneyDepositEvent
- KMEarnMoneyPickedUpEvent
- KMGlobalMultiplierChangeEvent
- KMLimitReachedEvent
- KMLoseMoneyCashTransferEvent
- KMLoseMoneyEvent
- KMMoneyItemDropEvent
- KMMoneyProcessorEvent
- KMSendActionBarMessageEvent
- KMSendMessageEvent
