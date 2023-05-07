class ListBuscaJobs {

    constructor(elemento) {
        this._elemento = elemento;

    }

    _template(taskGroups) {

        let lista = '';

        taskGroups.map(n => {
            lista += `<li><a href="#" onclick="taskGroupController.carregaJob('${n}')">${n}</a>`;
        });

        //lista += `<li><a href="#" onClick="taskGroupController.gravaForm()">Gravar</a></li>`;

        return lista;

    }

    update(taskGroups) {

        this._elemento.innerHTML = this._template(taskGroups);

    }

}