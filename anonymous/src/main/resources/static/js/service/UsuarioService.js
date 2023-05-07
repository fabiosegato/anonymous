

class UsuarioService {
    
    reset (dado,cb) {
    let xhr = new XMLHttpRequest();
    xhr.open('POST', `/resetPassword`,true);
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
    //console.log(dado);
    //console.log(JSON.stringify(dado));
    xhr.send(JSON.stringify(dado));

}

}
