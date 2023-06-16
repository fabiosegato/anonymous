class TaskGroupView {

    constructor(elemento) {
        this._elemento = elemento;
        document.querySelector('#createTasks').style.display = 'none';
    }

    _template(taskGroup) {


    }

    update(taskGroup) {


    }

    escondeItens() {

        document.querySelector('#formItens').style.display = 'none';
        
        
    }

    esconde() {

        this._elemento.style.display = 'none';
        
     
    }

    mostaTitulo(taskGroup){

        document.querySelector('#taskBanner').innerHTML = taskGroup.taskName;
        document.querySelector('#taskNameSource').value = taskGroup.taskName;
        document.querySelector('#createTasks').style.display = 'block';
        //<a href="#" onClick="taskGroupController.deletaJob(event,'${taskGroup.taskName}')">deletar</a>

    }

    //mostaFormulario(){

		//document.querySelector('#createTasks').show();
        //document.querySelector('#formJob').style.display = 'block';        

    //}

    escondeTitulo(){

        document.querySelector('#taskBanner').innerHTML = '';
        

    }
    
    escondeCloneButton(){

        document.querySelector('#cloneButton').style.display = 'none';        

    }
    
    mostraCloneButton(){

        document.querySelector('#cloneButton').style.display = 'block';        

    }
    
    escondeCloneForm(){

        document.querySelector('#cloneForm').style.display = 'none';        

    }
    
    mostraCloneForm(){

        document.querySelector('#cloneForm').style.display = 'block';        

    }


}