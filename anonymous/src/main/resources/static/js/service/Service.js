class Service {

    doGet(url,cb) {

        let xhr = new XMLHttpRequest();
        xhr.open('GET', url);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    cb(null, JSON.parse(xhr.responseText));
                } else {
                    cb('Ocorreu um erro', JSON.parse(xhr.responseText));
                }
            }
        }
        xhr.send();

    }

    
    doPost(url,dado,cb) {

        let xhr = new XMLHttpRequest();
        xhr.open('POST', url,true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 201) {
                    cb(null, JSON.parse(xhr.responseText));
                } else {
                    cb(`Não foi possível gravar os dados`, JSON.parse(xhr.responseText));
                }
            }
        }
        console.log(JSON.stringify(dado));
        xhr.send(JSON.stringify(dado));
    }


    doDelete(url,cb) {

        let xhr = new XMLHttpRequest();
        xhr.open('DELETE', url);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    cb(null, `Deletado com sucesso !`);
                } 
            }
        }
    
        xhr.send();

    }
}