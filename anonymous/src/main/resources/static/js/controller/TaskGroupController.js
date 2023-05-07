class TaskGroupController {

    taskGroup;

    constructor() {
        this.taskGroup;
        this.groupItensView = new GroupItensView(document.querySelector('#groupItensView'));
        this.taskGroupView = new TaskGroupView(document.querySelector('#formJob'));
        this.listBuscaJobs = new ListBuscaJobs(document.querySelector('#listaPesquisaJobs'));
        this.taskGroupView.escondeItens();
        this.settingsView = new SettingsView(document.querySelector('#settingsView'));
        this.typesView = new TypesView(document.querySelector('#typesView'));
        this._mensagem = new Mensagem();
        this._mensagemView = new MensagemView(document.querySelector('#mensagemView'));
        this.inputConfId = $('#confId'); //document.querySelector('.groupItens');
        this.inputTaskOrder = $('#taskOrder');
        this.inputFlagExec = $('#flagExec');
        this.inputJobUpdt = $('#jobUpdt');
        this.inputTaskType = $('#taskType');
        this.inputTaskDesc = $('#taskDesc');
        this.inputCommand = $('#command');
        this.bannerType = $('#taskBannerType');
    }

    _gravaForm() {

        let service = new TaskGroupService();

        service.grava(this.taskGroup, (erro, types) => {
            if (erro) {
                //this._mensagem.texto = erro;
                //this._mensagemView.update(this._mensagem);
                //return;
            	function alerta()
                {
                    alert("Sua sessão expirou!");
                }
                    alerta();
                    window.location.reload();
            }
            //this._mensagem.texto = 'Dados gravados com sucesso!';
            //this._mensagemView.update(this._mensagem);
        });

    }
    
    _deleteSettings(confId,key) {

        let service = new SettingsService();

        service.deletaItem(confId,key, (erro, types) => {
            if (erro) {
                this._mensagem.texto = erro;
                this._mensagemView.update(this._mensagem);
                return;
            }
            //this._mensagem.texto = 'Dados gravados com sucesso!';
            //this._mensagemView.update(this._mensagem);
        });

    }


    _carregaTaskTypes() {

        let service = new TaskGroupService();

        service.obtemTypeList((erro, types) => {
            if (erro) {
                this._mensagem.texto = erro;
                this._mensagemView.update(this._mensagem);
                return;
            }
            this.typesView.update(types);
        });


    }

    _deletaItem(item, index) {

        let service = new TaskGroupService();
        service.deletaItem(item.confId, (erro, settings) => {
            if (erro) {
                this._mensagem.texto = erro;
                this._mensagemView.update(this._mensagem);
                return;
            }
            this.taskGroup.removeGroupItem(index);
            this.groupItensView.update(this.taskGroup.groupItens);
            this.settingsView.update([]);
            this.taskGroupView.escondeItens();

        });
    }

    deletaJob(event, job) {
        event.preventDefault();
        bootbox.confirm({
            message: `Deseja excluir o job ${job}`,
            buttons: {
                confirm: {
                    label: 'Yes',
                    className: 'btn-success'
                },
                cancel: {
                    label: 'No',
                    className: 'btn-danger'
                }
            },
            callback: function (result) {
                if (result) {
                    let service = new TaskGroupService();
                    service.deletaJob(job, (erro, settings) => {
                        if (erro) {
                            this._mensagem.texto = erro;
                            this._mensagemView.update(this._mensagem);
                            return;
                        }
                        location.reload();
                    });
                }
                //console.log(result);
            }
        });
    }

    _montaForm(type, p_settings) {

        let service = new TaskGroupService();
        service.obtemSettings(type, (erro, settings) => {
            if (erro) {
                this._mensagem.texto = erro;
                return;
            }

            this.settingsView.update(settings);
            this.settingsView.populaSettings(p_settings);

        });
    }

    buscaJobs(job) {

        let service = new TaskGroupService();

        service.buscaJobs(job, (erro, taskGroup) => {
            if (erro) {
                this._mensagem.texto = erro;
                this._mensagemView.update(this._mensagem);
                return;
            }

            if (taskGroup == null) {
                taskGroup = [];

            }

            this.listBuscaJobs.update(taskGroup);
            

        });
    }

    carregaJob(job) {

        let service = new TaskGroupService();

        service.carregaJob(job, (erro, taskGroup) => {
            if (erro) {
                this._mensagem.texto = erro;
                return;
            }

            //console.log(taskGroup);

            let inputTaskName = document.querySelector('#taskName');
            let inputDesc = document.querySelector('#desc');

            inputTaskName.value = taskGroup.taskName;
            inputDesc.value = taskGroup.desc;

            this.taskGroup = new TaskGroup(inputTaskName.value, inputDesc.value);

            taskGroup.groupItens.map(n => {
                this.taskGroup.setGroupItem(n);
            });

            //console.log(this.taskGroup);

            this.taskGroupView.mostaTitulo(this.taskGroup);
            this.taskGroupView.esconde();
            this.taskGroupView.update();

            this._carregaTaskTypes();
            this.groupItensView.update(this.taskGroup.groupItens);

        });
    }

    adiciona(event) {

        event.preventDefault();
        let inputTaskName = document.querySelector('#taskName');
        let inputDesc = document.querySelector('#desc');
        this.taskGroup = new TaskGroup(inputTaskName.value, inputDesc.value);

        this.taskGroupView.mostaTitulo(this.taskGroup);

        this._carregaTaskTypes();
        this.taskGroupView.esconde();
        this.taskGroupView.update();
        this._gravaForm();

    }

    exibeForm(event, type, p_settings, p_origem) {
        event.preventDefault();

        if (p_origem == "tasktype") {
            this.bannerType[0].innerHTML = type;
            this.limpaForm();
        }

        $("#formItens").show();

        this.inputTaskType[0].value = type;
        this._montaForm(type, p_settings);


    }

    limpaForm() {
        this.inputConfId[0].value = '';
        this.inputTaskDesc[0].value = '';
        this.inputTaskOrder[0].value = '';
        this.inputFlagExec[0].value = '';
        this.inputJobUpdt[0].value = '';
        this.inputTaskType[0].value = '';
        this.inputCommand[0].value = '';
        this.inputConfId[0].focus();
    }

    adicionaItem(event) {
        event.preventDefault();
        
        let inputSettings = $('.settings');
        let groupItens = new GrouItens(this.inputConfId[0].value, this.taskGroup.taskName, this.inputTaskOrder[0].value, this.inputFlagExec[0].value, this.inputJobUpdt[0].value);
        let conf = new Conf(this.inputConfId[0].value, this.inputTaskType[0].value, this.inputTaskDesc[0].value, this.inputCommand[0].value);

        Object.values(inputSettings).forEach(item => {
            //console.log(typeof(item));
            if (item.id != undefined && item.value != '') {

                let setting = new Settings(this.inputConfId[0].value, item.id, item.value);
                conf.setSettings(setting);
            }
            
            if (item.value == '') {            	
            	//console.log("entrou aqui settings");
                //console.log(item.id);
                this._deleteSettings(this.inputConfId[0].value,item.id);
            }

        });        
        
        //Object.values(settingDelete).forEach(item => {
            //console.log(typeof(item));
        	
        //});

        groupItens.setConf(conf);
        this.taskGroup.setGroupItem(groupItens);
        //console.log(JSON.stringify(this.taskGroup));

        this._gravaForm();
        this.groupItensView.update(this.taskGroup.groupItens);
        //$("#formItens").show();
        this.taskGroupView.escondeItens();
        this.settingsView.update([]);

    }

    deletaTask(event, groupItens, index) {
        event.preventDefault();
        this._deletaItem(groupItens, index);

    }

    cancela(event) {
        event.preventDefault();
        this.taskGroupView.escondeItens();
        this.settingsView.update([]);
        this.groupItensView.update(this.taskGroup.groupItens);
    }

    populaForm(event, groupItens) {
        event.preventDefault();
        this.groupItensView.populaGroupItens(groupItens);
        this.exibeForm(event, groupItens.conf.type, groupItens.conf.settings);
        this.inputConfId[0].focus();
    }

    cloneTaskGroup(event) {
        event.preventDefault();
        console.log(this.taskGroup.groupItens);
    }
}   
    