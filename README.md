# KillerMoney 4 (Bukkit plugin)

## Abilities of the plugin
+ Giving or charging a player by either a fix amount of money, or random between a max and minimum amount when they kill an entity
+ Charging the victim of a PVP
+ Fully customisable loot dropping when an entity die
+ Running a command of your choice when an entity die
+ Banning the ability to farm entities for money,if they were spawned by either eggs or spawners
+ Multiworld support for entities
+ Full modularity, the only thing you need to add to the config file is what you need!
+ Customisable messages
+ Permission support by each entity for a perfect rank system
+ Public API

## Commands & Permissions
| Command | Permission | Description |
| ------------- | ------------- | ------------- |
| /kmadmin info | km.admin | Plugin info |
| /kmadmin reload | km.admin | Reload config.yml, entities.yml & lang.yml |
| /kmadmin limit reset | km.admin | Reset money & item limits |
| /kmadmin multiplier <function> [value] | Set a custom multiplier for a given amount of time |
| /km help | | Display command help |
| /km enable-messages <on\|off> | | Enable or disable the kill messages |
|  | km.bypass.moneylimit | Bypass money limit |
|  | km.bypass.itemlimit | Bypass item limit |
|  | km.bypass.commandlimit | Bypass command limit |
|  | km.bypass.cashtransferlimit | Bypass cash transfer limit |
|  | km.money.multiplier.NAME_FROM_CONFIG | Money multiplier |
|  | km.moneylimit.multiplier.NAME_FROM_CONFIG | Money limit multiplier |

## Installing
+ Step 0: If you have either KillerMoney 1.x, 2.x or 3.x installed, delete it with all files and configurations.
+ Step 1: Install VAULT and Economy plugins (for example Essentials, BOSEconomy, iConomy, etc.) if you want use money reward feature.
+ Step 2: Download the latest version of KillerMoney and copy it into your plugins folder.
+ Step 3: Restart your server for the plugin files to generate and for the plugin to load.
+ Step 4: Customise config.yml and entities.yml files to your like and set your language in the lang.yml file.
+ Step 5: Use it and send feedback for future developments

## Configuration Documentation
- [config.yml](https://github.com/diecode/KillerMoney/blob/master/docs/Config.md)
- [entities.yml](https://github.com/diecode/KillerMoney/blob/master/docs/Entities.md)
- [lang.yml](https://github.com/diecode/KillerMoney/blob/master/docs/Lang.md)

## API (WIP)

#### Events
+ KMCashTransferProcessorEvent
+ KMCCommandExecutionEvent
+ KMCItemDropEvent
+ KMEarnMoneyCashTransferDepositEvent
+ KMEarnMoneyDepositEvent
+ KMEarnMoneyPickedUpEvent
+ KMGlobalMultiplierChangeEvent
+ KMLimitReachedEvent
+ KMLoseMoneyCashTransferEvent
+ KMLoseMoneyEvent
+ KMMoneyItemDropEvent
+ KMMoneyProcessorEvent
+ KMSendActionBarMessageEvent
+ KMSendMessageEvent
