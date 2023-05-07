class SettingsView {

    constructor(elemento) {
        this._elemento = elemento;

    }

    _required(required) {

        if (required == '1') {
            return 'required';
        }
        return '';
    }


    _criaInputText(element) {

        let html = '';
        let required = this._required(element.required);

        if(element.value==null){
            element.value='';
        }

        html = `<div>
            <label for="${element.settingName}">${element.label}</label>
            <input type="${element.formType}" placeholder="${element.tip}" id="${element.settingName}" value="${element.value}" class="settings border border-gray-400 block py-2 px-4 w-full rounded focus:outline-none focus:border-orange-500" ${required}> </input>
            </div>`;

        return html;

    }

    _criaSelect(element) {

        let html = '';
        let required = this._required(element.required);

        html = `<div class="form-group col-md-12">
        <label for="${element.settingName}">${element.label}</label>
        <select id="${element.settingName}" size="1" class="settings border border-gray-400 block py-2 px-4 w-full rounded focus:outline-none focus:border-orange-500" ${required}>
        ${element.selectValues.split(';').map(n => {
            return `
            <option value="${n}">${n}</option>
            `
            }).join('')}
        </select>
    </div>`;

        return html;
    }

    _criaNumber(element) {

        let html = '';
        let required = this._required(element.required);

        html = `<div>
            <label for="${element.settingName}">${element.label}</label>
            <input type="number" id="${element.settingName}" value="${element.value}" class="settings border border-gray-400 block py-2 px-4 w-full rounded focus:outline-none focus:border-orange-500" ${required}> </input>
            </div>`;

        return html;

    }

    _template(settings) {

        //console.log(settings);

        let lista = '';
        //let settings = this._carregaTypeSettings(type);

        settings.forEach((element, index) => {

            if (element.formType == 'text') {
                lista += this._criaInputText(element);
            }

            if (element.formType == 'select') {
                lista += this._criaSelect(element);
            }

            if (element.formType == 'number') {
                lista += this._criaNumber(element);
            }

        });

        return lista;

    }

    update(settings) {

        this._elemento.innerHTML = this._template(settings);

    }


    populaSettings(settings) {

        console.log(settings)

        settings.forEach((element, index) => {

            let id = '#' + element.settingName;
            let elemento = $(id);

            console.log(`${id} ${element.value}`)

            elemento[0].value = element.value;

        });

    }
}