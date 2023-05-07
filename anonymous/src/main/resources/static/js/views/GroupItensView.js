class GroupItensView {

    constructor(elemento) {
        this._elemento = elemento;
        this.inputConfId = $('#confId'); //document.querySelector('.groupItens');
        this.inputTaskOrder = $('#taskOrder');
        this.inputFlagExec = $('#flagExec');
        this.inputJobUpdt = $('#jobUpdt');
        this.inputTaskType = $('#taskType');
        this.inputTaskDesc = $('#taskDesc');
        this.inputCommand = $('#command');
        this.bannerType = $('#taskBannerType');
        
    }

    esconde() {
        this._elemento.style.display = "none";
        
    }

    _template(groupItens) {

        groupItens.sort(SortObject.dynamicSort('taskOrder','number'));

        let lista = '';

        groupItens.forEach((element, index) => {

            let td_class = '';

            if(element.flagExec == 'I'){
                td_class = 'bg-red-400';
            } else {
				td_class = 'bg-white';
			}

            lista += `
            <tr class="${td_class} border-b dark:bg-gray-800 dark:border-gray-700" >
            <td class="px-6 py-4"><a href="#" onClick="taskGroupController.populaForm(event,taskGroupController.taskGroup.groupItens[${index}])">${element.confId}</a></td>
            <td class="px-6 py-4">${element.conf.type}</td>
            <td class="px-6 py-4">${element.taskOrder}</td>
            <td class="px-6 py-4">${element.flagExec}</td>
            <td class="px-6 py-4"><a href="#" onClick="taskGroupController.deletaTask(event,taskGroupController.taskGroup.groupItens[${index}],${index})">
            <i class="gg-trash"></i></a></td>
            </tr>
            `;
        
        });

        //lista += `<li><a href="#" onClick="taskGroupController.gravaForm()">Gravar</a></li>`;

        return lista;

    }

    update(groupItens) {

        this.inputConfId[0].value = '';
        this.inputTaskDesc[0].value = '';
        this.inputTaskOrder[0].value = '';
        this.inputFlagExec[0].value = '';
        this.inputJobUpdt[0].value = '';
        this.inputTaskType[0].value = '';
        this.inputCommand[0].value = '';
        this.inputConfId[0].focus();
        this._elemento.innerHTML = this._template(groupItens);

    }

    populaGroupItens(groupItens) {

        this.inputConfId[0].value = groupItens.confId;
        this.inputTaskDesc[0].value = groupItens.conf.desc;
        this.inputTaskOrder[0].value = groupItens.taskOrder;
        this.inputFlagExec[0].value = groupItens.flagExec;
        this.inputJobUpdt[0].value = groupItens.updateTabParameter;
        this.inputTaskType[0].value = groupItens.conf.type;
        this.bannerType[0].innerHTML = groupItens.conf.type;
        this.inputCommand[0].value = groupItens.conf.command;

    }
}