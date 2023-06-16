

class TaskGroupService {

    obtemTypeList(cb) {

        let xhr = new XMLHttpRequest();
        xhr.open('GET', `/metadata/types`);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    cb(null, JSON.parse(xhr.responseText));
                } else {
                    cb('Não foi possível obter a lista de TYPES', null);
                }
            }
        }
        xhr.send();

    }

    obtemSettings(type,cb) {

        let xhr = new XMLHttpRequest();
        xhr.open('GET', `/metadata/settings/${type}`);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    cb(null, JSON.parse(xhr.responseText));
                } else {
                    cb(`Não foi possível obter os settigns do TYPE ${type}`, null);
                }
            }
        }
        xhr.send();

    }

    buscaJobs(job,cb) {

        let xhr = new XMLHttpRequest();
        xhr.open('GET', `/taskgroup/taskName/${job}`);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    cb(null, JSON.parse(xhr.responseText));
                } 
                else{
                    cb(xhr.status,null);
                }

            }
        }
        //xhr.setRequestHeader('authorization','Bearer ' + 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgYW5vbnltb3VzIiwic3ViIjoiZmFiaW8iLCJpYXQiOjE1NzkyODIyOTcsImV4cCI6MTU3OTM2ODY5N30.aFryxdSPgeviaIePwlNdoAjPsXu5kz3Nt_gIF1SK_bg');
        xhr.send();

    }

    carregaJob(job,cb) {

        let xhr = new XMLHttpRequest();
        xhr.open('GET', `/taskgroup/${job}`);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    cb(null, JSON.parse(xhr.responseText));
                } 
            }
        }
        xhr.send();

    }

    grava(dado,cb) {

        let xhr = new XMLHttpRequest();
        xhr.open('POST', `/taskgroup`,true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 201) {
                    cb(null, JSON.parse(xhr.responseText));
                } else {
                    cb(`Não foi possível gravar os dados`, null);
                }
            }
        }
        console.log(JSON.stringify(dado));
        xhr.send(JSON.stringify(dado));

    }
    
    cloneProcess(source,target,cb) {

        let xhr = new XMLHttpRequest();
        console.log(`/taskgroup/taskgroupClone?taskGroup=${source}&taskGroupNew=${target}`);
        xhr.open('POST', `/taskgroup/taskgroupClone?taskGroup=${source}&taskGroupNew=${target}`,true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 201) {
                    cb(null, JSON.parse(xhr.responseText));
                } else {
                    cb(JSON.parse(xhr.responseText), null);
                }
            }
        }
        
        xhr.send();

    }

    deletaItem(item,cb) {

        let xhr = new XMLHttpRequest();
        xhr.open('DELETE', `/taskgroupitem/${item}`);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    cb(null, `Task ${item} deletada com sucesso !`);
                } 
            }
        }
    
        xhr.send();

    }

    deletaJob(job,cb) {

        let xhr = new XMLHttpRequest();
        xhr.open('DELETE', `/taskgroup/${job}`);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    cb(null, `Job ${job} deletada com sucesso !`);
                } 
            }
        }
    
        xhr.send();

    }
}