class TaskGroup {

    constructor(taskName, desc) {
        this.taskName = taskName.toUpperCase();
        this.desc = desc.toUpperCase();
        this.groupItens = [];

    }

    setGroupItem(groupItem) {

        let index = this.groupItens.findIndex(x => x.confId === groupItem.confId);

        if (index == -1) {
            this.groupItens.push(groupItem);
        } else {
            this.groupItens[index] = groupItem;
        }

    }

    removeGroupItem(index) {

        this.groupItens.splice(index, 1);

    }

}