class Conf {

    constructor(confId, type, desc, command) {
        this.confId = confId.toUpperCase();
        this.type = type.toUpperCase();
        this.desc = desc.toUpperCase();
        this.command = command;
        this.settings = [];

    }

    setSettings(setting) {
        this.settings.push(setting);
    }


}