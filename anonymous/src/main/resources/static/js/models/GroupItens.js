class GrouItens {

      constructor(confId, taskGroup, taskOrder, flagExec, updateTabParameter) {

        this.confId = confId.toUpperCase();
        this.taskGroup = taskGroup.toUpperCase();
        this.taskOrder = taskOrder;
        this.flagExec = flagExec.toUpperCase();
        this.updateTabParameter = updateTabParameter.toUpperCase();
        this.conf;

    }

    setConf(conf) {
        this.conf = conf;
    }

}