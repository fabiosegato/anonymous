class TypesView {

    constructor(elemento) {
        this._elemento = elemento;
    }

    _template(types) {

        let lista = '';

        types.map(n => {
            lista += `<a class="border border-black inline-flex items-center justify-center p-2 font-medium text-xs text-gray-500 rounded-lg hover:text-gray-900 hover:bg-gray-100 dark:text-gray-400 dark:bg-gray-800 dark:hover:bg-gray-700 dark:hover:text-white" href="#" onClick="taskGroupController.exibeForm(event,'${n}',[],'tasktype')">${n}</a>`;
        })

        return lista;

    }

    update(types) {

        this._elemento.innerHTML = this._template(types);

    }


}